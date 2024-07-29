package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfzw extends zzgbt {
    private static final Object zza = new Object();
    private Object zzb;

    zzfzw(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return this.zzb != zza;
    }

    public final Object next() {
        Object obj = this.zzb;
        Object obj2 = zza;
        if (obj != obj2) {
            this.zzb = obj2;
            return obj;
        }
        throw new NoSuchElementException();
    }
}
