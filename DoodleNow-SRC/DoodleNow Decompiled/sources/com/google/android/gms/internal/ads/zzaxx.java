package com.google.android.gms.internal.ads;

import android.app.AppOpsManager$OnOpActiveChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaxx implements AppOpsManager$OnOpActiveChangedListener {
    final /* synthetic */ zzaxy zza;

    zzaxx(zzaxy zzaxy) {
        this.zza = zzaxy;
    }

    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            this.zza.zzb = System.currentTimeMillis();
            this.zza.zze = true;
            return;
        }
        zzaxy zzaxy = this.zza;
        long currentTimeMillis = System.currentTimeMillis();
        if (zzaxy.zzc > 0) {
            zzaxy zzaxy2 = this.zza;
            if (currentTimeMillis >= zzaxy2.zzc) {
                zzaxy2.zzd = currentTimeMillis - zzaxy2.zzc;
            }
        }
        this.zza.zze = false;
    }
}
