package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzun implements zzvr, zzsh {
    final /* synthetic */ zzup zza;
    private final Object zzb;
    private zzvq zzc;
    private zzsg zzd;

    public zzun(zzup zzup, Object obj) {
        this.zza = zzup;
        this.zzc = zzup.zze((zzvh) null);
        this.zzd = zzup.zzc((zzvh) null);
        this.zzb = obj;
    }

    private final zzvd zzf(zzvd zzvd, zzvh zzvh) {
        zzup zzup = this.zza;
        Object obj = this.zzb;
        long j = zzvd.zzc;
        zzup.zzx(obj, j, zzvh);
        zzup zzup2 = this.zza;
        Object obj2 = this.zzb;
        long j2 = zzvd.zzd;
        zzup2.zzx(obj2, j2, zzvh);
        return (j == zzvd.zzc && j2 == zzvd.zzd) ? zzvd : new zzvd(1, zzvd.zza, zzvd.zzb, 0, (Object) null, j, j2);
    }

    private final boolean zzg(int i, zzvh zzvh) {
        zzvh zzvh2;
        if (zzvh != null) {
            zzvh2 = this.zza.zzy(this.zzb, zzvh);
            if (zzvh2 == null) {
                return false;
            }
        } else {
            zzvh2 = null;
        }
        this.zza.zzw(this.zzb, 0);
        zzvq zzvq = this.zzc;
        int i2 = zzvq.zza;
        if (!zzfx.zzG(zzvq.zzb, zzvh2)) {
            this.zzc = this.zza.zzf(0, zzvh2);
        }
        zzsg zzsg = this.zzd;
        int i3 = zzsg.zza;
        if (zzfx.zzG(zzsg.zzb, zzvh2)) {
            return true;
        }
        this.zzd = this.zza.zzd(0, zzvh2);
        return true;
    }

    public final void zzae(int i, zzvh zzvh, zzvd zzvd) {
        if (zzg(0, zzvh)) {
            this.zzc.zzc(zzf(zzvd, zzvh));
        }
    }

    public final void zzaf(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        if (zzg(0, zzvh)) {
            this.zzc.zzd(zzuy, zzf(zzvd, zzvh));
        }
    }

    public final void zzag(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        if (zzg(0, zzvh)) {
            this.zzc.zze(zzuy, zzf(zzvd, zzvh));
        }
    }

    public final void zzah(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
        if (zzg(0, zzvh)) {
            this.zzc.zzf(zzuy, zzf(zzvd, zzvh), iOException, z);
        }
    }

    public final void zzai(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        if (zzg(0, zzvh)) {
            this.zzc.zzg(zzuy, zzf(zzvd, zzvh));
        }
    }
}
