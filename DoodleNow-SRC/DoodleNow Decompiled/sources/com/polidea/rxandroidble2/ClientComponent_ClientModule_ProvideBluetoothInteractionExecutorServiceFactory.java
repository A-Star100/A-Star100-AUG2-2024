package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;
import java.util.concurrent.ExecutorService;

public final class ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory implements Factory<ExecutorService> {
    public ExecutorService get() {
        return provideBluetoothInteractionExecutorService();
    }

    public static ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ExecutorService provideBluetoothInteractionExecutorService() {
        return (ExecutorService) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideBluetoothInteractionExecutorService());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothInteractionExecutorServiceFactory();

        private InstanceHolder() {
        }
    }
}
