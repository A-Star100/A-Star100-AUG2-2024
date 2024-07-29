package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbte implements zzp {
    final /* synthetic */ zzbtg zza;

    zzbte(zzbtg zzbtg) {
        this.zza = zzbtg;
    }

    public final void zzdH() {
        zzm.zze("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzdk() {
        zzm.zze("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void zzdq() {
        zzm.zze("Delay close AdMobCustomTabsAdapter overlay.");
    }

    public final void zzdr() {
        zzm.zze("Opening AdMobCustomTabsAdapter overlay.");
        zzbtg zzbtg = this.zza;
        zzbtg.zzb.onAdOpened(zzbtg);
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
        zzm.zze("AdMobCustomTabsAdapter overlay is closed.");
        zzbtg zzbtg = this.zza;
        zzbtg.zzb.onAdClosed(zzbtg);
    }
}
