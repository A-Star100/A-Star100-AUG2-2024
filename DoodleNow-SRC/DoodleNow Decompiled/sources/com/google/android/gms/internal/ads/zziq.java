package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zziq implements zzmf, zzmh {
    private final Object zza = new Object();
    private final int zzb;
    private final zzlb zzc;
    private zzmi zzd;
    private int zze;
    private zzpb zzf;
    private zzel zzg;
    private int zzh;
    private zzwy zzi;
    private zzam[] zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private boolean zzn;
    private boolean zzo;
    private zzcx zzp;
    private zzmg zzq;

    public zziq(int i) {
        this.zzb = i;
        this.zzc = new zzlb();
        this.zzm = Long.MIN_VALUE;
        this.zzp = zzcx.zza;
    }

    private final void zzZ(long j, boolean z) throws zziz {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        zzz(j, z);
    }

    /* access modifiers changed from: protected */
    public void zzA() {
    }

    /* access modifiers changed from: protected */
    public final void zzB() {
        zzmg zzmg;
        synchronized (this.zza) {
            zzmg = this.zzq;
        }
        if (zzmg != null) {
            zzmg.zza(this);
        }
    }

    /* access modifiers changed from: protected */
    public void zzC() {
    }

    /* access modifiers changed from: protected */
    public void zzD() throws zziz {
    }

    /* access modifiers changed from: protected */
    public void zzE() {
    }

    /* access modifiers changed from: protected */
    public void zzF(zzam[] zzamArr, long j, long j2, zzvh zzvh) throws zziz {
        throw null;
    }

    public final void zzG() {
        zzek.zzf(this.zzh == 0);
        zzA();
    }

    public final void zzH(zzam[] zzamArr, zzwy zzwy, long j, long j2, zzvh zzvh) throws zziz {
        zzek.zzf(!this.zzn);
        this.zzi = zzwy;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzamArr;
        this.zzk = j2;
        zzF(zzamArr, j, j2, zzvh);
    }

    public final void zzI() {
        zzek.zzf(this.zzh == 0);
        zzlb zzlb = this.zzc;
        zzlb.zzb = null;
        zzlb.zza = null;
        zzC();
    }

    public final void zzJ(long j) throws zziz {
        zzZ(j, false);
    }

    public final void zzK() {
        this.zzn = true;
    }

    public final void zzL(zzmg zzmg) {
        synchronized (this.zza) {
            this.zzq = zzmg;
        }
    }

    public /* synthetic */ void zzM(float f, float f2) {
    }

    public final void zzN(zzcx zzcx) {
        if (!zzfx.zzG(this.zzp, zzcx)) {
            this.zzp = zzcx;
        }
    }

    public final void zzO() throws zziz {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzek.zzf(z);
        this.zzh = 2;
        zzD();
    }

    public final void zzP() {
        zzek.zzf(this.zzh == 2);
        this.zzh = 1;
        zzE();
    }

    public final boolean zzQ() {
        return this.zzm == Long.MIN_VALUE;
    }

    public final boolean zzR() {
        return this.zzn;
    }

    /* access modifiers changed from: protected */
    public final zzam[] zzT() {
        zzam[] zzamArr = this.zzj;
        zzamArr.getClass();
        return zzamArr;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzcU() {
        return this.zzh;
    }

    public final long zzcW() {
        return this.zzm;
    }

    /* access modifiers changed from: protected */
    public final zzlb zzcX() {
        zzlb zzlb = this.zzc;
        zzlb.zzb = null;
        zzlb.zza = null;
        return zzlb;
    }

    public int zze() throws zziz {
        return 0;
    }

    /* access modifiers changed from: protected */
    public final long zzf() {
        return this.zzl;
    }

    /* access modifiers changed from: protected */
    public final zzel zzh() {
        zzel zzel = this.zzg;
        zzel.getClass();
        return zzel;
    }

    /* access modifiers changed from: protected */
    public final zziz zzi(Throwable th, zzam zzam, boolean z, int i) {
        int i2 = 4;
        if (zzam != null && !this.zzo) {
            this.zzo = true;
            try {
                i2 = zzY(zzam) & 7;
            } catch (zziz unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zziz.zzb(th, zzU(), this.zze, zzam, i2, z, i);
    }

    public zzlh zzk() {
        return null;
    }

    public final zzmh zzl() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final zzmi zzm() {
        zzmi zzmi = this.zzd;
        zzmi.getClass();
        return zzmi;
    }

    /* access modifiers changed from: protected */
    public final zzpb zzn() {
        zzpb zzpb = this.zzf;
        zzpb.getClass();
        return zzpb;
    }

    public final zzwy zzo() {
        return this.zzi;
    }

    public final void zzp() {
        synchronized (this.zza) {
            this.zzq = null;
        }
    }

    public final void zzq() {
        boolean z = true;
        if (this.zzh != 1) {
            z = false;
        }
        zzek.zzf(z);
        zzlb zzlb = this.zzc;
        zzlb.zzb = null;
        zzlb.zza = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzw();
    }

    public final void zzr(zzmi zzmi, zzam[] zzamArr, zzwy zzwy, long j, boolean z, boolean z2, long j2, long j3, zzvh zzvh) throws zziz {
        boolean z3 = z;
        zzek.zzf(this.zzh == 0);
        this.zzd = zzmi;
        this.zzh = 1;
        zzx(z3, z2);
        zzH(zzamArr, zzwy, j2, j3, zzvh);
        zzZ(j2, z3);
    }

    public /* synthetic */ void zzs() {
    }

    public void zzt(int i, Object obj) throws zziz {
    }

    public final void zzu(int i, zzpb zzpb, zzel zzel) {
        this.zze = i;
        this.zzf = zzpb;
        this.zzg = zzel;
        zzy();
    }

    /* access modifiers changed from: protected */
    public void zzw() {
        throw null;
    }

    /* access modifiers changed from: protected */
    public void zzx(boolean z, boolean z2) throws zziz {
    }

    /* access modifiers changed from: protected */
    public void zzy() {
    }

    /* access modifiers changed from: protected */
    public void zzz(long j, boolean z) throws zziz {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzS() {
        if (zzQ()) {
            return this.zzn;
        }
        zzwy zzwy = this.zzi;
        zzwy.getClass();
        return zzwy.zze();
    }

    /* access modifiers changed from: protected */
    public final int zzd(long j) {
        zzwy zzwy = this.zzi;
        zzwy.getClass();
        return zzwy.zzb(j - this.zzk);
    }

    public final void zzv() throws IOException {
        zzwy zzwy = this.zzi;
        zzwy.getClass();
        zzwy.zzd();
    }

    /* access modifiers changed from: protected */
    public final int zzcV(zzlb zzlb, zzih zzih, int i) {
        zzwy zzwy = this.zzi;
        zzwy.getClass();
        int zza2 = zzwy.zza(zzlb, zzih, i);
        if (zza2 == -4) {
            if (zzih.zzf()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzih.zze + this.zzk;
            zzih.zze = j;
            this.zzm = Math.max(this.zzm, j);
        } else if (zza2 == -5) {
            zzam zzam = zzlb.zza;
            zzam.getClass();
            long j2 = zzam.zzq;
            if (j2 != Long.MAX_VALUE) {
                zzak zzb2 = zzam.zzb();
                zzb2.zzaa(j2 + this.zzk);
                zzlb.zza = zzb2.zzac();
                return -5;
            }
        }
        return zza2;
    }
}
