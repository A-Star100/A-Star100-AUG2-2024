package com.google.android.gms.internal.ads;

import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcoi implements zzgdl {
    public static final /* synthetic */ zzcoi zza = new zzcoi();

    private /* synthetic */ zzcoi() {
    }

    public final ListenableFuture zza(Object obj) {
        zzu.zzo().zzw((Throwable) obj, "GetTopicsApiWithRecordObservationActionHandler");
        return zzgee.zzh(new GetTopicsResponse(zzfzn.zzm()));
    }
}
