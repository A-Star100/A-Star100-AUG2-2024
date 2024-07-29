package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcvy implements zza {
    private final zzcwc zza;
    private final zzfgi zzb;

    zzcvy(zzcwc zzcwc, zzfgi zzfgi) {
        this.zza = zzcwc;
        this.zzb = zzfgi;
    }

    public final void onAdClicked() {
        this.zza.zzc(this.zzb.zzf);
    }
}
