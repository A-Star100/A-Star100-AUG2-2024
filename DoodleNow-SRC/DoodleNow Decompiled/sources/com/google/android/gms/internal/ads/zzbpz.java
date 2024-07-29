package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbpz {
    private final zzbpc zza;
    private ListenableFuture zzb;

    zzbpz(zzbpc zzbpc) {
        this.zza = zzbpc;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzcbw zzcbw = new zzcbw();
            this.zzb = zzcbw;
            this.zza.zzb((zzawo) null).zzj(new zzbpw(zzcbw), new zzbpx(zzcbw));
        }
    }

    public final zzbqc zza(String str, zzbpj zzbpj, zzbpi zzbpi) {
        zzd();
        return new zzbqc(this.zzb, "google.afma.activeView.handleUpdate", zzbpj, zzbpi);
    }

    public final void zzb(String str, zzbky zzbky) {
        zzd();
        this.zzb = zzgee.zzn(this.zzb, new zzbpy(str, zzbky), zzcbr.zzf);
    }

    public final void zzc(String str, zzbky zzbky) {
        this.zzb = zzgee.zzm(this.zzb, new zzbpv(str, zzbky), zzcbr.zzf);
    }
}
