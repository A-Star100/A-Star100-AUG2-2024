package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.DeadObjectException;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble2.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.BleConnectionCompat;
import com.polidea.rxandroidble2.internal.util.DisposableUtil;
import io.reactivex.ObservableEmitter;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.SingleTransformer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableSingleObserver;
import java.util.concurrent.Callable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ConnectOperation extends QueueOperation<BluetoothGatt> {
    final boolean autoConnect;
    final BluetoothDevice bluetoothDevice;
    final BluetoothGattProvider bluetoothGattProvider;
    final TimeoutConfiguration connectTimeout;
    final BleConnectionCompat connectionCompat;
    final ConnectionStateChangeListener connectionStateChangedAction;
    final RxBleGattCallback rxBleGattCallback;

    @Inject
    ConnectOperation(BluetoothDevice bluetoothDevice2, BleConnectionCompat bleConnectionCompat, RxBleGattCallback rxBleGattCallback2, BluetoothGattProvider bluetoothGattProvider2, @Named("connect-timeout") TimeoutConfiguration timeoutConfiguration, @Named("autoConnect") boolean z, ConnectionStateChangeListener connectionStateChangeListener) {
        this.bluetoothDevice = bluetoothDevice2;
        this.connectionCompat = bleConnectionCompat;
        this.rxBleGattCallback = rxBleGattCallback2;
        this.bluetoothGattProvider = bluetoothGattProvider2;
        this.connectTimeout = timeoutConfiguration;
        this.autoConnect = z;
        this.connectionStateChangedAction = connectionStateChangeListener;
    }

    /* access modifiers changed from: protected */
    public void protectedRun(ObservableEmitter<BluetoothGatt> observableEmitter, final QueueReleaseInterface queueReleaseInterface) {
        observableEmitter.setDisposable((DisposableSingleObserver) getConnectedBluetoothGatt().compose(wrapWithTimeoutWhenNotAutoconnecting()).doFinally(new Action() {
            public void run() {
                queueReleaseInterface.release();
            }
        }).subscribeWith(DisposableUtil.disposableSingleObserverFromEmitter(observableEmitter)));
        if (this.autoConnect) {
            queueReleaseInterface.release();
        }
    }

    private SingleTransformer<BluetoothGatt, BluetoothGatt> wrapWithTimeoutWhenNotAutoconnecting() {
        return new SingleTransformer<BluetoothGatt, BluetoothGatt>() {
            public Single<BluetoothGatt> apply(Single<BluetoothGatt> single) {
                if (ConnectOperation.this.autoConnect) {
                    return single;
                }
                return single.timeout(ConnectOperation.this.connectTimeout.timeout, ConnectOperation.this.connectTimeout.timeoutTimeUnit, ConnectOperation.this.connectTimeout.timeoutScheduler, ConnectOperation.this.prepareConnectionTimeoutError());
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Single<BluetoothGatt> prepareConnectionTimeoutError() {
        return Single.fromCallable(new Callable<BluetoothGatt>() {
            public BluetoothGatt call() {
                throw new BleGattCallbackTimeoutException(ConnectOperation.this.bluetoothGattProvider.getBluetoothGatt(), BleGattOperationType.CONNECTION_STATE);
            }
        });
    }

    private Single<BluetoothGatt> getConnectedBluetoothGatt() {
        return Single.create(new SingleOnSubscribe<BluetoothGatt>() {
            public void subscribe(SingleEmitter<BluetoothGatt> singleEmitter) {
                singleEmitter.setDisposable((DisposableSingleObserver) ConnectOperation.this.getBluetoothGattAndChangeStatusToConnected().delaySubscription(ConnectOperation.this.rxBleGattCallback.getOnConnectionStateChange().filter(new Predicate<RxBleConnection.RxBleConnectionState>() {
                    public boolean test(RxBleConnection.RxBleConnectionState rxBleConnectionState) {
                        return rxBleConnectionState == RxBleConnection.RxBleConnectionState.CONNECTED;
                    }
                })).mergeWith(ConnectOperation.this.rxBleGattCallback.observeDisconnect().firstOrError()).firstOrError().subscribeWith(DisposableUtil.disposableSingleObserverFromEmitter(singleEmitter)));
                ConnectOperation.this.connectionStateChangedAction.onConnectionStateChange(RxBleConnection.RxBleConnectionState.CONNECTING);
                ConnectOperation.this.bluetoothGattProvider.updateBluetoothGatt(ConnectOperation.this.connectionCompat.connectGatt(ConnectOperation.this.bluetoothDevice, ConnectOperation.this.autoConnect, ConnectOperation.this.rxBleGattCallback.getBluetoothGattCallback()));
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Single<BluetoothGatt> getBluetoothGattAndChangeStatusToConnected() {
        return Single.fromCallable(new Callable<BluetoothGatt>() {
            public BluetoothGatt call() {
                ConnectOperation.this.connectionStateChangedAction.onConnectionStateChange(RxBleConnection.RxBleConnectionState.CONNECTED);
                return ConnectOperation.this.bluetoothGattProvider.getBluetoothGatt();
            }
        });
    }

    /* access modifiers changed from: protected */
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleDisconnectedException(deadObjectException, this.bluetoothDevice.getAddress(), -1);
    }

    public String toString() {
        return "ConnectOperation{" + LoggerUtil.commonMacMessage(this.bluetoothDevice.getAddress()) + ", autoConnect=" + this.autoConnect + AbstractJsonLexerKt.END_OBJ;
    }
}
