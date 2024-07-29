package com.polidea.rxandroidble2.internal.scan;

import bleshadow.dagger.internal.Factory;

public final class IsConnectableCheckerApi18_Factory implements Factory<IsConnectableCheckerApi18> {
    public IsConnectableCheckerApi18 get() {
        return newInstance();
    }

    public static IsConnectableCheckerApi18_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static IsConnectableCheckerApi18 newInstance() {
        return new IsConnectableCheckerApi18();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final IsConnectableCheckerApi18_Factory INSTANCE = new IsConnectableCheckerApi18_Factory();

        private InstanceHolder() {
        }
    }
}
