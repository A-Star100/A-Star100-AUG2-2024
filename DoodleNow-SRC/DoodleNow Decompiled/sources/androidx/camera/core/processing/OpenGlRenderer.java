package androidx.camera.core.processing;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.Logger;
import androidx.camera.core.processing.AutoValue_OpenGlRenderer_GraphicDeviceInfo;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
import androidx.work.Data;
import com.revenuecat.purchases.common.Constants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class OpenGlRenderer {
    private static final String DEFAULT_FRAGMENT_SHADER = String.format(Locale.US, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 %s;\nuniform samplerExternalOES %s;\nvoid main() {\n    gl_FragColor = texture2D(%s, %s);\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE, VAR_TEXTURE, VAR_TEXTURE_COORD});
    private static final String DEFAULT_VERTEX_SHADER = String.format(Locale.US, "uniform mat4 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 %s;\nvoid main() {\n    gl_Position = aPosition;\n    %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
    private static final int EGL_GL_COLORSPACE_BT2020_HLG_EXT = 13632;
    private static final int EGL_GL_COLORSPACE_KHR = 12445;
    private static final int[] EMPTY_ATTRIBS = {12344};
    private static final String HDR_FRAGMENT_SHADER = String.format(Locale.US, "#version 300 es\n#extension GL_OES_EGL_image_external : require\n#extension GL_EXT_YUV_target : require\nprecision mediump float;\nuniform __samplerExternal2DY2YEXT %s;\nin vec2 %s;\nout vec4 outColor;\n\nvec3 yuvToRgb(vec3 yuv) {\n  const vec3 yuvOffset = vec3(0.0625, 0.5, 0.5);\n  const mat3 yuvToRgbColorTransform = mat3(\n    1.1689f, 1.1689f, 1.1689f,\n    0.0000f, -0.1881f, 2.1502f,\n    1.6853f, -0.6530f, 0.0000f\n  );\n  return clamp(yuvToRgbColorTransform * (yuv - yuvOffset), 0.0, 1.0);\n}\n\nvoid main() {\n  vec3 srcYuv = texture(%s, %s).xyz;\n  outColor = vec4(yuvToRgb(srcYuv), 1.0);\n}", new Object[]{VAR_TEXTURE, VAR_TEXTURE_COORD, VAR_TEXTURE, VAR_TEXTURE_COORD});
    private static final String HDR_VERTEX_SHADER = String.format(Locale.US, "#version 300 es\nin vec4 aPosition;\nin vec4 aTextureCoord;\nuniform mat4 uTexMatrix;\nout vec2 %s;\nvoid main() {\n  gl_Position = aPosition;\n  %s = (uTexMatrix * aTextureCoord).xy;\n}\n", new Object[]{VAR_TEXTURE_COORD, VAR_TEXTURE_COORD});
    private static final int[] HLG_SURFACE_ATTRIBS = {EGL_GL_COLORSPACE_KHR, EGL_GL_COLORSPACE_BT2020_HLG_EXT, 12344};
    private static final OutputSurface NO_OUTPUT_SURFACE = OutputSurface.of(EGL14.EGL_NO_SURFACE, 0, 0);
    private static final int PIXEL_STRIDE = 4;
    private static final int SIZEOF_FLOAT = 4;
    private static final String TAG = "OpenGlRenderer";
    private static final FloatBuffer TEX_BUF;
    private static final float[] TEX_COORDS;
    private static final String VAR_TEXTURE = "sTexture";
    private static final String VAR_TEXTURE_COORD = "vTextureCoord";
    public static final String VERSION_UNKNOWN = "0.0";
    private static final FloatBuffer VERTEX_BUF;
    private static final float[] VERTEX_COORDS;
    private Surface mCurrentSurface;
    private EGLConfig mEglConfig;
    private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
    private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;
    private int mExternalTextureId = -1;
    private Thread mGlThread;
    private final AtomicBoolean mInitialized = new AtomicBoolean(false);
    final Map<Surface, OutputSurface> mOutputSurfaceMap = new HashMap();
    private int mPositionLoc = -1;
    private int mProgramHandle = -1;
    private int[] mSurfaceAttrib = EMPTY_ATTRIBS;
    private EGLSurface mTempSurface = EGL14.EGL_NO_SURFACE;
    private int mTexCoordLoc = -1;
    private int mTexMatrixLoc = -1;

    static {
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        VERTEX_COORDS = fArr;
        VERTEX_BUF = createFloatBuffer(fArr);
        float[] fArr2 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        TEX_COORDS = fArr2;
        TEX_BUF = createFloatBuffer(fArr2);
    }

    public GraphicDeviceInfo init(DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        checkInitializedOrThrow(false);
        GraphicDeviceInfo.Builder builder = GraphicDeviceInfo.builder();
        try {
            if (dynamicRange.is10BitHdr()) {
                Pair<String, String> extensionsBeforeInitialized = getExtensionsBeforeInitialized(dynamicRange);
                String str = (String) Preconditions.checkNotNull((String) extensionsBeforeInitialized.first);
                String str2 = (String) Preconditions.checkNotNull((String) extensionsBeforeInitialized.second);
                if (!str.contains("GL_EXT_YUV_target")) {
                    Logger.w(TAG, "Device does not support GL_EXT_YUV_target. Fallback to SDR.");
                    dynamicRange = DynamicRange.SDR;
                }
                this.mSurfaceAttrib = chooseSurfaceAttrib(str2, dynamicRange);
                builder.setGlExtensions(str);
                builder.setEglExtensions(str2);
            }
            createEglContext(dynamicRange, builder);
            createTempSurface();
            makeCurrent(this.mTempSurface);
            builder.setGlVersion(getGlVersionNumber());
            createProgram(dynamicRange, shaderProvider);
            loadLocations();
            createTexture();
            useAndConfigureProgram();
            this.mGlThread = Thread.currentThread();
            this.mInitialized.set(true);
            return builder.build();
        } catch (IllegalArgumentException | IllegalStateException e) {
            releaseInternal();
            throw e;
        }
    }

    public void release() {
        if (this.mInitialized.getAndSet(false)) {
            checkGlThreadOrThrow();
            releaseInternal();
        }
    }

    public void registerOutputSurface(Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        if (!this.mOutputSurfaceMap.containsKey(surface)) {
            this.mOutputSurfaceMap.put(surface, NO_OUTPUT_SURFACE);
        }
    }

    public void unregisterOutputSurface(Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        removeOutputSurfaceInternal(surface, true);
    }

    public int getTextureName() {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        return this.mExternalTextureId;
    }

    public void render(long j, float[] fArr, Surface surface) {
        checkInitializedOrThrow(true);
        checkGlThreadOrThrow();
        OutputSurface outSurfaceOrThrow = getOutSurfaceOrThrow(surface);
        if (outSurfaceOrThrow == NO_OUTPUT_SURFACE) {
            outSurfaceOrThrow = createOutputSurfaceInternal(surface);
            if (outSurfaceOrThrow != null) {
                this.mOutputSurfaceMap.put(surface, outSurfaceOrThrow);
            } else {
                return;
            }
        }
        if (surface != this.mCurrentSurface) {
            makeCurrent(outSurfaceOrThrow.getEglSurface());
            this.mCurrentSurface = surface;
            GLES20.glViewport(0, 0, outSurfaceOrThrow.getWidth(), outSurfaceOrThrow.getHeight());
            GLES20.glScissor(0, 0, outSurfaceOrThrow.getWidth(), outSurfaceOrThrow.getHeight());
        }
        GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, fArr, 0);
        checkGlErrorOrThrow("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        checkGlErrorOrThrow("glDrawArrays");
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, outSurfaceOrThrow.getEglSurface(), j);
        if (!EGL14.eglSwapBuffers(this.mEglDisplay, outSurfaceOrThrow.getEglSurface())) {
            Logger.w(TAG, "Failed to swap buffers with EGL error: 0x" + Integer.toHexString(EGL14.eglGetError()));
            removeOutputSurfaceInternal(surface, false);
        }
    }

    public Bitmap snapshot(Size size, float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(size.getWidth() * size.getHeight() * 4);
        snapshot(allocateDirect, size, fArr);
        Bitmap createBitmap = Bitmap.createBitmap(size.getWidth(), size.getHeight(), Bitmap.Config.ARGB_8888);
        allocateDirect.rewind();
        ImageProcessingUtil.copyByteBufferToBitmap(createBitmap, allocateDirect, size.getWidth() * 4);
        return createBitmap;
    }

    private void snapshot(ByteBuffer byteBuffer, Size size, float[] fArr) {
        Preconditions.checkArgument(byteBuffer.capacity() == (size.getWidth() * size.getHeight()) * 4, "ByteBuffer capacity is not equal to width * height * 4.");
        Preconditions.checkArgument(byteBuffer.isDirect(), "ByteBuffer is not direct.");
        int generateTexture = generateTexture();
        GLES20.glActiveTexture(33985);
        checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(3553, generateTexture);
        checkGlErrorOrThrow("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6407, size.getWidth(), size.getHeight(), 0, 6407, 5121, (Buffer) null);
        checkGlErrorOrThrow("glTexImage2D");
        GLES20.glTexParameteri(3553, Data.MAX_DATA_BYTES, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        int generateFbo = generateFbo();
        GLES20.glBindFramebuffer(36160, generateFbo);
        checkGlErrorOrThrow("glBindFramebuffer");
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, generateTexture, 0);
        checkGlErrorOrThrow("glFramebufferTexture2D");
        GLES20.glActiveTexture(33984);
        checkGlErrorOrThrow("glActiveTexture");
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        checkGlErrorOrThrow("glBindTexture");
        this.mCurrentSurface = null;
        GLES20.glViewport(0, 0, size.getWidth(), size.getHeight());
        GLES20.glScissor(0, 0, size.getWidth(), size.getHeight());
        GLES20.glUniformMatrix4fv(this.mTexMatrixLoc, 1, false, fArr, 0);
        checkGlErrorOrThrow("glUniformMatrix4fv");
        GLES20.glDrawArrays(5, 0, 4);
        checkGlErrorOrThrow("glDrawArrays");
        GLES20.glReadPixels(0, 0, size.getWidth(), size.getHeight(), 6408, 5121, byteBuffer);
        checkGlErrorOrThrow("glReadPixels");
        GLES20.glBindFramebuffer(36160, 0);
        deleteTexture(generateTexture);
        deleteFbo(generateFbo);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mExternalTextureId);
    }

    private Pair<String, String> getExtensionsBeforeInitialized(DynamicRange dynamicRange) {
        checkInitializedOrThrow(false);
        try {
            createEglContext(dynamicRange, (GraphicDeviceInfo.Builder) null);
            createTempSurface();
            makeCurrent(this.mTempSurface);
            String glGetString = GLES20.glGetString(7939);
            String eglQueryString = EGL14.eglQueryString(this.mEglDisplay, 12373);
            if (glGetString == null) {
                glGetString = "";
            }
            if (eglQueryString == null) {
                eglQueryString = "";
            }
            return new Pair<>(glGetString, eglQueryString);
        } catch (IllegalStateException e) {
            Logger.w(TAG, "Failed to get GL or EGL extensions: " + e.getMessage(), e);
            return new Pair<>("", "");
        } finally {
            releaseInternal();
        }
    }

    private static String getGlVersionNumber() {
        Matcher matcher = Pattern.compile("OpenGL ES ([0-9]+)\\.([0-9]+).*").matcher(GLES20.glGetString(7938));
        if (!matcher.find()) {
            return VERSION_UNKNOWN;
        }
        return ((String) Preconditions.checkNotNull(matcher.group(1))) + "." + ((String) Preconditions.checkNotNull(matcher.group(2)));
    }

    private static int[] chooseSurfaceAttrib(String str, DynamicRange dynamicRange) {
        int[] iArr = EMPTY_ATTRIBS;
        if (dynamicRange.getEncoding() != 3) {
            return iArr;
        }
        if (str.contains("EGL_EXT_gl_colorspace_bt2020_hlg")) {
            return HLG_SURFACE_ATTRIBS;
        }
        Logger.w(TAG, "Dynamic range uses HLG encoding, but device does not support EGL_EXT_gl_colorspace_bt2020_hlg.Fallback to default colorspace.");
        return iArr;
    }

    private static int generateFbo() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        checkGlErrorOrThrow("glGenFramebuffers");
        return iArr[0];
    }

    private static int generateTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlErrorOrThrow("glGenTextures");
        return iArr[0];
    }

    private static void deleteTexture(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        checkGlErrorOrThrow("glDeleteTextures");
    }

    private static void deleteFbo(int i) {
        GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
        checkGlErrorOrThrow("glDeleteFramebuffers");
    }

    private void createEglContext(DynamicRange dynamicRange, GraphicDeviceInfo.Builder builder) {
        GraphicDeviceInfo.Builder builder2 = builder;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEglDisplay = eglGetDisplay;
        if (!Objects.equals(eglGetDisplay, EGL14.EGL_NO_DISPLAY)) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.mEglDisplay, iArr, 0, iArr, 1)) {
                if (builder2 != null) {
                    builder2.setEglVersion(iArr[0] + "." + iArr[1]);
                }
                int i = dynamicRange.is10BitHdr() ? 10 : 8;
                int i2 = 3;
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12324, i, 12323, i, 12322, i, 12321, dynamicRange.is10BitHdr() ? 2 : 8, 12325, 0, 12326, 0, 12352, dynamicRange.is10BitHdr() ? 64 : 4, 12610, dynamicRange.is10BitHdr() ? -1 : 1, 12339, 5, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    int[] iArr2 = new int[3];
                    iArr2[0] = 12440;
                    if (!dynamicRange.is10BitHdr()) {
                        i2 = 2;
                    }
                    iArr2[1] = i2;
                    iArr2[2] = 12344;
                    EGLContext eglCreateContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, iArr2, 0);
                    checkEglErrorOrThrow("eglCreateContext");
                    this.mEglConfig = eGLConfig;
                    this.mEglContext = eglCreateContext;
                    int[] iArr3 = new int[1];
                    EGL14.eglQueryContext(this.mEglDisplay, eglCreateContext, 12440, iArr3, 0);
                    Log.d(TAG, "EGLContext created, client version " + iArr3[0]);
                    return;
                }
                throw new IllegalStateException("Unable to find a suitable EGLConfig");
            }
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            throw new IllegalStateException("Unable to initialize EGL14");
        }
        throw new IllegalStateException("Unable to get EGL14 display");
    }

    private void createTempSurface() {
        this.mTempSurface = createPBufferSurface(this.mEglDisplay, (EGLConfig) Objects.requireNonNull(this.mEglConfig), 1, 1);
    }

    private void makeCurrent(EGLSurface eGLSurface) {
        Preconditions.checkNotNull(this.mEglDisplay);
        Preconditions.checkNotNull(this.mEglContext);
        if (!EGL14.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            throw new IllegalStateException("eglMakeCurrent failed");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void createProgram(androidx.camera.core.DynamicRange r9, androidx.camera.core.processing.ShaderProvider r10) {
        /*
            r8 = this;
            java.lang.String r0 = "glAttachShader"
            java.lang.String r1 = "Could not link program: "
            r2 = -1
            boolean r3 = r9.is10BitHdr()     // Catch:{ IllegalStateException -> 0x0072, IllegalArgumentException -> 0x0070 }
            if (r3 == 0) goto L_0x000e
            java.lang.String r3 = HDR_VERTEX_SHADER     // Catch:{ IllegalStateException -> 0x0072, IllegalArgumentException -> 0x0070 }
            goto L_0x0010
        L_0x000e:
            java.lang.String r3 = DEFAULT_VERTEX_SHADER     // Catch:{ IllegalStateException -> 0x0072, IllegalArgumentException -> 0x0070 }
        L_0x0010:
            r4 = 35633(0x8b31, float:4.9932E-41)
            int r3 = loadShader(r4, r3)     // Catch:{ IllegalStateException -> 0x0072, IllegalArgumentException -> 0x0070 }
            int r9 = r8.loadFragmentShader(r9, r10)     // Catch:{ IllegalStateException -> 0x006c, IllegalArgumentException -> 0x006a }
            int r10 = android.opengl.GLES20.glCreateProgram()     // Catch:{ IllegalStateException -> 0x0064, IllegalArgumentException -> 0x0062 }
            java.lang.String r4 = "glCreateProgram"
            checkGlErrorOrThrow(r4)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            android.opengl.GLES20.glAttachShader(r10, r3)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            checkGlErrorOrThrow(r0)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            android.opengl.GLES20.glAttachShader(r10, r9)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            checkGlErrorOrThrow(r0)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            android.opengl.GLES20.glLinkProgram(r10)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            r0 = 1
            int[] r4 = new int[r0]     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            r5 = 35714(0x8b82, float:5.0046E-41)
            r6 = 0
            android.opengl.GLES20.glGetProgramiv(r10, r5, r4, r6)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            r4 = r4[r6]     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            if (r4 != r0) goto L_0x0044
            r8.mProgramHandle = r10     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            return
        L_0x0044:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            r4.<init>(r1)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            java.lang.String r1 = android.opengl.GLES20.glGetProgramInfoLog(r10)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            r4.append(r1)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            java.lang.String r1 = r4.toString()     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
            throw r0     // Catch:{ IllegalStateException -> 0x005c, IllegalArgumentException -> 0x005a }
        L_0x005a:
            r0 = move-exception
            goto L_0x005d
        L_0x005c:
            r0 = move-exception
        L_0x005d:
            r7 = r10
            r10 = r9
            r9 = r0
            r0 = r7
            goto L_0x0076
        L_0x0062:
            r10 = move-exception
            goto L_0x0065
        L_0x0064:
            r10 = move-exception
        L_0x0065:
            r0 = r2
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x0076
        L_0x006a:
            r9 = move-exception
            goto L_0x006d
        L_0x006c:
            r9 = move-exception
        L_0x006d:
            r10 = r2
            r0 = r10
            goto L_0x0076
        L_0x0070:
            r9 = move-exception
            goto L_0x0073
        L_0x0072:
            r9 = move-exception
        L_0x0073:
            r10 = r2
            r0 = r10
            r3 = r0
        L_0x0076:
            if (r3 == r2) goto L_0x007b
            android.opengl.GLES20.glDeleteShader(r3)
        L_0x007b:
            if (r10 == r2) goto L_0x0080
            android.opengl.GLES20.glDeleteShader(r10)
        L_0x0080:
            if (r0 == r2) goto L_0x0085
            android.opengl.GLES20.glDeleteProgram(r0)
        L_0x0085:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.processing.OpenGlRenderer.createProgram(androidx.camera.core.DynamicRange, androidx.camera.core.processing.ShaderProvider):void");
    }

    private void useAndConfigureProgram() {
        GLES20.glUseProgram(this.mProgramHandle);
        checkGlErrorOrThrow("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mExternalTextureId);
        GLES20.glEnableVertexAttribArray(this.mPositionLoc);
        checkGlErrorOrThrow("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mPositionLoc, 2, 5126, false, 0, VERTEX_BUF);
        checkGlErrorOrThrow("glVertexAttribPointer");
        GLES20.glEnableVertexAttribArray(this.mTexCoordLoc);
        checkGlErrorOrThrow("glEnableVertexAttribArray");
        GLES20.glVertexAttribPointer(this.mTexCoordLoc, 2, 5126, false, 0, TEX_BUF);
        checkGlErrorOrThrow("glVertexAttribPointer");
    }

    private void loadLocations() {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.mProgramHandle, "aPosition");
        this.mPositionLoc = glGetAttribLocation;
        checkLocationOrThrow(glGetAttribLocation, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(this.mProgramHandle, "aTextureCoord");
        this.mTexCoordLoc = glGetAttribLocation2;
        checkLocationOrThrow(glGetAttribLocation2, "aTextureCoord");
        int glGetUniformLocation = GLES20.glGetUniformLocation(this.mProgramHandle, "uTexMatrix");
        this.mTexMatrixLoc = glGetUniformLocation;
        checkLocationOrThrow(glGetUniformLocation, "uTexMatrix");
    }

    private void createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        checkGlErrorOrThrow("glGenTextures");
        int i = iArr[0];
        GLES20.glBindTexture(36197, i);
        checkGlErrorOrThrow("glBindTexture " + i);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, Data.MAX_DATA_BYTES, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        checkGlErrorOrThrow("glTexParameter");
        this.mExternalTextureId = i;
    }

    private int loadFragmentShader(DynamicRange dynamicRange, ShaderProvider shaderProvider) {
        if (shaderProvider == ShaderProvider.DEFAULT) {
            return loadShader(35632, dynamicRange.is10BitHdr() ? HDR_FRAGMENT_SHADER : DEFAULT_FRAGMENT_SHADER);
        }
        try {
            String createFragmentShader = shaderProvider.createFragmentShader(VAR_TEXTURE, VAR_TEXTURE_COORD);
            if (createFragmentShader != null && createFragmentShader.contains(VAR_TEXTURE_COORD) && createFragmentShader.contains(VAR_TEXTURE)) {
                return loadShader(35632, createFragmentShader);
            }
            throw new IllegalArgumentException("Invalid fragment shader");
        } catch (Throwable th) {
            if (th instanceof IllegalArgumentException) {
                throw th;
            }
            throw new IllegalArgumentException("Unable to compile fragment shader", th);
        }
    }

    private Size getSurfaceSize(EGLSurface eGLSurface) {
        return new Size(querySurface(this.mEglDisplay, eGLSurface, 12375), querySurface(this.mEglDisplay, eGLSurface, 12374));
    }

    private void releaseInternal() {
        int i = this.mProgramHandle;
        if (i != -1) {
            GLES20.glDeleteProgram(i);
            this.mProgramHandle = -1;
        }
        if (!Objects.equals(this.mEglDisplay, EGL14.EGL_NO_DISPLAY)) {
            EGL14.eglMakeCurrent(this.mEglDisplay, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            for (OutputSurface next : this.mOutputSurfaceMap.values()) {
                if (!Objects.equals(next.getEglSurface(), EGL14.EGL_NO_SURFACE) && !EGL14.eglDestroySurface(this.mEglDisplay, next.getEglSurface())) {
                    checkEglErrorOrLog("eglDestroySurface");
                }
            }
            this.mOutputSurfaceMap.clear();
            if (!Objects.equals(this.mTempSurface, EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.mEglDisplay, this.mTempSurface);
                this.mTempSurface = EGL14.EGL_NO_SURFACE;
            }
            if (!Objects.equals(this.mEglContext, EGL14.EGL_NO_CONTEXT)) {
                EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEglDisplay);
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        }
        this.mEglConfig = null;
        this.mProgramHandle = -1;
        this.mTexMatrixLoc = -1;
        this.mPositionLoc = -1;
        this.mTexCoordLoc = -1;
        this.mExternalTextureId = -1;
        this.mCurrentSurface = null;
        this.mGlThread = null;
    }

    private void checkInitializedOrThrow(boolean z) {
        Preconditions.checkState(z == this.mInitialized.get(), z ? "OpenGlRenderer is not initialized" : "OpenGlRenderer is already initialized");
    }

    private void checkGlThreadOrThrow() {
        Preconditions.checkState(this.mGlThread == Thread.currentThread(), "Method call must be called on the GL thread.");
    }

    private OutputSurface getOutSurfaceOrThrow(Surface surface) {
        Preconditions.checkState(this.mOutputSurfaceMap.containsKey(surface), "The surface is not registered.");
        return (OutputSurface) Objects.requireNonNull(this.mOutputSurfaceMap.get(surface));
    }

    private static EGLSurface createPBufferSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
        EGLSurface eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, new int[]{12375, i, 12374, i2, 12344}, 0);
        checkEglErrorOrThrow("eglCreatePbufferSurface");
        if (eglCreatePbufferSurface != null) {
            return eglCreatePbufferSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    private OutputSurface createOutputSurfaceInternal(Surface surface) {
        try {
            EGLSurface createWindowSurface = createWindowSurface(this.mEglDisplay, (EGLConfig) Objects.requireNonNull(this.mEglConfig), surface, this.mSurfaceAttrib);
            Size surfaceSize = getSurfaceSize(createWindowSurface);
            return OutputSurface.of(createWindowSurface, surfaceSize.getWidth(), surfaceSize.getHeight());
        } catch (IllegalArgumentException | IllegalStateException e) {
            Logger.w(TAG, "Failed to create EGL surface: " + e.getMessage(), e);
            return null;
        }
    }

    private void removeOutputSurfaceInternal(Surface surface, boolean z) {
        OutputSurface outputSurface;
        if (this.mCurrentSurface == surface) {
            this.mCurrentSurface = null;
            makeCurrent(this.mTempSurface);
        }
        if (z) {
            outputSurface = this.mOutputSurfaceMap.remove(surface);
        } else {
            outputSurface = this.mOutputSurfaceMap.put(surface, NO_OUTPUT_SURFACE);
        }
        if (outputSurface != null && outputSurface != NO_OUTPUT_SURFACE) {
            try {
                EGL14.eglDestroySurface(this.mEglDisplay, outputSurface.getEglSurface());
            } catch (RuntimeException e) {
                Logger.w(TAG, "Failed to destroy EGL surface: " + e.getMessage(), e);
            }
        }
    }

    private static EGLSurface createWindowSurface(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Surface surface, int[] iArr) {
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, surface, iArr, 0);
        checkEglErrorOrThrow("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        throw new IllegalStateException("surface was null");
    }

    private static int loadShader(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        checkGlErrorOrThrow("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Logger.w(TAG, "Could not compile shader: " + str);
        GLES20.glDeleteShader(glCreateShader);
        throw new IllegalStateException("Could not compile shader type " + i + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + GLES20.glGetShaderInfoLog(glCreateShader));
    }

    private static int querySurface(EGLDisplay eGLDisplay, EGLSurface eGLSurface, int i) {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(eGLDisplay, eGLSurface, i, iArr, 0);
        return iArr[0];
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    private static void checkLocationOrThrow(int i, String str) {
        if (i < 0) {
            throw new IllegalStateException("Unable to locate '" + str + "' in program");
        }
    }

    private static void checkEglErrorOrThrow(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
        }
    }

    private static void checkEglErrorOrLog(String str) {
        try {
            checkEglErrorOrThrow(str);
        } catch (IllegalStateException e) {
            Logger.e(TAG, e.toString(), e);
        }
    }

    private static void checkGlErrorOrThrow(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            throw new IllegalStateException(str + ": GL error 0x" + Integer.toHexString(glGetError));
        }
    }

    static abstract class OutputSurface {
        /* access modifiers changed from: package-private */
        public abstract EGLSurface getEglSurface();

        /* access modifiers changed from: package-private */
        public abstract int getHeight();

        /* access modifiers changed from: package-private */
        public abstract int getWidth();

        OutputSurface() {
        }

        static OutputSurface of(EGLSurface eGLSurface, int i, int i2) {
            return new AutoValue_OpenGlRenderer_OutputSurface(eGLSurface, i, i2);
        }
    }

    public static abstract class GraphicDeviceInfo {
        public abstract String getEglExtensions();

        public abstract String getEglVersion();

        public abstract String getGlExtensions();

        public abstract String getGlVersion();

        static Builder builder() {
            return new AutoValue_OpenGlRenderer_GraphicDeviceInfo.Builder().setGlVersion(OpenGlRenderer.VERSION_UNKNOWN).setEglVersion(OpenGlRenderer.VERSION_UNKNOWN).setGlExtensions("").setEglExtensions("");
        }

        GraphicDeviceInfo() {
        }

        static abstract class Builder {
            /* access modifiers changed from: package-private */
            public abstract GraphicDeviceInfo build();

            /* access modifiers changed from: package-private */
            public abstract Builder setEglExtensions(String str);

            /* access modifiers changed from: package-private */
            public abstract Builder setEglVersion(String str);

            /* access modifiers changed from: package-private */
            public abstract Builder setGlExtensions(String str);

            /* access modifiers changed from: package-private */
            public abstract Builder setGlVersion(String str);

            Builder() {
            }
        }
    }
}
