package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbbn extends AppOpenAd {
    FullScreenContentCallback zza;
    private final zzbbr zzb;
    private final String zzc;
    private final zzbbo zzd = new zzbbo();
    private OnPaidEventListener zze;

    public zzbbn(zzbbr zzbbr, String str) {
        this.zzb = zzbbr;
        this.zzc = str;
    }

    public final String getAdUnitId() {
        return this.zzc;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zza;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zze;
    }

    public final ResponseInfo getResponseInfo() {
        zzdn zzdn;
        try {
            zzdn = this.zzb.zzf();
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            zzdn = null;
        }
        return ResponseInfo.zzb(zzdn);
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zza = fullScreenContentCallback;
        this.zzd.zzg(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzb.zzg(z);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zze = onPaidEventListener;
        try {
            this.zzb.zzh(new zzfe(onPaidEventListener));
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity) {
        try {
            this.zzb.zzi(ObjectWrapper.wrap(activity), this.zzd);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
