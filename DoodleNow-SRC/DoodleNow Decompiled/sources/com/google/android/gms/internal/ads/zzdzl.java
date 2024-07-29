package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.regex.Matcher;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdzl implements zzgea {
    final /* synthetic */ zzdzm zza;

    zzdzl(zzdzm zzdzm) {
        this.zza = zzdzm;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue()) {
            Matcher matcher = zzdzm.zza.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zza.zzf.zzi(Integer.parseInt(matcher.group(1)));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzffz zzffz = (zzffz) obj;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue()) {
            this.zza.zzf.zzi(zzffz.zzb.zzb.zze);
            this.zza.zzf.zzj(zzffz.zzb.zzb.zzf);
        }
    }
}
