package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.common.ReactConstants;
import java.util.Map;

public abstract class BaseJavaModule implements NativeModule {
    public static final String METHOD_TYPE_ASYNC = "async";
    public static final String METHOD_TYPE_PROMISE = "promise";
    public static final String METHOD_TYPE_SYNC = "sync";
    private final ReactApplicationContext mReactApplicationContext;

    public boolean canOverrideExistingModule() {
        return false;
    }

    public Map<String, Object> getConstants() {
        return null;
    }

    public void initialize() {
    }

    public void invalidate() {
    }

    public /* synthetic */ void onCatalystInstanceDestroy() {
        NativeModule.CC.$default$onCatalystInstanceDestroy(this);
    }

    public BaseJavaModule() {
        this((ReactApplicationContext) null);
    }

    public BaseJavaModule(ReactApplicationContext reactApplicationContext) {
        this.mReactApplicationContext = reactApplicationContext;
    }

    /* access modifiers changed from: protected */
    public final ReactApplicationContext getReactApplicationContext() {
        return (ReactApplicationContext) Assertions.assertNotNull(this.mReactApplicationContext, "Tried to get ReactApplicationContext even though NativeModule wasn't instantiated with one");
    }

    /* access modifiers changed from: protected */
    public final ReactApplicationContext getReactApplicationContextIfActiveOrWarn() {
        if (this.mReactApplicationContext.hasActiveReactInstance()) {
            return this.mReactApplicationContext;
        }
        ReactSoftExceptionLogger.logSoftException(ReactConstants.TAG, new RuntimeException("React Native Instance has already disappeared: requested by " + getName()));
        return null;
    }
}
