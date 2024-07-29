package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.common.util.CollectionUtils;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzblf implements zzbky {
    static final Map zza = CollectionUtils.mapOfKeyValueArrays(new String[]{WebViewManager.EVENT_TYPE_RESIZE, "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zzb zzb;
    private final zzbtm zzc;
    private final zzbtt zzd;

    public zzblf(zzb zzb2, zzbtm zzbtm, zzbtt zzbtt) {
        this.zzb = zzb2;
        this.zzc = zzbtm;
        this.zzd = zzbtt;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        int intValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i = 6;
        boolean z = true;
        if (intValue != 5) {
            if (intValue != 7) {
                zzb zzb2 = this.zzb;
                if (!zzb2.zzc()) {
                    zzb2.zzb((String) null);
                    return;
                } else if (intValue == 1) {
                    this.zzc.zzb(map);
                    return;
                } else if (intValue == 3) {
                    new zzbtp(zzcgm, map).zzb();
                    return;
                } else if (intValue == 4) {
                    new zzbtj(zzcgm, map).zzc();
                    return;
                } else if (intValue != 5) {
                    if (intValue == 6) {
                        this.zzc.zza(true);
                        return;
                    } else if (intValue != 7) {
                        zzm.zzi("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            z = Boolean.parseBoolean((String) map.get("allowOrientationChange"));
        }
        if (zzcgm == null) {
            zzm.zzj("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            i = z ? -1 : 14;
        }
        zzcgm.zzar(i);
    }
}
