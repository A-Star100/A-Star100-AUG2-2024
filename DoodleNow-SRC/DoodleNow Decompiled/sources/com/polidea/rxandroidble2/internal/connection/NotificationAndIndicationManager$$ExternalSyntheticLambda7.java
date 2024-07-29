package com.polidea.rxandroidble2.internal.connection;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda7 implements Function {
    public final /* synthetic */ PublishSubject f$0;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda7(PublishSubject publishSubject) {
        this.f$0 = publishSubject;
    }

    public final Object apply(Object obj) {
        return Observable.amb(Arrays.asList(new Observable[]{this.f$0.cast(byte[].class), ((Observable) obj).takeUntil(this.f$0)}));
    }
}
