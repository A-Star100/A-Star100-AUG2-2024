package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
class zzfyc implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzfyd zzc;

    zzfyc(zzfyd zzfyd) {
        Iterator it;
        this.zzc = zzfyd;
        this.zzb = zzfyd.zzb;
        Collection collection = zzfyd.zzb;
        if (collection instanceof List) {
            it = ((List) collection).listIterator();
        } else {
            it = collection.iterator();
        }
        this.zza = it;
    }

    zzfyc(zzfyd zzfyd, Iterator it) {
        this.zzc = zzfyd;
        this.zzb = zzfyd.zzb;
        this.zza = it;
    }

    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    public final Object next() {
        zza();
        return this.zza.next();
    }

    public final void remove() {
        this.zza.remove();
        zzfyg zzfyg = this.zzc.zze;
        zzfyg.zzb = zzfyg.zzb - 1;
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzb();
        if (this.zzc.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }
}
