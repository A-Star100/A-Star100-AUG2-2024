package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzblq implements zzbky {
    private final zzblp zza;

    public zzblq(zzblp zzblp) {
        this.zza = zzblp;
    }

    public static void zzb(zzcgm zzcgm, zzblp zzblp) {
        zzcgm.zzae("/reward", new zzblq(zzblp));
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("action");
        if ("grant".equals(str)) {
            zzbyc zzbyc = null;
            try {
                int parseInt = Integer.parseInt((String) map.get("amount"));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzbyc = new zzbyc(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse reward amount.", e);
            }
            this.zza.zza(zzbyc);
        } else if ("video_start".equals(str)) {
            this.zza.zzc();
        } else if ("video_complete".equals(str)) {
            this.zza.zzb();
        }
    }
}
