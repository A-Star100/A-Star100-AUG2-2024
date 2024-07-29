package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzghs {
    public static final /* synthetic */ int zza = 0;
    private static final zzgog zzb = zzgog.zzb(zzghq.zza, zzghp.class, zzgfj.class);
    private static final zzgfu zzc = zzgnb.zzd("type.googleapis.com/google.crypto.tink.AesEaxKey", zzgfj.class, zzguo.SYMMETRIC, zzgtb.zzh());
    private static final zzgnj zzd = zzghr.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            int i = zzglf.zza;
            zzglf.zze(zzgnu.zzc());
            zzgnr.zza().zze(zzb);
            zzgnq zzb2 = zzgnq.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_EAX", zzgko.zzc);
            zzghu zzghu = new zzghu((zzght) null);
            zzghu.zza(16);
            zzghu.zzb(16);
            zzghu.zzc(16);
            zzghu.zzd(zzghv.zzc);
            hashMap.put("AES128_EAX_RAW", zzghu.zze());
            hashMap.put("AES256_EAX", zzgko.zzd);
            zzghu zzghu2 = new zzghu((zzght) null);
            zzghu2.zza(16);
            zzghu2.zzb(32);
            zzghu2.zzc(16);
            zzghu2.zzd(zzghv.zzc);
            hashMap.put("AES256_EAX_RAW", zzghu2.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnk.zzb().zzc(zzd, zzghx.class);
            zzgms.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
    }
}
