package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdop implements zzazy {
    public final /* synthetic */ zzcgm zza;

    public /* synthetic */ zzdop(zzcgm zzcgm) {
        this.zza = zzcgm;
    }

    public final void zzdp(zzazx zzazx) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", true != zzazx.zzj ? SessionDescription.SUPPORTED_SDP_VERSION : "1");
        this.zza.zzd("onAdVisibilityChanged", hashMap);
    }
}
