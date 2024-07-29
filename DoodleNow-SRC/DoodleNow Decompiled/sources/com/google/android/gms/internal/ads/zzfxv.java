package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfxv implements Iterator {
    @CheckForNull
    Map.Entry zza;
    final /* synthetic */ Iterator zzb;
    final /* synthetic */ zzfxw zzc;

    zzfxv(zzfxw zzfxw, Iterator it) {
        this.zzb = it;
        this.zzc = zzfxw;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.zzb.next();
        this.zza = entry;
        return entry.getKey();
    }

    public final void remove() {
        zzfwr.zzk(this.zza != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.zza.getValue();
        this.zzb.remove();
        zzfyg zzfyg = this.zzc.zza;
        zzfyg.zzb = zzfyg.zzb - collection.size();
        collection.clear();
        this.zza = null;
    }
}
