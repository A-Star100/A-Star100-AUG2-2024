package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaag {
    private static final Comparator zza = zzaac.zza;
    private static final Comparator zzb = zzaad.zza;
    private final ArrayList zzc = new ArrayList();
    private final zzaaf[] zzd = new zzaaf[5];
    private int zze = -1;
    private int zzf;
    private int zzg;
    private int zzh;

    public zzaag(int i) {
    }

    public final float zza(float f) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f2 = (float) this.zzg;
        int i = 0;
        for (int i2 = 0; i2 < this.zzc.size(); i2++) {
            zzaaf zzaaf = (zzaaf) this.zzc.get(i2);
            i += zzaaf.zzb;
            if (((float) i) >= 0.5f * f2) {
                return zzaaf.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.zzc;
        return ((zzaaf) arrayList.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i, float f) {
        zzaaf zzaaf;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i2 = this.zzh;
        if (i2 > 0) {
            zzaaf[] zzaafArr = this.zzd;
            int i3 = i2 - 1;
            this.zzh = i3;
            zzaaf = zzaafArr[i3];
        } else {
            zzaaf = new zzaaf((zzaae) null);
        }
        int i4 = this.zzf;
        this.zzf = i4 + 1;
        zzaaf.zza = i4;
        zzaaf.zzb = i;
        zzaaf.zzc = f;
        this.zzc.add(zzaaf);
        this.zzg += i;
        while (true) {
            int i5 = this.zzg;
            if (i5 > 2000) {
                int i6 = i5 - 2000;
                zzaaf zzaaf2 = (zzaaf) this.zzc.get(0);
                int i7 = zzaaf2.zzb;
                if (i7 <= i6) {
                    this.zzg -= i7;
                    this.zzc.remove(0);
                    int i8 = this.zzh;
                    if (i8 < 5) {
                        zzaaf[] zzaafArr2 = this.zzd;
                        this.zzh = i8 + 1;
                        zzaafArr2[i8] = zzaaf2;
                    }
                } else {
                    zzaaf2.zzb = i7 - i6;
                    this.zzg -= i6;
                }
            } else {
                return;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
