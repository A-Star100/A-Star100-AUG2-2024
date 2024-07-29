package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkg implements zzbky {
    zzbkg() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzfuz zzm = zzfva.zzm();
        zzm.zzb((String) map.get("appId"));
        zzm.zzi(zzcgm.getWidth());
        zzm.zzh(zzcgm.zzF().getWindowToken());
        if (!map.containsKey("gravityX") || !map.containsKey("gravityY")) {
            zzm.zzd(81);
        } else {
            zzm.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        }
        if (map.containsKey("verticalMargin")) {
            zzm.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzm.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzm.zza((String) map.get("enifd"));
        }
        try {
            zzu.zzj().zzj(zzcgm, zzm.zzj());
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "DefaultGmsgHandlers.ShowLMDOverlay");
            zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
