package com.facebook.react.runtime;

import com.facebook.jni.HybridData;
import com.facebook.soloader.SoLoader;

public abstract class JSRuntimeFactory {
    private final HybridData mHybridData;

    static {
        SoLoader.loadLibrary("rninstance");
    }

    protected JSRuntimeFactory(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
