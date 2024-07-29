package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;

public final class ConnectionModule_MinimumMtuFactory implements Factory<Integer> {
    public Integer get() {
        return Integer.valueOf(minimumMtu());
    }

    public static ConnectionModule_MinimumMtuFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int minimumMtu() {
        return ConnectionModule.minimumMtu();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ConnectionModule_MinimumMtuFactory INSTANCE = new ConnectionModule_MinimumMtuFactory();

        private InstanceHolder() {
        }
    }
}
