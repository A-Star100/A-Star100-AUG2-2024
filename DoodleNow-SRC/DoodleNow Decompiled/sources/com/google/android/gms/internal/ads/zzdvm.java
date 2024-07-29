package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdvm {
    private final zzblx zza;

    zzdvm(zzblx zzblx) {
        this.zza = zzblx;
    }

    private final void zzs(zzdvl zzdvl) throws RemoteException {
        String zza2 = zzdvl.zza(zzdvl);
        zzm.zzi("Dispatching AFMA event on publisher webview: ".concat(zza2));
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdvl("initialize", (zzdvk) null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("interstitial", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onAdClicked";
        this.zza.zzb(zzdvl.zza(zzdvl));
    }

    public final void zzc(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("interstitial", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onAdClosed";
        zzs(zzdvl);
    }

    public final void zzd(long j, int i) throws RemoteException {
        zzdvl zzdvl = new zzdvl("interstitial", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onAdFailedToLoad";
        zzdvl.zzd = Integer.valueOf(i);
        zzs(zzdvl);
    }

    public final void zze(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("interstitial", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onAdLoaded";
        zzs(zzdvl);
    }

    public final void zzf(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("interstitial", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdvl);
    }

    public final void zzg(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("interstitial", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onAdOpened";
        zzs(zzdvl);
    }

    public final void zzh(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("creation", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "nativeObjectCreated";
        zzs(zzdvl);
    }

    public final void zzi(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("creation", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "nativeObjectNotCreated";
        zzs(zzdvl);
    }

    public final void zzj(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onAdClicked";
        zzs(zzdvl);
    }

    public final void zzk(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onRewardedAdClosed";
        zzs(zzdvl);
    }

    public final void zzl(long j, zzbyg zzbyg) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onUserEarnedReward";
        zzdvl.zze = zzbyg.zzf();
        zzdvl.zzf = Integer.valueOf(zzbyg.zze());
        zzs(zzdvl);
    }

    public final void zzm(long j, int i) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onRewardedAdFailedToLoad";
        zzdvl.zzd = Integer.valueOf(i);
        zzs(zzdvl);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onRewardedAdFailedToShow";
        zzdvl.zzd = Integer.valueOf(i);
        zzs(zzdvl);
    }

    public final void zzo(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onAdImpression";
        zzs(zzdvl);
    }

    public final void zzp(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onRewardedAdLoaded";
        zzs(zzdvl);
    }

    public final void zzq(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdvl);
    }

    public final void zzr(long j) throws RemoteException {
        zzdvl zzdvl = new zzdvl("rewarded", (zzdvk) null);
        zzdvl.zza = Long.valueOf(j);
        zzdvl.zzc = "onRewardedAdOpened";
        zzs(zzdvl);
    }
}
