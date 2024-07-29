package com.revenuecat.purchases.common.subscriberattributes;

import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getSubscriberAttributeKey", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SpecialSubscriberAttributes.kt */
public final class SpecialSubscriberAttributesKt {
    public static final SubscriberAttributeKey getSubscriberAttributeKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual((Object) str, (Object) ReservedSubscriberAttribute.EMAIL.getValue())) {
            return SubscriberAttributeKey.Email.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) str, (Object) ReservedSubscriberAttribute.DISPLAY_NAME.getValue())) {
            return SubscriberAttributeKey.DisplayName.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) str, (Object) ReservedSubscriberAttribute.PHONE_NUMBER.getValue())) {
            return SubscriberAttributeKey.PhoneNumber.INSTANCE;
        }
        if (Intrinsics.areEqual((Object) str, (Object) ReservedSubscriberAttribute.FCM_TOKENS.getValue())) {
            return SubscriberAttributeKey.FCMTokens.INSTANCE;
        }
        return new SubscriberAttributeKey.Custom(str);
    }
}
