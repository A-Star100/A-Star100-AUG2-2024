package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.HmsLocationController$start$2", f = "HmsLocationController.kt", i = {0, 1}, l = {229, 81}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* compiled from: HmsLocationController.kt */
final class HmsLocationController$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<HmsLocationController> $self;
    final /* synthetic */ Ref.BooleanRef $wasSuccessful;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ HmsLocationController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HmsLocationController$start$2(HmsLocationController hmsLocationController, Ref.BooleanRef booleanRef, Ref.ObjectRef<HmsLocationController> objectRef, Continuation<? super HmsLocationController$start$2> continuation) {
        super(2, continuation);
        this.this$0 = hmsLocationController;
        this.$wasSuccessful = booleanRef;
        this.$self = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HmsLocationController$start$2(this.this$0, this.$wasSuccessful, this.$self, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HmsLocationController$start$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0102 A[Catch:{ all -> 0x002a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Huawei LocationServices getFusedLocationProviderClient failed! "
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r9.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x004a
            if (r2 == r3) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            java.lang.Object r0 = r9.L$4
            kotlin.jvm.internal.Ref$BooleanRef r0 = (kotlin.jvm.internal.Ref.BooleanRef) r0
            java.lang.Object r1 = r9.L$3
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r2 = r9.L$2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r3 = r9.L$1
            com.onesignal.location.internal.controller.impl.HmsLocationController r3 = (com.onesignal.location.internal.controller.impl.HmsLocationController) r3
            java.lang.Object r4 = r9.L$0
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x002a }
            goto L_0x00f6
        L_0x002a:
            r10 = move-exception
            goto L_0x0134
        L_0x002d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0035:
            java.lang.Object r2 = r9.L$3
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r3 = r9.L$2
            kotlin.jvm.internal.Ref$BooleanRef r3 = (kotlin.jvm.internal.Ref.BooleanRef) r3
            java.lang.Object r6 = r9.L$1
            com.onesignal.location.internal.controller.impl.HmsLocationController r6 = (com.onesignal.location.internal.controller.impl.HmsLocationController) r6
            java.lang.Object r7 = r9.L$0
            kotlinx.coroutines.sync.Mutex r7 = (kotlinx.coroutines.sync.Mutex) r7
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r7
            goto L_0x0070
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r10)
            com.onesignal.location.internal.controller.impl.HmsLocationController r10 = r9.this$0
            kotlinx.coroutines.sync.Mutex r10 = r10.startStopMutex
            com.onesignal.location.internal.controller.impl.HmsLocationController r2 = r9.this$0
            kotlin.jvm.internal.Ref$BooleanRef r6 = r9.$wasSuccessful
            kotlin.jvm.internal.Ref$ObjectRef<com.onesignal.location.internal.controller.impl.HmsLocationController> r7 = r9.$self
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r9.L$0 = r10
            r9.L$1 = r2
            r9.L$2 = r6
            r9.L$3 = r7
            r9.label = r3
            java.lang.Object r3 = r10.lock(r5, r8)
            if (r3 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r3 = r6
            r6 = r2
            r2 = r7
        L_0x0070:
            com.huawei.hms.location.FusedLocationProviderClient r7 = r6.hmsFusedLocationClient     // Catch:{ all -> 0x0131 }
            if (r7 != 0) goto L_0x009b
            com.onesignal.core.internal.application.IApplicationService r7 = r6._applicationService     // Catch:{ Exception -> 0x0086 }
            android.content.Context r7 = r7.getAppContext()     // Catch:{ Exception -> 0x0086 }
            com.huawei.hms.location.FusedLocationProviderClient r7 = com.huawei.hms.location.LocationServices.getFusedLocationProviderClient(r7)     // Catch:{ Exception -> 0x0086 }
            r6.hmsFusedLocationClient = r7     // Catch:{ Exception -> 0x0086 }
            goto L_0x009b
        L_0x0086:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0131 }
            r2.<init>(r0)     // Catch:{ all -> 0x0131 }
            r2.append(r1)     // Catch:{ all -> 0x0131 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0131 }
            com.onesignal.debug.internal.logging.Logging.error$default(r0, r5, r4, r5)     // Catch:{ all -> 0x0131 }
            r0 = 0
            r3.element = r0     // Catch:{ all -> 0x0131 }
            goto L_0x0128
        L_0x009b:
            android.location.Location r0 = r6.lastLocation     // Catch:{ all -> 0x0131 }
            if (r0 == 0) goto L_0x00b1
            com.onesignal.common.events.EventProducer r0 = r6.event     // Catch:{ all -> 0x0131 }
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$1$1 r1 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$1$1     // Catch:{ all -> 0x0131 }
            r1.<init>(r6)     // Catch:{ all -> 0x0131 }
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1     // Catch:{ all -> 0x0131 }
            r0.fire(r1)     // Catch:{ all -> 0x0131 }
            goto L_0x0128
        L_0x00b1:
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x0131 }
            r0.<init>()     // Catch:{ all -> 0x0131 }
            com.onesignal.common.threading.WaiterWithValue r7 = new com.onesignal.common.threading.WaiterWithValue     // Catch:{ all -> 0x0131 }
            r7.<init>()     // Catch:{ all -> 0x0131 }
            r0.element = r7     // Catch:{ all -> 0x0131 }
            com.huawei.hms.location.FusedLocationProviderClient r7 = r6.hmsFusedLocationClient     // Catch:{ all -> 0x0131 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x0131 }
            com.huawei.hmf.tasks.Task r7 = r7.getLastLocation()     // Catch:{ all -> 0x0131 }
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$$ExternalSyntheticLambda0 r8 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$$ExternalSyntheticLambda0     // Catch:{ all -> 0x0131 }
            r8.<init>(r0, r6)     // Catch:{ all -> 0x0131 }
            com.huawei.hmf.tasks.Task r7 = r7.addOnSuccessListener(r8)     // Catch:{ all -> 0x0131 }
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$$ExternalSyntheticLambda1 r8 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$$ExternalSyntheticLambda1     // Catch:{ all -> 0x0131 }
            r8.<init>(r0)     // Catch:{ all -> 0x0131 }
            r7.addOnFailureListener(r8)     // Catch:{ all -> 0x0131 }
            T r0 = r0.element     // Catch:{ all -> 0x0131 }
            com.onesignal.common.threading.WaiterWithValue r0 = (com.onesignal.common.threading.WaiterWithValue) r0     // Catch:{ all -> 0x0131 }
            r9.L$0 = r10     // Catch:{ all -> 0x0131 }
            r9.L$1 = r6     // Catch:{ all -> 0x0131 }
            r9.L$2 = r3     // Catch:{ all -> 0x0131 }
            r9.L$3 = r2     // Catch:{ all -> 0x0131 }
            r9.L$4 = r3     // Catch:{ all -> 0x0131 }
            r9.label = r4     // Catch:{ all -> 0x0131 }
            java.lang.Object r0 = r0.waitForWake(r9)     // Catch:{ all -> 0x0131 }
            if (r0 != r1) goto L_0x00f0
            return r1
        L_0x00f0:
            r4 = r10
            r10 = r0
            r1 = r2
            r0 = r3
            r2 = r0
            r3 = r6
        L_0x00f6:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x002a }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x002a }
            r0.element = r10     // Catch:{ all -> 0x002a }
            boolean r10 = r2.element     // Catch:{ all -> 0x002a }
            if (r10 == 0) goto L_0x0127
            com.onesignal.common.events.EventProducer r10 = r3.event     // Catch:{ all -> 0x002a }
            com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$1$4 r0 = new com.onesignal.location.internal.controller.impl.HmsLocationController$start$2$1$4     // Catch:{ all -> 0x002a }
            r0.<init>(r3)     // Catch:{ all -> 0x002a }
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0     // Catch:{ all -> 0x002a }
            r10.fire(r0)     // Catch:{ all -> 0x002a }
            com.onesignal.location.internal.controller.impl.HmsLocationController$LocationUpdateListener r10 = new com.onesignal.location.internal.controller.impl.HmsLocationController$LocationUpdateListener     // Catch:{ all -> 0x002a }
            T r0 = r1.element     // Catch:{ all -> 0x002a }
            com.onesignal.location.internal.controller.impl.HmsLocationController r0 = (com.onesignal.location.internal.controller.impl.HmsLocationController) r0     // Catch:{ all -> 0x002a }
            com.onesignal.core.internal.application.IApplicationService r1 = r3._applicationService     // Catch:{ all -> 0x002a }
            com.huawei.hms.location.FusedLocationProviderClient r2 = r3.hmsFusedLocationClient     // Catch:{ all -> 0x002a }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)     // Catch:{ all -> 0x002a }
            r10.<init>(r0, r1, r2)     // Catch:{ all -> 0x002a }
            r3.locationUpdateListener = r10     // Catch:{ all -> 0x002a }
        L_0x0127:
            r10 = r4
        L_0x0128:
            r4 = r10
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002a }
            r4.unlock(r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0131:
            r0 = move-exception
            r4 = r10
            r10 = r0
        L_0x0134:
            r4.unlock(r5)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.location.internal.controller.impl.HmsLocationController$start$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-2$lambda-0  reason: not valid java name */
    public static final void m1041invokeSuspend$lambda2$lambda0(Ref.ObjectRef objectRef, HmsLocationController hmsLocationController, Location location) {
        Logging.warn$default("Huawei LocationServices getLastLocation returned location: " + location, (Throwable) null, 2, (Object) null);
        if (location == null) {
            ((WaiterWithValue) objectRef.element).wake(false);
            return;
        }
        hmsLocationController.lastLocation = location;
        ((WaiterWithValue) objectRef.element).wake(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-2$lambda-1  reason: not valid java name */
    public static final void m1042invokeSuspend$lambda2$lambda1(Ref.ObjectRef objectRef, Exception exc) {
        Logging.error("Huawei LocationServices getLastLocation failed!", exc);
        ((WaiterWithValue) objectRef.element).wake(false);
    }
}
