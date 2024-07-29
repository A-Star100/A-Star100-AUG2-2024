package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnr {
    private static final zzgnr zza = new zzgnr();
    private final AtomicReference zzb = new AtomicReference(new zzgom(new zzgoi((zzgoh) null), (zzgol) null));

    zzgnr() {
    }

    public static zzgnr zza() {
        return zza;
    }

    public final Class zzb(Class cls) throws GeneralSecurityException {
        return ((zzgom) this.zzb.get()).zza(cls);
    }

    public final Object zzc(zzgft zzgft, Class cls) throws GeneralSecurityException {
        return ((zzgom) this.zzb.get()).zzb(zzgft, cls);
    }

    public final Object zzd(zzgos zzgos, Class cls) throws GeneralSecurityException {
        return ((zzgom) this.zzb.get()).zzc(zzgos, cls);
    }

    public final synchronized void zze(zzgog zzgog) throws GeneralSecurityException {
        zzgoi zzgoi = new zzgoi((zzgom) this.zzb.get(), (zzgoh) null);
        zzgoi.zza(zzgog);
        this.zzb.set(new zzgom(zzgoi, (zzgol) null));
    }

    public final synchronized void zzf(zzggj zzggj) throws GeneralSecurityException {
        zzgoi zzgoi = new zzgoi((zzgom) this.zzb.get(), (zzgoh) null);
        zzgoi.zzb(zzggj);
        this.zzb.set(new zzgom(zzgoi, (zzgol) null));
    }
}
