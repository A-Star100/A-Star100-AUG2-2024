package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbon implements zzbky {
    final /* synthetic */ long zza;
    final /* synthetic */ zzbpb zzb;
    final /* synthetic */ zzbnx zzc;
    final /* synthetic */ zzbpc zzd;

    zzbon(zzbpc zzbpc, long j, zzbpb zzbpb, zzbnx zzbnx) {
        this.zza = j;
        this.zzb = zzbpb;
        this.zzc = zzbnx;
        this.zzd = zzbpc;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbpd zzbpd = (zzbpd) obj;
        long currentTimeMillis = zzu.zzB().currentTimeMillis() - this.zza;
        zze.zza("onGmsg /jsLoaded. JsLoaded latency is " + currentTimeMillis + " ms.");
        zze.zza("loadJavascriptEngine > /jsLoaded handler: Trying to acquire lock");
        synchronized (this.zzd.zza) {
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock acquired");
            if (this.zzb.zze() != -1) {
                if (this.zzb.zze() != 1) {
                    this.zzd.zzi = 0;
                    zzbnx zzbnx = this.zzc;
                    zzbnx.zzq("/log", zzbkx.zzg);
                    zzbnx.zzq("/result", zzbkx.zzo);
                    this.zzb.zzi(this.zzc);
                    this.zzd.zzh = this.zzb;
                    zze.zza("Successfully loaded JS Engine.");
                    zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > /jsLoaded handler: Lock released, the promise is already settled");
        }
    }
}
