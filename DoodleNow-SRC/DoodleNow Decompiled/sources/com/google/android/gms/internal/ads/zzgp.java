package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzgp implements zzgv {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzhb zzd;

    protected zzgp(boolean z) {
        this.zza = z;
    }

    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    /* access modifiers changed from: protected */
    public final void zzg(int i) {
        zzhb zzhb = this.zzd;
        int i2 = zzfx.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzhy) this.zzb.get(i3)).zza(this, zzhb, this.zza, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzh() {
        zzhb zzhb = this.zzd;
        int i = zzfx.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzhy) this.zzb.get(i2)).zzb(this, zzhb, this.zza);
        }
        this.zzd = null;
    }

    /* access modifiers changed from: protected */
    public final void zzi(zzhb zzhb) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzhy) this.zzb.get(i)).zzc(this, zzhb, this.zza);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzj(zzhb zzhb) {
        this.zzd = zzhb;
        for (int i = 0; i < this.zzc; i++) {
            ((zzhy) this.zzb.get(i)).zzd(this, zzhb, this.zza);
        }
    }

    public final void zzf(zzhy zzhy) {
        zzhy.getClass();
        if (!this.zzb.contains(zzhy)) {
            this.zzb.add(zzhy);
            this.zzc++;
        }
    }
}
