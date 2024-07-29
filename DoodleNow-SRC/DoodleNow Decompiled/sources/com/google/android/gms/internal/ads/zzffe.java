package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzffe extends zzbyi {
    private final zzffa zza;
    private final zzfeq zzb;
    private final String zzc;
    /* access modifiers changed from: private */
    public final zzfga zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzawo zzg;
    private final zzduh zzh;
    /* access modifiers changed from: private */
    public zzdqm zzi;
    private boolean zzj = ((Boolean) zzba.zzc().zza(zzbdz.zzaD)).booleanValue();

    public zzffe(String str, zzffa zzffa, Context context, zzfeq zzfeq, zzfga zzfga, VersionInfoParcel versionInfoParcel, zzawo zzawo, zzduh zzduh) {
        this.zzc = str;
        this.zza = zzffa;
        this.zzb = zzfeq;
        this.zzd = zzfga;
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzg = zzawo;
        this.zzh = zzduh;
    }

    private final synchronized void zzu(zzl zzl, zzbyq zzbyq, int i) throws RemoteException {
        boolean z = false;
        if (((Boolean) zzbfr.zzl.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzkP)).booleanValue()) {
                z = true;
            }
        }
        if (this.zzf.clientJarVersion < ((Integer) zzba.zzc().zza(zzbdz.zzkQ)).intValue() || !z) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        }
        this.zzb.zzk(zzbyq);
        zzu.zzp();
        if (zzt.zzH(this.zze)) {
            if (zzl.zzs == null) {
                zzm.zzg("Failed to load the ad because app ID is missing.");
                this.zzb.zzdB(zzfhk.zzd(4, (String) null, (zze) null));
                return;
            }
        }
        if (this.zzi == null) {
            zzfes zzfes = new zzfes((String) null);
            this.zza.zzj(i);
            this.zza.zzb(zzl, this.zzc, zzfes, new zzffd(this));
        }
    }

    public final Bundle zzb() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdqm zzdqm = this.zzi;
        return zzdqm != null ? zzdqm.zza() : new Bundle();
    }

    public final zzdn zzc() {
        zzdqm zzdqm;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgQ)).booleanValue() && (zzdqm = this.zzi) != null) {
            return zzdqm.zzl();
        }
        return null;
    }

    public final zzbyg zzd() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdqm zzdqm = this.zzi;
        if (zzdqm != null) {
            return zzdqm.zzc();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String zze() throws android.os.RemoteException {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzdqm r0 = r2.zzi     // Catch:{ all -> 0x0018 }
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffe.zze():java.lang.String");
    }

    public final synchronized void zzf(zzl zzl, zzbyq zzbyq) throws RemoteException {
        zzu(zzl, zzbyq, 2);
    }

    public final synchronized void zzg(zzl zzl, zzbyq zzbyq) throws RemoteException {
        zzu(zzl, zzbyq, 3);
    }

    public final synchronized void zzh(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzj = z;
    }

    public final void zzi(zzdd zzdd) {
        if (zzdd == null) {
            this.zzb.zzg((OnAdMetadataChangedListener) null);
        } else {
            this.zzb.zzg(new zzffc(this, zzdd));
        }
    }

    public final void zzj(zzdg zzdg) {
        Preconditions.checkMainThread("setOnPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdg.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            zzm.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzb.zzi(zzdg);
    }

    public final void zzk(zzbym zzbym) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzj(zzbym);
    }

    public final synchronized void zzl(zzbyx zzbyx) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzfga zzfga = this.zzd;
        zzfga.zza = zzbyx.zza;
        zzfga.zzb = zzbyx.zzb;
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzn(iObjectWrapper, this.zzj);
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzi == null) {
            zzm.zzj("Rewarded can not be shown before loaded");
            this.zzb.zzq(zzfhk.zzd(9, (String) null, (zze) null));
            return;
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcC)).booleanValue()) {
            this.zzg.zzc().zzn(new Throwable().getStackTrace());
        }
        this.zzi.zzh(z, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final boolean zzo() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzdqm zzdqm = this.zzi;
        return zzdqm != null && !zzdqm.zzf();
    }

    public final void zzp(zzbyr zzbyr) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        this.zzb.zzo(zzbyr);
    }
}
