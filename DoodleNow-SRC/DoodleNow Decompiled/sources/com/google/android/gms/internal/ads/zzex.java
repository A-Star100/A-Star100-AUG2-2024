package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzex implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzey zzc;

    public /* synthetic */ zzex(CopyOnWriteArraySet copyOnWriteArraySet, int i, zzey zzey) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i;
        this.zzc = zzey;
    }

    public final void run() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzey zzey = this.zzc;
            ((zzfa) it.next()).zza(this.zzb, zzey);
        }
    }
}
