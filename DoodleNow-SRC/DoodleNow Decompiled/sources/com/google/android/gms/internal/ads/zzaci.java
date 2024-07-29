package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaci {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;
    public final String zzk;

    private zzaci(List list, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, String str) {
        this.zza = list;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = i8;
        this.zzj = f;
        this.zzk = str;
    }

    public static zzaci zza(zzfo zzfo) throws zzcc {
        String str;
        float f;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        try {
            zzfo.zzL(4);
            int zzm = zzfo.zzm() & 3;
            int i8 = zzm + 1;
            if (i8 != 3) {
                ArrayList arrayList = new ArrayList();
                int zzm2 = zzfo.zzm() & 31;
                for (int i9 = 0; i9 < zzm2; i9++) {
                    arrayList.add(zzb(zzfo));
                }
                int zzm3 = zzfo.zzm();
                for (int i10 = 0; i10 < zzm3; i10++) {
                    arrayList.add(zzb(zzfo));
                }
                if (zzm2 > 0) {
                    zzgk zze2 = zzgl.zze((byte[]) arrayList.get(0), zzm + 2, ((byte[]) arrayList.get(0)).length);
                    int i11 = zze2.zze;
                    int i12 = zze2.zzf;
                    int i13 = zze2.zzj;
                    int i14 = zze2.zzk;
                    int i15 = zze2.zzl;
                    float f2 = zze2.zzg;
                    str = zzem.zza(zze2.zza, zze2.zzb, zze2.zzc);
                    i2 = i14;
                    i = i15;
                    f = f2;
                    i5 = zze2.zzh + 8;
                    i4 = zze2.zzi + 8;
                    i3 = i13;
                    i7 = i11;
                    i6 = i12;
                } else {
                    i7 = -1;
                    i6 = -1;
                    i5 = -1;
                    i4 = -1;
                    i3 = -1;
                    i2 = -1;
                    i = -1;
                    str = null;
                    f = 1.0f;
                }
                return new zzaci(arrayList, i8, i7, i6, i5, i4, i3, i2, i, f, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw zzcc.zza("Error parsing AVC config", e);
        }
    }

    private static byte[] zzb(zzfo zzfo) {
        int zzq = zzfo.zzq();
        int zzd2 = zzfo.zzd();
        zzfo.zzL(zzq);
        return zzem.zzc(zzfo.zzM(), zzd2, zzq);
    }
}
