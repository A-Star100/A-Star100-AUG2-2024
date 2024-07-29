package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.internal.client.zzdi;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdyc extends zzdi {
    final Map zza = new HashMap();
    private final Context zzb;
    private final WeakReference zzc;
    /* access modifiers changed from: private */
    public final zzdxq zzd;
    private final zzgep zze;
    private final zzdyd zzf;
    private zzdxf zzg;

    zzdyc(Context context, WeakReference weakReference, zzdxq zzdxq, zzdyd zzdyd, zzgep zzgep) {
        this.zzb = context;
        this.zzc = weakReference;
        this.zzd = zzdxq;
        this.zze = zzgep;
        this.zzf = zzdyd;
    }

    private final Context zzj() {
        Context context = (Context) this.zzc.get();
        return context == null ? this.zzb : context;
    }

    private static AdRequest zzk() {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        return ((AdRequest.Builder) new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle)).build();
    }

    /* access modifiers changed from: private */
    public static String zzl(Object obj) {
        ResponseInfo responseInfo;
        zzdn zzc2;
        if (obj instanceof LoadAdError) {
            responseInfo = ((LoadAdError) obj).getResponseInfo();
        } else if (obj instanceof AppOpenAd) {
            responseInfo = ((AppOpenAd) obj).getResponseInfo();
        } else if (obj instanceof InterstitialAd) {
            responseInfo = ((InterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedAd) {
            responseInfo = ((RewardedAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfo = ((RewardedInterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof AdView) {
            responseInfo = ((AdView) obj).getResponseInfo();
        } else if (!(obj instanceof NativeAd)) {
            return "";
        } else {
            responseInfo = ((NativeAd) obj).getResponseInfo();
        }
        if (responseInfo == null || (zzc2 = responseInfo.zzc()) == null) {
            return "";
        }
        try {
            return zzc2.zzh();
        } catch (RemoteException unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    public final synchronized void zzm(String str, String str2) {
        try {
            zzgee.zzr(this.zzg.zzb(str), new zzdya(this, str2), this.zze);
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "OutOfContextTester.setAdAsOutOfContext");
            this.zzd.zzk(str2);
        }
    }

    private final synchronized void zzn(String str, String str2) {
        try {
            zzgee.zzr(this.zzg.zzb(str), new zzdyb(this, str2), this.zze);
        } catch (NullPointerException e) {
            zzu.zzo().zzw(e, "OutOfContextTester.setAdAsShown");
            this.zzd.zzk(str2);
        }
    }

    public final void zze(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        ViewGroup viewGroup = (ViewGroup) ObjectWrapper.unwrap(iObjectWrapper2);
        if (context != null && viewGroup != null) {
            Object obj = this.zza.get(str);
            if (obj != null) {
                this.zza.remove(str);
            }
            if (obj instanceof AdView) {
                zzdyd.zza(context, viewGroup, (AdView) obj);
            } else if (obj instanceof NativeAd) {
                zzdyd.zzb(context, viewGroup, (NativeAd) obj);
            }
        }
    }

    public final void zzf(zzdxf zzdxf) {
        this.zzg = zzdxf;
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzg(String str, Object obj, String str2) {
        this.zza.put(str, obj);
        zzm(zzl(obj), str2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzh(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            int r0 = r8.hashCode()     // Catch:{ all -> 0x00e9 }
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1999289321: goto L_0x0040;
                case -1372958932: goto L_0x0036;
                case -428325382: goto L_0x002c;
                case 543046670: goto L_0x0022;
                case 1854800829: goto L_0x0018;
                case 1951953708: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ all -> 0x00e9 }
        L_0x000d:
            goto L_0x004a
        L_0x000e:
            java.lang.String r0 = "BANNER"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x004a
            r8 = r5
            goto L_0x004b
        L_0x0018:
            java.lang.String r0 = "REWARDED_INTERSTITIAL"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x004a
            r8 = r1
            goto L_0x004b
        L_0x0022:
            java.lang.String r0 = "REWARDED"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x004a
            r8 = r2
            goto L_0x004b
        L_0x002c:
            java.lang.String r0 = "APP_OPEN_AD"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x004a
            r8 = 0
            goto L_0x004b
        L_0x0036:
            java.lang.String r0 = "INTERSTITIAL"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x004a
            r8 = r4
            goto L_0x004b
        L_0x0040:
            java.lang.String r0 = "NATIVE"
            boolean r8 = r8.equals(r0)     // Catch:{ all -> 0x00e9 }
            if (r8 == 0) goto L_0x004a
            r8 = r3
            goto L_0x004b
        L_0x004a:
            r8 = -1
        L_0x004b:
            if (r8 == 0) goto L_0x00d7
            if (r8 == r5) goto L_0x00b5
            if (r8 == r4) goto L_0x00a3
            if (r8 == r3) goto L_0x007d
            if (r8 == r2) goto L_0x006b
            if (r8 == r1) goto L_0x0059
            monitor-exit(r6)
            return
        L_0x0059:
            android.content.Context r8 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdxy r1 = new com.google.android.gms.internal.ads.zzdxy     // Catch:{ all -> 0x00e9 }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd.load((android.content.Context) r8, (java.lang.String) r7, (com.google.android.gms.ads.AdRequest) r0, (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback) r1)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r6)
            return
        L_0x006b:
            android.content.Context r8 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdxx r1 = new com.google.android.gms.internal.ads.zzdxx     // Catch:{ all -> 0x00e9 }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.rewarded.RewardedAd.load((android.content.Context) r8, (java.lang.String) r7, (com.google.android.gms.ads.AdRequest) r0, (com.google.android.gms.ads.rewarded.RewardedAdLoadCallback) r1)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r6)
            return
        L_0x007d:
            com.google.android.gms.ads.AdLoader$Builder r8 = new com.google.android.gms.ads.AdLoader$Builder     // Catch:{ all -> 0x00e9 }
            android.content.Context r0 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            r8.<init>(r0, r7)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdxr r0 = new com.google.android.gms.internal.ads.zzdxr     // Catch:{ all -> 0x00e9 }
            r0.<init>(r6, r7, r9)     // Catch:{ all -> 0x00e9 }
            r8.forNativeAd(r0)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdxz r7 = new com.google.android.gms.internal.ads.zzdxz     // Catch:{ all -> 0x00e9 }
            r7.<init>(r6, r9)     // Catch:{ all -> 0x00e9 }
            r8.withAdListener(r7)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdLoader r7 = r8.build()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdRequest r8 = zzk()     // Catch:{ all -> 0x00e9 }
            r7.loadAd((com.google.android.gms.ads.AdRequest) r8)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r6)
            return
        L_0x00a3:
            android.content.Context r8 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdxw r1 = new com.google.android.gms.internal.ads.zzdxw     // Catch:{ all -> 0x00e9 }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.interstitial.InterstitialAd.load(r8, r7, r0, r1)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r6)
            return
        L_0x00b5:
            com.google.android.gms.ads.AdView r8 = new com.google.android.gms.ads.AdView     // Catch:{ all -> 0x00e9 }
            android.content.Context r0 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            r8.<init>(r0)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdSize r0 = com.google.android.gms.ads.AdSize.BANNER     // Catch:{ all -> 0x00e9 }
            r8.setAdSize(r0)     // Catch:{ all -> 0x00e9 }
            r8.setAdUnitId(r7)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdxv r0 = new com.google.android.gms.internal.ads.zzdxv     // Catch:{ all -> 0x00e9 }
            r0.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x00e9 }
            r8.setAdListener(r0)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdRequest r7 = zzk()     // Catch:{ all -> 0x00e9 }
            r8.loadAd(r7)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r6)
            return
        L_0x00d7:
            android.content.Context r8 = r6.zzj()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.AdRequest r0 = zzk()     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.internal.ads.zzdxu r1 = new com.google.android.gms.internal.ads.zzdxu     // Catch:{ all -> 0x00e9 }
            r1.<init>(r6, r7, r9)     // Catch:{ all -> 0x00e9 }
            com.google.android.gms.ads.appopen.AppOpenAd.load((android.content.Context) r8, (java.lang.String) r7, (com.google.android.gms.ads.AdRequest) r0, (int) r5, (com.google.android.gms.ads.appopen.AppOpenAd.AppOpenAdLoadCallback) r1)     // Catch:{ all -> 0x00e9 }
            monitor-exit(r6)
            return
        L_0x00e9:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyc.zzh(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a7, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzi(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzdxq r0 = r4.zzd     // Catch:{ all -> 0x00a8 }
            android.app.Activity r0 = r0.zzg()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x000b
            goto L_0x00a6
        L_0x000b:
            java.util.Map r1 = r4.zza     // Catch:{ all -> 0x00a8 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00a6
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzjn     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a8 }
            java.lang.Object r2 = r3.zza(r2)     // Catch:{ all -> 0x00a8 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x00a8 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x00a8 }
            if (r2 == 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.appopen.AppOpenAd     // Catch:{ all -> 0x00a8 }
            if (r2 != 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.interstitial.InterstitialAd     // Catch:{ all -> 0x00a8 }
            if (r2 != 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.rewarded.RewardedAd     // Catch:{ all -> 0x00a8 }
            if (r2 != 0) goto L_0x0035
            boolean r2 = r1 instanceof com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd     // Catch:{ all -> 0x00a8 }
            if (r2 == 0) goto L_0x003a
        L_0x0035:
            java.util.Map r2 = r4.zza     // Catch:{ all -> 0x00a8 }
            r2.remove(r5)     // Catch:{ all -> 0x00a8 }
        L_0x003a:
            java.lang.String r2 = zzl(r1)     // Catch:{ all -> 0x00a8 }
            r4.zzn(r2, r6)     // Catch:{ all -> 0x00a8 }
            boolean r6 = r1 instanceof com.google.android.gms.ads.appopen.AppOpenAd     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x004c
            com.google.android.gms.ads.appopen.AppOpenAd r1 = (com.google.android.gms.ads.appopen.AppOpenAd) r1     // Catch:{ all -> 0x00a8 }
            r1.show(r0)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r4)
            return
        L_0x004c:
            boolean r6 = r1 instanceof com.google.android.gms.ads.interstitial.InterstitialAd     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x0057
            com.google.android.gms.ads.interstitial.InterstitialAd r1 = (com.google.android.gms.ads.interstitial.InterstitialAd) r1     // Catch:{ all -> 0x00a8 }
            r1.show(r0)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r4)
            return
        L_0x0057:
            boolean r6 = r1 instanceof com.google.android.gms.ads.rewarded.RewardedAd     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x0064
            com.google.android.gms.ads.rewarded.RewardedAd r1 = (com.google.android.gms.ads.rewarded.RewardedAd) r1     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.internal.ads.zzdxs r5 = com.google.android.gms.internal.ads.zzdxs.zza     // Catch:{ all -> 0x00a8 }
            r1.show(r0, r5)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r4)
            return
        L_0x0064:
            boolean r6 = r1 instanceof com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x0071
            com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd r1 = (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd) r1     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.internal.ads.zzdxt r5 = com.google.android.gms.internal.ads.zzdxt.zza     // Catch:{ all -> 0x00a8 }
            r1.show(r0, r5)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r4)
            return
        L_0x0071:
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzjn     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00a8 }
            java.lang.Object r6 = r0.zza(r6)     // Catch:{ all -> 0x00a8 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x00a8 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x00a6
            boolean r6 = r1 instanceof com.google.android.gms.ads.AdView     // Catch:{ all -> 0x00a8 }
            if (r6 != 0) goto L_0x008b
            boolean r6 = r1 instanceof com.google.android.gms.ads.nativead.NativeAd     // Catch:{ all -> 0x00a8 }
            if (r6 == 0) goto L_0x00a6
        L_0x008b:
            android.content.Intent r6 = new android.content.Intent     // Catch:{ all -> 0x00a8 }
            r6.<init>()     // Catch:{ all -> 0x00a8 }
            android.content.Context r0 = r4.zzj()     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = "com.google.android.gms.ads.OutOfContextTestingActivity"
            r6.setClassName(r0, r1)     // Catch:{ all -> 0x00a8 }
            java.lang.String r1 = "adUnit"
            r6.putExtra(r1, r5)     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.ads.internal.util.zzt.zzT(r0, r6)     // Catch:{ all -> 0x00a8 }
            monitor-exit(r4)
            return
        L_0x00a6:
            monitor-exit(r4)
            return
        L_0x00a8:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdyc.zzi(java.lang.String, java.lang.String):void");
    }
}
