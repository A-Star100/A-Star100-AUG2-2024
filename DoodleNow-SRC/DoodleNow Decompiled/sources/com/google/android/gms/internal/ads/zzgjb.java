package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgjb {
    public static final /* synthetic */ int zza = 0;
    private static final zzgog zzb = zzgog.zzb(zzgiz.zza, zzgiy.class, zzgfj.class);
    private static final zzgnj zzc = zzgja.zza;
    private static final zzgfu zzd = zzgnb.zzd("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", zzgfj.class, zzguo.SYMMETRIC, zzgtw.zzg());

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            int i = zzgji.zza;
            zzgji.zze(zzgnu.zzc());
            zzgnr.zza().zze(zzb);
            zzgnk.zzb().zzc(zzc, zzgjd.class);
            zzgnq zzb2 = zzgnq.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("CHACHA20_POLY1305", zzgjd.zzc(zzgjc.zza));
            hashMap.put("CHACHA20_POLY1305_RAW", zzgjd.zzc(zzgjc.zzc));
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgms.zzc().zzd(zzd, true);
            return;
        }
        throw new GeneralSecurityException("Registering ChaCha20Poly1305 is not supported in FIPS mode");
    }
}
