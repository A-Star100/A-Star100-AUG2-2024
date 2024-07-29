package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/FlowCollector;", "downstream", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {215, 418}, m = "invokeSuspend", n = {"downstream", "values", "lastValue", "timeoutMillis", "downstream", "values", "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounceInternal$1 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<T> $this_debounceInternal;
    final /* synthetic */ Function1<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounceInternal$1(Function1<? super T, Long> function1, Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$debounceInternal$1> continuation) {
        super(3, continuation);
        this.$timeoutMillisSelector = function1;
        this.$this_debounceInternal = flow;
    }

    public final Object invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, continuation);
        flowKt__DelayKt$debounceInternal$1.L$0 = coroutineScope;
        flowKt__DelayKt$debounceInternal$1.L$1 = flowCollector;
        return flowKt__DelayKt$debounceInternal$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x011f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0120  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            r7 = 0
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x002f
            if (r2 != r3) goto L_0x0027
            java.lang.Object r2 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            kotlin.ResultKt.throwOnFailure(r18)
            r10 = r9
            r9 = r8
            r8 = r2
            r2 = r0
            goto L_0x006f
        L_0x0027:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002f:
            java.lang.Object r2 = r0.L$3
            kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
            java.lang.Object r8 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
            kotlin.ResultKt.throwOnFailure(r18)
            r11 = r2
            r2 = r0
            goto L_0x00ba
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            r8 = r2
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            r9 = 0
            r10 = 0
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1 r11 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$values$1
            kotlinx.coroutines.flow.Flow<T> r12 = r0.$this_debounceInternal
            r11.<init>(r12, r7)
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11
            r12 = 3
            r13 = 0
            kotlinx.coroutines.channels.ReceiveChannel r8 = kotlinx.coroutines.channels.ProduceKt.produce$default(r8, r9, r10, r11, r12, r13)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            r10 = r2
            r2 = r0
            r16 = r9
            r9 = r8
            r8 = r16
        L_0x006f:
            T r11 = r8.element
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE
            if (r11 == r12) goto L_0x0127
            kotlin.jvm.internal.Ref$LongRef r11 = new kotlin.jvm.internal.Ref$LongRef
            r11.<init>()
            T r12 = r8.element
            if (r12 == 0) goto L_0x00bc
            kotlin.jvm.functions.Function1<T, java.lang.Long> r12 = r2.$timeoutMillisSelector
            kotlinx.coroutines.internal.Symbol r13 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r14 = r8.element
            if (r14 != r13) goto L_0x0087
            r14 = r7
        L_0x0087:
            java.lang.Object r12 = r12.invoke(r14)
            java.lang.Number r12 = (java.lang.Number) r12
            long r12 = r12.longValue()
            r11.element = r12
            long r12 = r11.element
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 < 0) goto L_0x00c2
            long r12 = r11.element
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 != 0) goto L_0x00bc
            kotlinx.coroutines.internal.Symbol r12 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            T r13 = r8.element
            if (r13 != r12) goto L_0x00a6
            r13 = r7
        L_0x00a6:
            r12 = r2
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r2.L$0 = r10
            r2.L$1 = r9
            r2.L$2 = r8
            r2.L$3 = r11
            r2.label = r4
            java.lang.Object r12 = r10.emit(r13, r12)
            if (r12 != r1) goto L_0x00ba
            return r1
        L_0x00ba:
            r8.element = r7
        L_0x00bc:
            r16 = r8
            r8 = r2
            r2 = r16
            goto L_0x00ce
        L_0x00c2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Debounce timeout should not be negative"
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00ce:
            boolean r12 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r12 == 0) goto L_0x00e5
            T r12 = r2.element
            if (r12 == 0) goto L_0x00e5
            long r12 = r11.element
            int r12 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r12 <= 0) goto L_0x00df
            goto L_0x00e5
        L_0x00df:
            java.lang.AssertionError r1 = new java.lang.AssertionError
            r1.<init>()
            throw r1
        L_0x00e5:
            kotlinx.coroutines.selects.SelectImplementation r12 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r13 = r8.getContext()
            r12.<init>(r13)
            r13 = r12
            kotlinx.coroutines.selects.SelectBuilder r13 = (kotlinx.coroutines.selects.SelectBuilder) r13
            T r14 = r2.element
            if (r14 == 0) goto L_0x0101
            long r14 = r11.element
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1 r11 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$1
            r11.<init>(r10, r2, r7)
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
            kotlinx.coroutines.selects.OnTimeoutKt.onTimeout(r13, r14, r11)
        L_0x0101:
            kotlinx.coroutines.selects.SelectClause1 r11 = r9.getOnReceiveCatching()
            kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2 r14 = new kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2
            r14.<init>(r2, r10, r7)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r13.invoke(r11, r14)
            r8.L$0 = r10
            r8.L$1 = r9
            r8.L$2 = r2
            r8.L$3 = r7
            r8.label = r3
            java.lang.Object r11 = r12.doSelect(r8)
            if (r11 != r1) goto L_0x0120
            return r1
        L_0x0120:
            r16 = r8
            r8 = r2
            r2 = r16
            goto L_0x006f
        L_0x0127:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
