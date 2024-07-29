package com.revenuecat.purchases.common.offlineentitlements;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.onesignal.common.modeling.ModelChangeTags;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.utils.Iso8601Utils;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0018\u0010\u0010\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J6\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00120\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0014J\u0010\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u00010\u0001H\u0002J\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0016\u0010\u001b\u001a\u00020\u001a2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/OfflineCustomerInfoCalculator;", "", "purchasedProductsFetcher", "Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProductsFetcher;", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "(Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProductsFetcher;Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/DateProvider;)V", "buildCustomerInfoUsingListOfPurchases", "Lcom/revenuecat/purchases/CustomerInfo;", "appUserID", "", "purchasedProducts", "", "Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProduct;", "calculateOriginalPurchaseDate", "computeOfflineCustomerInfo", "", "onSuccess", "Lkotlin/Function1;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "determineManagementURL", "kotlin.jvm.PlatformType", "generateEntitlementsResponse", "Lorg/json/JSONObject;", "generateSubscriptions", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfflineCustomerInfoCalculator.kt */
public final class OfflineCustomerInfoCalculator {
    private final AppConfig appConfig;
    private final DateProvider dateProvider;
    private final PurchasedProductsFetcher purchasedProductsFetcher;

    public OfflineCustomerInfoCalculator(PurchasedProductsFetcher purchasedProductsFetcher2, AppConfig appConfig2, DateProvider dateProvider2) {
        Intrinsics.checkNotNullParameter(purchasedProductsFetcher2, "purchasedProductsFetcher");
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        this.purchasedProductsFetcher = purchasedProductsFetcher2;
        this.appConfig = appConfig2;
        this.dateProvider = dateProvider2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OfflineCustomerInfoCalculator(PurchasedProductsFetcher purchasedProductsFetcher2, AppConfig appConfig2, DateProvider dateProvider2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasedProductsFetcher2, appConfig2, (i & 4) != 0 ? new DefaultDateProvider() : dateProvider2);
    }

    public final void computeOfflineCustomerInfo(String str, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        this.purchasedProductsFetcher.queryActiveProducts(str, new OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$1(function12, this, str, function1), new OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$2(function12));
    }

    /* access modifiers changed from: private */
    public final CustomerInfo buildCustomerInfoUsingListOfPurchases(String str, List<PurchasedProduct> list) {
        JSONObject jSONObject = new JSONObject();
        Date now = this.dateProvider.getNow();
        String format = Iso8601Utils.format(now);
        jSONObject.put(CustomerInfoResponseJsonKeys.REQUEST_DATE, format);
        jSONObject.put(CustomerInfoResponseJsonKeys.REQUEST_DATE_MS, now.getTime());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(CustomerInfoResponseJsonKeys.ORIGINAL_APP_USER_ID, str);
        jSONObject2.put(CustomerInfoResponseJsonKeys.ORIGINAL_APPLICATION_VERSION, "1.0");
        jSONObject2.put(CustomerInfoResponseJsonKeys.ENTITLEMENTS, generateEntitlementsResponse(list));
        jSONObject2.put(CustomerInfoResponseJsonKeys.FIRST_SEEN, format);
        jSONObject2.put("original_purchase_date", calculateOriginalPurchaseDate(list));
        jSONObject2.put(CustomerInfoResponseJsonKeys.NON_SUBSCRIPTIONS, new JSONObject());
        jSONObject2.put("subscriptions", generateSubscriptions(list));
        jSONObject2.put(CustomerInfoResponseJsonKeys.MANAGEMENT_URL, determineManagementURL());
        Unit unit = Unit.INSTANCE;
        jSONObject.put(CustomerInfoResponseJsonKeys.SUBSCRIBER, jSONObject2);
        return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, now, VerificationResult.VERIFIED_ON_DEVICE);
    }

    private final Object determineManagementURL() {
        return this.appConfig.getStore() == Store.PLAY_STORE ? Constants.GOOGLE_PLAY_MANAGEMENT_URL : JSONObject.NULL;
    }

    private final String calculateOriginalPurchaseDate(List<PurchasedProduct> list) {
        Comparable comparable;
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            comparable = null;
        } else {
            comparable = Long.valueOf(((PurchasedProduct) it.next()).getStoreTransaction().getPurchaseTime());
            while (it.hasNext()) {
                Comparable valueOf = Long.valueOf(((PurchasedProduct) it.next()).getStoreTransaction().getPurchaseTime());
                if (comparable.compareTo(valueOf) > 0) {
                    comparable = valueOf;
                }
            }
        }
        Long l = (Long) comparable;
        if (l == null) {
            return null;
        }
        l.longValue();
        return ISO8601Utils.format(new Date(l.longValue()));
    }

    private final JSONObject generateSubscriptions(List<PurchasedProduct> list) {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        for (PurchasedProduct purchasedProduct : list) {
            String productIdentifier = purchasedProduct.getProductIdentifier();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT, JSONObject.NULL);
            jSONObject2.put(ProductResponseJsonKeys.IS_SANDBOX, false);
            Date date = new Date(purchasedProduct.getStoreTransaction().getPurchaseTime());
            jSONObject2.put("original_purchase_date", Iso8601Utils.format(date));
            jSONObject2.put("purchase_date", Iso8601Utils.format(date));
            String lowerCase = this.appConfig.getStore().name().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject2.put(ProductResponseJsonKeys.STORE, lowerCase);
            jSONObject2.put(ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT, JSONObject.NULL);
            jSONObject2.put("product_plan_identifier", purchasedProduct.getBasePlanId());
            Date expiresDate = purchasedProduct.getExpiresDate();
            if (expiresDate == null || (obj = Iso8601Utils.format(expiresDate)) == null) {
                obj = JSONObject.NULL;
            }
            jSONObject2.put("expires_date", obj);
            String lowerCase2 = ModelChangeTags.NORMAL.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            jSONObject2.put(ProductResponseJsonKeys.PERIOD_TYPE, lowerCase2);
            Unit unit = Unit.INSTANCE;
            jSONObject.put(productIdentifier, jSONObject2);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final org.json.JSONObject generateEntitlementsResponse(java.util.List<com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct> r14) {
        /*
            r13 = this;
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r14 = r14.iterator()
        L_0x000d:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x004c
            java.lang.Object r1 = r14.next()
            com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct r1 = (com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct) r1
            java.util.List r2 = r1.getEntitlements()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r4)
            r3.<init>(r4)
            java.util.Collection r3 = (java.util.Collection) r3
            java.util.Iterator r2 = r2.iterator()
        L_0x0030:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r1)
            r3.add(r4)
            goto L_0x0030
        L_0x0044:
            java.util.List r3 = (java.util.List) r3
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            kotlin.collections.CollectionsKt.addAll(r0, r3)
            goto L_0x000d
        L_0x004c:
            java.util.List r0 = (java.util.List) r0
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>()
            java.util.Map r14 = (java.util.Map) r14
            java.util.Iterator r0 = r0.iterator()
        L_0x005b:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0089
            java.lang.Object r1 = r0.next()
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r2 = r1.getFirst()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r14.get(r2)
            if (r3 != 0) goto L_0x007d
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.List r3 = (java.util.List) r3
            r14.put(r2, r3)
        L_0x007d:
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r1 = r1.getSecond()
            com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct r1 = (com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct) r1
            r3.add(r1)
            goto L_0x005b
        L_0x0089:
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            int r1 = r14.size()
            int r1 = kotlin.collections.MapsKt.mapCapacity(r1)
            r0.<init>(r1)
            java.util.Map r0 = (java.util.Map) r0
            java.util.Set r14 = r14.entrySet()
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x00a2:
            boolean r1 = r14.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0114
            java.lang.Object r1 = r14.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            r4 = r1
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L_0x00c7
            goto L_0x0105
        L_0x00c7:
            java.lang.Object r2 = r4.next()
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L_0x00d2
            goto L_0x0105
        L_0x00d2:
            r5 = r2
            com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct r5 = (com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct) r5
            java.util.Date r5 = r5.getExpiresDate()
            r6 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r5 == 0) goto L_0x00e5
            long r8 = r5.getTime()
            goto L_0x00e6
        L_0x00e5:
            r8 = r6
        L_0x00e6:
            java.lang.Object r5 = r4.next()
            r10 = r5
            com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct r10 = (com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct) r10
            java.util.Date r10 = r10.getExpiresDate()
            if (r10 == 0) goto L_0x00f8
            long r10 = r10.getTime()
            goto L_0x00f9
        L_0x00f8:
            r10 = r6
        L_0x00f9:
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x00ff
            r2 = r5
            r8 = r10
        L_0x00ff:
            boolean r5 = r4.hasNext()
            if (r5 != 0) goto L_0x00e6
        L_0x0105:
            com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct r2 = (com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct) r2
            if (r2 != 0) goto L_0x0110
            java.lang.Object r1 = kotlin.collections.CollectionsKt.first(r1)
            r2 = r1
            com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct r2 = (com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct) r2
        L_0x0110:
            r0.put(r3, r2)
            goto L_0x00a2
        L_0x0114:
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0121:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x017d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r3 = r1.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.getValue()
            com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct r1 = (com.revenuecat.purchases.common.offlineentitlements.PurchasedProduct) r1
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.util.Date r5 = r1.getExpiresDate()
            if (r5 == 0) goto L_0x0149
            java.lang.String r5 = com.revenuecat.purchases.utils.Iso8601Utils.format(r5)
            goto L_0x014a
        L_0x0149:
            r5 = r2
        L_0x014a:
            java.lang.String r6 = "expires_date"
            r4.put(r6, r5)
            java.lang.String r5 = "product_identifier"
            java.lang.String r6 = r1.getProductIdentifier()
            r4.put(r5, r6)
            java.util.Date r5 = new java.util.Date
            com.revenuecat.purchases.models.StoreTransaction r6 = r1.getStoreTransaction()
            long r6 = r6.getPurchaseTime()
            r5.<init>(r6)
            java.lang.String r6 = "purchase_date"
            java.lang.String r5 = com.revenuecat.purchases.utils.Iso8601Utils.format(r5)
            r4.put(r6, r5)
            java.lang.String r1 = r1.getBasePlanId()
            if (r1 == 0) goto L_0x0179
            java.lang.String r5 = "product_plan_identifier"
            r4.put(r5, r1)
        L_0x0179:
            r14.put(r3, r4)
            goto L_0x0121
        L_0x017d:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.offlineentitlements.OfflineCustomerInfoCalculator.generateEntitlementsResponse(java.util.List):org.json.JSONObject");
    }
}
