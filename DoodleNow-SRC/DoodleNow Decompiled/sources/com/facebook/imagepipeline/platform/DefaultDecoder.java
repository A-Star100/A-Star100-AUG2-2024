package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.memory.DummyBitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public abstract class DefaultDecoder implements PlatformDecoder {
    private static final byte[] EOI_TAIL = {-1, -39};
    private static final Class<?> TAG = DefaultDecoder.class;
    private boolean mAvoidPoolGet;
    private boolean mAvoidPoolRelease;
    private final BitmapPool mBitmapPool;
    final Pools.Pool<ByteBuffer> mDecodeBuffers;
    @Nullable
    private final PreverificationHelper mPreverificationHelper;

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);

    public DefaultDecoder(BitmapPool bitmapPool, Pools.Pool<ByteBuffer> pool, PlatformDecoderOptions platformDecoderOptions) {
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        if (bitmapPool instanceof DummyBitmapPool) {
            this.mAvoidPoolGet = platformDecoderOptions.getAvoidPoolGet();
            this.mAvoidPoolRelease = platformDecoderOptions.getAvoidPoolRelease();
        }
        this.mDecodeBuffers = pool;
    }

    @Nullable
    public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect) {
        return decodeFromEncodedImageWithColorSpace(encodedImage, config, rect, (ColorSpace) null);
    }

    @Nullable
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i) {
        return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, config, rect, i, (ColorSpace) null);
    }

    @Nullable
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, @Nullable ColorSpace colorSpace) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream((InputStream) Preconditions.checkNotNull(encodedImage.getInputStream()), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    @Nullable
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, @Nullable Rect rect, int i, @Nullable ColorSpace colorSpace) {
        boolean isCompleteAt = encodedImage.isCompleteAt(i);
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config, this.mAvoidPoolGet);
        TailAppendingInputStream inputStream = encodedImage.getInputStream();
        Preconditions.checkNotNull(inputStream);
        if (encodedImage.getSize() > i) {
            inputStream = new LimitedInputStream(inputStream, i);
        }
        if (!isCompleteAt) {
            inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
        }
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            CloseableReference<Bitmap> decodeFromStream = decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return decodeFromStream;
        } catch (RuntimeException e2) {
            if (z) {
                CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace = decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                return decodeJPEGFromEncodedImageWithColorSpace;
            }
            throw e2;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream inputStream, BitmapFactory.Options options, @Nullable Rect rect) {
        return decodeFromStream(inputStream, options, rect, (ColorSpace) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        com.facebook.common.logging.FLog.e(TAG, "Could not decode region %s, decoding full bitmap instead.", r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b2, code lost:
        if (r0 != null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r0.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b8, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b9, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        r2 = r8.mPreverificationHelper;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00a7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x011f */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0098 A[SYNTHETIC, Splitter:B:42:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a0 A[SYNTHETIC, Splitter:B:46:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc A[Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6, all -> 0x00f4, IOException -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c3 A[Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6, all -> 0x00f4, IOException -> 0x011f }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ed  */
    @javax.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.common.references.CloseableReference<android.graphics.Bitmap> decodeFromStream(java.io.InputStream r9, android.graphics.BitmapFactory.Options r10, @javax.annotation.Nullable android.graphics.Rect r11, @javax.annotation.Nullable android.graphics.ColorSpace r12) {
        /*
            r8 = this;
            com.facebook.common.internal.Preconditions.checkNotNull(r9)
            int r0 = r10.outWidth
            int r1 = r10.outHeight
            if (r11 == 0) goto L_0x0017
            int r0 = r11.width()
            int r1 = r10.inSampleSize
            int r0 = r0 / r1
            int r1 = r11.height()
            int r2 = r10.inSampleSize
            int r1 = r1 / r2
        L_0x0017:
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L_0x002d
            com.facebook.imagepipeline.platform.PreverificationHelper r2 = r8.mPreverificationHelper
            if (r2 == 0) goto L_0x002d
            android.graphics.Bitmap$Config r6 = r10.inPreferredConfig
            boolean r2 = r2.shouldUseHardwareBitmapConfig(r6)
            if (r2 == 0) goto L_0x002d
            r2 = r4
            goto L_0x002e
        L_0x002d:
            r2 = r5
        L_0x002e:
            r6 = 0
            if (r11 != 0) goto L_0x0036
            if (r2 == 0) goto L_0x0036
            r10.inMutable = r5
            goto L_0x0059
        L_0x0036:
            if (r11 == 0) goto L_0x003e
            if (r2 == 0) goto L_0x003e
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ARGB_8888
            r10.inPreferredConfig = r2
        L_0x003e:
            boolean r2 = r8.mAvoidPoolGet
            if (r2 != 0) goto L_0x0059
            int r2 = r8.getBitmapSize(r0, r1, r10)
            com.facebook.imagepipeline.memory.BitmapPool r7 = r8.mBitmapPool
            java.lang.Object r2 = r7.get(r2)
            android.graphics.Bitmap r2 = (android.graphics.Bitmap) r2
            if (r2 == 0) goto L_0x0051
            goto L_0x005a
        L_0x0051:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "BitmapPool.get returned null"
            r9.<init>(r10)
            throw r9
        L_0x0059:
            r2 = r6
        L_0x005a:
            r10.inBitmap = r2
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r3) goto L_0x006d
            if (r12 != 0) goto L_0x006a
            android.graphics.ColorSpace$Named r12 = androidx.core.graphics.ColorKt$$ExternalSyntheticApiModelOutline0.m()
            android.graphics.ColorSpace r12 = android.graphics.ColorSpace.get(r12)
        L_0x006a:
            r10.inPreferredColorSpace = r12
        L_0x006d:
            androidx.core.util.Pools$Pool<java.nio.ByteBuffer> r12 = r8.mDecodeBuffers
            java.lang.Object r12 = r12.acquire()
            java.nio.ByteBuffer r12 = (java.nio.ByteBuffer) r12
            if (r12 != 0) goto L_0x007f
            int r12 = com.facebook.common.memory.DecodeBufferHelper.getRecommendedDecodeBufferSize()
            java.nio.ByteBuffer r12 = java.nio.ByteBuffer.allocate(r12)
        L_0x007f:
            byte[] r3 = r12.array()     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
            r10.inTempStorage = r3     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
            if (r11 == 0) goto L_0x00c0
            if (r2 == 0) goto L_0x00c0
            android.graphics.Bitmap$Config r3 = r10.inPreferredConfig     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
            if (r3 == 0) goto L_0x00c0
            android.graphics.Bitmap$Config r3 = r10.inPreferredConfig     // Catch:{ IOException -> 0x00a6, all -> 0x00a4 }
            r2.reconfigure(r0, r1, r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a4 }
            android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r9, r4)     // Catch:{ IOException -> 0x00a6, all -> 0x00a4 }
            if (r0 == 0) goto L_0x009d
            android.graphics.Bitmap r11 = r0.decodeRegion(r11, r10)     // Catch:{ IOException -> 0x00a7 }
            goto L_0x009e
        L_0x009d:
            r11 = r6
        L_0x009e:
            if (r0 == 0) goto L_0x00c1
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
            goto L_0x00c1
        L_0x00a4:
            r10 = move-exception
            goto L_0x00ba
        L_0x00a6:
            r0 = r6
        L_0x00a7:
            java.lang.Class<?> r1 = TAG     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = "Could not decode region %s, decoding full bitmap instead."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00b8 }
            r4[r5] = r11     // Catch:{ all -> 0x00b8 }
            com.facebook.common.logging.FLog.e((java.lang.Class<?>) r1, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x00c0
            r0.recycle()     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
            goto L_0x00c0
        L_0x00b8:
            r10 = move-exception
            r6 = r0
        L_0x00ba:
            if (r6 == 0) goto L_0x00bf
            r6.recycle()     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
        L_0x00bf:
            throw r10     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
        L_0x00c0:
            r11 = r6
        L_0x00c1:
            if (r11 != 0) goto L_0x00c7
            android.graphics.Bitmap r11 = android.graphics.BitmapFactory.decodeStream(r9, r6, r10)     // Catch:{ IllegalArgumentException -> 0x00ff, RuntimeException -> 0x00f6 }
        L_0x00c7:
            androidx.core.util.Pools$Pool<java.nio.ByteBuffer> r9 = r8.mDecodeBuffers
            r9.release(r12)
            if (r2 == 0) goto L_0x00e0
            if (r2 == r11) goto L_0x00e0
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            r9.release(r2)
            if (r11 == 0) goto L_0x00da
            r11.recycle()
        L_0x00da:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x00e0:
            boolean r9 = r8.mAvoidPoolRelease
            if (r9 == 0) goto L_0x00ed
            com.facebook.imagepipeline.platform.DefaultDecoder$NoOpResourceReleaser r9 = com.facebook.imagepipeline.platform.DefaultDecoder.NoOpResourceReleaser.INSTANCE
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.of(r11, r9)
            return r9
        L_0x00ed:
            com.facebook.imagepipeline.memory.BitmapPool r9 = r8.mBitmapPool
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.of(r11, r9)
            return r9
        L_0x00f4:
            r9 = move-exception
            goto L_0x0120
        L_0x00f6:
            r9 = move-exception
            if (r2 == 0) goto L_0x00fe
            com.facebook.imagepipeline.memory.BitmapPool r10 = r8.mBitmapPool     // Catch:{ all -> 0x00f4 }
            r10.release(r2)     // Catch:{ all -> 0x00f4 }
        L_0x00fe:
            throw r9     // Catch:{ all -> 0x00f4 }
        L_0x00ff:
            r10 = move-exception
            if (r2 == 0) goto L_0x0107
            com.facebook.imagepipeline.memory.BitmapPool r11 = r8.mBitmapPool     // Catch:{ all -> 0x00f4 }
            r11.release(r2)     // Catch:{ all -> 0x00f4 }
        L_0x0107:
            r9.reset()     // Catch:{ IOException -> 0x011f }
            android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r9)     // Catch:{ IOException -> 0x011f }
            if (r9 == 0) goto L_0x011e
            com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser r11 = com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser.getInstance()     // Catch:{ IOException -> 0x011f }
            com.facebook.common.references.CloseableReference r9 = com.facebook.common.references.CloseableReference.of(r9, r11)     // Catch:{ IOException -> 0x011f }
            androidx.core.util.Pools$Pool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            return r9
        L_0x011e:
            throw r10     // Catch:{ IOException -> 0x011f }
        L_0x011f:
            throw r10     // Catch:{ all -> 0x00f4 }
        L_0x0120:
            androidx.core.util.Pools$Pool<java.nio.ByteBuffer> r10 = r8.mDecodeBuffers
            r10.release(r12)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imagepipeline.platform.DefaultDecoder.decodeFromStream(java.io.InputStream, android.graphics.BitmapFactory$Options, android.graphics.Rect, android.graphics.ColorSpace):com.facebook.common.references.CloseableReference");
    }

    private static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        if (!z) {
            BitmapFactory.decodeStream(encodedImage.getInputStream(), (Rect) null, options);
            if (options.outWidth == -1 || options.outHeight == -1) {
                throw new IllegalArgumentException();
            }
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    private static final class NoOpResourceReleaser implements ResourceReleaser<Bitmap> {
        /* access modifiers changed from: private */
        public static final NoOpResourceReleaser INSTANCE = new NoOpResourceReleaser();

        public void release(Bitmap bitmap) {
        }

        private NoOpResourceReleaser() {
        }
    }
}
