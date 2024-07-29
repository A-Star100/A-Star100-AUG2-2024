package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzgni implements zzgnj {
    public static final /* synthetic */ zzgni zza = new zzgni();

    private /* synthetic */ zzgni() {
    }

    public final zzgft zza(zzggi zzggi, Integer num) {
        int i = zzgnk.zza;
        zzguu zzc = ((zzgne) zzggi).zzb().zzc();
        zzgfu zzb = zzgms.zzc().zzb(zzc.zzi());
        if (zzgms.zzc().zze(zzc.zzi())) {
            zzgup zza2 = zzb.zza(zzc.zzh());
            return new zzgnd(zzgot.zza(zza2.zzg(), zza2.zzf(), zza2.zzc(), zzc.zzg(), num), zzgfs.zza());
        }
        throw new GeneralSecurityException("Creating new keys is not allowed.");
    }
}
