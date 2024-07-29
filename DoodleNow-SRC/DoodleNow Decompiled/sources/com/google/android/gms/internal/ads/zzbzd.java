package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdx;
import com.google.android.gms.ads.internal.client.zzfd;
import com.google.android.gms.ads.internal.client.zzfe;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbzd extends RewardedInterstitialAd {
    private final String zza;
    private final zzbyj zzb;
    private final Context zzc;
    private final zzbzb zzd = new zzbzb();
    private FullScreenContentCallback zze;
    private OnAdMetadataChangedListener zzf;
    private OnPaidEventListener zzg;

    public zzbzd(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = zzay.zza().zzq(context, str, new zzbqk());
    }

    public final Bundle getAdMetadata() {
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                return zzbyj.zzb();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    public final ResponseInfo getResponseInfo() {
        zzdn zzdn = null;
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                zzdn = zzbyj.zzc();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zzb(zzdn);
    }

    public final RewardItem getRewardItem() {
        try {
            zzbyj zzbyj = this.zzb;
            zzbyg zzd2 = zzbyj != null ? zzbyj.zzd() : null;
            if (zzd2 != null) {
                return new zzbyt(zzd2);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z) {
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                zzbyj.zzh(z);
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                zzbyj.zzi(new zzfd(onAdMetadataChangedListener));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                zzbyj.zzj(new zzfe(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                zzbyj.zzl(new zzbyx(serverSideVerificationOptions));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                zzbyj.zzk(this.zzd);
                this.zzb.zzm(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzdx zzdx, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzbyj zzbyj = this.zzb;
            if (zzbyj != null) {
                zzbyj.zzg(zzp.zza.zza(this.zzc, zzdx), new zzbzc(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
