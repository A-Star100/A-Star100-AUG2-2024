package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcn;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcna extends zzcn {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdry zzc;
    private final zzegl zzd;
    private final zzemw zze;
    private final zzdwk zzf;
    private final zzcad zzg;
    private final zzdsd zzh;
    private final zzdxf zzi;
    private final zzbgm zzj;
    private final zzflk zzk;
    private final zzfhe zzl;
    private final zzcwi zzm;
    private final zzduh zzn;
    private boolean zzo = false;
    private final Long zzp = Long.valueOf(zzu.zzB().elapsedRealtime());

    zzcna(Context context, VersionInfoParcel versionInfoParcel, zzdry zzdry, zzegl zzegl, zzemw zzemw, zzdwk zzdwk, zzcad zzcad, zzdsd zzdsd, zzdxf zzdxf, zzbgm zzbgm, zzflk zzflk, zzfhe zzfhe, zzcwi zzcwi, zzduh zzduh) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdry;
        this.zzd = zzegl;
        this.zze = zzemw;
        this.zzf = zzdwk;
        this.zzg = zzcad;
        this.zzh = zzdsd;
        this.zzi = zzdxf;
        this.zzj = zzbgm;
        this.zzk = zzflk;
        this.zzl = zzfhe;
        this.zzm = zzcwi;
        this.zzn = zzduh;
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (zzu.zzo().zzi().zzN()) {
            String zzk2 = zzu.zzo().zzi().zzk();
            if (!zzu.zzs().zzj(this.zza, zzk2, this.zzb.afmaVersion)) {
                zzu.zzo().zzi().zzA(false);
                zzu.zzo().zzi().zzz("");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map zze2 = zzu.zzo().zzi().zzg().zze();
        if (!zze2.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzm.zzk("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzc.zzd()) {
                HashMap hashMap = new HashMap();
                for (zzbqi zzbqi : zze2.values()) {
                    for (zzbqh zzbqh : zzbqi.zza) {
                        String str = zzbqh.zzk;
                        for (String str2 : zzbqh.zzc) {
                            if (!hashMap.containsKey(str2)) {
                                hashMap.put(str2, new ArrayList());
                            }
                            if (str != null) {
                                ((List) hashMap.get(str2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str3 = (String) entry.getKey();
                    try {
                        zzegm zza2 = this.zzd.zza(str3, jSONObject);
                        if (zza2 != null) {
                            zzfhg zzfhg = (zzfhg) zza2.zzb;
                            if (!zzfhg.zzC() && zzfhg.zzB()) {
                                zzfhg.zzj(this.zza, (zzeig) zza2.zzc, (List) entry.getValue());
                                zzm.zze("Initialized rewarded video mediation adapter " + str3);
                            }
                        }
                    } catch (zzfgp e) {
                        zzm.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        zzfhn.zzb(this.zza, true);
    }

    public final synchronized float zze() {
        return zzu.zzr().zza();
    }

    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    public final void zzi() {
        this.zzf.zzl();
    }

    public final void zzj(boolean z) throws RemoteException {
        try {
            zzfts.zzi(this.zza).zzn(z);
        } catch (IOException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public final synchronized void zzk() {
        if (this.zzo) {
            zzm.zzj("Mobile ads is initialized already.");
            return;
        }
        zzbdz.zza(this.zza);
        zzu.zzo().zzu(this.zza, this.zzb);
        this.zzm.zzc();
        zzu.zzc().zzi(this.zza);
        this.zzo = true;
        this.zzf.zzr();
        this.zze.zze();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdV)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzg();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjd)).booleanValue()) {
            zzcbr.zza.execute(new zzcmv(this));
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkC)).booleanValue()) {
            zzcbr.zza.execute(new zzcmx(this));
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcJ)).booleanValue()) {
            zzcbr.zza.execute(new zzcmw(this));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl(java.lang.String r12, com.google.android.gms.dynamic.IObjectWrapper r13) {
        /*
            r11 = this;
            android.content.Context r0 = r11.zza
            com.google.android.gms.internal.ads.zzbdz.zza(r0)
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzdZ
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ RemoteException -> 0x0021 }
            android.content.Context r0 = r11.zza     // Catch:{ RemoteException -> 0x0021 }
            java.lang.String r0 = com.google.android.gms.ads.internal.util.zzt.zzp(r0)     // Catch:{ RemoteException -> 0x0021 }
            goto L_0x002d
        L_0x0021:
            r0 = move-exception
            java.lang.String r1 = "NonagonMobileAdsSettingManager_AppId"
            com.google.android.gms.internal.ads.zzcbh r2 = com.google.android.gms.ads.internal.zzu.zzo()
            r2.zzw(r0, r1)
        L_0x002b:
            java.lang.String r0 = ""
        L_0x002d:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            if (r2 != r1) goto L_0x0036
            r6 = r12
            goto L_0x0037
        L_0x0036:
            r6 = r0
        L_0x0037:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 == 0) goto L_0x003e
            goto L_0x0093
        L_0x003e:
            com.google.android.gms.internal.ads.zzbdq r12 = com.google.android.gms.internal.ads.zzbdz.zzdT
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r12 = r0.zza(r12)
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzaQ
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r12 = r12 | r0
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzaQ
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x007d
            java.lang.Object r12 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r13)
            java.lang.Runnable r12 = (java.lang.Runnable) r12
            com.google.android.gms.internal.ads.zzcmy r13 = new com.google.android.gms.internal.ads.zzcmy
            r13.<init>(r11, r12)
            goto L_0x007f
        L_0x007d:
            r13 = 0
            r2 = r12
        L_0x007f:
            r7 = r13
            if (r2 == 0) goto L_0x0093
            android.content.Context r4 = r11.zza
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r11.zzb
            com.google.android.gms.internal.ads.zzflk r8 = r11.zzk
            com.google.android.gms.internal.ads.zzduh r9 = r11.zzn
            java.lang.Long r10 = r11.zzp
            com.google.android.gms.ads.internal.zzf r3 = com.google.android.gms.ads.internal.zzu.zza()
            r3.zza(r4, r5, r6, r7, r8, r9, r10)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcna.zzl(java.lang.String, com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    public final void zzm(zzda zzda) throws RemoteException {
        this.zzi.zzh(zzda, zzdxe.API);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzm.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzm.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        zzau zzau = new zzau(context);
        zzau.zzn(str);
        zzau.zzo(this.zzb.afmaVersion);
        zzau.zzr();
    }

    public final void zzo(zzbqo zzbqo) throws RemoteException {
        this.zzl.zzf(zzbqo);
    }

    public final synchronized void zzp(boolean z) {
        zzu.zzr().zzc(z);
    }

    public final synchronized void zzq(float f) {
        zzu.zzr().zzd(f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            android.content.Context r0 = r9.zza     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbdz.zza(r0)     // Catch:{ all -> 0x0033 }
            boolean r0 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0033 }
            if (r0 != 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzdT     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            android.content.Context r2 = r9.zza     // Catch:{ all -> 0x0033 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r9.zzb     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzflk r6 = r9.zzk     // Catch:{ all -> 0x0033 }
            com.google.android.gms.ads.internal.zzf r1 = com.google.android.gms.ads.internal.zzu.zza()     // Catch:{ all -> 0x0033 }
            r5 = 0
            r7 = 0
            r8 = 0
            r4 = r10
            r1.zza(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0033 }
            monitor-exit(r9)
            return
        L_0x0031:
            monitor-exit(r9)
            return
        L_0x0033:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcna.zzr(java.lang.String):void");
    }

    public final void zzs(zzbnd zzbnd) throws RemoteException {
        this.zzf.zzs(zzbnd);
    }

    public final void zzt(String str) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjo)).booleanValue()) {
            zzu.zzo().zzy(str);
        }
    }

    public final void zzu(zzff zzff) throws RemoteException {
        this.zzg.zzn(this.zza, zzff);
    }

    public final synchronized boolean zzv() {
        return zzu.zzr().zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbvx());
    }
}
