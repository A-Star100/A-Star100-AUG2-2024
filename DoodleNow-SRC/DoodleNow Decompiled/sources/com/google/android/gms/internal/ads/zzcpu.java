package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcpu implements zzgea {
    final /* synthetic */ zzcpw zza;

    zzcpu(zzcpw zzcpw) {
        this.zza = zzcpw;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpw zzcpw = this.zza;
        zzfgu zzj = zzcpw.zzh;
        List zzd = zzcpw.zzg.zzd(zzcpw.zze, zzcpw.zzf, false, "", (String) obj, zzcpw.zzf.zzc);
        int i = 1;
        if (true == zzu.zzo().zzz(this.zza.zza)) {
            i = 2;
        }
        zzj.zzc(zzd, i);
    }
}
