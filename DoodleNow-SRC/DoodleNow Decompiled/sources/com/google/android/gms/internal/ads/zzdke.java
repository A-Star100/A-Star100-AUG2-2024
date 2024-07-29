package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdke implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzdke(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzcjc) this.zza).zza();
        zzu.zzp();
        return new zzazu(UUID.randomUUID().toString(), zza2, "native", new JSONObject(), false, true);
    }
}
