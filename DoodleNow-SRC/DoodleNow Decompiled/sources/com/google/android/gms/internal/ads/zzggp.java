package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzggp {
    public static zzggi zza(byte[] bArr) throws GeneralSecurityException {
        try {
            zzguu zzf = zzguu.zzf(bArr, zzgzf.zza());
            zzgnu zzc = zzgnu.zzc();
            zzgou zza = zzgou.zza(zzf);
            if (!zzc.zzk(zza)) {
                return new zzgne(zza);
            }
            return zzc.zzb(zza);
        } catch (IOException e) {
            throw new GeneralSecurityException("Failed to parse proto", e);
        }
    }

    public static byte[] zzb(zzggi zzggi) throws GeneralSecurityException {
        return ((zzgou) zzgnu.zzc().zze(zzggi, zzgou.class)).zzc().zzaV();
    }
}
