package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.exceptions.BleGattCallbackTimeoutException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtilBluetoothServices;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ServiceDiscoveryOperation extends SingleResponseOperation<RxBleDeviceServices> {
    final LoggerUtilBluetoothServices bleServicesLogger;
    final BluetoothGatt bluetoothGatt;

    ServiceDiscoveryOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt2, LoggerUtilBluetoothServices loggerUtilBluetoothServices, TimeoutConfiguration timeoutConfiguration) {
        super(bluetoothGatt2, rxBleGattCallback, BleGattOperationType.SERVICE_DISCOVERY, timeoutConfiguration);
        this.bluetoothGatt = bluetoothGatt2;
        this.bleServicesLogger = loggerUtilBluetoothServices;
    }

    /* access modifiers changed from: protected */
    public Single<RxBleDeviceServices> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnServicesDiscovered().firstOrError().doOnSuccess(new ServiceDiscoveryOperation$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$getCallback$0$com-polidea-rxandroidble2-internal-operations-ServiceDiscoveryOperation  reason: not valid java name */
    public /* synthetic */ void m1056lambda$getCallback$0$compolidearxandroidble2internaloperationsServiceDiscoveryOperation(RxBleDeviceServices rxBleDeviceServices) throws Exception {
        this.bleServicesLogger.log(rxBleDeviceServices, this.bluetoothGatt.getDevice());
    }

    /* access modifiers changed from: protected */
    public boolean startOperation(BluetoothGatt bluetoothGatt2) {
        return bluetoothGatt2.discoverServices();
    }

    /* access modifiers changed from: protected */
    public Single<RxBleDeviceServices> timeoutFallbackProcedure(BluetoothGatt bluetoothGatt2, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) {
        return Single.defer(new ServiceDiscoveryOperation$$ExternalSyntheticLambda3(bluetoothGatt2, scheduler));
    }

    static /* synthetic */ SingleSource lambda$timeoutFallbackProcedure$3(BluetoothGatt bluetoothGatt2, Scheduler scheduler) throws Exception {
        if (bluetoothGatt2.getServices().size() == 0) {
            return Single.error((Throwable) new BleGattCallbackTimeoutException(bluetoothGatt2, BleGattOperationType.SERVICE_DISCOVERY));
        }
        return Single.timer(5, TimeUnit.SECONDS, scheduler).flatMap(new ServiceDiscoveryOperation$$ExternalSyntheticLambda1(bluetoothGatt2));
    }

    static /* synthetic */ RxBleDeviceServices lambda$timeoutFallbackProcedure$1(BluetoothGatt bluetoothGatt2) throws Exception {
        return new RxBleDeviceServices(bluetoothGatt2.getServices());
    }

    public String toString() {
        return "ServiceDiscoveryOperation{" + super.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
