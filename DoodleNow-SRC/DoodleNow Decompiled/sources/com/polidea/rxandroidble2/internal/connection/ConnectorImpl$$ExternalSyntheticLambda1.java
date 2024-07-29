package com.polidea.rxandroidble2.internal.connection;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Set;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ConnectorImpl$$ExternalSyntheticLambda1 implements Consumer {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ ConnectorImpl$$ExternalSyntheticLambda1(Set set) {
        this.f$0 = set;
    }

    public final void accept(Object obj) {
        ConnectorImpl.lambda$prepareConnection$0(this.f$0, (Disposable) obj);
    }
}
