package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$start$2", f = "GmsLocationController.kt", i = {0, 1}, l = {250, 62}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
/* compiled from: GmsLocationController.kt */
final class GmsLocationController$start$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<GmsLocationController> $self;
    final /* synthetic */ Ref.BooleanRef $wasSuccessful;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ GmsLocationController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GmsLocationController$start$2(GmsLocationController gmsLocationController, Ref.BooleanRef booleanRef, Ref.ObjectRef<GmsLocationController> objectRef, Continuation<? super GmsLocationController$start$2> continuation) {
        super(2, continuation);
        this.this$0 = gmsLocationController;
        this.$wasSuccessful = booleanRef;
        this.$self = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GmsLocationController$start$2(this.this$0, this.$wasSuccessful, this.$self, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GmsLocationController$start$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Mutex mutex2;
        GmsLocationController gmsLocationController;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef<GmsLocationController> objectRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex2 = this.this$0.startStopMutex;
            gmsLocationController = this.this$0;
            booleanRef = this.$wasSuccessful;
            objectRef = this.$self;
            this.L$0 = mutex2;
            this.L$1 = gmsLocationController;
            this.L$2 = booleanRef;
            this.L$3 = objectRef;
            this.label = 1;
            if (mutex2.lock((Object) null, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            objectRef = (Ref.ObjectRef) this.L$3;
            booleanRef = (Ref.BooleanRef) this.L$2;
            gmsLocationController = (GmsLocationController) this.L$1;
            ResultKt.throwOnFailure(obj);
            mutex2 = (Mutex) this.L$0;
        } else if (i == 2) {
            mutex = (Mutex) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (TimeoutCancellationException unused) {
            }
            Unit unit = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        try {
            if (gmsLocationController.googleApiClient != null) {
                if (gmsLocationController.lastLocation != null) {
                    gmsLocationController.event.fire(new GmsLocationController$start$2$1$1(gmsLocationController));
                } else {
                    Location lastLocation = gmsLocationController.getLastLocation();
                    if (lastLocation != null) {
                        gmsLocationController.setLocationAndFire(lastLocation);
                    }
                }
                booleanRef.element = true;
            } else {
                try {
                    this.L$0 = mutex2;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    if (TimeoutKt.withTimeout((long) GmsLocationController.Companion.getAPI_FALLBACK_TIME(), new GmsLocationController$start$2$1$2(objectRef, gmsLocationController, booleanRef, (Continuation<? super GmsLocationController$start$2$1$2>) null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } catch (TimeoutCancellationException unused2) {
                    mutex = mutex2;
                    try {
                        Logging.warn$default("Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.", (Throwable) null, 2, (Object) null);
                        Unit unit2 = Unit.INSTANCE;
                        mutex.unlock((Object) null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        mutex.unlock((Object) null);
                        throw th;
                    }
                }
            }
            mutex = mutex2;
            Unit unit22 = Unit.INSTANCE;
            mutex.unlock((Object) null);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            mutex = mutex2;
            th = th3;
            mutex.unlock((Object) null);
            throw th;
        }
    }
}
