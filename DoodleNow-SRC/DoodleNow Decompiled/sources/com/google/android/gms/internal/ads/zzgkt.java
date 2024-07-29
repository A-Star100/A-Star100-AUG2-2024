package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgkt {
    public static final /* synthetic */ int zza = 0;
    private static final zzgog zzb = zzgog.zzb(zzgkq.zza, zzgkp.class, zzgfj.class);
    private static final zzgfu zzc = zzgnb.zzd("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", zzgfj.class, zzguo.SYMMETRIC, zzgwb.zzg());
    private static final zzgnl zzd = zzgkr.zza;
    private static final zzgnj zze = zzgks.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (zzgml.zza(1)) {
            int i = zzgmi.zza;
            zzgmi.zze(zzgnu.zzc());
            zzgnr.zza().zze(zzb);
            zzgnq zzb2 = zzgnq.zzb();
            HashMap hashMap = new HashMap();
            hashMap.put("XCHACHA20_POLY1305", zzgkv.zzc(zzgku.zza));
            hashMap.put("XCHACHA20_POLY1305_RAW", zzgkv.zzc(zzgku.zzc));
            zzb2.zzd(Collections.unmodifiableMap(hashMap));
            zzgnk.zzb().zzc(zze, zzgkv.class);
            zzgnm.zza().zzb(zzd, zzgkv.class);
            zzgms.zzc().zzd(zzc, true);
            return;
        }
        throw new GeneralSecurityException("Registering XChaCha20Poly1305 is not supported in FIPS mode");
    }
}
