package com.facebook.react.runtime;

import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactHostImpl$$ExternalSyntheticLambda44 implements Continuation {
    public final /* synthetic */ ReactHostImpl f$0;
    public final /* synthetic */ ReactHostImpl.ReactInstanceTaskUnwrapper f$1;

    public /* synthetic */ ReactHostImpl$$ExternalSyntheticLambda44(ReactHostImpl reactHostImpl, ReactHostImpl.ReactInstanceTaskUnwrapper reactInstanceTaskUnwrapper) {
        this.f$0 = reactHostImpl;
        this.f$1 = reactInstanceTaskUnwrapper;
    }

    public final Object then(Task task) {
        return this.f$0.lambda$getOrCreateReloadTask$33(this.f$1, task);
    }
}
