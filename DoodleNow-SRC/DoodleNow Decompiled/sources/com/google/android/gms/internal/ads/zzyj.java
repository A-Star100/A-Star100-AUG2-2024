package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzyj extends zzdf {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;
    /* access modifiers changed from: private */
    public boolean zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    /* access modifiers changed from: private */
    public final SparseArray zzh;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzi;

    @Deprecated
    public zzyj() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    private final void zzx() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    public final /* synthetic */ zzdf zzf(int i, int i2, boolean z) {
        super.zzf(i, i2, true);
        return this;
    }

    public final zzyj zzp(int i, boolean z) {
        if (this.zzi.get(i) != z) {
            if (z) {
                this.zzi.put(i, true);
            } else {
                this.zzi.delete(i);
            }
        }
        return this;
    }

    public zzyj(Context context) {
        super.zze(context);
        Point zzv = zzfx.zzv(context);
        zzf(zzv.x, zzv.y, true);
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    /* synthetic */ zzyj(zzyl zzyl, zzyi zzyi) {
        super(zzyl);
        this.zza = zzyl.zzI;
        this.zzb = zzyl.zzK;
        this.zzc = zzyl.zzM;
        this.zzd = zzyl.zzR;
        this.zze = zzyl.zzS;
        this.zzf = zzyl.zzT;
        this.zzg = zzyl.zzV;
        SparseArray zza2 = zzyl.zzaq;
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < zza2.size(); i++) {
            sparseArray.put(zza2.keyAt(i), new HashMap((Map) zza2.valueAt(i)));
        }
        this.zzh = sparseArray;
        this.zzi = zzyl.zzar.clone();
    }
}
