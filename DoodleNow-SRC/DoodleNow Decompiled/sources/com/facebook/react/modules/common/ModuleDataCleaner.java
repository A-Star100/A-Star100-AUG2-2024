package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import java.util.Collection;

public class ModuleDataCleaner {

    public interface Cleanable {
        void clearSensitiveData();
    }

    @Deprecated
    public static void cleanDataFromModules(CatalystInstance catalystInstance) {
        cleanDataFromModules(catalystInstance.getNativeModules());
    }

    public static void cleanDataFromModules(ReactContext reactContext) {
        cleanDataFromModules(reactContext.getNativeModules());
    }

    private static void cleanDataFromModules(Collection<NativeModule> collection) {
        for (NativeModule next : collection) {
            if (next instanceof Cleanable) {
                FLog.d(ReactConstants.TAG, "Cleaning data from " + next.getName());
                ((Cleanable) next).clearSensitiveData();
            }
        }
    }
}
