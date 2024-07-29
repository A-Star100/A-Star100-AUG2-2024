package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgqi {
    private static final zzgog zza = zzgog.zzb(zzgqe.zza, zzgqd.class, zzgpw.class);
    private static final zzgog zzb = zzgog.zzb(zzgqf.zza, zzgqd.class, zzggh.class);
    private static final zzgfu zzc = zzgnb.zzd("type.googleapis.com/google.crypto.tink.HmacKey", zzggh.class, zzguo.SYMMETRIC, zzgue.zzi());
    private static final zzgnl zzd = zzgqg.zza;
    private static final zzgnj zze = zzgqh.zza;
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgml.zza(i)) {
            int i2 = zzgro.zza;
            zzgro.zze(zzgnu.zzc());
            zzgnr.zza().zze(zza);
            zzgnr.zza().zze(zzb);
            zzgnq zzb2 = zzgnq.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("HMAC_SHA256_128BITTAG", zzgrb.zza);
            zzgqk zzgqk = new zzgqk((zzgqj) null);
            zzgqk.zzb(32);
            zzgqk.zzc(16);
            zzgqk.zzd(zzgqm.zzd);
            zzgqk.zza(zzgql.zzc);
            hashMap.put("HMAC_SHA256_128BITTAG_RAW", zzgqk.zze());
            zzgqk zzgqk2 = new zzgqk((zzgqj) null);
            zzgqk2.zzb(32);
            zzgqk2.zzc(32);
            zzgqk2.zzd(zzgqm.zza);
            zzgqk2.zza(zzgql.zzc);
            hashMap.put("HMAC_SHA256_256BITTAG", zzgqk2.zze());
            zzgqk zzgqk3 = new zzgqk((zzgqj) null);
            zzgqk3.zzb(32);
            zzgqk3.zzc(32);
            zzgqk3.zzd(zzgqm.zzd);
            zzgqk3.zza(zzgql.zzc);
            hashMap.put("HMAC_SHA256_256BITTAG_RAW", zzgqk3.zze());
            zzgqk zzgqk4 = new zzgqk((zzgqj) null);
            zzgqk4.zzb(64);
            zzgqk4.zzc(16);
            zzgqk4.zzd(zzgqm.zza);
            zzgqk4.zza(zzgql.zze);
            hashMap.put("HMAC_SHA512_128BITTAG", zzgqk4.zze());
            zzgqk zzgqk5 = new zzgqk((zzgqj) null);
            zzgqk5.zzb(64);
            zzgqk5.zzc(16);
            zzgqk5.zzd(zzgqm.zzd);
            zzgqk5.zza(zzgql.zze);
            hashMap.put("HMAC_SHA512_128BITTAG_RAW", zzgqk5.zze());
            zzgqk zzgqk6 = new zzgqk((zzgqj) null);
            zzgqk6.zzb(64);
            zzgqk6.zzc(32);
            zzgqk6.zzd(zzgqm.zza);
            zzgqk6.zza(zzgql.zze);
            hashMap.put("HMAC_SHA512_256BITTAG", zzgqk6.zze());
            zzgqk zzgqk7 = new zzgqk((zzgqj) null);
            zzgqk7.zzb(64);
            zzgqk7.zzc(32);
            zzgqk7.zzd(zzgqm.zzd);
            zzgqk7.zza(zzgql.zze);
            hashMap.put("HMAC_SHA512_256BITTAG_RAW", zzgqk7.zze());
            hashMap.put("HMAC_SHA512_512BITTAG", zzgrb.zzd);
            zzgqk zzgqk8 = new zzgqk((zzgqj) null);
            zzgqk8.zzb(64);
            zzgqk8.zzc(64);
            zzgqk8.zzd(zzgqm.zzd);
            zzgqk8.zza(zzgql.zze);
            hashMap.put("HMAC_SHA512_512BITTAG_RAW", zzgqk8.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnk.zzb().zzc(zze, zzgqo.class);
            zzgnm.zza().zzb(zzd, zzgqo.class);
            zzgms.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
