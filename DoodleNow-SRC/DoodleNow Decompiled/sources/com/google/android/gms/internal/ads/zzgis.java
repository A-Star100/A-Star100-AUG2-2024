package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgis {
    private static final zzgog zza = zzgog.zzb(zzgip.zza, zzgio.class, zzgfj.class);
    private static final zzgnj zzb = zzgiq.zza;
    private static final zzgnl zzc = zzgir.zza;
    private static final zzgfu zzd = zzgnb.zzd("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzgfj.class, zzguo.SYMMETRIC, zzgtq.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            int i = zzglp.zza;
            zzglp.zze(zzgnu.zzc());
            if (zzb()) {
                zzgnr.zza().zze(zza);
                zzgnq zzb2 = zzgnq.zzb();
                HashMap hashMap = new HashMap();
                zzgiu zzgiu = new zzgiu((zzgit) null);
                zzgiu.zza(16);
                zzgiu.zzb(zzgiv.zza);
                hashMap.put("AES128_GCM_SIV", zzgiu.zzc());
                zzgiu zzgiu2 = new zzgiu((zzgit) null);
                zzgiu2.zza(16);
                zzgiu2.zzb(zzgiv.zzc);
                hashMap.put("AES128_GCM_SIV_RAW", zzgiu2.zzc());
                zzgiu zzgiu3 = new zzgiu((zzgit) null);
                zzgiu3.zza(32);
                zzgiu3.zzb(zzgiv.zza);
                hashMap.put("AES256_GCM_SIV", zzgiu3.zzc());
                zzgiu zzgiu4 = new zzgiu((zzgit) null);
                zzgiu4.zza(32);
                zzgiu4.zzb(zzgiv.zzc);
                hashMap.put("AES256_GCM_SIV_RAW", zzgiu4.zzc());
                zzb2.zzd(Collections.unmodifiableMap(hashMap));
                zzgnm.zza().zzb(zzc, zzgix.class);
                zzgnk.zzb().zzc(zzb, zzgix.class);
                zzgms.zzc().zzd(zzd, true);
                return;
            }
            return;
        }
        throw new GeneralSecurityException("Registering AES GCM SIV is not supported in FIPS mode");
    }

    private static boolean zzb() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}
