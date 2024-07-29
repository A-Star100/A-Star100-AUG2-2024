package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.NotificationSetupMode;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda4 implements Callable {
    public final /* synthetic */ NotificationAndIndicationManager f$0;
    public final /* synthetic */ BluetoothGattCharacteristic f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ NotificationSetupMode f$3;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda4(NotificationAndIndicationManager notificationAndIndicationManager, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, NotificationSetupMode notificationSetupMode) {
        this.f$0 = notificationAndIndicationManager;
        this.f$1 = bluetoothGattCharacteristic;
        this.f$2 = z;
        this.f$3 = notificationSetupMode;
    }

    public final Object call() {
        return this.f$0.m1055lambda$setupServerInitiatedCharacteristicRead$2$compolidearxandroidble2internalconnectionNotificationAndIndicationManager(this.f$1, this.f$2, this.f$3);
    }
}
