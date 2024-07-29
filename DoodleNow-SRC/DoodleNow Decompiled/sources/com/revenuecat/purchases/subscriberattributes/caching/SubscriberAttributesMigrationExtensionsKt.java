package com.revenuecat.purchases.subscriberattributes.caching;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a0\u0010\u0000\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00050\u0001j\u0002`\u0006*\u00020\u0007H\u0000\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0000\u001a8\u0010\n\u001a\u00020\u000b*\u00020\u00072*\u0010\f\u001a&\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00050\u0001j\u0002`\u0006H\u0000\u001a\f\u0010\r\u001a\u00020\u000b*\u00020\u0007H\u0000¨\u0006\u000e"}, d2 = {"getAllLegacyStoredSubscriberAttributes", "", "", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "legacySubscriberAttributesCacheKey", "appUserID", "migrateSubscriberAttributes", "", "legacySubscriberAttributesForAppUserID", "migrateSubscriberAttributesIfNeeded", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesMigrationExtensions.kt */
public final class SubscriberAttributesMigrationExtensionsKt {
    public static final synchronized void migrateSubscriberAttributesIfNeeded(SubscriberAttributesCache subscriberAttributesCache) {
        synchronized (SubscriberAttributesMigrationExtensionsKt.class) {
            Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
            Map<String, Map<String, SubscriberAttribute>> allLegacyStoredSubscriberAttributes = getAllLegacyStoredSubscriberAttributes(subscriberAttributesCache);
            if (!(!allLegacyStoredSubscriberAttributes.isEmpty())) {
                allLegacyStoredSubscriberAttributes = null;
            }
            if (allLegacyStoredSubscriberAttributes != null) {
                migrateSubscriberAttributes(subscriberAttributesCache, allLegacyStoredSubscriberAttributes);
            }
        }
    }

    public static final synchronized void migrateSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache, Map<String, ? extends Map<String, SubscriberAttribute>> map) {
        synchronized (SubscriberAttributesMigrationExtensionsKt.class) {
            Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
            Intrinsics.checkNotNullParameter(map, "legacySubscriberAttributesForAppUserID");
            Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = subscriberAttributesCache.getAllStoredSubscriberAttributes();
            Map<String, Map<String, SubscriberAttribute>> mutableMap = MapsKt.toMutableMap(allStoredSubscriberAttributes);
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                Map map2 = (Map) next.getValue();
                Map map3 = allStoredSubscriberAttributes.get(str);
                if (map3 == null) {
                    map3 = MapsKt.emptyMap();
                }
                mutableMap.put(str, MapsKt.plus(map2, map3));
                subscriberAttributesCache.getDeviceCache$purchases_defaultsRelease().remove(legacySubscriberAttributesCacheKey(subscriberAttributesCache, str));
            }
            subscriberAttributesCache.putAttributes$purchases_defaultsRelease(subscriberAttributesCache.getDeviceCache$purchases_defaultsRelease(), mutableMap);
        }
    }

    public static final String legacySubscriberAttributesCacheKey(SubscriberAttributesCache subscriberAttributesCache, String str) {
        Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        return subscriberAttributesCache.getSubscriberAttributesCacheKey$purchases_defaultsRelease() + '.' + str;
    }

    public static final synchronized Map<String, Map<String, SubscriberAttribute>> getAllLegacyStoredSubscriberAttributes(SubscriberAttributesCache subscriberAttributesCache) {
        Map<String, Map<String, SubscriberAttribute>> map;
        Map<String, SubscriberAttribute> map2;
        synchronized (SubscriberAttributesMigrationExtensionsKt.class) {
            Intrinsics.checkNotNullParameter(subscriberAttributesCache, "<this>");
            String legacySubscriberAttributesCacheKey = legacySubscriberAttributesCacheKey(subscriberAttributesCache, "");
            Iterable<String> findKeysThatStartWith = subscriberAttributesCache.getDeviceCache$purchases_defaultsRelease().findKeysThatStartWith(legacySubscriberAttributesCacheKey);
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(findKeysThatStartWith, 10));
            for (String str : findKeysThatStartWith) {
                String str2 = (String) StringsKt.split$default((CharSequence) str, new String[]{legacySubscriberAttributesCacheKey}, false, 0, 6, (Object) null).get(1);
                JSONObject jSONObjectOrNull = subscriberAttributesCache.getDeviceCache$purchases_defaultsRelease().getJSONObjectOrNull(str);
                if (jSONObjectOrNull == null || (map2 = SubscriberAttributesFactoriesKt.buildLegacySubscriberAttributes(jSONObjectOrNull)) == null) {
                    map2 = MapsKt.emptyMap();
                }
                arrayList.add(TuplesKt.to(str2, map2));
            }
            map = MapsKt.toMap((List) arrayList);
        }
        return map;
    }
}
