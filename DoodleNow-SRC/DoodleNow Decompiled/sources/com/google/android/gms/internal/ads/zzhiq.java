package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzhiq {
    final LinkedHashMap zza;

    zzhiq(int i) {
        this.zza = zzhis.zzb(i);
    }

    /* access modifiers changed from: package-private */
    public final zzhiq zza(Object obj, zzhje zzhje) {
        zzhjd.zza(obj, SubscriberAttributeKt.JSON_NAME_KEY);
        zzhjd.zza(zzhje, "provider");
        this.zza.put(obj, zzhje);
        return this;
    }
}
