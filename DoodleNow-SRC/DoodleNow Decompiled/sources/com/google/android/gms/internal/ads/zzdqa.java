package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzp;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdqa extends zzdpk implements zzdgn {
    private zzdgn zza;

    public final synchronized void zzdG() {
        zzdgn zzdgn = this.zza;
        if (zzdgn != null) {
            zzdgn.zzdG();
        }
    }

    public final synchronized void zzdf() {
        zzdgn zzdgn = this.zza;
        if (zzdgn != null) {
            zzdgn.zzdf();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzi(zza zza2, zzbjo zzbjo, zzp zzp, zzbjq zzbjq, zzaa zzaa, zzdgn zzdgn) {
        super.zzh(zza2, zzbjo, zzp, zzbjq, zzaa);
        this.zza = zzdgn;
    }
}
