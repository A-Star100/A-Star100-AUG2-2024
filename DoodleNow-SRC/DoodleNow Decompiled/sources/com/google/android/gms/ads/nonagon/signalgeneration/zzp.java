package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.android.gms.internal.ads.zzgee;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzp implements zzgdl {
    public final /* synthetic */ zzab zza;

    public /* synthetic */ zzp(zzab zzab) {
        this.zza = zzab;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgee.zzm(this.zza.zzS("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzq(this.zza, (Uri) obj), this.zza.zzk);
    }
}
