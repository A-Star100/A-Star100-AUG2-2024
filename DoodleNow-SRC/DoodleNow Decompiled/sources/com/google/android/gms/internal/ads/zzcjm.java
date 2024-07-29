package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcjm implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzcjm(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    /* renamed from: zza */
    public final zzbwx zzb() {
        Context zza2 = ((zzciq) this.zza).zza();
        zzflk zzflk = (zzflk) this.zzb.zzb();
        zzu.zzf().zzb(zza2, VersionInfoParcel.forPackage(), zzflk).zza("google.afma.request.getAdDictionary", zzbpn.zza, zzbpn.zza);
        zzbpq zzb2 = zzu.zzf().zzb(zza2, VersionInfoParcel.forPackage(), zzflk);
        zzbpk zzbpk = zzbpn.zza;
        return new zzbwz(zza2, zzb2.zza("google.afma.sdkConstants.getSdkConstants", zzbpk, zzbpk), VersionInfoParcel.forPackage());
    }
}
