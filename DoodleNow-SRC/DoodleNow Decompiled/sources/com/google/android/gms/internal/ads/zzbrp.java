package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbrp extends zzbqq {
    /* access modifiers changed from: private */
    public final Object zza;
    private zzbrr zzb;
    private zzbyb zzc;
    private IObjectWrapper zzd;
    /* access modifiers changed from: private */
    public View zze;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzf;
    /* access modifiers changed from: private */
    public UnifiedNativeAdMapper zzg;
    /* access modifiers changed from: private */
    public NativeAdMapper zzh;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzi;
    /* access modifiers changed from: private */
    public MediationInterscrollerAd zzj;
    /* access modifiers changed from: private */
    public MediationAppOpenAd zzk;
    private final String zzl = "";

    public zzbrp(Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzV(zzl zzl2) {
        Bundle bundle;
        Bundle bundle2 = zzl2.zzm;
        if (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) {
            return new Bundle();
        }
        return bundle;
    }

    private final Bundle zzW(String str, zzl zzl2, String str2) throws RemoteException {
        zzm.zze("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzl2 != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzl2.zzg);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzm.zzh("", th);
            throw new RemoteException();
        }
    }

    private static final boolean zzX(zzl zzl2) {
        if (zzl2.zzf) {
            return true;
        }
        zzay.zzb();
        return zzf.zzs();
    }

    private static final String zzY(String str, zzl zzl2) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzl2.zzu;
        }
    }

    public final void zzA(IObjectWrapper iObjectWrapper, zzl zzl2, String str, zzbqu zzbqu) throws RemoteException {
        zzl zzl3 = zzl2;
        String str2 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzm.zze("Requesting rewarded ad from adapter.");
            try {
                zzbrn zzbrn = new zzbrn(this, zzbqu);
                Bundle zzW = zzW(str2, zzl3, (String) null);
                Bundle zzV = zzV(zzl3);
                boolean zzX = zzX(zzl2);
                Location location = zzl3.zzk;
                int i = zzl3.zzg;
                int i2 = zzl3.zzt;
                String zzY = zzY(str2, zzl3);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW, zzV, zzX, location, i, i2, zzY, "");
                ((Adapter) this.zza).loadRewardedAd(mediationRewardedAdConfiguration, zzbrn);
            } catch (Exception e) {
                zzm.zzh("", e);
                zzbql.zza(iObjectWrapper, e, "adapter.loadRewardedAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzB(zzl zzl2, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzA(this.zzd, zzl2, str, new zzbrs((Adapter) obj, this.zzc));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj.getClass().getCanonicalName();
        zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    public final void zzC(IObjectWrapper iObjectWrapper, zzl zzl2, String str, zzbqu zzbqu) throws RemoteException {
        zzl zzl3 = zzl2;
        String str2 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzm.zze("Requesting rewarded interstitial ad from adapter.");
            try {
                zzbrn zzbrn = new zzbrn(this, zzbqu);
                Bundle zzW = zzW(str2, zzl3, (String) null);
                Bundle zzV = zzV(zzl3);
                boolean zzX = zzX(zzl2);
                Location location = zzl3.zzk;
                int i = zzl3.zzg;
                int i2 = zzl3.zzt;
                String zzY = zzY(str2, zzl3);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW, zzV, zzX, location, i, i2, zzY, "");
                ((Adapter) this.zza).loadRewardedInterstitialAd(mediationRewardedAdConfiguration, zzbrn);
            } catch (Exception e) {
                zzbql.zza(iObjectWrapper, e, "adapter.loadRewardedInterstitialAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zza;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zzE() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzF() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzG(boolean z) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
            } catch (Throwable th) {
                zzm.zzh("", th);
            }
        } else {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zze(canonicalName + " #009 Class mismatch: " + canonicalName2);
        }
    }

    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzm.zze("Show app open ad from adapter.");
            MediationAppOpenAd mediationAppOpenAd = this.zzk;
            if (mediationAppOpenAd != null) {
                try {
                    mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                } catch (RuntimeException e) {
                    zzbql.zza(iObjectWrapper, e, "adapter.appOpen.showAd");
                    throw e;
                }
            } else {
                zzm.zzg("Can not show null mediation app open ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzI() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationInterstitialAdapter) {
            zzm.zze("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zza).showInterstitial();
            } catch (Throwable th) {
                zzm.zzh("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        } else if (obj instanceof MediationInterstitialAdapter) {
            zzI();
        } else {
            zzm.zze("Show interstitial ad from adapter.");
            MediationInterstitialAd mediationInterstitialAd = this.zzf;
            if (mediationInterstitialAd != null) {
                try {
                    mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                } catch (RuntimeException e) {
                    zzbql.zza(iObjectWrapper, e, "adapter.interstitial.showAd");
                    throw e;
                }
            } else {
                zzm.zzg("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
    }

    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzm.zze("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzi;
            if (mediationRewardedAd != null) {
                try {
                    mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
                } catch (RuntimeException e) {
                    zzbql.zza(iObjectWrapper, e, "adapter.rewarded.showAd");
                    throw e;
                }
            } else {
                zzm.zzg("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzL() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzi;
            if (mediationRewardedAd != null) {
                try {
                    mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzd));
                } catch (RuntimeException e) {
                    zzbql.zza(this.zzd, e, "adapter.showVideo");
                    throw e;
                }
            } else {
                zzm.zzg("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final boolean zzM() {
        return false;
    }

    public final boolean zzN() throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            return this.zzc != null;
        }
        Object obj2 = this.zza;
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj2.getClass().getCanonicalName();
        zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    public final zzbqz zzO() {
        return null;
    }

    public final zzbra zzP() {
        return null;
    }

    public final Bundle zze() {
        return new Bundle();
    }

    public final Bundle zzf() {
        return new Bundle();
    }

    public final Bundle zzg() {
        return new Bundle();
    }

    public final zzdq zzh() {
        Object obj = this.zza;
        if (obj instanceof zza) {
            try {
                return ((zza) obj).getVideoController();
            } catch (Throwable th) {
                zzm.zzh("", th);
            }
        }
        return null;
    }

    public final zzbhy zzi() {
        zzbrr zzbrr = this.zzb;
        if (zzbrr == null) {
            return null;
        }
        zzbhz zzc2 = zzbrr.zzc();
        if (zzc2 instanceof zzbhz) {
            return zzc2.zza();
        }
        return null;
    }

    public final zzbqx zzj() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzj;
        if (mediationInterscrollerAd != null) {
            return new zzbrq(mediationInterscrollerAd);
        }
        return null;
    }

    public final zzbrd zzk() {
        UnifiedNativeAdMapper zza2;
        Object obj = this.zza;
        if (obj instanceof MediationNativeAdapter) {
            zzbrr zzbrr = this.zzb;
            if (zzbrr == null || (zza2 = zzbrr.zza()) == null) {
                return null;
            }
            return new zzbrv(zza2);
        } else if (!(obj instanceof Adapter)) {
            return null;
        } else {
            NativeAdMapper nativeAdMapper = this.zzh;
            if (nativeAdMapper != null) {
                return new zzbrt(nativeAdMapper);
            }
            UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzg;
            if (unifiedNativeAdMapper != null) {
                return new zzbrv(unifiedNativeAdMapper);
            }
            return null;
        }
    }

    public final zzbtc zzl() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbtc.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzbtc zzm() {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzbtc.zza(((Adapter) obj).getSDKVersionInfo());
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzm.zzh("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.zze);
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public final void zzo() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    public final void zzp(IObjectWrapper iObjectWrapper, zzl zzl2, String str, zzbyb zzbyb, String str2) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            this.zzd = iObjectWrapper;
            this.zzc = zzbyb;
            zzbyb.zzl(ObjectWrapper.wrap(this.zza));
            return;
        }
        Object obj2 = this.zza;
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = obj2.getClass().getCanonicalName();
        zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
        throw new RemoteException();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzq(com.google.android.gms.dynamic.IObjectWrapper r6, com.google.android.gms.internal.ads.zzbna r7, java.util.List r8) throws android.os.RemoteException {
        /*
            r5 = this;
            java.lang.Object r0 = r5.zza
            boolean r0 = r0 instanceof com.google.android.gms.ads.mediation.Adapter
            if (r0 == 0) goto L_0x00b8
            com.google.android.gms.internal.ads.zzbri r0 = new com.google.android.gms.internal.ads.zzbri
            r0.<init>(r5, r7)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Iterator r8 = r8.iterator()
        L_0x0014:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x00aa
            java.lang.Object r1 = r8.next()
            com.google.android.gms.internal.ads.zzbng r1 = (com.google.android.gms.internal.ads.zzbng) r1
            java.lang.String r2 = r1.zza
            int r3 = r2.hashCode()
            switch(r3) {
                case -1396342996: goto L_0x0066;
                case -1052618729: goto L_0x005c;
                case -239580146: goto L_0x0052;
                case 604727084: goto L_0x0048;
                case 1167692200: goto L_0x003e;
                case 1778294298: goto L_0x0034;
                case 1911491517: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x0070
        L_0x002a:
            java.lang.String r3 = "rewarded_interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 3
            goto L_0x0071
        L_0x0034:
            java.lang.String r3 = "app_open_ad"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 6
            goto L_0x0071
        L_0x003e:
            java.lang.String r3 = "app_open"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 5
            goto L_0x0071
        L_0x0048:
            java.lang.String r3 = "interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 1
            goto L_0x0071
        L_0x0052:
            java.lang.String r3 = "rewarded"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 2
            goto L_0x0071
        L_0x005c:
            java.lang.String r3 = "native"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 4
            goto L_0x0071
        L_0x0066:
            java.lang.String r3 = "banner"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0071
        L_0x0070:
            r2 = -1
        L_0x0071:
            r3 = 0
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0097;
                case 2: goto L_0x0094;
                case 3: goto L_0x0091;
                case 4: goto L_0x008e;
                case 5: goto L_0x008b;
                case 6: goto L_0x0076;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x009c
        L_0x0076:
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzlw
            com.google.android.gms.internal.ads.zzbdx r4 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r4.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x009c
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD
            goto L_0x009c
        L_0x008b:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD
            goto L_0x009c
        L_0x008e:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.NATIVE
            goto L_0x009c
        L_0x0091:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL
            goto L_0x009c
        L_0x0094:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.REWARDED
            goto L_0x009c
        L_0x0097:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.INTERSTITIAL
            goto L_0x009c
        L_0x009a:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.BANNER
        L_0x009c:
            if (r3 == 0) goto L_0x0014
            com.google.android.gms.ads.mediation.MediationConfiguration r2 = new com.google.android.gms.ads.mediation.MediationConfiguration
            android.os.Bundle r1 = r1.zzb
            r2.<init>(r3, r1)
            r7.add(r2)
            goto L_0x0014
        L_0x00aa:
            java.lang.Object r8 = r5.zza
            com.google.android.gms.ads.mediation.Adapter r8 = (com.google.android.gms.ads.mediation.Adapter) r8
            java.lang.Object r6 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r6)
            android.content.Context r6 = (android.content.Context) r6
            r8.initialize(r6, r0, r7)
            return
        L_0x00b8:
            android.os.RemoteException r6 = new android.os.RemoteException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbrp.zzq(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzbna, java.util.List):void");
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbyb zzbyb, List list) throws RemoteException {
        zzm.zzj("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    public final void zzs(zzl zzl2, String str) throws RemoteException {
        zzB(zzl2, str, (String) null);
    }

    public final void zzt(IObjectWrapper iObjectWrapper, zzl zzl2, String str, zzbqu zzbqu) throws RemoteException {
        zzl zzl3 = zzl2;
        String str2 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzm.zze("Requesting app open ad from adapter.");
            try {
                zzbro zzbro = new zzbro(this, zzbqu);
                Bundle zzW = zzW(str2, zzl3, (String) null);
                Bundle zzV = zzV(zzl3);
                boolean zzX = zzX(zzl2);
                Location location = zzl3.zzk;
                int i = zzl3.zzg;
                int i2 = zzl3.zzt;
                String zzY = zzY(str2, zzl3);
                MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration = r5;
                MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration2 = new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW, zzV, zzX, location, i, i2, zzY, "");
                ((Adapter) this.zza).loadAppOpenAd(mediationAppOpenAdConfiguration, zzbro);
            } catch (Exception e) {
                zzm.zzh("", e);
                zzbql.zza(iObjectWrapper, e, "adapter.loadAppOpenAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzu(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl2, String str, zzbqu zzbqu) throws RemoteException {
        zzv(iObjectWrapper, zzq, zzl2, str, (String) null, zzbqu);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl2, String str, String str2, zzbqu zzbqu) throws RemoteException {
        AdSize adSize;
        Date date;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzq zzq2 = zzq;
        zzl zzl3 = zzl2;
        String str3 = str;
        String str4 = str2;
        zzbqu zzbqu2 = zzbqu;
        Object obj = this.zza;
        if ((obj instanceof MediationBannerAdapter) || (obj instanceof Adapter)) {
            zzm.zze("Requesting banner ad from adapter.");
            if (zzq2.zzn) {
                adSize = zzb.zzd(zzq2.zze, zzq2.zzb);
            } else {
                adSize = zzb.zzc(zzq2.zze, zzq2.zzb, zzq2.zza);
            }
            AdSize adSize2 = adSize;
            Object obj2 = this.zza;
            if (obj2 instanceof MediationBannerAdapter) {
                try {
                    MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
                    List list = zzl3.zze;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzl3.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbrg zzbrg = new zzbrg(date, zzl3.zzd, hashSet, zzl3.zzk, zzX(zzl2), zzl3.zzg, zzl3.zzr, zzl3.zzt, zzY(str3, zzl3));
                    Bundle bundle = zzl3.zzm;
                    mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbrr(zzbqu2), zzW(str3, zzl3, str4), adSize2, zzbrg, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    zzm.zzh("", th);
                    zzbql.zza(iObjectWrapper2, th, "adapter.requestBannerAd");
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    zzbrj zzbrj = new zzbrj(this, zzbqu2);
                    MediationBannerAdConfiguration mediationBannerAdConfiguration = r3;
                    MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str3, zzl3, str4), zzV(zzl3), zzX(zzl2), zzl3.zzk, zzl3.zzg, zzl3.zzt, zzY(str3, zzl3), adSize2, this.zzl);
                    ((Adapter) obj2).loadBannerAd(mediationBannerAdConfiguration, zzbrj);
                } catch (Throwable th2) {
                    zzm.zzh("", th2);
                    zzbql.zza(iObjectWrapper, th2, "adapter.loadBannerAd");
                    throw new RemoteException();
                }
            }
        } else {
            zzm.zzj(MediationBannerAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
    }

    public final void zzw(IObjectWrapper iObjectWrapper, zzq zzq, zzl zzl2, String str, String str2, zzbqu zzbqu) throws RemoteException {
        zzq zzq2 = zzq;
        zzl zzl3 = zzl2;
        String str3 = str;
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzm.zze("Requesting interscroller ad from adapter.");
            try {
                Adapter adapter = (Adapter) this.zza;
                zzbrh zzbrh = new zzbrh(this, zzbqu, adapter);
                Bundle zzW = zzW(str3, zzl3, str2);
                Bundle zzV = zzV(zzl3);
                boolean zzX = zzX(zzl2);
                Location location = zzl3.zzk;
                int i = zzl3.zzg;
                int i2 = zzl3.zzt;
                String zzY = zzY(str3, zzl3);
                AdSize zze2 = zzb.zze(zzq2.zze, zzq2.zzb);
                MediationBannerAdConfiguration mediationBannerAdConfiguration = r6;
                MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW, zzV, zzX, location, i, i2, zzY, zze2, "");
                adapter.loadInterscrollerAd(mediationBannerAdConfiguration, zzbrh);
            } catch (Exception e) {
                zzm.zzh("", e);
                zzbql.zza(iObjectWrapper, e, "adapter.loadInterscrollerAd");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " #009 Class mismatch: " + canonicalName2);
            throw new RemoteException();
        }
    }

    public final void zzx(IObjectWrapper iObjectWrapper, zzl zzl2, String str, zzbqu zzbqu) throws RemoteException {
        zzy(iObjectWrapper, zzl2, str, (String) null, zzbqu);
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzl zzl2, String str, String str2, zzbqu zzbqu) throws RemoteException {
        Date date;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzl zzl3 = zzl2;
        String str3 = str;
        String str4 = str2;
        zzbqu zzbqu2 = zzbqu;
        Object obj = this.zza;
        if ((obj instanceof MediationInterstitialAdapter) || (obj instanceof Adapter)) {
            zzm.zze("Requesting interstitial ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationInterstitialAdapter) {
                try {
                    MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
                    List list = zzl3.zze;
                    HashSet hashSet = list != null ? new HashSet(list) : null;
                    long j = zzl3.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbrg zzbrg = new zzbrg(date, zzl3.zzd, hashSet, zzl3.zzk, zzX(zzl2), zzl3.zzg, zzl3.zzr, zzl3.zzt, zzY(str3, zzl3));
                    Bundle bundle = zzl3.zzm;
                    mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbrr(zzbqu2), zzW(str3, zzl3, str4), zzbrg, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
                } catch (Throwable th) {
                    zzm.zzh("", th);
                    zzbql.zza(iObjectWrapper2, th, "adapter.requestInterstitialAd");
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str3, zzl3, str4), zzV(zzl3), zzX(zzl2), zzl3.zzk, zzl3.zzg, zzl3.zzt, zzY(str3, zzl3), this.zzl), new zzbrk(this, zzbqu2));
                } catch (Throwable th2) {
                    zzm.zzh("", th2);
                    zzbql.zza(iObjectWrapper2, th2, "adapter.loadInterstitialAd");
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public final void zzz(IObjectWrapper iObjectWrapper, zzl zzl2, String str, String str2, zzbqu zzbqu, zzbgt zzbgt, List list) throws RemoteException {
        Date date;
        IObjectWrapper iObjectWrapper2 = iObjectWrapper;
        zzl zzl3 = zzl2;
        String str3 = str;
        String str4 = str2;
        zzbqu zzbqu2 = zzbqu;
        Object obj = this.zza;
        if ((obj instanceof MediationNativeAdapter) || (obj instanceof Adapter)) {
            zzm.zze("Requesting native ad from adapter.");
            Object obj2 = this.zza;
            if (obj2 instanceof MediationNativeAdapter) {
                try {
                    MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                    List list2 = zzl3.zze;
                    HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                    long j = zzl3.zzb;
                    if (j == -1) {
                        date = null;
                    } else {
                        date = new Date(j);
                    }
                    zzbru zzbru = new zzbru(date, zzl3.zzd, hashSet, zzl3.zzk, zzX(zzl2), zzl3.zzg, zzbgt, list, zzl3.zzr, zzl3.zzt, zzY(str3, zzl3));
                    Bundle bundle = zzl3.zzm;
                    Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                    this.zzb = new zzbrr(zzbqu2);
                    mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzb, zzW(str3, zzl3, str4), zzbru, bundle2);
                } catch (Throwable th) {
                    zzm.zzh("", th);
                    zzbql.zza(iObjectWrapper2, th, "adapter.requestNativeAd");
                    throw new RemoteException();
                }
            } else if (obj2 instanceof Adapter) {
                try {
                    zzbrm zzbrm = new zzbrm(this, zzbqu2);
                    Bundle zzW = zzW(str3, zzl3, str4);
                    Bundle zzV = zzV(zzl3);
                    boolean zzX = zzX(zzl2);
                    Location location = zzl3.zzk;
                    int i = zzl3.zzg;
                    int i2 = zzl3.zzt;
                    String zzY = zzY(str3, zzl3);
                    MediationNativeAdConfiguration mediationNativeAdConfiguration = r9;
                    MediationNativeAdConfiguration mediationNativeAdConfiguration2 = new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW, zzV, zzX, location, i, i2, zzY, this.zzl, zzbgt);
                    ((Adapter) obj2).loadNativeAdMapper(mediationNativeAdConfiguration, zzbrm);
                } catch (Throwable th2) {
                    zzm.zzh("", th2);
                    zzbql.zza(iObjectWrapper2, th2, "adapter.loadNativeAd");
                    throw new RemoteException();
                }
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = obj.getClass().getCanonicalName();
            zzm.zzj(canonicalName + " or " + canonicalName2 + " #009 Class mismatch: " + canonicalName3);
            throw new RemoteException();
        }
    }

    public zzbrp(MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }
}
