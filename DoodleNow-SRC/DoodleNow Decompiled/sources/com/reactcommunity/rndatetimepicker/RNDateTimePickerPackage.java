package com.reactcommunity.rndatetimepicker;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.HashMap;
import java.util.Map;

public class RNDateTimePickerPackage extends TurboReactPackage {
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals(DatePickerModule.NAME)) {
            return new DatePickerModule(reactApplicationContext);
        }
        if (str.equals(TimePickerModule.NAME)) {
            return new TimePickerModule(reactApplicationContext);
        }
        return null;
    }

    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new RNDateTimePickerPackage$$ExternalSyntheticLambda0();
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap hashMap = new HashMap();
        hashMap.put(DatePickerModule.NAME, new ReactModuleInfo(DatePickerModule.NAME, DatePickerModule.NAME, false, false, false, false, false));
        hashMap.put(TimePickerModule.NAME, new ReactModuleInfo(TimePickerModule.NAME, TimePickerModule.NAME, false, false, false, false, false));
        return hashMap;
    }
}
