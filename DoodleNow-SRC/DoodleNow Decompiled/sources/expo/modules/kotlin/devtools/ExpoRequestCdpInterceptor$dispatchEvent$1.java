package expo.modules.kotlin.devtools;

import expo.modules.kotlin.devtools.ExpoRequestCdpInterceptor;
import expo.modules.kotlin.devtools.cdp.Event;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "expo.modules.kotlin.devtools.ExpoRequestCdpInterceptor$dispatchEvent$1", f = "ExpoRequestCdpInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ExpoRequestCdpInterceptor.kt */
final class ExpoRequestCdpInterceptor$dispatchEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Event $event;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ExpoRequestCdpInterceptor$dispatchEvent$1(Event event, Continuation<? super ExpoRequestCdpInterceptor$dispatchEvent$1> continuation) {
        super(2, continuation);
        this.$event = event;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ExpoRequestCdpInterceptor$dispatchEvent$1(this.$event, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ExpoRequestCdpInterceptor$dispatchEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            ExpoRequestCdpInterceptor.Delegate access$getDelegate$p = ExpoRequestCdpInterceptor.delegate;
            if (access$getDelegate$p != null) {
                access$getDelegate$p.dispatch(this.$event.toJson());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
