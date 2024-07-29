package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdrq implements zzczl {
    private final zzcgm zza;

    zzdrq(zzcgm zzcgm) {
        this.zza = zzcgm;
    }

    public final void zzdj(Context context) {
        zzcgm zzcgm = this.zza;
        if (zzcgm != null) {
            zzcgm.destroy();
        }
    }

    public final void zzdl(Context context) {
        zzcgm zzcgm = this.zza;
        if (zzcgm != null) {
            zzcgm.onPause();
        }
    }

    public final void zzdm(Context context) {
        zzcgm zzcgm = this.zza;
        if (zzcgm != null) {
            zzcgm.onResume();
        }
    }
}
