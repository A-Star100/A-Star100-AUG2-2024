package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzou {
    final /* synthetic */ zzov zza;
    /* access modifiers changed from: private */
    public final String zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public long zzd;
    /* access modifiers changed from: private */
    public zzvh zze;
    /* access modifiers changed from: private */
    public boolean zzf;
    /* access modifiers changed from: private */
    public boolean zzg;

    public zzou(zzov zzov, String str, int i, zzvh zzvh) {
        this.zza = zzov;
        this.zzb = str;
        this.zzc = i;
        this.zzd = zzvh == null ? -1 : zzvh.zzd;
        if (zzvh != null && zzvh.zzb()) {
            this.zze = zzvh;
        }
    }

    public final void zzg(int i, zzvh zzvh) {
        if (this.zzd == -1 && i == this.zzc && zzvh != null) {
            zzov zzov = this.zza;
            long j = zzvh.zzd;
            if (j >= zzov.zzl()) {
                this.zzd = j;
            }
        }
    }

    public final boolean zzj(int i, zzvh zzvh) {
        if (zzvh == null) {
            return i == this.zzc;
        }
        zzvh zzvh2 = this.zze;
        return zzvh2 == null ? !zzvh.zzb() && zzvh.zzd == this.zzd : zzvh.zzd == zzvh2.zzd && zzvh.zzb == zzvh2.zzb && zzvh.zzc == zzvh2.zzc;
    }

    public final boolean zzk(zzmq zzmq) {
        zzvh zzvh = zzmq.zzd;
        if (zzvh == null) {
            return this.zzc != zzmq.zzc;
        }
        long j = this.zzd;
        if (j == -1) {
            return false;
        }
        if (zzvh.zzd > j) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        zzcx zzcx = zzmq.zzb;
        int zza2 = zzcx.zza(zzvh.zza);
        int zza3 = zzcx.zza(this.zze.zza);
        zzvh zzvh2 = zzmq.zzd;
        if (zzvh2.zzd < this.zze.zzd || zza2 < zza3) {
            return false;
        }
        if (zza2 > zza3) {
            return true;
        }
        if (zzvh2.zzb()) {
            zzvh zzvh3 = zzmq.zzd;
            int i = zzvh3.zzb;
            int i2 = zzvh3.zzc;
            zzvh zzvh4 = this.zze;
            int i3 = zzvh4.zzb;
            if (i > i3) {
                return true;
            }
            if (i == i3) {
                return i2 > zzvh4.zzc;
            }
            return false;
        }
        int i4 = zzmq.zzd.zze;
        return i4 == -1 || i4 > this.zze.zzb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r0 < r8.zzc()) goto L_0x004a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzl(com.google.android.gms.internal.ads.zzcx r7, com.google.android.gms.internal.ads.zzcx r8) {
        /*
            r6 = this;
            int r0 = r6.zzc
            int r1 = r7.zzc()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L_0x0013
            int r7 = r8.zzc()
            if (r0 >= r7) goto L_0x0011
            goto L_0x004a
        L_0x0011:
            r0 = r3
            goto L_0x004a
        L_0x0013:
            com.google.android.gms.internal.ads.zzov r1 = r6.zza
            com.google.android.gms.internal.ads.zzcw r1 = r1.zzc
            r4 = 0
            r7.zze(r0, r1, r4)
            com.google.android.gms.internal.ads.zzov r0 = r6.zza
            com.google.android.gms.internal.ads.zzcw r0 = r0.zzc
            int r0 = r0.zzp
        L_0x0026:
            com.google.android.gms.internal.ads.zzov r1 = r6.zza
            com.google.android.gms.internal.ads.zzcw r1 = r1.zzc
            int r1 = r1.zzq
            if (r0 > r1) goto L_0x0011
            java.lang.Object r1 = r7.zzf(r0)
            int r1 = r8.zza(r1)
            if (r1 == r3) goto L_0x0047
            com.google.android.gms.internal.ads.zzov r7 = r6.zza
            com.google.android.gms.internal.ads.zzcu r7 = r7.zzd
            com.google.android.gms.internal.ads.zzcu r7 = r8.zzd(r1, r7, r2)
            int r0 = r7.zzd
            goto L_0x004a
        L_0x0047:
            int r0 = r0 + 1
            goto L_0x0026
        L_0x004a:
            r6.zzc = r0
            if (r0 != r3) goto L_0x004f
            return r2
        L_0x004f:
            com.google.android.gms.internal.ads.zzvh r7 = r6.zze
            r0 = 1
            if (r7 != 0) goto L_0x0055
            return r0
        L_0x0055:
            java.lang.Object r7 = r7.zza
            int r7 = r8.zza(r7)
            if (r7 == r3) goto L_0x005e
            return r0
        L_0x005e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzou.zzl(com.google.android.gms.internal.ads.zzcx, com.google.android.gms.internal.ads.zzcx):boolean");
    }
}
