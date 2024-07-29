package com.onesignal.core.internal.preferences.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.preferences.impl.PreferencesService$doWorkAsync$1", f = "PreferencesService.kt", i = {0, 1}, l = {221, 225}, m = "invokeSuspend", n = {"lastSyncTime", "lastSyncTime"}, s = {"J$0", "J$0"})
/* compiled from: PreferencesService.kt */
final class PreferencesService$doWorkAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ PreferencesService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PreferencesService$doWorkAsync$1(PreferencesService preferencesService, Continuation<? super PreferencesService$doWorkAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = preferencesService;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PreferencesService$doWorkAsync$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PreferencesService$doWorkAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b A[Catch:{ all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0068 A[Catch:{ all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072 A[Catch:{ all -> 0x011c }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x011b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e1 A[EDGE_INSN: B:73:0x00e1->B:54:0x00e1 ?: BREAK  , SYNTHETIC] */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0029
            if (r1 == r3) goto L_0x001c
            if (r1 != r2) goto L_0x0014
            long r4 = r13.J$0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0024 }
            goto L_0x0036
        L_0x0014:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001c:
            long r4 = r13.J$0
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ all -> 0x0024 }
            r14 = r13
            goto L_0x0108
        L_0x0024:
            r14 = move-exception
            r1 = r0
            r0 = r13
            goto L_0x0121
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r14)
            com.onesignal.core.internal.preferences.impl.PreferencesService r14 = r13.this$0
            com.onesignal.core.internal.time.ITime r14 = r14._time
            long r4 = r14.getCurrentTimeMillis()
        L_0x0036:
            r14 = r13
        L_0x0037:
            com.onesignal.core.internal.preferences.impl.PreferencesService r1 = r14.this$0     // Catch:{ all -> 0x011c }
            java.util.Map r1 = r1.prefsToApply     // Catch:{ all -> 0x011c }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x011c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x011c }
        L_0x0045:
            boolean r6 = r1.hasNext()     // Catch:{ all -> 0x011c }
            if (r6 == 0) goto L_0x00e1
            java.lang.Object r6 = r1.next()     // Catch:{ all -> 0x011c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x011c }
            com.onesignal.core.internal.preferences.impl.PreferencesService r7 = r14.this$0     // Catch:{ all -> 0x011c }
            java.util.Map r7 = r7.prefsToApply     // Catch:{ all -> 0x011c }
            java.lang.Object r7 = r7.get(r6)     // Catch:{ all -> 0x011c }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)     // Catch:{ all -> 0x011c }
            java.util.Map r7 = (java.util.Map) r7     // Catch:{ all -> 0x011c }
            com.onesignal.core.internal.preferences.impl.PreferencesService r8 = r14.this$0     // Catch:{ all -> 0x011c }
            android.content.SharedPreferences r6 = r8.getSharedPrefsByName(r6)     // Catch:{ all -> 0x011c }
            if (r6 != 0) goto L_0x0072
            com.onesignal.core.internal.preferences.impl.PreferencesService r6 = r14.this$0     // Catch:{ all -> 0x011c }
            com.onesignal.common.threading.Waiter r6 = r6.waiter     // Catch:{ all -> 0x011c }
            r6.wake()     // Catch:{ all -> 0x011c }
            goto L_0x0045
        L_0x0072:
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ all -> 0x011c }
            monitor-enter(r7)     // Catch:{ all -> 0x011c }
            java.util.Set r8 = r7.keySet()     // Catch:{ all -> 0x00de }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00de }
        L_0x007f:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x00de }
            if (r9 == 0) goto L_0x00d3
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x00de }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00de }
            java.lang.Object r10 = r7.get(r9)     // Catch:{ all -> 0x00de }
            boolean r11 = r10 instanceof java.lang.String     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x0099
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x00de }
            r6.putString(r9, r10)     // Catch:{ all -> 0x00de }
            goto L_0x007f
        L_0x0099:
            boolean r11 = r10 instanceof java.lang.Boolean     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x00a7
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x00de }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x00de }
            r6.putBoolean(r9, r10)     // Catch:{ all -> 0x00de }
            goto L_0x007f
        L_0x00a7:
            boolean r11 = r10 instanceof java.lang.Integer     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x00b5
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x00de }
            int r10 = r10.intValue()     // Catch:{ all -> 0x00de }
            r6.putInt(r9, r10)     // Catch:{ all -> 0x00de }
            goto L_0x007f
        L_0x00b5:
            boolean r11 = r10 instanceof java.lang.Long     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x00c3
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x00de }
            long r10 = r10.longValue()     // Catch:{ all -> 0x00de }
            r6.putLong(r9, r10)     // Catch:{ all -> 0x00de }
            goto L_0x007f
        L_0x00c3:
            boolean r11 = r10 instanceof java.util.Set     // Catch:{ all -> 0x00de }
            if (r11 == 0) goto L_0x00cd
            java.util.Set r10 = (java.util.Set) r10     // Catch:{ all -> 0x00de }
            r6.putStringSet(r9, r10)     // Catch:{ all -> 0x00de }
            goto L_0x007f
        L_0x00cd:
            if (r10 != 0) goto L_0x007f
            r6.remove(r9)     // Catch:{ all -> 0x00de }
            goto L_0x007f
        L_0x00d3:
            r7.clear()     // Catch:{ all -> 0x00de }
            kotlin.Unit r8 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00de }
            monitor-exit(r7)     // Catch:{ all -> 0x011c }
            r6.apply()     // Catch:{ all -> 0x011c }
            goto L_0x0045
        L_0x00de:
            r1 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x011c }
            throw r1     // Catch:{ all -> 0x011c }
        L_0x00e1:
            com.onesignal.core.internal.preferences.impl.PreferencesService r1 = r14.this$0     // Catch:{ all -> 0x011c }
            com.onesignal.core.internal.time.ITime r1 = r1._time     // Catch:{ all -> 0x011c }
            long r6 = r1.getCurrentTimeMillis()     // Catch:{ all -> 0x011c }
            long r4 = r4 - r6
            r1 = 200(0xc8, float:2.8E-43)
            long r8 = (long) r1
            long r4 = r4 + r8
            r8 = 0
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 <= 0) goto L_0x0107
            r1 = r14
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch:{ all -> 0x0104 }
            r14.J$0 = r6     // Catch:{ all -> 0x0104 }
            r14.label = r3     // Catch:{ all -> 0x0104 }
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r4, r1)     // Catch:{ all -> 0x0104 }
            if (r1 != r0) goto L_0x0107
            return r0
        L_0x0104:
            r1 = move-exception
            r4 = r6
            goto L_0x011d
        L_0x0107:
            r4 = r6
        L_0x0108:
            com.onesignal.core.internal.preferences.impl.PreferencesService r1 = r14.this$0     // Catch:{ all -> 0x011c }
            com.onesignal.common.threading.Waiter r1 = r1.waiter     // Catch:{ all -> 0x011c }
            r6 = r14
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch:{ all -> 0x011c }
            r14.J$0 = r4     // Catch:{ all -> 0x011c }
            r14.label = r2     // Catch:{ all -> 0x011c }
            java.lang.Object r1 = r1.waitForWake(r6)     // Catch:{ all -> 0x011c }
            if (r1 != r0) goto L_0x0037
            return r0
        L_0x011c:
            r1 = move-exception
        L_0x011d:
            r12 = r0
            r0 = r14
            r14 = r1
            r1 = r12
        L_0x0121:
            com.onesignal.debug.LogLevel r6 = com.onesignal.debug.LogLevel.ERROR
            java.lang.String r7 = "Error with Preference work loop"
            com.onesignal.debug.internal.logging.Logging.log(r6, r7, r14)
            r14 = r0
            r0 = r1
            goto L_0x0037
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.preferences.impl.PreferencesService$doWorkAsync$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
