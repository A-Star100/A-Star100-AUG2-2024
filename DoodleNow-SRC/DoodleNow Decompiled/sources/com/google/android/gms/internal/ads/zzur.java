package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzur implements zzxa {
    private final zzfzn zza;
    private long zzb;

    public zzur(List list, List list2) {
        zzfzk zzfzk = new zzfzk();
        zzek.zzd(list.size() == list2.size());
        for (int i = 0; i < list.size(); i++) {
            zzfzk.zzf(new zzuq((zzxa) list.get(i), (List) list2.get(i)));
        }
        this.zza = zzfzk.zzi();
        this.zzb = C.TIME_UNSET;
    }

    public final long zzb() {
        long j = Long.MAX_VALUE;
        long j2 = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            zzuq zzuq = (zzuq) this.zza.get(i);
            long zzb2 = zzuq.zzb();
            if ((zzuq.zza().contains(1) || zzuq.zza().contains(2) || zzuq.zza().contains(4)) && zzb2 != Long.MIN_VALUE) {
                j = Math.min(j, zzb2);
            }
            if (zzb2 != Long.MIN_VALUE) {
                j2 = Math.min(j2, zzb2);
            }
        }
        if (j != Long.MAX_VALUE) {
            this.zzb = j;
            return j;
        } else if (j2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        } else {
            long j3 = this.zzb;
            return j3 != C.TIME_UNSET ? j3 : j2;
        }
    }

    public final long zzc() {
        long j = Long.MAX_VALUE;
        for (int i = 0; i < this.zza.size(); i++) {
            long zzc = ((zzuq) this.zza.get(i)).zzc();
            if (zzc != Long.MIN_VALUE) {
                j = Math.min(j, zzc);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final void zzm(long j) {
        for (int i = 0; i < this.zza.size(); i++) {
            ((zzuq) this.zza.get(i)).zzm(j);
        }
    }

    public final boolean zzo(zzlg zzlg) {
        boolean z;
        boolean z2 = false;
        do {
            long zzc = zzc();
            if (zzc == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (int i = 0; i < this.zza.size(); i++) {
                long zzc2 = ((zzuq) this.zza.get(i)).zzc();
                boolean z3 = zzc2 != Long.MIN_VALUE && zzc2 <= zzlg.zza;
                if (zzc2 == zzc || z3) {
                    z |= ((zzuq) this.zza.get(i)).zzo(zzlg);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final boolean zzp() {
        for (int i = 0; i < this.zza.size(); i++) {
            if (((zzuq) this.zza.get(i)).zzp()) {
                return true;
            }
        }
        return false;
    }
}
