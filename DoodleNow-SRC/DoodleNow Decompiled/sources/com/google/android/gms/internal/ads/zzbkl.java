package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkl implements zzbky {
    zzbkl() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        try {
            String str = (String) map.get(ViewProps.ENABLED);
            if (!zzfvx.zzc(b.ac, str)) {
                if (!zzfvx.zzc("false", str)) {
                    return;
                }
            }
            zzfts.zzi(zzcgm.getContext()).zzm(Boolean.parseBoolean(str));
        } catch (IOException e) {
            zzu.zzo().zzw(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
