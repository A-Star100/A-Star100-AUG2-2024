package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbos implements zzcby {
    final /* synthetic */ zzbpb zza;
    final /* synthetic */ zzfkw zzb;
    final /* synthetic */ zzbpc zzc;

    zzbos(zzbpc zzbpc, zzbpb zzbpb, zzfkw zzfkw) {
        this.zza = zzbpb;
        this.zzb = zzfkw;
        this.zzc = zzbpc;
    }

    public final void zza() {
        zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            this.zzc.zzi = 1;
            zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzb();
            if (((Boolean) zzbfm.zzd.zze()).booleanValue()) {
                zzbpc zzbpc = this.zzc;
                if (zzbpc.zze != null) {
                    zzflk zze = zzbpc.zze;
                    zzfkw zzfkw = this.zzb;
                    zzfkw.zzc("Failed loading new engine");
                    zzfkw.zzg(false);
                    zze.zzb(zzfkw.zzm());
                }
            }
        }
        zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
