package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.huawei.hmf.tasks.OnSuccessListener;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda0 implements OnSuccessListener {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;

    public /* synthetic */ HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda0(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.f$0 = objectRef;
        this.f$1 = objectRef2;
    }

    public final void onSuccess(Object obj) {
        HmsLocationController$getLastLocation$1.m1039invokeSuspend$lambda0(this.f$0, this.f$1, (Location) obj);
    }
}
