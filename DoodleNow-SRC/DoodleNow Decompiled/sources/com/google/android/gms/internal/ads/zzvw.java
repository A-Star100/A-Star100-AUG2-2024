package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.revenuecat.purchases.common.Constants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzvw implements zzvf, zzve {
    private final zzvf[] zza;
    private final IdentityHashMap zzb = new IdentityHashMap();
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzve zze;
    private zzxk zzf;
    private zzvf[] zzg;
    private zzxa zzh = new zzur(zzfzn.zzm(), zzfzn.zzm());
    private final zzus zzi;

    public zzvw(zzus zzus, long[] jArr, zzvf... zzvfArr) {
        this.zzi = zzus;
        this.zza = zzvfArr;
        this.zzg = new zzvf[0];
        for (int i = 0; i < zzvfArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zza[i] = new zzxg(zzvfArr[i], j);
            }
        }
    }

    public final long zza(long j, zzmj zzmj) {
        zzvf[] zzvfArr = this.zzg;
        return (zzvfArr.length > 0 ? zzvfArr[0] : this.zza[0]).zza(j, zzmj);
    }

    public final long zzb() {
        return this.zzh.zzb();
    }

    public final long zzc() {
        return this.zzh.zzc();
    }

    public final long zzd() {
        long j = -9223372036854775807L;
        for (zzvf zzvf : this.zzg) {
            long zzd2 = zzvf.zzd();
            if (zzd2 != C.TIME_UNSET) {
                if (j == C.TIME_UNSET) {
                    zzvf[] zzvfArr = this.zzg;
                    int length = zzvfArr.length;
                    int i = 0;
                    while (i < length) {
                        zzvf zzvf2 = zzvfArr[i];
                        if (zzvf2 == zzvf) {
                            break;
                        } else if (zzvf2.zze(zzd2) == zzd2) {
                            i++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j = zzd2;
                } else if (zzd2 != j) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j == C.TIME_UNSET || zzvf.zze(j) == j)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j;
    }

    public final long zze(long j) {
        long zze2 = this.zzg[0].zze(j);
        int i = 1;
        while (true) {
            zzvf[] zzvfArr = this.zzg;
            if (i >= zzvfArr.length) {
                return zze2;
            }
            if (zzvfArr[i].zze(zze2) == zze2) {
                i++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v9, resolved type: java.lang.Integer} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzf(com.google.android.gms.internal.ads.zzyz[] r22, boolean[] r23, com.google.android.gms.internal.ads.zzwy[] r24, boolean[] r25, long r26) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r24
            int r3 = r1.length
            int[] r4 = new int[r3]
            int[] r3 = new int[r3]
            r5 = 0
            r6 = r5
        L_0x000d:
            int r7 = r1.length
            r8 = 0
            if (r6 >= r7) goto L_0x004a
            r7 = r2[r6]
            if (r7 != 0) goto L_0x0016
            goto L_0x001f
        L_0x0016:
            java.util.IdentityHashMap r8 = r0.zzb
            java.lang.Object r7 = r8.get(r7)
            r8 = r7
            java.lang.Integer r8 = (java.lang.Integer) r8
        L_0x001f:
            r7 = -1
            if (r8 != 0) goto L_0x0024
            r8 = r7
            goto L_0x0028
        L_0x0024:
            int r8 = r8.intValue()
        L_0x0028:
            r4[r6] = r8
            r8 = r1[r6]
            if (r8 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzcz r7 = r8.zze()
            java.lang.String r7 = r7.zzc
            java.lang.String r8 = ":"
            int r8 = r7.indexOf(r8)
            java.lang.String r7 = r7.substring(r5, r8)
            int r7 = java.lang.Integer.parseInt(r7)
            r3[r6] = r7
            goto L_0x0047
        L_0x0045:
            r3[r6] = r7
        L_0x0047:
            int r6 = r6 + 1
            goto L_0x000d
        L_0x004a:
            java.util.IdentityHashMap r6 = r0.zzb
            r6.clear()
            com.google.android.gms.internal.ads.zzvf[] r6 = r0.zza
            com.google.android.gms.internal.ads.zzwy[] r9 = new com.google.android.gms.internal.ads.zzwy[r7]
            com.google.android.gms.internal.ads.zzwy[] r15 = new com.google.android.gms.internal.ads.zzwy[r7]
            com.google.android.gms.internal.ads.zzyz[] r14 = new com.google.android.gms.internal.ads.zzyz[r7]
            java.util.ArrayList r13 = new java.util.ArrayList
            int r6 = r6.length
            r13.<init>(r6)
            r17 = r26
            r6 = r5
        L_0x0060:
            com.google.android.gms.internal.ads.zzvf[] r10 = r0.zza
            int r10 = r10.length
            if (r6 >= r10) goto L_0x00fe
            r10 = r5
        L_0x0066:
            int r11 = r1.length
            if (r10 >= r11) goto L_0x0099
            r11 = r4[r10]
            if (r11 != r6) goto L_0x0070
            r11 = r2[r10]
            goto L_0x0071
        L_0x0070:
            r11 = r8
        L_0x0071:
            r15[r10] = r11
            r11 = r3[r10]
            if (r11 != r6) goto L_0x0093
            r11 = r1[r10]
            r11.getClass()
            java.util.HashMap r12 = r0.zzd
            com.google.android.gms.internal.ads.zzcz r5 = r11.zze()
            java.lang.Object r5 = r12.get(r5)
            com.google.android.gms.internal.ads.zzcz r5 = (com.google.android.gms.internal.ads.zzcz) r5
            r5.getClass()
            com.google.android.gms.internal.ads.zzvv r12 = new com.google.android.gms.internal.ads.zzvv
            r12.<init>(r11, r5)
            r14[r10] = r12
            goto L_0x0095
        L_0x0093:
            r14[r10] = r8
        L_0x0095:
            int r10 = r10 + 1
            r5 = 0
            goto L_0x0066
        L_0x0099:
            com.google.android.gms.internal.ads.zzvf[] r5 = r0.zza
            r10 = r5[r6]
            r11 = r14
            r12 = r23
            r5 = r13
            r13 = r15
            r19 = r14
            r14 = r25
            r20 = r15
            r15 = r17
            long r10 = r10.zzf(r11, r12, r13, r14, r15)
            if (r6 != 0) goto L_0x00b3
            r17 = r10
            goto L_0x00b7
        L_0x00b3:
            int r10 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r10 != 0) goto L_0x00f6
        L_0x00b7:
            r10 = 0
            r11 = 0
        L_0x00b9:
            int r12 = r1.length
            if (r10 >= r12) goto L_0x00e3
            r12 = r3[r10]
            r13 = 1
            if (r12 != r6) goto L_0x00d3
            r11 = r20[r10]
            r11.getClass()
            r9[r10] = r11
            java.util.IdentityHashMap r12 = r0.zzb
            java.lang.Integer r14 = java.lang.Integer.valueOf(r6)
            r12.put(r11, r14)
            r11 = r13
            goto L_0x00e0
        L_0x00d3:
            r12 = r4[r10]
            if (r12 != r6) goto L_0x00e0
            r12 = r20[r10]
            if (r12 != 0) goto L_0x00dc
            goto L_0x00dd
        L_0x00dc:
            r13 = 0
        L_0x00dd:
            com.google.android.gms.internal.ads.zzek.zzf(r13)
        L_0x00e0:
            int r10 = r10 + 1
            goto L_0x00b9
        L_0x00e3:
            if (r11 == 0) goto L_0x00ec
            com.google.android.gms.internal.ads.zzvf[] r10 = r0.zza
            r10 = r10[r6]
            r5.add(r10)
        L_0x00ec:
            int r6 = r6 + 1
            r13 = r5
            r14 = r19
            r15 = r20
            r5 = 0
            goto L_0x0060
        L_0x00f6:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Children enabled at different positions."
            r1.<init>(r2)
            throw r1
        L_0x00fe:
            r1 = r5
            r5 = r13
            java.lang.System.arraycopy(r9, r1, r2, r1, r7)
            com.google.android.gms.internal.ads.zzvf[] r1 = new com.google.android.gms.internal.ads.zzvf[r1]
            java.lang.Object[] r1 = r5.toArray(r1)
            com.google.android.gms.internal.ads.zzvf[] r1 = (com.google.android.gms.internal.ads.zzvf[]) r1
            r0.zzg = r1
            com.google.android.gms.internal.ads.zzvu r1 = com.google.android.gms.internal.ads.zzvu.zza
            java.util.List r1 = com.google.android.gms.internal.ads.zzgad.zzb(r5, r1)
            com.google.android.gms.internal.ads.zzur r2 = new com.google.android.gms.internal.ads.zzur
            r2.<init>(r5, r1)
            r0.zzh = r2
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvw.zzf(com.google.android.gms.internal.ads.zzyz[], boolean[], com.google.android.gms.internal.ads.zzwy[], boolean[], long):long");
    }

    public final /* bridge */ /* synthetic */ void zzg(zzxa zzxa) {
        zzvf zzvf = (zzvf) zzxa;
        zzve zzve = this.zze;
        zzve.getClass();
        zzve.zzg(this);
    }

    public final zzxk zzh() {
        zzxk zzxk = this.zzf;
        zzxk.getClass();
        return zzxk;
    }

    public final void zzi(zzvf zzvf) {
        this.zzc.remove(zzvf);
        if (this.zzc.isEmpty()) {
            zzvf[] zzvfArr = this.zza;
            int i = 0;
            for (zzvf zzh2 : zzvfArr) {
                i += zzh2.zzh().zzc;
            }
            zzcz[] zzczArr = new zzcz[i];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                zzvf[] zzvfArr2 = this.zza;
                if (i2 < zzvfArr2.length) {
                    zzxk zzh3 = zzvfArr2[i2].zzh();
                    int i4 = zzh3.zzc;
                    int i5 = 0;
                    while (i5 < i4) {
                        zzcz zzb2 = zzh3.zzb(i5);
                        zzam[] zzamArr = new zzam[zzb2.zzb];
                        for (int i6 = 0; i6 < zzb2.zzb; i6++) {
                            zzam zzb3 = zzb2.zzb(i6);
                            zzak zzb4 = zzb3.zzb();
                            String str = zzb3.zzb;
                            if (str == null) {
                                str = "";
                            }
                            zzb4.zzK(i2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str);
                            zzamArr[i6] = zzb4.zzac();
                        }
                        zzcz zzcz = new zzcz(i2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + zzb2.zzc, zzamArr);
                        this.zzd.put(zzcz, zzb2);
                        zzczArr[i3] = zzcz;
                        i5++;
                        i3++;
                    }
                    i2++;
                } else {
                    this.zzf = new zzxk(zzczArr);
                    zzve zzve = this.zze;
                    zzve.getClass();
                    zzve.zzi(this);
                    return;
                }
            }
        }
    }

    public final void zzj(long j, boolean z) {
        for (zzvf zzj : this.zzg) {
            zzj.zzj(j, false);
        }
    }

    public final void zzk() throws IOException {
        int i = 0;
        while (true) {
            zzvf[] zzvfArr = this.zza;
            if (i < zzvfArr.length) {
                zzvfArr[i].zzk();
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzl(zzve zzve, long j) {
        this.zze = zzve;
        Collections.addAll(this.zzc, this.zza);
        int i = 0;
        while (true) {
            zzvf[] zzvfArr = this.zza;
            if (i < zzvfArr.length) {
                zzvfArr[i].zzl(this, j);
                i++;
            } else {
                return;
            }
        }
    }

    public final void zzm(long j) {
        this.zzh.zzm(j);
    }

    public final zzvf zzn(int i) {
        zzvf zzvf = this.zza[i];
        return zzvf instanceof zzxg ? ((zzxg) zzvf).zzn() : zzvf;
    }

    public final boolean zzo(zzlg zzlg) {
        if (this.zzc.isEmpty()) {
            return this.zzh.zzo(zzlg);
        }
        int size = this.zzc.size();
        for (int i = 0; i < size; i++) {
            ((zzvf) this.zzc.get(i)).zzo(zzlg);
        }
        return false;
    }

    public final boolean zzp() {
        return this.zzh.zzp();
    }
}
