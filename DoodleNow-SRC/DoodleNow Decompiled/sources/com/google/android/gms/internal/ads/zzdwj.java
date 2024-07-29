package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdwj extends zzbmz {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfkw zzd;
    final /* synthetic */ zzcbw zze;
    final /* synthetic */ zzdwk zzf;

    zzdwj(zzdwk zzdwk, Object obj, String str, long j, zzfkw zzfkw, zzcbw zzcbw) {
        this.zza = obj;
        this.zzb = str;
        this.zzc = j;
        this.zzd = zzfkw;
        this.zze = zzcbw;
        this.zzf = zzdwk;
    }

    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (zzu.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, "error");
            this.zzf.zzo.zzb(this.zzb, "error");
            zzflk zze2 = this.zzf.zzp;
            zzfkw zzfkw = this.zzd;
            zzfkw.zzc(str);
            zzfkw.zzg(false);
            zze2.zzb(zzfkw.zzm());
            this.zze.zzc(false);
        }
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (zzu.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzflk zze2 = this.zzf.zzp;
            zzfkw zzfkw = this.zzd;
            zzfkw.zzg(true);
            zze2.zzb(zzfkw.zzm());
            this.zze.zzc(true);
        }
    }
}
