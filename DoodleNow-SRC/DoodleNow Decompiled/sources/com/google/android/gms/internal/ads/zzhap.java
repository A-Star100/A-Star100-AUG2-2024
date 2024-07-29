package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhap implements Iterator {
    private final Iterator zza;

    public zzhap(Iterator it) {
        this.zza = it;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        return entry.getValue() instanceof zzhaq ? new zzhao(entry, (zzhan) null) : entry;
    }

    public final void remove() {
        this.zza.remove();
    }
}
