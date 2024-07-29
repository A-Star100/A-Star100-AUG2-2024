package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzby;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdu;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeoi extends zzbt {
    private final zzq zza;
    private final Context zzb;
    private final zzfdq zzc;
    private final String zzd;
    private final VersionInfoParcel zze;
    private final zzeoa zzf;
    private final zzfeq zzg;
    private final zzawo zzh;
    private final zzduh zzi;
    /* access modifiers changed from: private */
    public zzdhl zzj;
    private boolean zzk = ((Boolean) zzba.zzc().zza(zzbdz.zzaD)).booleanValue();

    public zzeoi(Context context, zzq zzq, String str, zzfdq zzfdq, zzeoa zzeoa, zzfeq zzfeq, VersionInfoParcel versionInfoParcel, zzawo zzawo, zzduh zzduh) {
        this.zza = zzq;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfdq;
        this.zzf = zzeoa;
        this.zzg = zzfeq;
        this.zze = versionInfoParcel;
        this.zzh = zzawo;
        this.zzi = zzduh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zze() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzdhl r0 = r1.zzj     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.zza()     // Catch:{ all -> 0x0011 }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r1)
            r0 = 1
            return r0
        L_0x000e:
            monitor-exit(r1)
            r0 = 0
            return r0
        L_0x0011:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoi.zze():boolean");
    }

    public final void zzA() {
    }

    public final synchronized void zzB() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdhl zzdhl = this.zzj;
        if (zzdhl != null) {
            zzdhl.zzm().zzc((Context) null);
        }
    }

    public final void zzC(zzbe zzbe) {
    }

    public final void zzD(zzbh zzbh) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzf.zzj(zzbh);
    }

    public final void zzE(zzby zzby) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    public final void zzF(zzq zzq) {
    }

    public final void zzG(zzcb zzcb) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzm(zzcb);
    }

    public final void zzH(zzbbu zzbbu) {
    }

    public final void zzI(zzw zzw) {
    }

    public final void zzJ(zzci zzci) {
        this.zzf.zzn(zzci);
    }

    public final void zzK(zzdu zzdu) {
    }

    public final synchronized void zzL(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z;
    }

    public final void zzM(zzbuy zzbuy) {
    }

    public final void zzN(boolean z) {
    }

    public final synchronized void zzO(zzbeu zzbeu) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbeu);
    }

    public final void zzP(zzdg zzdg) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdg.zzf()) {
                this.zzi.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzf.zzl(zzdg);
    }

    public final void zzQ(zzbvb zzbvb, String str) {
    }

    public final void zzR(String str) {
    }

    public final void zzS(zzbxw zzbxw) {
        this.zzg.zzm(zzbxw);
    }

    public final void zzT(String str) {
    }

    public final void zzU(zzfk zzfk) {
    }

    public final synchronized void zzW(IObjectWrapper iObjectWrapper) {
        if (this.zzj == null) {
            zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfhk.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcC)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzX() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            zzm.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzq(zzfhk.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcC)).booleanValue()) {
            this.zzh.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzj.zzc(this.zzk, (Activity) null);
    }

    public final synchronized boolean zzY() {
        return this.zzc.zza();
    }

    public final synchronized boolean zzZ() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zze();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzaa(com.google.android.gms.ads.internal.client.zzl r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.internal.ads.zzbff r0 = com.google.android.gms.internal.ads.zzbfr.zzi     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = r0.zze()     // Catch:{ all -> 0x008b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008b }
            r1 = 0
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzkP     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = r2.zza(r0)     // Catch:{ all -> 0x008b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x008b }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x0024
            r0 = 1
            goto L_0x0025
        L_0x0024:
            r0 = r1
        L_0x0025:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.zze     // Catch:{ all -> 0x008b }
            int r2 = r2.clientJarVersion     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbdq r3 = com.google.android.gms.internal.ads.zzbdz.zzkQ     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzbdx r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008b }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x008b }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x008b }
            int r3 = r3.intValue()     // Catch:{ all -> 0x008b }
            if (r2 < r3) goto L_0x003d
            if (r0 != 0) goto L_0x0042
        L_0x003d:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x008b }
        L_0x0042:
            com.google.android.gms.ads.internal.zzu.zzp()     // Catch:{ all -> 0x008b }
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x008b }
            boolean r0 = com.google.android.gms.ads.internal.util.zzt.zzH(r0)     // Catch:{ all -> 0x008b }
            r2 = 0
            if (r0 == 0) goto L_0x0064
            com.google.android.gms.ads.internal.client.zzc r0 = r6.zzs     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0064
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r6)     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzeoa r6 = r5.zzf     // Catch:{ all -> 0x008b }
            if (r6 == 0) goto L_0x0089
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfhk.zzd(r0, r2, r2)     // Catch:{ all -> 0x008b }
            r6.zzdB(r0)     // Catch:{ all -> 0x008b }
            goto L_0x0089
        L_0x0064:
            boolean r0 = r5.zze()     // Catch:{ all -> 0x008b }
            if (r0 != 0) goto L_0x0089
            android.content.Context r0 = r5.zzb     // Catch:{ all -> 0x008b }
            boolean r1 = r6.zzf     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzfhf.zza(r0, r1)     // Catch:{ all -> 0x008b }
            r5.zzj = r2     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzfdq r0 = r5.zzc     // Catch:{ all -> 0x008b }
            java.lang.String r1 = r5.zzd     // Catch:{ all -> 0x008b }
            com.google.android.gms.ads.internal.client.zzq r2 = r5.zza     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzfdj r3 = new com.google.android.gms.internal.ads.zzfdj     // Catch:{ all -> 0x008b }
            r3.<init>(r2)     // Catch:{ all -> 0x008b }
            com.google.android.gms.internal.ads.zzeoh r2 = new com.google.android.gms.internal.ads.zzeoh     // Catch:{ all -> 0x008b }
            r2.<init>(r5)     // Catch:{ all -> 0x008b }
            boolean r6 = r0.zzb(r6, r1, r3, r2)     // Catch:{ all -> 0x008b }
            monitor-exit(r5)
            return r6
        L_0x0089:
            monitor-exit(r5)
            return r1
        L_0x008b:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoi.zzaa(com.google.android.gms.ads.internal.client.zzl):boolean");
    }

    public final void zzab(zzcf zzcf) {
    }

    public final Bundle zzd() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    public final zzq zzg() {
        return null;
    }

    public final zzbh zzi() {
        return this.zzf.zzg();
    }

    public final zzcb zzj() {
        return this.zzf.zzi();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.ads.internal.client.zzdn zzk() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzgQ     // Catch:{ all -> 0x0021 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0021 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0021 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0021 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0021 }
            if (r0 != 0) goto L_0x0014
            goto L_0x001e
        L_0x0014:
            com.google.android.gms.internal.ads.zzdhl r0 = r2.zzj     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzcyj r0 = r0.zzl()     // Catch:{ all -> 0x0021 }
            monitor-exit(r2)
            return r0
        L_0x001e:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0021:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoi.zzk():com.google.android.gms.ads.internal.client.zzdn");
    }

    public final zzdq zzl() {
        return null;
    }

    public final IObjectWrapper zzn() {
        return null;
    }

    public final synchronized String zzr() {
        return this.zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzs() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdhl r0 = r2.zzj     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcyj r1 = r0.zzl()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcyj r0 = r0.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoi.zzs():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zzt() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdhl r0 = r2.zzj     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcyj r1 = r0.zzl()     // Catch:{ all -> 0x0018 }
            if (r1 == 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcyj r0 = r0.zzl()     // Catch:{ all -> 0x0018 }
            java.lang.String r0 = r0.zzg()     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return r0
        L_0x0015:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0018:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoi.zzt():java.lang.String");
    }

    public final synchronized void zzx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdhl zzdhl = this.zzj;
        if (zzdhl != null) {
            zzdhl.zzm().zza((Context) null);
        }
    }

    public final void zzy(zzl zzl, zzbk zzbk) {
        this.zzf.zzk(zzbk);
        zzaa(zzl);
    }

    public final synchronized void zzz() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdhl zzdhl = this.zzj;
        if (zzdhl != null) {
            zzdhl.zzm().zzb((Context) null);
        }
    }
}
