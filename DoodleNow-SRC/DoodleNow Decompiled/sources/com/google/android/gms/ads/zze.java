package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzbvs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zze implements Runnable {
    public final /* synthetic */ BaseAdView zza;

    public /* synthetic */ zze(BaseAdView baseAdView) {
        this.zza = baseAdView;
    }

    public final void run() {
        BaseAdView baseAdView = this.zza;
        try {
            baseAdView.zza.zzn();
        } catch (IllegalStateException e) {
            zzbvs.zza(baseAdView.getContext()).zzg(e, "BaseAdView.pause");
        }
    }
}
