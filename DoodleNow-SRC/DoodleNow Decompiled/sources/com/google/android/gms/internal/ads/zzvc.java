package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzvc extends zzxm {
    private final boolean zzb;
    private final zzcw zzc;
    private final zzcu zzd;
    private zzva zze;
    private zzuz zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzvc(zzvj zzvj, boolean z) {
        super(zzvj);
        boolean z2;
        if (z) {
            zzvj.zzv();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzcw();
        this.zzd = new zzcu();
        zzvj.zzM();
        this.zze = zzva.zzq(zzvj.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zzf == null || !obj.equals(zzva.zzd)) ? obj : this.zze.zzf;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzL(long j) {
        zzuz zzuz = this.zzf;
        int zza = this.zze.zza(zzuz.zza.zza);
        if (zza != -1) {
            zzva zzva = this.zze;
            zzcu zzcu = this.zzd;
            zzva.zzd(zza, zzcu, false);
            long j2 = zzcu.zze;
            if (j2 != C.TIME_UNSET && j >= j2) {
                j = Math.max(0, j2 - 1);
            }
            zzuz.zzs(j);
        }
    }

    public final zzcx zzC() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final zzvh zzD(zzvh zzvh) {
        Object zzs = this.zze.zzf;
        Object obj = zzvh.zza;
        if (zzs != null && this.zze.zzf.equals(obj)) {
            obj = zzva.zzd;
        }
        return zzvh.zza(obj);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzE(com.google.android.gms.internal.ads.zzcx r15) {
        /*
            r14 = this;
            boolean r0 = r14.zzh
            r1 = 0
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzva r0 = r14.zze
            com.google.android.gms.internal.ads.zzva r15 = r0.zzp(r15)
            r14.zze = r15
            com.google.android.gms.internal.ads.zzuz r15 = r14.zzf
            if (r15 == 0) goto L_0x009b
            long r2 = r15.zzn()
            r14.zzL(r2)
            goto L_0x009b
        L_0x001a:
            boolean r0 = r15.zzo()
            if (r0 == 0) goto L_0x0036
            boolean r0 = r14.zzi
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.internal.ads.zzva r0 = r14.zze
            com.google.android.gms.internal.ads.zzva r15 = r0.zzp(r15)
            goto L_0x0033
        L_0x002b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzcw.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzva.zzd
            com.google.android.gms.internal.ads.zzva r15 = com.google.android.gms.internal.ads.zzva.zzr(r15, r0, r2)
        L_0x0033:
            r14.zze = r15
            goto L_0x009b
        L_0x0036:
            com.google.android.gms.internal.ads.zzcw r0 = r14.zzc
            r2 = 0
            r3 = 0
            r15.zze(r2, r0, r3)
            com.google.android.gms.internal.ads.zzcw r0 = r14.zzc
            java.lang.Object r0 = r0.zzc
            com.google.android.gms.internal.ads.zzuz r5 = r14.zzf
            if (r5 == 0) goto L_0x0062
            long r6 = r5.zzq()
            com.google.android.gms.internal.ads.zzva r8 = r14.zze
            com.google.android.gms.internal.ads.zzcu r9 = r14.zzd
            com.google.android.gms.internal.ads.zzvh r5 = r5.zza
            java.lang.Object r5 = r5.zza
            r8.zzn(r5, r9)
            com.google.android.gms.internal.ads.zzva r5 = r14.zze
            com.google.android.gms.internal.ads.zzcw r8 = r14.zzc
            r5.zze(r2, r8, r3)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0062
            r12 = r6
            goto L_0x0063
        L_0x0062:
            r12 = r3
        L_0x0063:
            com.google.android.gms.internal.ads.zzcw r9 = r14.zzc
            com.google.android.gms.internal.ads.zzcu r10 = r14.zzd
            r11 = 0
            r8 = r15
            android.util.Pair r2 = r8.zzl(r9, r10, r11, r12)
            java.lang.Object r3 = r2.first
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r4 = r2.longValue()
            boolean r2 = r14.zzi
            if (r2 == 0) goto L_0x0082
            com.google.android.gms.internal.ads.zzva r0 = r14.zze
            com.google.android.gms.internal.ads.zzva r15 = r0.zzp(r15)
            goto L_0x0086
        L_0x0082:
            com.google.android.gms.internal.ads.zzva r15 = com.google.android.gms.internal.ads.zzva.zzr(r15, r0, r3)
        L_0x0086:
            r14.zze = r15
            com.google.android.gms.internal.ads.zzuz r15 = r14.zzf
            if (r15 == 0) goto L_0x009b
            r14.zzL(r4)
            com.google.android.gms.internal.ads.zzvh r15 = r15.zza
            java.lang.Object r0 = r15.zza
            java.lang.Object r0 = r14.zzK(r0)
            com.google.android.gms.internal.ads.zzvh r1 = r15.zza(r0)
        L_0x009b:
            r15 = 1
            r14.zzi = r15
            r14.zzh = r15
            com.google.android.gms.internal.ads.zzva r15 = r14.zze
            r14.zzo(r15)
            if (r1 == 0) goto L_0x00af
            com.google.android.gms.internal.ads.zzuz r15 = r14.zzf
            r15.getClass()
            r15.zzr(r1)
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvc.zzE(com.google.android.gms.internal.ads.zzcx):void");
    }

    public final void zzF() {
        if (!this.zzb) {
            this.zzg = true;
            zzB((Object) null, this.zza);
        }
    }

    public final void zzG(zzvf zzvf) {
        ((zzuz) zzvf).zzt();
        if (zzvf == this.zzf) {
            this.zzf = null;
        }
    }

    /* renamed from: zzH */
    public final zzuz zzI(zzvh zzvh, zzzo zzzo, long j) {
        zzuz zzuz = new zzuz(zzvh, zzzo, j);
        zzuz.zzu(this.zza);
        if (this.zzh) {
            zzuz.zzr(zzvh.zza(zzK(zzvh.zza)));
        } else {
            this.zzf = zzuz;
            if (!this.zzg) {
                this.zzg = true;
                zzB((Object) null, this.zza);
            }
        }
        return zzuz;
    }

    public final void zzq() {
        this.zzh = false;
        this.zzg = false;
        super.zzq();
    }

    public final void zzt(zzbp zzbp) {
        if (this.zzi) {
            this.zze = this.zze.zzp(new zzxh(this.zze.zzc, zzbp));
        } else {
            this.zze = zzva.zzq(zzbp);
        }
        this.zza.zzt(zzbp);
    }

    public final void zzz() {
    }
}
