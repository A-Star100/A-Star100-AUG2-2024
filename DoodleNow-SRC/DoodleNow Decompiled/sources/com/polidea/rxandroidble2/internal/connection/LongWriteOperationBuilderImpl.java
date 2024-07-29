package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.UUID;

public final class LongWriteOperationBuilderImpl implements RxBleConnection.LongWriteOperationBuilder {
    byte[] bytes;
    PayloadSizeLimitProvider maxBatchSizeProvider;
    final ConnectionOperationQueue operationQueue;
    final OperationsProvider operationsProvider;
    private final RxBleConnection rxBleConnection;
    RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy = new ImmediateSerializedBatchAckStrategy();
    RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy = new NoRetryStrategy();
    private Single<BluetoothGattCharacteristic> writtenCharacteristicObservable;

    public RxBleConnection.LongWriteOperationBuilder setBytes(byte[] bArr) {
        this.bytes = bArr;
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setWriteOperationAckStrategy(RxBleConnection.WriteOperationAckStrategy writeOperationAckStrategy2) {
        this.writeOperationAckStrategy = writeOperationAckStrategy2;
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setWriteOperationRetryStrategy(RxBleConnection.WriteOperationRetryStrategy writeOperationRetryStrategy2) {
        this.writeOperationRetryStrategy = writeOperationRetryStrategy2;
        return this;
    }

    @Inject
    LongWriteOperationBuilderImpl(ConnectionOperationQueue connectionOperationQueue, MtuBasedPayloadSizeLimit mtuBasedPayloadSizeLimit, RxBleConnection rxBleConnection2, OperationsProvider operationsProvider2) {
        this.operationQueue = connectionOperationQueue;
        this.maxBatchSizeProvider = mtuBasedPayloadSizeLimit;
        this.rxBleConnection = rxBleConnection2;
        this.operationsProvider = operationsProvider2;
    }

    public RxBleConnection.LongWriteOperationBuilder setCharacteristicUuid(final UUID uuid) {
        this.writtenCharacteristicObservable = this.rxBleConnection.discoverServices().flatMap(new Function<RxBleDeviceServices, SingleSource<? extends BluetoothGattCharacteristic>>() {
            public SingleSource<? extends BluetoothGattCharacteristic> apply(RxBleDeviceServices rxBleDeviceServices) throws Exception {
                return rxBleDeviceServices.getCharacteristic(uuid);
            }
        });
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.writtenCharacteristicObservable = Single.just(bluetoothGattCharacteristic);
        return this;
    }

    public RxBleConnection.LongWriteOperationBuilder setMaxBatchSize(int i) {
        this.maxBatchSizeProvider = new ConstantPayloadSizeLimit(i);
        return this;
    }

    public Observable<byte[]> build() {
        Single<BluetoothGattCharacteristic> single = this.writtenCharacteristicObservable;
        if (single == null) {
            throw new IllegalArgumentException("setCharacteristicUuid() or setCharacteristic() needs to be called before build()");
        } else if (this.bytes != null) {
            return single.flatMapObservable(new Function<BluetoothGattCharacteristic, Observable<byte[]>>() {
                public Observable<byte[]> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                    return LongWriteOperationBuilderImpl.this.operationQueue.queue(LongWriteOperationBuilderImpl.this.operationsProvider.provideLongWriteOperation(bluetoothGattCharacteristic, LongWriteOperationBuilderImpl.this.writeOperationAckStrategy, LongWriteOperationBuilderImpl.this.writeOperationRetryStrategy, LongWriteOperationBuilderImpl.this.maxBatchSizeProvider, LongWriteOperationBuilderImpl.this.bytes));
                }
            });
        } else {
            throw new IllegalArgumentException("setBytes() needs to be called before build()");
        }
    }
}
