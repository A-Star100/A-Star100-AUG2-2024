package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzehr implements zzgdl {
    public final /* synthetic */ zzehu zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ zzffn zzc;

    public /* synthetic */ zzehr(zzehu zzehu, View view, zzffn zzffn) {
        this.zza = zzehu;
        this.zzb = view;
        this.zzc = zzffn;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, obj);
    }
}
