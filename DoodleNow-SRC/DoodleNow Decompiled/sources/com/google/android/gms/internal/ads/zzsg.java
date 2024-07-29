package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzsg {
    public final int zza;
    public final zzvh zzb;
    private final CopyOnWriteArrayList zzc;

    public zzsg() {
        this(new CopyOnWriteArrayList(), 0, (zzvh) null);
    }

    private zzsg(CopyOnWriteArrayList copyOnWriteArrayList, int i, zzvh zzvh) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zzvh;
    }

    public final zzsg zza(int i, zzvh zzvh) {
        return new zzsg(this.zzc, 0, zzvh);
    }

    public final void zzb(Handler handler, zzsh zzsh) {
        this.zzc.add(new zzsf(handler, zzsh));
    }

    public final void zzc(zzsh zzsh) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzsf zzsf = (zzsf) it.next();
            if (zzsf.zzb == zzsh) {
                this.zzc.remove(zzsf);
            }
        }
    }
}
