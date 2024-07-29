package com.onesignal.notifications.internal.registration.impl;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2", f = "PushRegistratorFCM.kt", i = {0}, l = {120}, m = "invokeSuspend", n = {"token"}, s = {"L$0"})
/* compiled from: PushRegistratorFCM.kt */
final class PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ PushRegistratorFCM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2(PushRegistratorFCM pushRegistratorFCM, Continuation<? super PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2> continuation) {
        super(2, continuation);
        this.this$0 = pushRegistratorFCM;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.ObjectRef objectRef;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.element = "";
            final PushRegistratorFCM pushRegistratorFCM = this.this$0;
            this.L$0 = objectRef2;
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getDefault(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            objectRef = objectRef2;
        } else if (i == 1) {
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return objectRef.element;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2$1", f = "PushRegistratorFCM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2$1  reason: invalid class name */
    /* compiled from: PushRegistratorFCM.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(pushRegistratorFCM, objectRef2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FirebaseApp access$getFirebaseApp$p = pushRegistratorFCM.firebaseApp;
                Intrinsics.checkNotNull(access$getFirebaseApp$p);
                Task token = ((FirebaseMessaging) access$getFirebaseApp$p.get(FirebaseMessaging.class)).getToken();
                Intrinsics.checkNotNullExpressionValue(token, "fcmInstance.token");
                try {
                    Ref.ObjectRef<String> objectRef = objectRef2;
                    T await = Tasks.await(token);
                    Intrinsics.checkNotNullExpressionValue(await, "await(tokenTask)");
                    objectRef.element = await;
                    return Unit.INSTANCE;
                } catch (ExecutionException e) {
                    Exception exception = token.getException();
                    throw (exception == null ? e : exception);
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
