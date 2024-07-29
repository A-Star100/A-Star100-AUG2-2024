package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleConnection;
import io.reactivex.Observable;

public class ImmediateSerializedBatchAckStrategy implements RxBleConnection.WriteOperationAckStrategy {
    public Observable<Boolean> apply(Observable<Boolean> observable) {
        return observable;
    }
}
