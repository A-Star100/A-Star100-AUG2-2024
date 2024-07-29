package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzyx extends zzzc implements zzmg {
    /* access modifiers changed from: private */
    public static final zzgay zzb = zzgay.zzb(zzxu.zza);
    public final Context zza;
    private final Object zzc = new Object();
    private final boolean zzd;
    private zzyl zze;
    private zzyq zzf;
    private zzk zzg;
    private final zzxq zzh;

    public zzyx(Context context) {
        zzxq zzxq = new zzxq();
        zzyl zzd2 = zzyl.zzd(context);
        this.zza = context != null ? context.getApplicationContext() : null;
        this.zzh = zzxq;
        this.zze = zzd2;
        this.zzg = zzk.zza;
        boolean z = false;
        if (context != null && zzfx.zzM(context)) {
            z = true;
        }
        this.zzd = z;
        if (!z && context != null && zzfx.zza >= 32) {
            this.zzf = zzyq.zza(context);
        }
        if (this.zze.zzS && context == null) {
            zzfe.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
        }
    }

    static /* bridge */ /* synthetic */ int zzb(int i, int i2) {
        if (i == 0 || i != i2) {
            return Integer.bitCount(i & i2);
        }
        return Integer.MAX_VALUE;
    }

    protected static int zzc(zzam zzam, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(zzam.zzd)) {
            return 4;
        }
        String zzh2 = zzh(str);
        String zzh3 = zzh(zzam.zzd);
        if (zzh3 == null || zzh2 == null) {
            if (!z || zzh3 != null) {
                return 0;
            }
            return 1;
        } else if (zzh3.startsWith(zzh2) || zzh2.startsWith(zzh3)) {
            return 3;
        } else {
            int i = zzfx.zza;
            if (zzh3.split("-", 2)[0].equals(zzh2.split("-", 2)[0])) {
                return 2;
            }
            return 0;
        }
    }

    protected static String zzh(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ boolean zzm(com.google.android.gms.internal.ads.zzyx r8, com.google.android.gms.internal.ads.zzam r9) {
        /*
            java.lang.Object r0 = r8.zzc
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzyl r1 = r8.zze     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzS     // Catch:{ all -> 0x008f }
            r2 = 1
            if (r1 == 0) goto L_0x008d
            boolean r1 = r8.zzd     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x008d
            int r1 = r9.zzz     // Catch:{ all -> 0x008f }
            r3 = 2
            if (r1 <= r3) goto L_0x008d
            java.lang.String r1 = r9.zzm     // Catch:{ all -> 0x008f }
            r4 = 32
            r5 = 0
            if (r1 != 0) goto L_0x001b
            goto L_0x0065
        L_0x001b:
            int r6 = r1.hashCode()     // Catch:{ all -> 0x008f }
            r7 = 3
            switch(r6) {
                case -2123537834: goto L_0x0042;
                case 187078296: goto L_0x0038;
                case 187078297: goto L_0x002e;
                case 1504578661: goto L_0x0024;
                default: goto L_0x0023;
            }
        L_0x0023:
            goto L_0x004c
        L_0x0024:
            java.lang.String r6 = "audio/eac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r2
            goto L_0x004d
        L_0x002e:
            java.lang.String r6 = "audio/ac4"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r7
            goto L_0x004d
        L_0x0038:
            java.lang.String r6 = "audio/ac3"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r5
            goto L_0x004d
        L_0x0042:
            java.lang.String r6 = "audio/eac3-joc"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x004c
            r1 = r3
            goto L_0x004d
        L_0x004c:
            r1 = -1
        L_0x004d:
            if (r1 == 0) goto L_0x0056
            if (r1 == r2) goto L_0x0056
            if (r1 == r3) goto L_0x0056
            if (r1 == r7) goto L_0x0056
            goto L_0x0065
        L_0x0056:
            int r1 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008d
            com.google.android.gms.internal.ads.zzyq r1 = r8.zzf     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008d
            boolean r1 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r1 != 0) goto L_0x0065
            goto L_0x008d
        L_0x0065:
            int r1 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ all -> 0x008f }
            if (r1 < r4) goto L_0x008c
            com.google.android.gms.internal.ads.zzyq r1 = r8.zzf     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            boolean r3 = r1.zzg()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x008c
            boolean r1 = r1.zze()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzyq r1 = r8.zzf     // Catch:{ all -> 0x008f }
            boolean r1 = r1.zzf()     // Catch:{ all -> 0x008f }
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.internal.ads.zzyq r1 = r8.zzf     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzk r8 = r8.zzg     // Catch:{ all -> 0x008f }
            boolean r8 = r1.zzd(r8, r9)     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            r2 = r5
        L_0x008d:
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            return r2
        L_0x008f:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008f }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyx.zzm(com.google.android.gms.internal.ads.zzyx, com.google.android.gms.internal.ads.zzam):boolean");
    }

    protected static boolean zzo(int i, boolean z) {
        int i2 = i & 7;
        if (i2 == 4) {
            return true;
        }
        if (z) {
            return i2 == 3;
        }
        return false;
    }

    private static void zzu(zzxk zzxk, zzdg zzdg, Map map) {
        int i = 0;
        while (i < zzxk.zzc) {
            if (((zzdb) zzdg.zzD.get(zzxk.zzb(i))) == null) {
                i++;
            } else {
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        boolean z;
        zzyq zzyq;
        synchronized (this.zzc) {
            z = false;
            if (this.zze.zzS && !this.zzd && zzfx.zza >= 32 && (zzyq = this.zzf) != null && zzyq.zzg()) {
                z = true;
            }
        }
        if (z) {
            zzt();
        }
    }

    private static final Pair zzw(int i, zzzb zzzb, int[][][] iArr, zzys zzys, Comparator comparator) {
        Object obj;
        zzzb zzzb2 = zzzb;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < 2) {
            if (i == zzzb2.zzc(i2)) {
                zzxk zzd2 = zzzb2.zzd(i2);
                int i3 = 0;
                while (i3 < zzd2.zzc) {
                    zzcz zzb2 = zzd2.zzb(i3);
                    List zza2 = zzys.zza(i2, zzb2, iArr[i2][i3]);
                    boolean[] zArr = new boolean[zzb2.zzb];
                    int i4 = 0;
                    while (i4 < zzb2.zzb) {
                        int i5 = i4 + 1;
                        zzyt zzyt = (zzyt) zza2.get(i4);
                        int zzb3 = zzyt.zzb();
                        if (!zArr[i4] && zzb3 != 0) {
                            if (zzb3 == 1) {
                                obj = zzfzn.zzn(zzyt);
                            } else {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(zzyt);
                                int i6 = i5;
                                while (i6 < zzb2.zzb) {
                                    zzyt zzyt2 = (zzyt) zza2.get(i6);
                                    if (zzyt2.zzb() == 2 && zzyt.zzc(zzyt2)) {
                                        arrayList2.add(zzyt2);
                                        zArr[i6] = true;
                                    }
                                    i6++;
                                    zzzb zzzb3 = zzzb;
                                }
                                obj = arrayList2;
                            }
                            arrayList.add(obj);
                        }
                        zzzb zzzb4 = zzzb;
                        i4 = i5;
                    }
                    i3++;
                    zzzb zzzb5 = zzzb;
                }
            }
            zzys zzys2 = zzys;
            i2++;
            zzzb2 = zzzb;
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i7 = 0; i7 < list.size(); i7++) {
            iArr2[i7] = ((zzyt) list.get(i7)).zzc;
        }
        zzyt zzyt3 = (zzyt) list.get(0);
        return Pair.create(new zzyy(zzyt3.zzb, iArr2, 0), Integer.valueOf(zzyt3.zza));
    }

    public final void zza(zzmf zzmf) {
        synchronized (this.zzc) {
            boolean z = this.zze.zzW;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: com.google.android.gms.internal.ads.zzyz[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.google.android.gms.internal.ads.zzxr} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: com.google.android.gms.internal.ads.zzza} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: com.google.android.gms.internal.ads.zzza} */
    /* JADX WARNING: type inference failed for: r9v1 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair zzd(com.google.android.gms.internal.ads.zzzb r27, int[][][] r28, int[] r29, com.google.android.gms.internal.ads.zzvh r30, com.google.android.gms.internal.ads.zzcx r31) throws com.google.android.gms.internal.ads.zziz {
        /*
            r26 = this;
            r1 = r26
            r0 = r27
            r2 = r28
            r3 = r29
            java.lang.Object r4 = r1.zzc
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzyl r5 = r1.zze     // Catch:{ all -> 0x0254 }
            boolean r6 = r5.zzS     // Catch:{ all -> 0x0254 }
            if (r6 == 0) goto L_0x0025
            int r6 = com.google.android.gms.internal.ads.zzfx.zza     // Catch:{ all -> 0x0254 }
            r7 = 32
            if (r6 < r7) goto L_0x0025
            com.google.android.gms.internal.ads.zzyq r6 = r1.zzf     // Catch:{ all -> 0x0254 }
            if (r6 == 0) goto L_0x0025
            android.os.Looper r7 = android.os.Looper.myLooper()     // Catch:{ all -> 0x0254 }
            com.google.android.gms.internal.ads.zzek.zzb(r7)     // Catch:{ all -> 0x0254 }
            r6.zzb(r1, r7)     // Catch:{ all -> 0x0254 }
        L_0x0025:
            monitor-exit(r4)     // Catch:{ all -> 0x0254 }
            r4 = 2
            com.google.android.gms.internal.ads.zzyy[] r6 = new com.google.android.gms.internal.ads.zzyy[r4]
            com.google.android.gms.internal.ads.zzde r7 = r5.zzv
            com.google.android.gms.internal.ads.zzya r7 = new com.google.android.gms.internal.ads.zzya
            r7.<init>(r5, r3)
            com.google.android.gms.internal.ads.zzyb r8 = com.google.android.gms.internal.ads.zzyb.zza
            android.util.Pair r7 = zzw(r4, r0, r2, r7, r8)
            boolean r8 = r5.zzA
            r8 = 4
            if (r7 != 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzde r10 = r5.zzv
            com.google.android.gms.internal.ads.zzxw r10 = new com.google.android.gms.internal.ads.zzxw
            r10.<init>(r5)
            com.google.android.gms.internal.ads.zzxx r11 = com.google.android.gms.internal.ads.zzxx.zza
            android.util.Pair r10 = zzw(r8, r0, r2, r10, r11)
            goto L_0x004a
        L_0x0049:
            r10 = 0
        L_0x004a:
            r11 = 0
            if (r10 == 0) goto L_0x005d
            java.lang.Object r7 = r10.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r10 = r10.first
            com.google.android.gms.internal.ads.zzyy r10 = (com.google.android.gms.internal.ads.zzyy) r10
            r6[r7] = r10
        L_0x005b:
            r7 = r11
            goto L_0x006e
        L_0x005d:
            if (r7 == 0) goto L_0x005b
            java.lang.Object r10 = r7.second
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r7 = r7.first
            com.google.android.gms.internal.ads.zzyy r7 = (com.google.android.gms.internal.ads.zzyy) r7
            r6[r10] = r7
            goto L_0x005b
        L_0x006e:
            r10 = 1
            if (r7 >= r4) goto L_0x0084
            int r12 = r0.zzc(r7)
            if (r12 != r4) goto L_0x0081
            com.google.android.gms.internal.ads.zzxk r12 = r0.zzd(r7)
            int r12 = r12.zzc
            if (r12 <= 0) goto L_0x0081
            r7 = r10
            goto L_0x0085
        L_0x0081:
            int r7 = r7 + 1
            goto L_0x006e
        L_0x0084:
            r7 = r11
        L_0x0085:
            com.google.android.gms.internal.ads.zzxy r12 = new com.google.android.gms.internal.ads.zzxy
            r12.<init>(r1, r5, r7, r3)
            com.google.android.gms.internal.ads.zzxz r3 = com.google.android.gms.internal.ads.zzxz.zza
            android.util.Pair r3 = zzw(r10, r0, r2, r12, r3)
            if (r3 == 0) goto L_0x00a0
            java.lang.Object r7 = r3.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r12 = r3.first
            com.google.android.gms.internal.ads.zzyy r12 = (com.google.android.gms.internal.ads.zzyy) r12
            r6[r7] = r12
        L_0x00a0:
            if (r3 != 0) goto L_0x00a4
            r3 = 0
            goto L_0x00b8
        L_0x00a4:
            java.lang.Object r7 = r3.first
            com.google.android.gms.internal.ads.zzyy r7 = (com.google.android.gms.internal.ads.zzyy) r7
            com.google.android.gms.internal.ads.zzcz r7 = r7.zza
            java.lang.Object r3 = r3.first
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            int[] r3 = r3.zzb
            r3 = r3[r11]
            com.google.android.gms.internal.ads.zzam r3 = r7.zzb(r3)
            java.lang.String r3 = r3.zzd
        L_0x00b8:
            com.google.android.gms.internal.ads.zzde r7 = r5.zzv
            com.google.android.gms.internal.ads.zzyc r7 = new com.google.android.gms.internal.ads.zzyc
            r7.<init>(r5, r3)
            com.google.android.gms.internal.ads.zzyd r3 = com.google.android.gms.internal.ads.zzyd.zza
            r12 = 3
            android.util.Pair r3 = zzw(r12, r0, r2, r7, r3)
            if (r3 == 0) goto L_0x00d6
            java.lang.Object r7 = r3.second
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r3 = r3.first
            com.google.android.gms.internal.ads.zzyy r3 = (com.google.android.gms.internal.ads.zzyy) r3
            r6[r7] = r3
        L_0x00d6:
            r3 = r11
        L_0x00d7:
            if (r3 >= r4) goto L_0x014b
            int r7 = r0.zzc(r3)
            if (r7 == r4) goto L_0x0143
            if (r7 == r10) goto L_0x0143
            if (r7 == r12) goto L_0x0143
            if (r7 == r8) goto L_0x0143
            com.google.android.gms.internal.ads.zzxk r7 = r0.zzd(r3)
            r13 = r2[r3]
            com.google.android.gms.internal.ads.zzde r14 = r5.zzv
            r14 = r11
            r16 = r14
            r15 = 0
            r17 = 0
        L_0x00f3:
            int r8 = r7.zzc
            if (r14 >= r8) goto L_0x0133
            com.google.android.gms.internal.ads.zzcz r8 = r7.zzb(r14)
            r18 = r13[r14]
            r10 = r11
            r12 = r17
        L_0x0100:
            int r9 = r8.zzb
            if (r10 >= r9) goto L_0x012a
            r9 = r18[r10]
            boolean r4 = r5.zzT
            boolean r4 = zzo(r9, r4)
            if (r4 == 0) goto L_0x0125
            com.google.android.gms.internal.ads.zzam r4 = r8.zzb(r10)
            com.google.android.gms.internal.ads.zzyg r9 = new com.google.android.gms.internal.ads.zzyg
            r11 = r18[r10]
            r9.<init>(r4, r11)
            if (r12 == 0) goto L_0x0121
            int r4 = r9.compareTo(r12)
            if (r4 <= 0) goto L_0x0125
        L_0x0121:
            r15 = r8
            r12 = r9
            r16 = r10
        L_0x0125:
            int r10 = r10 + 1
            r4 = 2
            r11 = 0
            goto L_0x0100
        L_0x012a:
            int r14 = r14 + 1
            r17 = r12
            r4 = 2
            r10 = 1
            r11 = 0
            r12 = 3
            goto L_0x00f3
        L_0x0133:
            if (r15 != 0) goto L_0x0137
            r4 = 0
            goto L_0x0141
        L_0x0137:
            com.google.android.gms.internal.ads.zzyy r4 = new com.google.android.gms.internal.ads.zzyy
            int[] r7 = new int[]{r16}
            r8 = 0
            r4.<init>(r15, r7, r8)
        L_0x0141:
            r6[r3] = r4
        L_0x0143:
            int r3 = r3 + 1
            r4 = 2
            r8 = 4
            r10 = 1
            r11 = 0
            r12 = 3
            goto L_0x00d7
        L_0x014b:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            r3 = 2
            r8 = 0
        L_0x0152:
            if (r8 >= r3) goto L_0x015e
            com.google.android.gms.internal.ads.zzxk r4 = r0.zzd(r8)
            zzu(r4, r5, r2)
            int r8 = r8 + 1
            goto L_0x0152
        L_0x015e:
            com.google.android.gms.internal.ads.zzxk r4 = r27.zze()
            zzu(r4, r5, r2)
            r8 = 0
        L_0x0166:
            if (r8 >= r3) goto L_0x017d
            int r4 = r0.zzc(r8)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Object r4 = r2.get(r4)
            com.google.android.gms.internal.ads.zzdb r4 = (com.google.android.gms.internal.ads.zzdb) r4
            if (r4 != 0) goto L_0x017b
            int r8 = r8 + 1
            goto L_0x0166
        L_0x017b:
            r4 = 0
            throw r4
        L_0x017d:
            r4 = 0
            r8 = 0
        L_0x017f:
            if (r8 >= r3) goto L_0x0199
            com.google.android.gms.internal.ads.zzxk r2 = r0.zzd(r8)
            boolean r3 = r5.zzg(r8, r2)
            if (r3 != 0) goto L_0x018c
            goto L_0x0194
        L_0x018c:
            com.google.android.gms.internal.ads.zzyn r2 = r5.zze(r8, r2)
            if (r2 != 0) goto L_0x0198
            r6[r8] = r4
        L_0x0194:
            int r8 = r8 + 1
            r3 = 2
            goto L_0x017f
        L_0x0198:
            throw r4
        L_0x0199:
            r2 = r3
            r8 = 0
        L_0x019b:
            if (r8 >= r2) goto L_0x01bd
            int r2 = r0.zzc(r8)
            boolean r3 = r5.zzf(r8)
            if (r3 != 0) goto L_0x01b6
            com.google.android.gms.internal.ads.zzfzs r3 = r5.zzE
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            boolean r2 = r3.contains(r2)
            if (r2 == 0) goto L_0x01b4
            goto L_0x01b6
        L_0x01b4:
            r4 = 0
            goto L_0x01b9
        L_0x01b6:
            r4 = 0
            r6[r8] = r4
        L_0x01b9:
            int r8 = r8 + 1
            r2 = 2
            goto L_0x019b
        L_0x01bd:
            r4 = 0
            com.google.android.gms.internal.ads.zzxq r2 = r1.zzh
            com.google.android.gms.internal.ads.zzzn r3 = r26.zzr()
            com.google.android.gms.internal.ads.zzfzn r7 = com.google.android.gms.internal.ads.zzxr.zzf(r6)
            r8 = 2
            com.google.android.gms.internal.ads.zzyz[] r15 = new com.google.android.gms.internal.ads.zzyz[r8]
            r14 = 0
        L_0x01cc:
            if (r14 >= r8) goto L_0x0218
            r8 = r6[r14]
            if (r8 == 0) goto L_0x020e
            int[] r11 = r8.zzb
            int r9 = r11.length
            if (r9 != 0) goto L_0x01d8
            goto L_0x020e
        L_0x01d8:
            r13 = 1
            if (r9 != r13) goto L_0x01f5
            com.google.android.gms.internal.ads.zzcz r8 = r8.zza
            com.google.android.gms.internal.ads.zzza r9 = new com.google.android.gms.internal.ads.zzza
            r16 = 0
            r22 = r11[r16]
            r23 = 0
            r24 = 0
            r25 = 0
            r20 = r9
            r21 = r8
            r20.<init>(r21, r22, r23, r24, r25)
            r17 = r13
            r19 = r14
            goto L_0x020b
        L_0x01f5:
            r16 = 0
            com.google.android.gms.internal.ads.zzcz r10 = r8.zza
            r12 = 0
            java.lang.Object r8 = r7.get(r14)
            com.google.android.gms.internal.ads.zzfzn r8 = (com.google.android.gms.internal.ads.zzfzn) r8
            r9 = r2
            r17 = r13
            r13 = r3
            r19 = r14
            r14 = r8
            com.google.android.gms.internal.ads.zzxr r9 = r9.zza(r10, r11, r12, r13, r14)
        L_0x020b:
            r15[r19] = r9
            goto L_0x0214
        L_0x020e:
            r19 = r14
            r16 = 0
            r17 = 1
        L_0x0214:
            int r14 = r19 + 1
            r8 = 2
            goto L_0x01cc
        L_0x0218:
            r16 = 0
            com.google.android.gms.internal.ads.zzmi[] r2 = new com.google.android.gms.internal.ads.zzmi[r8]
            r11 = r16
        L_0x021e:
            if (r11 >= r8) goto L_0x024b
            int r3 = r0.zzc(r11)
            boolean r6 = r5.zzf(r11)
            if (r6 != 0) goto L_0x0245
            com.google.android.gms.internal.ads.zzfzs r6 = r5.zzE
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            boolean r3 = r6.contains(r3)
            if (r3 == 0) goto L_0x0237
            goto L_0x0245
        L_0x0237:
            int r3 = r0.zzc(r11)
            r6 = -2
            if (r3 == r6) goto L_0x0242
            r3 = r15[r11]
            if (r3 == 0) goto L_0x0245
        L_0x0242:
            com.google.android.gms.internal.ads.zzmi r3 = com.google.android.gms.internal.ads.zzmi.zza
            goto L_0x0246
        L_0x0245:
            r3 = r4
        L_0x0246:
            r2[r11] = r3
            int r11 = r11 + 1
            goto L_0x021e
        L_0x024b:
            boolean r0 = r5.zzU
            com.google.android.gms.internal.ads.zzde r0 = r5.zzv
            android.util.Pair r0 = android.util.Pair.create(r2, r15)
            return r0
        L_0x0254:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0254 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyx.zzd(com.google.android.gms.internal.ads.zzzb, int[][][], int[], com.google.android.gms.internal.ads.zzvh, com.google.android.gms.internal.ads.zzcx):android.util.Pair");
    }

    public final zzmg zze() {
        return this;
    }

    public final zzyl zzf() {
        zzyl zzyl;
        synchronized (this.zzc) {
            zzyl = this.zze;
        }
        return zzyl;
    }

    public final void zzj() {
        zzyq zzyq;
        synchronized (this.zzc) {
            if (zzfx.zza >= 32 && (zzyq = this.zzf) != null) {
                zzyq.zzc();
            }
        }
        super.zzj();
    }

    public final void zzk(zzk zzk) {
        boolean z;
        synchronized (this.zzc) {
            z = !this.zzg.equals(zzk);
            this.zzg = zzk;
        }
        if (z) {
            zzv();
        }
    }

    public final void zzl(zzyj zzyj) {
        boolean z;
        zzyl zzyl = new zzyl(zzyj);
        synchronized (this.zzc) {
            z = !this.zze.equals(zzyl);
            this.zze = zzyl;
        }
        if (z) {
            if (zzyl.zzS && this.zza == null) {
                zzfe.zzf("DefaultTrackSelector", "Audio channel count constraints cannot be applied without reference to Context. Build the track selector instance with one of the non-deprecated constructors that take a Context argument.");
            }
            zzt();
        }
    }

    public final boolean zzn() {
        return true;
    }
}
