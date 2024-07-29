package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzca;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbkb implements zzbky {
    public static final /* synthetic */ zzbkb zza = new zzbkb();

    private /* synthetic */ zzbkb() {
    }

    public final void zza(Object obj, Map map) {
        zzchr zzchr = (zzchr) obj;
        zzbky zzbky = zzbkx.zza;
        String str = (String) map.get("u");
        if (str == null) {
            zzm.zzj("URL missing from httpTrack GMSG.");
        } else {
            new zzca(zzchr.getContext(), ((zzchy) zzchr).zzn().afmaVersion, str).zzb();
        }
    }
}
