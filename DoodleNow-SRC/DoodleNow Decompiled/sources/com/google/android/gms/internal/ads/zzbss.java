package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzbss implements MediationAdLoadCallback {
    final /* synthetic */ zzbsb zza;
    final /* synthetic */ zzbqu zzb;

    zzbss(zzbta zzbta, zzbsb zzbsb, zzbqu zzbqu) {
        this.zza = zzbsb;
        this.zzb = zzbqu;
    }

    public final void onFailure(AdError adError) {
        try {
            this.zza.zzf(adError.zza());
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        MediationBannerAd mediationBannerAd = (MediationBannerAd) obj;
        if (mediationBannerAd == null) {
            zzm.zzj("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zza.zze("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzm.zzh("", e);
                return null;
            }
        } else {
            try {
                this.zza.zzg(ObjectWrapper.wrap(mediationBannerAd.getView()));
            } catch (RemoteException e2) {
                zzm.zzh("", e2);
            }
            return new zzbtb(this.zzb);
        }
    }

    public final void onFailure(String str) {
        onFailure(new AdError(0, str, AdError.UNDEFINED_DOMAIN));
    }
}
