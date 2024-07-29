package com.google.android.gms.internal.ads;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzabf implements DisplayManager.DisplayListener {
    final /* synthetic */ zzabh zza;
    private final DisplayManager zzb;

    public zzabf(zzabh zzabh, DisplayManager displayManager) {
        this.zza = zzabh;
        this.zzb = displayManager;
    }

    private final Display zzc() {
        return this.zzb.getDisplay(0);
    }

    public final void onDisplayAdded(int i) {
    }

    public final void onDisplayChanged(int i) {
        if (i == 0) {
            zzabh.zzb(this.zza, zzc());
        }
    }

    public final void onDisplayRemoved(int i) {
    }

    public final void zza() {
        this.zzb.registerDisplayListener(this, zzfx.zzx((Handler.Callback) null));
        zzabh.zzb(this.zza, zzc());
    }

    public final void zzb() {
        this.zzb.unregisterDisplayListener(this);
    }
}
