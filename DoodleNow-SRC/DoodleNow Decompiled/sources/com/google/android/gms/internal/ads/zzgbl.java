package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgbl extends zzgbk implements SortedSet {
    zzgbl(SortedSet sortedSet, zzfws zzfws) {
        super(sortedSet, zzfws);
    }

    @CheckForNull
    public final Comparator comparator() {
        return ((SortedSet) this.zza).comparator();
    }

    public final Object first() {
        Iterator it = this.zza.iterator();
        it.getClass();
        zzfws zzfws = this.zzb;
        zzfws.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            if (zzfws.zza(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    public final SortedSet headSet(Object obj) {
        return new zzgbl(((SortedSet) this.zza).headSet(obj), this.zzb);
    }

    public final Object last() {
        SortedSet sortedSet = (SortedSet) this.zza;
        while (true) {
            zzfws zzfws = this.zzb;
            Object last = sortedSet.last();
            if (zzfws.zza(last)) {
                return last;
            }
            sortedSet = sortedSet.headSet(last);
        }
    }

    public final SortedSet subSet(Object obj, Object obj2) {
        return new zzgbl(((SortedSet) this.zza).subSet(obj, obj2), this.zzb);
    }

    public final SortedSet tailSet(Object obj) {
        return new zzgbl(((SortedSet) this.zza).tailSet(obj), this.zzb);
    }
}
