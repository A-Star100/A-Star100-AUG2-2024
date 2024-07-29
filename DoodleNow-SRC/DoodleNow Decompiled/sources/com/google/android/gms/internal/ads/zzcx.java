package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzcx {
    public static final zzcx zza = new zzcs();
    @Deprecated
    public static final zzn zzb = zzcr.zza;
    private static final String zzc = Integer.toString(0, 36);
    private static final String zzd = Integer.toString(1, 36);
    private static final String zze = Integer.toString(2, 36);

    protected zzcx() {
    }

    public final boolean equals(Object obj) {
        int zzh;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcx)) {
            return false;
        }
        zzcx zzcx = (zzcx) obj;
        if (zzcx.zzc() == zzc() && zzcx.zzb() == zzb()) {
            zzcw zzcw = new zzcw();
            zzcu zzcu = new zzcu();
            zzcw zzcw2 = new zzcw();
            zzcu zzcu2 = new zzcu();
            for (int i = 0; i < zzc(); i++) {
                if (!zze(i, zzcw, 0).equals(zzcx.zze(i, zzcw2, 0))) {
                    return false;
                }
            }
            for (int i2 = 0; i2 < zzb(); i2++) {
                if (!zzd(i2, zzcu, true).equals(zzcx.zzd(i2, zzcu2, true))) {
                    return false;
                }
            }
            int zzg = zzg(true);
            if (zzg == zzcx.zzg(true) && (zzh = zzh(true)) == zzcx.zzh(true)) {
                while (zzg != zzh) {
                    int zzj = zzj(zzg, 0, true);
                    if (zzj != zzcx.zzj(zzg, 0, true)) {
                        return false;
                    }
                    zzg = zzj;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        zzcw zzcw = new zzcw();
        zzcu zzcu = new zzcu();
        int zzc2 = zzc() + JfifUtil.MARKER_EOI;
        int i2 = 0;
        while (true) {
            i = zzc2 * 31;
            if (i2 >= zzc()) {
                break;
            }
            zzc2 = i + zze(i2, zzcw, 0).hashCode();
            i2++;
        }
        int zzb2 = i + zzb();
        for (int i3 = 0; i3 < zzb(); i3++) {
            zzb2 = (zzb2 * 31) + zzd(i3, zzcu, true).hashCode();
        }
        int zzg = zzg(true);
        while (zzg != -1) {
            zzb2 = (zzb2 * 31) + zzg;
            zzg = zzj(zzg, 0, true);
        }
        return zzb2;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzcu zzd(int i, zzcu zzcu, boolean z);

    public abstract zzcw zze(int i, zzcw zzcw, long j);

    public abstract Object zzf(int i);

    public int zzg(boolean z) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i, zzcu zzcu, zzcw zzcw, int i2, boolean z) {
        int i3 = zzd(i, zzcu, false).zzd;
        if (zze(i3, zzcw, 0).zzq != i) {
            return i + 1;
        }
        int zzj = zzj(i3, i2, z);
        if (zzj == -1) {
            return -1;
        }
        return zze(zzj, zzcw, 0).zzp;
    }

    public int zzj(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == zzh(z) ? zzg(z) : i + 1;
            }
            throw new IllegalStateException();
        } else if (i == zzh(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int zzk(int i, int i2, boolean z) {
        if (i == zzg(false)) {
            return -1;
        }
        return i - 1;
    }

    public final Pair zzl(zzcw zzcw, zzcu zzcu, int i, long j) {
        Pair zzm = zzm(zzcw, zzcu, i, j, 0);
        zzm.getClass();
        return zzm;
    }

    public final Pair zzm(zzcw zzcw, zzcu zzcu, int i, long j, long j2) {
        zzek.zza(i, 0, zzc());
        zze(i, zzcw, j2);
        if (j == C.TIME_UNSET) {
            long j3 = zzcw.zzn;
            j = 0;
        }
        int i2 = zzcw.zzp;
        zzd(i2, zzcu, false);
        while (i2 < zzcw.zzq) {
            long j4 = zzcu.zzf;
            int i3 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i3 == 0) {
                break;
            }
            int i4 = i2 + 1;
            long j5 = zzd(i4, zzcu, false).zzf;
            if (i3 < 0) {
                break;
            }
            i2 = i4;
        }
        zzd(i2, zzcu, true);
        long j6 = zzcu.zzf;
        long j7 = zzcu.zze;
        if (j7 != C.TIME_UNSET) {
            j = Math.min(j, j7 - 1);
        }
        long max = Math.max(0, j);
        Object obj = zzcu.zzc;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public zzcu zzn(Object obj, zzcu zzcu) {
        return zzd(zza(obj), zzcu, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
