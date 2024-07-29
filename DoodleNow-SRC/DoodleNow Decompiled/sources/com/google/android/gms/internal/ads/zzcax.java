package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcax implements Runnable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzcbw zzb;

    zzcax(zzcay zzcay, Context context, zzcbw zzcbw) {
        this.zza = context;
        this.zzb = zzcbw;
    }

    public final void run() {
        try {
            this.zzb.zzc(AdvertisingIdClient.getAdvertisingIdInfo(this.zza));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzb.zzd(e);
            zzm.zzh("Exception while getting advertising Id info", e);
        }
    }
}
