package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfzt {
    public static Object zza(Iterable iterable, Object obj) {
        zzgbi zzgbi = new zzgbi((zzgbj) iterable);
        return zzgbi.hasNext() ? zzgbi.next() : obj;
    }

    public static boolean zzb(Iterable iterable, zzfws zzfws) {
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            Iterator it = iterable.iterator();
            zzfws.getClass();
            boolean z = false;
            while (it.hasNext()) {
                if (zzfws.zza(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        zzfws.getClass();
        return zzd((List) iterable, zzfws);
    }

    private static void zzc(List list, zzfws zzfws, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzfws.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 >= i) {
                list.remove(i2);
            } else {
                return;
            }
        }
    }

    private static boolean zzd(List list, zzfws zzfws) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzfws.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (UnsupportedOperationException unused) {
                        zzc(list, zzfws, i2, i);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        zzc(list, zzfws, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }
}
