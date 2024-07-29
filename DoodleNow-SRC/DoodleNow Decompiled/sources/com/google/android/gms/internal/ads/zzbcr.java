package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbcr implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbcj zza;
    final /* synthetic */ zzcbw zzb;
    final /* synthetic */ zzbct zzc;

    zzbcr(zzbct zzbct, zzbcj zzbcj, zzcbw zzcbw) {
        this.zza = zzbcj;
        this.zzb = zzcbw;
        this.zzc = zzbct;
    }

    public final void onConnectionSuspended(int i) {
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzbct zzbct = this.zzc;
            if (!zzbct.zzb) {
                zzbct.zzb = true;
                zzbci zza2 = this.zzc.zza;
                if (zza2 != null) {
                    ListenableFuture zza3 = zzcbr.zza.zza(new zzbco(this, zza2, this.zza, this.zzb));
                    zzcbw zzcbw = this.zzb;
                    zzcbw.addListener(new zzbcp(zzcbw, zza3), zzcbr.zzf);
                }
            }
        }
    }
}
