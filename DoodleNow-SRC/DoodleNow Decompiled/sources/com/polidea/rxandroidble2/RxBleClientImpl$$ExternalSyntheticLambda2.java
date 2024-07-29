package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import io.reactivex.Maybe;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RxBleClientImpl$$ExternalSyntheticLambda2 implements Function {
    public final Object apply(Object obj) {
        return Maybe.error((Throwable) new BleScanException(1));
    }
}
