package com.onesignal.core.internal.background.impl;

import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.background.impl.BackgroundManager$runBackgroundServices$2", f = "BackgroundManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BackgroundManager.kt */
final class BackgroundManager$runBackgroundServices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BackgroundManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BackgroundManager$runBackgroundServices$2(BackgroundManager backgroundManager, Continuation<? super BackgroundManager$runBackgroundServices$2> continuation) {
        super(2, continuation);
        this.this$0 = backgroundManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BackgroundManager$runBackgroundServices$2 backgroundManager$runBackgroundServices$2 = new BackgroundManager$runBackgroundServices$2(this.this$0, continuation);
        backgroundManager$runBackgroundServices$2.L$0 = obj;
        return backgroundManager$runBackgroundServices$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BackgroundManager$runBackgroundServices$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Logging.debug$default("OSBackground sync, calling initWithContext", (Throwable) null, 2, (Object) null);
            BackgroundManager backgroundManager = this.this$0;
            final BackgroundManager backgroundManager2 = this.this$0;
            backgroundManager.backgroundSyncJob = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, Dispatchers.getUnconfined(), (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 2, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.onesignal.core.internal.background.impl.BackgroundManager$runBackgroundServices$2$1", f = "BackgroundManager.kt", i = {}, l = {125}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.onesignal.core.internal.background.impl.BackgroundManager$runBackgroundServices$2$1  reason: invalid class name */
    /* compiled from: BackgroundManager.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(backgroundManager2, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Object access$getLock$p = backgroundManager2.lock;
                BackgroundManager backgroundManager = backgroundManager2;
                synchronized (access$getLock$p) {
                    backgroundManager.nextScheduledSyncTimeMs = 0;
                    Unit unit = Unit.INSTANCE;
                }
                it = backgroundManager2._backgroundServices.iterator();
            } else if (i == 1) {
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                this.L$0 = it;
                this.label = 1;
                if (((IBackgroundService) it.next()).backgroundRun(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            backgroundManager2.scheduleBackground();
            return Unit.INSTANCE;
        }
    }
}
