package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzbjk implements Runnable {
    final /* synthetic */ AdManagerAdView zza;
    final /* synthetic */ zzbu zzb;
    final /* synthetic */ zzbjl zzc;

    zzbjk(zzbjl zzbjl, AdManagerAdView adManagerAdView, zzbu zzbu) {
        this.zza = adManagerAdView;
        this.zzb = zzbu;
        this.zzc = zzbjl;
    }

    public final void run() {
        if (this.zza.zzb(this.zzb)) {
            zzbjl zzbjl = this.zzc;
            zzbjl.zza.onAdManagerAdViewLoaded(this.zza);
            return;
        }
        zzm.zzj("Could not bind.");
    }
}
