package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzyr extends zzyt implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final boolean zzm;

    public zzyr(int i, zzcz zzcz, int i2, zzyl zzyl, int i3, String str) {
        super(i, zzcz, i2);
        zzfzn zzfzn;
        int i4;
        int i5 = 0;
        this.zzf = zzyx.zzo(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzyl.zzy;
        this.zzg = 1 == (i6 & 1);
        this.zzh = (i6 & 2) != 0;
        if (zzyl.zzw.isEmpty()) {
            zzfzn = zzfzn.zzn("");
        } else {
            zzfzn = zzyl.zzw;
        }
        int i8 = 0;
        while (true) {
            if (i8 >= zzfzn.size()) {
                i8 = Integer.MAX_VALUE;
                i4 = 0;
                break;
            }
            boolean z = zzyl.zzz;
            i4 = zzyx.zzc(this.zzd, (String) zzfzn.get(i8), false);
            if (i4 > 0) {
                break;
            }
            i8++;
        }
        this.zzi = i8;
        this.zzj = i4;
        int zzb = zzyx.zzb(this.zzd.zzf, zzyl.zzx);
        this.zzk = zzb;
        this.zzm = (this.zzd.zzf & 1088) != 0;
        int zzc = zzyx.zzc(this.zzd, str, zzyx.zzh(str) == null);
        this.zzl = zzc;
        boolean z2 = i4 > 0 || (zzyl.zzw.isEmpty() && zzb > 0) || this.zzg || (this.zzh && zzc > 0);
        if (zzyx.zzo(i3, zzyl.zzT) && z2) {
            i5 = 1;
        }
        this.zze = i5;
    }

    /* renamed from: zza */
    public final int compareTo(zzyr zzyr) {
        zzgay zzgay;
        zzfzc zze2 = zzfzc.zzk().zze(this.zzf, zzyr.zzf).zzd(Integer.valueOf(this.zzi), Integer.valueOf(zzyr.zzi), zzgay.zzc().zza()).zzb(this.zzj, zzyr.zzj).zzb(this.zzk, zzyr.zzk).zze(this.zzg, zzyr.zzg);
        Boolean valueOf = Boolean.valueOf(this.zzh);
        Boolean valueOf2 = Boolean.valueOf(zzyr.zzh);
        if (this.zzj == 0) {
            zzgay = zzgay.zzc();
        } else {
            zzgay = zzgay.zzc().zza();
        }
        zzfzc zzb = zze2.zzd(valueOf, valueOf2, zzgay).zzb(this.zzl, zzyr.zzl);
        if (this.zzk == 0) {
            zzb = zzb.zzf(this.zzm, zzyr.zzm);
        }
        return zzb.zza();
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzyt zzyt) {
        zzyr zzyr = (zzyr) zzyt;
        return false;
    }
}
