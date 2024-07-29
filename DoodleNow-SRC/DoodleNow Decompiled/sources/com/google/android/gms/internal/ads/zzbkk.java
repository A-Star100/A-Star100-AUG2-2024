package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkk implements zzbky {
    zzbkk() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        try {
            zzftr.zzj(zzcgm.getContext()).zzk();
            zzfts.zzi(zzcgm.getContext()).zzj();
        } catch (IOException e) {
            zzu.zzo().zzw(e, "DefaultGmsgHandlers.ResetPaid");
        }
    }
}
