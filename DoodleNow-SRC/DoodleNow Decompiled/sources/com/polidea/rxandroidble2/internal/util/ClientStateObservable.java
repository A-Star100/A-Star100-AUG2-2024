package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.concurrent.TimeUnit;

public class ClientStateObservable extends Observable<RxBleClient.State> {
    final Observable<RxBleAdapterStateObservable.BleAdapterState> bleAdapterStateObservable;
    final Observable<Boolean> locationServicesOkObservable;
    private final LocationServicesStatus locationServicesStatus;
    final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final Scheduler timerScheduler;

    @Inject
    protected ClientStateObservable(RxBleAdapterWrapper rxBleAdapterWrapper2, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, @Named("location-ok-boolean-observable") Observable<Boolean> observable2, LocationServicesStatus locationServicesStatus2, @Named("timeout") Scheduler scheduler) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper2;
        this.bleAdapterStateObservable = observable;
        this.locationServicesOkObservable = observable2;
        this.locationServicesStatus = locationServicesStatus2;
        this.timerScheduler = scheduler;
    }

    private static Single<Boolean> checkPermissionUntilGranted(final LocationServicesStatus locationServicesStatus2, Scheduler scheduler) {
        return Observable.interval(0, 1, TimeUnit.SECONDS, scheduler).takeWhile(new Predicate<Long>() {
            public boolean test(Long l) {
                return !LocationServicesStatus.this.isLocationPermissionOk();
            }
        }).count().map(new Function<Long, Boolean>() {
            public Boolean apply(Long l) {
                return Boolean.valueOf(l.longValue() == 0);
            }
        });
    }

    static Observable<RxBleClient.State> checkAdapterAndServicesState(RxBleAdapterWrapper rxBleAdapterWrapper2, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, final Observable<Boolean> observable2) {
        RxBleAdapterStateObservable.BleAdapterState bleAdapterState;
        if (rxBleAdapterWrapper2.isBluetoothEnabled()) {
            bleAdapterState = RxBleAdapterStateObservable.BleAdapterState.STATE_ON;
        } else {
            bleAdapterState = RxBleAdapterStateObservable.BleAdapterState.STATE_OFF;
        }
        return observable.startWith(bleAdapterState).switchMap(new Function<RxBleAdapterStateObservable.BleAdapterState, Observable<RxBleClient.State>>() {
            public Observable<RxBleClient.State> apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
                if (bleAdapterState != RxBleAdapterStateObservable.BleAdapterState.STATE_ON) {
                    return Observable.just(RxBleClient.State.BLUETOOTH_NOT_ENABLED);
                }
                return Observable.this.map(new Function<Boolean, RxBleClient.State>() {
                    public RxBleClient.State apply(Boolean bool) {
                        if (bool.booleanValue()) {
                            return RxBleClient.State.READY;
                        }
                        return RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED;
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Observer<? super RxBleClient.State> observer) {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            observer.onSubscribe(Disposables.empty());
            observer.onComplete();
            return;
        }
        checkPermissionUntilGranted(this.locationServicesStatus, this.timerScheduler).flatMapObservable(new Function<Boolean, Observable<RxBleClient.State>>() {
            public Observable<RxBleClient.State> apply(Boolean bool) {
                Observable<RxBleClient.State> distinctUntilChanged = ClientStateObservable.checkAdapterAndServicesState(ClientStateObservable.this.rxBleAdapterWrapper, ClientStateObservable.this.bleAdapterStateObservable, ClientStateObservable.this.locationServicesOkObservable).distinctUntilChanged();
                return bool.booleanValue() ? distinctUntilChanged.skip(1) : distinctUntilChanged;
            }
        }).subscribe(observer);
    }
}
