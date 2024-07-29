package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgaa extends AbstractList implements RandomAccess, Serializable {
    final List zza;
    final zzfwf zzb;

    zzgaa(List list, zzfwf zzfwf) {
        list.getClass();
        this.zza = list;
        this.zzb = zzfwf;
    }

    public final Object get(int i) {
        return this.zzb.apply(this.zza.get(i));
    }

    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    public final Iterator iterator() {
        return listIterator();
    }

    public final ListIterator listIterator(int i) {
        return new zzfzz(this, this.zza.listIterator(i));
    }

    public final Object remove(int i) {
        return this.zzb.apply(this.zza.remove(i));
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        this.zza.subList(i, i2).clear();
    }

    public final int size() {
        return this.zza.size();
    }
}
