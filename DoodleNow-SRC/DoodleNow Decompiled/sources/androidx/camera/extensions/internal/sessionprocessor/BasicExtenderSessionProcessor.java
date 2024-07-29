package androidx.camera.extensions.internal.sessionprocessor;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.util.Pair;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.OutputSurfaceConfiguration;
import androidx.camera.core.impl.RequestProcessor;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.extensions.impl.CaptureProcessorImpl;
import androidx.camera.extensions.impl.CaptureStageImpl;
import androidx.camera.extensions.impl.ImageCaptureExtenderImpl;
import androidx.camera.extensions.impl.PreviewExtenderImpl;
import androidx.camera.extensions.impl.RequestUpdateProcessorImpl;
import androidx.camera.extensions.internal.ClientVersion;
import androidx.camera.extensions.internal.ExtensionVersion;
import androidx.camera.extensions.internal.RequestOptionConfig;
import androidx.camera.extensions.internal.VendorExtender;
import androidx.camera.extensions.internal.Version;
import androidx.camera.extensions.internal.compat.workaround.OnEnableDisableSessionDurationCheck;
import androidx.camera.extensions.internal.sessionprocessor.RequestBuilder;
import androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class BasicExtenderSessionProcessor extends SessionProcessorBase {
    private static final int PREVIEW_PROCESS_MAX_IMAGES = 2;
    private static final String TAG = "BasicSessionProcessor";
    static AtomicInteger sLastOutputConfigId = new AtomicInteger(0);
    private volatile Camera2OutputConfig mAnalysisOutputConfig = null;
    private volatile Camera2OutputConfig mCaptureOutputConfig;
    private volatile OutputSurface mCaptureOutputSurface;
    private final Context mContext;
    private final ImageCaptureExtenderImpl mImageCaptureExtenderImpl;
    volatile boolean mIsCapturing = false;
    private final AtomicInteger mNextCaptureSequenceId = new AtomicInteger(0);
    private OnEnableDisableSessionDurationCheck mOnEnableDisableSessionDurationCheck = new OnEnableDisableSessionDurationCheck();
    private final Map<CaptureRequest.Key<?>, Object> mParameters = new LinkedHashMap();
    private OutputSurface mPostviewOutputSurface;
    private final PreviewExtenderImpl mPreviewExtenderImpl;
    private volatile Camera2OutputConfig mPreviewOutputConfig;
    private volatile OutputSurface mPreviewOutputSurface;
    volatile PreviewProcessor mPreviewProcessor = null;
    /* access modifiers changed from: private */
    public volatile RequestProcessor mRequestProcessor;
    volatile RequestUpdateProcessorImpl mRequestUpdateProcessor = null;
    volatile StillCaptureProcessor mStillCaptureProcessor = null;
    private final List<CaptureResult.Key> mSupportedResultKeys;
    private final VendorExtender mVendorExtender;

    public /* bridge */ /* synthetic */ Set getSupportedCameraOperations() {
        return super.getSupportedCameraOperations();
    }

    public BasicExtenderSessionProcessor(PreviewExtenderImpl previewExtenderImpl, ImageCaptureExtenderImpl imageCaptureExtenderImpl, List<CaptureRequest.Key> list, List<CaptureResult.Key> list2, VendorExtender vendorExtender, Context context) {
        super(list);
        this.mPreviewExtenderImpl = previewExtenderImpl;
        this.mImageCaptureExtenderImpl = imageCaptureExtenderImpl;
        this.mSupportedResultKeys = list2;
        this.mContext = context;
        this.mVendorExtender = vendorExtender;
    }

    /* access modifiers changed from: protected */
    public Camera2SessionConfig initSessionInternal(String str, Map<String, CameraCharacteristics> map, OutputSurfaceConfiguration outputSurfaceConfiguration) {
        Logger.d(TAG, "PreviewExtenderImpl.onInit");
        this.mPreviewExtenderImpl.onInit(str, map.get(str), this.mContext);
        Logger.d(TAG, "ImageCaptureExtenderImpl.onInit");
        this.mImageCaptureExtenderImpl.onInit(str, map.get(str), this.mContext);
        this.mPreviewOutputSurface = outputSurfaceConfiguration.getPreviewOutputSurface();
        this.mCaptureOutputSurface = outputSurfaceConfiguration.getImageCaptureOutputSurface();
        this.mPostviewOutputSurface = outputSurfaceConfiguration.getPostviewOutputSurface();
        PreviewExtenderImpl.ProcessorType processorType = this.mPreviewExtenderImpl.getProcessorType();
        Logger.d(TAG, "preview processorType=" + processorType);
        if (processorType == PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_IMAGE_PROCESSOR) {
            this.mPreviewOutputConfig = ImageReaderOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mPreviewOutputSurface.getSize(), 35, 2);
            this.mPreviewProcessor = new PreviewProcessor(this.mPreviewExtenderImpl.getProcessor(), this.mPreviewOutputSurface.getSurface(), this.mPreviewOutputSurface.getSize());
        } else if (processorType == PreviewExtenderImpl.ProcessorType.PROCESSOR_TYPE_REQUEST_UPDATE_ONLY) {
            this.mPreviewOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mPreviewOutputSurface.getSurface());
            this.mRequestUpdateProcessor = this.mPreviewExtenderImpl.getProcessor();
        } else {
            this.mPreviewOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mPreviewOutputSurface.getSurface());
        }
        CaptureProcessorImpl captureProcessor = this.mImageCaptureExtenderImpl.getCaptureProcessor();
        Logger.d(TAG, "CaptureProcessor=" + captureProcessor);
        if (captureProcessor != null) {
            this.mCaptureOutputConfig = ImageReaderOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mCaptureOutputSurface.getSize(), 35, this.mImageCaptureExtenderImpl.getMaxCaptureStage());
            this.mStillCaptureProcessor = new StillCaptureProcessor(captureProcessor, this.mCaptureOutputSurface.getSurface(), this.mCaptureOutputSurface.getSize(), this.mPostviewOutputSurface);
        } else {
            this.mCaptureOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), this.mCaptureOutputSurface.getSurface());
        }
        if (outputSurfaceConfiguration.getImageAnalysisOutputSurface() != null) {
            this.mAnalysisOutputConfig = SurfaceOutputConfig.create(sLastOutputConfigId.getAndIncrement(), outputSurfaceConfiguration.getImageAnalysisOutputSurface().getSurface());
        }
        boolean z = true;
        Camera2SessionConfigBuilder sessionTemplateId = new Camera2SessionConfigBuilder().addOutputConfig(this.mPreviewOutputConfig).addOutputConfig(this.mCaptureOutputConfig).setSessionTemplateId(1);
        if (ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) && ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4)) {
            int onSessionType = this.mPreviewExtenderImpl.onSessionType();
            if (onSessionType != this.mImageCaptureExtenderImpl.onSessionType()) {
                z = false;
            }
            Preconditions.checkArgument(z, "Needs same session type in both PreviewExtenderImpl and ImageCaptureExtenderImpl");
            if (onSessionType == -1) {
                onSessionType = 0;
            }
            sessionTemplateId.setSessionType(onSessionType);
        }
        if (this.mAnalysisOutputConfig != null) {
            sessionTemplateId.addOutputConfig(this.mAnalysisOutputConfig);
        }
        CaptureStageImpl onPresetSession = this.mPreviewExtenderImpl.onPresetSession();
        Logger.d(TAG, "preview onPresetSession:" + onPresetSession);
        CaptureStageImpl onPresetSession2 = this.mImageCaptureExtenderImpl.onPresetSession();
        Logger.d(TAG, "capture onPresetSession:" + onPresetSession2);
        if (!(onPresetSession == null || onPresetSession.getParameters() == null)) {
            for (Pair pair : onPresetSession.getParameters()) {
                sessionTemplateId.addSessionParameter((CaptureRequest.Key) pair.first, pair.second);
            }
        }
        if (!(onPresetSession2 == null || onPresetSession2.getParameters() == null)) {
            for (Pair pair2 : onPresetSession2.getParameters()) {
                sessionTemplateId.addSessionParameter((CaptureRequest.Key) pair2.first, pair2.second);
            }
        }
        return sessionTemplateId.build();
    }

    /* access modifiers changed from: protected */
    public void deInitSessionInternal() {
        if (this.mPreviewProcessor != null) {
            this.mPreviewProcessor.close();
            this.mPreviewProcessor = null;
        }
        if (this.mStillCaptureProcessor != null) {
            this.mStillCaptureProcessor.close();
            this.mStillCaptureProcessor = null;
        }
        Logger.d(TAG, "preview onDeInit");
        this.mPreviewExtenderImpl.onDeInit();
        Logger.d(TAG, "capture onDeInit");
        this.mImageCaptureExtenderImpl.onDeInit();
    }

    public void setParameters(Config config) {
        synchronized (this.mLock) {
            HashMap hashMap = new HashMap();
            RequestOptionConfig build = RequestOptionConfig.Builder.from(config).build();
            for (Config.Option option : build.listOptions()) {
                hashMap.put((CaptureRequest.Key) option.getToken(), build.retrieveOption(option));
            }
            this.mParameters.clear();
            this.mParameters.putAll(hashMap);
            applyRotationAndJpegQualityToProcessor();
        }
    }

    public void onCaptureSessionStart(RequestProcessor requestProcessor) {
        this.mRequestProcessor = requestProcessor;
        ArrayList arrayList = new ArrayList();
        CaptureStageImpl onEnableSession = this.mPreviewExtenderImpl.onEnableSession();
        Logger.d(TAG, "preview onEnableSession: " + onEnableSession);
        if (onEnableSession != null) {
            arrayList.add(onEnableSession);
        }
        CaptureStageImpl onEnableSession2 = this.mImageCaptureExtenderImpl.onEnableSession();
        Logger.d(TAG, "capture onEnableSession:" + onEnableSession2);
        if (onEnableSession2 != null) {
            arrayList.add(onEnableSession2);
        }
        this.mOnEnableDisableSessionDurationCheck.onEnableSessionInvoked();
        if (!arrayList.isEmpty()) {
            submitRequestByCaptureStages(requestProcessor, arrayList);
        }
        if (this.mPreviewProcessor != null) {
            this.mPreviewProcessor.resume();
            setImageProcessor(this.mPreviewOutputConfig.getId(), new ImageProcessor() {
                public void onNextImageAvailable(int i, long j, ImageReference imageReference, String str) {
                    if (BasicExtenderSessionProcessor.this.mPreviewProcessor != null) {
                        BasicExtenderSessionProcessor.this.mPreviewProcessor.notifyImage(imageReference);
                    } else {
                        imageReference.decrement();
                    }
                }
            });
        }
    }

    private void applyParameters(RequestBuilder requestBuilder) {
        synchronized (this.mLock) {
            for (CaptureRequest.Key next : this.mParameters.keySet()) {
                Object obj = this.mParameters.get(next);
                if (obj != null) {
                    requestBuilder.setParameters(next, obj);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyRotationAndJpegQualityToProcessor() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor r1 = r3.mStillCaptureProcessor     // Catch:{ all -> 0x0035 }
            if (r1 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0009:
            java.util.Map<android.hardware.camera2.CaptureRequest$Key<?>, java.lang.Object> r1 = r3.mParameters     // Catch:{ all -> 0x0035 }
            android.hardware.camera2.CaptureRequest$Key r2 = android.hardware.camera2.CaptureRequest.JPEG_ORIENTATION     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0035 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x001e
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor r2 = r3.mStillCaptureProcessor     // Catch:{ all -> 0x0035 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x0035 }
            r2.setRotationDegrees(r1)     // Catch:{ all -> 0x0035 }
        L_0x001e:
            java.util.Map<android.hardware.camera2.CaptureRequest$Key<?>, java.lang.Object> r1 = r3.mParameters     // Catch:{ all -> 0x0035 }
            android.hardware.camera2.CaptureRequest$Key r2 = android.hardware.camera2.CaptureRequest.JPEG_QUALITY     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0035 }
            java.lang.Byte r1 = (java.lang.Byte) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0033
            androidx.camera.extensions.internal.sessionprocessor.StillCaptureProcessor r2 = r3.mStillCaptureProcessor     // Catch:{ all -> 0x0035 }
            byte r1 = r1.byteValue()     // Catch:{ all -> 0x0035 }
            r2.setJpegQuality(r1)     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.extensions.internal.sessionprocessor.BasicExtenderSessionProcessor.applyRotationAndJpegQualityToProcessor():void");
    }

    private void submitRequestByCaptureStages(RequestProcessor requestProcessor, List<CaptureStageImpl> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureStageImpl next : list) {
            RequestBuilder requestBuilder = new RequestBuilder();
            requestBuilder.addTargetOutputConfigIds(this.mPreviewOutputConfig.getId());
            if (this.mAnalysisOutputConfig != null) {
                requestBuilder.addTargetOutputConfigIds(this.mAnalysisOutputConfig.getId());
            }
            for (Pair pair : next.getParameters()) {
                requestBuilder.setParameters((CaptureRequest.Key) pair.first, pair.second);
            }
            requestBuilder.setTemplateId(1);
            arrayList.add(requestBuilder.build());
        }
        requestProcessor.submit((List<RequestProcessor.Request>) arrayList, (RequestProcessor.Callback) new RequestProcessor.Callback() {
            public /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i) {
                RequestProcessor.Callback.CC.$default$onCaptureBufferLost(this, request, j, i);
            }

            public /* synthetic */ void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                RequestProcessor.Callback.CC.$default$onCaptureCompleted(this, request, cameraCaptureResult);
            }

            public /* synthetic */ void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                RequestProcessor.Callback.CC.$default$onCaptureFailed(this, request, cameraCaptureFailure);
            }

            public /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                RequestProcessor.Callback.CC.$default$onCaptureProgressed(this, request, cameraCaptureResult);
            }

            public /* synthetic */ void onCaptureSequenceAborted(int i) {
                RequestProcessor.Callback.CC.$default$onCaptureSequenceAborted(this, i);
            }

            public /* synthetic */ void onCaptureSequenceCompleted(int i, long j) {
                RequestProcessor.Callback.CC.$default$onCaptureSequenceCompleted(this, i, j);
            }

            public /* synthetic */ void onCaptureStarted(RequestProcessor.Request request, long j, long j2) {
                RequestProcessor.Callback.CC.$default$onCaptureStarted(this, request, j, j2);
            }
        });
    }

    public void onCaptureSessionEnd() {
        this.mOnEnableDisableSessionDurationCheck.onDisableSessionInvoked();
        if (this.mPreviewProcessor != null) {
            this.mPreviewProcessor.pause();
        }
        ArrayList arrayList = new ArrayList();
        CaptureStageImpl onDisableSession = this.mPreviewExtenderImpl.onDisableSession();
        Logger.d(TAG, "preview onDisableSession: " + onDisableSession);
        if (onDisableSession != null) {
            arrayList.add(onDisableSession);
        }
        CaptureStageImpl onDisableSession2 = this.mImageCaptureExtenderImpl.onDisableSession();
        Logger.d(TAG, "capture onDisableSession:" + onDisableSession2);
        if (onDisableSession2 != null) {
            arrayList.add(onDisableSession2);
        }
        if (!arrayList.isEmpty()) {
            submitRequestByCaptureStages(this.mRequestProcessor, arrayList);
        }
        this.mRequestProcessor = null;
        this.mIsCapturing = false;
    }

    /* access modifiers changed from: package-private */
    public Map<CaptureResult.Key, Object> getCaptureResultKeyMapFromList(List<Pair<CaptureResult.Key, Object>> list) {
        HashMap hashMap = new HashMap();
        for (Pair next : list) {
            hashMap.put((CaptureResult.Key) next.first, next.second);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public Map<CaptureResult.Key, Object> getCaptureResultKeyMaps(TotalCaptureResult totalCaptureResult) {
        HashMap hashMap = new HashMap();
        for (CaptureResult.Key next : this.mSupportedResultKeys) {
            Object obj = totalCaptureResult.get(next);
            if (obj != null) {
                hashMap.put(next, obj);
            }
        }
        return hashMap;
    }

    public int startRepeating(SessionProcessor.CaptureCallback captureCallback) {
        int andIncrement = this.mNextCaptureSequenceId.getAndIncrement();
        if (this.mRequestProcessor == null) {
            captureCallback.onCaptureFailed(andIncrement);
            captureCallback.onCaptureSequenceAborted(andIncrement);
        } else {
            if (this.mPreviewProcessor != null) {
                this.mPreviewProcessor.start(new BasicExtenderSessionProcessor$$ExternalSyntheticLambda0(this, captureCallback, andIncrement));
            }
            updateRepeating(andIncrement, captureCallback);
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$startRepeating$0$androidx-camera-extensions-internal-sessionprocessor-BasicExtenderSessionProcessor  reason: not valid java name */
    public /* synthetic */ void m210lambda$startRepeating$0$androidxcameraextensionsinternalsessionprocessorBasicExtenderSessionProcessor(SessionProcessor.CaptureCallback captureCallback, int i, long j, List list) {
        captureCallback.onCaptureCompleted(j, i, getCaptureResultKeyMapFromList(list));
    }

    /* access modifiers changed from: package-private */
    public void updateRepeating(final int i, final SessionProcessor.CaptureCallback captureCallback) {
        if (this.mRequestProcessor == null) {
            Logger.d(TAG, "mRequestProcessor is null, ignore repeating request");
            return;
        }
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addTargetOutputConfigIds(this.mPreviewOutputConfig.getId());
        if (this.mAnalysisOutputConfig != null) {
            requestBuilder.addTargetOutputConfigIds(this.mAnalysisOutputConfig.getId());
        }
        requestBuilder.setTemplateId(1);
        applyParameters(requestBuilder);
        applyPreviewStagesParameters(requestBuilder);
        AnonymousClass3 r2 = new RequestProcessor.Callback() {
            public /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i) {
                RequestProcessor.Callback.CC.$default$onCaptureBufferLost(this, request, j, i);
            }

            public /* synthetic */ void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                RequestProcessor.Callback.CC.$default$onCaptureFailed(this, request, cameraCaptureFailure);
            }

            public /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                RequestProcessor.Callback.CC.$default$onCaptureProgressed(this, request, cameraCaptureResult);
            }

            public /* synthetic */ void onCaptureSequenceAborted(int i) {
                RequestProcessor.Callback.CC.$default$onCaptureSequenceAborted(this, i);
            }

            public /* synthetic */ void onCaptureSequenceCompleted(int i, long j) {
                RequestProcessor.Callback.CC.$default$onCaptureSequenceCompleted(this, i, j);
            }

            public /* synthetic */ void onCaptureStarted(RequestProcessor.Request request, long j, long j2) {
                RequestProcessor.Callback.CC.$default$onCaptureStarted(this, request, j, j2);
            }

            public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                Long l;
                CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
                Preconditions.checkArgument(captureResult instanceof TotalCaptureResult, "Cannot get TotalCaptureResult from the cameraCaptureResult ");
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) captureResult;
                if (BasicExtenderSessionProcessor.this.mPreviewProcessor != null) {
                    BasicExtenderSessionProcessor.this.mPreviewProcessor.notifyCaptureResult(totalCaptureResult);
                } else if (ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_3) && ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_3) && (l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP)) != null) {
                    captureCallback.onCaptureCompleted(l.longValue(), i, BasicExtenderSessionProcessor.this.getCaptureResultKeyMaps(totalCaptureResult));
                }
                if (!(BasicExtenderSessionProcessor.this.mRequestUpdateProcessor == null || BasicExtenderSessionProcessor.this.mRequestUpdateProcessor.process(totalCaptureResult) == null)) {
                    BasicExtenderSessionProcessor.this.updateRepeating(i, captureCallback);
                }
                captureCallback.onCaptureSequenceCompleted(i);
            }
        };
        Logger.d(TAG, "requestProcessor setRepeating");
        this.mRequestProcessor.setRepeating(requestBuilder.build(), r2);
    }

    private void applyPreviewStagesParameters(RequestBuilder requestBuilder) {
        CaptureStageImpl captureStage = this.mPreviewExtenderImpl.getCaptureStage();
        if (captureStage != null) {
            for (Pair pair : captureStage.getParameters()) {
                requestBuilder.setParameters((CaptureRequest.Key) pair.first, pair.second);
            }
        }
    }

    public void stopRepeating() {
        this.mRequestProcessor.stopRepeating();
    }

    public int startCapture(boolean z, final SessionProcessor.CaptureCallback captureCallback) {
        final int andIncrement = this.mNextCaptureSequenceId.getAndIncrement();
        if (this.mRequestProcessor == null || this.mIsCapturing) {
            Logger.d(TAG, "startCapture failed");
            captureCallback.onCaptureFailed(andIncrement);
            captureCallback.onCaptureSequenceAborted(andIncrement);
            return andIncrement;
        }
        this.mIsCapturing = true;
        ArrayList arrayList = new ArrayList();
        List<CaptureStageImpl> captureStages = this.mImageCaptureExtenderImpl.getCaptureStages();
        ArrayList arrayList2 = new ArrayList();
        for (CaptureStageImpl captureStageImpl : captureStages) {
            RequestBuilder requestBuilder = new RequestBuilder();
            requestBuilder.addTargetOutputConfigIds(this.mCaptureOutputConfig.getId());
            requestBuilder.setTemplateId(2);
            requestBuilder.setCaptureStageId(captureStageImpl.getId());
            arrayList2.add(Integer.valueOf(captureStageImpl.getId()));
            applyParameters(requestBuilder);
            applyPreviewStagesParameters(requestBuilder);
            for (Pair pair : captureStageImpl.getParameters()) {
                requestBuilder.setParameters((CaptureRequest.Key) pair.first, pair.second);
            }
            arrayList.add(requestBuilder.build());
        }
        Logger.d(TAG, "Wait for capture stage id: " + arrayList2);
        AnonymousClass4 r3 = new RequestProcessor.Callback() {
            boolean mIsCaptureFailed = false;
            boolean mIsCaptureStarted = false;

            public /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i) {
                RequestProcessor.Callback.CC.$default$onCaptureBufferLost(this, request, j, i);
            }

            public /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                RequestProcessor.Callback.CC.$default$onCaptureProgressed(this, request, cameraCaptureResult);
            }

            public /* synthetic */ void onCaptureSequenceCompleted(int i, long j) {
                RequestProcessor.Callback.CC.$default$onCaptureSequenceCompleted(this, i, j);
            }

            public void onCaptureStarted(RequestProcessor.Request request, long j, long j2) {
                if (!this.mIsCaptureStarted) {
                    this.mIsCaptureStarted = true;
                    captureCallback.onCaptureStarted(andIncrement, j2);
                }
            }

            public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                CaptureResult captureResult = cameraCaptureResult.getCaptureResult();
                Preconditions.checkArgument(captureResult instanceof TotalCaptureResult, "Cannot get capture TotalCaptureResult from the cameraCaptureResult ");
                TotalCaptureResult totalCaptureResult = (TotalCaptureResult) captureResult;
                RequestBuilder.RequestProcessorRequest requestProcessorRequest = (RequestBuilder.RequestProcessorRequest) request;
                if (BasicExtenderSessionProcessor.this.mStillCaptureProcessor != null) {
                    BasicExtenderSessionProcessor.this.mStillCaptureProcessor.notifyCaptureResult(totalCaptureResult, requestProcessorRequest.getCaptureStageId());
                    return;
                }
                BasicExtenderSessionProcessor.this.mIsCapturing = false;
                if (BasicExtenderSessionProcessor.this.mRequestProcessor == null) {
                    captureCallback.onCaptureSequenceAborted(andIncrement);
                    return;
                }
                captureCallback.onCaptureProcessStarted(andIncrement);
                captureCallback.onCaptureSequenceCompleted(andIncrement);
            }

            public void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                if (!this.mIsCaptureFailed) {
                    this.mIsCaptureFailed = true;
                    captureCallback.onCaptureFailed(andIncrement);
                    captureCallback.onCaptureSequenceAborted(andIncrement);
                    BasicExtenderSessionProcessor.this.mIsCapturing = false;
                }
            }

            public void onCaptureSequenceAborted(int i) {
                captureCallback.onCaptureSequenceAborted(andIncrement);
                BasicExtenderSessionProcessor.this.mIsCapturing = false;
            }
        };
        Logger.d(TAG, "startCapture");
        if (this.mStillCaptureProcessor != null) {
            setImageProcessor(this.mCaptureOutputConfig.getId(), new ImageProcessor() {
                boolean mIsFirstFrame = true;

                public void onNextImageAvailable(int i, long j, ImageReference imageReference, String str) {
                    Logger.d(BasicExtenderSessionProcessor.TAG, "onNextImageAvailable  outputStreamId=" + i);
                    if (BasicExtenderSessionProcessor.this.mStillCaptureProcessor != null) {
                        BasicExtenderSessionProcessor.this.mStillCaptureProcessor.notifyImage(imageReference);
                    } else {
                        imageReference.decrement();
                    }
                    if (this.mIsFirstFrame) {
                        captureCallback.onCaptureProcessStarted(andIncrement);
                        this.mIsFirstFrame = false;
                    }
                }
            });
            this.mStillCaptureProcessor.startCapture(z, arrayList2, new StillCaptureProcessor.OnCaptureResultCallback() {
                public void onCompleted() {
                    captureCallback.onCaptureSequenceCompleted(andIncrement);
                    BasicExtenderSessionProcessor.this.mIsCapturing = false;
                }

                public void onError(Exception exc) {
                    captureCallback.onCaptureFailed(andIncrement);
                    BasicExtenderSessionProcessor.this.mIsCapturing = false;
                }

                public void onCaptureResult(long j, List<Pair<CaptureResult.Key, Object>> list) {
                    captureCallback.onCaptureCompleted(j, andIncrement, BasicExtenderSessionProcessor.this.getCaptureResultKeyMapFromList(list));
                }

                public void onCaptureProcessProgressed(int i) {
                    captureCallback.onCaptureProcessProgressed(i);
                }
            });
        }
        this.mRequestProcessor.submit((List<RequestProcessor.Request>) arrayList, (RequestProcessor.Callback) r3);
        return andIncrement;
    }

    public void abortCapture(int i) {
        this.mRequestProcessor.abortCaptures();
    }

    public int startTrigger(Config config, final SessionProcessor.CaptureCallback captureCallback) {
        Logger.d(TAG, "startTrigger");
        final int andIncrement = this.mNextCaptureSequenceId.getAndIncrement();
        RequestBuilder requestBuilder = new RequestBuilder();
        requestBuilder.addTargetOutputConfigIds(this.mPreviewOutputConfig.getId());
        if (this.mAnalysisOutputConfig != null) {
            requestBuilder.addTargetOutputConfigIds(this.mAnalysisOutputConfig.getId());
        }
        requestBuilder.setTemplateId(1);
        applyParameters(requestBuilder);
        applyPreviewStagesParameters(requestBuilder);
        RequestOptionConfig build = RequestOptionConfig.Builder.from(config).build();
        for (Config.Option option : build.listOptions()) {
            requestBuilder.setParameters((CaptureRequest.Key) option.getToken(), build.retrieveOption(option));
        }
        this.mRequestProcessor.submit(requestBuilder.build(), (RequestProcessor.Callback) new RequestProcessor.Callback() {
            public /* synthetic */ void onCaptureBufferLost(RequestProcessor.Request request, long j, int i) {
                RequestProcessor.Callback.CC.$default$onCaptureBufferLost(this, request, j, i);
            }

            public /* synthetic */ void onCaptureProgressed(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                RequestProcessor.Callback.CC.$default$onCaptureProgressed(this, request, cameraCaptureResult);
            }

            public /* synthetic */ void onCaptureSequenceAborted(int i) {
                RequestProcessor.Callback.CC.$default$onCaptureSequenceAborted(this, i);
            }

            public /* synthetic */ void onCaptureSequenceCompleted(int i, long j) {
                RequestProcessor.Callback.CC.$default$onCaptureSequenceCompleted(this, i, j);
            }

            public /* synthetic */ void onCaptureStarted(RequestProcessor.Request request, long j, long j2) {
                RequestProcessor.Callback.CC.$default$onCaptureStarted(this, request, j, j2);
            }

            public void onCaptureCompleted(RequestProcessor.Request request, CameraCaptureResult cameraCaptureResult) {
                captureCallback.onCaptureSequenceCompleted(andIncrement);
            }

            public void onCaptureFailed(RequestProcessor.Request request, CameraCaptureFailure cameraCaptureFailure) {
                captureCallback.onCaptureFailed(andIncrement);
            }
        });
        return andIncrement;
    }

    public Pair<Long, Long> getRealtimeCaptureLatency() {
        if (!ClientVersion.isMinimumCompatibleVersion(Version.VERSION_1_4) || !ExtensionVersion.isMinimumCompatibleVersion(Version.VERSION_1_4)) {
            return null;
        }
        return this.mImageCaptureExtenderImpl.getRealtimeCaptureLatency();
    }

    public Map<Integer, List<Size>> getSupportedPostviewSize(Size size) {
        return this.mVendorExtender.getSupportedPostviewResolutions(size);
    }
}
