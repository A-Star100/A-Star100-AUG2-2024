package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbps implements zzcby {
    final /* synthetic */ zzcbw zza;
    final /* synthetic */ zzbow zzb;

    zzbps(zzbpu zzbpu, zzcbw zzcbw, zzbow zzbow) {
        this.zza = zzcbw;
        this.zzb = zzbow;
    }

    public final void zza() {
        zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbpf("Unable to obtain a JavascriptEngine."));
        this.zzb.zzb();
    }
}
