package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzo implements Callable {
    public final /* synthetic */ zzab zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ IObjectWrapper zzc;

    public /* synthetic */ zzo(zzab zzab, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zza = zzab;
        this.zzb = uri;
        this.zzc = iObjectWrapper;
    }

    public final Object call() {
        return this.zza.zzn(this.zzb, this.zzc);
    }
}
