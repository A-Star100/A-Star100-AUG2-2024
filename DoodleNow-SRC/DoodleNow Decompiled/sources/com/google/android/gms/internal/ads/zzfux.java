package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfux extends zzfua {
    final /* synthetic */ zzfuy zza;
    private final zzfvd zzb;

    zzfux(zzfuy zzfuy, zzfvd zzfvd) {
        this.zza = zzfuy;
        this.zzb = zzfvd;
    }

    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzfvb zzc = zzfvc.zzc();
        zzc.zzb(i);
        if (string != null) {
            zzc.zza(string);
        }
        this.zzb.zza(zzc.zzc());
        if (i == 8157) {
            this.zza.zzc();
        }
    }
}
