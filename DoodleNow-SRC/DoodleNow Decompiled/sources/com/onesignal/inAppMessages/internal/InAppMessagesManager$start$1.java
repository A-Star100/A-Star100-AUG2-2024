package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$start$1", f = "InAppMessagesManager.kt", i = {}, l = {141, 144, 152}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$start$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$start$1(InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$start$1> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessagesManager;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$start$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$start$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e A[LOOP:0: B:17:0x0068->B:19:0x006e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0089 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r4) goto L_0x0026
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x008a
        L_0x0016:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001e:
            java.lang.Object r1 = r5.L$0
            java.util.List r1 = (java.util.List) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0059
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r6)
            com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
            com.onesignal.inAppMessages.internal.repositories.IInAppRepository r6 = r6._repository
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r4
            java.lang.Object r6 = r6.cleanCachedInAppMessages(r1)
            if (r6 != r0) goto L_0x003f
            return r0
        L_0x003f:
            com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
            java.util.List r1 = r6.redisplayedInAppMessages
            com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
            com.onesignal.inAppMessages.internal.repositories.IInAppRepository r6 = r6._repository
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.L$0 = r1
            r5.label = r3
            java.lang.Object r6 = r6.listInAppMessages(r4)
            if (r6 != r0) goto L_0x0059
            return r0
        L_0x0059:
            java.util.Collection r6 = (java.util.Collection) r6
            r1.addAll(r6)
            com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
            java.util.List r6 = r6.redisplayedInAppMessages
            java.util.Iterator r6 = r6.iterator()
        L_0x0068:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r6.next()
            com.onesignal.inAppMessages.internal.InAppMessage r1 = (com.onesignal.inAppMessages.internal.InAppMessage) r1
            r3 = 0
            r1.setDisplayedInSession(r3)
            goto L_0x0068
        L_0x0079:
            com.onesignal.inAppMessages.internal.InAppMessagesManager r6 = r5.this$0
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r3 = 0
            r5.L$0 = r3
            r5.label = r2
            java.lang.Object r6 = r6.fetchMessages(r1)
            if (r6 != r0) goto L_0x008a
            return r0
        L_0x008a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
