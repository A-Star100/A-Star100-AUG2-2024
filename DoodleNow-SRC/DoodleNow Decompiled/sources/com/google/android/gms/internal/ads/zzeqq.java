package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeqq implements zzfwf {
    public static final /* synthetic */ zzeqq zza = new zzeqq();

    private /* synthetic */ zzeqq() {
    }

    public final Object apply(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return new zzequ(appSetIdInfo.getId(), appSetIdInfo.getScope());
    }
}
