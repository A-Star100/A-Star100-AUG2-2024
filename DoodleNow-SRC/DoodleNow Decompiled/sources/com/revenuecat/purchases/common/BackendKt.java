package com.revenuecat.purchases.common;

import com.revenuecat.purchases.models.PricingPhase;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004*\u00020\u0006H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000*\u0018\b\u0000\u0010\u0007\"\b\u0012\u0004\u0012\u00020\u00010\b2\b\u0012\u0004\u0012\u00020\u00010\b*~\b\u0000\u0010\t\";\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012%\u0012#\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000e0\n2;\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b\u0012%\u0012#\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000e0\n*`\b\u0000\u0010\u0014\",\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000e0\n2,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000e0\n*`\b\u0000\u0010\u0016\",\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b0\n2,\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b0\n*~\b\u0000\u0010\u0017\";\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u000b\u0012%\u0012#\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000e0\n2;\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\r0\u000b\u0012%\u0012#\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000e0\n*T\b\u0000\u0010\u0018\"&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0019\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000e0\n2&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0019\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000e0\n*\u0001\b\u0000\u0010\u001a\"\u000e\u0012\u0004\u0012\u0002`\u001b\u0012\u0004\u0012\u0002`\u001c0\n2o\u0012)\u0012'\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u000ej\u0002`\u001b\u0012@\u0012>\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u001ej\u0002`\u001c0\n*|\b\u0000\u0010!\":\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u001e2:\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u001e*N\b\u0000\u0010\"\"#\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u000e2#\u0012\u0004\u0012\u00020\f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\r0\u000e*T\b\u0000\u0010#\"&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b0\n2&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u000b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u000b0\n¨\u0006%"}, d2 = {"ATTRIBUTES_ERROR_RESPONSE_KEY", "", "ATTRIBUTE_ERRORS_KEY", "toMap", "", "", "Lcom/revenuecat/purchases/models/PricingPhase;", "CallbackCacheKey", "", "CustomerInfoCallback", "Lkotlin/Pair;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/PurchasesError;", "", "Lkotlin/ParameterName;", "name", "isServerError", "DiagnosticsCallback", "Lorg/json/JSONObject;", "IdentifyCallback", "OfferingsCallback", "PaywallEventsCallback", "Lkotlin/Function0;", "PostReceiptCallback", "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "body", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "postReceiptErrorHandlingBehavior", "PostReceiptDataErrorCallback", "PostReceiptDataSuccessCallback", "ProductEntitlementCallback", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Backend.kt */
public final class BackendKt {
    public static final String ATTRIBUTES_ERROR_RESPONSE_KEY = "attributes_error_response";
    public static final String ATTRIBUTE_ERRORS_KEY = "attribute_errors";

    public static final Map<String, Object> toMap(PricingPhase pricingPhase) {
        Intrinsics.checkNotNullParameter(pricingPhase, "<this>");
        return MapsKt.mapOf(TuplesKt.to("billingPeriod", pricingPhase.getBillingPeriod().getIso8601()), TuplesKt.to("billingCycleCount", pricingPhase.getBillingCycleCount()), TuplesKt.to("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier()), TuplesKt.to("formattedPrice", pricingPhase.getPrice().getFormatted()), TuplesKt.to("priceAmountMicros", Long.valueOf(pricingPhase.getPrice().getAmountMicros())), TuplesKt.to("priceCurrencyCode", pricingPhase.getPrice().getCurrencyCode()));
    }
}
