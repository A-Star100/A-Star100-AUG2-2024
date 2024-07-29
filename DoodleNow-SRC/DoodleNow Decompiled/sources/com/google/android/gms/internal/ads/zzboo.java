package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzcc;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzboo implements zzbky {
    final /* synthetic */ zzbnx zza;
    final /* synthetic */ zzcc zzb;
    final /* synthetic */ zzbpc zzc;

    zzboo(zzbpc zzbpc, zzawo zzawo, zzbnx zzbnx, zzcc zzcc) {
        this.zza = zzbnx;
        this.zzb = zzcc;
        this.zzc = zzbpc;
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzbky, java.lang.Object] */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzbpd zzbpd = (zzbpd) obj;
        zze.zza("loadJavascriptEngine > /requestReload handler: Trying to acquire lock");
        synchronized (this.zzc.zza) {
            zze.zza("loadJavascriptEngine > /requestReload handler: Lock acquired");
            zzm.zzi("JS Engine is requesting an update");
            if (this.zzc.zzi == 0) {
                zzm.zzi("Starting reload.");
                this.zzc.zzi = 2;
                this.zzc.zzd((zzawo) null);
            }
            this.zza.zzr("/requestReload", this.zzb.zza());
        }
        zze.zza("loadJavascriptEngine > /requestReload handler: Lock released");
    }
}
