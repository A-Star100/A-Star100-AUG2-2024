package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgzk {
    private static final zzgzk zzb = new zzgzk(true);
    final zzhct zza = new zzhcj(16);
    private boolean zzc;
    private boolean zzd;

    private zzgzk() {
    }

    static int zza(zzhdn zzhdn, int i, Object obj) {
        int zzD = zzgza.zzD(i << 3);
        if (zzhdn == zzhdn.GROUP) {
            zzhbl zzhbl = (zzhbl) obj;
            byte[] bArr = zzhai.zzd;
            if (!(zzhbl instanceof zzgxr)) {
                zzD += zzD;
            } else {
                zzgxr zzgxr = (zzgxr) zzhbl;
                throw null;
            }
        }
        return zzD + zzb(zzhdn, obj);
    }

    static int zzb(zzhdn zzhdn, Object obj) {
        int zzd2;
        int zzD;
        zzhdn zzhdn2 = zzhdn.DOUBLE;
        zzhdo zzhdo = zzhdo.INT;
        switch (zzhdn.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzgza.zzf;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzgza.zzf;
                return 4;
            case 2:
                return zzgza.zzE(((Long) obj).longValue());
            case 3:
                return zzgza.zzE(((Long) obj).longValue());
            case 4:
                return zzgza.zzE((long) ((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzgza.zzf;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzgza.zzf;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzgza.zzf;
                return 1;
            case 8:
                if (obj instanceof zzgyj) {
                    int i6 = zzgza.zzf;
                    zzd2 = ((zzgyj) obj).zzd();
                    zzD = zzgza.zzD(zzd2);
                    break;
                } else {
                    return zzgza.zzC((String) obj);
                }
            case 9:
                int i7 = zzgza.zzf;
                return ((zzhbl) obj).zzaY();
            case 10:
                if (obj instanceof zzhaq) {
                    int i8 = zzgza.zzf;
                    zzd2 = ((zzhaq) obj).zza();
                    zzD = zzgza.zzD(zzd2);
                    break;
                } else {
                    return zzgza.zzz((zzhbl) obj);
                }
            case 11:
                if (!(obj instanceof zzgyj)) {
                    int i9 = zzgza.zzf;
                    zzd2 = ((byte[]) obj).length;
                    zzD = zzgza.zzD(zzd2);
                    break;
                } else {
                    int i10 = zzgza.zzf;
                    zzd2 = ((zzgyj) obj).zzd();
                    zzD = zzgza.zzD(zzd2);
                    break;
                }
            case 12:
                return zzgza.zzD(((Integer) obj).intValue());
            case 13:
                if (obj instanceof zzgzz) {
                    return zzgza.zzE((long) ((zzgzz) obj).zza());
                }
                return zzgza.zzE((long) ((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i11 = zzgza.zzf;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i12 = zzgza.zzf;
                return 8;
            case 16:
                int intValue = ((Integer) obj).intValue();
                return zzgza.zzD((intValue >> 31) ^ (intValue + intValue));
            case 17:
                long longValue = ((Long) obj).longValue();
                return zzgza.zzE((longValue >> 63) ^ (longValue + longValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return zzD + zzd2;
    }

    public static int zzc(zzgzj zzgzj, Object obj) {
        zzhdn zzd2 = zzgzj.zzd();
        int zza2 = zzgzj.zza();
        if (!zzgzj.zzg()) {
            return zza(zzd2, zza2, obj);
        }
        List<Object> list = (List) obj;
        int i = 0;
        if (!zzgzj.zzf()) {
            for (Object zza3 : list) {
                i += zza(zzd2, zza2, zza3);
            }
            return i;
        } else if (list.isEmpty()) {
            return 0;
        } else {
            for (Object zzb2 : list) {
                i += zzb(zzd2, zzb2);
            }
            return zzgza.zzD(zza2 << 3) + i + zzgza.zzD(i);
        }
    }

    public static zzgzk zze() {
        return zzb;
    }

    private static Object zzm(Object obj) {
        if (obj instanceof zzhbq) {
            return ((zzhbq) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzn(Map.Entry entry) {
        Object obj;
        zzgzj zzgzj = (zzgzj) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzhaq;
        if (zzgzj.zzg()) {
            if (!z) {
                Object zzf = zzf(zzgzj);
                if (zzf == null) {
                    zzf = new ArrayList();
                }
                for (Object zzm : (List) value) {
                    ((List) zzf).add(zzm(zzm));
                }
                this.zza.put(zzgzj, zzf);
                return;
            }
            throw new IllegalStateException("Lazy fields can not be repeated");
        } else if (zzgzj.zze() == zzhdo.MESSAGE) {
            Object zzf2 = zzf(zzgzj);
            if (zzf2 == null) {
                this.zza.put(zzgzj, zzm(value));
                if (z) {
                    this.zzd = true;
                }
            } else if (!z) {
                if (zzf2 instanceof zzhbq) {
                    obj = zzgzj.zzc((zzhbq) zzf2, (zzhbq) value);
                } else {
                    zzhbk zzcZ = ((zzhbl) zzf2).zzcZ();
                    zzgzj.zzb(zzcZ, (zzhbl) value);
                    obj = zzcZ.zzbr();
                }
                this.zza.put(zzgzj, obj);
            } else {
                zzhaq zzhaq = (zzhaq) value;
                throw null;
            }
        } else if (!z) {
            this.zza.put(zzgzj, zzm(value));
        } else {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
    }

    private static boolean zzo(Map.Entry entry) {
        zzgzj zzgzj = (zzgzj) entry.getKey();
        if (zzgzj.zze() != zzhdo.MESSAGE) {
            return true;
        }
        if (!zzgzj.zzg()) {
            return zzp(entry.getValue());
        }
        for (Object zzp : (List) entry.getValue()) {
            if (!zzp(zzp)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzp(Object obj) {
        if (obj instanceof zzhbm) {
            return ((zzhbm) obj).zzbw();
        }
        if (obj instanceof zzhaq) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzq(Map.Entry entry) {
        int i;
        int zzD;
        int zzD2;
        zzgzj zzgzj = (zzgzj) entry.getKey();
        Object value = entry.getValue();
        if (zzgzj.zze() != zzhdo.MESSAGE || zzgzj.zzg() || zzgzj.zzf()) {
            return zzc(zzgzj, value);
        }
        if (value instanceof zzhaq) {
            int zza2 = ((zzgzj) entry.getKey()).zza();
            int zzD3 = zzgza.zzD(8);
            i = zzD3 + zzD3;
            zzD = zzgza.zzD(16) + zzgza.zzD(zza2);
            int zzD4 = zzgza.zzD(24);
            int zza3 = ((zzhaq) value).zza();
            zzD2 = zzD4 + zzgza.zzD(zza3) + zza3;
        } else {
            int zza4 = ((zzgzj) entry.getKey()).zza();
            int zzD5 = zzgza.zzD(8);
            i = zzD5 + zzD5;
            zzD = zzgza.zzD(16) + zzgza.zzD(zza4);
            zzD2 = zzgza.zzD(24) + zzgza.zzz((zzhbl) value);
        }
        return i + zzD + zzD2;
    }

    private static final void zzr(zzgzj zzgzj, Object obj) {
        boolean z;
        zzhdn zzd2 = zzgzj.zzd();
        byte[] bArr = zzhai.zzd;
        obj.getClass();
        zzhdn zzhdn = zzhdn.DOUBLE;
        zzhdo zzhdo = zzhdo.INT;
        switch (zzd2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgyj) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgzz)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzhbl) || (obj instanceof zzhaq)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzgzj.zza()), zzgzj.zzd().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgzk zzgzk = new zzgzk();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzgzk.zzk((zzgzj) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgzk.zzk((zzgzj) entry.getKey(), entry.getValue());
        }
        zzgzk.zzd = this.zzd;
        return zzgzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgzk)) {
            return false;
        }
        return this.zza.equals(((zzgzk) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzb(); i2++) {
            i += zzq(this.zza.zzg(i2));
        }
        for (Map.Entry zzq : this.zza.zzc()) {
            i += zzq(zzq);
        }
        return i;
    }

    public final Object zzf(zzgzj zzgzj) {
        Object obj = this.zza.get(zzgzj);
        if (!(obj instanceof zzhaq)) {
            return obj;
        }
        zzhaq zzhaq = (zzhaq) obj;
        throw null;
    }

    public final Iterator zzg() {
        if (this.zzd) {
            return new zzhap(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    public final void zzh(zzgzj zzgzj, Object obj) {
        List list;
        if (((zzgzs) zzgzj).zzd) {
            zzr(zzgzj, obj);
            Object zzf = zzf(zzgzj);
            if (zzf == null) {
                list = new ArrayList();
                this.zza.put(zzgzj, list);
            } else {
                list = (List) zzf;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    public final void zzi() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzgzv) {
                    ((zzgzv) zzg.getValue()).zzbV();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzj(zzgzk zzgzk) {
        for (int i = 0; i < zzgzk.zza.zzb(); i++) {
            zzn(zzgzk.zza.zzg(i));
        }
        for (Map.Entry zzn : zzgzk.zza.zzc()) {
            zzn(zzn);
        }
    }

    public final void zzk(zzgzj zzgzj, Object obj) {
        if (!zzgzj.zzg()) {
            zzr(zzgzj, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzr(zzgzj, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzhaq) {
            this.zzd = true;
        }
        this.zza.put(zzgzj, obj);
    }

    public final boolean zzl() {
        for (int i = 0; i < this.zza.zzb(); i++) {
            if (!zzo(this.zza.zzg(i))) {
                return false;
            }
        }
        for (Map.Entry zzo : this.zza.zzc()) {
            if (!zzo(zzo)) {
                return false;
            }
        }
        return true;
    }

    private zzgzk(boolean z) {
        zzi();
        zzi();
    }
}
