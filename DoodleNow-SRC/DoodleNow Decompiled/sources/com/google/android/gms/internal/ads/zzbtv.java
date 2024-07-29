package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbtv implements NativeCustomFormatAd.DisplayOpenMeasurement {
    private final zzbhy zza;

    public zzbtv(zzbhy zzbhy) {
        this.zza = zzbhy;
        try {
            zzbhy.zzm();
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.zza.zzp(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zza.zzt();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return false;
        }
    }
}
