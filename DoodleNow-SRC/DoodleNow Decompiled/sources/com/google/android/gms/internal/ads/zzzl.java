package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzzl {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzzm zzzm) {
        zzc(zzzm);
        this.zza.add(new zzzk(handler, zzzm));
    }

    public final void zzb(int i, long j, long j2) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzzk zzzk = (zzzk) it.next();
            if (!zzzk.zzc) {
                zzzk.zza.post(new zzzj(zzzk, i, j, j2));
            }
        }
    }

    public final void zzc(zzzm zzzm) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzzk zzzk = (zzzk) it.next();
            if (zzzk.zzb == zzzm) {
                zzzk.zzc();
                this.zza.remove(zzzk);
            }
        }
    }
}
