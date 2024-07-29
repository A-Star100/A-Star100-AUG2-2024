package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.huawei.hmf.tasks.OnSuccessListener;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HmsLocationController$start$2$$ExternalSyntheticLambda0 implements OnSuccessListener {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ HmsLocationController f$1;

    public /* synthetic */ HmsLocationController$start$2$$ExternalSyntheticLambda0(Ref.ObjectRef objectRef, HmsLocationController hmsLocationController) {
        this.f$0 = objectRef;
        this.f$1 = hmsLocationController;
    }

    public final void onSuccess(Object obj) {
        HmsLocationController$start$2.m1041invokeSuspend$lambda2$lambda0(this.f$0, this.f$1, (Location) obj);
    }
}
