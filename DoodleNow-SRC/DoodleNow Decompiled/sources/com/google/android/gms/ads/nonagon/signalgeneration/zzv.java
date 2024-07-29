package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzv implements Callable {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ List zzb;
    public final /* synthetic */ IObjectWrapper zzc;

    public /* synthetic */ zzv(zzab zzab, List list, IObjectWrapper iObjectWrapper) {
        this.zza = zzab;
        this.zzb = list;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzC(this.zzb, this.zzc);
    }
}
