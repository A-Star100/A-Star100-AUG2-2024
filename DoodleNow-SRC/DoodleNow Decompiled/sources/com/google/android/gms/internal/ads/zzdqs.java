package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdqs implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzdqs(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    public final /* synthetic */ Object zzb() {
        int i = ((zzcyh) this.zzc).zza().zzo.zza;
        if (i == 0) {
            throw null;
        } else if (i - 1 != 0) {
            return ((zzelw) this.zzb).zzb();
        } else {
            return ((zzelw) this.zza).zzb();
        }
    }
}
