package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
class zzfxu implements Iterator {
    final Iterator zza;
    @CheckForNull
    Object zzb = null;
    @CheckForNull
    Collection zzc = null;
    Iterator zzd = zzfzv.INSTANCE;
    final /* synthetic */ zzfyg zze;

    zzfxu(zzfyg zzfyg) {
        this.zze = zzfyg;
        this.zza = zzfyg.zza.entrySet().iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext() || this.zzd.hasNext();
    }

    public final Object next() {
        if (!this.zzd.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            this.zzb = entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.zzc = collection;
            this.zzd = collection.iterator();
        }
        return this.zzd.next();
    }

    public final void remove() {
        this.zzd.remove();
        if (((Collection) Objects.requireNonNull(this.zzc)).isEmpty()) {
            this.zza.remove();
        }
        zzfyg zzfyg = this.zze;
        zzfyg.zzb = zzfyg.zzb - 1;
    }
}
