package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgzh extends zzgzg {
    zzgzh() {
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry entry) {
        return ((zzgzs) entry.getKey()).zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzgzk zzb(Object obj) {
        return ((zzgzr) obj).zza;
    }

    /* access modifiers changed from: package-private */
    public final zzgzk zzc(Object obj) {
        zzgzr zzgzr = (zzgzr) obj;
        throw null;
    }

    /* access modifiers changed from: package-private */
    public final Object zzd(zzgzf zzgzf, zzhbl zzhbl, int i) {
        return zzgzf.zzc(zzhbl, i);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj) {
        ((zzgzr) obj).zza.zzi();
    }

    /* access modifiers changed from: package-private */
    public final void zzg(zzhby zzhby, Object obj, zzgzf zzgzf, zzgzk zzgzk) throws IOException {
        zzgzt zzgzt = (zzgzt) obj;
        zzgzk.zzk(zzgzt.zzd, zzhby.zzs(zzgzt.zzc.getClass(), zzgzf));
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzgyj zzgyj, Object obj, zzgzf zzgzf, zzgzk zzgzk) throws IOException {
        zzgzt zzgzt = (zzgzt) obj;
        zzhbk zzcY = zzgzt.zzc.zzcY();
        zzgyt zzl = zzgyj.zzl();
        zzcY.zzaW(zzl, zzgzf);
        zzgzk.zzk(zzgzt.zzd, zzcY.zzbs());
        zzl.zzz(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzi(zzhbl zzhbl) {
        return zzhbl instanceof zzgzr;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(zzgzb zzgzb, Map.Entry entry) throws IOException {
        zzgzs zzgzs = (zzgzs) entry.getKey();
        if (zzgzs.zzd) {
            zzhdn zzhdn = zzhdn.DOUBLE;
            switch (zzgzs.zzc.ordinal()) {
                case 0:
                    zzhci.zzw(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 1:
                    zzhci.zzA(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 2:
                    zzhci.zzD(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 3:
                    zzhci.zzL(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 4:
                    zzhci.zzC(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 5:
                    zzhci.zzz(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 6:
                    zzhci.zzy(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 7:
                    zzhci.zzu(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 8:
                    zzhci.zzJ(zzgzs.zzb, (List) entry.getValue(), zzgzb);
                    return;
                case 9:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzhci.zzB(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzhbv.zza().zzb(list.get(0).getClass()));
                        return;
                    }
                    return;
                case 10:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzhci.zzE(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzhbv.zza().zzb(list2.get(0).getClass()));
                        return;
                    }
                    return;
                case 11:
                    zzhci.zzv(zzgzs.zzb, (List) entry.getValue(), zzgzb);
                    return;
                case 12:
                    zzhci.zzK(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 13:
                    zzhci.zzC(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 14:
                    zzhci.zzF(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 15:
                    zzhci.zzG(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 16:
                    zzhci.zzH(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                case 17:
                    zzhci.zzI(zzgzs.zzb, (List) entry.getValue(), zzgzb, zzgzs.zze);
                    return;
                default:
                    return;
            }
        } else {
            zzhdn zzhdn2 = zzhdn.DOUBLE;
            switch (zzgzs.zzc.ordinal()) {
                case 0:
                    zzgzb.zzf(zzgzs.zzb, ((Double) entry.getValue()).doubleValue());
                    return;
                case 1:
                    zzgzb.zzo(zzgzs.zzb, ((Float) entry.getValue()).floatValue());
                    return;
                case 2:
                    zzgzb.zzt(zzgzs.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 3:
                    zzgzb.zzK(zzgzs.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    zzgzb.zzr(zzgzs.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 5:
                    zzgzb.zzm(zzgzs.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 6:
                    zzgzb.zzk(zzgzs.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 7:
                    zzgzb.zzb(zzgzs.zzb, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case 8:
                    zzgzb.zzG(zzgzs.zzb, (String) entry.getValue());
                    return;
                case 9:
                    zzgzb.zzq(zzgzs.zzb, entry.getValue(), zzhbv.zza().zzb(entry.getValue().getClass()));
                    return;
                case 10:
                    zzgzb.zzv(zzgzs.zzb, entry.getValue(), zzhbv.zza().zzb(entry.getValue().getClass()));
                    return;
                case 11:
                    zzgzb.zzd(zzgzs.zzb, (zzgyj) entry.getValue());
                    return;
                case 12:
                    zzgzb.zzI(zzgzs.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    zzgzb.zzr(zzgzs.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 14:
                    zzgzb.zzx(zzgzs.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 15:
                    zzgzb.zzz(zzgzs.zzb, ((Long) entry.getValue()).longValue());
                    return;
                case 16:
                    zzgzb.zzB(zzgzs.zzb, ((Integer) entry.getValue()).intValue());
                    return;
                case 17:
                    zzgzb.zzD(zzgzs.zzb, ((Long) entry.getValue()).longValue());
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object zze(Object obj, zzhby zzhby, Object obj2, zzgzf zzgzf, zzgzk zzgzk, Object obj3, zzhcx zzhcx) throws IOException {
        Object obj4;
        Object zzf;
        ArrayList arrayList;
        zzgzt zzgzt = (zzgzt) obj2;
        zzgzs zzgzs = zzgzt.zzd;
        boolean z = zzgzs.zzd;
        int i = zzgzs.zzb;
        if (!z || !zzgzs.zze) {
            if (zzgzs.zzc != zzhdn.ENUM) {
                switch (zzgzt.zzd.zzc.ordinal()) {
                    case 0:
                        obj4 = Double.valueOf(zzhby.zza());
                        break;
                    case 1:
                        obj4 = Float.valueOf(zzhby.zzb());
                        break;
                    case 2:
                        obj4 = Long.valueOf(zzhby.zzl());
                        break;
                    case 3:
                        obj4 = Long.valueOf(zzhby.zzo());
                        break;
                    case 4:
                        obj4 = Integer.valueOf(zzhby.zzg());
                        break;
                    case 5:
                        obj4 = Long.valueOf(zzhby.zzk());
                        break;
                    case 6:
                        obj4 = Integer.valueOf(zzhby.zzf());
                        break;
                    case 7:
                        obj4 = Boolean.valueOf(zzhby.zzP());
                        break;
                    case 8:
                        obj4 = zzhby.zzt();
                        break;
                    case 9:
                        zzgzs zzgzs2 = zzgzt.zzd;
                        if (!zzgzs2.zzd) {
                            Object zzf2 = zzgzk.zzf(zzgzs2);
                            if (zzf2 instanceof zzgzv) {
                                zzhcg zzb = zzhbv.zza().zzb(zzf2.getClass());
                                if (!((zzgzv) zzf2).zzce()) {
                                    Object zze = zzb.zze();
                                    zzb.zzg(zze, zzf2);
                                    zzgzk.zzk(zzgzt.zzd, zze);
                                    zzf2 = zze;
                                }
                                zzhby.zzv(zzf2, zzb, zzgzf);
                                return obj3;
                            }
                        }
                        obj4 = zzhby.zzr(zzgzt.zzc.getClass(), zzgzf);
                        break;
                    case 10:
                        zzgzs zzgzs3 = zzgzt.zzd;
                        if (!zzgzs3.zzd) {
                            Object zzf3 = zzgzk.zzf(zzgzs3);
                            if (zzf3 instanceof zzgzv) {
                                zzhcg zzb2 = zzhbv.zza().zzb(zzf3.getClass());
                                if (!((zzgzv) zzf3).zzce()) {
                                    Object zze2 = zzb2.zze();
                                    zzb2.zzg(zze2, zzf3);
                                    zzgzk.zzk(zzgzt.zzd, zze2);
                                    zzf3 = zze2;
                                }
                                zzhby.zzw(zzf3, zzb2, zzgzf);
                                return obj3;
                            }
                        }
                        obj4 = zzhby.zzs(zzgzt.zzc.getClass(), zzgzf);
                        break;
                    case 11:
                        obj4 = zzhby.zzp();
                        break;
                    case 12:
                        obj4 = Integer.valueOf(zzhby.zzj());
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 14:
                        obj4 = Integer.valueOf(zzhby.zzh());
                        break;
                    case 15:
                        obj4 = Long.valueOf(zzhby.zzm());
                        break;
                    case 16:
                        obj4 = Integer.valueOf(zzhby.zzi());
                        break;
                    case 17:
                        obj4 = Long.valueOf(zzhby.zzn());
                        break;
                    default:
                        obj4 = null;
                        break;
                }
            } else {
                int zzg = zzhby.zzg();
                if (zzgzt.zzd.zza.zza(zzg) == null) {
                    return zzhci.zzp(obj, i, zzg, obj3, zzhcx);
                }
                obj4 = Integer.valueOf(zzg);
            }
            zzgzs zzgzs4 = zzgzt.zzd;
            if (zzgzs4.zzd) {
                zzgzk.zzh(zzgzs4, obj4);
            } else {
                int ordinal = zzgzs4.zzc.ordinal();
                if ((ordinal == 9 || ordinal == 10) && (zzf = zzgzk.zzf(zzgzt.zzd)) != null) {
                    byte[] bArr = zzhai.zzd;
                    obj4 = ((zzhbl) zzf).zzcZ().zzaS((zzhbl) obj4).zzbs();
                }
                zzgzk.zzk(zzgzt.zzd, obj4);
            }
        } else {
            zzhdn zzhdn = zzhdn.DOUBLE;
            switch (zzgzt.zzd.zzc.ordinal()) {
                case 0:
                    arrayList = new ArrayList();
                    zzhby.zzz(arrayList);
                    break;
                case 1:
                    arrayList = new ArrayList();
                    zzhby.zzD(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    zzhby.zzG(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    zzhby.zzO(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    zzhby.zzF(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    zzhby.zzC(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    zzhby.zzB(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    zzhby.zzx(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    zzhby.zzN(arrayList);
                    break;
                case 13:
                    ArrayList arrayList2 = new ArrayList();
                    zzhby.zzA(arrayList2);
                    zzgzs zzgzs5 = zzgzt.zzd;
                    int i2 = zzhci.zza;
                    zzhaa zzhaa = zzgzs5.zza;
                    if (zzhaa != null) {
                        int size = arrayList2.size();
                        int i3 = 0;
                        for (int i4 = 0; i4 < size; i4++) {
                            int intValue = ((Integer) arrayList2.get(i4)).intValue();
                            if (zzhaa.zza(intValue) != null) {
                                if (i4 != i3) {
                                    arrayList2.set(i3, Integer.valueOf(intValue));
                                }
                                i3++;
                            } else {
                                obj3 = zzhci.zzp(obj, i, intValue, obj3, zzhcx);
                            }
                        }
                        if (i3 != size) {
                            arrayList2.subList(i3, size).clear();
                        }
                    }
                    arrayList = arrayList2;
                    break;
                case 14:
                    arrayList = new ArrayList();
                    zzhby.zzI(arrayList);
                    break;
                case 15:
                    arrayList = new ArrayList();
                    zzhby.zzJ(arrayList);
                    break;
                case 16:
                    arrayList = new ArrayList();
                    zzhby.zzK(arrayList);
                    break;
                case 17:
                    arrayList = new ArrayList();
                    zzhby.zzL(arrayList);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: ".concat(String.valueOf(String.valueOf(zzgzt.zzd.zzc))));
            }
            zzgzk.zzk(zzgzt.zzd, arrayList);
        }
        return obj3;
    }
}
