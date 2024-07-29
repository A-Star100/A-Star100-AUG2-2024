package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhci {
    public static final /* synthetic */ int zza = 0;
    private static final Class zzb;
    private static final zzhcx zzc;
    private static final zzhcx zzd = new zzhcz();

    static {
        Class<?> cls;
        Class<?> cls2;
        zzhcx zzhcx = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zzb = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                zzhcx = (zzhcx) cls2.getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused3) {
            }
        }
        zzc = zzhcx;
    }

    public static void zzA(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzp(i, list, z);
        }
    }

    public static void zzB(int i, List list, zzgzb zzgzb, zzhcg zzhcg) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgzb.zzq(i, list.get(i2), zzhcg);
            }
        }
    }

    public static void zzC(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzs(i, list, z);
        }
    }

    public static void zzD(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzu(i, list, z);
        }
    }

    public static void zzE(int i, List list, zzgzb zzgzb, zzhcg zzhcg) throws IOException {
        if (list != null && !list.isEmpty()) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                zzgzb.zzv(i, list.get(i2), zzhcg);
            }
        }
    }

    public static void zzF(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzy(i, list, z);
        }
    }

    public static void zzG(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzA(i, list, z);
        }
    }

    public static void zzH(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzC(i, list, z);
        }
    }

    public static void zzI(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzE(i, list, z);
        }
    }

    public static void zzJ(int i, List list, zzgzb zzgzb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzH(i, list);
        }
    }

    public static void zzK(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzJ(i, list, z);
        }
    }

    public static void zzL(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzL(i, list, z);
        }
    }

    static int zza(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzE((long) zzgzw.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgza.zzE((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgza.zzD(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzgza.zzD(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzE((long) zzgzw.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgza.zzE((long) ((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzE(zzhba.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgza.zzE(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzh(int i, Object obj, zzhcg zzhcg) {
        int i2 = i << 3;
        if (!(obj instanceof zzhar)) {
            return zzgza.zzD(i2) + zzgza.zzA((zzhbl) obj, zzhcg);
        }
        int zzD = zzgza.zzD(i2);
        int zza2 = ((zzhar) obj).zza();
        return zzD + zzgza.zzD(zza2) + zza2;
    }

    static int zzi(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            i = 0;
            while (i2 < size) {
                int zzd2 = zzgzw.zzd(i2);
                i += zzgza.zzD((zzd2 >> 31) ^ (zzd2 + zzd2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                int intValue = ((Integer) list.get(i2)).intValue();
                i3 = i + zzgza.zzD((intValue >> 31) ^ (intValue + intValue));
                i2++;
            }
        }
        return i;
    }

    static int zzj(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            i = 0;
            while (i2 < size) {
                long zza2 = zzhba.zza(i2);
                i += zzgza.zzE((zza2 >> 63) ^ (zza2 + zza2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                long longValue = ((Long) list.get(i2)).longValue();
                i3 = i + zzgza.zzE((longValue >> 63) ^ (longValue + longValue));
                i2++;
            }
        }
        return i;
    }

    static int zzk(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgzw) {
            zzgzw zzgzw = (zzgzw) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzD(zzgzw.zzd(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgza.zzD(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzl(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhba) {
            zzhba zzhba = (zzhba) list;
            i = 0;
            while (i2 < size) {
                i += zzgza.zzE(zzhba.zza(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzgza.zzE(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static zzhcx zzm() {
        return zzc;
    }

    public static zzhcx zzn() {
        return zzd;
    }

    static Object zzo(Object obj, int i, List list, zzhab zzhab, Object obj2, zzhcx zzhcx) {
        if (zzhab == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ((Integer) list.get(i3)).intValue();
                if (zzhab.zza(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    obj2 = zzp(obj, i, intValue, obj2, zzhcx);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzhab.zza(intValue2)) {
                    obj2 = zzp(obj, i, intValue2, obj2, zzhcx);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzp(Object obj, int i, int i2, Object obj2, zzhcx zzhcx) {
        if (obj2 == null) {
            obj2 = zzhcx.zzc(obj);
        }
        zzhcx.zzl(obj2, i, (long) i2);
        return obj2;
    }

    static void zzq(zzgzg zzgzg, Object obj, Object obj2) {
        zzgzk zzb2 = zzgzg.zzb(obj2);
        if (!zzb2.zza.isEmpty()) {
            zzgzg.zzc(obj).zzj(zzb2);
        }
    }

    static void zzr(zzhcx zzhcx, Object obj, Object obj2) {
        zzhcx.zzo(obj, zzhcx.zze(zzhcx.zzd(obj), zzhcx.zzd(obj2)));
    }

    public static void zzs(Class cls) {
        Class cls2;
        if (!zzgzv.class.isAssignableFrom(cls) && (cls2 = zzb) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    static boolean zzt(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null) {
            return obj.equals(obj2);
        }
        return false;
    }

    public static void zzu(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzc(i, list, z);
        }
    }

    public static void zzv(int i, List list, zzgzb zzgzb) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zze(i, list);
        }
    }

    public static void zzw(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzg(i, list, z);
        }
    }

    public static void zzx(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzj(i, list, z);
        }
    }

    public static void zzy(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzl(i, list, z);
        }
    }

    public static void zzz(int i, List list, zzgzb zzgzb, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgzb.zzn(i, list, z);
        }
    }
}
