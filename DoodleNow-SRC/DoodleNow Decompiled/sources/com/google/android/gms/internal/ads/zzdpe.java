package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdpe implements zzbgs {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdpf zzb;

    zzdpe(zzdpf zzdpf, String str) {
        this.zzb = zzdpf;
    }

    public final JSONObject zza() {
        return null;
    }

    public final JSONObject zzb() {
        return null;
    }

    public final void zzc() {
        zzdpf zzdpf = this.zzb;
        if (zzdpf.zzd != null) {
            zzdpf.zzd.zzE(this.zza);
        }
    }

    public final void zzd(MotionEvent motionEvent) {
    }
}
