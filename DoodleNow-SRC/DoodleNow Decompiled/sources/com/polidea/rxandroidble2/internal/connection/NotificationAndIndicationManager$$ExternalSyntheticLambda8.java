package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda8 implements Action {
    public final /* synthetic */ NotificationAndIndicationManager f$0;
    public final /* synthetic */ PublishSubject f$1;
    public final /* synthetic */ CharacteristicNotificationId f$2;
    public final /* synthetic */ BluetoothGattCharacteristic f$3;
    public final /* synthetic */ NotificationSetupMode f$4;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda8(NotificationAndIndicationManager notificationAndIndicationManager, PublishSubject publishSubject, CharacteristicNotificationId characteristicNotificationId, BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode) {
        this.f$0 = notificationAndIndicationManager;
        this.f$1 = publishSubject;
        this.f$2 = characteristicNotificationId;
        this.f$3 = bluetoothGattCharacteristic;
        this.f$4 = notificationSetupMode;
    }

    public final void run() {
        this.f$0.m1054lambda$setupServerInitiatedCharacteristicRead$1$compolidearxandroidble2internalconnectionNotificationAndIndicationManager(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
