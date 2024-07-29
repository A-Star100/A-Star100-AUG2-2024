package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzbiu extends zzazp implements zzbiv {
    public static zzbiv zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IShouldDelayBannerRenderingListener");
        return queryLocalInterface instanceof zzbiv ? (zzbiv) queryLocalInterface : new zzbit(iBinder);
    }
}
