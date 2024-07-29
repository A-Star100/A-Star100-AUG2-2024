package com.bleplx.adapter.utils;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleCustomOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.concurrent.TimeUnit;

public class RefreshGattCustomOperation implements RxBleCustomOperation<Boolean> {
    public Observable<Boolean> asObservable(BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) {
        return Observable.ambArray(Observable.fromCallable(new RefreshGattCustomOperation$$ExternalSyntheticLambda0(bluetoothGatt)).subscribeOn(scheduler).delay(1, TimeUnit.SECONDS, scheduler), rxBleGattCallback.observeDisconnect());
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Boolean lambda$asObservable$0(android.bluetooth.BluetoothGatt r4) throws java.lang.Exception {
        /*
            r0 = 0
            java.lang.Class r1 = r4.getClass()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r2 = "refresh"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0025 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch:{ Exception -> 0x0025 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0025 }
            java.lang.Object r4 = r1.invoke(r4, r2)     // Catch:{ Exception -> 0x0025 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ Exception -> 0x0025 }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x0025 }
            if (r4 != 0) goto L_0x002e
            java.lang.String r1 = "BluetoothGatt.refresh() returned false"
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0023 }
            com.polidea.rxandroidble2.internal.RxBleLog.d(r1, r2)     // Catch:{ Exception -> 0x0023 }
            goto L_0x002e
        L_0x0023:
            r1 = move-exception
            goto L_0x0027
        L_0x0025:
            r1 = move-exception
            r4 = r0
        L_0x0027:
            java.lang.String r2 = "Could not call function BluetoothGatt.refresh()"
            java.lang.Object[] r3 = new java.lang.Object[r0]
            com.polidea.rxandroidble2.internal.RxBleLog.d(r1, r2, r3)
        L_0x002e:
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            if (r4 == 0) goto L_0x0036
            java.lang.String r2 = "Success"
            goto L_0x0038
        L_0x0036:
            java.lang.String r2 = "Failure"
        L_0x0038:
            r1[r0] = r2
            java.lang.String r0 = "Calling BluetoothGatt.refresh() status: %s"
            com.polidea.rxandroidble2.internal.RxBleLog.i(r0, r1)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bleplx.adapter.utils.RefreshGattCustomOperation.lambda$asObservable$0(android.bluetooth.BluetoothGatt):java.lang.Boolean");
    }
}
