package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejf implements zzegp {
    private final Context zza;
    private final zzdji zzb;
    private final Executor zzc;

    public zzejf(Context context, zzdji zzdji, Executor executor) {
        this.zza = context;
        this.zzb = zzdji;
        this.zzc = executor;
    }

    private static final boolean zzc(zzffz zzffz, int i) {
        return zzffz.zza.zza.zzg.contains(Integer.toString(i));
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzdky zzdky;
        zzbqz zzD = ((zzfhg) zzegm.zzb).zzD();
        zzbra zzE = ((zzfhg) zzegm.zzb).zzE();
        zzbrd zzd = ((zzfhg) zzegm.zzb).zzd();
        if (zzd != null && zzc(zzffz, 6)) {
            zzdky = zzdky.zzt(zzd);
        } else if (zzD != null && zzc(zzffz, 6)) {
            zzdky = zzdky.zzai(zzD);
        } else if (zzD != null && zzc(zzffz, 2)) {
            zzdky = zzdky.zzag(zzD);
        } else if (zzE != null && zzc(zzffz, 6)) {
            zzdky = zzdky.zzaj(zzE);
        } else if (zzE == null || !zzc(zzffz, 1)) {
            throw new zzekh(1, "No native ad mappers");
        } else {
            zzdky = zzdky.zzah(zzE);
        }
        zzfgi zzfgi = zzffz.zza.zza;
        if (zzfgi.zzg.contains(Integer.toString(zzdky.zzc()))) {
            zzdla zze = this.zzb.zze(new zzcul(zzffz, zzffn, zzegm.zza), new zzdlk(zzdky), new zzdnb(zzE, zzD, zzd));
            ((zzeif) zzegm.zzc).zzc(zze.zzj());
            zze.zzd().zzo(new zzcpa((zzfhg) zzegm.zzb), this.zzc);
            return zze.zza();
        }
        throw new zzekh(1, "No corresponding native ad listener");
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        zzfgi zzfgi = zzffz.zza.zza;
        zzfgi zzfgi2 = zzffz.zza.zza;
        zzbgt zzbgt = zzfgi2.zzi;
        ((zzfhg) zzegm.zzb).zzp(this.zza, zzfgi.zzd, zzffn.zzw.toString(), zzbw.zzl(zzffn.zzt), (zzbqu) zzegm.zzc, zzbgt, zzfgi2.zzg);
    }
}
