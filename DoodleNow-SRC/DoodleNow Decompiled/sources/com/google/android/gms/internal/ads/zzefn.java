package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzefn extends TimerTask {
    final /* synthetic */ AlertDialog zza;
    final /* synthetic */ Timer zzb;
    final /* synthetic */ zzm zzc;

    zzefn(zzefo zzefo, AlertDialog alertDialog, Timer timer, zzm zzm) {
        this.zza = alertDialog;
        this.zzb = timer;
        this.zzc = zzm;
    }

    public final void run() {
        this.zza.dismiss();
        this.zzb.cancel();
        zzm zzm = this.zzc;
        if (zzm != null) {
            zzm.zzb();
        }
    }
}
