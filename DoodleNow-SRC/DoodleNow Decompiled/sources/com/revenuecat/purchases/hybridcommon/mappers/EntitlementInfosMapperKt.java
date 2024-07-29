package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/EntitlementInfos;", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: EntitlementInfosMapper.kt */
public final class EntitlementInfosMapperKt {
    public static final Map<String, Object> map(EntitlementInfos entitlementInfos) {
        Intrinsics.checkNotNullParameter(entitlementInfos, "<this>");
        Pair[] pairArr = new Pair[3];
        Iterable<Map.Entry> entrySet = entitlementInfos.getAll().entrySet();
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair<A, B> pair = TuplesKt.to(entry.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry.getValue()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        pairArr[0] = TuplesKt.to(TtmlNode.COMBINE_ALL, linkedHashMap);
        Iterable<Map.Entry> entrySet2 = entitlementInfos.getActive().entrySet();
        Map linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet2, 10)), 16));
        for (Map.Entry entry2 : entrySet2) {
            Pair<A, B> pair2 = TuplesKt.to(entry2.getKey(), EntitlementInfoMapperKt.map((EntitlementInfo) entry2.getValue()));
            linkedHashMap2.put(pair2.getFirst(), pair2.getSecond());
        }
        pairArr[1] = TuplesKt.to("active", linkedHashMap2);
        pairArr[2] = TuplesKt.to("verification", entitlementInfos.getVerification().name());
        return MapsKt.mapOf(pairArr);
    }
}
