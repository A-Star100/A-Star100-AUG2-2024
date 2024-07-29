package com.onesignal.notifications.internal.registration.impl;

import com.google.firebase.FirebaseApp;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2", f = "PushRegistratorFCM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PushRegistratorFCM.kt */
final class PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $senderId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PushRegistratorFCM this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2(PushRegistratorFCM pushRegistratorFCM, String str, Continuation<? super PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2> continuation) {
        super(2, continuation);
        this.this$0 = pushRegistratorFCM;
        this.$senderId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2 pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2 = new PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2(this.this$0, this.$senderId, continuation);
        pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2.L$0 = obj;
        return pushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Exception exc;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            try {
                Object invoke = Class.forName("com.google.firebase.iid.FirebaseInstanceId").getMethod("getInstance", new Class[]{FirebaseApp.class}).invoke((Object) null, new Object[]{this.this$0.firebaseApp});
                Method method = invoke.getClass().getMethod("getToken", new Class[]{String.class, String.class});
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getDefault(), (CoroutineStart) null, new PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1(method, invoke, this.$senderId, objectRef, (Continuation<? super PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2$exception$1>) null), 2, (Object) null);
                return objectRef.element;
            } catch (ClassNotFoundException e) {
                exc = e;
                throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", exc);
            } catch (NoSuchMethodException e2) {
                exc = e2;
                throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", exc);
            } catch (IllegalAccessException e3) {
                exc = e3;
                throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", exc);
            } catch (InvocationTargetException e4) {
                exc = e4;
                throw new Error("Reflection error on FirebaseInstanceId.getInstance(firebaseApp).getToken(senderId, FirebaseMessaging.INSTANCE_ID_SCOPE)", exc);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
