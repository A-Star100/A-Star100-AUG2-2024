package com.polidea.rxandroidble2;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ClientComponent;
import io.reactivex.Scheduler;
import java.util.concurrent.ExecutorService;

public final class ClientComponent_ClientModule_ProvideFinalizationCloseableFactory implements Factory<ClientComponent.ClientComponentFinalizer> {
    private final Provider<Scheduler> callbacksSchedulerProvider;
    private final Provider<ExecutorService> connectionQueueExecutorServiceProvider;
    private final Provider<ExecutorService> interactionExecutorServiceProvider;

    public ClientComponent_ClientModule_ProvideFinalizationCloseableFactory(Provider<ExecutorService> provider, Provider<Scheduler> provider2, Provider<ExecutorService> provider3) {
        this.interactionExecutorServiceProvider = provider;
        this.callbacksSchedulerProvider = provider2;
        this.connectionQueueExecutorServiceProvider = provider3;
    }

    public ClientComponent.ClientComponentFinalizer get() {
        return provideFinalizationCloseable(this.interactionExecutorServiceProvider.get(), this.callbacksSchedulerProvider.get(), this.connectionQueueExecutorServiceProvider.get());
    }

    public static ClientComponent_ClientModule_ProvideFinalizationCloseableFactory create(Provider<ExecutorService> provider, Provider<Scheduler> provider2, Provider<ExecutorService> provider3) {
        return new ClientComponent_ClientModule_ProvideFinalizationCloseableFactory(provider, provider2, provider3);
    }

    public static ClientComponent.ClientComponentFinalizer provideFinalizationCloseable(ExecutorService executorService, Scheduler scheduler, ExecutorService executorService2) {
        return (ClientComponent.ClientComponentFinalizer) Preconditions.checkNotNullFromProvides(ClientComponent.ClientModule.provideFinalizationCloseable(executorService, scheduler, executorService2));
    }
}
