package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnb implements zzgfu {
    final String zza;
    final Class zzb;
    final zzguo zzc;
    final zzhbt zzd;

    zzgnb(String str, Class cls, zzguo zzguo, zzhbt zzhbt) {
        this.zzd = zzhbt;
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzguo;
    }

    public static zzgfu zzd(String str, Class cls, zzguo zzguo, zzhbt zzhbt) {
        return new zzgnb(str, cls, zzguo, zzhbt);
    }

    public final zzgup zza(zzgyj zzgyj) throws GeneralSecurityException {
        zzgut zza2 = zzguu.zza();
        zza2.zzb(this.zza);
        zza2.zzc(zzgyj);
        zza2.zza(zzgvv.RAW);
        zzgoy zzd2 = zzgnu.zzc().zzd(zzgnk.zzb().zza(zzgnu.zzc().zzb(zzgou.zza((zzguu) zza2.zzbr())), (Integer) null), zzgot.class, zzgfs.zza());
        zzgum zza3 = zzgup.zza();
        zzgot zzgot = (zzgot) zzd2;
        zza3.zzb(zzgot.zzg());
        zza3.zzc(zzgot.zze());
        zza3.zza(zzgot.zzb());
        return (zzgup) zza3.zzbr();
    }

    public final Class zzb() {
        return this.zzb;
    }

    public final Object zzc(zzgyj zzgyj) throws GeneralSecurityException {
        return zzgnr.zza().zzc(zzgnu.zzc().zza(zzgot.zza(this.zza, zzgyj, this.zzc, zzgvv.RAW, (Integer) null), zzgfs.zza()), this.zzb);
    }
}
