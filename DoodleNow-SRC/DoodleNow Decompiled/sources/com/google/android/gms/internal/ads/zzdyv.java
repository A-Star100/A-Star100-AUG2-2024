package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdyv implements zzhiv {
    private final zzhjm zza;

    public zzdyv(zzhjm zzhjm) {
        this.zza = zzhjm;
    }

    /* renamed from: zza */
    public final ApplicationInfo zzb() {
        ApplicationInfo applicationInfo = ((Context) this.zza.zzb()).getApplicationInfo();
        zzhjd.zzb(applicationInfo);
        return applicationInfo;
    }
}
