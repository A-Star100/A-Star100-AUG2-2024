package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaow implements zzadf {
    @Deprecated
    public static final zzadm zza = zzaot.zza;
    /* access modifiers changed from: private */
    public final List zzb;
    private final zzfo zzc;
    private final SparseIntArray zzd;
    /* access modifiers changed from: private */
    public final zzaoz zze;
    private final zzalf zzf;
    /* access modifiers changed from: private */
    public final SparseArray zzg;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzh;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzi;
    private final zzaos zzj;
    private zzaor zzk;
    /* access modifiers changed from: private */
    public zzadi zzl;
    /* access modifiers changed from: private */
    public int zzm;
    /* access modifiers changed from: private */
    public boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    /* access modifiers changed from: private */
    public int zzr;

    @Deprecated
    public zzaow() {
        this(1, 1, zzalf.zza, new zzfv(0), new zzanl(0), TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b3, code lost:
        if (r1 == false) goto L_0x01b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzadg r19, com.google.android.gms.internal.ads.zzaec r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            long r11 = r19.zzd()
            boolean r3 = r0.zzn
            r13 = -1
            r15 = 1
            r10 = 0
            if (r3 == 0) goto L_0x009e
            int r3 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r3 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzaos r3 = r0.zzj
            boolean r4 = r3.zzd()
            if (r4 == 0) goto L_0x001f
            goto L_0x0026
        L_0x001f:
            int r4 = r0.zzr
            int r1 = r3.zza(r1, r2, r4)
            return r1
        L_0x0026:
            boolean r3 = r0.zzo
            r7 = 0
            if (r3 != 0) goto L_0x0075
            r0.zzo = r15
            com.google.android.gms.internal.ads.zzaos r3 = r0.zzj
            long r4 = r3.zzb()
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r4 == 0) goto L_0x0065
            com.google.android.gms.internal.ads.zzaor r9 = new com.google.android.gms.internal.ads.zzaor
            com.google.android.gms.internal.ads.zzfv r4 = r3.zzc()
            long r5 = r3.zzb()
            int r3 = r0.zzr
            r16 = 112800(0x1b8a0, float:1.58066E-40)
            r17 = r3
            r3 = r9
            r13 = r7
            r7 = r11
            r15 = r9
            r9 = r17
            r10 = r16
            r3.<init>(r4, r5, r7, r9, r10)
            r0.zzk = r15
            com.google.android.gms.internal.ads.zzadi r3 = r0.zzl
            com.google.android.gms.internal.ads.zzaef r4 = r15.zzb()
            r3.zzO(r4)
            goto L_0x0076
        L_0x0065:
            r13 = r7
            com.google.android.gms.internal.ads.zzadi r4 = r0.zzl
            com.google.android.gms.internal.ads.zzaee r5 = new com.google.android.gms.internal.ads.zzaee
            long r6 = r3.zzb()
            r5.<init>(r6, r13)
            r4.zzO(r5)
            goto L_0x0076
        L_0x0075:
            r13 = r7
        L_0x0076:
            boolean r3 = r0.zzp
            if (r3 == 0) goto L_0x008d
            r3 = 0
            r0.zzp = r3
            r0.zze(r13, r13)
            long r4 = r19.zzf()
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x0089
            goto L_0x008e
        L_0x0089:
            r2.zza = r13
            r1 = 1
            return r1
        L_0x008d:
            r3 = 0
        L_0x008e:
            com.google.android.gms.internal.ads.zzaor r4 = r0.zzk
            if (r4 == 0) goto L_0x009f
            boolean r5 = r4.zze()
            if (r5 != 0) goto L_0x0099
            goto L_0x009f
        L_0x0099:
            int r1 = r4.zza(r1, r2)
            return r1
        L_0x009e:
            r3 = r10
        L_0x009f:
            com.google.android.gms.internal.ads.zzfo r2 = r0.zzc
            byte[] r4 = r2.zzM()
            int r5 = r2.zzd()
            int r5 = 9400 - r5
            r6 = 188(0xbc, float:2.63E-43)
            if (r5 < r6) goto L_0x00b0
            goto L_0x00c2
        L_0x00b0:
            int r5 = r2.zzb()
            if (r5 <= 0) goto L_0x00bd
            int r2 = r2.zzd()
            java.lang.System.arraycopy(r4, r2, r4, r3, r5)
        L_0x00bd:
            com.google.android.gms.internal.ads.zzfo r2 = r0.zzc
            r2.zzI(r4, r5)
        L_0x00c2:
            com.google.android.gms.internal.ads.zzfo r2 = r0.zzc
            int r5 = r2.zzb()
            r7 = -1
            if (r5 >= r6) goto L_0x0100
            int r2 = r2.zze()
            int r5 = 9400 - r2
            int r5 = r1.zza(r4, r2, r5)
            if (r5 != r7) goto L_0x00f9
            r10 = r3
        L_0x00d8:
            android.util.SparseArray r1 = r0.zzg
            int r1 = r1.size()
            if (r10 >= r1) goto L_0x00f8
            android.util.SparseArray r1 = r0.zzg
            java.lang.Object r1 = r1.valueAt(r10)
            com.google.android.gms.internal.ads.zzapb r1 = (com.google.android.gms.internal.ads.zzapb) r1
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzaof
            if (r2 == 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzfo r2 = new com.google.android.gms.internal.ads.zzfo
            r2.<init>()
            r3 = 1
            r1.zza(r2, r3)
        L_0x00f5:
            int r10 = r10 + 1
            goto L_0x00d8
        L_0x00f8:
            return r7
        L_0x00f9:
            com.google.android.gms.internal.ads.zzfo r7 = r0.zzc
            int r2 = r2 + r5
            r7.zzJ(r2)
            goto L_0x00c2
        L_0x0100:
            int r1 = r2.zzd()
            int r4 = r2.zze()
            byte[] r2 = r2.zzM()
            int r2 = com.google.android.gms.internal.ads.zzapc.zza(r2, r1, r4)
            com.google.android.gms.internal.ads.zzfo r5 = r0.zzc
            r5.zzK(r2)
            int r5 = r2 + 188
            if (r5 <= r4) goto L_0x0120
            int r4 = r0.zzq
            int r2 = r2 - r1
            int r4 = r4 + r2
            r0.zzq = r4
            goto L_0x0122
        L_0x0120:
            r0.zzq = r3
        L_0x0122:
            com.google.android.gms.internal.ads.zzfo r1 = r0.zzc
            int r2 = r1.zze()
            if (r5 <= r2) goto L_0x012b
            return r3
        L_0x012b:
            int r1 = r1.zzg()
            r4 = 8388608(0x800000, float:1.17549435E-38)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x013a
            com.google.android.gms.internal.ads.zzfo r1 = r0.zzc
            r1.zzK(r5)
            return r3
        L_0x013a:
            r4 = 4194304(0x400000, float:5.877472E-39)
            r4 = r4 & r1
            if (r4 == 0) goto L_0x0141
            r10 = 1
            goto L_0x0142
        L_0x0141:
            r10 = r3
        L_0x0142:
            int r4 = r1 >> 8
            r6 = r1 & 32
            r8 = r1 & 16
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            if (r8 == 0) goto L_0x0155
            android.util.SparseArray r8 = r0.zzg
            java.lang.Object r8 = r8.get(r4)
            com.google.android.gms.internal.ads.zzapb r8 = (com.google.android.gms.internal.ads.zzapb) r8
            goto L_0x0156
        L_0x0155:
            r8 = 0
        L_0x0156:
            if (r8 != 0) goto L_0x015e
            com.google.android.gms.internal.ads.zzfo r1 = r0.zzc
            r1.zzK(r5)
            return r3
        L_0x015e:
            r1 = r1 & 15
            android.util.SparseIntArray r9 = r0.zzd
            int r13 = r1 + -1
            int r9 = r9.get(r4, r13)
            android.util.SparseIntArray r13 = r0.zzd
            r13.put(r4, r1)
            if (r9 != r1) goto L_0x0175
            com.google.android.gms.internal.ads.zzfo r1 = r0.zzc
            r1.zzK(r5)
            return r3
        L_0x0175:
            r13 = 1
            int r9 = r9 + r13
            r9 = r9 & 15
            if (r1 == r9) goto L_0x017e
            r8.zzc()
        L_0x017e:
            if (r6 == 0) goto L_0x0198
            com.google.android.gms.internal.ads.zzfo r1 = r0.zzc
            int r6 = r1.zzm()
            int r1 = r1.zzm()
            r1 = r1 & 64
            if (r1 == 0) goto L_0x0190
            r1 = 2
            goto L_0x0191
        L_0x0190:
            r1 = r3
        L_0x0191:
            r10 = r10 | r1
            com.google.android.gms.internal.ads.zzfo r1 = r0.zzc
            int r6 = r6 + r7
            r1.zzL(r6)
        L_0x0198:
            boolean r1 = r0.zzn
            if (r1 != 0) goto L_0x01a4
            android.util.SparseBooleanArray r6 = r0.zzi
            boolean r4 = r6.get(r4, r3)
            if (r4 != 0) goto L_0x01b5
        L_0x01a4:
            com.google.android.gms.internal.ads.zzfo r4 = r0.zzc
            r4.zzJ(r5)
            com.google.android.gms.internal.ads.zzfo r4 = r0.zzc
            r8.zza(r4, r10)
            com.google.android.gms.internal.ads.zzfo r4 = r0.zzc
            r4.zzJ(r2)
            if (r1 != 0) goto L_0x01c2
        L_0x01b5:
            boolean r1 = r0.zzn
            if (r1 == 0) goto L_0x01c2
            r1 = -1
            int r1 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x01c2
            r1 = 1
            r0.zzp = r1
        L_0x01c2:
            com.google.android.gms.internal.ads.zzfo r1 = r0.zzc
            r1.zzK(r5)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaow.zzb(com.google.android.gms.internal.ads.zzadg, com.google.android.gms.internal.ads.zzaec):int");
    }

    public final /* synthetic */ List zzc() {
        return zzfzn.zzm();
    }

    public final void zzd(zzadi zzadi) {
        this.zzl = zzadi;
    }

    public final void zze(long j, long j2) {
        zzaor zzaor;
        int size = this.zzb.size();
        for (int i = 0; i < size; i++) {
            zzfv zzfv = (zzfv) this.zzb.get(i);
            if (zzfv.zzf() != C.TIME_UNSET) {
                long zzd2 = zzfv.zzd();
                if (zzd2 != C.TIME_UNSET) {
                    if (zzd2 != 0) {
                        if (zzd2 == j2) {
                        }
                    }
                }
            }
            zzfv.zzi(j2);
        }
        if (!(j2 == 0 || (zzaor = this.zzk) == null)) {
            zzaor.zzd(j2);
        }
        this.zzc.zzH(0);
        this.zzd.clear();
        for (int i2 = 0; i2 < this.zzg.size(); i2++) {
            ((zzapb) this.zzg.valueAt(i2)).zzc();
        }
        this.zzq = 0;
    }

    public final boolean zzf(zzadg zzadg) throws IOException {
        byte[] zzM = this.zzc.zzM();
        zzact zzact = (zzact) zzadg;
        zzact.zzm(zzM, 0, 940, false);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 < 5) {
                if (zzM[(i2 * TsExtractor.TS_PACKET_SIZE) + i] != 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            zzact.zzo(i, false);
            return true;
        }
        return false;
    }

    public zzaow(int i, int i2, zzalf zzalf, zzfv zzfv, zzaoz zzaoz, int i3) {
        this.zze = zzaoz;
        this.zzf = zzalf;
        this.zzb = Collections.singletonList(zzfv);
        this.zzc = new zzfo(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzaos(TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
        this.zzl = zzadi.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(sparseArray2.keyAt(i4), (zzapb) sparseArray2.valueAt(i4));
        }
        this.zzg.put(0, new zzaoo(new zzaou(this)));
    }
}
