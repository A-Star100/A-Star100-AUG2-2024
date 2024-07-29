package com.revenuecat.purchases.common;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.utils.DateActive;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0002\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0002\u001a,\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a,\u0010\u0012\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u001a\u0014\u0010\u0016\u001a\u00020\u0003*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nH\u0000\u001a\u0014\u0010\u001a\u001a\u00020\u001b*\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\nH\u0000¨\u0006\u001c"}, d2 = {"getWillRenew", "", "store", "Lcom/revenuecat/purchases/Store;", "expirationDate", "Ljava/util/Date;", "unsubscribeDetectedAt", "billingIssueDetectedAt", "isDateActive", "identifier", "", "requestDate", "buildEntitlementInfo", "Lcom/revenuecat/purchases/EntitlementInfo;", "Lorg/json/JSONObject;", "productData", "verificationResult", "Lcom/revenuecat/purchases/VerificationResult;", "buildEntitlementInfos", "Lcom/revenuecat/purchases/EntitlementInfos;", "subscriptions", "nonSubscriptionsLatestPurchases", "getStore", "name", "optOwnershipType", "Lcom/revenuecat/purchases/OwnershipType;", "optPeriodType", "Lcom/revenuecat/purchases/PeriodType;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: EntitlementInfoFactories.kt */
public final class EntitlementInfoFactoriesKt {
    public static final EntitlementInfos buildEntitlementInfos(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, Date date, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(jSONObject2, "subscriptions");
        Intrinsics.checkNotNullParameter(jSONObject3, "nonSubscriptionsLatestPurchases");
        Intrinsics.checkNotNullParameter(date, "requestDate");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        Map linkedHashMap = new LinkedHashMap();
        Iterator<String> keys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys()");
        while (keys.hasNext()) {
            String next = keys.next();
            JSONObject jSONObject4 = jSONObject.getJSONObject(next);
            String optString = jSONObject4.optString(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER);
            Intrinsics.checkNotNullExpressionValue(optString, "it");
            if (optString.length() <= 0) {
                optString = null;
            }
            if (optString != null) {
                if (jSONObject2.has(optString)) {
                    Intrinsics.checkNotNullExpressionValue(next, "entitlementId");
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "entitlement");
                    JSONObject jSONObject5 = jSONObject2.getJSONObject(optString);
                    Intrinsics.checkNotNullExpressionValue(jSONObject5, "subscriptions.getJSONObject(productIdentifier)");
                    linkedHashMap.put(next, buildEntitlementInfo(jSONObject4, next, jSONObject5, date, verificationResult));
                } else if (jSONObject3.has(optString)) {
                    Intrinsics.checkNotNullExpressionValue(next, "entitlementId");
                    Intrinsics.checkNotNullExpressionValue(jSONObject4, "entitlement");
                    JSONObject jSONObject6 = jSONObject3.getJSONObject(optString);
                    Intrinsics.checkNotNullExpressionValue(jSONObject6, "nonSubscriptionsLatestPu…Object(productIdentifier)");
                    linkedHashMap.put(next, buildEntitlementInfo(jSONObject4, next, jSONObject6, date, verificationResult));
                }
            }
        }
        return new EntitlementInfos(linkedHashMap, verificationResult);
    }

    public static final Store getStore(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        String string = jSONObject.getString(str);
        if (string != null) {
            switch (string.hashCode()) {
                case -1414265340:
                    if (string.equals("amazon")) {
                        return Store.AMAZON;
                    }
                    break;
                case -891985843:
                    if (string.equals("stripe")) {
                        return Store.STRIPE;
                    }
                    break;
                case 564036179:
                    if (string.equals("mac_app_store")) {
                        return Store.MAC_APP_STORE;
                    }
                    break;
                case 756050958:
                    if (string.equals("promotional")) {
                        return Store.PROMOTIONAL;
                    }
                    break;
                case 1842542915:
                    if (string.equals("app_store")) {
                        return Store.APP_STORE;
                    }
                    break;
                case 1925951510:
                    if (string.equals("play_store")) {
                        return Store.PLAY_STORE;
                    }
                    break;
            }
        }
        return Store.UNKNOWN_STORE;
    }

    public static final PeriodType optPeriodType(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        String optString = jSONObject.optString(str);
        if (optString != null) {
            int hashCode = optString.hashCode();
            if (hashCode != -1039745817) {
                if (hashCode != 100361836) {
                    if (hashCode == 110628630 && optString.equals("trial")) {
                        return PeriodType.TRIAL;
                    }
                } else if (optString.equals("intro")) {
                    return PeriodType.INTRO;
                }
            } else if (optString.equals("normal")) {
                return PeriodType.NORMAL;
            }
        }
        return PeriodType.NORMAL;
    }

    public static final OwnershipType optOwnershipType(JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        String optString = jSONObject.optString(str);
        if (Intrinsics.areEqual((Object) optString, (Object) "PURCHASED")) {
            return OwnershipType.PURCHASED;
        }
        if (Intrinsics.areEqual((Object) optString, (Object) "FAMILY_SHARED")) {
            return OwnershipType.FAMILY_SHARED;
        }
        return OwnershipType.UNKNOWN;
    }

    public static final EntitlementInfo buildEntitlementInfo(JSONObject jSONObject, String str, JSONObject jSONObject2, Date date, VerificationResult verificationResult) {
        JSONObject jSONObject3 = jSONObject;
        String str2 = str;
        JSONObject jSONObject4 = jSONObject2;
        Date date2 = date;
        String str3 = str;
        Intrinsics.checkNotNullParameter(jSONObject3, "<this>");
        Intrinsics.checkNotNullParameter(str2, "identifier");
        Intrinsics.checkNotNullParameter(jSONObject4, "productData");
        Intrinsics.checkNotNullParameter(date2, "requestDate");
        Intrinsics.checkNotNullParameter(verificationResult, "verificationResult");
        Date optDate = JSONObjectExtensionsKt.optDate(jSONObject3, "expires_date");
        Date date3 = optDate;
        Date optDate2 = JSONObjectExtensionsKt.optDate(jSONObject4, ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT);
        Date date4 = optDate2;
        Date optDate3 = JSONObjectExtensionsKt.optDate(jSONObject4, ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT);
        Date date5 = optDate3;
        Store store = getStore(jSONObject4, ProductResponseJsonKeys.STORE);
        Store store2 = store;
        boolean isDateActive = isDateActive(str2, optDate, date2);
        boolean willRenew = getWillRenew(store, optDate, optDate2, optDate3);
        PeriodType optPeriodType = optPeriodType(jSONObject4, ProductResponseJsonKeys.PERIOD_TYPE);
        Date date6 = JSONObjectExtensionsKt.getDate(jSONObject3, "purchase_date");
        Date date7 = JSONObjectExtensionsKt.getDate(jSONObject4, "original_purchase_date");
        String string = jSONObject3.getString(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER);
        String str4 = string;
        Intrinsics.checkNotNullExpressionValue(string, "getString(EntitlementsRe…nKeys.PRODUCT_IDENTIFIER)");
        return new EntitlementInfo(str3, isDateActive, willRenew, optPeriodType, date6, date7, date3, store2, str4, JSONObjectExtensionsKt.optNullableString(jSONObject3, "product_plan_identifier"), jSONObject4.getBoolean(ProductResponseJsonKeys.IS_SANDBOX), date4, date5, optOwnershipType(jSONObject4, ProductResponseJsonKeys.OWNERSHIP_TYPE), jSONObject, verificationResult);
    }

    private static final boolean isDateActive(String str, Date date, Date date2) {
        DateActive r0 = DateHelper.Companion.m1109isDateActiveSxA4cEA$default(DateHelper.Companion, date, date2, 0, 4, (Object) null);
        if (!r0.isActive() && !r0.getInGracePeriod()) {
            String format = String.format(PurchaseStrings.ENTITLEMENT_EXPIRED_OUTSIDE_GRACE_PERIOD, Arrays.copyOf(new Object[]{str, date, date2}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.warnLog(format);
        }
        return r0.isActive();
    }

    private static final boolean getWillRenew(Store store, Date date, Date date2, Date date3) {
        return !(store == Store.PROMOTIONAL) && !(date == null) && !(date2 != null) && !(date3 != null);
    }
}
