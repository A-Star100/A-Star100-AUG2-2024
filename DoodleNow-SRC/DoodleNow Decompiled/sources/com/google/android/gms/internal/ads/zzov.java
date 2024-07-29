package com.google.android.gms.internal.ads;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzov implements zzoz {
    public static final zzfxh zza = zzot.zza;
    private static final Random zzb = new Random();
    /* access modifiers changed from: private */
    public final zzcw zzc;
    /* access modifiers changed from: private */
    public final zzcu zzd;
    private final HashMap zze;
    private final zzfxh zzf;
    private zzoy zzg;
    private zzcx zzh;
    private String zzi;
    private long zzj;

    public zzov() {
        this(zza);
    }

    /* access modifiers changed from: private */
    public final long zzl() {
        zzou zzou = (zzou) this.zze.get(this.zzi);
        return (zzou == null || zzou.zzd == -1) ? this.zzj + 1 : zzou.zzd;
    }

    private final zzou zzm(int i, zzvh zzvh) {
        int i2;
        long j = Long.MAX_VALUE;
        zzou zzou = null;
        for (zzou zzou2 : this.zze.values()) {
            zzou2.zzg(i, zzvh);
            if (zzou2.zzj(i, zzvh)) {
                long zzb2 = zzou2.zzd;
                if (zzb2 == -1 || zzb2 < j) {
                    zzou = zzou2;
                    j = zzb2;
                } else if (i2 == 0) {
                    int i3 = zzfx.zza;
                    if (!(zzou.zze == null || zzou2.zze == null)) {
                        zzou = zzou2;
                    }
                }
            }
        }
        if (zzou != null) {
            return zzou;
        }
        String zzn = zzn();
        zzou zzou3 = new zzou(this, zzn, i, zzvh);
        this.zze.put(zzn, zzou3);
        return zzou3;
    }

    /* access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzou zzou) {
        if (zzou.zzd != -1) {
            this.zzj = zzou.zzd;
        }
        this.zzi = null;
    }

    @RequiresNonNull({"listener"})
    private final void zzp(zzmq zzmq) {
        if (zzmq.zzb.zzo()) {
            String str = this.zzi;
            if (str != null) {
                zzou zzou = (zzou) this.zze.get(str);
                zzou.getClass();
                zzo(zzou);
                return;
            }
            return;
        }
        zzou zzou2 = (zzou) this.zze.get(this.zzi);
        zzou zzm = zzm(zzmq.zzc, zzmq.zzd);
        this.zzi = zzm.zzb;
        zzi(zzmq);
        zzvh zzvh = zzmq.zzd;
        if (zzvh != null && zzvh.zzb()) {
            if (zzou2 != null) {
                if (zzou2.zzd == zzvh.zzd && zzou2.zze != null && zzou2.zze.zzb == zzmq.zzd.zzb && zzou2.zze.zzc == zzmq.zzd.zzc) {
                    return;
                }
            }
            zzvh zzvh2 = zzmq.zzd;
            String unused = zzm(zzmq.zzc, new zzvh(zzvh2.zza, zzvh2.zzd)).zzb;
            String unused2 = zzm.zzb;
        }
    }

    public final synchronized String zze() {
        return this.zzi;
    }

    public final synchronized String zzf(zzcx zzcx, zzvh zzvh) {
        return zzm(zzcx.zzn(zzvh.zza, this.zzd).zzd, zzvh).zzb;
    }

    public final synchronized void zzg(zzmq zzmq) {
        zzoy zzoy;
        String str = this.zzi;
        if (str != null) {
            zzou zzou = (zzou) this.zze.get(str);
            zzou.getClass();
            zzo(zzou);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzou zzou2 = (zzou) it.next();
            it.remove();
            if (zzou2.zzf && (zzoy = this.zzg) != null) {
                zzoy.zzd(zzmq, zzou2.zzb, false);
            }
        }
    }

    public final void zzh(zzoy zzoy) {
        this.zzg = zzoy;
    }

    public zzov(zzfxh zzfxh) {
        this.zzf = zzfxh;
        this.zzc = new zzcw();
        this.zzd = new zzcu();
        this.zze = new HashMap();
        this.zzh = zzcx.zza;
        this.zzj = -1;
    }

    public final synchronized void zzj(zzmq zzmq, int i) {
        this.zzg.getClass();
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzou zzou = (zzou) it.next();
            if (zzou.zzk(zzmq)) {
                it.remove();
                if (zzou.zzf) {
                    boolean equals = zzou.zzb.equals(this.zzi);
                    boolean z = false;
                    if (i == 0 && equals && zzou.zzg) {
                        z = true;
                    }
                    if (equals) {
                        zzo(zzou);
                    }
                    this.zzg.zzd(zzmq, zzou.zzb, z);
                }
            }
        }
        zzp(zzmq);
    }

    public final synchronized void zzk(zzmq zzmq) {
        this.zzg.getClass();
        zzcx zzcx = this.zzh;
        this.zzh = zzmq.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzou zzou = (zzou) it.next();
            if (!zzou.zzl(zzcx, this.zzh) || zzou.zzk(zzmq)) {
                it.remove();
                if (zzou.zzf) {
                    if (zzou.zzb.equals(this.zzi)) {
                        zzo(zzou);
                    }
                    this.zzg.zzd(zzmq, zzou.zzb, false);
                }
            }
        }
        zzp(zzmq);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        if (r0.zzc == r10.zzc) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(com.google.android.gms.internal.ads.zzmq r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzoy r0 = r9.zzg     // Catch:{ all -> 0x00c6 }
            r0.getClass()
            com.google.android.gms.internal.ads.zzcx r0 = r10.zzb     // Catch:{ all -> 0x00c6 }
            boolean r0 = r0.zzo()     // Catch:{ all -> 0x00c6 }
            if (r0 == 0) goto L_0x0010
            goto L_0x00c4
        L_0x0010:
            com.google.android.gms.internal.ads.zzvh r0 = r10.zzd     // Catch:{ all -> 0x00c6 }
            if (r0 == 0) goto L_0x003c
            long r1 = r9.zzl()     // Catch:{ all -> 0x00c6 }
            long r3 = r0.zzd     // Catch:{ all -> 0x00c6 }
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00c4
            java.util.HashMap r0 = r9.zze     // Catch:{ all -> 0x00c6 }
            java.lang.String r1 = r9.zzi     // Catch:{ all -> 0x00c6 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzou r0 = (com.google.android.gms.internal.ads.zzou) r0     // Catch:{ all -> 0x00c6 }
            if (r0 == 0) goto L_0x003c
            long r1 = r0.zzd     // Catch:{ all -> 0x00c6 }
            r3 = -1
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x003c
            int r0 = r0.zzc     // Catch:{ all -> 0x00c6 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c6 }
            if (r0 != r1) goto L_0x00c4
        L_0x003c:
            int r0 = r10.zzc     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzvh r1 = r10.zzd     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzou r0 = r9.zzm(r0, r1)     // Catch:{ all -> 0x00c6 }
            java.lang.String r1 = r9.zzi     // Catch:{ all -> 0x00c6 }
            if (r1 != 0) goto L_0x004e
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c6 }
            r9.zzi = r1     // Catch:{ all -> 0x00c6 }
        L_0x004e:
            com.google.android.gms.internal.ads.zzvh r1 = r10.zzd     // Catch:{ all -> 0x00c6 }
            r2 = 1
            if (r1 == 0) goto L_0x0098
            boolean r3 = r1.zzb()     // Catch:{ all -> 0x00c6 }
            if (r3 == 0) goto L_0x0098
            java.lang.Object r3 = r1.zza     // Catch:{ all -> 0x00c6 }
            long r4 = r1.zzd     // Catch:{ all -> 0x00c6 }
            int r1 = r1.zzb     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzvh r6 = new com.google.android.gms.internal.ads.zzvh     // Catch:{ all -> 0x00c6 }
            r6.<init>(r3, r4, r1)     // Catch:{ all -> 0x00c6 }
            int r1 = r10.zzc     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzou r1 = r9.zzm(r1, r6)     // Catch:{ all -> 0x00c6 }
            boolean r3 = r1.zzf     // Catch:{ all -> 0x00c6 }
            if (r3 != 0) goto L_0x0098
            r1.zzf = true     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzcx r3 = r10.zzb     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzvh r4 = r10.zzd     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzcu r5 = r9.zzd     // Catch:{ all -> 0x00c6 }
            java.lang.Object r4 = r4.zza     // Catch:{ all -> 0x00c6 }
            r3.zzn(r4, r5)     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzcu r3 = r9.zzd     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzvh r4 = r10.zzd     // Catch:{ all -> 0x00c6 }
            int r4 = r4.zzb     // Catch:{ all -> 0x00c6 }
            r3.zzi(r4)     // Catch:{ all -> 0x00c6 }
            r3 = 0
            long r5 = com.google.android.gms.internal.ads.zzfx.zzu(r3)     // Catch:{ all -> 0x00c6 }
            long r7 = com.google.android.gms.internal.ads.zzfx.zzu(r3)     // Catch:{ all -> 0x00c6 }
            long r5 = r5 + r7
            java.lang.Math.max(r3, r5)     // Catch:{ all -> 0x00c6 }
            java.lang.String unused = r1.zzb     // Catch:{ all -> 0x00c6 }
        L_0x0098:
            boolean r1 = r0.zzf     // Catch:{ all -> 0x00c6 }
            if (r1 != 0) goto L_0x00a4
            r0.zzf = true     // Catch:{ all -> 0x00c6 }
            java.lang.String unused = r0.zzb     // Catch:{ all -> 0x00c6 }
        L_0x00a4:
            java.lang.String r1 = r0.zzb     // Catch:{ all -> 0x00c6 }
            java.lang.String r3 = r9.zzi     // Catch:{ all -> 0x00c6 }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x00c6 }
            if (r1 == 0) goto L_0x00c4
            boolean r1 = r0.zzg     // Catch:{ all -> 0x00c6 }
            if (r1 != 0) goto L_0x00c4
            r0.zzg = true     // Catch:{ all -> 0x00c6 }
            com.google.android.gms.internal.ads.zzoy r1 = r9.zzg     // Catch:{ all -> 0x00c6 }
            java.lang.String r0 = r0.zzb     // Catch:{ all -> 0x00c6 }
            r1.zzc(r10, r0)     // Catch:{ all -> 0x00c6 }
            monitor-exit(r9)
            return
        L_0x00c4:
            monitor-exit(r9)
            return
        L_0x00c6:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzov.zzi(com.google.android.gms.internal.ads.zzmq):void");
    }
}
