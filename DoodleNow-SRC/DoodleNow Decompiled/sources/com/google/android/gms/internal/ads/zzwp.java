package com.google.android.gms.internal.ads;

import android.os.Looper;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzwp extends zzuh implements zzwg {
    private final zzgu zza;
    private final zzsm zzb;
    private final int zzc;
    private boolean zzd = true;
    private long zze = C.TIME_UNSET;
    private boolean zzf;
    private boolean zzg;
    private zzhy zzh;
    private zzbp zzi;
    private final zzwm zzj;
    private final zzzs zzk;

    /* synthetic */ zzwp(zzbp zzbp, zzgu zzgu, zzwm zzwm, zzsm zzsm, zzzs zzzs, int i, zzwo zzwo) {
        this.zzi = zzbp;
        this.zza = zzgu;
        this.zzj = zzwm;
        this.zzb = zzsm;
        this.zzk = zzzs;
        this.zzc = i;
    }

    private final void zzw() {
        long j = this.zze;
        boolean z = this.zzf;
        boolean z2 = this.zzg;
        zzbp zzJ = zzJ();
        zzxc zzxc = r1;
        zzxc zzxc2 = new zzxc(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j, j, 0, 0, z, false, false, (Object) null, zzJ, z2 ? zzJ.zzf : null);
        zzo(this.zzd ? new zzwl(this, zzxc) : zzxc);
    }

    public final void zzG(zzvf zzvf) {
        ((zzwk) zzvf).zzN();
    }

    public final zzvf zzI(zzvh zzvh, zzzo zzzo, long j) {
        zzgv zza2 = this.zza.zza();
        zzhy zzhy = this.zzh;
        if (zzhy != null) {
            zza2.zzf(zzhy);
        }
        zzbi zzbi = zzJ().zzd;
        zzbi.getClass();
        zzwm zzwm = this.zzj;
        zzb();
        return new zzwk(zzbi.zzb, zza2, new zzuj(zzwm.zza), this.zzb, zzc(zzvh), this.zzk, zze(zzvh), this, zzzo, (String) null, this.zzc, zzfx.zzr(C.TIME_UNSET));
    }

    public final synchronized zzbp zzJ() {
        return this.zzi;
    }

    public final void zza(long j, boolean z, boolean z2) {
        if (j == C.TIME_UNSET) {
            j = this.zze;
        }
        if (this.zzd || this.zze != j || this.zzf != z || this.zzg != z2) {
            this.zze = j;
            this.zzf = z;
            this.zzg = z2;
            this.zzd = false;
            zzw();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn(zzhy zzhy) {
        this.zzh = zzhy;
        Looper.myLooper().getClass();
        zzb();
        zzw();
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
    }

    public final synchronized void zzt(zzbp zzbp) {
        this.zzi = zzbp;
    }

    public final void zzz() {
    }
}
