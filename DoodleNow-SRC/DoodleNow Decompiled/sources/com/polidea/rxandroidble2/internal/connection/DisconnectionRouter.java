package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

@ConnectionScope
class DisconnectionRouter implements DisconnectionRouterInput, DisconnectionRouterOutput {
    private final BehaviorRelay<BleException> bleExceptionBehaviorRelay;
    private final Observable<Object> firstDisconnectionExceptionObs;
    private final Observable<BleException> firstDisconnectionValueObs;

    public <T> Observable<T> asErrorOnlyObservable() {
        return this.firstDisconnectionExceptionObs;
    }

    public Observable<BleException> asValueOnlyObservable() {
        return this.firstDisconnectionValueObs;
    }

    @Inject
    DisconnectionRouter(@Named("mac-address") final String str, RxBleAdapterWrapper rxBleAdapterWrapper, Observable<RxBleAdapterStateObservable.BleAdapterState> observable) {
        BehaviorRelay<BleException> create = BehaviorRelay.create();
        this.bleExceptionBehaviorRelay = create;
        final Disposable subscribe = awaitAdapterNotUsable(rxBleAdapterWrapper, observable).map(new Function<Boolean, BleException>() {
            public BleException apply(Boolean bool) {
                return BleDisconnectedException.adapterDisabled(str);
            }
        }).doOnNext(new Consumer<BleException>() {
            public void accept(BleException bleException) {
                RxBleLog.v("An exception received, indicating that the adapter has became unusable.", new Object[0]);
            }
        }).subscribe(create, new Consumer<Throwable>() {
            public void accept(Throwable th) {
                RxBleLog.e(th, "Failed to monitor adapter state.", new Object[0]);
            }
        });
        Observable<BleException> autoConnect = create.firstElement().toObservable().doOnTerminate(new Action() {
            public void run() {
                subscribe.dispose();
            }
        }).replay().autoConnect(0);
        this.firstDisconnectionValueObs = autoConnect;
        this.firstDisconnectionExceptionObs = autoConnect.flatMap(new Function<BleException, ObservableSource<?>>() {
            public ObservableSource<?> apply(BleException bleException) {
                return Observable.error((Throwable) bleException);
            }
        });
    }

    private static Observable<Boolean> awaitAdapterNotUsable(RxBleAdapterWrapper rxBleAdapterWrapper, Observable<RxBleAdapterStateObservable.BleAdapterState> observable) {
        return observable.map(new Function<RxBleAdapterStateObservable.BleAdapterState, Boolean>() {
            public Boolean apply(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
                return Boolean.valueOf(bleAdapterState.isUsable());
            }
        }).startWith(Boolean.valueOf(rxBleAdapterWrapper.isBluetoothEnabled())).filter(new Predicate<Boolean>() {
            public boolean test(Boolean bool) {
                return !bool.booleanValue();
            }
        });
    }

    public void onDisconnectedException(BleDisconnectedException bleDisconnectedException) {
        this.bleExceptionBehaviorRelay.accept(bleDisconnectedException);
    }

    public void onGattConnectionStateException(BleGattException bleGattException) {
        this.bleExceptionBehaviorRelay.accept(bleGattException);
    }
}
