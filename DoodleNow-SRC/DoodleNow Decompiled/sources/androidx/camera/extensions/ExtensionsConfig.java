package androidx.camera.extensions;

import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Identifier;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseConfigFactory;
import java.util.Set;

class ExtensionsConfig implements CameraConfig {
    public static final Config.Option<Integer> OPTION_EXTENSION_MODE = Config.Option.create("camerax.extensions.extensionMode", Integer.TYPE);
    private final Config mConfig;

    public /* synthetic */ boolean containsOption(Config.Option option) {
        return ReadableConfig.CC.$default$containsOption(this, option);
    }

    public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
        ReadableConfig.CC.$default$findOptions(this, str, optionMatcher);
    }

    public Config getConfig() {
        return this.mConfig;
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

    ExtensionsConfig(Config config) {
        this.mConfig = config;
    }

    public int getExtensionMode() {
        return ((Integer) retrieveOption(OPTION_EXTENSION_MODE)).intValue();
    }

    public Identifier getCompatibilityId() {
        return (Identifier) retrieveOption(OPTION_COMPATIBILITY_ID);
    }

    static final class Builder implements CameraConfig.Builder<Builder> {
        private final MutableOptionsBundle mConfig = MutableOptionsBundle.create();

        Builder() {
        }

        /* access modifiers changed from: package-private */
        public ExtensionsConfig build() {
            return new ExtensionsConfig(this.mConfig);
        }

        public Builder setExtensionMode(int i) {
            this.mConfig.insertOption(ExtensionsConfig.OPTION_EXTENSION_MODE, Integer.valueOf(i));
            return this;
        }

        public Builder setUseCaseConfigFactory(UseCaseConfigFactory useCaseConfigFactory) {
            this.mConfig.insertOption(CameraConfig.OPTION_USECASE_CONFIG_FACTORY, useCaseConfigFactory);
            return this;
        }

        public Builder setCompatibilityId(Identifier identifier) {
            this.mConfig.insertOption(CameraConfig.OPTION_COMPATIBILITY_ID, identifier);
            return this;
        }

        public Builder setUseCaseCombinationRequiredRule(int i) {
            this.mConfig.insertOption(CameraConfig.OPTION_USE_CASE_COMBINATION_REQUIRED_RULE, Integer.valueOf(i));
            return this;
        }

        public Builder setSessionProcessor(SessionProcessor sessionProcessor) {
            this.mConfig.insertOption(CameraConfig.OPTION_SESSION_PROCESSOR, sessionProcessor);
            return this;
        }

        public Builder setZslDisabled(boolean z) {
            this.mConfig.insertOption(CameraConfig.OPTION_ZSL_DISABLED, Boolean.valueOf(z));
            return this;
        }

        public Builder setPostviewSupported(boolean z) {
            this.mConfig.insertOption(CameraConfig.OPTION_POSTVIEW_SUPPORTED, Boolean.valueOf(z));
            return this;
        }

        public Builder setCaptureProcessProgressSupported(boolean z) {
            this.mConfig.insertOption(CameraConfig.OPTION_CAPTURE_PROCESS_PROGRESS_SUPPORTED, Boolean.valueOf(z));
            return this;
        }
    }
}
