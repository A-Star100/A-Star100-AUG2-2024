package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzvy extends zzup {
    private static final zzbp zza;
    private final zzvj[] zzb;
    private final zzcx[] zzc;
    private final ArrayList zzd;
    private final Map zze;
    private final zzgal zzf;
    private int zzg = -1;
    private long[][] zzh;
    private zzvx zzi;
    private final zzus zzj;

    static {
        zzar zzar = new zzar();
        zzar.zza("MergingMediaSource");
        zza = zzar.zzc();
    }

    public zzvy(boolean z, boolean z2, zzvj... zzvjArr) {
        zzus zzus = new zzus();
        this.zzb = zzvjArr;
        this.zzj = zzus;
        this.zzd = new ArrayList(Arrays.asList(zzvjArr));
        this.zzc = new zzcx[zzvjArr.length];
        this.zzh = new long[0][];
        this.zze = new HashMap();
        this.zzf = zzgat.zzb(8).zzb(2).zza();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void zzA(Object obj, zzvj zzvj, zzcx zzcx) {
        int i;
        if (this.zzi == null) {
            if (this.zzg == -1) {
                i = zzcx.zzb();
                this.zzg = i;
            } else {
                int zzb2 = zzcx.zzb();
                int i2 = this.zzg;
                if (zzb2 != i2) {
                    this.zzi = new zzvx(0);
                    return;
                }
                i = i2;
            }
            if (this.zzh.length == 0) {
                this.zzh = (long[][]) Array.newInstance(Long.TYPE, new int[]{i, this.zzc.length});
            }
            this.zzd.remove(zzvj);
            this.zzc[((Integer) obj).intValue()] = zzcx;
            if (this.zzd.isEmpty()) {
                zzo(this.zzc[0]);
            }
        }
    }

    public final void zzG(zzvf zzvf) {
        zzvw zzvw = (zzvw) zzvf;
        int i = 0;
        while (true) {
            zzvj[] zzvjArr = this.zzb;
            if (i < zzvjArr.length) {
                zzvjArr[i].zzG(zzvw.zzn(i));
                i++;
            } else {
                return;
            }
        }
    }

    public final zzvf zzI(zzvh zzvh, zzzo zzzo, long j) {
        zzcx[] zzcxArr = this.zzc;
        int length = this.zzb.length;
        zzvf[] zzvfArr = new zzvf[length];
        int zza2 = zzcxArr[0].zza(zzvh.zza);
        for (int i = 0; i < length; i++) {
            zzvfArr[i] = this.zzb[i].zzI(zzvh.zza(this.zzc[i].zzf(zza2)), zzzo, j - this.zzh[zza2][i]);
        }
        return new zzvw(this.zzj, this.zzh[zza2], zzvfArr);
    }

    public final zzbp zzJ() {
        zzvj[] zzvjArr = this.zzb;
        return zzvjArr.length > 0 ? zzvjArr[0].zzJ() : zza;
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzhy zzhy) {
        super.zzn(zzhy);
        int i = 0;
        while (true) {
            zzvj[] zzvjArr = this.zzb;
            if (i < zzvjArr.length) {
                zzB(Integer.valueOf(i), zzvjArr[i]);
                i++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        super.zzq();
        Arrays.fill(this.zzc, (Object) null);
        this.zzg = -1;
        this.zzi = null;
        this.zzd.clear();
        Collections.addAll(this.zzd, this.zzb);
    }

    public final void zzt(zzbp zzbp) {
        this.zzb[0].zzt(zzbp);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ zzvh zzy(Object obj, zzvh zzvh) {
        if (((Integer) obj).intValue() == 0) {
            return zzvh;
        }
        return null;
    }

    public final void zzz() throws IOException {
        zzvx zzvx = this.zzi;
        if (zzvx == null) {
            super.zzz();
            return;
        }
        throw zzvx;
    }
}
