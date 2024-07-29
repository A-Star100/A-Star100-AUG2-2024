package com.polidea.rxandroidble2.internal.util;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class ObservableUtil {
    private static final ObservableTransformer<?, ?> IDENTITY_TRANSFORMER = new ObservableTransformer<Object, Object>() {
        public Observable<Object> apply(Observable<Object> observable) {
            return observable;
        }
    };

    public static <T> ObservableTransformer<T, T> identityTransformer() {
        return IDENTITY_TRANSFORMER;
    }

    private ObservableUtil() {
    }

    public static <T> Observable<T> justOnNext(T t) {
        return Observable.never().startWith(t);
    }
}
