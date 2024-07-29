package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeui implements zzewq {
    public final zzffm zza;

    public zzeui(zzffm zzffm) {
        this.zza = zzffm;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza != null) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzlB)).booleanValue()) {
                bundle.putBoolean("render_in_browser", this.zza.zzd());
                bundle.putBoolean("disable_ml", this.zza.zzc());
            }
        }
    }
}
