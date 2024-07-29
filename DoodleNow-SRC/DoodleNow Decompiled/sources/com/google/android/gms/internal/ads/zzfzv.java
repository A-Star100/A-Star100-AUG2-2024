package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
enum zzfzv implements Iterator {
    INSTANCE;

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        throw new NoSuchElementException();
    }

    public final void remove() {
        zzfwr.zzk(false, "no calls to next() since the last call to remove()");
    }
}
