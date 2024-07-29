package com.revenuecat.purchases.identity;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.IdentityStrings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: IdentityManager.kt */
final class IdentityManager$logOut$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $completion;
    final /* synthetic */ IdentityManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    IdentityManager$logOut$1(IdentityManager identityManager, Function1<? super PurchasesError, Unit> function1) {
        super(0);
        this.this$0 = identityManager;
        this.$completion = function1;
    }

    public final void invoke() {
        IdentityManager identityManager = this.this$0;
        identityManager.resetAndSaveUserID(identityManager.generateRandomID());
        LogWrapperKt.log(LogIntent.USER, IdentityStrings.LOG_OUT_SUCCESSFUL);
        this.$completion.invoke(null);
    }
}
