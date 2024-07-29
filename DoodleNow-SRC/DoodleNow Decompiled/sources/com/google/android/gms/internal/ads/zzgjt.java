package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzgjt implements zzgnw {
    public static final /* synthetic */ zzgjt zza = new zzgjt();

    private /* synthetic */ zzgjt() {
    }

    public final zzggi zza(zzgoy zzgoy) {
        int i = zzgjw.zza;
        zzgou zzgou = (zzgou) zzgoy;
        if (zzgou.zzc().zzi().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            try {
                zzgvn zze = zzgvn.zze(((zzgou) zzgoy).zzc().zzh(), zzgzf.zza());
                if (zzgou.zzc().zzg() == zzgvv.RAW) {
                    return zzgjr.zzb(zze.zzf());
                }
                String valueOf = String.valueOf(zzgou.zzc().zzg());
                String valueOf2 = String.valueOf(zze);
                throw new GeneralSecurityException("Only key templates with RAW are accepted, but got " + valueOf + " with format " + valueOf2);
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing KmsAeadKeyFormat failed: ", e);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzgou.zzc().zzi())));
        }
    }
}
