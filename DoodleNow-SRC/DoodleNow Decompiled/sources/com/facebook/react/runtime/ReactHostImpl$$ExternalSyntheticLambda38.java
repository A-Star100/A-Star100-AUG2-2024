package com.facebook.react.runtime;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactHostImpl$$ExternalSyntheticLambda38 implements Callable {
    public final /* synthetic */ ReactHostImpl f$0;

    public /* synthetic */ ReactHostImpl$$ExternalSyntheticLambda38(ReactHostImpl reactHostImpl) {
        this.f$0 = reactHostImpl;
    }

    public final Object call() {
        return this.f$0.waitThenCallGetOrCreateReactInstanceTask();
    }
}
