package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzvq {
    public final int zza;
    public final zzvh zzb;
    private final CopyOnWriteArrayList zzc;

    public zzvq() {
        this(new CopyOnWriteArrayList(), 0, (zzvh) null);
    }

    private zzvq(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzvh zzvh) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzvh;
    }

    public final zzvq zza(int i, zzvh zzvh) {
        return new zzvq(this.zzc, 0, zzvh);
    }

    public final void zzb(Handler handler, zzvr zzvr) {
        this.zzc.add(new zzvp(handler, zzvr));
    }

    public final void zzc(zzvd zzvd) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvp zzvp = (zzvp) it.next();
            zzfx.zzN(zzvp.zza, new zzvk(this, zzvp.zzb, zzvd));
        }
    }

    public final void zzd(zzuy zzuy, zzvd zzvd) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvp zzvp = (zzvp) it.next();
            zzfx.zzN(zzvp.zza, new zzvo(this, zzvp.zzb, zzuy, zzvd));
        }
    }

    public final void zze(zzuy zzuy, zzvd zzvd) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvp zzvp = (zzvp) it.next();
            zzfx.zzN(zzvp.zza, new zzvm(this, zzvp.zzb, zzuy, zzvd));
        }
    }

    public final void zzf(zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvp zzvp = (zzvp) it.next();
            zzfx.zzN(zzvp.zza, new zzvn(this, zzvp.zzb, zzuy, zzvd, iOException, z));
        }
    }

    public final void zzg(zzuy zzuy, zzvd zzvd) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvp zzvp = (zzvp) it.next();
            zzfx.zzN(zzvp.zza, new zzvl(this, zzvp.zzb, zzuy, zzvd));
        }
    }

    public final void zzh(zzvr zzvr) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzvp zzvp = (zzvp) it.next();
            if (zzvp.zzb == zzvr) {
                this.zzc.remove(zzvp);
            }
        }
    }
}
