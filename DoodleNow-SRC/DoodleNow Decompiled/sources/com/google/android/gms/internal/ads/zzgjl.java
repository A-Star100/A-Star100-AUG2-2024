package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjl {
    public static final /* synthetic */ int zza = 0;
    private static final zzgog zzb = zzgog.zzb(zzgjj.zza, zzgjq.class, zzgfj.class);
    private static final zzgfu zzc = zzgnb.zzd("type.googleapis.com/google.crypto.tink.KmsAeadKey", zzgfj.class, zzguo.REMOTE, zzgvk.zzg());
    private static final zzgnj zzd = zzgjk.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            int i = zzgjw.zza;
            zzgjw.zza(zzgnu.zzc());
            zzgnr.zza().zze(zzb);
            zzgnk.zzb().zzc(zzd, zzgjr.class);
            zzgms.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS AEAD is not supported in FIPS mode");
    }
}
