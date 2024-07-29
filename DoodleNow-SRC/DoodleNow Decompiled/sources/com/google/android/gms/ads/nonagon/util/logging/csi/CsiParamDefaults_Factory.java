package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzhiv;
import com.google.android.gms.internal.ads.zzhjm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class CsiParamDefaults_Factory implements zzhiv<CsiParamDefaults> {
    private final zzhjm zza;
    private final zzhjm zzb;

    public CsiParamDefaults_Factory(zzhjm<Context> zzhjm, zzhjm<VersionInfoParcel> zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public static CsiParamDefaults_Factory create(zzhjm<Context> zzhjm, zzhjm<VersionInfoParcel> zzhjm2) {
        return new CsiParamDefaults_Factory(zzhjm, zzhjm2);
    }

    public static CsiParamDefaults newInstance(Context context, VersionInfoParcel versionInfoParcel) {
        return new CsiParamDefaults(context, versionInfoParcel);
    }

    /* renamed from: get */
    public CsiParamDefaults zzb() {
        return newInstance((Context) this.zza.zzb(), (VersionInfoParcel) this.zzb.zzb());
    }
}
