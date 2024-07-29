package com.facebook.react.runtime;

import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactHostImpl$$ExternalSyntheticLambda39 implements Continuation {
    public final /* synthetic */ ReactHostImpl f$0;

    public /* synthetic */ ReactHostImpl$$ExternalSyntheticLambda39(ReactHostImpl reactHostImpl) {
        this.f$0 = reactHostImpl;
    }

    public final Object then(Task task) {
        return this.f$0.lambda$getOrCreateReactInstanceTask$24(task);
    }
}
