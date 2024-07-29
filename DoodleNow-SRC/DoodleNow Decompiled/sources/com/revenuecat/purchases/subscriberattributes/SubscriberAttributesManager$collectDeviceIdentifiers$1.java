package com.revenuecat.purchases.subscriberattributes;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "deviceIdentifiers", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesManager.kt */
final class SubscriberAttributesManager$collectDeviceIdentifiers$1 extends Lambda implements Function1<Map<String, ? extends String>, Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ SubscriberAttributesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesManager$collectDeviceIdentifiers$1(SubscriberAttributesManager subscriberAttributesManager, String str) {
        super(1);
        this.this$0 = subscriberAttributesManager;
        this.$appUserID = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, String>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "deviceIdentifiers");
        this.this$0.setAttributes(map, this.$appUserID);
    }
}
