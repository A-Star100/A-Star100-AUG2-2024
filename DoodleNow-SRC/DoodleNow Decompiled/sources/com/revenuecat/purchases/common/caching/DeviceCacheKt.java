package com.revenuecat.purchases.common.caching;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"CUSTOMER_INFO_SCHEMA_VERSION", "", "PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD", "Lkotlin/time/Duration;", "J", "SHARED_PREFERENCES_PREFIX", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: DeviceCache.kt */
public final class DeviceCacheKt {
    public static final int CUSTOMER_INFO_SCHEMA_VERSION = 3;
    /* access modifiers changed from: private */
    public static final long PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD = DurationKt.toDuration(25, DurationUnit.HOURS);
    private static final String SHARED_PREFERENCES_PREFIX = "com.revenuecat.purchases.";

    static {
        Duration.Companion companion = Duration.Companion;
    }
}
