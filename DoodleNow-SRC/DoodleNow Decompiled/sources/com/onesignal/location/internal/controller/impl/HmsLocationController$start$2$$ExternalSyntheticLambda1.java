package com.onesignal.location.internal.controller.impl;

import com.huawei.hmf.tasks.OnFailureListener;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HmsLocationController$start$2$$ExternalSyntheticLambda1 implements OnFailureListener {
    public final /* synthetic */ Ref.ObjectRef f$0;

    public /* synthetic */ HmsLocationController$start$2$$ExternalSyntheticLambda1(Ref.ObjectRef objectRef) {
        this.f$0 = objectRef;
    }

    public final void onFailure(Exception exc) {
        HmsLocationController$start$2.m1042invokeSuspend$lambda2$lambda1(this.f$0, exc);
    }
}
