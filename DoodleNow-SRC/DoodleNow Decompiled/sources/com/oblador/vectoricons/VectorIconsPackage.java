package com.oblador.vectoricons;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

public class VectorIconsPackage extends TurboReactPackage {
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(VectorIconsModuleImpl.NAME)) {
            return new VectorIconsModule(reactApplicationContext);
        }
        return null;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new VectorIconsPackage$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap hashMap = new HashMap();
        hashMap.put(VectorIconsModuleImpl.NAME, new ReactModuleInfo(VectorIconsModuleImpl.NAME, VectorIconsModuleImpl.NAME, false, false, false, false, false));
        return hashMap;
    }
}
