package com.reactnativelauncharguments;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Collections;
import java.util.List;

public class LaunchArgumentsPackage implements ReactPackage {
    public /* synthetic */ NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        return ReactPackage.CC.$default$getModule(this, str, reactApplicationContext);
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new LaunchArgumentsModule(reactApplicationContext));
    }
}
