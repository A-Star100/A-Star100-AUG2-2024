package androidx.camera.core.streamsharing;

import android.graphics.Rect;
import android.util.Log;
import android.util.Size;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class StreamSharing extends UseCase {
    private static final String TAG = "StreamSharing";
    private SurfaceEdge mCameraEdge;
    private final StreamSharingConfig mDefaultConfig;
    private SurfaceProcessorNode mEffectNode;
    SessionConfig.Builder mSessionConfigBuilder;
    private SurfaceEdge mSharingInputEdge;
    private SurfaceProcessorNode mSharingNode;
    private final VirtualCameraAdapter mVirtualCameraAdapter;

    interface Control {
        ListenableFuture<Void> jpegSnapshot(int i, int i2);
    }

    /* access modifiers changed from: package-private */
    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    public SurfaceEdge getSharingInputEdge() {
        return this.mSharingInputEdge;
    }

    /* access modifiers changed from: package-private */
    public SurfaceProcessorNode getSharingNode() {
        return this.mSharingNode;
    }

    /* access modifiers changed from: package-private */
    public VirtualCameraAdapter getVirtualCameraAdapter() {
        return this.mVirtualCameraAdapter;
    }

    private static StreamSharingConfig getDefaultConfig(Set<UseCase> set) {
        MutableConfig mutableConfig = new StreamSharingBuilder().getMutableConfig();
        mutableConfig.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        ArrayList arrayList = new ArrayList();
        for (UseCase next : set) {
            if (next.getCurrentConfig().containsOption(UseCaseConfig.OPTION_CAPTURE_TYPE)) {
                arrayList.add(next.getCurrentConfig().getCaptureType());
            } else {
                Log.e(TAG, "A child does not have capture type.");
            }
        }
        mutableConfig.insertOption(StreamSharingConfig.OPTION_CAPTURE_TYPES, arrayList);
        mutableConfig.insertOption(ImageOutputConfig.OPTION_MIRROR_MODE, 2);
        return new StreamSharingConfig(OptionsBundle.from(mutableConfig));
    }

    public StreamSharing(CameraInternal cameraInternal, Set<UseCase> set, UseCaseConfigFactory useCaseConfigFactory) {
        super(getDefaultConfig(set));
        this.mDefaultConfig = getDefaultConfig(set);
        this.mVirtualCameraAdapter = new VirtualCameraAdapter(cameraInternal, set, useCaseConfigFactory, new StreamSharing$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$androidx-camera-core-streamsharing-StreamSharing  reason: not valid java name */
    public /* synthetic */ ListenableFuture m207lambda$new$0$androidxcameracorestreamsharingStreamSharing(int i, int i2) {
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        if (surfaceProcessorNode != null) {
            return surfaceProcessorNode.getSurfaceProcessor().snapshot(i, i2);
        }
        return Futures.immediateFailedFuture(new Exception("Failed to take picture: pipeline is not ready."));
    }

    public UseCaseConfig<?> getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(this.mDefaultConfig.getCaptureType(), 1);
        if (z) {
            config = Config.CC.mergeConfigs(config, this.mDefaultConfig.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config) {
        return new StreamSharingBuilder(MutableOptionsBundle.from(config));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [androidx.camera.core.impl.UseCaseConfig$Builder, androidx.camera.core.impl.UseCaseConfig$Builder<?, ?, ?>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.UseCaseConfig<?> onMergeConfig(androidx.camera.core.impl.CameraInfoInternal r2, androidx.camera.core.impl.UseCaseConfig.Builder<?, ?, ?> r3) {
        /*
            r1 = this;
            androidx.camera.core.streamsharing.VirtualCameraAdapter r2 = r1.mVirtualCameraAdapter
            androidx.camera.core.impl.MutableConfig r0 = r3.getMutableConfig()
            r2.mergeChildrenConfigs(r0)
            androidx.camera.core.impl.UseCaseConfig r2 = r3.getUseCaseConfig()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.streamsharing.StreamSharing.onMergeConfig(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.UseCaseConfig$Builder):androidx.camera.core.impl.UseCaseConfig");
    }

    /* access modifiers changed from: protected */
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec) {
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getCurrentConfig(), streamSpec));
        notifyActive();
        return streamSpec;
    }

    /* access modifiers changed from: protected */
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        this.mSessionConfigBuilder.addImplementationOptions(config);
        updateSessionConfig(this.mSessionConfigBuilder.build());
        return getAttachedStreamSpec().toBuilder().setImplementationOptions(config).build();
    }

    public void onBind() {
        super.onBind();
        this.mVirtualCameraAdapter.bindChildren();
    }

    public void onUnbind() {
        super.onUnbind();
        clearPipeline();
        this.mVirtualCameraAdapter.unbindChildren();
    }

    public void onStateAttached() {
        super.onStateAttached();
        this.mVirtualCameraAdapter.notifyStateAttached();
    }

    public void onStateDetached() {
        super.onStateDetached();
        this.mVirtualCameraAdapter.notifyStateDetached();
    }

    public Set<UseCase> getChildren() {
        return this.mVirtualCameraAdapter.getChildren();
    }

    public Set<Integer> getSupportedEffectTargets() {
        HashSet hashSet = new HashSet();
        hashSet.add(3);
        return hashSet;
    }

    private SessionConfig createPipelineAndUpdateChildrenSpecs(String str, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec) {
        Threads.checkMainThread();
        CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(getCamera());
        SurfaceEdge surfaceEdge = new SurfaceEdge(3, 34, streamSpec, getSensorToBufferTransformMatrix(), cameraInternal.getHasTransform(), (Rect) Objects.requireNonNull(getCropRect(streamSpec.getResolution())), getRelativeRotation(cameraInternal), -1, isMirroringRequired(cameraInternal));
        this.mCameraEdge = surfaceEdge;
        this.mSharingInputEdge = getSharingInputEdge(surfaceEdge, cameraInternal);
        this.mSharingNode = getSharingNode(cameraInternal, streamSpec);
        Map<UseCase, SurfaceProcessorNode.OutConfig> childrenOutConfigs = this.mVirtualCameraAdapter.getChildrenOutConfigs(this.mSharingInputEdge, getTargetRotationInternal(), getViewPortCropRect() != null);
        SurfaceProcessorNode.Out transform = this.mSharingNode.transform(SurfaceProcessorNode.In.of(this.mSharingInputEdge, new ArrayList(childrenOutConfigs.values())));
        HashMap hashMap = new HashMap();
        for (Map.Entry next : childrenOutConfigs.entrySet()) {
            hashMap.put((UseCase) next.getKey(), (SurfaceEdge) transform.get(next.getValue()));
        }
        this.mVirtualCameraAdapter.setChildrenEdges(hashMap);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(useCaseConfig, streamSpec.getResolution());
        propagateChildrenCamera2Interop(streamSpec.getResolution(), createFrom);
        createFrom.addSurface(this.mCameraEdge.getDeferrableSurface(), streamSpec.getDynamicRange(), (String) null, -1);
        createFrom.addRepeatingCameraCaptureCallback(this.mVirtualCameraAdapter.getParentMetadataCallback());
        if (streamSpec.getImplementationOptions() != null) {
            createFrom.addImplementationOptions(streamSpec.getImplementationOptions());
        }
        addCameraErrorListener(createFrom, str, useCaseConfig, streamSpec);
        this.mSessionConfigBuilder = createFrom;
        return createFrom.build();
    }

    private void propagateChildrenCamera2Interop(Size size, SessionConfig.Builder builder) {
        for (UseCase currentConfig : getChildren()) {
            SessionConfig build = SessionConfig.Builder.createFrom(currentConfig.getCurrentConfig(), size).build();
            builder.addAllRepeatingCameraCaptureCallbacks(build.getRepeatingCameraCaptureCallbacks());
            builder.addAllCameraCaptureCallbacks(build.getSingleCameraCaptureCallbacks());
            builder.addAllSessionStateCallbacks(build.getSessionStateCallbacks());
            builder.addAllDeviceStateCallbacks(build.getDeviceStateCallbacks());
            builder.addImplementationOptions(build.getImplementationOptions());
        }
    }

    private SurfaceEdge getSharingInputEdge(SurfaceEdge surfaceEdge, CameraInternal cameraInternal) {
        if (getEffect() == null || getEffect().getTransformation() == 2 || getEffect().getOutputOption() == 1) {
            return surfaceEdge;
        }
        this.mEffectNode = new SurfaceProcessorNode(cameraInternal, getEffect().createSurfaceProcessorInternal());
        int rotationAppliedByEffect = getRotationAppliedByEffect();
        Rect cropRectAppliedByEffect = getCropRectAppliedByEffect(surfaceEdge);
        SurfaceProcessorNode.OutConfig of = SurfaceProcessorNode.OutConfig.of(surfaceEdge.getTargets(), surfaceEdge.getFormat(), cropRectAppliedByEffect, TransformUtils.getRotatedSize(cropRectAppliedByEffect, rotationAppliedByEffect), rotationAppliedByEffect, getMirroringAppliedByEffect(), true);
        return (SurfaceEdge) Objects.requireNonNull((SurfaceEdge) this.mEffectNode.transform(SurfaceProcessorNode.In.of(surfaceEdge, Collections.singletonList(of))).get(of));
    }

    private SurfaceProcessorNode getSharingNode(CameraInternal cameraInternal, StreamSpec streamSpec) {
        if (getEffect() == null || getEffect().getOutputOption() != 1) {
            return new SurfaceProcessorNode(cameraInternal, DefaultSurfaceProcessor.Factory.newInstance(streamSpec.getDynamicRange()));
        }
        SurfaceProcessorNode surfaceProcessorNode = new SurfaceProcessorNode(cameraInternal, getEffect().createSurfaceProcessorInternal());
        this.mEffectNode = surfaceProcessorNode;
        return surfaceProcessorNode;
    }

    private int getRotationAppliedByEffect() {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() == 1) {
            return getRelativeRotation((CameraInternal) Preconditions.checkNotNull(getCamera()));
        }
        return 0;
    }

    private boolean getMirroringAppliedByEffect() {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() != 1) {
            return false;
        }
        CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(getCamera());
        if (!cameraInternal.isFrontFacing() || !cameraInternal.getHasTransform()) {
            return false;
        }
        return true;
    }

    private Rect getCropRectAppliedByEffect(SurfaceEdge surfaceEdge) {
        if (((CameraEffect) Preconditions.checkNotNull(getEffect())).getTransformation() == 1) {
            return TransformUtils.sizeToRect(surfaceEdge.getStreamSpec().getResolution());
        }
        return surfaceEdge.getCropRect();
    }

    private void addCameraErrorListener(SessionConfig.Builder builder, String str, UseCaseConfig<?> useCaseConfig, StreamSpec streamSpec) {
        builder.addErrorListener(new StreamSharing$$ExternalSyntheticLambda0(this, str, useCaseConfig, streamSpec));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$addCameraErrorListener$1$androidx-camera-core-streamsharing-StreamSharing  reason: not valid java name */
    public /* synthetic */ void m206lambda$addCameraErrorListener$1$androidxcameracorestreamsharingStreamSharing(String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            updateSessionConfig(createPipelineAndUpdateChildrenSpecs(str, useCaseConfig, streamSpec));
            notifyReset();
            this.mVirtualCameraAdapter.resetChildren();
        }
    }

    private void clearPipeline() {
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        SurfaceEdge surfaceEdge2 = this.mSharingInputEdge;
        if (surfaceEdge2 != null) {
            surfaceEdge2.close();
            this.mSharingInputEdge = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mSharingNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mSharingNode = null;
        }
        SurfaceProcessorNode surfaceProcessorNode2 = this.mEffectNode;
        if (surfaceProcessorNode2 != null) {
            surfaceProcessorNode2.release();
            this.mEffectNode = null;
        }
    }

    private Rect getCropRect(Size size) {
        if (getViewPortCropRect() != null) {
            return getViewPortCropRect();
        }
        return new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    public static List<UseCaseConfigFactory.CaptureType> getCaptureTypes(UseCase useCase) {
        ArrayList arrayList = new ArrayList();
        if (isStreamSharing(useCase)) {
            for (UseCase currentConfig : ((StreamSharing) useCase).getChildren()) {
                arrayList.add(currentConfig.getCurrentConfig().getCaptureType());
            }
        } else {
            arrayList.add(useCase.getCurrentConfig().getCaptureType());
        }
        return arrayList;
    }

    public static boolean isStreamSharing(UseCase useCase) {
        return useCase instanceof StreamSharing;
    }
}
