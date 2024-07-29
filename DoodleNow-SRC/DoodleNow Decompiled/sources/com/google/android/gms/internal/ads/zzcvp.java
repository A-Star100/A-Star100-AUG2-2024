package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbdg;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcvp implements zzdae, zza, zzdbl, zzczk, zzcyq, zzddx {
    private final Clock zza;
    private final zzcba zzb;

    public zzcvp(Clock clock, zzcba zzcba) {
        this.zza = clock;
        this.zzb = zzcba;
    }

    public final void onAdClicked() {
        this.zzb.zzd();
    }

    public final void zza() {
        this.zzb.zze();
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zzdn(zzbxd zzbxd) {
    }

    public final void zzdo(zzffz zzffz) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    public final void zzds(zzbxq zzbxq, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final String zzg() {
        return this.zzb.zzc();
    }

    public final void zzh() {
    }

    public final void zzi(zzbdg.zzb zzb2) {
        this.zzb.zzi();
    }

    public final void zzj(zzbdg.zzb zzb2) {
    }

    public final void zzk(zzl zzl) {
        this.zzb.zzj(zzl);
    }

    public final void zzl(boolean z) {
    }

    public final void zzm(zzbdg.zzb zzb2) {
        this.zzb.zzg();
    }

    public final void zzn(boolean z) {
    }

    public final void zzr() {
        this.zzb.zzf();
    }

    public final void zzs() {
        this.zzb.zzh(true);
    }
}
