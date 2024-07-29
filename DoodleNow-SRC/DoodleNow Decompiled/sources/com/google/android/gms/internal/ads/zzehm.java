package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzehm implements zzgdl {
    public final /* synthetic */ zzeho zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzffn zzc;

    public /* synthetic */ zzehm(zzeho zzeho, View view, zzffn zzffn) {
        this.zza = zzeho;
        this.zzb = view;
        this.zzc = zzffn;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
