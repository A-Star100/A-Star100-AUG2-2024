package com.facebook.react.bridge;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeModule;

public class CxxModuleWrapperBase implements NativeModule {
    private HybridData mHybridData;

    public boolean canOverrideExistingModule() {
        return false;
    }

    public native String getName();

    public void initialize() {
    }

    public /* synthetic */ void onCatalystInstanceDestroy() {
        NativeModule.CC.$default$onCatalystInstanceDestroy(this);
    }

    static {
        ReactBridge.staticInit();
    }

    public void invalidate() {
        this.mHybridData.resetNative();
    }

    protected CxxModuleWrapperBase(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    /* access modifiers changed from: protected */
    public void resetModule(HybridData hybridData) {
        HybridData hybridData2 = this.mHybridData;
        if (hybridData != hybridData2) {
            hybridData2.resetNative();
            this.mHybridData = hybridData;
        }
    }
}
