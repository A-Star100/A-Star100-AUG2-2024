package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgif {
    public static final /* synthetic */ int zza = 0;
    private static final zzgog zzb = zzgog.zzb(zzgic.zza, zzgib.class, zzgfj.class);
    private static final zzgfu zzc = zzgnb.zzd("type.googleapis.com/google.crypto.tink.AesGcmKey", zzgfj.class, zzguo.SYMMETRIC, zzgtk.zzg());
    private static final zzgnl zzd = zzgid.zza;
    private static final zzgnj zze = zzgie.zza;
    private static final int zzf = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzf;
        if (zzgml.zza(i)) {
            int i2 = zzglk.zza;
            zzglk.zze(zzgnu.zzc());
            zzgnr.zza().zze(zzb);
            zzgnq zzb2 = zzgnq.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("AES128_GCM", zzgko.zza);
            zzgih zzgih = new zzgih((zzgig) null);
            zzgih.zza(12);
            zzgih.zzb(16);
            zzgih.zzc(16);
            zzgih.zzd(zzgii.zzc);
            hashMap.put("AES128_GCM_RAW", zzgih.zze());
            hashMap.put("AES256_GCM", zzgko.zzb);
            zzgih zzgih2 = new zzgih((zzgig) null);
            zzgih2.zza(12);
            zzgih2.zzb(32);
            zzgih2.zzc(16);
            zzgih2.zzd(zzgii.zzc);
            hashMap.put("AES256_GCM_RAW", zzgih2.zze());
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnm.zza().zzb(zzd, zzgik.class);
            zzgnk.zzb().zzc(zze, zzgik.class);
            zzgms.zzc().zzf(zzc, i, true);
            return;
        }
        throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
    }
}
