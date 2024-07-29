package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzcat;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzr implements Callable {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ zzcat zzb;
    public final /* synthetic */ Bundle zzc;

    public /* synthetic */ zzr(zzab zzab, zzcat zzcat, Bundle bundle) {
        this.zza = zzab;
        this.zzb = zzcat;
        this.zzc = bundle;
    }

    public final Object call() {
        return this.zza.zzq(this.zzb, this.zzc);
    }
}
