package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbor implements zzcca {
    final /* synthetic */ zzbpb zza;
    final /* synthetic */ zzfkw zzb;
    final /* synthetic */ zzbpc zzc;

    zzbor(zzbpc zzbpc, zzbpb zzbpb, zzfkw zzfkw) {
        this.zza = zzbpb;
        this.zzb = zzfkw;
        this.zzc = zzbpc;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zzbnx zzbnx = (zzbnx) obj;
        zze.zza("loadNewJavascriptEngine (success): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (success): Lock acquired");
            this.zzc.zzi = 0;
            zzbpc zzbpc = this.zzc;
            if (!(zzbpc.zzh == null || this.zza == zzbpc.zzh)) {
                zze.zza("New JS engine is loaded, marking previous one as destroyable.");
                this.zzc.zzh.zzb();
            }
            this.zzc.zzh = this.zza;
            if (((Boolean) zzbfm.zzd.zze()).booleanValue()) {
                zzbpc zzbpc2 = this.zzc;
                if (zzbpc2.zze != null) {
                    zzflk zze = zzbpc2.zze;
                    zzfkw zzfkw = this.zzb;
                    zzfkw.zzg(true);
                    zze.zzb(zzfkw.zzm());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (success): Lock released");
    }
}
