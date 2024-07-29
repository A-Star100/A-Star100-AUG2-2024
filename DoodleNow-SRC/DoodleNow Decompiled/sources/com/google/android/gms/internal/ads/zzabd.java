package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzabd {
    private final zzabc zza;
    private final zzabh zzb;
    private boolean zzc;
    private int zzd = 0;
    private long zze = C.TIME_UNSET;
    private long zzf;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private float zzi = 1.0f;
    private zzel zzj = zzel.zza;

    public zzabd(Context context, zzabc zzabc, long j) {
        this.zza = zzabc;
        this.zzb = new zzabh(context);
    }

    private final void zzq(int i) {
        this.zzd = Math.min(this.zzd, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0071, code lost:
        if (r15 > 100000) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        if (r3 >= r26) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0081, code lost:
        if (r0.zzc != false) goto L_0x0083;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(long r20, long r22, long r24, long r26, boolean r28, com.google.android.gms.internal.ads.zzabb r29) throws com.google.android.gms.internal.ads.zziz {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r22
            r5 = r29
            com.google.android.gms.internal.ads.zzabb.zzg(r29)
            long r6 = r0.zze
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x0018
            r0.zze = r3
        L_0x0018:
            long r6 = r0.zzg
            int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzabh r6 = r0.zzb
            r6.zzd(r1)
            r0.zzg = r1
        L_0x0025:
            long r1 = r1 - r3
            float r6 = r0.zzi
            double r6 = (double) r6
            boolean r10 = r0.zzc
            double r1 = (double) r1
            double r1 = r1 / r6
            long r1 = (long) r1
            if (r10 == 0) goto L_0x003b
            long r6 = android.os.SystemClock.elapsedRealtime()
            long r6 = com.google.android.gms.internal.ads.zzfx.zzr(r6)
            long r6 = r6 - r24
            long r1 = r1 - r6
        L_0x003b:
            r5.zza = r1
            long r1 = r29.zza
            long r6 = r0.zzh
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            r10 = -30000(0xffffffffffff8ad0, double:NaN)
            r7 = 0
            r12 = 3
            r13 = 2
            r14 = 1
            if (r6 == 0) goto L_0x004f
            goto L_0x0084
        L_0x004f:
            int r6 = r0.zzd
            if (r6 == 0) goto L_0x007f
            if (r6 == r14) goto L_0x0083
            if (r6 == r13) goto L_0x007a
            if (r6 != r12) goto L_0x0074
            long r15 = android.os.SystemClock.elapsedRealtime()
            long r15 = com.google.android.gms.internal.ads.zzfx.zzr(r15)
            long r13 = r0.zzf
            long r15 = r15 - r13
            boolean r6 = r0.zzc
            if (r6 == 0) goto L_0x0084
            int r1 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0084
            r1 = 100000(0x186a0, double:4.94066E-319)
            int r1 = (r15 > r1 ? 1 : (r15 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0084
            goto L_0x0083
        L_0x0074:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x007a:
            int r1 = (r3 > r26 ? 1 : (r3 == r26 ? 0 : -1))
            if (r1 < 0) goto L_0x0084
            goto L_0x0083
        L_0x007f:
            boolean r1 = r0.zzc
            if (r1 == 0) goto L_0x0084
        L_0x0083:
            return r7
        L_0x0084:
            boolean r1 = r0.zzc
            r2 = 5
            if (r1 == 0) goto L_0x00f1
            long r13 = r0.zze
            int r1 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r1 != 0) goto L_0x0090
            goto L_0x00f1
        L_0x0090:
            com.google.android.gms.internal.ads.zzabh r1 = r0.zzb
            long r13 = java.lang.System.nanoTime()
            long r15 = r29.zza
            r17 = 1000(0x3e8, double:4.94E-321)
            long r15 = r15 * r17
            long r10 = r13 + r15
            long r10 = r1.zza(r10)
            r5.zzb = r10
            long r10 = r29.zzb
            long r10 = r10 - r13
            long r10 = r10 / r17
            r5.zza = r10
            long r10 = r0.zzh
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x00b8
            r7 = 1
        L_0x00b8:
            com.google.android.gms.internal.ads.zzabc r1 = r0.zza
            long r8 = r29.zza
            r10 = -500000(0xfffffffffff85ee0, double:NaN)
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 >= 0) goto L_0x00d2
            if (r28 != 0) goto L_0x00d2
            com.google.android.gms.internal.ads.zzaaw r1 = (com.google.android.gms.internal.ads.zzaaw) r1
            boolean r1 = r1.zzaN(r3, r7)
            if (r1 != 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r1 = 4
            return r1
        L_0x00d2:
            long r3 = r29.zza
            r8 = -30000(0xffffffffffff8ad0, double:NaN)
            int r1 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x00e3
            if (r28 != 0) goto L_0x00e3
            if (r7 == 0) goto L_0x00e1
            return r12
        L_0x00e1:
            r1 = 2
            return r1
        L_0x00e3:
            long r3 = r29.zza
            r5 = 50000(0xc350, double:2.47033E-319)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ef
            return r2
        L_0x00ef:
            r1 = 1
            return r1
        L_0x00f1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabd.zza(long, long, long, long, boolean, com.google.android.gms.internal.ads.zzabb):int");
    }

    public final void zzb() {
        if (this.zzd == 0) {
            this.zzd = 1;
        }
    }

    public final void zzc() {
        this.zzh = C.TIME_UNSET;
    }

    public final void zzd() {
        zzq(0);
    }

    public final void zze(boolean z) {
        this.zzd = z ? 1 : 0;
    }

    public final void zzf() {
        zzq(2);
    }

    public final void zzg() {
        this.zzc = true;
        this.zzf = zzfx.zzr(SystemClock.elapsedRealtime());
        this.zzb.zzg();
    }

    public final void zzh() {
        this.zzc = false;
        this.zzh = C.TIME_UNSET;
        this.zzb.zzh();
    }

    public final void zzi() {
        this.zzb.zzf();
        this.zzg = C.TIME_UNSET;
        this.zze = C.TIME_UNSET;
        zzq(1);
        this.zzh = C.TIME_UNSET;
    }

    public final void zzj(int i) {
        this.zzb.zzj(i);
    }

    public final void zzk(zzel zzel) {
        this.zzj = zzel;
    }

    public final void zzl(float f) {
        this.zzb.zzc(f);
    }

    public final void zzm(Surface surface) {
        this.zzb.zzi(surface);
        zzq(1);
    }

    public final void zzn(float f) {
        this.zzi = f;
        this.zzb.zze(f);
    }

    public final boolean zzo(boolean z) {
        boolean z2 = true;
        if (!z || this.zzd != 3) {
            if (this.zzh == C.TIME_UNSET) {
                return false;
            }
            if (SystemClock.elapsedRealtime() >= this.zzh) {
                z2 = false;
            }
            return z2;
        }
        this.zzh = C.TIME_UNSET;
        return z2;
    }

    public final boolean zzp() {
        int i = this.zzd;
        this.zzd = 3;
        this.zzf = zzfx.zzr(SystemClock.elapsedRealtime());
        return i != 3;
    }
}
