package com.onesignal.user.internal.subscriptions.impl;

import com.onesignal.user.internal.subscriptions.ISubscriptionChangedHandler;
import com.onesignal.user.subscriptions.ISubscription;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionManager.kt */
final class SubscriptionManager$createSubscriptionAndAddToSubscriptionList$1 extends Lambda implements Function1<ISubscriptionChangedHandler, Unit> {
    final /* synthetic */ ISubscription $subscription;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriptionManager$createSubscriptionAndAddToSubscriptionList$1(ISubscription iSubscription) {
        super(1);
        this.$subscription = iSubscription;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ISubscriptionChangedHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ISubscriptionChangedHandler iSubscriptionChangedHandler) {
        Intrinsics.checkNotNullParameter(iSubscriptionChangedHandler, "it");
        iSubscriptionChangedHandler.onSubscriptionAdded(this.$subscription);
    }
}
