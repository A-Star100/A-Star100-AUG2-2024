package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzqf {
    private final Handler zza;
    private final zzqg zzb;

    public zzqf(Handler handler, zzqg zzqg) {
        this.zza = zzqg == null ? null : handler;
        this.zzb = zzqg;
    }

    public final void zza(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpz(this, exc));
        }
    }

    public final void zzb(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqa(this, exc));
        }
    }

    public final void zzc(zzqh zzqh) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpx(this, zzqh));
        }
    }

    public final void zzd(zzqh zzqh) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpy(this, zzqh));
        }
    }

    public final void zze(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqd(this, str, j, j2));
        }
    }

    public final void zzf(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqe(this, str));
        }
    }

    public final void zzg(zzir zzir) {
        zzir.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpu(this, zzir));
        }
    }

    public final void zzh(zzir zzir) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpt(this, zzir));
        }
    }

    public final void zzi(zzam zzam, zzis zzis) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqb(this, zzam, zzis));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(Exception exc) {
        int i = zzfx.zza;
        this.zzb.zza(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(Exception exc) {
        int i = zzfx.zza;
        this.zzb.zzh(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzqh zzqh) {
        int i = zzfx.zza;
        this.zzb.zzi(zzqh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(zzqh zzqh) {
        int i = zzfx.zza;
        this.zzb.zzj(zzqh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str, long j, long j2) {
        int i = zzfx.zza;
        this.zzb.zzb(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        int i = zzfx.zza;
        this.zzb.zzc(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzir zzir) {
        zzir.zza();
        int i = zzfx.zza;
        this.zzb.zzd(zzir);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(zzir zzir) {
        int i = zzfx.zza;
        this.zzb.zze(zzir);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzr(zzam zzam, zzis zzis) {
        int i = zzfx.zza;
        this.zzb.zzf(zzam, zzis);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs(long j) {
        int i = zzfx.zza;
        this.zzb.zzg(j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzt(boolean z) {
        int i = zzfx.zza;
        this.zzb.zzn(z);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzu(int i, long j, long j2) {
        int i2 = zzfx.zza;
        this.zzb.zzk(i, j, j2);
    }

    public final void zzv(long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpv(this, j));
        }
    }

    public final void zzw(boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzqc(this, z));
        }
    }

    public final void zzx(int i, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpw(this, i, j, j2));
        }
    }
}
