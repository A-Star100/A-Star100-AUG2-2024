package com.facebook.react;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.ReactConstants;
import java.util.Iterator;
import java.util.List;

class ReactPackageHelper {
    ReactPackageHelper() {
    }

    static Iterable<ModuleHolder> getNativeModuleIterator(ReactPackage reactPackage, ReactApplicationContext reactApplicationContext) {
        FLog.d(ReactConstants.TAG, reactPackage.getClass().getSimpleName() + " is not a LazyReactPackage, falling back to old version.");
        return new ReactPackageHelper$$ExternalSyntheticLambda0(reactPackage.createNativeModules(reactApplicationContext));
    }

    static /* synthetic */ Iterator lambda$getNativeModuleIterator$0(final List list) {
        return new Iterator<ModuleHolder>() {
            int position = 0;

            public ModuleHolder next() {
                List list = list;
                int i = this.position;
                this.position = i + 1;
                return new ModuleHolder((NativeModule) list.get(i));
            }

            public boolean hasNext() {
                return this.position < list.size();
            }

            public void remove() {
                throw new UnsupportedOperationException("Cannot remove methods ");
            }
        };
    }
}
