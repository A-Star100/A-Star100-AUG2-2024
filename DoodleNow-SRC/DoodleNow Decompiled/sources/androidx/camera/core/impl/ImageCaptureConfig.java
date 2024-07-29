package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class ImageCaptureConfig implements UseCaseConfig<ImageCapture>, ImageOutputConfig, IoConfig {
    public static final Config.Option<Integer> OPTION_BUFFER_FORMAT = Config.Option.create("camerax.core.imageCapture.bufferFormat", Integer.class);
    public static final Config.Option<CaptureBundle> OPTION_CAPTURE_BUNDLE = Config.Option.create("camerax.core.imageCapture.captureBundle", CaptureBundle.class);
    public static final Config.Option<Integer> OPTION_FLASH_MODE = Config.Option.create("camerax.core.imageCapture.flashMode", Integer.TYPE);
    public static final Config.Option<Integer> OPTION_FLASH_TYPE = Config.Option.create("camerax.core.imageCapture.flashType", Integer.TYPE);
    public static final Config.Option<Integer> OPTION_IMAGE_CAPTURE_MODE = Config.Option.create("camerax.core.imageCapture.captureMode", Integer.TYPE);
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create("camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
    public static final Config.Option<Integer> OPTION_JPEG_COMPRESSION_QUALITY = Config.Option.create("camerax.core.imageCapture.jpegCompressionQuality", Integer.TYPE);
    public static final Config.Option<Integer> OPTION_MAX_CAPTURE_STAGES = Config.Option.create("camerax.core.imageCapture.maxCaptureStages", Integer.class);
    public static final Config.Option<Integer> OPTION_OUTPUT_FORMAT = Config.Option.create("camerax.core.imageCapture.outputFormat", Integer.class);
    public static final Config.Option<Boolean> OPTION_POSTVIEW_ENABLED = Config.Option.create("camerax.core.useCase.isPostviewEnabled", Boolean.class);
    public static final Config.Option<ResolutionSelector> OPTION_POSTVIEW_RESOLUTION_SELECTOR = Config.Option.create("camerax.core.useCase.postviewResolutionSelector", ResolutionSelector.class);
    public static final Config.Option<ImageCapture.ScreenFlash> OPTION_SCREEN_FLASH = Config.Option.create("camerax.core.imageCapture.screenFlash", ImageCapture.ScreenFlash.class);
    public static final Config.Option<Boolean> OPTION_USE_SOFTWARE_JPEG_ENCODER = Config.Option.create("camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
    private final OptionsBundle mConfig;

    public /* synthetic */ boolean containsOption(Config.Option option) {
        return ReadableConfig.CC.$default$containsOption(this, option);
    }

    public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        ReadableConfig.CC.$default$findOptions(this, str, optionMatcher);
    }

    public /* synthetic */ int getAppTargetRotation(int i) {
        return ImageOutputConfig.CC.$default$getAppTargetRotation(this, i);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        return UseCaseConfig.CC.$default$getCaptureOptionUnpacker(this, optionUnpacker);
    }

    public /* synthetic */ UseCaseConfigFactory.CaptureType getCaptureType() {
        return UseCaseConfig.CC.$default$getCaptureType(this);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public /* synthetic */ List getCustomOrderedResolutions() {
        return ImageOutputConfig.CC.$default$getCustomOrderedResolutions(this);
    }

    public /* synthetic */ List getCustomOrderedResolutions(List list) {
        return ImageOutputConfig.CC.$default$getCustomOrderedResolutions(this, list);
    }

    public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
        return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this);
    }

    public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
        return UseCaseConfig.CC.$default$getDefaultCaptureConfig(this, captureConfig);
    }

    public /* synthetic */ Size getDefaultResolution() {
        return ImageOutputConfig.CC.$default$getDefaultResolution(this);
    }

    public /* synthetic */ Size getDefaultResolution(Size size) {
        return ImageOutputConfig.CC.$default$getDefaultResolution(this, size);
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

    public /* synthetic */ Size getMaxResolution() {
        return ImageOutputConfig.CC.$default$getMaxResolution(this);
    }

    public /* synthetic */ Size getMaxResolution(Size size) {
        return ImageOutputConfig.CC.$default$getMaxResolution(this, size);
    }

    public /* synthetic */ int getMirrorMode(int i) {
        return ImageOutputConfig.CC.$default$getMirrorMode(this, i);
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

    public /* synthetic */ ResolutionSelector getResolutionSelector() {
        return ImageOutputConfig.CC.$default$getResolutionSelector(this);
    }

    public /* synthetic */ ResolutionSelector getResolutionSelector(ResolutionSelector resolutionSelector) {
        return ImageOutputConfig.CC.$default$getResolutionSelector(this, resolutionSelector);
    }

    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this);
    }

    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        return UseCaseConfig.CC.$default$getSessionOptionUnpacker(this, optionUnpacker);
    }

    public /* synthetic */ List getSupportedResolutions() {
        return ImageOutputConfig.CC.$default$getSupportedResolutions(this);
    }

    public /* synthetic */ List getSupportedResolutions(List list) {
        return ImageOutputConfig.CC.$default$getSupportedResolutions(this, list);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority() {
        return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority(int i) {
        return UseCaseConfig.CC.$default$getSurfaceOccupancyPriority(this, i);
    }

    public /* synthetic */ int getTargetAspectRatio() {
        return ImageOutputConfig.CC.$default$getTargetAspectRatio(this);
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

    public /* synthetic */ Size getTargetResolution() {
        return ImageOutputConfig.CC.$default$getTargetResolution(this);
    }

    public /* synthetic */ Size getTargetResolution(Size size) {
        return ImageOutputConfig.CC.$default$getTargetResolution(this, size);
    }

    public /* synthetic */ int getTargetRotation() {
        return ImageOutputConfig.CC.$default$getTargetRotation(this);
    }

    public /* synthetic */ int getTargetRotation(int i) {
        return ImageOutputConfig.CC.$default$getTargetRotation(this, i);
    }

    public /* synthetic */ int getVideoStabilizationMode() {
        return UseCaseConfig.CC.$default$getVideoStabilizationMode(this);
    }

    public /* synthetic */ boolean hasDynamicRange() {
        return ImageInputConfig.CC.$default$hasDynamicRange(this);
    }

    public /* synthetic */ boolean hasTargetAspectRatio() {
        return ImageOutputConfig.CC.$default$hasTargetAspectRatio(this);
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

    public ImageCaptureConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public boolean hasCaptureMode() {
        return containsOption(OPTION_IMAGE_CAPTURE_MODE);
    }

    public int getCaptureMode() {
        return ((Integer) retrieveOption(OPTION_IMAGE_CAPTURE_MODE)).intValue();
    }

    public int getFlashMode(int i) {
        return ((Integer) retrieveOption(OPTION_FLASH_MODE, Integer.valueOf(i))).intValue();
    }

    public int getFlashMode() {
        return ((Integer) retrieveOption(OPTION_FLASH_MODE)).intValue();
    }

    public CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        return (CaptureBundle) retrieveOption(OPTION_CAPTURE_BUNDLE, captureBundle);
    }

    public CaptureBundle getCaptureBundle() {
        return (CaptureBundle) retrieveOption(OPTION_CAPTURE_BUNDLE);
    }

    public Integer getBufferFormat(Integer num) {
        return (Integer) retrieveOption(OPTION_BUFFER_FORMAT, num);
    }

    public Integer getBufferFormat() {
        return (Integer) retrieveOption(OPTION_BUFFER_FORMAT);
    }

    public int getInputFormat() {
        return ((Integer) retrieveOption(OPTION_INPUT_FORMAT)).intValue();
    }

    public int getMaxCaptureStages(int i) {
        return ((Integer) retrieveOption(OPTION_MAX_CAPTURE_STAGES, Integer.valueOf(i))).intValue();
    }

    public int getMaxCaptureStages() {
        return ((Integer) retrieveOption(OPTION_MAX_CAPTURE_STAGES)).intValue();
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return (ImageReaderProxyProvider) retrieveOption(OPTION_IMAGE_READER_PROXY_PROVIDER, (Object) null);
    }

    public boolean isSoftwareJpegEncoderRequested() {
        return ((Boolean) retrieveOption(OPTION_USE_SOFTWARE_JPEG_ENCODER, false)).booleanValue();
    }

    public int getFlashType(int i) {
        return ((Integer) retrieveOption(OPTION_FLASH_TYPE, Integer.valueOf(i))).intValue();
    }

    public int getFlashType() {
        return ((Integer) retrieveOption(OPTION_FLASH_TYPE)).intValue();
    }

    public int getJpegQuality(int i) {
        return ((Integer) retrieveOption(OPTION_JPEG_COMPRESSION_QUALITY, Integer.valueOf(i))).intValue();
    }

    public int getJpegQuality() {
        return ((Integer) retrieveOption(OPTION_JPEG_COMPRESSION_QUALITY)).intValue();
    }

    public ImageCapture.ScreenFlash getScreenFlash() {
        return (ImageCapture.ScreenFlash) retrieveOption(OPTION_SCREEN_FLASH, (Object) null);
    }

    public ResolutionSelector getPostviewResolutionSelector() {
        return (ResolutionSelector) retrieveOption(OPTION_POSTVIEW_RESOLUTION_SELECTOR, (Object) null);
    }

    public boolean isPostviewEnabled() {
        return ((Boolean) retrieveOption(OPTION_POSTVIEW_ENABLED, false)).booleanValue();
    }

    public Executor getIoExecutor(Executor executor) {
        return (Executor) retrieveOption(OPTION_IO_EXECUTOR, executor);
    }

    public Executor getIoExecutor() {
        return (Executor) retrieveOption(OPTION_IO_EXECUTOR);
    }
}
