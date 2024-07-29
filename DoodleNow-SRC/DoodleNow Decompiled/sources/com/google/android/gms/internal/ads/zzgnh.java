package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnh {
    public static final zzgrt zza = new zzgng((zzgnf) null);

    public static zzgrz zza(zzgos zzgos) {
        zzgfv zzgfv;
        zzgrv zzgrv = new zzgrv();
        zzgrv.zzb(zzgos.zzc());
        for (List it : zzgos.zze()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzgoq zzgoq = (zzgoq) it2.next();
                    zzgur zzb = zzgoq.zzb();
                    zzgur zzgur = zzgur.UNKNOWN_STATUS;
                    int ordinal = zzb.ordinal();
                    if (ordinal == 1) {
                        zzgfv = zzgfv.zza;
                    } else if (ordinal == 2) {
                        zzgfv = zzgfv.zzb;
                    } else if (ordinal == 3) {
                        zzgfv = zzgfv.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzgoq.zza();
                    String zzf = zzgoq.zzf();
                    if (zzf.startsWith("type.googleapis.com/google.crypto.")) {
                        zzf = zzf.substring(34);
                    }
                    zzgrv.zza(zzgfv, zza2, zzf, zzgoq.zzc().name());
                }
            }
        }
        if (zzgos.zzb() != null) {
            zzgrv.zzc(zzgos.zzb().zza());
        }
        try {
            return zzgrv.zzd();
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
