package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzchd implements Runnable {
    public final /* synthetic */ zzchj zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ ValueCallback zzc;

    public /* synthetic */ zzchd(zzchj zzchj, String str, ValueCallback valueCallback) {
        this.zza = zzchj;
        this.zzb = str;
        this.zzc = valueCallback;
    }

    public final void run() {
        this.zza.zzaR(this.zzb, this.zzc);
    }
}
