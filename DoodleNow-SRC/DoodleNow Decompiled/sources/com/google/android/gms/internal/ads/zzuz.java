package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzuz implements zzvf, zzve {
    public final zzvh zza;
    private final long zzb;
    private zzvj zzc;
    private zzvf zzd;
    private zzve zze;
    private long zzf = C.TIME_UNSET;
    private final zzzo zzg;

    public zzuz(zzvh zzvh, zzzo zzzo, long j) {
        this.zza = zzvh;
        this.zzg = zzzo;
        this.zzb = j;
    }

    private final long zzv(long j) {
        long j2 = this.zzf;
        return j2 != C.TIME_UNSET ? j2 : j;
    }

    public final long zza(long j, zzmj zzmj) {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        return zzvf.zza(j, zzmj);
    }

    public final long zzb() {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        return zzvf.zzb();
    }

    public final long zzc() {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        return zzvf.zzc();
    }

    public final long zzd() {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        return zzvf.zzd();
    }

    public final long zze(long j) {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        return zzvf.zze(j);
    }

    public final long zzf(zzyz[] zzyzArr, boolean[] zArr, zzwy[] zzwyArr, boolean[] zArr2, long j) {
        long j2 = this.zzf;
        long j3 = (j2 == C.TIME_UNSET || j != this.zzb) ? j : j2;
        this.zzf = C.TIME_UNSET;
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        return zzvf.zzf(zzyzArr, zArr, zzwyArr, zArr2, j3);
    }

    public final /* bridge */ /* synthetic */ void zzg(zzxa zzxa) {
        zzvf zzvf = (zzvf) zzxa;
        zzve zzve = this.zze;
        int i = zzfx.zza;
        zzve.zzg(this);
    }

    public final zzxk zzh() {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        return zzvf.zzh();
    }

    public final void zzi(zzvf zzvf) {
        zzve zzve = this.zze;
        int i = zzfx.zza;
        zzve.zzi(this);
    }

    public final void zzj(long j, boolean z) {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        zzvf.zzj(j, false);
    }

    public final void zzk() throws IOException {
        zzvf zzvf = this.zzd;
        if (zzvf != null) {
            zzvf.zzk();
            return;
        }
        zzvj zzvj = this.zzc;
        if (zzvj != null) {
            zzvj.zzz();
        }
    }

    public final void zzl(zzve zzve, long j) {
        this.zze = zzve;
        zzvf zzvf = this.zzd;
        if (zzvf != null) {
            zzvf.zzl(this, zzv(this.zzb));
        }
    }

    public final void zzm(long j) {
        zzvf zzvf = this.zzd;
        int i = zzfx.zza;
        zzvf.zzm(j);
    }

    public final long zzn() {
        return this.zzf;
    }

    public final boolean zzo(zzlg zzlg) {
        zzvf zzvf = this.zzd;
        return zzvf != null && zzvf.zzo(zzlg);
    }

    public final boolean zzp() {
        zzvf zzvf = this.zzd;
        return zzvf != null && zzvf.zzp();
    }

    public final long zzq() {
        return this.zzb;
    }

    public final void zzr(zzvh zzvh) {
        long zzv = zzv(this.zzb);
        zzvj zzvj = this.zzc;
        zzvj.getClass();
        zzvf zzI = zzvj.zzI(zzvh, this.zzg, zzv);
        this.zzd = zzI;
        if (this.zze != null) {
            zzI.zzl(this, zzv);
        }
    }

    public final void zzs(long j) {
        this.zzf = j;
    }

    public final void zzu(zzvj zzvj) {
        zzek.zzf(this.zzc == null);
        this.zzc = zzvj;
    }

    public final void zzt() {
        zzvf zzvf = this.zzd;
        if (zzvf != null) {
            zzvj zzvj = this.zzc;
            zzvj.getClass();
            zzvj.zzG(zzvf);
        }
    }
}
