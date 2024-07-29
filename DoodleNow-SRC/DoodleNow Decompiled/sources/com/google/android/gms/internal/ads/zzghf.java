package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzghf {
    public static final /* synthetic */ int zza = 0;
    private static final zzgog zzb = zzgog.zzb(zzghc.zza, zzghb.class, zzgfj.class);
    private static final zzgfu zzc = zzgnb.zzd("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", zzgfj.class, zzguo.SYMMETRIC, zzgsm.zzh());
    private static final zzgnl zzd = zzghd.zza;
    private static final zzgnj zze = zzghe.zza;
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgml.zza(i)) {
            int i2 = zzgla.zza;
            zzgla.zze(zzgnu.zzc());
            zzgnr.zza().zze(zzb);
            zzgnq zzb2 = zzgnq.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_CTR_HMAC_SHA256", zzgko.zze);
            zzghh zzghh = new zzghh((zzghg) null);
            zzghh.zza(16);
            zzghh.zzc(32);
            zzghh.zze(16);
            zzghh.zzd(16);
            zzghh.zzb(zzghi.zzc);
            zzghh.zzf(zzghj.zzc);
            hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zzghh.zzg());
            hashMap.put("AES256_CTR_HMAC_SHA256", zzgko.zzf);
            zzghh zzghh2 = new zzghh((zzghg) null);
            zzghh2.zza(32);
            zzghh2.zzc(32);
            zzghh2.zze(32);
            zzghh2.zzd(16);
            zzghh2.zzb(zzghi.zzc);
            zzghh2.zzf(zzghj.zzc);
            hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzghh2.zzg());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnm.zza().zzb(zzd, zzghl.class);
            zzgnk.zzb().zzc(zze, zzghl.class);
            zzgms.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-CTR-HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
