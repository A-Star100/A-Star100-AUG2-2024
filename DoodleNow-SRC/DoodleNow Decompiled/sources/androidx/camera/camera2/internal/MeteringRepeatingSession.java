package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.workaround.SupportedRepeatingSurfaceSize;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.TargetConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.UUID;

class MeteringRepeatingSession {
    private static final int IMAGE_FORMAT = 34;
    private static final String TAG = "MeteringRepeating";
    private final MeteringRepeatingConfig mConfigWithDefaults = new MeteringRepeatingConfig();
    private DeferrableSurface mDeferrableSurface;
    private final Size mMeteringRepeatingSize;
    private SessionConfig mSessionConfig;
    private final SupportedRepeatingSurfaceSize mSupportedRepeatingSurfaceSize = new SupportedRepeatingSurfaceSize();
    private final SurfaceResetCallback mSurfaceResetCallback;

    interface SurfaceResetCallback {
        void onSurfaceReset();
    }

    /* access modifiers changed from: package-private */
    public Size getMeteringRepeatingSize() {
        return this.mMeteringRepeatingSize;
    }

    /* access modifiers changed from: package-private */
    public String getName() {
        return TAG;
    }

    /* access modifiers changed from: package-private */
    public SessionConfig getSessionConfig() {
        return this.mSessionConfig;
    }

    /* access modifiers changed from: package-private */
    public UseCaseConfig<?> getUseCaseConfig() {
        return this.mConfigWithDefaults;
    }

    MeteringRepeatingSession(CameraCharacteristicsCompat cameraCharacteristicsCompat, DisplayInfoManager displayInfoManager, SurfaceResetCallback surfaceResetCallback) {
        this.mSurfaceResetCallback = surfaceResetCallback;
        Size properPreviewSize = getProperPreviewSize(cameraCharacteristicsCompat, displayInfoManager);
        this.mMeteringRepeatingSize = properPreviewSize;
        Logger.d(TAG, "MeteringSession SurfaceTexture size: " + properPreviewSize);
        this.mSessionConfig = createSessionConfig();
    }

    /* access modifiers changed from: package-private */
    public SessionConfig createSessionConfig() {
        final SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(this.mMeteringRepeatingSize.getWidth(), this.mMeteringRepeatingSize.getHeight());
        final Surface surface = new Surface(surfaceTexture);
        SessionConfig.Builder createFrom = SessionConfig.Builder.createFrom(this.mConfigWithDefaults, this.mMeteringRepeatingSize);
        createFrom.setTemplateType(1);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        this.mDeferrableSurface = immediateSurface;
        Futures.addCallback(immediateSurface.getTerminationFuture(), new FutureCallback<Void>() {
            public void onSuccess(Void voidR) {
                surface.release();
                surfaceTexture.release();
            }

            public void onFailure(Throwable th) {
                throw new IllegalStateException("Future should never fail. Did it get completed by GC?", th);
            }
        }, CameraXExecutors.directExecutor());
        createFrom.addSurface(this.mDeferrableSurface);
        createFrom.addErrorListener(new MeteringRepeatingSession$$ExternalSyntheticLambda0(this));
        return createFrom.build();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createSessionConfig$0$androidx-camera-camera2-internal-MeteringRepeatingSession  reason: not valid java name */
    public /* synthetic */ void m76lambda$createSessionConfig$0$androidxcameracamera2internalMeteringRepeatingSession(SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        this.mSessionConfig = createSessionConfig();
        SurfaceResetCallback surfaceResetCallback = this.mSurfaceResetCallback;
        if (surfaceResetCallback != null) {
            surfaceResetCallback.onSurfaceReset();
        }
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        Logger.d(TAG, "MeteringRepeating clear!");
        DeferrableSurface deferrableSurface = this.mDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mDeferrableSurface = null;
    }

    private static class MeteringRepeatingConfig implements UseCaseConfig<UseCase> {
        private final Config mConfig;

        public /* synthetic */ boolean containsOption(Config.Option option) {
            return ReadableConfig.CC.$default$containsOption(this, option);
        }

        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            ReadableConfig.CC.$default$findOptions(this, str, optionMatcher);
        }

        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this);
        }

        public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
            return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this, optionUnpacker);
        }

        public Config getConfig() {
            return this.mConfig;
        }

        public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this);
        }

        public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
            return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this, captureConfig);
        }

        public /* synthetic */ SessionConfig getDefaultSessionConfig() {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this);
        }

        public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
            return UseCaseConfig.CC.$default$getDefaultSessionConfig(this, sessionConfig);
        }

        public /* synthetic */ DynamicRange getDynamicRange() {
            return ImageInputConfig.CC.$default$getDynamicRange(this);
        }

        public /* synthetic */ int getInputFormat() {
            return ImageInputConfig.CC.$default$getInputFormat(this);
        }

        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return ReadableConfig.CC.$default$getOptionPriority(this, option);
        }

        public /* synthetic */ int getPreviewStabilizationMode() {
            return UseCaseConfig.CC.$default$getPreviewStabilizationMode(this);
        }

        public /* synthetic */ Set getPriorities(Config.Option option) {
            return ReadableConfig.CC.$default$getPriorities(this, option);
        }

        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this);
        }

        public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
            return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this, optionUnpacker);
        }

        public /* synthetic */ int getSurfaceOccupancyPriority() {
            return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this);
        }

        public /* synthetic */ int getSurfaceOccupancyPriority(int i) {
            return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this, i);
        }

        public /* synthetic */ Class getTargetClass() {
            return TargetConfig.CC.$default$getTargetClass(this);
        }

        public /* synthetic */ Class getTargetClass(Class cls) {
            return TargetConfig.CC.$default$getTargetClass(this, cls);
        }

        public /* synthetic */ Range getTargetFrameRate() {
            return UseCaseConfig.CC.$default$getTargetFrameRate(this);
        }

        public /* synthetic */ Range getTargetFrameRate(Range range) {
            return UseCaseConfig.CC.$default$getTargetFrameRate(this, range);
        }

        public /* synthetic */ String getTargetName() {
            return TargetConfig.CC.$default$getTargetName(this);
        }

        public /* synthetic */ String getTargetName(String str) {
            return TargetConfig.CC.$default$getTargetName(this, str);
        }

        public /* synthetic */ int getVideoStabilizationMode() {
            return UseCaseConfig.CC.$default$getVideoStabilizationMode(this);
        }

        public /* synthetic */ boolean hasDynamicRange() {
            return ImageInputConfig.CC.$default$hasDynamicRange(this);
        }

        public /* synthetic */ boolean isHigResolutionDisabled(boolean z) {
            return UseCaseConfig.CC.$default$isHigResolutionDisabled(this, z);
        }

        public /* synthetic */ boolean isZslDisabled(boolean z) {
            return UseCaseConfig.CC.$default$isZslDisabled(this, z);
        }

        public /* synthetic */ Set listOptions() {
            return ReadableConfig.CC.$default$listOptions(this);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option) {
            return ReadableConfig.CC.$default$retrieveOption(this, option);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return ReadableConfig.CC.$default$retrieveOption(this, option, obj);
        }

        public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return ReadableConfig.CC.$default$retrieveOptionWithPriority(this, option, optionPriority);
        }

        MeteringRepeatingConfig() {
            MutableOptionsBundle create = MutableOptionsBundle.create();
            create.insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, new Camera2SessionOptionUnpacker());
            create.insertOption(OPTION_INPUT_FORMAT, 34);
            setTargetConfigs(create);
            this.mConfig = create;
        }

        public UseCaseConfigFactory.CaptureType getCaptureType() {
            return UseCaseConfigFactory.CaptureType.METERING_REPEATING;
        }

        private void setTargetConfigs(MutableOptionsBundle mutableOptionsBundle) {
            mutableOptionsBundle.insertOption(OPTION_TARGET_CLASS, MeteringRepeatingSession.class);
            mutableOptionsBundle.insertOption(OPTION_TARGET_NAME, MeteringRepeatingSession.class.getCanonicalName() + "-" + UUID.randomUUID());
        }
    }

    private Size getProperPreviewSize(CameraCharacteristicsCompat cameraCharacteristicsCompat, DisplayInfoManager displayInfoManager) {
        Size[] outputSizes = cameraCharacteristicsCompat.getStreamConfigurationMapCompat().getOutputSizes(34);
        if (outputSizes == null) {
            Logger.e(TAG, "Can not get output size list.");
            return new Size(0, 0);
        }
        Size[] supportedSizes = this.mSupportedRepeatingSurfaceSize.getSupportedSizes(outputSizes);
        List asList = Arrays.asList(supportedSizes);
        Collections.sort(asList, new MeteringRepeatingSession$$ExternalSyntheticLambda1());
        Size previewSize = displayInfoManager.getPreviewSize();
        long min = Math.min(((long) previewSize.getWidth()) * ((long) previewSize.getHeight()), 307200);
        int length = supportedSizes.length;
        Size size = null;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Size size2 = supportedSizes[i];
            int i2 = ((((long) size2.getWidth()) * ((long) size2.getHeight())) > min ? 1 : ((((long) size2.getWidth()) * ((long) size2.getHeight())) == min ? 0 : -1));
            if (i2 == 0) {
                return size2;
            }
            if (i2 <= 0) {
                i++;
                size = size2;
            } else if (size != null) {
                return size;
            }
        }
        return (Size) asList.get(0);
    }
}
