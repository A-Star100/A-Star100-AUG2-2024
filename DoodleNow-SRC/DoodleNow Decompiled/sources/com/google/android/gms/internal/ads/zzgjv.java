package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzgjv implements zzgmu {
    public static final /* synthetic */ zzgjv zza = new zzgjv();

    private /* synthetic */ zzgjv() {
    }

    public final zzgft zza(zzgoy zzgoy, zzggn zzggn) {
        int i = zzgjw.zza;
        zzgot zzgot = (zzgot) zzgoy;
        if (!zzgot.zzg().equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsAeadProtoSerialization.parseKey");
        } else if (zzgot.zzc() == zzgvv.RAW) {
            try {
                zzgvk zze = zzgvk.zze(((zzgot) zzgoy).zze(), zzgzf.zza());
                if (zze.zza() == 0) {
                    return zzgjq.zza(zzgjr.zzb(zze.zzf().zzf()));
                }
                String valueOf = String.valueOf(zze);
                throw new GeneralSecurityException("KmsAeadKey are only accepted with version 0, got " + valueOf);
            } catch (zzhak e) {
                throw new GeneralSecurityException("Parsing KmsAeadKey failed: ", e);
            }
        } else {
            throw new GeneralSecurityException("KmsAeadKey are only accepted with RAW, got ".concat(String.valueOf(String.valueOf(zzgot.zzc()))));
        }
    }
}
