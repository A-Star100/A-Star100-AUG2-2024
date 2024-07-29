package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdt;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdqh extends VideoController.VideoLifecycleCallbacks {
    private final zzdky zza;

    public zzdqh(zzdky zzdky) {
        this.zza = zzdky;
    }

    private static zzdt zza(zzdky zzdky) {
        zzdq zzj = zzdky.zzj();
        if (zzj == null) {
            return null;
        }
        try {
            return zzj.zzi();
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void onVideoEnd() {
        zzdt zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zze();
            } catch (RemoteException e) {
                zzm.zzk("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoPause() {
        zzdt zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzg();
            } catch (RemoteException e) {
                zzm.zzk("Unable to call onVideoEnd()", e);
            }
        }
    }

    public final void onVideoStart() {
        zzdt zza2 = zza(this.zza);
        if (zza2 != null) {
            try {
                zza2.zzi();
            } catch (RemoteException e) {
                zzm.zzk("Unable to call onVideoEnd()", e);
            }
        }
    }
}
