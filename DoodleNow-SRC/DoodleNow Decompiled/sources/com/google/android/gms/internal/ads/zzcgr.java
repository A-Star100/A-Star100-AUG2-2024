package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcgr implements View.OnAttachStateChangeListener {
    final /* synthetic */ zzbzo zza;
    final /* synthetic */ zzcgu zzb;

    zzcgr(zzcgu zzcgu, zzbzo zzbzo) {
        this.zza = zzbzo;
        this.zzb = zzcgu;
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzb.zzW(view, this.zza, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
