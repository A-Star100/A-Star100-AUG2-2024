package com.onesignal.debug.internal.logging;

import android.app.Activity;
import android.app.AlertDialog;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.debug.internal.logging.Logging$log$1", f = "Logging.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: Logging.kt */
final class Logging$log$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $finalFullMessage;
    final /* synthetic */ LogLevel $level;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Logging$log$1(LogLevel logLevel, String str, Continuation<? super Logging$log$1> continuation) {
        super(1, continuation);
        this.$level = logLevel;
        this.$finalFullMessage = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Logging$log$1(this.$level, this.$finalFullMessage, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((Logging$log$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IApplicationService applicationService = Logging.INSTANCE.getApplicationService();
            Activity current = applicationService != null ? applicationService.getCurrent() : null;
            if (current != null) {
                new AlertDialog.Builder(current).setTitle(this.$level.toString()).setMessage(this.$finalFullMessage).show();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
