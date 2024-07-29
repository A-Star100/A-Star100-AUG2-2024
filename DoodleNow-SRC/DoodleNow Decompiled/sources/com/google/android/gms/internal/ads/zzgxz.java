package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgxz extends zzgyb {
    final /* synthetic */ zzgyj zza;
    private int zzb = 0;
    private final int zzc;

    zzgxz(zzgyj zzgyj) {
        this.zza = zzgyj;
        this.zzc = zzgyj.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i < this.zzc) {
            this.zzb = i + 1;
            return this.zza.zzb(i);
        }
        throw new NoSuchElementException();
    }
}
