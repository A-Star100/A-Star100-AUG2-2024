package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzhcy {
    private static final zzhcy zza = new zzhcy(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzhcy() {
        this(0, new int[8], new Object[8], true);
    }

    private zzhcy(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public static zzhcy zzc() {
        return zza;
    }

    static zzhcy zze(zzhcy zzhcy, zzhcy zzhcy2) {
        int i = zzhcy.zzb + zzhcy2.zzb;
        int[] copyOf = Arrays.copyOf(zzhcy.zzc, i);
        System.arraycopy(zzhcy2.zzc, 0, copyOf, zzhcy.zzb, zzhcy2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzhcy.zzd, i);
        System.arraycopy(zzhcy2.zzd, 0, copyOf2, zzhcy.zzb, zzhcy2.zzb);
        return new zzhcy(i, copyOf, copyOf2, true);
    }

    static zzhcy zzf() {
        return new zzhcy();
    }

    private final void zzn(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzhcy)) {
            return false;
        }
        zzhcy zzhcy = (zzhcy) obj;
        int i = this.zzb;
        if (i == zzhcy.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzhcy.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzhcy.zzd;
                    int i3 = this.zzb;
                    int i4 = 0;
                    while (i4 < i3) {
                        if (objArr[i4].equals(objArr2[i4])) {
                            i4++;
                        }
                    }
                    return true;
                } else if (iArr[i2] != iArr2[i2]) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = i + 527;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = ((i2 * 31) + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int i;
        int i2;
        int i3;
        int i4 = this.zze;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.zzb; i6++) {
            int i7 = this.zzc[i6];
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i9 != 0) {
                if (i9 == 1) {
                    ((Long) this.zzd[i6]).longValue();
                    i = zzgza.zzD(i8 << 3) + 8;
                } else if (i9 == 2) {
                    int zzD = zzgza.zzD(i8 << 3);
                    int zzd2 = ((zzgyj) this.zzd[i6]).zzd();
                    i = zzD + zzgza.zzD(zzd2) + zzd2;
                } else if (i9 == 3) {
                    int zzD2 = zzgza.zzD(i8 << 3);
                    i3 = zzD2 + zzD2;
                    i2 = ((zzhcy) this.zzd[i6]).zza();
                } else if (i9 == 5) {
                    ((Integer) this.zzd[i6]).intValue();
                    i = zzgza.zzD(i8 << 3) + 4;
                } else {
                    throw new IllegalStateException(zzhak.zza());
                }
                i5 += i;
            } else {
                int i10 = i8 << 3;
                long longValue = ((Long) this.zzd[i6]).longValue();
                i3 = zzgza.zzD(i10);
                i2 = zzgza.zzE(longValue);
            }
            i = i3 + i2;
            i5 += i;
        }
        this.zze = i5;
        return i5;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int zzD = zzgza.zzD(8);
            int zzD2 = zzgza.zzD(16) + zzgza.zzD(this.zzc[i3] >>> 3);
            int zzD3 = zzgza.zzD(24);
            int zzd2 = ((zzgyj) this.zzd[i3]).zzd();
            i2 += zzD + zzD + zzD2 + zzD3 + zzgza.zzD(zzd2) + zzd2;
        }
        this.zze = i2;
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final zzhcy zzd(zzhcy zzhcy) {
        if (zzhcy.equals(zza)) {
            return this;
        }
        zzg();
        int i = this.zzb + zzhcy.zzb;
        zzn(i);
        System.arraycopy(zzhcy.zzc, 0, this.zzc, this.zzb, zzhcy.zzb);
        System.arraycopy(zzhcy.zzd, 0, this.zzd, this.zzb, zzhcy.zzb);
        this.zzb = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zzg() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzhbn.zzb(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i, Object obj) {
        zzg();
        zzn(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzk(int i, zzgyt zzgyt) throws IOException {
        int zzm;
        zzg();
        int i2 = i & 7;
        if (i2 == 0) {
            zzj(i, Long.valueOf(zzgyt.zzp()));
            return true;
        } else if (i2 == 1) {
            zzj(i, Long.valueOf(zzgyt.zzo()));
            return true;
        } else if (i2 == 2) {
            zzj(i, zzgyt.zzw());
            return true;
        } else if (i2 == 3) {
            zzhcy zzhcy = new zzhcy();
            do {
                zzm = zzgyt.zzm();
                if (zzm == 0 || !zzhcy.zzk(zzm, zzgyt)) {
                    zzgyt.zzz(4 | ((i >>> 3) << 3));
                    zzj(i, zzhcy);
                }
                zzm = zzgyt.zzm();
                break;
            } while (!zzhcy.zzk(zzm, zzgyt));
            zzgyt.zzz(4 | ((i >>> 3) << 3));
            zzj(i, zzhcy);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzj(i, Integer.valueOf(zzgyt.zzg()));
                return true;
            }
            throw zzhak.zza();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzl(zzgzb zzgzb) throws IOException {
        for (int i = 0; i < this.zzb; i++) {
            zzgzb.zzw(this.zzc[i] >>> 3, this.zzd[i]);
        }
    }

    public final void zzm(zzgzb zzgzb) throws IOException {
        if (this.zzb != 0) {
            for (int i = 0; i < this.zzb; i++) {
                int i2 = this.zzc[i];
                Object obj = this.zzd[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    zzgzb.zzt(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    zzgzb.zzm(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    zzgzb.zzd(i4, (zzgyj) obj);
                } else if (i3 == 3) {
                    zzgzb.zzF(i4);
                    ((zzhcy) obj).zzm(zzgzb);
                    zzgzb.zzh(i4);
                } else if (i3 == 5) {
                    zzgzb.zzk(i4, ((Integer) obj).intValue());
                } else {
                    throw new RuntimeException(zzhak.zza());
                }
            }
        }
    }
}
