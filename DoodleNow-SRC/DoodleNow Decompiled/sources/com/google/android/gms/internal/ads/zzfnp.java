package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfnp extends zzfns {
    private static final zzfnp zzb = new zzfnp();

    private zzfnp() {
    }

    public static zzfnp zza() {
        return zzb;
    }

    public final void zzb(boolean z) {
        for (zzfnc zzg : zzfnq.zza().zzc()) {
            zzg.zzg().zzk(z);
        }
    }

    public final boolean zzc() {
        for (zzfnc zzf : zzfnq.zza().zzb()) {
            View zzf2 = zzf.zzf();
            if (zzf2 != null && zzf2.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
