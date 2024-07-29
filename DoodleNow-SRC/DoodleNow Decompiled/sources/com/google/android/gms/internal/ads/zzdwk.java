package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import com.polidea.rxandroidble2.ClientComponent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdwk {
    private boolean zza = false;
    private boolean zzb = false;
    /* access modifiers changed from: private */
    public boolean zzc = false;
    /* access modifiers changed from: private */
    public final long zzd;
    /* access modifiers changed from: private */
    public final zzcbw zze = new zzcbw();
    private final Context zzf;
    private final WeakReference zzg;
    private final zzdry zzh;
    /* access modifiers changed from: private */
    public final Executor zzi;
    private final Executor zzj;
    private final ScheduledExecutorService zzk;
    /* access modifiers changed from: private */
    public final zzdur zzl;
    private final VersionInfoParcel zzm;
    private final Map zzn = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final zzdfm zzo;
    /* access modifiers changed from: private */
    public final zzflk zzp;
    private boolean zzq = true;

    public zzdwk(Executor executor, Context context, WeakReference weakReference, Executor executor2, zzdry zzdry, ScheduledExecutorService scheduledExecutorService, zzdur zzdur, VersionInfoParcel versionInfoParcel, zzdfm zzdfm, zzflk zzflk) {
        this.zzh = zzdry;
        this.zzf = context;
        this.zzg = weakReference;
        this.zzi = executor2;
        this.zzk = scheduledExecutorService;
        this.zzj = executor;
        this.zzl = zzdur;
        this.zzm = versionInfoParcel;
        this.zzo = zzdfm;
        this.zzp = zzflk;
        this.zzd = zzu.zzB().elapsedRealtime();
        zzv("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    static /* bridge */ /* synthetic */ void zzj(zzdwk zzdwk, String str) {
        zzdwk zzdwk2 = zzdwk;
        zzfkw zza2 = zzfkv.zza(zzdwk2.zzf, zzflo.CUI_NAME_SDKINIT_ADAPTERINIT);
        zza2.zzi();
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzfkw zza3 = zzfkv.zza(zzdwk2.zzf, zzflo.CUI_NAME_SDKINIT_ADAPTERINIT);
                zza3.zzi();
                zza3.zze(next);
                Object obj = new Object();
                zzcbw zzcbw = new zzcbw();
                ListenableFuture zzo2 = zzgee.zzo(zzcbw, ((Long) zzba.zzc().zza(zzbdz.zzbO)).longValue(), TimeUnit.SECONDS, zzdwk2.zzk);
                zzdwk2.zzl.zzc(next);
                zzdwk2.zzo.zzc(next);
                long elapsedRealtime = zzu.zzB().elapsedRealtime();
                zzdwb zzdwb = r1;
                Iterator<String> it = keys;
                ListenableFuture listenableFuture = zzo2;
                zzdwb zzdwb2 = new zzdwb(zzdwk, obj, zzcbw, next, elapsedRealtime, zza3);
                listenableFuture.addListener(zzdwb, zzdwk2.zzi);
                arrayList.add(listenableFuture);
                zzdwj zzdwj = new zzdwj(zzdwk, obj, next, elapsedRealtime, zza3, zzcbw);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        int i = 0;
                        while (i < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                    jSONArray = jSONArray;
                                }
                            }
                            JSONArray jSONArray2 = jSONArray;
                            arrayList2.add(new zzbng(optString, bundle));
                            i++;
                            jSONArray = jSONArray2;
                        }
                    } catch (JSONException unused) {
                    }
                }
                zzdwk2.zzv(next, false, "", 0);
                try {
                    zzdwk2.zzj.execute(new zzdwf(zzdwk, next, zzdwj, zzdwk2.zzh.zzc(next, new JSONObject()), arrayList2));
                } catch (zzfgp unused2) {
                    try {
                        zzdwj.zze("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzm.zzh("", e);
                    }
                }
                keys = it;
            }
            zzgee.zza(arrayList).zza(new zzdwc(zzdwk2, zza2), zzdwk2.zzi);
        } catch (JSONException e2) {
            zze.zzb("Malformed CLD response", e2);
            zzdwk2.zzo.zza("MalformedJson");
            zzdwk2.zzl.zza("MalformedJson");
            zzdwk2.zze.zzd(e2);
            zzu.zzo().zzw(e2, "AdapterInitializer.updateAdapterStatus");
            zzflk zzflk = zzdwk2.zzp;
            zza2.zzh(e2);
            zza2.zzg(false);
            zzflk.zzb(zza2.zzm());
        }
    }

    private final synchronized ListenableFuture zzu() {
        String zzc2 = zzu.zzo().zzi().zzg().zzc();
        if (!TextUtils.isEmpty(zzc2)) {
            return zzgee.zzh(zzc2);
        }
        zzcbw zzcbw = new zzcbw();
        zzu.zzo().zzi().zzp(new zzdwd(this, zzcbw));
        return zzcbw;
    }

    /* access modifiers changed from: private */
    public final void zzv(String str, boolean z, String str2, int i) {
        this.zzn.put(str, new zzbmw(str, z, i, str2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzf(zzfkw zzfkw) throws Exception {
        this.zze.zzc(true);
        zzfkw.zzg(true);
        this.zzp.zzb(zzfkw.zzm());
        return null;
    }

    public final List zzg() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzn.keySet()) {
            zzbmw zzbmw = (zzbmw) this.zzn.get(str);
            arrayList.add(new zzbmw(str, zzbmw.zzb, zzbmw.zzc, zzbmw.zzd));
        }
        return arrayList;
    }

    public final void zzl() {
        this.zzq = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        synchronized (this) {
            if (!this.zzc) {
                zzv("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzu.zzB().elapsedRealtime() - this.zzd));
                this.zzl.zzb("com.google.android.gms.ads.MobileAds", ClientComponent.NamedSchedulers.TIMEOUT);
                this.zzo.zzb("com.google.android.gms.ads.MobileAds", ClientComponent.NamedSchedulers.TIMEOUT);
                this.zze.zzd(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0026 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zzn(java.lang.String r3, com.google.android.gms.internal.ads.zzbna r4, com.google.android.gms.internal.ads.zzfhg r5, java.util.List r6) {
        /*
            r2 = this;
            java.lang.String r0 = "Failed to initialize adapter. "
            java.lang.String r1 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r1 = java.util.Objects.equals(r3, r1)     // Catch:{ zzfgp -> 0x0026, RemoteException -> 0x001f }
            if (r1 == 0) goto L_0x000e
            r4.zzf()     // Catch:{ zzfgp -> 0x0026, RemoteException -> 0x001f }
            return
        L_0x000e:
            java.lang.ref.WeakReference r1 = r2.zzg     // Catch:{ zzfgp -> 0x0026, RemoteException -> 0x001f }
            java.lang.Object r1 = r1.get()     // Catch:{ zzfgp -> 0x0026, RemoteException -> 0x001f }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ zzfgp -> 0x0026, RemoteException -> 0x001f }
            if (r1 == 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            android.content.Context r1 = r2.zzf     // Catch:{ zzfgp -> 0x0026, RemoteException -> 0x001f }
        L_0x001b:
            r5.zzi(r1, r4, r6)     // Catch:{ zzfgp -> 0x0026, RemoteException -> 0x001f }
            return
        L_0x001f:
            r3 = move-exception
            com.google.android.gms.internal.ads.zzfxm r4 = new com.google.android.gms.internal.ads.zzfxm
            r4.<init>(r3)
            throw r4
        L_0x0026:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x003b }
            r5.<init>(r0)     // Catch:{ RemoteException -> 0x003b }
            r5.append(r3)     // Catch:{ RemoteException -> 0x003b }
            java.lang.String r3 = " does not implement the initialize() method."
            r5.append(r3)     // Catch:{ RemoteException -> 0x003b }
            java.lang.String r3 = r5.toString()     // Catch:{ RemoteException -> 0x003b }
            r4.zze(r3)     // Catch:{ RemoteException -> 0x003b }
            return
        L_0x003b:
            r3 = move-exception
            java.lang.String r4 = ""
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r4, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwk.zzn(java.lang.String, com.google.android.gms.internal.ads.zzbna, com.google.android.gms.internal.ads.zzfhg, java.util.List):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzcbw zzcbw) {
        this.zzi.execute(new zzdwa(this, zzcbw));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp() {
        this.zzl.zze();
        this.zzo.zze();
        this.zzb = true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(Object obj, zzcbw zzcbw, String str, long j, zzfkw zzfkw) {
        synchronized (obj) {
            if (!zzcbw.isDone()) {
                zzv(str, false, "Timeout.", (int) (zzu.zzB().elapsedRealtime() - j));
                this.zzl.zzb(str, ClientComponent.NamedSchedulers.TIMEOUT);
                this.zzo.zzb(str, ClientComponent.NamedSchedulers.TIMEOUT);
                zzflk zzflk = this.zzp;
                zzfkw.zzc("Timeout");
                zzfkw.zzg(false);
                zzflk.zzb(zzfkw.zzm());
                zzcbw.zzc(false);
            }
        }
    }

    public final void zzr() {
        if (!((Boolean) zzbfy.zza.zze()).booleanValue()) {
            if (this.zzm.clientJarVersion >= ((Integer) zzba.zzc().zza(zzbdz.zzbN)).intValue() && this.zzq) {
                if (!this.zza) {
                    synchronized (this) {
                        if (!this.zza) {
                            this.zzl.zzf();
                            this.zzo.zzf();
                            this.zze.addListener(new zzdwg(this), this.zzi);
                            this.zza = true;
                            ListenableFuture zzu = zzu();
                            this.zzk.schedule(new zzdvz(this), ((Long) zzba.zzc().zza(zzbdz.zzbP)).longValue(), TimeUnit.SECONDS);
                            zzgee.zzr(zzu, new zzdwi(this), this.zzi);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zza) {
            zzv("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zze.zzc(false);
            this.zza = true;
            this.zzb = true;
        }
    }

    public final void zzs(zzbnd zzbnd) {
        this.zze.addListener(new zzdwe(this, zzbnd), this.zzj);
    }

    public final boolean zzt() {
        return this.zzb;
    }
}
