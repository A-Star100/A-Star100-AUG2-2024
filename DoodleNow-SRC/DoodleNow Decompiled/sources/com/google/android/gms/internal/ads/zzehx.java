package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzehx implements zzdiu {
    public final /* synthetic */ zzcbw zza;

    public /* synthetic */ zzehx(zzcbw zzcbw) {
        this.zza = zzcbw;
    }

    public final void zza(boolean z, Context context, zzczd zzczd) {
        zzcbw zzcbw = this.zza;
        try {
            zzu.zzi();
            zzn.zza(context, (AdOverlayInfoParcel) zzcbw.get(), true);
        } catch (Exception unused) {
        }
    }
}
