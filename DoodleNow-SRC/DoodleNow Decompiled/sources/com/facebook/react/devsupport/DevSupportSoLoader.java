package com.facebook.react.devsupport;

import com.facebook.soloader.SoLoader;

class DevSupportSoLoader {
    private static volatile boolean sDidInit = false;

    DevSupportSoLoader() {
    }

    public static synchronized void staticInit() {
        synchronized (DevSupportSoLoader.class) {
            if (!sDidInit) {
                SoLoader.loadLibrary("react_devsupportjni");
                sDidInit = true;
            }
        }
    }
}
