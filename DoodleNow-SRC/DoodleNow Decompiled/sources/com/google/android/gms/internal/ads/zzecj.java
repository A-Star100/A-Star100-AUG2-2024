package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzecj implements Callable {
    public final /* synthetic */ zzbxd zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ ListenableFuture zzd;

    public /* synthetic */ zzecj(zzbxd zzbxd, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) {
        this.zza = zzbxd;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = listenableFuture3;
    }

    public final Object call() {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue() && (bundle = this.zza.zzm) != null) {
            bundle.putLong(zzdtq.HTTP_RESPONSE_READY.zza(), zzu.zzB().currentTimeMillis());
        }
        ListenableFuture listenableFuture = this.zzd;
        return new zzect((zzedh) this.zzb.get(), (JSONObject) this.zzc.get(), (zzbxg) listenableFuture.get());
    }
}
