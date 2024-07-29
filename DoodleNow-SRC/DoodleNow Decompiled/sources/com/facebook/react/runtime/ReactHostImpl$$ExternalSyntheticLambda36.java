package com.facebook.react.runtime;

import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactHostImpl$$ExternalSyntheticLambda36 implements Continuation {
    public final /* synthetic */ Task f$0;

    public /* synthetic */ ReactHostImpl$$ExternalSyntheticLambda36(Task task) {
        this.f$0 = task;
    }

    public final Object then(Task task) {
        return Task.forError(this.f$0.getError());
    }
}
