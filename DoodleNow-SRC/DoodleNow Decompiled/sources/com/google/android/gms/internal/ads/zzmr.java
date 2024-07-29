package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzmr {
    private final zzah zza;
    private final SparseArray zzb;

    public zzmr(zzah zzah, SparseArray sparseArray) {
        this.zza = zzah;
        SparseArray sparseArray2 = new SparseArray(zzah.zzb());
        for (int i = 0; i < zzah.zzb(); i++) {
            int zza2 = zzah.zza(i);
            zzmq zzmq = (zzmq) sparseArray.get(zza2);
            zzmq.getClass();
            sparseArray2.append(zza2, zzmq);
        }
        this.zzb = sparseArray2;
    }

    public final int zza(int i) {
        return this.zza.zza(i);
    }

    public final int zzb() {
        return this.zza.zzb();
    }

    public final zzmq zzc(int i) {
        zzmq zzmq = (zzmq) this.zzb.get(i);
        zzmq.getClass();
        return zzmq;
    }

    public final boolean zzd(int i) {
        return this.zza.zzc(i);
    }
}
