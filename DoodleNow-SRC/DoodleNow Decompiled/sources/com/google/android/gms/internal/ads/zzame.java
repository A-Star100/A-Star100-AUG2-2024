package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.Pair;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.exoplayer2.C;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import org.apache.commons.io.IOUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzame {
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final long zzd;
    public final long zze;
    public final zzamk zzf;
    public final String zzg;
    public final String zzh;
    public final zzame zzi;
    private final String[] zzj;
    private final HashMap zzk;
    private final HashMap zzl;
    private List zzm;

    public static zzame zzb(String str, long j, long j2, zzamk zzamk, String[] strArr, String str2, String str3, zzame zzame) {
        return new zzame(str, (String) null, j, j2, zzamk, strArr, str2, str3, zzame);
    }

    public static zzame zzc(String str) {
        return new zzame((String) null, str.replaceAll(IOUtils.LINE_SEPARATOR_WINDOWS, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).replaceAll("[ \t\\x0B\f\r]+", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR), C.TIME_UNSET, C.TIME_UNSET, (zzamk) null, (String[]) null, "", (String) null, (zzame) null);
    }

    private static SpannableStringBuilder zzi(String str, Map map) {
        if (!map.containsKey(str)) {
            zzea zzea = new zzea();
            zzea.zzl(new SpannableStringBuilder());
            map.put(str, zzea);
        }
        CharSequence zzq = ((zzea) map.get(str)).zzq();
        zzq.getClass();
        return (SpannableStringBuilder) zzq;
    }

    private final void zzj(TreeSet treeSet, boolean z) {
        String str = this.zza;
        boolean equals = "p".equals(str);
        boolean equals2 = TtmlNode.TAG_DIV.equals(str);
        if (z || equals || (equals2 && this.zzh != null)) {
            long j = this.zzd;
            if (j != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.zze;
            if (j2 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.zzm != null) {
            for (int i = 0; i < this.zzm.size(); i++) {
                zzame zzame = (zzame) this.zzm.get(i);
                boolean z2 = true;
                if (!z && !equals) {
                    z2 = false;
                }
                zzame.zzj(treeSet, z2);
            }
        }
    }

    private final void zzk(long j, String str, List list) {
        String str2;
        if (!"".equals(this.zzg)) {
            str = this.zzg;
        }
        if (!zzg(j) || !TtmlNode.TAG_DIV.equals(this.zza) || (str2 = this.zzh) == null) {
            for (int i = 0; i < zza(); i++) {
                zzd(i).zzk(j, str, list);
            }
            return;
        }
        list.add(new Pair(str, str2));
    }

    private final void zzl(long j, Map map, Map map2, String str, Map map3) {
        zzame zzame;
        int i;
        int i2;
        zzamk zza2;
        int i3;
        Map map4 = map;
        if (zzg(j)) {
            String str2 = !"".equals(this.zzg) ? this.zzg : str;
            for (Map.Entry entry : this.zzl.entrySet()) {
                String str3 = (String) entry.getKey();
                int intValue = this.zzk.containsKey(str3) ? ((Integer) this.zzk.get(str3)).intValue() : 0;
                int intValue2 = ((Integer) entry.getValue()).intValue();
                if (intValue != intValue2) {
                    zzea zzea = (zzea) map3.get(str3);
                    zzea.getClass();
                    zzami zzami = (zzami) map2.get(str2);
                    zzami.getClass();
                    zzamk zza3 = zzamj.zza(this.zzf, this.zzj, map4);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzea.zzq();
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        zzea.zzl(spannableStringBuilder);
                    }
                    if (zza3 != null) {
                        zzame zzame2 = this.zzi;
                        if (zza3.zzh() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(zza3.zzh()), intValue, intValue2, 33);
                        }
                        if (zza3.zzI()) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), intValue, intValue2, 33);
                        }
                        if (zza3.zzJ()) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), intValue, intValue2, 33);
                        }
                        if (zza3.zzH()) {
                            zzei.zza(spannableStringBuilder, new ForegroundColorSpan(zza3.zzd()), intValue, intValue2, 33);
                        }
                        if (zza3.zzG()) {
                            zzei.zza(spannableStringBuilder, new BackgroundColorSpan(zza3.zzc()), intValue, intValue2, 33);
                        }
                        if (zza3.zzD() != null) {
                            zzei.zza(spannableStringBuilder, new TypefaceSpan(zza3.zzD()), intValue, intValue2, 33);
                        }
                        if (zza3.zzk() != null) {
                            zzamd zzk2 = zza3.zzk();
                            zzk2.getClass();
                            int i4 = zzk2.zza;
                            if (i4 == -1) {
                                int i5 = zzami.zzj;
                                i4 = (i5 == 2 || i5 == 1) ? 3 : 1;
                                i3 = 1;
                            } else {
                                i3 = zzk2.zzb;
                            }
                            int i6 = zzk2.zzc;
                            if (i6 == -2) {
                                i6 = 1;
                            }
                            zzei.zza(spannableStringBuilder, new zzej(i4, i3, i6), intValue, intValue2, 33);
                        }
                        int zzg2 = zza3.zzg();
                        if (zzg2 == 2) {
                            while (true) {
                                if (zzame2 != null) {
                                    zzamk zza4 = zzamj.zza(zzame2.zzf, zzame2.zzj, map4);
                                    if (zza4 != null && zza4.zzg() == 1) {
                                        break;
                                    }
                                    zzame2 = zzame2.zzi;
                                } else {
                                    zzame2 = null;
                                    break;
                                }
                            }
                            if (zzame2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(zzame2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        zzame = null;
                                        break;
                                    }
                                    zzame zzame3 = (zzame) arrayDeque.pop();
                                    zzamk zza5 = zzamj.zza(zzame3.zzf, zzame3.zzj, map4);
                                    if (zza5 != null && zza5.zzg() == 3) {
                                        zzame = zzame3;
                                        break;
                                    }
                                    for (int zza6 = zzame3.zza() - 1; zza6 >= 0; zza6--) {
                                        arrayDeque.push(zzame3.zzd(zza6));
                                    }
                                }
                                if (zzame != null) {
                                    if (zzame.zza() != 1 || zzame.zzd(0).zzb == null) {
                                        zzfe.zze("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                    } else {
                                        String str4 = zzame.zzd(0).zzb;
                                        int i7 = zzfx.zza;
                                        zzamk zza7 = zzamj.zza(zzame.zzf, zzame.zzj, map4);
                                        if (zza7 != null) {
                                            i = zza7.zzf();
                                            i2 = -1;
                                        } else {
                                            i2 = -1;
                                            i = -1;
                                        }
                                        if (i == i2 && (zza2 = zzamj.zza(zzame2.zzf, zzame2.zzj, map4)) != null) {
                                            i = zza2.zzf();
                                        }
                                        spannableStringBuilder.setSpan(new zzeh(str4, i), intValue, intValue2, 33);
                                    }
                                }
                            }
                        } else if (zzg2 == 3 || zzg2 == 4) {
                            spannableStringBuilder.setSpan(new zzamc(), intValue, intValue2, 33);
                        }
                        if (zza3.zzF()) {
                            zzei.zza(spannableStringBuilder, new zzeg(), intValue, intValue2, 33);
                        }
                        int zze2 = zza3.zze();
                        if (zze2 == 1) {
                            zzei.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zza3.zza(), true), intValue, intValue2, 33);
                        } else if (zze2 == 2) {
                            zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zza3.zza()), intValue, intValue2, 33);
                        } else if (zze2 == 3) {
                            zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zza3.zza() / 100.0f), intValue, intValue2, 33);
                        }
                        if ("p".equals(this.zza)) {
                            if (zza3.zzb() != Float.MAX_VALUE) {
                                zzea.zzj((zza3.zzb() * -90.0f) / 100.0f);
                            }
                            if (zza3.zzj() != null) {
                                zzea.zzm(zza3.zzj());
                            }
                            if (zza3.zzi() != null) {
                                zzea.zzg(zza3.zzi());
                            }
                        }
                    }
                } else {
                    Map map5 = map2;
                    Map map6 = map3;
                }
            }
            Map map7 = map2;
            Map map8 = map3;
            for (int i8 = 0; i8 < zza(); i8++) {
                zzd(i8).zzl(j, map, map2, str2, map3);
            }
        }
    }

    private final void zzm(long j, boolean z, String str, Map map) {
        this.zzk.clear();
        this.zzl.clear();
        if (!TtmlNode.TAG_METADATA.equals(this.zza)) {
            if (!"".equals(this.zzg)) {
                str = this.zzg;
            }
            if (this.zzc && z) {
                SpannableStringBuilder zzi2 = zzi(str, map);
                String str2 = this.zzb;
                str2.getClass();
                zzi2.append(str2);
            } else if (TtmlNode.TAG_BR.equals(this.zza) && z) {
                zzi(str, map).append(10);
            } else if (zzg(j)) {
                for (Map.Entry entry : map.entrySet()) {
                    CharSequence zzq = ((zzea) entry.getValue()).zzq();
                    zzq.getClass();
                    this.zzk.put((String) entry.getKey(), Integer.valueOf(zzq.length()));
                }
                boolean equals = "p".equals(this.zza);
                for (int i = 0; i < zza(); i++) {
                    zzd(i).zzm(j, z || equals, str, map);
                }
                if (equals) {
                    SpannableStringBuilder zzi3 = zzi(str, map);
                    int length = zzi3.length();
                    do {
                        length--;
                        if (length < 0 || zzi3.charAt(length) != ' ') {
                            if (length >= 0 && zzi3.charAt(length) != 10) {
                                zzi3.append(10);
                            }
                        }
                        length--;
                        break;
                    } while (zzi3.charAt(length) != ' ');
                    zzi3.append(10);
                }
                for (Map.Entry entry2 : map.entrySet()) {
                    CharSequence zzq2 = ((zzea) entry2.getValue()).zzq();
                    zzq2.getClass();
                    this.zzl.put((String) entry2.getKey(), Integer.valueOf(zzq2.length()));
                }
            }
        }
    }

    public final int zza() {
        List list = this.zzm;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final List zze(long j, Map map, Map map2, Map map3) {
        ArrayList arrayList = new ArrayList();
        zzk(j, this.zzg, arrayList);
        TreeMap treeMap = new TreeMap();
        long j2 = j;
        zzm(j2, false, this.zzg, treeMap);
        zzl(j2, map, map2, this.zzg, treeMap);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Pair pair = (Pair) arrayList.get(i);
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                zzami zzami = (zzami) map2.get(pair.first);
                zzami.getClass();
                zzea zzea = new zzea();
                zzea.zzc(decodeByteArray);
                zzea.zzh(zzami.zzb);
                zzea.zzi(0);
                zzea.zze(zzami.zzc, 0);
                zzea.zzf(zzami.zze);
                zzea.zzk(zzami.zzf);
                zzea.zzd(zzami.zzg);
                zzea.zzo(zzami.zzj);
                arrayList2.add(zzea.zzp());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            zzami zzami2 = (zzami) map2.get(entry.getKey());
            zzami2.getClass();
            zzea zzea2 = (zzea) entry.getValue();
            CharSequence zzq = zzea2.zzq();
            zzq.getClass();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) zzq;
            for (zzamc zzamc : (zzamc[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), zzamc.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(zzamc), spannableStringBuilder.getSpanEnd(zzamc), "");
            }
            int i2 = 0;
            while (i2 < spannableStringBuilder.length()) {
                int i3 = i2 + 1;
                if (spannableStringBuilder.charAt(i2) == ' ') {
                    int i4 = i3;
                    while (i4 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i4) == ' ') {
                        i4++;
                    }
                    int i5 = i4 - i3;
                    if (i5 > 0) {
                        spannableStringBuilder.delete(i2, i5 + i2);
                    }
                }
                i2 = i3;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            int i6 = 0;
            while (i6 < spannableStringBuilder.length() - 1) {
                int i7 = i6 + 1;
                if (spannableStringBuilder.charAt(i6) == 10 && spannableStringBuilder.charAt(i7) == ' ') {
                    spannableStringBuilder.delete(i7, i6 + 2);
                }
                i6 = i7;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            int i8 = 0;
            while (i8 < spannableStringBuilder.length() - 1) {
                int i9 = i8 + 1;
                if (spannableStringBuilder.charAt(i8) == ' ' && spannableStringBuilder.charAt(i9) == 10) {
                    spannableStringBuilder.delete(i8, i9);
                }
                i8 = i9;
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == 10) {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            zzea2.zze(zzami2.zzc, zzami2.zzd);
            zzea2.zzf(zzami2.zze);
            zzea2.zzh(zzami2.zzb);
            zzea2.zzk(zzami2.zzf);
            zzea2.zzn(zzami2.zzi, zzami2.zzh);
            zzea2.zzo(zzami2.zzj);
            arrayList2.add(zzea2.zzp());
        }
        return arrayList2;
    }

    public final void zzf(zzame zzame) {
        if (this.zzm == null) {
            this.zzm = new ArrayList();
        }
        this.zzm.add(zzame);
    }

    public final boolean zzg(long j) {
        long j2 = this.zzd;
        if (j2 == C.TIME_UNSET) {
            if (this.zze == C.TIME_UNSET) {
                return true;
            }
            j2 = -9223372036854775807L;
        }
        int i = (j2 > j ? 1 : (j2 == j ? 0 : -1));
        if (i <= 0 && this.zze == C.TIME_UNSET) {
            return true;
        }
        if (j2 == C.TIME_UNSET && j < this.zze) {
            return true;
        }
        if (i <= 0) {
            return j < this.zze;
        }
        return false;
    }

    public final long[] zzh() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        zzj(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    public final zzame zzd(int i) {
        List list = this.zzm;
        if (list != null) {
            return (zzame) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    private zzame(String str, String str2, long j, long j2, zzamk zzamk, String[] strArr, String str3, String str4, zzame zzame) {
        this.zza = str;
        this.zzb = str2;
        this.zzh = str4;
        this.zzf = zzamk;
        this.zzj = strArr;
        this.zzc = str2 != null;
        this.zzd = j;
        this.zze = j2;
        str3.getClass();
        this.zzg = str3;
        this.zzi = zzame;
        this.zzk = new HashMap();
        this.zzl = new HashMap();
    }
}
