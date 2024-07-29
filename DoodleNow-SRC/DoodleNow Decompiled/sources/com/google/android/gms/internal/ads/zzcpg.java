package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcpg implements zzgdl {
    public final /* synthetic */ Uri.Builder zza;

    public /* synthetic */ zzcpg(Uri.Builder builder) {
        this.zza = builder;
    }

    public final ListenableFuture zza(Object obj) {
        zzbdq zzbdq = zzbdz.zzjX;
        Uri.Builder builder = this.zza;
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbdq), "12");
        return zzgee.zzh(builder.toString());
    }
}
