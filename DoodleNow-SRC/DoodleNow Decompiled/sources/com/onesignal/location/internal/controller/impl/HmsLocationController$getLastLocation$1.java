package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.onesignal.common.threading.Waiter;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.HmsLocationController$getLastLocation$1", f = "HmsLocationController.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HmsLocationController.kt */
final class HmsLocationController$getLastLocation$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ FusedLocationProviderClient $locationClient;
    final /* synthetic */ Ref.ObjectRef<Location> $retVal;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HmsLocationController$getLastLocation$1(FusedLocationProviderClient fusedLocationProviderClient, Ref.ObjectRef<Location> objectRef, Continuation<? super HmsLocationController$getLastLocation$1> continuation) {
        super(1, continuation);
        this.$locationClient = fusedLocationProviderClient;
        this.$retVal = objectRef;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HmsLocationController$getLastLocation$1(this.$locationClient, this.$retVal, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((HmsLocationController$getLastLocation$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = new Waiter();
            this.$locationClient.getLastLocation().addOnSuccessListener(new HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda0(objectRef, this.$retVal)).addOnFailureListener(new HmsLocationController$getLastLocation$1$$ExternalSyntheticLambda1(objectRef));
            this.label = 1;
            if (((Waiter) objectRef.element).waitForWake(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0  reason: not valid java name */
    public static final void m1039invokeSuspend$lambda0(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Location location) {
        Logging.warn$default("Huawei LocationServices getLastLocation returned location: " + location, (Throwable) null, 2, (Object) null);
        if (location == null) {
            ((Waiter) objectRef.element).wake();
            return;
        }
        objectRef2.element = location;
        ((Waiter) objectRef.element).wake();
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-1  reason: not valid java name */
    public static final void m1040invokeSuspend$lambda1(Ref.ObjectRef objectRef, Exception exc) {
        Logging.error("Huawei LocationServices getLastLocation failed!", exc);
        ((Waiter) objectRef.element).wake();
    }
}
