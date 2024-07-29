package com.revenuecat.purchases.common;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/common/GoogleOfferingParser;", "Lcom/revenuecat/purchases/common/OfferingParser;", "()V", "findMatchingProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "productsById", "", "", "", "packageJson", "Lorg/json/JSONObject;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GoogleOfferingParser.kt */
public final class GoogleOfferingParser extends OfferingParser {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        r1 = r1.getBasePlan();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.revenuecat.purchases.models.StoreProduct findMatchingProduct(java.util.Map<java.lang.String, ? extends java.util.List<? extends com.revenuecat.purchases.models.StoreProduct>> r4, org.json.JSONObject r5) {
        /*
            r3 = this;
            java.lang.String r0 = "productsById"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "packageJson"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "platform_product_identifier"
            java.lang.String r0 = r5.getString(r0)
            java.lang.String r1 = "platform_product_plan_identifier"
            java.lang.String r5 = r5.optString(r1)
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            r1 = r5
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            r2 = 0
            if (r1 <= 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r5 = r2
        L_0x0027:
            java.lang.Object r4 = r4.get(r0)
            java.util.List r4 = (java.util.List) r4
            if (r5 != 0) goto L_0x0057
            if (r4 == 0) goto L_0x0039
            int r5 = r4.size()
            r0 = 1
            if (r5 != r0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r4 = r2
        L_0x003a:
            if (r4 == 0) goto L_0x0056
            r5 = 0
            java.lang.Object r5 = r4.get(r5)
            com.revenuecat.purchases.models.StoreProduct r5 = (com.revenuecat.purchases.models.StoreProduct) r5
            com.revenuecat.purchases.ProductType r5 = r5.getType()
            com.revenuecat.purchases.ProductType r0 = com.revenuecat.purchases.ProductType.INAPP
            if (r5 != r0) goto L_0x004c
            goto L_0x004d
        L_0x004c:
            r4 = r2
        L_0x004d:
            if (r4 == 0) goto L_0x0056
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            r2 = r4
            com.revenuecat.purchases.models.StoreProduct r2 = (com.revenuecat.purchases.models.StoreProduct) r2
        L_0x0056:
            return r2
        L_0x0057:
            if (r4 == 0) goto L_0x0087
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L_0x005f:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = r4.next()
            r1 = r0
            com.revenuecat.purchases.models.StoreProduct r1 = (com.revenuecat.purchases.models.StoreProduct) r1
            com.revenuecat.purchases.models.SubscriptionOptions r1 = r1.getSubscriptionOptions()
            if (r1 == 0) goto L_0x007d
            com.revenuecat.purchases.models.SubscriptionOption r1 = r1.getBasePlan()
            if (r1 == 0) goto L_0x007d
            java.lang.String r1 = r1.getId()
            goto L_0x007e
        L_0x007d:
            r1 = r2
        L_0x007e:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r1 == 0) goto L_0x005f
            r2 = r0
        L_0x0085:
            com.revenuecat.purchases.models.StoreProduct r2 = (com.revenuecat.purchases.models.StoreProduct) r2
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.GoogleOfferingParser.findMatchingProduct(java.util.Map, org.json.JSONObject):com.revenuecat.purchases.models.StoreProduct");
    }
}
