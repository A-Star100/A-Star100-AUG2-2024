package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;

public final class ConnectionModule_GattWriteMtuOverheadFactory implements Factory<Integer> {
    public Integer get() {
        return Integer.valueOf(gattWriteMtuOverhead());
    }

    public static ConnectionModule_GattWriteMtuOverheadFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int gattWriteMtuOverhead() {
        return ConnectionModule.gattWriteMtuOverhead();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ConnectionModule_GattWriteMtuOverheadFactory INSTANCE = new ConnectionModule_GattWriteMtuOverheadFactory();

        private InstanceHolder() {
        }
    }
}
