package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import com.polidea.rxandroidble2.exceptions.BleConflictingNotificationAlreadySetException;
import com.polidea.rxandroidble2.internal.util.ActiveCharacteristicNotification;
import com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ConnectionScope
class NotificationAndIndicationManager {
    static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    final Map<CharacteristicNotificationId, ActiveCharacteristicNotification> activeNotificationObservableMap = new HashMap();
    final BluetoothGatt bluetoothGatt;
    final byte[] configDisable;
    final byte[] configEnableIndication;
    final byte[] configEnableNotification;
    final DescriptorWriter descriptorWriter;
    final RxBleGattCallback gattCallback;

    @Inject
    NotificationAndIndicationManager(@Named("enable-notification-value") byte[] bArr, @Named("enable-indication-value") byte[] bArr2, @Named("disable-notification-value") byte[] bArr3, BluetoothGatt bluetoothGatt2, RxBleGattCallback rxBleGattCallback, DescriptorWriter descriptorWriter2) {
        this.configEnableNotification = bArr;
        this.configEnableIndication = bArr2;
        this.configDisable = bArr3;
        this.bluetoothGatt = bluetoothGatt2;
        this.gattCallback = rxBleGattCallback;
        this.descriptorWriter = descriptorWriter2;
    }

    /* access modifiers changed from: package-private */
    public Observable<Observable<byte[]>> setupServerInitiatedCharacteristicRead(BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode, boolean z) {
        return Observable.defer(new NotificationAndIndicationManager$$ExternalSyntheticLambda4(this, bluetoothGattCharacteristic, z, notificationSetupMode));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupServerInitiatedCharacteristicRead$2$com-polidea-rxandroidble2-internal-connection-NotificationAndIndicationManager  reason: not valid java name */
    public /* synthetic */ ObservableSource m1055lambda$setupServerInitiatedCharacteristicRead$2$compolidearxandroidble2internalconnectionNotificationAndIndicationManager(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, NotificationSetupMode notificationSetupMode) throws Exception {
        synchronized (this.activeNotificationObservableMap) {
            CharacteristicNotificationId characteristicNotificationId = new CharacteristicNotificationId(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
            ActiveCharacteristicNotification activeCharacteristicNotification = this.activeNotificationObservableMap.get(characteristicNotificationId);
            if (activeCharacteristicNotification == null) {
                byte[] bArr = z ? this.configEnableIndication : this.configEnableNotification;
                PublishSubject create = PublishSubject.create();
                Observable<R> refCount = setCharacteristicNotification(this.bluetoothGatt, bluetoothGattCharacteristic, true).andThen(ObservableUtil.justOnNext(observeOnCharacteristicChangeCallbacks(this.gattCallback, characteristicNotificationId))).compose(setupModeTransformer(this.descriptorWriter, bluetoothGattCharacteristic, bArr, notificationSetupMode)).map(new NotificationAndIndicationManager$$ExternalSyntheticLambda7(create)).doFinally(new NotificationAndIndicationManager$$ExternalSyntheticLambda8(this, create, characteristicNotificationId, bluetoothGattCharacteristic, notificationSetupMode)).mergeWith(this.gattCallback.observeDisconnect()).replay(1).refCount();
                this.activeNotificationObservableMap.put(characteristicNotificationId, new ActiveCharacteristicNotification(refCount, z));
                return refCount;
            } else if (activeCharacteristicNotification.isIndication == z) {
                Observable<Observable<byte[]>> observable = activeCharacteristicNotification.notificationObservable;
                return observable;
            } else {
                Observable error = Observable.error((Throwable) new BleConflictingNotificationAlreadySetException(bluetoothGattCharacteristic.getUuid(), !z));
                return error;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setupServerInitiatedCharacteristicRead$1$com-polidea-rxandroidble2-internal-connection-NotificationAndIndicationManager  reason: not valid java name */
    public /* synthetic */ void m1054lambda$setupServerInitiatedCharacteristicRead$1$compolidearxandroidble2internalconnectionNotificationAndIndicationManager(PublishSubject publishSubject, CharacteristicNotificationId characteristicNotificationId, BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode) throws Exception {
        publishSubject.onComplete();
        synchronized (this.activeNotificationObservableMap) {
            this.activeNotificationObservableMap.remove(characteristicNotificationId);
        }
        setCharacteristicNotification(this.bluetoothGatt, bluetoothGattCharacteristic, false).compose(teardownModeTransformer(this.descriptorWriter, bluetoothGattCharacteristic, this.configDisable, notificationSetupMode)).subscribe(Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    static Completable setCharacteristicNotification(BluetoothGatt bluetoothGatt2, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        return Completable.fromAction(new NotificationAndIndicationManager$$ExternalSyntheticLambda3(bluetoothGatt2, bluetoothGattCharacteristic, z));
    }

    static /* synthetic */ void lambda$setCharacteristicNotification$3(BluetoothGatt bluetoothGatt2, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) throws Exception {
        if (!bluetoothGatt2.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            throw new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 1, (Throwable) null);
        }
    }

    /* renamed from: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.polidea.rxandroidble2.NotificationSetupMode[] r0 = com.polidea.rxandroidble2.NotificationSetupMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode = r0
                com.polidea.rxandroidble2.NotificationSetupMode r1 = com.polidea.rxandroidble2.NotificationSetupMode.COMPAT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.polidea.rxandroidble2.NotificationSetupMode r1 = com.polidea.rxandroidble2.NotificationSetupMode.QUICK_SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.polidea.rxandroidble2.NotificationSetupMode r1 = com.polidea.rxandroidble2.NotificationSetupMode.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager.AnonymousClass1.<clinit>():void");
        }
    }

    static ObservableTransformer<Observable<byte[]>, Observable<byte[]>> setupModeTransformer(DescriptorWriter descriptorWriter2, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, NotificationSetupMode notificationSetupMode) {
        return new NotificationAndIndicationManager$$ExternalSyntheticLambda0(notificationSetupMode, bluetoothGattCharacteristic, descriptorWriter2, bArr);
    }

    static /* synthetic */ ObservableSource lambda$setupModeTransformer$5(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter2, byte[] bArr, Observable observable) {
        int i = AnonymousClass1.$SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[notificationSetupMode.ordinal()];
        if (i == 1) {
            return observable;
        }
        if (i != 2) {
            return writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter2, bArr).andThen(observable);
        }
        Completable ignoreElements = writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter2, bArr).toObservable().publish().autoConnect(2).ignoreElements();
        return observable.mergeWith((CompletableSource) ignoreElements).map(new NotificationAndIndicationManager$$ExternalSyntheticLambda9(ignoreElements));
    }

    static CompletableTransformer teardownModeTransformer(DescriptorWriter descriptorWriter2, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, NotificationSetupMode notificationSetupMode) {
        return new NotificationAndIndicationManager$$ExternalSyntheticLambda1(notificationSetupMode, bluetoothGattCharacteristic, descriptorWriter2, bArr);
    }

    static /* synthetic */ CompletableSource lambda$teardownModeTransformer$6(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter2, byte[] bArr, Completable completable) {
        if (notificationSetupMode == NotificationSetupMode.COMPAT) {
            return completable;
        }
        return completable.andThen((CompletableSource) writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter2, bArr));
    }

    static Observable<byte[]> observeOnCharacteristicChangeCallbacks(RxBleGattCallback rxBleGattCallback, CharacteristicNotificationId characteristicNotificationId) {
        return rxBleGattCallback.getOnCharacteristicChanged().filter(new NotificationAndIndicationManager$$ExternalSyntheticLambda5(characteristicNotificationId)).map(new NotificationAndIndicationManager$$ExternalSyntheticLambda6());
    }

    static Completable writeClientCharacteristicConfig(BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter2, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
        if (descriptor == null) {
            return Completable.error((Throwable) new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 2, (Throwable) null));
        }
        return descriptorWriter2.writeDescriptor(descriptor, bArr).onErrorResumeNext(new NotificationAndIndicationManager$$ExternalSyntheticLambda2(bluetoothGattCharacteristic));
    }
}
