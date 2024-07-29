package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzhil implements Iterator {
    int zza = 0;
    final /* synthetic */ zzhim zzb;

    zzhil(zzhim zzhim) {
        this.zzb = zzhim;
    }

    public final boolean hasNext() {
        return this.zza < this.zzb.zza.size() || this.zzb.zzb.hasNext();
    }

    public final Object next() {
        if (this.zza < this.zzb.zza.size()) {
            zzhim zzhim = this.zzb;
            int i = this.zza;
            this.zza = i + 1;
            return zzhim.zza.get(i);
        }
        zzhim zzhim2 = this.zzb;
        zzhim2.zza.add(zzhim2.zzb.next());
        return next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
