package com.onesignal.location.internal.controller.impl;

import com.huawei.hmf.tasks.OnFailureListener;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda1 implements OnFailureListener {
    public final /* synthetic */ Ref.ObjectRef f$0;

    public /* synthetic */ HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda1(Ref.ObjectRef objectRef) {
        this.f$0 = objectRef;
    }

    public final void onFailure(Exception exc) {
        HmsLocationController$getLastLocation$1.m1040invokeSuspend$lambda1(this.f$0, exc);
    }
}
