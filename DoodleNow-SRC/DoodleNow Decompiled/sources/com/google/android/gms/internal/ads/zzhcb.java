package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhcb {
    private final ArrayDeque zza = new ArrayDeque();

    private zzhcb() {
    }

    static /* bridge */ /* synthetic */ zzgyj zza(zzhcb zzhcb, zzgyj zzgyj, zzgyj zzgyj2) {
        zzhcb.zzb(zzgyj);
        zzhcb.zzb(zzgyj2);
        zzgyj zzgyj3 = (zzgyj) zzhcb.zza.pop();
        while (!zzhcb.zza.isEmpty()) {
            zzgyj3 = new zzhcf((zzgyj) zzhcb.zza.pop(), zzgyj3);
        }
        return zzgyj3;
    }

    private final void zzb(zzgyj zzgyj) {
        if (zzgyj.zzh()) {
            int zzc = zzc(zzgyj.zzd());
            ArrayDeque arrayDeque = this.zza;
            int zzc2 = zzhcf.zzc(zzc + 1);
            if (arrayDeque.isEmpty() || ((zzgyj) this.zza.peek()).zzd() >= zzc2) {
                this.zza.push(zzgyj);
                return;
            }
            int zzc3 = zzhcf.zzc(zzc);
            zzgyj zzgyj2 = (zzgyj) this.zza.pop();
            while (!this.zza.isEmpty() && ((zzgyj) this.zza.peek()).zzd() < zzc3) {
                zzgyj2 = new zzhcf((zzgyj) this.zza.pop(), zzgyj2);
            }
            zzhcf zzhcf = new zzhcf(zzgyj2, zzgyj);
            while (!this.zza.isEmpty()) {
                ArrayDeque arrayDeque2 = this.zza;
                if (((zzgyj) arrayDeque2.peek()).zzd() >= zzhcf.zzc(zzc(zzhcf.zzd()) + 1)) {
                    break;
                }
                zzhcf = new zzhcf((zzgyj) this.zza.pop(), zzhcf);
            }
            this.zza.push(zzhcf);
        } else if (zzgyj instanceof zzhcf) {
            zzhcf zzhcf2 = (zzhcf) zzgyj;
            zzb(zzhcf2.zzd);
            zzb(zzhcf2.zze);
        } else {
            throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(String.valueOf(zzgyj.getClass()))));
        }
    }

    private static final int zzc(int i) {
        int binarySearch = Arrays.binarySearch(zzhcf.zza, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }

    /* synthetic */ zzhcb(zzhca zzhca) {
    }
}
