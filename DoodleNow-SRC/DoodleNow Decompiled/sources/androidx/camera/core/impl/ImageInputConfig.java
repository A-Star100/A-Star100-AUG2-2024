package androidx.camera.core.impl;

import androidx.camera.core.DynamicRange;
import androidx.camera.core.impl.Config;
import androidx.core.util.Preconditions;

public interface ImageInputConfig extends ReadableConfig {
    public static final Config.Option<DynamicRange> OPTION_INPUT_DYNAMIC_RANGE = Config.Option.create("camerax.core.imageInput.inputDynamicRange", DynamicRange.class);
    public static final Config.Option<Integer> OPTION_INPUT_FORMAT = Config.Option.create("camerax.core.imageInput.inputFormat", Integer.TYPE);

    public interface Builder<B> {
        B setDynamicRange(DynamicRange dynamicRange);
    }

    DynamicRange getDynamicRange();

    int getInputFormat();

    boolean hasDynamicRange();

    /* renamed from: androidx.camera.core.impl.ImageInputConfig$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$getInputFormat(ImageInputConfig _this) {
            return ((Integer) _this.retrieveOption(ImageInputConfig.OPTION_INPUT_FORMAT)).intValue();
        }

        public static DynamicRange $default$getDynamicRange(ImageInputConfig _this) {
            return (DynamicRange) Preconditions.checkNotNull((DynamicRange) _this.retrieveOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE, DynamicRange.UNSPECIFIED));
        }

        public static boolean $default$hasDynamicRange(ImageInputConfig _this) {
            return _this.containsOption(ImageInputConfig.OPTION_INPUT_DYNAMIC_RANGE);
        }
    }
}
