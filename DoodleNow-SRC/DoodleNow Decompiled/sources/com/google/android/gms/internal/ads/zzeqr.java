package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeqr implements zzgdl {
    public static final /* synthetic */ zzeqr zza = new zzeqr();

    private /* synthetic */ zzeqr() {
    }

    public final ListenableFuture zza(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        if (appSetIdInfo == null) {
            return zzgee.zzh(new zzequ((String) null, -1));
        }
        return zzgee.zzh(new zzequ(appSetIdInfo.getId(), appSetIdInfo.getScope()));
    }
}
