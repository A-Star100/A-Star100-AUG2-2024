package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcql implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzcql(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        String str = (String) this.zzc.zzb();
        boolean equals = "native".equals(str);
        zzu.zzp();
        return new zzazu(UUID.randomUUID().toString(), ((zzcjc) this.zza).zza(), str, (JSONObject) this.zzb.zzb(), false, equals);
    }
}
