package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgpq {
    private static final zzgnj zza = zzgpn.zza;
    private static final zzgog zzb = zzgog.zzb(zzgpo.zza, zzgpm.class, zzgpw.class);
    private static final zzgog zzc = zzgog.zzb(zzgpp.zza, zzgpm.class, zzggh.class);
    private static final zzgfu zzd = zzgnb.zzd("type.googleapis.com/google.crypto.tink.AesCmacKey", zzggh.class, zzguo.SYMMETRIC, zzgsd.zzh());

    public static /* synthetic */ zzgpm zzb(zzgpv zzgpv, Integer num) {
        zze(zzgpv);
        zzgpk zzgpk = new zzgpk((zzgpj) null);
        zzgpk.zzc(zzgpv);
        zzgpk.zza(zzgxn.zzc(zzgpv.zzc()));
        zzgpk.zzb(num);
        return zzgpk.zzd();
    }

    public static void zzd(boolean z) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            int i = zzgrg.zza;
            zzgrg.zze(zzgnu.zzc());
            zzgnk.zzb().zzc(zza, zzgpv.class);
            zzgnr.zza().zze(zzb);
            zzgnr.zza().zze(zzc);
            zzgnq zzb2 = zzgnq.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES_CMAC", zzgrb.zze);
            hashMap.put("AES256_CMAC", zzgrb.zze);
            zzgps zzgps = new zzgps((zzgpr) null);
            zzgps.zza(32);
            zzgps.zzb(16);
            zzgps.zzc(zzgpt.zzd);
            hashMap.put("AES256_CMAC_RAW", zzgps.zzd());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgms.zzc().zzd(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES CMAC is not supported in FIPS mode");
    }

    /* access modifiers changed from: private */
    public static void zze(zzgpv zzgpv) throws GeneralSecurityException {
        if (zzgpv.zzc() != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }
}
