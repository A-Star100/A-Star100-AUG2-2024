package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdug {
    final /* synthetic */ zzduh zza;
    private final Map zzb = new ConcurrentHashMap();

    zzdug(zzduh zzduh) {
        this.zza = zzduh;
    }

    public final zzdug zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdug zzc(zzffn zzffn) {
        zzb("aai", zzffn.zzx);
        zzb(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, zzffn.zzao);
        zzb("ad_format", zzffn.zza(zzffn.zzb));
        return this;
    }

    public final zzdug zzd(zzffq zzffq) {
        zzb("gqi", zzffq.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzf() {
        this.zza.zzb.execute(new zzdue(this));
    }

    public final void zzg() {
        this.zza.zzb.execute(new zzduf(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zza.zza.zzf(this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zza.zza.zze(this.zzb);
    }
}
