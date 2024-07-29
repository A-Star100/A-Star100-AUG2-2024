package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgnu {
    private static final zzgnu zza = ((zzgnu) zzgph.zza(zzgns.zza));
    private final AtomicReference zzb = new AtomicReference(new zzgpf(new zzgoz(), (zzgpe) null));

    public static zzgnu zzc() {
        return zza;
    }

    public final zzgft zza(zzgoy zzgoy, @Nullable zzggn zzggn) throws GeneralSecurityException {
        return ((zzgpf) this.zzb.get()).zza(zzgoy, zzggn);
    }

    public final zzggi zzb(zzgoy zzgoy) throws GeneralSecurityException {
        return ((zzgpf) this.zzb.get()).zzb(zzgoy);
    }

    public final zzgoy zzd(zzgft zzgft, Class cls, @Nullable zzggn zzggn) throws GeneralSecurityException {
        return ((zzgpf) this.zzb.get()).zzc(zzgft, cls, zzggn);
    }

    public final zzgoy zze(zzggi zzggi, Class cls) throws GeneralSecurityException {
        return ((zzgpf) this.zzb.get()).zzd(zzggi, cls);
    }

    public final synchronized void zzf(zzgmw zzgmw) throws GeneralSecurityException {
        zzgoz zzgoz = new zzgoz((zzgpf) this.zzb.get());
        zzgoz.zza(zzgmw);
        this.zzb.set(new zzgpf(zzgoz, (zzgpe) null));
    }

    public final synchronized void zzg(zzgna zzgna) throws GeneralSecurityException {
        zzgoz zzgoz = new zzgoz((zzgpf) this.zzb.get());
        zzgoz.zzb(zzgna);
        this.zzb.set(new zzgpf(zzgoz, (zzgpe) null));
    }

    public final synchronized void zzh(zzgny zzgny) throws GeneralSecurityException {
        zzgoz zzgoz = new zzgoz((zzgpf) this.zzb.get());
        zzgoz.zzc(zzgny);
        this.zzb.set(new zzgpf(zzgoz, (zzgpe) null));
    }

    public final synchronized void zzi(zzgoc zzgoc) throws GeneralSecurityException {
        zzgoz zzgoz = new zzgoz((zzgpf) this.zzb.get());
        zzgoz.zzd(zzgoc);
        this.zzb.set(new zzgpf(zzgoz, (zzgpe) null));
    }

    public final boolean zzj(zzgoy zzgoy) {
        return ((zzgpf) this.zzb.get()).zzi(zzgoy);
    }

    public final boolean zzk(zzgoy zzgoy) {
        return ((zzgpf) this.zzb.get()).zzj(zzgoy);
    }
}
