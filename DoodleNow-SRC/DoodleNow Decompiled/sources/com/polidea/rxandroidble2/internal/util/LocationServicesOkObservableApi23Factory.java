package com.polidea.rxandroidble2.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import bleshadow.javax.inject.Inject;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import io.reactivex.schedulers.Schedulers;

public class LocationServicesOkObservableApi23Factory {
    final Context context;
    final LocationServicesStatus locationServicesStatus;

    @Inject
    LocationServicesOkObservableApi23Factory(Context context2, LocationServicesStatus locationServicesStatus2) {
        this.context = context2;
        this.locationServicesStatus = locationServicesStatus2;
    }

    public Observable<Boolean> get() {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            public void subscribe(final ObservableEmitter<Boolean> observableEmitter) {
                boolean isLocationProviderOk = LocationServicesOkObservableApi23Factory.this.locationServicesStatus.isLocationProviderOk();
                final AnonymousClass1 r1 = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        observableEmitter.onNext(Boolean.valueOf(LocationServicesOkObservableApi23Factory.this.locationServicesStatus.isLocationProviderOk()));
                    }
                };
                observableEmitter.onNext(Boolean.valueOf(isLocationProviderOk));
                LocationServicesOkObservableApi23Factory.this.context.registerReceiver(r1, new IntentFilter("android.location.MODE_CHANGED"));
                observableEmitter.setCancellable(new Cancellable() {
                    public void cancel() {
                        LocationServicesOkObservableApi23Factory.this.context.unregisterReceiver(r1);
                    }
                });
            }
        }).distinctUntilChanged().subscribeOn(Schedulers.trampoline()).unsubscribeOn(Schedulers.trampoline());
    }
}
