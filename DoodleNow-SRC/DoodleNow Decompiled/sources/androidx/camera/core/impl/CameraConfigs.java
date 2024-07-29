package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import java.util.Set;

public class CameraConfigs {
    private static final CameraConfig DEFAULT_CAMERA_CONFIG = new DefaultCameraConfig();

    public static CameraConfig defaultConfig() {
        return DEFAULT_CAMERA_CONFIG;
    }

    static final class DefaultCameraConfig implements CameraConfig {
        private final Identifier mIdentifier = Identifier.create(new Object());

        public /* synthetic */ boolean containsOption(Config.Option option) {
            return ReadableConfig.CC.$default$containsOption(this, option);
        }

        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            ReadableConfig.CC.$default$findOptions(this, str, optionMatcher);
        }

        public Identifier getCompatibilityId() {
            return this.mIdentifier;
        }

        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return ReadableConfig.CC.$default$getOptionPriority(this, option);
        }

        public /* synthetic */ Set getPriorities(Config.Option option) {
            return ReadableConfig.CC.$default$getPriorities(this, option);
        }

        public /* synthetic */ SessionProcessor getSessionProcessor() {
            return CameraConfig.CC.$default$getSessionProcessor(this);
        }

        public /* synthetic */ SessionProcessor getSessionProcessor(SessionProcessor sessionProcessor) {
            return CameraConfig.CC.$default$getSessionProcessor(this, sessionProcessor);
        }

        public /* synthetic */ int getUseCaseCombinationRequiredRule() {
            return CameraConfig.CC.$default$getUseCaseCombinationRequiredRule(this);
        }

        public /* synthetic */ UseCaseConfigFactory getUseCaseConfigFactory() {
            return CameraConfig.CC.$default$getUseCaseConfigFactory(this);
        }

        public /* synthetic */ boolean isCaptureProcessProgressSupported() {
            return CameraConfig.CC.$default$isCaptureProcessProgressSupported(this);
        }

        public /* synthetic */ boolean isPostviewSupported() {
            return CameraConfig.CC.$default$isPostviewSupported(this);
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

        DefaultCameraConfig() {
        }

        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }
    }

    private CameraConfigs() {
    }
}
