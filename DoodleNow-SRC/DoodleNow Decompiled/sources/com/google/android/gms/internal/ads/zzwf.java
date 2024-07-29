package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzwf implements zzzx, zzuw {
    final /* synthetic */ zzwk zza;
    /* access modifiers changed from: private */
    public final long zzb = zzuy.zza();
    private final Uri zzc;
    /* access modifiers changed from: private */
    public final zzhx zzd;
    private final zzvz zze;
    private final zzadi zzf;
    private final zzeo zzg;
    private final zzaec zzh = new zzaec();
    private volatile boolean zzi;
    private boolean zzj = true;
    /* access modifiers changed from: private */
    public long zzk;
    /* access modifiers changed from: private */
    public zzhb zzl = zzi(0);
    private zzaem zzm;
    private boolean zzn;

    public zzwf(zzwk zzwk, Uri uri, zzgv zzgv, zzvz zzvz, zzadi zzadi, zzeo zzeo) {
        this.zza = zzwk;
        this.zzc = uri;
        this.zzd = new zzhx(zzgv);
        this.zze = zzvz;
        this.zzf = zzadi;
        this.zzg = zzeo;
    }

    static /* bridge */ /* synthetic */ void zzf(zzwf zzwf, long j, long j2) {
        zzwf.zzh.zza = j;
        zzwf.zzk = j2;
        zzwf.zzj = true;
        zzwf.zzn = false;
    }

    private final zzhb zzi(long j) {
        zzgz zzgz = new zzgz();
        zzgz.zzd(this.zzc);
        zzgz.zzc(j);
        zzgz.zza(6);
        zzgz.zzb(zzwk.zzb);
        return zzgz.zze();
    }

    public final void zza(zzfo zzfo) {
        long max = !this.zzn ? this.zzk : Math.max(this.zza.zzR(true), this.zzk);
        int zzb2 = zzfo.zzb();
        zzaem zzaem = this.zzm;
        zzaem.getClass();
        zzaek.zzb(zzaem, zzfo, zzb2);
        zzaem.zzs(max, 1, zzb2, 0, (zzael) null);
        this.zzn = true;
    }

    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(20:59|60|63|64|(0)|68|(0)(0)|74|75|76|77|(0)|80|(0)(0)|88|(2:(0)(0)|129)|105|(0)(0)|112|(0)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0120 */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0228 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01e3 A[EDGE_INSN: B:130:0x01e3->B:105:0x01e3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009e A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a8 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00be A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d4 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e0 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f0 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fc A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0132 A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x014e A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x016a A[Catch:{ all -> 0x0208 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0186 A[Catch:{ all -> 0x0205 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018f A[Catch:{ all -> 0x0205 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01a2 A[SYNTHETIC, Splitter:B:90:0x01a2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh() throws java.io.IOException {
        /*
            r24 = this;
            r1 = r24
            java.lang.String r0 = "Invalid metadata interval: "
        L_0x0004:
            boolean r2 = r1.zzi
            if (r2 != 0) goto L_0x0228
            r2 = -1
            r5 = 0
            com.google.android.gms.internal.ads.zzaec r6 = r1.zzh     // Catch:{ all -> 0x0208 }
            long r13 = r6.zza     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzhb r6 = r1.zzi(r13)     // Catch:{ all -> 0x0208 }
            r1.zzl = r6     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzhx r7 = r1.zzd     // Catch:{ all -> 0x0208 }
            long r6 = r7.zzb(r6)     // Catch:{ all -> 0x0208 }
            boolean r8 = r1.zzi     // Catch:{ all -> 0x0208 }
            if (r8 == 0) goto L_0x0037
            com.google.android.gms.internal.ads.zzvz r0 = r1.zze
            long r4 = r0.zzb()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzaec r2 = r1.zzh
            long r3 = r0.zzb()
            r2.zza = r3
        L_0x0031:
            com.google.android.gms.internal.ads.zzhx r0 = r1.zzd
            com.google.android.gms.internal.ads.zzgx.zza(r0)
            return
        L_0x0037:
            int r8 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0041
            long r6 = r6 + r13
            com.google.android.gms.internal.ads.zzwk r8 = r1.zza     // Catch:{ all -> 0x0208 }
            r8.zzp.post(new com.google.android.gms.internal.ads.zzwa(r8))     // Catch:{ all -> 0x0208 }
        L_0x0041:
            r15 = r6
            com.google.android.gms.internal.ads.zzwk r6 = r1.zza     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzhx r7 = r1.zzd     // Catch:{ all -> 0x0208 }
            java.util.Map r7 = r7.zze()     // Catch:{ all -> 0x0208 }
            java.lang.String r8 = "icy-br"
            java.lang.Object r8 = r7.get(r8)     // Catch:{ all -> 0x0208 }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x0208 }
            java.lang.String r9 = "IcyHeaders"
            r10 = -1
            if (r8 == 0) goto L_0x0090
            java.lang.Object r8 = r8.get(r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0208 }
            int r11 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x007e }
            int r11 = r11 * 1000
            if (r11 <= 0) goto L_0x0069
            r18 = r11
            r2 = 1
            goto L_0x0093
        L_0x0069:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x007f }
            r12.<init>()     // Catch:{ NumberFormatException -> 0x007f }
            java.lang.String r2 = "Invalid bitrate: "
            r12.append(r2)     // Catch:{ NumberFormatException -> 0x007f }
            r12.append(r8)     // Catch:{ NumberFormatException -> 0x007f }
            java.lang.String r2 = r12.toString()     // Catch:{ NumberFormatException -> 0x007f }
            com.google.android.gms.internal.ads.zzfe.zzf(r9, r2)     // Catch:{ NumberFormatException -> 0x007f }
            goto L_0x0090
        L_0x007e:
            r11 = r10
        L_0x007f:
            java.lang.String r2 = "Invalid bitrate header: "
            java.lang.String r3 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzfe.zzf(r9, r2)     // Catch:{ all -> 0x0208 }
            r2 = r5
            r18 = r11
            goto L_0x0093
        L_0x0090:
            r2 = r5
            r18 = r10
        L_0x0093:
            java.lang.String r3 = "icy-genre"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x0208 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0208 }
            r8 = 0
            if (r3 == 0) goto L_0x00a8
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0208 }
            r19 = r2
            r2 = 1
            goto L_0x00aa
        L_0x00a8:
            r19 = r8
        L_0x00aa:
            java.lang.String r3 = "icy-name"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x0208 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0208 }
            if (r3 == 0) goto L_0x00be
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0208 }
            r20 = r2
            r2 = 1
            goto L_0x00c0
        L_0x00be:
            r20 = r8
        L_0x00c0:
            java.lang.String r3 = "icy-url"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x0208 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0208 }
            if (r3 == 0) goto L_0x00d4
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0208 }
            r21 = r2
            r2 = 1
            goto L_0x00d6
        L_0x00d4:
            r21 = r8
        L_0x00d6:
            java.lang.String r3 = "icy-pub"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x0208 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0208 }
            if (r3 == 0) goto L_0x00f0
            java.lang.Object r2 = r3.get(r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0208 }
            r22 = r2
            r2 = 1
            goto L_0x00f2
        L_0x00f0:
            r22 = r5
        L_0x00f2:
            java.lang.String r3 = "icy-metaint"
            java.lang.Object r3 = r7.get(r3)     // Catch:{ all -> 0x0208 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0208 }
            if (r3 == 0) goto L_0x012e
            java.lang.Object r3 = r3.get(r5)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0208 }
            int r7 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x011f }
            if (r7 <= 0) goto L_0x010c
            r23 = r7
            r2 = 1
            goto L_0x0130
        L_0x010c:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0120 }
            r11.<init>()     // Catch:{ NumberFormatException -> 0x0120 }
            r11.append(r0)     // Catch:{ NumberFormatException -> 0x0120 }
            r11.append(r3)     // Catch:{ NumberFormatException -> 0x0120 }
            java.lang.String r11 = r11.toString()     // Catch:{ NumberFormatException -> 0x0120 }
            com.google.android.gms.internal.ads.zzfe.zzf(r9, r11)     // Catch:{ NumberFormatException -> 0x0120 }
            goto L_0x012e
        L_0x011f:
            r7 = r10
        L_0x0120:
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0208 }
            java.lang.String r3 = r0.concat(r3)     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzfe.zzf(r9, r3)     // Catch:{ all -> 0x0208 }
            r23 = r7
            goto L_0x0130
        L_0x012e:
            r23 = r10
        L_0x0130:
            if (r2 == 0) goto L_0x0139
            com.google.android.gms.internal.ads.zzagm r8 = new com.google.android.gms.internal.ads.zzagm     // Catch:{ all -> 0x0208 }
            r17 = r8
            r17.<init>(r18, r19, r20, r21, r22, r23)     // Catch:{ all -> 0x0208 }
        L_0x0139:
            r6.zzs = r8     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzhx r2 = r1.zzd     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzwk r3 = r1.zza     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzagm r6 = r3.zzs     // Catch:{ all -> 0x0208 }
            if (r6 == 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzagm r6 = r3.zzs     // Catch:{ all -> 0x0208 }
            int r6 = r6.zzf     // Catch:{ all -> 0x0208 }
            if (r6 == r10) goto L_0x016a
            com.google.android.gms.internal.ads.zzux r6 = new com.google.android.gms.internal.ads.zzux     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzagm r3 = r3.zzs     // Catch:{ all -> 0x0208 }
            int r3 = r3.zzf     // Catch:{ all -> 0x0208 }
            r6.<init>(r2, r3, r1)     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzwk r2 = r1.zza     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzaem r2 = r2.zzv()     // Catch:{ all -> 0x0208 }
            r1.zzm = r2     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzam r3 = com.google.android.gms.internal.ads.zzwk.zzc     // Catch:{ all -> 0x0208 }
            r2.zzl(r3)     // Catch:{ all -> 0x0208 }
            r8 = r6
            goto L_0x016b
        L_0x016a:
            r8 = r2
        L_0x016b:
            com.google.android.gms.internal.ads.zzvz r7 = r1.zze     // Catch:{ all -> 0x0208 }
            android.net.Uri r9 = r1.zzc     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzhx r2 = r1.zzd     // Catch:{ all -> 0x0208 }
            java.util.Map r10 = r2.zze()     // Catch:{ all -> 0x0208 }
            com.google.android.gms.internal.ads.zzadi r2 = r1.zzf     // Catch:{ all -> 0x0208 }
            r11 = r13
            r4 = r13
            r13 = r15
            r15 = r2
            r7.zzd(r8, r9, r10, r11, r13, r15)     // Catch:{ all -> 0x0205 }
            com.google.android.gms.internal.ads.zzwk r2 = r1.zza     // Catch:{ all -> 0x0205 }
            com.google.android.gms.internal.ads.zzagm r2 = r2.zzs     // Catch:{ all -> 0x0205 }
            if (r2 == 0) goto L_0x018b
            com.google.android.gms.internal.ads.zzvz r2 = r1.zze     // Catch:{ all -> 0x0205 }
            r2.zzc()     // Catch:{ all -> 0x0205 }
        L_0x018b:
            boolean r2 = r1.zzj     // Catch:{ all -> 0x0205 }
            if (r2 == 0) goto L_0x019d
            com.google.android.gms.internal.ads.zzvz r2 = r1.zze     // Catch:{ all -> 0x0205 }
            long r7 = r1.zzk     // Catch:{ all -> 0x0205 }
            r2.zzf(r4, r7)     // Catch:{ all -> 0x0205 }
            r2 = 0
            r1.zzj = r2     // Catch:{ all -> 0x019a }
            goto L_0x019e
        L_0x019a:
            r0 = move-exception
            goto L_0x020a
        L_0x019d:
            r2 = 0
        L_0x019e:
            r13 = r4
            r4 = r2
        L_0x01a0:
            if (r4 != 0) goto L_0x01e3
            boolean r5 = r1.zzi     // Catch:{ all -> 0x01e0 }
            if (r5 != 0) goto L_0x01de
            com.google.android.gms.internal.ads.zzeo r5 = r1.zzg     // Catch:{ InterruptedException -> 0x01d8 }
            r5.zza()     // Catch:{ InterruptedException -> 0x01d8 }
            com.google.android.gms.internal.ads.zzvz r5 = r1.zze     // Catch:{ all -> 0x01e0 }
            com.google.android.gms.internal.ads.zzaec r6 = r1.zzh     // Catch:{ all -> 0x01e0 }
            int r4 = r5.zza(r6)     // Catch:{ all -> 0x01e0 }
            com.google.android.gms.internal.ads.zzvz r5 = r1.zze     // Catch:{ all -> 0x01e0 }
            long r5 = r5.zzb()     // Catch:{ all -> 0x01e0 }
            com.google.android.gms.internal.ads.zzwk r7 = r1.zza     // Catch:{ all -> 0x01e0 }
            long r7 = r7.zzj     // Catch:{ all -> 0x01e0 }
            long r7 = r7 + r13
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x01a0
            com.google.android.gms.internal.ads.zzeo r7 = r1.zzg     // Catch:{ all -> 0x01e0 }
            r7.zzc()     // Catch:{ all -> 0x01e0 }
            com.google.android.gms.internal.ads.zzwk r7 = r1.zza     // Catch:{ all -> 0x01e0 }
            android.os.Handler r8 = r7.zzp     // Catch:{ all -> 0x01e0 }
            java.lang.Runnable r7 = r7.zzo     // Catch:{ all -> 0x01e0 }
            r8.post(r7)     // Catch:{ all -> 0x01e0 }
            r13 = r5
            goto L_0x01a0
        L_0x01d8:
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch:{ all -> 0x01e0 }
            r0.<init>()     // Catch:{ all -> 0x01e0 }
            throw r0     // Catch:{ all -> 0x01e0 }
        L_0x01de:
            r4 = r2
            goto L_0x01e3
        L_0x01e0:
            r0 = move-exception
            r5 = r4
            goto L_0x020b
        L_0x01e3:
            r3 = 1
            if (r4 != r3) goto L_0x01e8
            r5 = r2
            goto L_0x01fd
        L_0x01e8:
            com.google.android.gms.internal.ads.zzvz r2 = r1.zze
            long r5 = r2.zzb()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x01fc
            com.google.android.gms.internal.ads.zzaec r3 = r1.zzh
            long r5 = r2.zzb()
            r3.zza = r5
        L_0x01fc:
            r5 = r4
        L_0x01fd:
            com.google.android.gms.internal.ads.zzhx r2 = r1.zzd
            com.google.android.gms.internal.ads.zzgx.zza(r2)
            if (r5 == 0) goto L_0x0004
            goto L_0x0228
        L_0x0205:
            r0 = move-exception
            r2 = 0
            goto L_0x020a
        L_0x0208:
            r0 = move-exception
            r2 = r5
        L_0x020a:
            r5 = r2
        L_0x020b:
            r2 = 1
            if (r5 == r2) goto L_0x0222
            com.google.android.gms.internal.ads.zzvz r2 = r1.zze
            long r3 = r2.zzb()
            r5 = -1
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0222
            com.google.android.gms.internal.ads.zzaec r3 = r1.zzh
            long r4 = r2.zzb()
            r3.zza = r4
        L_0x0222:
            com.google.android.gms.internal.ads.zzhx r2 = r1.zzd
            com.google.android.gms.internal.ads.zzgx.zza(r2)
            throw r0
        L_0x0228:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwf.zzh():void");
    }
}
