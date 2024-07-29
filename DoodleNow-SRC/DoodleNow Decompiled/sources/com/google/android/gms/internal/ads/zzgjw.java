package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgjw {
    public static final /* synthetic */ int zza = 0;
    private static final zzgxm zzb;
    private static final zzgoc zzc = zzgoc.zzb(zzgjs.zza, zzgjr.class, zzgou.class);
    private static final zzgny zzd;
    private static final zzgna zze = zzgna.zzb(zzgju.zza, zzgjq.class, zzgot.class);
    private static final zzgmw zzf;

    static {
        zzgxm zza2 = zzgpi.zza("type.googleapis.com/google.crypto.tink.KmsAeadKey");
        zzb = zza2;
        zzd = zzgny.zzb(zzgjt.zza, zza2, zzgou.class);
        zzf = zzgmw.zzb(zzgjv.zza, zza2, zzgot.class);
    }

    public static void zza(zzgnu zzgnu) throws GeneralSecurityException {
        zzgnu.zzi(zzc);
        zzgnu.zzh(zzd);
        zzgnu.zzg(zze);
        zzgnu.zzf(zzf);
    }
}
