package com.revenuecat.purchases.subscriberattributes;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "responseCode", "", "body", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesPoster.kt */
final class SubscriberAttributesPoster$postSubscriberAttributes$2 extends Lambda implements Function3<PurchasesError, Integer, JSONObject, Unit> {
    final /* synthetic */ Function3<PurchasesError, Boolean, List<SubscriberAttributeError>, Unit> $onErrorHandler;
    final /* synthetic */ Function0<Unit> $onSuccessHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SubscriberAttributesPoster$postSubscriberAttributes$2(Function0<Unit> function0, Function3<? super PurchasesError, ? super Boolean, ? super List<SubscriberAttributeError>, Unit> function3) {
        super(3);
        this.$onSuccessHandler = function0;
        this.$onErrorHandler = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((PurchasesError) obj, ((Number) obj2).intValue(), (JSONObject) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError, int i, JSONObject jSONObject) {
        Unit unit;
        Intrinsics.checkNotNullParameter(jSONObject, TtmlNode.TAG_BODY);
        if (purchasesError != null) {
            Function3<PurchasesError, Boolean, List<SubscriberAttributeError>, Unit> function3 = this.$onErrorHandler;
            boolean isServerError = RCHTTPStatusCodes.INSTANCE.isServerError(i);
            boolean z = true;
            boolean z2 = i == 404;
            if (isServerError || z2) {
                z = false;
            }
            List<SubscriberAttributeError> emptyList = CollectionsKt.emptyList();
            if (purchasesError.getCode() == PurchasesErrorCode.InvalidSubscriberAttributesError) {
                emptyList = BackendHelpersKt.getAttributeErrors(jSONObject);
            }
            function3.invoke(purchasesError, Boolean.valueOf(z), emptyList);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.$onSuccessHandler.invoke();
        }
    }
}
