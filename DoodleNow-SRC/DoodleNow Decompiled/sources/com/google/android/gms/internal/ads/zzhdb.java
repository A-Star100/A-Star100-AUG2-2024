package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhdb implements Iterator {
    final Iterator zza;
    final /* synthetic */ zzhdc zzb;

    zzhdb(zzhdc zzhdc) {
        this.zzb = zzhdc;
        this.zza = zzhdc.zza.iterator();
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.zza.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
