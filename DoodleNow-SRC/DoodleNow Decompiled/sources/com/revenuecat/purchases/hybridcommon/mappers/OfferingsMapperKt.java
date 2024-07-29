package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004H\u0002\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0005\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0006¨\u0006\u0007"}, d2 = {"map", "", "", "", "Lcom/revenuecat/purchases/Offering;", "Lcom/revenuecat/purchases/Offerings;", "Lcom/revenuecat/purchases/Package;", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsMapper.kt */
public final class OfferingsMapperKt {
    public static final Map<String, Object> map(Offerings offerings) {
        Intrinsics.checkNotNullParameter(offerings, "<this>");
        Pair[] pairArr = new Pair[2];
        Map<String, Offering> all = offerings.getAll();
        Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(all.size()));
        for (Map.Entry entry : all.entrySet()) {
            linkedHashMap.put(entry.getKey(), map((Offering) entry.getValue()));
        }
        pairArr[0] = TuplesKt.to(TtmlNode.COMBINE_ALL, linkedHashMap);
        Offering current = offerings.getCurrent();
        pairArr[1] = TuplesKt.to("current", current != null ? map(current) : null);
        return MapsKt.mapOf(pairArr);
    }

    private static final Map<String, Object> map(Offering offering) {
        Pair[] pairArr = new Pair[11];
        pairArr[0] = TuplesKt.to("identifier", offering.getIdentifier());
        pairArr[1] = TuplesKt.to("serverDescription", offering.getServerDescription());
        pairArr[2] = TuplesKt.to(TtmlNode.TAG_METADATA, offering.getMetadata());
        Iterable<Package> availablePackages = offering.getAvailablePackages();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(availablePackages, 10));
        for (Package map : availablePackages) {
            arrayList.add(map(map));
        }
        pairArr[3] = TuplesKt.to("availablePackages", (List) arrayList);
        Package lifetime = offering.getLifetime();
        Map<String, Object> map2 = null;
        pairArr[4] = TuplesKt.to("lifetime", lifetime != null ? map(lifetime) : null);
        Package annual = offering.getAnnual();
        pairArr[5] = TuplesKt.to("annual", annual != null ? map(annual) : null);
        Package sixMonth = offering.getSixMonth();
        pairArr[6] = TuplesKt.to("sixMonth", sixMonth != null ? map(sixMonth) : null);
        Package threeMonth = offering.getThreeMonth();
        pairArr[7] = TuplesKt.to("threeMonth", threeMonth != null ? map(threeMonth) : null);
        Package twoMonth = offering.getTwoMonth();
        pairArr[8] = TuplesKt.to("twoMonth", twoMonth != null ? map(twoMonth) : null);
        Package monthly = offering.getMonthly();
        pairArr[9] = TuplesKt.to("monthly", monthly != null ? map(monthly) : null);
        Package weekly = offering.getWeekly();
        if (weekly != null) {
            map2 = map(weekly);
        }
        pairArr[10] = TuplesKt.to("weekly", map2);
        return MapsKt.mapOf(pairArr);
    }

    public static final Map<String, Object> map(Package packageR) {
        Intrinsics.checkNotNullParameter(packageR, "<this>");
        return MapsKt.mapOf(TuplesKt.to("identifier", packageR.getIdentifier()), TuplesKt.to("packageType", packageR.getPackageType().name()), TuplesKt.to("product", StoreProductMapperKt.map(packageR.getProduct())), TuplesKt.to("offeringIdentifier", packageR.getOffering()));
    }
}
