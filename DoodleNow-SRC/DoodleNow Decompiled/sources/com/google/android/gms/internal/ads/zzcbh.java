package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzj;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcbh {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final zzj zzb;
    private final zzcbl zzc;
    private boolean zzd;
    /* access modifiers changed from: private */
    public Context zze;
    /* access modifiers changed from: private */
    public VersionInfoParcel zzf;
    private String zzg;
    /* access modifiers changed from: private */
    public zzbee zzh;
    private Boolean zzi;
    private final AtomicInteger zzj;
    private final AtomicInteger zzk;
    private final zzcbg zzl;
    private final Object zzm;
    private ListenableFuture zzn;
    /* access modifiers changed from: private */
    public final AtomicBoolean zzo;

    public zzcbh() {
        zzj zzj2 = new zzj();
        this.zzb = zzj2;
        this.zzc = new zzcbl(zzay.zzd(), zzj2);
        this.zzd = false;
        this.zzh = null;
        this.zzi = null;
        this.zzj = new AtomicInteger(0);
        this.zzk = new AtomicInteger(0);
        this.zzl = new zzcbg((zzcbf) null);
        this.zzm = new Object();
        this.zzo = new AtomicBoolean();
    }

    public final int zza() {
        return this.zzk.get();
    }

    public final int zzb() {
        return this.zzj.get();
    }

    public final Context zzd() {
        return this.zze;
    }

    public final Resources zze() {
        if (this.zzf.isClientJar) {
            return this.zze.getResources();
        }
        try {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzkz)).booleanValue()) {
                return zzq.zza(this.zze).getResources();
            }
            zzq.zza(this.zze).getResources();
            return null;
        } catch (zzp e) {
            zzm.zzk("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final zzbee zzg() {
        zzbee zzbee;
        synchronized (this.zza) {
            zzbee = this.zzh;
        }
        return zzbee;
    }

    public final zzcbl zzh() {
        return this.zzc;
    }

    public final zzg zzi() {
        zzj zzj2;
        synchronized (this.zza) {
            zzj2 = this.zzb;
        }
        return zzj2;
    }

    public final ListenableFuture zzk() {
        if (this.zze != null) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzcE)).booleanValue()) {
                synchronized (this.zzm) {
                    ListenableFuture listenableFuture = this.zzn;
                    if (listenableFuture != null) {
                        return listenableFuture;
                    }
                    ListenableFuture zzb2 = zzcbr.zza.zzb(new zzcbc(this));
                    this.zzn = zzb2;
                    return zzb2;
                }
            }
        }
        return zzgee.zzh(new ArrayList());
    }

    public final Boolean zzl() {
        Boolean bool;
        synchronized (this.zza) {
            bool = this.zzi;
        }
        return bool;
    }

    public final String zzn() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzo() throws Exception {
        Context zza2 = zzbxo.zza(this.zze);
        ArrayList arrayList = new ArrayList();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(zza2).getPackageInfo(zza2.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final void zzq() {
        this.zzl.zza();
    }

    public final void zzr() {
        this.zzj.decrementAndGet();
    }

    public final void zzs() {
        this.zzk.incrementAndGet();
    }

    public final void zzt() {
        this.zzj.incrementAndGet();
    }

    public final void zzu(Context context, VersionInfoParcel versionInfoParcel) {
        zzbee zzbee;
        synchronized (this.zza) {
            if (!this.zzd) {
                this.zze = context.getApplicationContext();
                this.zzf = versionInfoParcel;
                zzu.zzb().zzc(this.zzc);
                this.zzb.zzq(this.zze);
                zzbvs.zzb(this.zze, this.zzf);
                zzu.zze();
                if (!((Boolean) zzbfn.zzc.zze()).booleanValue()) {
                    zze.zza("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                    zzbee = null;
                } else {
                    zzbee = new zzbee();
                }
                this.zzh = zzbee;
                if (zzbee != null) {
                    zzcbu.zza(new zzcbd(this).zzb(), "AppState.registerCsiReporter");
                }
                if (PlatformVersion.isAtLeastO()) {
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzir)).booleanValue()) {
                        ((ConnectivityManager) context.getSystemService("connectivity")).registerDefaultNetworkCallback(new zzcbe(this));
                    }
                }
                this.zzd = true;
                zzk();
            }
        }
        zzu.zzp().zzc(context, versionInfoParcel.afmaVersion);
    }

    public final void zzv(Throwable th, String str) {
        zzbvs.zzb(this.zze, this.zzf).zzh(th, str, ((Double) zzbgb.zzg.zze()).floatValue());
    }

    public final void zzw(Throwable th, String str) {
        zzbvs.zzb(this.zze, this.zzf).zzg(th, str);
    }

    public final void zzx(Boolean bool) {
        synchronized (this.zza) {
            this.zzi = bool;
        }
    }

    public final void zzy(String str) {
        this.zzg = str;
    }

    public final boolean zzz(Context context) {
        if (PlatformVersion.isAtLeastO()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzir)).booleanValue()) {
                return this.zzo.get();
            }
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
