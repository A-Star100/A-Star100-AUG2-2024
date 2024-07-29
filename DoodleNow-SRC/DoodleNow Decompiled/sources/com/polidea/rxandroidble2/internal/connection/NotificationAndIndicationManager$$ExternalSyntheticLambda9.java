package com.polidea.rxandroidble2.internal.connection;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda9 implements Function {
    public final /* synthetic */ Completable f$0;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda9(Completable completable) {
        this.f$0 = completable;
    }

    public final Object apply(Object obj) {
        return ((Observable) obj).mergeWith((CompletableSource) this.f$0.onErrorComplete());
    }
}
