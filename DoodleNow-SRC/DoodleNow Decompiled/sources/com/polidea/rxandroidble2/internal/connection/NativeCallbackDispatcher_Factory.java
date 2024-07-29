package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;

public final class NativeCallbackDispatcher_Factory implements Factory<NativeCallbackDispatcher> {
    public NativeCallbackDispatcher get() {
        return newInstance();
    }

    public static NativeCallbackDispatcher_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static NativeCallbackDispatcher newInstance() {
        return new NativeCallbackDispatcher();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final NativeCallbackDispatcher_Factory INSTANCE = new NativeCallbackDispatcher_Factory();

        private InstanceHolder() {
        }
    }
}
