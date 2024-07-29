package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.polidea.rxandroidble2.ClientComponent;
import java.util.concurrent.ExecutorService;

public final class ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory implements Factory<ExecutorService> {
    public ExecutorService get() {
        return provideConnectionQueueExecutorService();
    }

    public static ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ExecutorService provideConnectionQueueExecutorService() {
        return (ExecutorService) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideConnectionQueueExecutorService());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory INSTANCE = new ClientComponent_ClientModule_ProvideConnectionQueueExecutorServiceFactory();

        private InstanceHolder() {
        }
    }
}
