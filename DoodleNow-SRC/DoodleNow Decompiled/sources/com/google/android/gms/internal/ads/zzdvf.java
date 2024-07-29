package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdvf implements AppEventListener, zzdbl, zza, zzcyq, zzczk, zzczl, zzdae, zzcyt, zzfko {
    private final List zza;
    private final zzdut zzb;
    private long zzc;

    public zzdvf(zzdut zzdut, zzcik zzcik) {
        this.zzb = zzdut;
        this.zza = Collections.singletonList(zzcik);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(String.valueOf(cls.getSimpleName())), str, objArr);
    }

    public final void onAdClicked() {
        zzg(zza.class, "onAdClicked", new Object[0]);
    }

    public final void onAppEvent(String str, String str2) {
        zzg(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void zza() {
        zzg(zzcyq.class, "onAdClosed", new Object[0]);
    }

    public final void zzb() {
        zzg(zzcyq.class, "onAdLeftApplication", new Object[0]);
    }

    public final void zzc() {
        zzg(zzcyq.class, "onAdOpened", new Object[0]);
    }

    public final void zzd(zzfkh zzfkh, String str) {
        zzg(zzfkg.class, "onTaskSucceeded", str);
    }

    public final void zzdB(zze zze) {
        zzg(zzcyt.class, "onAdFailedToLoad", Integer.valueOf(zze.zza), zze.zzb, zze.zzc);
    }

    public final void zzdC(zzfkh zzfkh, String str) {
        zzg(zzfkg.class, "onTaskCreated", str);
    }

    public final void zzdD(zzfkh zzfkh, String str, Throwable th) {
        zzg(zzfkg.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzdE(zzfkh zzfkh, String str) {
        zzg(zzfkg.class, "onTaskStarted", str);
    }

    public final void zzdj(Context context) {
        zzg(zzczl.class, "onDestroy", context);
    }

    public final void zzdl(Context context) {
        zzg(zzczl.class, "onPause", context);
    }

    public final void zzdm(Context context) {
        zzg(zzczl.class, "onResume", context);
    }

    public final void zzdn(zzbxd zzbxd) {
        this.zzc = zzu.zzB().elapsedRealtime();
        zzg(zzdbl.class, "onAdRequest", new Object[0]);
    }

    public final void zzdo(zzffz zzffz) {
    }

    @ParametersAreNonnullByDefault
    public final void zzds(zzbxq zzbxq, String str, String str2) {
        zzg(zzcyq.class, "onRewarded", zzbxq, str, str2);
    }

    public final void zze() {
        zzg(zzcyq.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void zzf() {
        zzg(zzcyq.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzr() {
        zzg(zzczk.class, "onAdImpression", new Object[0]);
    }

    public final void zzs() {
        long elapsedRealtime = zzu.zzB().elapsedRealtime() - this.zzc;
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + elapsedRealtime);
        zzg(zzdae.class, "onAdLoaded", new Object[0]);
    }
}
