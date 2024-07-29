package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhcd implements Iterator {
    private final ArrayDeque zza;
    private zzgye zzb;

    /* synthetic */ zzhcd(zzgyj zzgyj, zzhcc zzhcc) {
        if (zzgyj instanceof zzhcf) {
            zzhcf zzhcf = (zzhcf) zzgyj;
            ArrayDeque arrayDeque = new ArrayDeque(zzhcf.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzhcf);
            this.zzb = zzb(zzhcf.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzgye) zzgyj;
    }

    private final zzgye zzb(zzgyj zzgyj) {
        while (zzgyj instanceof zzhcf) {
            zzhcf zzhcf = (zzhcf) zzgyj;
            this.zza.push(zzhcf);
            zzgyj = zzhcf.zzd;
        }
        return (zzgye) zzgyj;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzgye next() {
        zzgye zzgye;
        zzgye zzgye2 = this.zzb;
        if (zzgye2 != null) {
            do {
                ArrayDeque arrayDeque = this.zza;
                zzgye = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzgye;
                } else {
                    zzgye = zzb(((zzhcf) this.zza.pop()).zze);
                }
            } while (zzgye.zzd() == 0);
            this.zzb = zzgye;
            return zzgye2;
        }
        throw new NoSuchElementException();
    }
}
