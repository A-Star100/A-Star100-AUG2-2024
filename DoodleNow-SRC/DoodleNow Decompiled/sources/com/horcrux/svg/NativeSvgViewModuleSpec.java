package com.horcrux.svg;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class NativeSvgViewModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNSVGSvgViewModule";

    @Nonnull
    public String getName() {
        return "RNSVGSvgViewModule";
    }

    @ReactMethod
    public abstract void toDataURL(@Nullable Double d, @Nullable ReadableMap readableMap, @Nullable Callback callback);

    public NativeSvgViewModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }
}
