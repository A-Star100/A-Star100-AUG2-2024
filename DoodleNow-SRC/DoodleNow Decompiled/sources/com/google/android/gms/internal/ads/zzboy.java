package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzboy implements zzcby {
    final /* synthetic */ zzbow zza;

    zzboy(zzbpb zzbpb, zzbow zzbow) {
        this.zza = zzbow;
    }

    public final void zza() {
        zze.zza("Rejecting reference for JS Engine.");
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhI)).booleanValue()) {
            this.zza.zzh(new IllegalStateException("Unable to create JS engine reference."), "SdkJavascriptFactory.createNewReference.FailureCallback");
        } else {
            this.zza.zzg();
        }
    }
}
