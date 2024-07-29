package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgbp {
    static int zza(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }

    public static zzgbo zzb(Set set, Set set2) {
        zzfwr.zzc(set, "set1");
        zzfwr.zzc(set2, "set2");
        return new zzgbj(set, set2);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.util.Collection, java.util.Set] */
    public static Set zzc(Set set, zzfws zzfws) {
        if (set instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) set;
            if (sortedSet instanceof zzgbk) {
                zzgbk zzgbk = (zzgbk) sortedSet;
                return new zzgbl((SortedSet) zzgbk.zza, zzfwv.zza(zzgbk.zzb, zzfws));
            }
            sortedSet.getClass();
            return new zzgbl(sortedSet, zzfws);
        } else if (set instanceof zzgbk) {
            zzgbk zzgbk2 = (zzgbk) set;
            return new zzgbk(zzgbk2.zza, zzfwv.zza(zzgbk2.zzb, zzfws));
        } else {
            set.getClass();
            return new zzgbk(set, zzfws);
        }
    }

    static boolean zzd(Set set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    static boolean zzf(Set set, Iterator it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean zze(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzgav) {
            collection = ((zzgav) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zzf(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
