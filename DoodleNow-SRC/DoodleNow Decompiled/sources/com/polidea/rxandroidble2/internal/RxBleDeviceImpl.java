package com.polidea.rxandroidble2.internal;

import android.bluetooth.BluetoothDevice;
import bleshadow.javax.inject.Inject;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.ConnectionSetup;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.Timeout;
import com.polidea.rxandroidble2.exceptions.BleAlreadyConnectedException;
import com.polidea.rxandroidble2.internal.connection.Connector;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@DeviceScope
class RxBleDeviceImpl implements RxBleDevice {
    final BluetoothDevice bluetoothDevice;
    private final CheckerConnectPermission checkerConnectPermission;
    private final BehaviorRelay<RxBleConnection.RxBleConnectionState> connectionStateRelay;
    final Connector connector;
    final AtomicBoolean isConnected = new AtomicBoolean(false);

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    @Inject
    RxBleDeviceImpl(BluetoothDevice bluetoothDevice2, Connector connector2, BehaviorRelay<RxBleConnection.RxBleConnectionState> behaviorRelay, CheckerConnectPermission checkerConnectPermission2) {
        this.bluetoothDevice = bluetoothDevice2;
        this.connector = connector2;
        this.connectionStateRelay = behaviorRelay;
        this.checkerConnectPermission = checkerConnectPermission2;
    }

    public Observable<RxBleConnection.RxBleConnectionState> observeConnectionStateChanges() {
        return this.connectionStateRelay.distinctUntilChanged().skip(1);
    }

    public RxBleConnection.RxBleConnectionState getConnectionState() {
        return this.connectionStateRelay.getValue();
    }

    public Observable<RxBleConnection> establishConnection(boolean z) {
        return establishConnection(new ConnectionSetup.Builder().setAutoConnect(z).setSuppressIllegalOperationCheck(true).build());
    }

    public Observable<RxBleConnection> establishConnection(boolean z, Timeout timeout) {
        return establishConnection(new ConnectionSetup.Builder().setAutoConnect(z).setOperationTimeout(timeout).setSuppressIllegalOperationCheck(true).build());
    }

    public Observable<RxBleConnection> establishConnection(ConnectionSetup connectionSetup) {
        return Observable.defer(new RxBleDeviceImpl$$ExternalSyntheticLambda0(this, connectionSetup));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$establishConnection$1$com-polidea-rxandroidble2-internal-RxBleDeviceImpl  reason: not valid java name */
    public /* synthetic */ ObservableSource m1052lambda$establishConnection$1$compolidearxandroidble2internalRxBleDeviceImpl(ConnectionSetup connectionSetup) throws Exception {
        if (this.isConnected.compareAndSet(false, true)) {
            return this.connector.prepareConnection(connectionSetup).doFinally(new RxBleDeviceImpl$$ExternalSyntheticLambda1(this));
        }
        return Observable.error((Throwable) new BleAlreadyConnectedException(this.bluetoothDevice.getAddress()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$establishConnection$0$com-polidea-rxandroidble2-internal-RxBleDeviceImpl  reason: not valid java name */
    public /* synthetic */ void m1051lambda$establishConnection$0$compolidearxandroidble2internalRxBleDeviceImpl() throws Exception {
        this.isConnected.set(false);
    }

    public String getName() {
        return getName(false);
    }

    private String getName(boolean z) {
        if (!z || this.checkerConnectPermission.isConnectRuntimePermissionGranted()) {
            return this.bluetoothDevice.getName();
        }
        return "[NO BLUETOOTH_CONNECT PERMISSION]";
    }

    public String getMacAddress() {
        return this.bluetoothDevice.getAddress();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RxBleDeviceImpl)) {
            return false;
        }
        return this.bluetoothDevice.equals(((RxBleDeviceImpl) obj).bluetoothDevice);
    }

    public int hashCode() {
        return this.bluetoothDevice.hashCode();
    }

    public String toString() {
        return "RxBleDeviceImpl{" + LoggerUtil.commonMacMessage(this.bluetoothDevice.getAddress()) + ", name=" + getName(true) + AbstractJsonLexerKt.END_OBJ;
    }
}
