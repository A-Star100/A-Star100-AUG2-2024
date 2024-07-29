package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u00132\u00020\u0001:\u0002\u0013\u0014B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "", "mappings", "", "", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Mapping;", "(Ljava/util/Map;)V", "getMappings", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toJson", "Lorg/json/JSONObject;", "toString", "Companion", "Mapping", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ProductEntitlementMapping.kt */
public final class ProductEntitlementMapping {
    private static final String BASE_PLAN_ID_KEY = "base_plan_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ENTITLEMENTS_KEY = "entitlements";
    private static final String PRODUCT_ENTITLEMENT_MAPPING_KEY = "product_entitlement_mapping";
    private static final String PRODUCT_ID_KEY = "product_identifier";
    private final Map<String, Mapping> mappings;

    public static /* synthetic */ ProductEntitlementMapping copy$default(ProductEntitlementMapping productEntitlementMapping, Map<String, Mapping> map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = productEntitlementMapping.mappings;
        }
        return productEntitlementMapping.copy(map);
    }

    public final Map<String, Mapping> component1() {
        return this.mappings;
    }

    public final ProductEntitlementMapping copy(Map<String, Mapping> map) {
        Intrinsics.checkNotNullParameter(map, "mappings");
        return new ProductEntitlementMapping(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ProductEntitlementMapping) && Intrinsics.areEqual((Object) this.mappings, (Object) ((ProductEntitlementMapping) obj).mappings);
    }

    public final Map<String, Mapping> getMappings() {
        return this.mappings;
    }

    public int hashCode() {
        return this.mappings.hashCode();
    }

    public String toString() {
        return "ProductEntitlementMapping(mappings=" + this.mappings + ')';
    }

    public ProductEntitlementMapping(Map<String, Mapping> map) {
        Intrinsics.checkNotNullParameter(map, "mappings");
        this.mappings = map;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Companion;", "", "()V", "BASE_PLAN_ID_KEY", "", "ENTITLEMENTS_KEY", "PRODUCT_ENTITLEMENT_MAPPING_KEY", "PRODUCT_ID_KEY", "fromJson", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "json", "Lorg/json/JSONObject;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ProductEntitlementMapping.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ProductEntitlementMapping fromJson(JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "json");
            JSONObject jSONObject2 = jSONObject.getJSONObject(ProductEntitlementMapping.PRODUCT_ENTITLEMENT_MAPPING_KEY);
            Map linkedHashMap = new LinkedHashMap();
            Iterator<String> keys = jSONObject2.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "productsObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                String string = jSONObject3.getString("product_identifier");
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "productObject");
                String optNullableString = JSONObjectExtensionsKt.optNullableString(jSONObject3, ProductEntitlementMapping.BASE_PLAN_ID_KEY);
                JSONArray jSONArray = jSONObject3.getJSONArray("entitlements");
                List arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    String string2 = jSONArray.getString(i);
                    Intrinsics.checkNotNullExpressionValue(string2, "entitlementsArray.getString(entitlementIndex)");
                    arrayList.add(string2);
                }
                Intrinsics.checkNotNullExpressionValue(next, "mappingIdentifier");
                Intrinsics.checkNotNullExpressionValue(string, "productIdentifier");
                linkedHashMap.put(next, new Mapping(string, optNullableString, arrayList));
            }
            return new ProductEntitlementMapping(linkedHashMap);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J/\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping$Mapping;", "", "productIdentifier", "", "basePlanId", "entitlements", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getBasePlanId", "()Ljava/lang/String;", "getEntitlements", "()Ljava/util/List;", "getProductIdentifier", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ProductEntitlementMapping.kt */
    public static final class Mapping {
        private final String basePlanId;
        private final List<String> entitlements;
        private final String productIdentifier;

        public static /* synthetic */ Mapping copy$default(Mapping mapping, String str, String str2, List<String> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = mapping.productIdentifier;
            }
            if ((i & 2) != 0) {
                str2 = mapping.basePlanId;
            }
            if ((i & 4) != 0) {
                list = mapping.entitlements;
            }
            return mapping.copy(str, str2, list);
        }

        public final String component1() {
            return this.productIdentifier;
        }

        public final String component2() {
            return this.basePlanId;
        }

        public final List<String> component3() {
            return this.entitlements;
        }

        public final Mapping copy(String str, String str2, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "productIdentifier");
            Intrinsics.checkNotNullParameter(list, "entitlements");
            return new Mapping(str, str2, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Mapping)) {
                return false;
            }
            Mapping mapping = (Mapping) obj;
            return Intrinsics.areEqual((Object) this.productIdentifier, (Object) mapping.productIdentifier) && Intrinsics.areEqual((Object) this.basePlanId, (Object) mapping.basePlanId) && Intrinsics.areEqual((Object) this.entitlements, (Object) mapping.entitlements);
        }

        public final String getBasePlanId() {
            return this.basePlanId;
        }

        public final List<String> getEntitlements() {
            return this.entitlements;
        }

        public final String getProductIdentifier() {
            return this.productIdentifier;
        }

        public int hashCode() {
            int hashCode = this.productIdentifier.hashCode() * 31;
            String str = this.basePlanId;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.entitlements.hashCode();
        }

        public String toString() {
            return "Mapping(productIdentifier=" + this.productIdentifier + ", basePlanId=" + this.basePlanId + ", entitlements=" + this.entitlements + ')';
        }

        public Mapping(String str, String str2, List<String> list) {
            Intrinsics.checkNotNullParameter(str, "productIdentifier");
            Intrinsics.checkNotNullParameter(list, "entitlements");
            this.productIdentifier = str;
            this.basePlanId = str2;
            this.entitlements = list;
        }
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        Map<String, Mapping> map = this.mappings;
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Mapping mapping = (Mapping) entry.getValue();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("product_identifier", mapping.getProductIdentifier());
            String basePlanId = mapping.getBasePlanId();
            if (basePlanId != null) {
                jSONObject2.put(BASE_PLAN_ID_KEY, basePlanId);
            }
            jSONObject2.put("entitlements", new JSONArray(mapping.getEntitlements()));
            linkedHashMap.put(key, jSONObject2);
        }
        jSONObject.put(PRODUCT_ENTITLEMENT_MAPPING_KEY, new JSONObject(linkedHashMap));
        return jSONObject;
    }
}
