package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.NotificationSetupMode;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda0 implements ObservableTransformer {
    public final /* synthetic */ NotificationSetupMode f$0;
    public final /* synthetic */ BluetoothGattCharacteristic f$1;
    public final /* synthetic */ DescriptorWriter f$2;
    public final /* synthetic */ byte[] f$3;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda0(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr) {
        this.f$0 = notificationSetupMode;
        this.f$1 = bluetoothGattCharacteristic;
        this.f$2 = descriptorWriter;
        this.f$3 = bArr;
    }

    public final ObservableSource apply(Observable observable) {
        return NotificationAndIndicationManager.lambda$setupModeTransformer$5(this.f$0, this.f$1, this.f$2, this.f$3, observable);
    }
}
