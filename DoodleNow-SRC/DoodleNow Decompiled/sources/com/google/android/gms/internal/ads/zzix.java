package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzix implements zzlh {
    private final zzmm zza;
    private final zziw zzb;
    private zzmf zzc;
    private zzlh zzd;
    private boolean zze = true;
    private boolean zzf;

    public zzix(zziw zziw, zzel zzel) {
        this.zzb = zziw;
        this.zza = new zzmm(zzel);
    }

    public final long zza() {
        throw null;
    }

    public final long zzb(boolean z) {
        zzmf zzmf = this.zzc;
        if (zzmf == null || zzmf.zzW() || ((z && this.zzc.zzcU() != 2) || (!this.zzc.zzX() && (z || this.zzc.zzQ())))) {
            this.zze = true;
            if (this.zzf) {
                this.zza.zzd();
            }
        } else {
            zzlh zzlh = this.zzd;
            zzlh.getClass();
            long zza2 = zzlh.zza();
            if (this.zze) {
                if (zza2 < this.zza.zza()) {
                    this.zza.zze();
                } else {
                    this.zze = false;
                    if (this.zzf) {
                        this.zza.zzd();
                    }
                }
            }
            this.zza.zzb(zza2);
            zzcg zzc2 = zzlh.zzc();
            if (!zzc2.equals(this.zza.zzc())) {
                this.zza.zzg(zzc2);
                this.zzb.zza(zzc2);
            }
        }
        if (this.zze) {
            return this.zza.zza();
        }
        zzlh zzlh2 = this.zzd;
        zzlh2.getClass();
        return zzlh2.zza();
    }

    public final zzcg zzc() {
        zzlh zzlh = this.zzd;
        return zzlh != null ? zzlh.zzc() : this.zza.zzc();
    }

    public final void zzd(zzmf zzmf) {
        if (zzmf == this.zzc) {
            this.zzd = null;
            this.zzc = null;
            this.zze = true;
        }
    }

    public final void zze(zzmf zzmf) throws zziz {
        zzlh zzlh;
        zzlh zzk = zzmf.zzk();
        if (zzk != null && zzk != (zzlh = this.zzd)) {
            if (zzlh == null) {
                this.zzd = zzk;
                this.zzc = zzmf;
                zzk.zzg(this.zza.zzc());
                return;
            }
            throw zziz.zzd(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
    }

    public final void zzf(long j) {
        this.zza.zzb(j);
    }

    public final void zzg(zzcg zzcg) {
        zzlh zzlh = this.zzd;
        if (zzlh != null) {
            zzlh.zzg(zzcg);
            zzcg = this.zzd.zzc();
        }
        this.zza.zzg(zzcg);
    }

    public final void zzh() {
        this.zzf = true;
        this.zza.zzd();
    }

    public final void zzi() {
        this.zzf = false;
        this.zza.zze();
    }

    public final boolean zzj() {
        if (this.zze) {
            return false;
        }
        zzlh zzlh = this.zzd;
        zzlh.getClass();
        return zzlh.zzj();
    }
}
