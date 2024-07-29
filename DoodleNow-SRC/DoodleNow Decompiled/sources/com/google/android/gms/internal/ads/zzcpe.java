package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.InputEvent;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcpe implements zzgdl {
    public final /* synthetic */ zzcpk zza;
    public final /* synthetic */ Uri.Builder zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ InputEvent zzd;

    public /* synthetic */ zzcpe(zzcpk zzcpk, Uri.Builder builder, String str, InputEvent inputEvent) {
        this.zza = zzcpk;
        this.zzb = builder;
        this.zzc = str;
        this.zzd = inputEvent;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd, (Integer) obj);
    }
}
