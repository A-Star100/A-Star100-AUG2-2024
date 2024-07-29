package com.onesignal.core.internal.purchases.impl;

import com.amazon.device.iap.PurchasingService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.purchases.impl.TrackAmazonPurchase$setListener$1", f = "TrackAmazonPurchase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TrackAmazonPurchase.kt */
final class TrackAmazonPurchase$setListener$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TrackAmazonPurchase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrackAmazonPurchase$setListener$1(TrackAmazonPurchase trackAmazonPurchase, Continuation<? super TrackAmazonPurchase$setListener$1> continuation) {
        super(1, continuation);
        this.this$0 = trackAmazonPurchase;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TrackAmazonPurchase$setListener$1(this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((TrackAmazonPurchase$setListener$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PurchasingService.registerListener(this.this$0._applicationService.getAppContext(), this.this$0.osPurchasingListener);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
