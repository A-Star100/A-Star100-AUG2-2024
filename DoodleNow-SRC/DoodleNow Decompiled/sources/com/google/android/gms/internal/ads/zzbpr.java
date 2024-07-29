package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbpr implements zzcca {
    final /* synthetic */ zzbow zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzcbw zzc;
    final /* synthetic */ zzbpu zzd;

    zzbpr(zzbpu zzbpu, zzbow zzbow, Object obj, zzcbw zzcbw) {
        this.zza = zzbow;
        this.zzb = obj;
        this.zzc = zzcbw;
        this.zzd = zzbpu;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzcbw zzcbw = this.zzc;
        zzbpu.zzd(this.zzd, this.zza, (zzbpd) obj, obj2, zzcbw);
    }
}
