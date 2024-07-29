package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.caching.DateExtensionsKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.common.caching.InMemoryCachedObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018R\u0013\u0010\n\u001a\u0004\u0018\u00010\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsCache;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "offeringsCachedObject", "Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;", "Lcom/revenuecat/purchases/Offerings;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/caching/InMemoryCachedObject;)V", "cachedOfferings", "getCachedOfferings", "()Lcom/revenuecat/purchases/Offerings;", "cachedOfferingsResponse", "Lorg/json/JSONObject;", "getCachedOfferingsResponse", "()Lorg/json/JSONObject;", "cacheOfferings", "", "offerings", "offeringsResponse", "clearCache", "clearOfferingsCacheTimestamp", "isOfferingsCacheStale", "", "appInBackground", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsCache.kt */
public final class OfferingsCache {
    private final DateProvider dateProvider;
    private final DeviceCache deviceCache;
    private final InMemoryCachedObject<Offerings> offeringsCachedObject;

    public OfferingsCache(DeviceCache deviceCache2, DateProvider dateProvider2, InMemoryCachedObject<Offerings> inMemoryCachedObject) {
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(inMemoryCachedObject, "offeringsCachedObject");
        this.deviceCache = deviceCache2;
        this.dateProvider = dateProvider2;
        this.offeringsCachedObject = inMemoryCachedObject;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OfferingsCache(com.revenuecat.purchases.common.caching.DeviceCache r1, com.revenuecat.purchases.common.DateProvider r2, com.revenuecat.purchases.common.caching.InMemoryCachedObject r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x000b
            com.revenuecat.purchases.common.DefaultDateProvider r2 = new com.revenuecat.purchases.common.DefaultDateProvider
            r2.<init>()
            com.revenuecat.purchases.common.DateProvider r2 = (com.revenuecat.purchases.common.DateProvider) r2
        L_0x000b:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0016
            com.revenuecat.purchases.common.caching.InMemoryCachedObject r3 = new com.revenuecat.purchases.common.caching.InMemoryCachedObject
            r4 = 1
            r5 = 0
            r3.<init>(r5, r2, r4, r5)
        L_0x0016:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.offerings.OfferingsCache.<init>(com.revenuecat.purchases.common.caching.DeviceCache, com.revenuecat.purchases.common.DateProvider, com.revenuecat.purchases.common.caching.InMemoryCachedObject, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final synchronized void clearCache() {
        this.offeringsCachedObject.clearCache();
        this.deviceCache.clearOfferingsResponseCache();
    }

    public final synchronized void cacheOfferings(Offerings offerings, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Intrinsics.checkNotNullParameter(jSONObject, "offeringsResponse");
        this.offeringsCachedObject.cacheInstance(offerings);
        this.deviceCache.cacheOfferingsResponse(jSONObject);
        this.offeringsCachedObject.updateCacheTimestamp(this.dateProvider.getNow());
    }

    public final synchronized Offerings getCachedOfferings() {
        return this.offeringsCachedObject.getCachedInstance();
    }

    public final synchronized boolean isOfferingsCacheStale(boolean z) {
        return DateExtensionsKt.isCacheStale(this.offeringsCachedObject.getLastUpdatedAt$purchases_defaultsRelease(), z, this.dateProvider);
    }

    public final synchronized void clearOfferingsCacheTimestamp() {
        this.offeringsCachedObject.clearCacheTimestamp();
    }

    public final synchronized JSONObject getCachedOfferingsResponse() {
        return this.deviceCache.getOfferingsResponseCache();
    }
}
