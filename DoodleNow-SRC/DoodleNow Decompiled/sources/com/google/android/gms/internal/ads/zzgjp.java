package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjp {
    public static final /* synthetic */ int zza = 0;
    private static final zzgfu zzb = zzgnb.zzd("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzgfj.class, zzguo.SYMMETRIC, zzgvq.zzg());
    private static final zzgnj zzc = zzgjn.zza;
    private static final zzgog zzd = zzgog.zzb(zzgjo.zza, zzgjx.class, zzgfj.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            int i = zzgkh.zza;
            zzgkh.zze(zzgnu.zzc());
            zzgnk.zzb().zzc(zzc, zzgkc.class);
            zzgnr.zza().zze(zzd);
            zzgms.zzc().zzd(zzb, true);
            return;
        }
        throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
    }
}
