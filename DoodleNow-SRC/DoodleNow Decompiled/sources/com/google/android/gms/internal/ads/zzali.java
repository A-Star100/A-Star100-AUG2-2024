package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzali implements zzadi {
    private final zzadi zzb;
    private final zzalf zzc;
    private final SparseArray zzd = new SparseArray();

    public zzali(zzadi zzadi, zzalf zzalf) {
        this.zzb = zzadi;
        this.zzc = zzalf;
    }

    public final void zzD() {
        this.zzb.zzD();
    }

    public final void zzO(zzaef zzaef) {
        this.zzb.zzO(zzaef);
    }

    public final zzaem zzw(int i, int i2) {
        if (i2 != 3) {
            return this.zzb.zzw(i, i2);
        }
        zzalk zzalk = (zzalk) this.zzd.get(i);
        if (zzalk != null) {
            return zzalk;
        }
        zzalk zzalk2 = new zzalk(this.zzb.zzw(i, 3), this.zzc);
        this.zzd.put(i, zzalk2);
        return zzalk2;
    }
}
