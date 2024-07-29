package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;

public final class ClientComponent_ClientModule_ProvideEnableIndicationValueFactory implements Factory<byte[]> {
    public byte[] get() {
        return provideEnableIndicationValue();
    }

    public static ClientComponent_ClientModule_ProvideEnableIndicationValueFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static byte[] provideEnableIndicationValue() {
        return (byte[]) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideEnableIndicationValue());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ClientComponent_ClientModule_ProvideEnableIndicationValueFactory INSTANCE = new ClientComponent_ClientModule_ProvideEnableIndicationValueFactory();

        private InstanceHolder() {
        }
    }
}
