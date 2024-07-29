package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcen implements zzbky {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcdn zzcdn = (zzcdn) obj;
        zzchm zzq = zzcdn.zzq();
        if (zzq == null) {
            try {
                zzchm zzchm = new zzchm(zzcdn, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcdn.zzC(zzchm);
                zzq = zzchm;
            } catch (NullPointerException e) {
                e = e;
                zzm.zzh("Unable to parse videoMeta message.", e);
                zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e2) {
                e = e2;
                zzm.zzh("Unable to parse videoMeta message.", e);
                zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float parseFloat = Float.parseFloat((String) map.get("duration"));
        boolean equals = "1".equals(map.get("muted"));
        float parseFloat2 = Float.parseFloat((String) map.get("currentTime"));
        int parseInt = Integer.parseInt((String) map.get("playbackState"));
        if (parseInt < 0 || parseInt > 3) {
            parseInt = 0;
        }
        String str = (String) map.get(ViewProps.ASPECT_RATIO);
        float parseFloat3 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (zze.zzm(3)) {
            zzm.zze("Video Meta GMSG: currentTime : " + parseFloat2 + " , duration : " + parseFloat + " , isMuted : " + equals + " , playbackState : " + parseInt + " , aspectRatio : " + str);
        }
        zzq.zzc(parseFloat2, parseFloat, parseInt, equals, parseFloat3);
    }
}
