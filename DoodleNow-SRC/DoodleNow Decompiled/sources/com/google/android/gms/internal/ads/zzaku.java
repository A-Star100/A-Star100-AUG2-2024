package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
abstract class zzaku {
    private final zzakn zza = new zzakn();
    private zzaem zzb;
    private zzadi zzc;
    private zzakp zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzakr zzj = new zzakr();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    /* access modifiers changed from: protected */
    public abstract long zza(zzfo zzfo);

    /* access modifiers changed from: protected */
    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzakr();
            this.zzf = 0;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1;
        this.zzg = 0;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean zzc(zzfo zzfo, long j, zzakr zzakr) throws IOException;

    /* access modifiers changed from: package-private */
    public final int zze(zzadg zzadg, zzaec zzaec) throws IOException {
        zzadg zzadg2 = zzadg;
        zzek.zzb(this.zzb);
        int i = zzfx.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzadg2)) {
                long zzf2 = zzadg.zzf();
                long j = this.zzf;
                this.zzk = zzf2 - j;
                if (zzc(this.zza.zza(), j, this.zzj)) {
                    this.zzf = zzadg.zzf();
                } else {
                    zzam zzam = this.zzj.zza;
                    this.zzi = zzam.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzam);
                        this.zzm = true;
                    }
                    zzakp zzakp = this.zzj.zzb;
                    if (zzakp != null) {
                        this.zzd = zzakp;
                    } else if (zzadg.zzd() == -1) {
                        this.zzd = new zzakt((zzaks) null);
                    } else {
                        zzako zzb2 = this.zza.zzb();
                        this.zzd = new zzaki(this, this.zzf, zzadg.zzd(), (long) (zzb2.zzd + zzb2.zze), zzb2.zzb, (zzb2.zza & 4) != 0);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                }
            }
            this.zzh = 3;
            return -1;
        } else if (i2 == 1) {
            ((zzact) zzadg2).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        } else if (i2 != 2) {
            return -1;
        } else {
            long zzd2 = this.zzd.zzd(zzadg2);
            if (zzd2 >= 0) {
                zzaec.zza = zzd2;
                return 1;
            }
            if (zzd2 < -1) {
                zzi(-(zzd2 + 2));
            }
            if (!this.zzl) {
                zzaef zze2 = this.zzd.zze();
                zzek.zzb(zze2);
                this.zzc.zzO(zze2);
                this.zzl = true;
            }
            if (this.zzk > 0 || this.zza.zze(zzadg2)) {
                this.zzk = 0;
                zzfo zza2 = this.zza.zza();
                long zza3 = zza(zza2);
                if (zza3 >= 0) {
                    long j2 = this.zzg;
                    if (j2 + zza3 >= this.zze) {
                        long zzf3 = zzf(j2);
                        zzaek.zzb(this.zzb, zza2, zza2.zze());
                        this.zzb.zzs(zzf3, 1, zza2.zze(), 0, (zzael) null);
                        this.zze = -1;
                    }
                }
                this.zzg += zza3;
            } else {
                this.zzh = 3;
                return -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    /* access modifiers changed from: protected */
    public final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    /* access modifiers changed from: package-private */
    public final void zzh(zzadi zzadi, zzaem zzaem) {
        this.zzc = zzadi;
        this.zzb = zzaem;
        zzb(true);
    }

    /* access modifiers changed from: protected */
    public void zzi(long j) {
        this.zzg = j;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            this.zze = zzg(j2);
            zzakp zzakp = this.zzd;
            int i = zzfx.zza;
            zzakp.zzg(this.zze);
            this.zzh = 2;
        }
    }
}
