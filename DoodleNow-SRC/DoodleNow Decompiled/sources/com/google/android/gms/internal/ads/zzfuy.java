package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfuy {
    /* access modifiers changed from: private */
    public static final zzfvg zzb = new zzfvg("OverlayDisplayService");
    private static final Intent zzc = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzfvr zza;
    /* access modifiers changed from: private */
    public final String zzd;

    zzfuy(Context context) {
        if (zzfvu.zza(context)) {
            this.zza = new zzfvr(context.getApplicationContext(), zzb, "OverlayDisplayService", zzc, zzfut.zza, (zzfvm) null);
        } else {
            this.zza = null;
        }
        this.zzd = context.getPackageName();
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (this.zza != null) {
            zzb.zzc("unbind LMD display overlay service", new Object[0]);
            this.zza.zzu();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(zzfup zzfup, zzfvd zzfvd) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzfuv(this, taskCompletionSource, zzfup, zzfvd, taskCompletionSource), taskCompletionSource);
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzfva zzfva, zzfvd zzfvd) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
        } else if (zzfva.zzh() == null) {
            zzb.zza("Failed to convert OverlayDisplayShowRequest when to create a new session: appId cannot be null.", new Object[0]);
            zzfvb zzc2 = zzfvc.zzc();
            zzc2.zzb(8160);
            zzfvd.zza(zzc2.zzc());
        } else {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.zza.zzs(new zzfuu(this, taskCompletionSource, zzfva, zzfvd, taskCompletionSource), taskCompletionSource);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzf(zzfvf zzfvf, zzfvd zzfvd, int i) {
        if (this.zza == null) {
            zzb.zza("error: %s", "Play Store not found.");
            return;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zza.zzs(new zzfuw(this, taskCompletionSource, zzfvf, i, zzfvd, taskCompletionSource), taskCompletionSource);
    }
}
