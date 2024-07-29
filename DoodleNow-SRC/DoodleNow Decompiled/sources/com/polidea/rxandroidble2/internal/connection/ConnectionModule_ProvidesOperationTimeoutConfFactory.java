package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import io.reactivex.Scheduler;

public final class ConnectionModule_ProvidesOperationTimeoutConfFactory implements Factory<TimeoutConfiguration> {
    private final Provider<Timeout> operationTimeoutProvider;
    private final Provider<Scheduler> timeoutSchedulerProvider;

    public ConnectionModule_ProvidesOperationTimeoutConfFactory(Provider<Scheduler> provider, Provider<Timeout> provider2) {
        this.timeoutSchedulerProvider = provider;
        this.operationTimeoutProvider = provider2;
    }

    public TimeoutConfiguration get() {
        return providesOperationTimeoutConf(this.timeoutSchedulerProvider.get(), this.operationTimeoutProvider.get());
    }

    public static ConnectionModule_ProvidesOperationTimeoutConfFactory create(Provider<Scheduler> provider, Provider<Timeout> provider2) {
        return new ConnectionModule_ProvidesOperationTimeoutConfFactory(provider, provider2);
    }

    public static TimeoutConfiguration providesOperationTimeoutConf(Scheduler scheduler, Timeout timeout) {
        return (TimeoutConfiguration) Preconditions.checkNotNullFromProvides(ConnectionModule.providesOperationTimeoutConf(scheduler, timeout));
    }
}
