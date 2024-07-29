package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.DeadObjectException;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.ConnectionParameters;
import com.polidea.rxandroidble2.HiddenBluetoothGattCallback;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleCustomOperation;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.internal.Priority;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.ByteAssociation;
import com.polidea.rxandroidble2.internal.util.QueueReleasingEmitterWrapper;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@ConnectionScope
public class RxBleConnectionImpl implements RxBleConnection {
    final BluetoothGatt bluetoothGatt;
    final Scheduler callbackScheduler;
    private final DescriptorWriter descriptorWriter;
    final RxBleGattCallback gattCallback;
    private final IllegalOperationChecker illegalOperationChecker;
    private final Provider<RxBleConnection.LongWriteOperationBuilder> longWriteOperationBuilderProvider;
    private final MtuProvider mtuProvider;
    private final NotificationAndIndicationManager notificationIndicationManager;
    private final ConnectionOperationQueue operationQueue;
    private final OperationsProvider operationsProvider;
    private final ServiceDiscoveryManager serviceDiscoveryManager;

    @Inject
    public RxBleConnectionImpl(ConnectionOperationQueue connectionOperationQueue, RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt2, ServiceDiscoveryManager serviceDiscoveryManager2, NotificationAndIndicationManager notificationAndIndicationManager, MtuProvider mtuProvider2, DescriptorWriter descriptorWriter2, OperationsProvider operationsProvider2, Provider<RxBleConnection.LongWriteOperationBuilder> provider, @Named("bluetooth_interaction") Scheduler scheduler, IllegalOperationChecker illegalOperationChecker2) {
        this.operationQueue = connectionOperationQueue;
        this.gattCallback = rxBleGattCallback;
        this.bluetoothGatt = bluetoothGatt2;
        this.serviceDiscoveryManager = serviceDiscoveryManager2;
        this.notificationIndicationManager = notificationAndIndicationManager;
        this.mtuProvider = mtuProvider2;
        this.descriptorWriter = descriptorWriter2;
        this.operationsProvider = operationsProvider2;
        this.longWriteOperationBuilderProvider = provider;
        this.callbackScheduler = scheduler;
        this.illegalOperationChecker = illegalOperationChecker2;
    }

    public RxBleConnection.LongWriteOperationBuilder createNewLongWriteBuilder() {
        return this.longWriteOperationBuilderProvider.get();
    }

    public Completable requestConnectionPriority(int i, long j, TimeUnit timeUnit) {
        if (i != 2 && i != 0 && i != 1) {
            return Completable.error((Throwable) new IllegalArgumentException("Connection priority must have valid value from BluetoothGatt (received " + i + ")"));
        } else if (j <= 0) {
            return Completable.error((Throwable) new IllegalArgumentException("Delay must be bigger than 0"));
        } else {
            return this.operationQueue.queue(this.operationsProvider.provideConnectionPriorityChangeOperation(i, j, timeUnit)).ignoreElements();
        }
    }

    public Single<Integer> requestMtu(int i) {
        return this.operationQueue.queue(this.operationsProvider.provideMtuChangeOperation(i)).firstOrError();
    }

    public int getMtu() {
        return this.mtuProvider.getMtu();
    }

    public Single<RxBleDeviceServices> discoverServices() {
        return this.serviceDiscoveryManager.getDiscoverServicesSingle(20, TimeUnit.SECONDS);
    }

    public Single<RxBleDeviceServices> discoverServices(long j, TimeUnit timeUnit) {
        return this.serviceDiscoveryManager.getDiscoverServicesSingle(j, timeUnit);
    }

    @Deprecated
    public Single<BluetoothGattCharacteristic> getCharacteristic(final UUID uuid) {
        return discoverServices().flatMap(new Function<RxBleDeviceServices, Single<? extends BluetoothGattCharacteristic>>() {
            public Single<? extends BluetoothGattCharacteristic> apply(RxBleDeviceServices rxBleDeviceServices) {
                return rxBleDeviceServices.getCharacteristic(uuid);
            }
        });
    }

    public Observable<Observable<byte[]>> setupNotification(UUID uuid) {
        return setupNotification(uuid, NotificationSetupMode.DEFAULT);
    }

    public Observable<Observable<byte[]>> setupNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return setupNotification(bluetoothGattCharacteristic, NotificationSetupMode.DEFAULT);
    }

    public Observable<Observable<byte[]>> setupNotification(UUID uuid, final NotificationSetupMode notificationSetupMode) {
        return getCharacteristic(uuid).flatMapObservable(new Function<BluetoothGattCharacteristic, ObservableSource<? extends Observable<byte[]>>>() {
            public Observable<? extends Observable<byte[]>> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.setupNotification(bluetoothGattCharacteristic, notificationSetupMode);
            }
        });
    }

    public Observable<Observable<byte[]>> setupNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 16).andThen(this.notificationIndicationManager.setupServerInitiatedCharacteristicRead(bluetoothGattCharacteristic, notificationSetupMode, false));
    }

    public Observable<Observable<byte[]>> setupIndication(UUID uuid) {
        return setupIndication(uuid, NotificationSetupMode.DEFAULT);
    }

    public Observable<Observable<byte[]>> setupIndication(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return setupIndication(bluetoothGattCharacteristic, NotificationSetupMode.DEFAULT);
    }

    public Observable<Observable<byte[]>> setupIndication(UUID uuid, final NotificationSetupMode notificationSetupMode) {
        return getCharacteristic(uuid).flatMapObservable(new Function<BluetoothGattCharacteristic, ObservableSource<? extends Observable<byte[]>>>() {
            public Observable<? extends Observable<byte[]>> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.setupIndication(bluetoothGattCharacteristic, notificationSetupMode);
            }
        });
    }

    public Observable<Observable<byte[]>> setupIndication(BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 32).andThen(this.notificationIndicationManager.setupServerInitiatedCharacteristicRead(bluetoothGattCharacteristic, notificationSetupMode, true));
    }

    public Single<byte[]> readCharacteristic(UUID uuid) {
        return getCharacteristic(uuid).flatMap(new Function<BluetoothGattCharacteristic, SingleSource<? extends byte[]>>() {
            public SingleSource<? extends byte[]> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.readCharacteristic(bluetoothGattCharacteristic);
            }
        });
    }

    public Single<byte[]> readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 2).andThen(this.operationQueue.queue(this.operationsProvider.provideReadCharacteristic(bluetoothGattCharacteristic))).firstOrError();
    }

    public Single<byte[]> writeCharacteristic(UUID uuid, final byte[] bArr) {
        return getCharacteristic(uuid).flatMap(new Function<BluetoothGattCharacteristic, SingleSource<? extends byte[]>>() {
            public SingleSource<? extends byte[]> apply(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                return RxBleConnectionImpl.this.writeCharacteristic(bluetoothGattCharacteristic, bArr);
            }
        });
    }

    public Single<byte[]> writeCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        return this.illegalOperationChecker.checkAnyPropertyMatches(bluetoothGattCharacteristic, 76).andThen(this.operationQueue.queue(this.operationsProvider.provideWriteCharacteristic(bluetoothGattCharacteristic, bArr))).firstOrError();
    }

    public Single<byte[]> readDescriptor(final UUID uuid, final UUID uuid2, final UUID uuid3) {
        return discoverServices().flatMap(new Function<RxBleDeviceServices, SingleSource<BluetoothGattDescriptor>>() {
            public SingleSource<BluetoothGattDescriptor> apply(RxBleDeviceServices rxBleDeviceServices) {
                return rxBleDeviceServices.getDescriptor(uuid, uuid2, uuid3);
            }
        }).flatMap(new Function<BluetoothGattDescriptor, SingleSource<byte[]>>() {
            public SingleSource<byte[]> apply(BluetoothGattDescriptor bluetoothGattDescriptor) {
                return RxBleConnectionImpl.this.readDescriptor(bluetoothGattDescriptor);
            }
        });
    }

    public Single<byte[]> readDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor) {
        return this.operationQueue.queue(this.operationsProvider.provideReadDescriptor(bluetoothGattDescriptor)).firstOrError().map(new Function<ByteAssociation<BluetoothGattDescriptor>, byte[]>() {
            public byte[] apply(ByteAssociation<BluetoothGattDescriptor> byteAssociation) {
                return byteAssociation.second;
            }
        });
    }

    public Completable writeDescriptor(final UUID uuid, final UUID uuid2, final UUID uuid3, final byte[] bArr) {
        return discoverServices().flatMap(new Function<RxBleDeviceServices, SingleSource<BluetoothGattDescriptor>>() {
            public SingleSource<BluetoothGattDescriptor> apply(RxBleDeviceServices rxBleDeviceServices) {
                return rxBleDeviceServices.getDescriptor(uuid, uuid2, uuid3);
            }
        }).flatMapCompletable(new Function<BluetoothGattDescriptor, CompletableSource>() {
            public CompletableSource apply(BluetoothGattDescriptor bluetoothGattDescriptor) {
                return RxBleConnectionImpl.this.writeDescriptor(bluetoothGattDescriptor, bArr);
            }
        });
    }

    public Completable writeDescriptor(BluetoothGattDescriptor bluetoothGattDescriptor, byte[] bArr) {
        return this.descriptorWriter.writeDescriptor(bluetoothGattDescriptor, bArr);
    }

    public Single<Integer> readRssi() {
        return this.operationQueue.queue(this.operationsProvider.provideRssiReadOperation()).firstOrError();
    }

    public Observable<ConnectionParameters> observeConnectionParametersUpdates() {
        return this.gattCallback.getConnectionParametersUpdates();
    }

    public <T> Observable<T> queue(RxBleCustomOperation<T> rxBleCustomOperation) {
        return queue(rxBleCustomOperation, Priority.NORMAL);
    }

    public <T> Observable<T> queue(final RxBleCustomOperation<T> rxBleCustomOperation, final Priority priority) {
        return this.operationQueue.queue(new QueueOperation<T>() {
            public Priority definedPriority() {
                return priority;
            }

            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: protected */
            public void protectedRun(ObservableEmitter<T> observableEmitter, QueueReleaseInterface queueReleaseInterface) throws Throwable {
                try {
                    Observable asObservable = rxBleCustomOperation.asObservable(RxBleConnectionImpl.this.bluetoothGatt, RxBleConnectionImpl.this.gattCallback, RxBleConnectionImpl.this.callbackScheduler);
                    if (asObservable != null) {
                        asObservable.doOnTerminate(clearNativeCallbackReferenceAction()).subscribe(new QueueReleasingEmitterWrapper(observableEmitter, queueReleaseInterface));
                        return;
                    }
                    queueReleaseInterface.release();
                    throw new IllegalArgumentException("The custom operation asObservable method must return a non-null observable");
                } catch (Throwable th) {
                    queueReleaseInterface.release();
                    throw th;
                }
            }

            private Action clearNativeCallbackReferenceAction() {
                return new Action() {
                    public void run() {
                        RxBleConnectionImpl.this.gattCallback.setNativeCallback((BluetoothGattCallback) null);
                        RxBleConnectionImpl.this.gattCallback.setHiddenNativeCallback((HiddenBluetoothGattCallback) null);
                    }
                };
            }

            /* access modifiers changed from: protected */
            public BleException provideException(DeadObjectException deadObjectException) {
                return new BleDisconnectedException(deadObjectException, RxBleConnectionImpl.this.bluetoothGatt.getDevice().getAddress(), -1);
            }
        });
    }
}
