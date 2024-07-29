package com.reactnativegooglesignin;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RNGoogleSigninPackage extends TurboReactPackage {
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(NativeGoogleSigninSpec.NAME)) {
            return new RNGoogleSigninModule(reactApplicationContext);
        }
        return null;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new RNGoogleSigninPackage$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap hashMap = new HashMap();
        hashMap.put(NativeGoogleSigninSpec.NAME, new ReactModuleInfo(NativeGoogleSigninSpec.NAME, NativeGoogleSigninSpec.NAME, false, false, true, false, false));
        return hashMap;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{new RNGoogleSigninButtonViewManager()});
    }
}
