package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzlt implements zzvr, zzsh {
    final /* synthetic */ zzlx zza;
    private final zzlv zzb;

    public zzlt(zzlx zzlx, zzlv zzlv) {
        this.zza = zzlx;
        this.zzb = zzlv;
    }

    private final Pair zzf(int i, zzvh zzvh) {
        zzvh zzvh2;
        zzvh zzvh3 = null;
        if (zzvh != null) {
            zzlv zzlv = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzlv.zzc.size()) {
                    zzvh2 = null;
                    break;
                } else if (((zzvh) zzlv.zzc.get(i2)).zzd == zzvh.zzd) {
                    zzvh2 = zzvh.zza(Pair.create(zzlv.zzb, zzvh.zza));
                    break;
                } else {
                    i2++;
                }
            }
            if (zzvh2 == null) {
                return null;
            }
            zzvh3 = zzvh2;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzvh3);
    }

    public final void zzae(int i, zzvh zzvh, zzvd zzvd) {
        Pair zzf = zzf(0, zzvh);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzlr(this, zzf, zzvd));
        }
    }

    public final void zzaf(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        Pair zzf = zzf(0, zzvh);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzlp(this, zzf, zzuy, zzvd));
        }
    }

    public final void zzag(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        Pair zzf = zzf(0, zzvh);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzls(this, zzf, zzuy, zzvd));
        }
    }

    public final void zzah(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
        Pair zzf = zzf(0, zzvh);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzlo(this, zzf, zzuy, zzvd, iOException, z));
        }
    }

    public final void zzai(int i, zzvh zzvh, zzuy zzuy, zzvd zzvd) {
        Pair zzf = zzf(0, zzvh);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzlq(this, zzf, zzuy, zzvd));
        }
    }
}
