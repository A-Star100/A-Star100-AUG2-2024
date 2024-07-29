package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnk {
    public static final /* synthetic */ int zza = 0;
    private static final zzgnj zzb = zzgni.zza;
    private static final zzgnk zzc = zze();
    private final Map zzd = new HashMap();

    public static zzgnk zzb() {
        return zzc;
    }

    private final synchronized zzgft zzd(zzggi zzggi, @Nullable Integer num) throws GeneralSecurityException {
        zzgnj zzgnj;
        zzgnj = (zzgnj) this.zzd.get(zzggi.getClass());
        if (zzgnj != null) {
        } else {
            String obj = zzggi.toString();
            throw new GeneralSecurityException("Cannot create a new key for parameters " + obj + ": no key creator for this class was registered.");
        }
        return zzgnj.zza(zzggi, num);
    }

    private static zzgnk zze() {
        zzgnk zzgnk = new zzgnk();
        try {
            zzgnk.zzc(zzb, zzgne.class);
            return zzgnk;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("unexpected error.", e);
        }
    }

    public final zzgft zza(zzggi zzggi, @Nullable Integer num) throws GeneralSecurityException {
        return zzd(zzggi, num);
    }

    public final synchronized void zzc(zzgnj zzgnj, Class cls) throws GeneralSecurityException {
        zzgnj zzgnj2 = (zzgnj) this.zzd.get(cls);
        if (zzgnj2 != null) {
            if (!zzgnj2.equals(zzgnj)) {
                String obj = cls.toString();
                throw new GeneralSecurityException("Different key creator for parameters class " + obj + " already inserted");
            }
        }
        this.zzd.put(cls, zzgnj);
    }
}
