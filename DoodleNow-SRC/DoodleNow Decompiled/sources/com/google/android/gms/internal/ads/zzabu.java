package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzabu {
    private final Handler zza;
    private final zzabv zzb;

    public zzabu(Handler handler, zzabv zzabv) {
        this.zza = zzabv == null ? null : handler;
        this.zzb = zzabv;
    }

    public final void zza(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabk(this, str, j, j2));
        }
    }

    public final void zzb(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabt(this, str));
        }
    }

    public final void zzc(zzir zzir) {
        zzir.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabs(this, zzir));
        }
    }

    public final void zzd(int i, long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabm(this, i, j));
        }
    }

    public final void zze(zzir zzir) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabq(this, zzir));
        }
    }

    public final void zzf(zzam zzam, zzis zzis) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabr(this, zzam, zzis));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(String str, long j, long j2) {
        int i = zzfx.zza;
        this.zzb.zzp(str, j, j2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str) {
        int i = zzfx.zza;
        this.zzb.zzq(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzir zzir) {
        zzir.zza();
        int i = zzfx.zza;
        this.zzb.zzr(zzir);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(int i, long j) {
        int i2 = zzfx.zza;
        this.zzb.zzl(i, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzir zzir) {
        int i = zzfx.zza;
        this.zzb.zzs(zzir);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzl(zzam zzam, zzis zzis) {
        int i = zzfx.zza;
        this.zzb.zzu(zzam, zzis);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(Object obj, long j) {
        int i = zzfx.zza;
        this.zzb.zzm(obj, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(long j, int i) {
        int i2 = zzfx.zza;
        this.zzb.zzt(j, i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Exception exc) {
        int i = zzfx.zza;
        this.zzb.zzo(exc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(zzdp zzdp) {
        int i = zzfx.zza;
        this.zzb.zzv(zzdp);
    }

    public final void zzq(Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabn(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzr(long j, int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabo(this, j, i));
        }
    }

    public final void zzs(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabp(this, exc));
        }
    }

    public final void zzt(zzdp zzdp) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzabl(this, zzdp));
        }
    }
}
