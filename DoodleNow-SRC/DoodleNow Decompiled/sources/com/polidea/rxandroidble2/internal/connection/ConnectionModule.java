package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.dagger.Binds;
import bleshadow.dagger.Module;
import bleshadow.dagger.Provides;
import bleshadow.dagger.multibindings.IntoSet;
import bleshadow.javax.inject.Named;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.operations.OperationsProviderImpl;
import com.polidea.rxandroidble2.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueueImpl;
import com.polidea.rxandroidble2.internal.util.CharacteristicPropertiesParser;
import io.reactivex.Scheduler;

@Module
public abstract class ConnectionModule {
    public static final String OPERATION_TIMEOUT = "operation-timeout";

    @Provides
    @Named("GATT_WRITE_MTU_OVERHEAD")
    static int gattWriteMtuOverhead() {
        return 3;
    }

    @Provides
    @Named("GATT_MTU_MINIMUM")
    static int minimumMtu() {
        return 23;
    }

    /* access modifiers changed from: package-private */
    @Binds
    public abstract ConnectionOperationQueue bindConnectionOperationQueue(ConnectionOperationQueueImpl connectionOperationQueueImpl);

    /* access modifiers changed from: package-private */
    @IntoSet
    @Binds
    public abstract ConnectionSubscriptionWatcher bindConnectionQueueSubscriptionWatcher(ConnectionOperationQueueImpl connectionOperationQueueImpl);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract MtuProvider bindCurrentMtuProvider(MtuWatcher mtuWatcher);

    /* access modifiers changed from: package-private */
    @IntoSet
    @Binds
    public abstract ConnectionSubscriptionWatcher bindDisconnectActionSubscriptionWatcher(DisconnectAction disconnectAction);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract DisconnectionRouterInput bindDisconnectionRouterInput(DisconnectionRouter disconnectionRouter);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract DisconnectionRouterOutput bindDisconnectionRouterOutput(DisconnectionRouter disconnectionRouter);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract RxBleConnection.LongWriteOperationBuilder bindLongWriteOperationBuilder(LongWriteOperationBuilderImpl longWriteOperationBuilderImpl);

    /* access modifiers changed from: package-private */
    @IntoSet
    @Binds
    public abstract ConnectionSubscriptionWatcher bindMtuWatcherSubscriptionWatcher(MtuWatcher mtuWatcher);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract OperationsProvider bindOperationsProvider(OperationsProviderImpl operationsProviderImpl);

    /* access modifiers changed from: package-private */
    @Binds
    public abstract RxBleConnection bindRxBleConnection(RxBleConnectionImpl rxBleConnectionImpl);

    @Provides
    @Named("operation-timeout")
    static TimeoutConfiguration providesOperationTimeoutConf(@Named("timeout") Scheduler scheduler, Timeout timeout) {
        return new TimeoutConfiguration(timeout.timeout, timeout.timeUnit, scheduler);
    }

    @Provides
    static IllegalOperationHandler provideIllegalOperationHandler(@Named("suppressOperationChecks") boolean z, Provider<LoggingIllegalOperationHandler> provider, Provider<ThrowingIllegalOperationHandler> provider2) {
        if (z) {
            return provider.get();
        }
        return provider2.get();
    }

    @Provides
    static CharacteristicPropertiesParser provideCharacteristicPropertiesParser() {
        return new CharacteristicPropertiesParser(1, 2, 4, 8, 16, 32, 64);
    }

    @Provides
    static BluetoothGatt provideBluetoothGatt(BluetoothGattProvider bluetoothGattProvider) {
        return bluetoothGattProvider.getBluetoothGatt();
    }
}
