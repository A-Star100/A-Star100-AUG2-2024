package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzpf {
    public static final zzpf zza;
    public final int zzb;
    public final int zzc;
    private final zzfzs zzd;

    static {
        zzpf zzpf;
        if (zzfx.zza >= 33) {
            zzfzr zzfzr = new zzfzr();
            for (int i = 1; i <= 10; i++) {
                zzfzr.zzf(Integer.valueOf(zzfx.zzh(i)));
            }
            zzpf = new zzpf(2, (Set) zzfzr.zzi());
        } else {
            zzpf = new zzpf(2, 10);
        }
        zza = zzpf;
    }

    public zzpf(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public zzpf(int i, Set set) {
        this.zzb = i;
        zzfzs zzl = zzfzs.zzl(set);
        this.zzd = zzl;
        zzgbt zze = zzl.iterator();
        int i2 = 0;
        while (zze.hasNext()) {
            i2 = Math.max(i2, Integer.bitCount(((Integer) zze.next()).intValue()));
        }
        this.zzc = i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpf)) {
            return false;
        }
        zzpf zzpf = (zzpf) obj;
        return this.zzb == zzpf.zzb && this.zzc == zzpf.zzc && zzfx.zzG(this.zzd, zzpf.zzd);
    }

    public final int hashCode() {
        zzfzs zzfzs = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzfzs == null ? 0 : zzfzs.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        return "AudioProfile[format=" + this.zzb + ", maxChannelCount=" + this.zzc + ", channelMasks=" + valueOf + "]";
    }

    public final int zza(int i, zzk zzk) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (zzfx.zza >= 29) {
            return zzpd.zza(this.zzb, i, zzk);
        }
        Integer num = (Integer) zzph.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
        num.getClass();
        return num.intValue();
    }

    public final boolean zzb(int i) {
        if (this.zzd == null) {
            return i <= this.zzc;
        }
        int zzh = zzfx.zzh(i);
        if (zzh == 0) {
            return false;
        }
        return this.zzd.contains(Integer.valueOf(zzh));
    }
}
