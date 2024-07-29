package androidx.camera.core;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Range;
import android.util.Size;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.utils.UseCaseConfigUtil;
import androidx.camera.core.processing.TargetUtils;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class UseCase {
    private SessionConfig mAttachedSessionConfig = SessionConfig.defaultEmptySessionConfig();
    private StreamSpec mAttachedStreamSpec;
    private CameraInternal mCamera;
    private UseCaseConfig<?> mCameraConfig;
    private final Object mCameraLock = new Object();
    private UseCaseConfig<?> mCurrentConfig;
    private CameraEffect mEffect;
    private UseCaseConfig<?> mExtendedConfig;
    private String mPhysicalCameraId;
    private Matrix mSensorToBufferTransformMatrix = new Matrix();
    private State mState = State.INACTIVE;
    private final Set<StateChangeCallback> mStateChangeCallbacks = new HashSet();
    private UseCaseConfig<?> mUseCaseConfig;
    private Rect mViewPortCropRect;

    enum State {
        ACTIVE,
        INACTIVE
    }

    public interface StateChangeCallback {
        void onUseCaseActive(UseCase useCase);

        void onUseCaseInactive(UseCase useCase);

        void onUseCaseReset(UseCase useCase);

        void onUseCaseUpdated(UseCase useCase);
    }

    /* access modifiers changed from: protected */
    public UseCaseConfig<?> getAppConfig() {
        return this.mUseCaseConfig;
    }

    public StreamSpec getAttachedStreamSpec() {
        return this.mAttachedStreamSpec;
    }

    public UseCaseConfig<?> getCurrentConfig() {
        return this.mCurrentConfig;
    }

    public abstract UseCaseConfig<?> getDefaultConfig(boolean z, UseCaseConfigFactory useCaseConfigFactory);

    public CameraEffect getEffect() {
        return this.mEffect;
    }

    public String getPhysicalCameraId() {
        return this.mPhysicalCameraId;
    }

    public Matrix getSensorToBufferTransformMatrix() {
        return this.mSensorToBufferTransformMatrix;
    }

    public SessionConfig getSessionConfig() {
        return this.mAttachedSessionConfig;
    }

    public abstract UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(Config config);

    public Rect getViewPortCropRect() {
        return this.mViewPortCropRect;
    }

    public void onBind() {
    }

    public void onCameraControlReady() {
    }

    public void onStateAttached() {
    }

    public void onStateDetached() {
    }

    /* access modifiers changed from: protected */
    public StreamSpec onSuggestedStreamSpecUpdated(StreamSpec streamSpec) {
        return streamSpec;
    }

    public void onUnbind() {
    }

    public void setPhysicalCameraId(String str) {
        this.mPhysicalCameraId = str;
    }

    public void setViewPortCropRect(Rect rect) {
        this.mViewPortCropRect = rect;
    }

    protected UseCase(UseCaseConfig<?> useCaseConfig) {
        this.mUseCaseConfig = useCaseConfig;
        this.mCurrentConfig = useCaseConfig;
    }

    public UseCaseConfig<?> mergeConfigs(CameraInfoInternal cameraInfoInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        MutableOptionsBundle mutableOptionsBundle;
        if (useCaseConfig2 != null) {
            mutableOptionsBundle = MutableOptionsBundle.from(useCaseConfig2);
            mutableOptionsBundle.removeOption(TargetConfig.OPTION_TARGET_NAME);
        } else {
            mutableOptionsBundle = MutableOptionsBundle.create();
        }
        if ((this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO) || this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION)) && mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            mutableOptionsBundle.removeOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR);
        }
        if (this.mUseCaseConfig.containsOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR) && mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_MAX_RESOLUTION) && ((ResolutionSelector) this.mUseCaseConfig.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)).getResolutionStrategy() != null) {
            mutableOptionsBundle.removeOption(ImageOutputConfig.OPTION_MAX_RESOLUTION);
        }
        for (Config.Option<?> mergeOptionValue : this.mUseCaseConfig.listOptions()) {
            Config.CC.mergeOptionValue(mutableOptionsBundle, mutableOptionsBundle, this.mUseCaseConfig, mergeOptionValue);
        }
        if (useCaseConfig != null) {
            for (Config.Option next : useCaseConfig.listOptions()) {
                if (!next.getId().equals(TargetConfig.OPTION_TARGET_NAME.getId())) {
                    Config.CC.mergeOptionValue(mutableOptionsBundle, mutableOptionsBundle, useCaseConfig, next);
                }
            }
        }
        if (mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION) && mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO)) {
            mutableOptionsBundle.removeOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO);
        }
        if (mutableOptionsBundle.containsOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR) && ((ResolutionSelector) mutableOptionsBundle.retrieveOption(ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)).getAllowedResolutionMode() != 0) {
            mutableOptionsBundle.insertOption(UseCaseConfig.OPTION_ZSL_DISABLED, true);
        }
        return onMergeConfig(cameraInfoInternal, getUseCaseConfigBuilder(mutableOptionsBundle));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [androidx.camera.core.impl.UseCaseConfig$Builder, androidx.camera.core.impl.UseCaseConfig$Builder<?, ?, ?>] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.UseCaseConfig<?> onMergeConfig(androidx.camera.core.impl.CameraInfoInternal r1, androidx.camera.core.impl.UseCaseConfig.Builder<?, ?, ?> r2) {
        /*
            r0 = this;
            androidx.camera.core.impl.UseCaseConfig r1 = r2.getUseCaseConfig()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.UseCase.onMergeConfig(androidx.camera.core.impl.CameraInfoInternal, androidx.camera.core.impl.UseCaseConfig$Builder):androidx.camera.core.impl.UseCaseConfig");
    }

    public static int snapToSurfaceRotation(int i) {
        Preconditions.checkArgumentInRange(i, 0, 359, "orientation");
        if (i >= 315 || i < 45) {
            return 0;
        }
        if (i >= 225) {
            return 1;
        }
        return i >= 135 ? 2 : 3;
    }

    /* access modifiers changed from: protected */
    public boolean setTargetRotationInternal(int i) {
        int targetRotation = ((ImageOutputConfig) getCurrentConfig()).getTargetRotation(-1);
        if (targetRotation != -1 && targetRotation == i) {
            return false;
        }
        UseCaseConfig.Builder useCaseConfigBuilder = getUseCaseConfigBuilder(this.mUseCaseConfig);
        UseCaseConfigUtil.updateTargetRotationAndRelatedConfigs(useCaseConfigBuilder, i);
        this.mUseCaseConfig = useCaseConfigBuilder.getUseCaseConfig();
        CameraInternal camera = getCamera();
        if (camera == null) {
            this.mCurrentConfig = this.mUseCaseConfig;
            return true;
        }
        this.mCurrentConfig = mergeConfigs(camera.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        return true;
    }

    /* access modifiers changed from: protected */
    public int getTargetRotationInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getTargetRotation(0);
    }

    /* access modifiers changed from: protected */
    public Range<Integer> getTargetFrameRateInternal() {
        return this.mCurrentConfig.getTargetFrameRate(StreamSpec.FRAME_RATE_RANGE_UNSPECIFIED);
    }

    /* access modifiers changed from: protected */
    public int getMirrorModeInternal() {
        return ((ImageOutputConfig) this.mCurrentConfig).getMirrorMode(-1);
    }

    public boolean isMirroringRequired(CameraInternal cameraInternal) {
        int mirrorModeInternal = getMirrorModeInternal();
        if (mirrorModeInternal == -1 || mirrorModeInternal == 0) {
            return false;
        }
        if (mirrorModeInternal == 1) {
            return true;
        }
        if (mirrorModeInternal == 2) {
            return cameraInternal.isFrontFacing();
        }
        throw new AssertionError("Unknown mirrorMode: " + mirrorModeInternal);
    }

    /* access modifiers changed from: protected */
    public int getAppTargetRotation() {
        return ((ImageOutputConfig) this.mCurrentConfig).getAppTargetRotation(-1);
    }

    /* access modifiers changed from: protected */
    public int getRelativeRotation(CameraInternal cameraInternal) {
        return getRelativeRotation(cameraInternal, false);
    }

    /* access modifiers changed from: protected */
    public int getRelativeRotation(CameraInternal cameraInternal, boolean z) {
        int sensorRotationDegrees = cameraInternal.getCameraInfoInternal().getSensorRotationDegrees(getTargetRotationInternal());
        return (cameraInternal.getHasTransform() || !z) ? sensorRotationDegrees : TransformUtils.within360(-sensorRotationDegrees);
    }

    /* access modifiers changed from: protected */
    public void updateSessionConfig(SessionConfig sessionConfig) {
        this.mAttachedSessionConfig = sessionConfig;
        for (DeferrableSurface next : sessionConfig.getSurfaces()) {
            if (next.getContainerClass() == null) {
                next.setContainerClass(getClass());
            }
        }
    }

    private void addStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.add(stateChangeCallback);
    }

    private void removeStateChangeCallback(StateChangeCallback stateChangeCallback) {
        this.mStateChangeCallbacks.remove(stateChangeCallback);
    }

    /* access modifiers changed from: protected */
    public final void notifyActive() {
        this.mState = State.ACTIVE;
        notifyState();
    }

    /* access modifiers changed from: protected */
    public final void notifyInactive() {
        this.mState = State.INACTIVE;
        notifyState();
    }

    /* access modifiers changed from: protected */
    public final void notifyUpdated() {
        for (StateChangeCallback onUseCaseUpdated : this.mStateChangeCallbacks) {
            onUseCaseUpdated.onUseCaseUpdated(this);
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyReset() {
        for (StateChangeCallback onUseCaseReset : this.mStateChangeCallbacks) {
            onUseCaseReset.onUseCaseReset(this);
        }
    }

    public final void notifyState() {
        int ordinal = this.mState.ordinal();
        if (ordinal == 0) {
            for (StateChangeCallback onUseCaseActive : this.mStateChangeCallbacks) {
                onUseCaseActive.onUseCaseActive(this);
            }
        } else if (ordinal == 1) {
            for (StateChangeCallback onUseCaseInactive : this.mStateChangeCallbacks) {
                onUseCaseInactive.onUseCaseInactive(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public String getCameraId() {
        CameraInternal camera = getCamera();
        return ((CameraInternal) Preconditions.checkNotNull(camera, "No camera attached to use case: " + this)).getCameraInfoInternal().getCameraId();
    }

    /* access modifiers changed from: protected */
    public boolean isCurrentCamera(String str) {
        if (getCamera() == null) {
            return false;
        }
        return Objects.equals(str, getCameraId());
    }

    public String getName() {
        UseCaseConfig<?> useCaseConfig = this.mCurrentConfig;
        return (String) Objects.requireNonNull(useCaseConfig.getTargetName("<UnknownUseCase-" + hashCode() + ">"));
    }

    public CameraInternal getCamera() {
        CameraInternal cameraInternal;
        synchronized (this.mCameraLock) {
            cameraInternal = this.mCamera;
        }
        return cameraInternal;
    }

    public Size getAttachedSurfaceResolution() {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.getResolution();
        }
        return null;
    }

    public void updateSuggestedStreamSpec(StreamSpec streamSpec) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecUpdated(streamSpec);
    }

    public void updateSuggestedStreamSpecImplementationOptions(Config config) {
        this.mAttachedStreamSpec = onSuggestedStreamSpecImplementationOptionsUpdated(config);
    }

    /* access modifiers changed from: protected */
    public StreamSpec onSuggestedStreamSpecImplementationOptionsUpdated(Config config) {
        StreamSpec streamSpec = this.mAttachedStreamSpec;
        if (streamSpec != null) {
            return streamSpec.toBuilder().setImplementationOptions(config).build();
        }
        throw new UnsupportedOperationException("Attempt to update the implementation options for a use case without attached stream specifications.");
    }

    public final void bindToCamera(CameraInternal cameraInternal, UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
        synchronized (this.mCameraLock) {
            this.mCamera = cameraInternal;
            addStateChangeCallback(cameraInternal);
        }
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
        this.mCurrentConfig = mergeConfigs(cameraInternal.getCameraInfoInternal(), this.mExtendedConfig, this.mCameraConfig);
        onBind();
    }

    public final void unbindFromCamera(CameraInternal cameraInternal) {
        onUnbind();
        synchronized (this.mCameraLock) {
            Preconditions.checkArgument(cameraInternal == this.mCamera);
            removeStateChangeCallback(this.mCamera);
            this.mCamera = null;
        }
        this.mAttachedStreamSpec = null;
        this.mViewPortCropRect = null;
        this.mCurrentConfig = this.mUseCaseConfig;
        this.mExtendedConfig = null;
        this.mCameraConfig = null;
    }

    /* access modifiers changed from: protected */
    public CameraControlInternal getCameraControl() {
        synchronized (this.mCameraLock) {
            CameraInternal cameraInternal = this.mCamera;
            if (cameraInternal == null) {
                CameraControlInternal cameraControlInternal = CameraControlInternal.DEFAULT_EMPTY_INSTANCE;
                return cameraControlInternal;
            }
            CameraControlInternal cameraControlInternal2 = cameraInternal.getCameraControlInternal();
            return cameraControlInternal2;
        }
    }

    public void setEffect(CameraEffect cameraEffect) {
        Preconditions.checkArgument(cameraEffect == null || isEffectTargetsSupported(cameraEffect.getTargets()));
        this.mEffect = cameraEffect;
    }

    public void setSensorToBufferTransformMatrix(Matrix matrix) {
        this.mSensorToBufferTransformMatrix = new Matrix(matrix);
    }

    public int getImageFormat() {
        return this.mCurrentConfig.getInputFormat();
    }

    /* access modifiers changed from: protected */
    public ResolutionInfo getResolutionInfoInternal() {
        CameraInternal camera = getCamera();
        Size attachedSurfaceResolution = getAttachedSurfaceResolution();
        if (camera == null || attachedSurfaceResolution == null) {
            return null;
        }
        Rect viewPortCropRect = getViewPortCropRect();
        if (viewPortCropRect == null) {
            viewPortCropRect = new Rect(0, 0, attachedSurfaceResolution.getWidth(), attachedSurfaceResolution.getHeight());
        }
        return new ResolutionInfo(attachedSurfaceResolution, viewPortCropRect, getRelativeRotation(camera));
    }

    /* access modifiers changed from: protected */
    public Set<Integer> getSupportedEffectTargets() {
        return Collections.emptySet();
    }

    public boolean isEffectTargetsSupported(int i) {
        for (Integer intValue : getSupportedEffectTargets()) {
            if (TargetUtils.isSuperset(i, intValue.intValue())) {
                return true;
            }
        }
        return false;
    }
}
