package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.connection.PayloadSizeLimitProvider;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import io.reactivex.Scheduler;
import java.util.concurrent.TimeUnit;

public class OperationsProviderImpl implements OperationsProvider {
    private final LoggerUtilBluetoothServices bleServicesLogger;
    private final BluetoothGatt bluetoothGatt;
    private final Scheduler bluetoothInteractionScheduler;
    private final Provider<ReadRssiOperation> rssiReadOperationProvider;
    private final RxBleGattCallback rxBleGattCallback;
    private final TimeoutConfiguration timeoutConfiguration;
    private final Scheduler timeoutScheduler;

    @Inject
    OperationsProviderImpl(RxBleGattCallback rxBleGattCallback2, BluetoothGatt bluetoothGatt2, LoggerUtilBluetoothServices loggerUtilBluetoothServices, @Named("operation-timeout") TimeoutConfiguration timeoutConfiguration2, @Named("bluetooth_interaction") Scheduler scheduler, @Named("timeout") Scheduler scheduler2, Provider<ReadRssiOperation> provider) {
        this.rxBleGattCallback = rxBleGattCallback2;
        this.bluetoothGatt = bluetoothGatt2;
        this.bleServicesLogger = loggerUtilBluetoothServices;
        this.timeoutConfiguration = timeoutConfiguration2;
        this.bluetoothInteractionScheduler = scheduler;
        this.timeoutScheduler = scheduler2;
        this.rssiReadOperationProvider = provider;
    }

    public CharacteristicLongWriteOperation provideLongWriteOperation(BluetoothGattCharacteristic bluetoothGattCharacteristic, RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy, RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy, PayloadSizeLimitProvider payloadSizeLimitProvider, byte[] bArr) {
        return new CharacteristicLongWriteOperation(this.bluetoothGatt, this.rxBleGattCallback, this.bluetoothInteractionScheduler, this.timeoutConfiguration, bluetoothGattCharacteristic, payloadSizeLimitProvider, writeOperationAckStrategy, writeOperationRetryStrategy, bArr);
    }

    public MtuRequestOperation provideMtuChangeOperation(int i) {
        return new MtuRequestOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, i);
    }

    public CharacteristicReadOperation provideReadCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return new CharacteristicReadOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattCharacteristic);
    }

    public DescriptorReadOperation provideReadDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return new DescriptorReadOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattDescriptor);
    }

    public ReadRssiOperation provideRssiReadOperation() {
        return this.rssiReadOperationProvider.get();
    }

    public ServiceDiscoveryOperation provideServiceDiscoveryOperation(long j, TimeUnit timeUnit) {
        return new ServiceDiscoveryOperation(this.rxBleGattCallback, this.bluetoothGatt, this.bleServicesLogger, new TimeoutConfiguration(j, timeUnit, this.timeoutScheduler));
    }

    public CharacteristicWriteOperation provideWriteCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return new CharacteristicWriteOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, bluetoothGattCharacteristic, bArr);
    }

    public DescriptorWriteOperation provideWriteDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return new DescriptorWriteOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, 2, bluetoothGattDescriptor, bArr);
    }

    public ConnectionPriorityChangeOperation provideConnectionPriorityChangeOperation(int i, long j, TimeUnit timeUnit) {
        return new ConnectionPriorityChangeOperation(this.rxBleGattCallback, this.bluetoothGatt, this.timeoutConfiguration, i, new TimeoutConfiguration(j, timeUnit, this.timeoutScheduler));
    }
}
