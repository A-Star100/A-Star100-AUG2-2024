package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import bleshadow.dagger.Lazy;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.LegacyScanOperation;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResultLegacy;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanSetup;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.util.BluetoothManagerWrapper;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

class RxBleClientImpl extends RxBleClient {
    @Deprecated
    public static final String TAG = "RxBleClient";
    private final BackgroundScanner backgroundScanner;
    final Scheduler bluetoothInteractionScheduler;
    private final BluetoothManagerWrapper bluetoothManagerWrapper;
    private final CheckerConnectPermission checkerConnectPermission;
    private final CheckerScanPermission checkerScanPermission;
    private final ClientComponent.ClientComponentFinalizer clientComponentFinalizer;
    final Function<RxBleInternalScanResult, ScanResult> internalToExternalScanResultMapFunction;
    private final Lazy<ClientStateObservable> lazyClientStateObservable;
    private final LocationServicesStatus locationServicesStatus;
    final ClientOperationQueue operationQueue;
    final Map<Set<UUID>, Observable<RxBleScanResult>> queuedScanOperations = new HashMap();
    private final Observable<RxBleAdapterStateObservable.BleAdapterState> rxBleAdapterStateObservable;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final RxBleDeviceProvider rxBleDeviceProvider;
    final ScanPreconditionsVerifier scanPreconditionVerifier;
    private final ScanRecordParser scanRecordParser;
    final ScanSetupBuilder scanSetupBuilder;

    public BackgroundScanner getBackgroundScanner() {
        return this.backgroundScanner;
    }

    @Inject
    RxBleClientImpl(BluetoothManagerWrapper bluetoothManagerWrapper2, RxBleAdapterWrapper rxBleAdapterWrapper2, ClientOperationQueue clientOperationQueue, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, ScanRecordParser scanRecordParser2, LocationServicesStatus locationServicesStatus2, Lazy<ClientStateObservable> lazy, RxBleDeviceProvider rxBleDeviceProvider2, ScanSetupBuilder scanSetupBuilder2, ScanPreconditionsVerifier scanPreconditionsVerifier, Function<RxBleInternalScanResult, ScanResult> function, @Named("bluetooth_interaction") Scheduler scheduler, ClientComponent.ClientComponentFinalizer clientComponentFinalizer2, BackgroundScanner backgroundScanner2, CheckerScanPermission checkerScanPermission2, CheckerConnectPermission checkerConnectPermission2) {
        this.operationQueue = clientOperationQueue;
        this.bluetoothManagerWrapper = bluetoothManagerWrapper2;
        this.rxBleAdapterWrapper = rxBleAdapterWrapper2;
        this.rxBleAdapterStateObservable = observable;
        this.scanRecordParser = scanRecordParser2;
        this.locationServicesStatus = locationServicesStatus2;
        this.lazyClientStateObservable = lazy;
        this.rxBleDeviceProvider = rxBleDeviceProvider2;
        this.scanSetupBuilder = scanSetupBuilder2;
        this.scanPreconditionVerifier = scanPreconditionsVerifier;
        this.internalToExternalScanResultMapFunction = function;
        this.bluetoothInteractionScheduler = scheduler;
        this.clientComponentFinalizer = clientComponentFinalizer2;
        this.backgroundScanner = backgroundScanner2;
        this.checkerScanPermission = checkerScanPermission2;
        this.checkerConnectPermission = checkerConnectPermission2;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        this.clientComponentFinalizer.onFinalize();
        super.finalize();
    }

    public RxBleDevice getBleDevice(String str) {
        guardBluetoothAdapterAvailable();
        return this.rxBleDeviceProvider.getBleDevice(str);
    }

    public Set<RxBleDevice> getBondedDevices() {
        guardBluetoothAdapterAvailable();
        HashSet hashSet = new HashSet();
        for (BluetoothDevice address : this.rxBleAdapterWrapper.getBondedDevices()) {
            hashSet.add(getBleDevice(address.getAddress()));
        }
        return hashSet;
    }

    public Set<RxBleDevice> getConnectedPeripherals() {
        HashSet hashSet = new HashSet();
        for (BluetoothDevice address : this.bluetoothManagerWrapper.getConnectedPeripherals()) {
            hashSet.add(getBleDevice(address.getAddress()));
        }
        return hashSet;
    }

    public Observable<ScanResult> scanBleDevices(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        return Observable.defer(new RxBleClientImpl$$ExternalSyntheticLambda7(this, scanSettings, scanFilterArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$scanBleDevices$1$com-polidea-rxandroidble2-RxBleClientImpl  reason: not valid java name */
    public /* synthetic */ ObservableSource m1049lambda$scanBleDevices$1$compolidearxandroidble2RxBleClientImpl(ScanSettings scanSettings, ScanFilter[] scanFilterArr) throws Exception {
        this.scanPreconditionVerifier.verify(scanSettings.shouldCheckLocationProviderState());
        ScanSetup build = this.scanSetupBuilder.build(scanSettings, scanFilterArr);
        return this.operationQueue.queue(build.scanOperation).unsubscribeOn(this.bluetoothInteractionScheduler).compose(build.scanOperationBehaviourEmulatorTransformer).map(this.internalToExternalScanResultMapFunction).doOnNext(new RxBleClientImpl$$ExternalSyntheticLambda3()).mergeWith(bluetoothAdapterOffExceptionObservable());
    }

    static /* synthetic */ void lambda$scanBleDevices$0(ScanResult scanResult) throws Exception {
        if (RxBleLog.getShouldLogScannedPeripherals()) {
            RxBleLog.i("%s", scanResult);
        }
    }

    @Deprecated
    public Observable<RxBleScanResult> scanBleDevices(UUID... uuidArr) {
        return Observable.defer(new RxBleClientImpl$$ExternalSyntheticLambda0(this, uuidArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$scanBleDevices$2$com-polidea-rxandroidble2-RxBleClientImpl  reason: not valid java name */
    public /* synthetic */ ObservableSource m1050lambda$scanBleDevices$2$compolidearxandroidble2RxBleClientImpl(UUID[] uuidArr) throws Exception {
        this.scanPreconditionVerifier.verify(true);
        return initializeScan(uuidArr);
    }

    private Set<UUID> toDistinctSet(UUID[] uuidArr) {
        if (uuidArr == null) {
            uuidArr = new UUID[0];
        }
        return new HashSet(Arrays.asList(uuidArr));
    }

    /* access modifiers changed from: package-private */
    public Observable<RxBleScanResult> initializeScan(UUID[] uuidArr) {
        Observable<RxBleScanResult> observable;
        Set<UUID> distinctSet = toDistinctSet(uuidArr);
        synchronized (this.queuedScanOperations) {
            observable = this.queuedScanOperations.get(distinctSet);
            if (observable == null) {
                observable = createScanOperationApi18(uuidArr);
                this.queuedScanOperations.put(distinctSet, observable);
            }
        }
        return observable;
    }

    /* access modifiers changed from: package-private */
    public <T> Observable<T> bluetoothAdapterOffExceptionObservable() {
        return this.rxBleAdapterStateObservable.filter(new RxBleClientImpl$$ExternalSyntheticLambda1()).firstElement().flatMap(new RxBleClientImpl$$ExternalSyntheticLambda2()).toObservable();
    }

    static /* synthetic */ boolean lambda$bluetoothAdapterOffExceptionObservable$3(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) throws Exception {
        return bleAdapterState != RxBleAdapterStateObservable.BleAdapterState.STATE_ON;
    }

    /* access modifiers changed from: package-private */
    public RxBleScanResult convertToPublicScanResult(RxBleInternalScanResultLegacy rxBleInternalScanResultLegacy) {
        return new RxBleScanResult(getBleDevice(rxBleInternalScanResultLegacy.getBluetoothDevice().getAddress()), rxBleInternalScanResultLegacy.getRssi(), rxBleInternalScanResultLegacy.getScanRecord());
    }

    private Observable<RxBleScanResult> createScanOperationApi18(UUID[] uuidArr) {
        Set<UUID> distinctSet = toDistinctSet(uuidArr);
        return this.operationQueue.queue(new LegacyScanOperation(uuidArr, this.rxBleAdapterWrapper, this.scanRecordParser)).doFinally(new RxBleClientImpl$$ExternalSyntheticLambda4(this, distinctSet)).mergeWith(bluetoothAdapterOffExceptionObservable()).map(new RxBleClientImpl$$ExternalSyntheticLambda5(this)).doOnNext(new RxBleClientImpl$$ExternalSyntheticLambda6()).share();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createScanOperationApi18$5$com-polidea-rxandroidble2-RxBleClientImpl  reason: not valid java name */
    public /* synthetic */ void m1048lambda$createScanOperationApi18$5$compolidearxandroidble2RxBleClientImpl(Set set) throws Exception {
        synchronized (this.queuedScanOperations) {
            this.queuedScanOperations.remove(set);
        }
    }

    private void guardBluetoothAdapterAvailable() {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            throw new UnsupportedOperationException("RxAndroidBle library needs a BluetoothAdapter to be available in the system to work. If this is a test on an emulator then you can use 'https://github.com/Polidea/RxAndroidBle/tree/master/mockrxandroidble'");
        }
    }

    public Observable<RxBleClient.State> observeStateChanges() {
        return this.lazyClientStateObservable.get();
    }

    public RxBleClient.State getState() {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            return RxBleClient.State.BLUETOOTH_NOT_AVAILABLE;
        }
        if (!this.locationServicesStatus.isLocationPermissionOk()) {
            return RxBleClient.State.LOCATION_PERMISSION_NOT_GRANTED;
        }
        if (!this.rxBleAdapterWrapper.isBluetoothEnabled()) {
            return RxBleClient.State.BLUETOOTH_NOT_ENABLED;
        }
        if (!this.locationServicesStatus.isLocationProviderOk()) {
            return RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED;
        }
        return RxBleClient.State.READY;
    }

    public boolean isScanRuntimePermissionGranted() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    public boolean isConnectRuntimePermissionGranted() {
        return this.checkerConnectPermission.isConnectRuntimePermissionGranted();
    }

    public String[] getRecommendedScanRuntimePermissions() {
        return this.checkerScanPermission.getRecommendedScanRuntimePermissions();
    }

    public String[] getRecommendedConnectRuntimePermissions() {
        return this.checkerConnectPermission.getRecommendedConnectRuntimePermissions();
    }
}
