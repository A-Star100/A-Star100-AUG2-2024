package com.revenuecat.purchases.subscriberattributes.caching;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesFactoriesKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0012\u0010\u0010\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012J\u0012\u0010\u0013\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0002J*\u0010\u0015\u001a&\u0012\b\u0012\u00060\bj\u0002`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0016j\u0002`\u0019J\"\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00182\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012J*\u0010\u001a\u001a&\u0012\b\u0012\u00060\bj\u0002`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0016j\u0002`\u0019J\u001e\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00182\u0006\u0010\u0011\u001a\u00020\bJ*\u0010\u001b\u001a\u00020\u000e2\n\u0010\u0011\u001a\u00060\bj\u0002`\u00122\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u0018J8\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u0018*\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00182\n\u0010\u0011\u001a\u00060\bj\u0002`\u0012H\u0002J=\u0010\u001e\u001a\u00020\u000e*\u00020\u00032*\u0010\u001f\u001a&\u0012\b\u0012\u00060\bj\u0002`\u0012\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u0016j\u0002`\u00180\u0016j\u0002`\u0019H\u0000¢\u0006\u0002\b R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8@X\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesCache;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;)V", "getDeviceCache$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/common/caching/DeviceCache;", "subscriberAttributesCacheKey", "", "getSubscriberAttributesCacheKey$purchases_defaultsRelease", "()Ljava/lang/String;", "subscriberAttributesCacheKey$delegate", "Lkotlin/Lazy;", "cleanUpSubscriberAttributeCache", "", "currentAppUserID", "clearAllSubscriberAttributesFromUser", "appUserID", "Lcom/revenuecat/purchases/subscriberattributes/caching/AppUserID;", "clearSubscriberAttributesIfSyncedForSubscriber", "deleteSyncedSubscriberAttributesForOtherUsers", "getAllStoredSubscriberAttributes", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributesPerAppUserIDMap;", "getUnsyncedSubscriberAttributes", "setAttributes", "attributesToBeSet", "filterUnsynced", "putAttributes", "updatedSubscriberAttributesForAll", "putAttributes$purchases_defaultsRelease", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriberAttributesCache.kt */
public final class SubscriberAttributesCache {
    private final DeviceCache deviceCache;
    private final Lazy subscriberAttributesCacheKey$delegate = LazyKt.lazy(new SubscriberAttributesCache$subscriberAttributesCacheKey$2(this));

    public final DeviceCache getDeviceCache$purchases_defaultsRelease() {
        return this.deviceCache;
    }

    public SubscriberAttributesCache(DeviceCache deviceCache2) {
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        this.deviceCache = deviceCache2;
    }

    public final String getSubscriberAttributesCacheKey$purchases_defaultsRelease() {
        return (String) this.subscriberAttributesCacheKey$delegate.getValue();
    }

    public final synchronized void setAttributes(String str, Map<String, SubscriberAttribute> map) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(map, "attributesToBeSet");
        Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        Map map2 = allStoredSubscriberAttributes.get(str);
        if (map2 == null) {
            map2 = MapsKt.emptyMap();
        }
        putAttributes$purchases_defaultsRelease(this.deviceCache, MapsKt.plus(allStoredSubscriberAttributes, (Map<String, Map<String, SubscriberAttribute>>) MapsKt.mapOf(TuplesKt.to(str, MapsKt.plus(map2, (Map) map)))));
    }

    public final synchronized Map<String, Map<String, SubscriberAttribute>> getAllStoredSubscriberAttributes() {
        Map<String, Map<String, SubscriberAttribute>> map;
        JSONObject jSONObjectOrNull = this.deviceCache.getJSONObjectOrNull(getSubscriberAttributesCacheKey$purchases_defaultsRelease());
        if (jSONObjectOrNull == null || (map = SubscriberAttributesFactoriesKt.buildSubscriberAttributesMapPerUser(jSONObjectOrNull)) == null) {
            map = MapsKt.emptyMap();
        }
        return map;
    }

    public final synchronized Map<String, SubscriberAttribute> getAllStoredSubscriberAttributes(String str) {
        Map<String, SubscriberAttribute> map;
        Intrinsics.checkNotNullParameter(str, "appUserID");
        map = getAllStoredSubscriberAttributes().get(str);
        if (map == null) {
            map = MapsKt.emptyMap();
        }
        return map;
    }

    public final synchronized Map<String, Map<String, SubscriberAttribute>> getUnsyncedSubscriberAttributes() {
        LinkedHashMap linkedHashMap;
        Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        Map linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(allStoredSubscriberAttributes.size()));
        for (Object next : allStoredSubscriberAttributes.entrySet()) {
            Object key = ((Map.Entry) next).getKey();
            Map.Entry entry = (Map.Entry) next;
            linkedHashMap2.put(key, filterUnsynced((Map) entry.getValue(), (String) entry.getKey()));
        }
        linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            if (!((Map) entry2.getValue()).isEmpty()) {
                linkedHashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return linkedHashMap;
    }

    public final synchronized Map<String, SubscriberAttribute> getUnsyncedSubscriberAttributes(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        return filterUnsynced(getAllStoredSubscriberAttributes(str), str);
    }

    public final synchronized void clearAllSubscriberAttributesFromUser(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.DELETING_ATTRIBUTES, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Map<String, Map<String, SubscriberAttribute>> mutableMap = MapsKt.toMutableMap(getAllStoredSubscriberAttributes());
        mutableMap.remove(str);
        putAttributes$purchases_defaultsRelease(this.deviceCache, MapsKt.toMap(mutableMap));
    }

    public final synchronized void clearSubscriberAttributesIfSyncedForSubscriber(String str) {
        Intrinsics.checkNotNullParameter(str, "appUserID");
        if (getUnsyncedSubscriberAttributes(str).isEmpty()) {
            clearAllSubscriberAttributesFromUser(str);
        }
    }

    public final synchronized void cleanUpSubscriberAttributeCache(String str) {
        Intrinsics.checkNotNullParameter(str, "currentAppUserID");
        SubscriberAttributesMigrationExtensionsKt.migrateSubscriberAttributesIfNeeded(this);
        deleteSyncedSubscriberAttributesForOtherUsers(str);
    }

    public final void putAttributes$purchases_defaultsRelease(DeviceCache deviceCache2, Map<String, ? extends Map<String, SubscriberAttribute>> map) {
        Intrinsics.checkNotNullParameter(deviceCache2, "<this>");
        Intrinsics.checkNotNullParameter(map, "updatedSubscriberAttributesForAll");
        DeviceCache deviceCache3 = this.deviceCache;
        String subscriberAttributesCacheKey$purchases_defaultsRelease = getSubscriberAttributesCacheKey$purchases_defaultsRelease();
        String jSONObject = CachingHelpersKt.toJSONObject(map).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "updatedSubscriberAttribu…toJSONObject().toString()");
        deviceCache3.putString(subscriberAttributesCacheKey$purchases_defaultsRelease, jSONObject);
    }

    private final synchronized void deleteSyncedSubscriberAttributesForOtherUsers(String str) {
        Pair pair;
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AttributionStrings.DELETING_ATTRIBUTES_OTHER_USERS, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        Map<String, Map<String, SubscriberAttribute>> allStoredSubscriberAttributes = getAllStoredSubscriberAttributes();
        Collection arrayList = new ArrayList(allStoredSubscriberAttributes.size());
        for (Map.Entry next : allStoredSubscriberAttributes.entrySet()) {
            String str2 = (String) next.getKey();
            Map map = (Map) next.getValue();
            if (!Intrinsics.areEqual((Object) str, (Object) str2)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (!((SubscriberAttribute) entry.getValue()).isSynced()) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                pair = TuplesKt.to(str2, linkedHashMap);
            } else {
                pair = TuplesKt.to(str2, map);
            }
            arrayList.add(pair);
        }
        Map map2 = MapsKt.toMap((List) arrayList);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry2 : map2.entrySet()) {
            if (!((Map) entry2.getValue()).isEmpty()) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        putAttributes$purchases_defaultsRelease(this.deviceCache, linkedHashMap2);
    }

    private final Map<String, SubscriberAttribute> filterUnsynced(Map<String, SubscriberAttribute> map, String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (true ^ ((SubscriberAttribute) next.getValue()).isSynced()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        Map<String, SubscriberAttribute> map2 = linkedHashMap;
        LogIntent logIntent = LogIntent.DEBUG;
        StringBuilder sb = new StringBuilder();
        String format = String.format(AttributionStrings.UNSYNCED_ATTRIBUTES_COUNT, Arrays.copyOf(new Object[]{Integer.valueOf(map2.size()), str}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        sb.append(format);
        sb.append(map2.isEmpty() ^ true ? CollectionsKt.joinToString$default(map2.values(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) : "");
        LogWrapperKt.log(logIntent, sb.toString());
        return map2;
    }
}
