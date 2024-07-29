package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzzc extends zzzf {
    private zzzb zza;

    /* access modifiers changed from: protected */
    public abstract Pair zzd(zzzb zzzb, int[][][] iArr, int[] iArr2, zzvh zzvh, zzcx zzcx) throws zziz;

    public final zzzg zzp(zzmh[] zzmhArr, zzxk zzxk, zzvh zzvh, zzcx zzcx) throws zziz {
        boolean z;
        int[] iArr;
        zzxk zzxk2 = zzxk;
        int[] iArr2 = new int[3];
        zzcz[][] zzczArr = new zzcz[3][];
        int[][][] iArr3 = new int[3][][];
        for (int i = 0; i < 3; i++) {
            int i2 = zzxk2.zzc;
            zzczArr[i] = new zzcz[i2];
            iArr3[i] = new int[i2][];
        }
        int i3 = 2;
        int[] iArr4 = new int[2];
        for (int i4 = 0; i4 < 2; i4++) {
            iArr4[i4] = zzmhArr[i4].zze();
        }
        int i5 = 0;
        while (i5 < zzxk2.zzc) {
            zzcz zzb = zzxk2.zzb(i5);
            int i6 = zzb.zzd;
            int i7 = i3;
            int i8 = 0;
            int i9 = 0;
            boolean z2 = true;
            while (i8 < i3) {
                zzmh zzmh = zzmhArr[i8];
                int i10 = 0;
                for (int i11 = 0; i11 < zzb.zzb; i11++) {
                    i10 = Math.max(i10, zzmh.zzY(zzb.zzb(i11)) & 7);
                }
                boolean z3 = iArr2[i8] == 0;
                if (i10 > i9) {
                    z2 = z3;
                    i7 = i8;
                    i9 = i10;
                } else if (i10 == i9 && i6 == 5 && !z2 && z3) {
                    i7 = i8;
                    i9 = i10;
                    z2 = true;
                }
                i8++;
                i3 = 2;
            }
            if (i7 == i3) {
                iArr = new int[zzb.zzb];
            } else {
                zzmh zzmh2 = zzmhArr[i7];
                int[] iArr5 = new int[zzb.zzb];
                for (int i12 = 0; i12 < zzb.zzb; i12++) {
                    iArr5[i12] = zzmh2.zzY(zzb.zzb(i12));
                }
                iArr = iArr5;
            }
            int i13 = iArr2[i7];
            zzczArr[i7][i13] = zzb;
            iArr3[i7][i13] = iArr;
            iArr2[i7] = i13 + 1;
            i5++;
            i3 = 2;
        }
        int i14 = i3;
        boolean z4 = true;
        zzxk[] zzxkArr = new zzxk[i14];
        String[] strArr = new String[i14];
        int[] iArr6 = new int[i14];
        int i15 = 0;
        while (i15 < i14) {
            int i16 = iArr2[i15];
            zzxkArr[i15] = new zzxk((zzcz[]) zzfx.zzO(zzczArr[i15], i16));
            iArr3[i15] = (int[][]) zzfx.zzO(iArr3[i15], i16);
            strArr[i15] = zzmhArr[i15].zzU();
            iArr6[i15] = zzmhArr[i15].zzb();
            i15++;
            i14 = 2;
        }
        int i17 = i14;
        zzzb zzzb = new zzzb(strArr, iArr6, zzxkArr, iArr4, iArr3, new zzxk((zzcz[]) zzfx.zzO(zzczArr[i17], iArr2[i17])));
        Pair zzd = zzd(zzzb, iArr3, iArr4, zzvh, zzcx);
        zzzd[] zzzdArr = (zzzd[]) zzd.second;
        List[] listArr = new List[zzzdArr.length];
        for (int i18 = 0; i18 < zzzdArr.length; i18++) {
            zzzd zzzd = zzzdArr[i18];
            listArr[i18] = zzzd != null ? zzfzn.zzn(zzzd) : zzfzn.zzm();
        }
        zzfzk zzfzk = new zzfzk();
        int i19 = 0;
        while (i19 < 2) {
            zzxk zzd2 = zzzb.zzd(i19);
            List list = listArr[i19];
            int i20 = 0;
            while (i20 < zzd2.zzc) {
                zzcz zzb2 = zzd2.zzb(i20);
                boolean z5 = zzzb.zza(i19, i20, false) != 0 ? z4 : false;
                int i21 = zzb2.zzb;
                int[] iArr7 = new int[i21];
                boolean[] zArr = new boolean[i21];
                for (int i22 = 0; i22 < zzb2.zzb; i22++) {
                    iArr7[i22] = zzzb.zzb(i19, i20, i22) & 7;
                    int i23 = 0;
                    while (true) {
                        if (i23 >= list.size()) {
                            z = false;
                            break;
                        }
                        zzzd zzzd2 = (zzzd) list.get(i23);
                        if (zzzd2.zze().equals(zzb2) && zzzd2.zzb(i22) != -1) {
                            z = true;
                            break;
                        }
                        i23++;
                    }
                    zArr[i22] = z;
                }
                zzfzk.zzf(new zzdj(zzb2, z5, iArr7, zArr));
                i20++;
                z4 = true;
            }
            i19++;
            z4 = true;
        }
        zzxk zze = zzzb.zze();
        for (int i24 = 0; i24 < zze.zzc; i24++) {
            zzcz zzb3 = zze.zzb(i24);
            int[] iArr8 = new int[zzb3.zzb];
            Arrays.fill(iArr8, 0);
            zzfzk.zzf(new zzdj(zzb3, false, iArr8, new boolean[zzb3.zzb]));
        }
        return new zzzg((zzmi[]) zzd.first, (zzyz[]) zzd.second, new zzdk(zzfzk.zzi()), zzzb);
    }

    public final void zzq(Object obj) {
        this.zza = (zzzb) obj;
    }
}
