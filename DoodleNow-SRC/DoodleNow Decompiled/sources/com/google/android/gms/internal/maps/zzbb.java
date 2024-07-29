package com.google.android.gms.internal.maps;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzbb extends zzbf {
    boolean zza;
    final /* synthetic */ Object zzb;

    zzbb(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final Object next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
