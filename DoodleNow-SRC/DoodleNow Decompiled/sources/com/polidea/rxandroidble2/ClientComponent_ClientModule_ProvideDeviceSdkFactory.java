package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import com.polidea.rxandroidble2.ClientComponent;

public final class ClientComponent_ClientModule_ProvideDeviceSdkFactory implements Factory<Integer> {
    public Integer get() {
        return Integer.valueOf(provideDeviceSdk());
    }

    public static ClientComponent_ClientModule_ProvideDeviceSdkFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static int provideDeviceSdk() {
        return ClientComponent.ClientModule.provideDeviceSdk();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ClientComponent_ClientModule_ProvideDeviceSdkFactory INSTANCE = new ClientComponent_ClientModule_ProvideDeviceSdkFactory();

        private InstanceHolder() {
        }
    }
}
