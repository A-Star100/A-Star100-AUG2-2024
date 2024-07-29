package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbhz {
    private final zzbhy zza;
    private final MediaView zzb;
    private final VideoController zzc = new VideoController();

    public zzbhz(zzbhy zzbhy) {
        Context context;
        this.zza = zzbhy;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbhy.zzh());
        } catch (RemoteException | NullPointerException e) {
            zzm.zzh("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (true == this.zza.zzs(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
        }
        this.zzb = mediaView;
    }

    public final zzbhy zza() {
        return this.zza;
    }

    public final String zzb() {
        try {
            return this.zza.zzi();
        } catch (RemoteException e) {
            zzm.zzh("", e);
            return null;
        }
    }
}
