package androidx.privacysandbox.ads.adservices.java.customaudience;

import androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager;
import androidx.privacysandbox.ads.adservices.customaudience.JoinCustomAudienceRequest;
import androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.customaudience.CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1", f = "CustomAudienceManagerFutures.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CustomAudienceManagerFutures.kt */
final class CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JoinCustomAudienceRequest $request;
    int label;
    final /* synthetic */ CustomAudienceManagerFutures.Api33Ext4JavaImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(CustomAudienceManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, JoinCustomAudienceRequest joinCustomAudienceRequest, Continuation<? super CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1> continuation) {
        super(2, continuation);
        this.this$0 = api33Ext4JavaImpl;
        this.$request = joinCustomAudienceRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomAudienceManagerFutures$Api33Ext4JavaImpl$joinCustomAudienceAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CustomAudienceManager access$getMCustomAudienceManager$p = this.this$0.mCustomAudienceManager;
            Intrinsics.checkNotNull(access$getMCustomAudienceManager$p);
            this.label = 1;
            if (access$getMCustomAudienceManager$p.joinCustomAudience(this.$request, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
