package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzevk implements zzewq {
    private final String zza;
    private final String zzb;

    public zzevk(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgZ)).booleanValue()) {
            bundle.putString(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, this.zzb);
        } else {
            bundle.putString(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, this.zza);
        }
    }
}
