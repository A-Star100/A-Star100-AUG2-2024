package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Build;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzflk implements Runnable {
    public static final Object zza = new Object();
    public static Boolean zzb;
    private static final Object zzc = new Object();
    private static final Object zzd = new Object();
    private final Context zze;
    private final VersionInfoParcel zzf;
    private final zzflz zzg = zzfmc.zzc();
    private String zzh = "";
    private int zzi;
    private final zzdrv zzj;
    private final List zzk;
    private boolean zzl = false;
    private final zzedj zzm;
    private final zzbxm zzn;

    public zzflk(Context context, VersionInfoParcel versionInfoParcel, zzdrv zzdrv, zzedj zzedj, zzbxm zzbxm) {
        this.zze = context;
        this.zzf = versionInfoParcel;
        this.zzj = zzdrv;
        this.zzm = zzedj;
        this.zzn = zzbxm;
        if (((Boolean) zzba.zzc().zza(zzbdz.zziK)).booleanValue()) {
            this.zzk = zzt.zzd();
        } else {
            this.zzk = zzfzn.zzm();
        }
    }

    public static boolean zza() {
        boolean booleanValue;
        synchronized (zza) {
            if (zzb == null) {
                boolean z = false;
                if (!((Boolean) zzbfm.zzb.zze()).booleanValue()) {
                    zzb = false;
                } else {
                    if (Math.random() < ((Double) zzbfm.zza.zze()).doubleValue()) {
                        z = true;
                    }
                    zzb = Boolean.valueOf(z);
                }
            }
            booleanValue = zzb.booleanValue();
        }
        return booleanValue;
    }

    public final void run() {
        byte[] zzaV;
        if (zza()) {
            Object obj = zzc;
            synchronized (obj) {
                if (this.zzg.zza() != 0) {
                    try {
                        synchronized (obj) {
                            zzaV = ((zzfmc) this.zzg.zzbr()).zzaV();
                            this.zzg.zzc();
                        }
                        new zzedi(this.zze, this.zzf.afmaVersion, this.zzn, Binder.getCallingUid()).zza(new zzedg((String) zzba.zzc().zza(zzbdz.zziE), 60000, new HashMap(), zzaV, "application/x-protobuf", false));
                    } catch (Exception e) {
                        if (!(e instanceof zzdyi) || ((zzdyi) e).zza() != 3) {
                            zzu.zzo().zzv(e, "CuiMonitor.sendCuiPing");
                        }
                    }
                }
            }
        }
    }

    public final void zzb(zzfla zzfla) {
        zzcbr.zza.zza(new zzflj(this, zzfla));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzfla zzfla) {
        synchronized (zzd) {
            if (!this.zzl) {
                this.zzl = true;
                if (zza()) {
                    try {
                        zzu.zzp();
                        this.zzh = zzt.zzp(this.zze);
                    } catch (RemoteException e) {
                        zzu.zzo().zzw(e, "CuiMonitor.gettingAppIdFromManifest");
                    }
                    this.zzi = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zze);
                    int intValue = ((Integer) zzba.zzc().zza(zzbdz.zziF)).intValue();
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzly)).booleanValue()) {
                        long j = (long) intValue;
                        zzcbr.zzd.scheduleWithFixedDelay(this, j, j, TimeUnit.MILLISECONDS);
                    } else {
                        long j2 = (long) intValue;
                        zzcbr.zzd.scheduleAtFixedRate(this, j2, j2, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
        if (zza() && zzfla != null) {
            synchronized (zzc) {
                if (this.zzg.zza() < ((Integer) zzba.zzc().zza(zzbdz.zziG)).intValue()) {
                    zzflm zza2 = zzflx.zza();
                    zza2.zzk(zzfla.zzd());
                    zza2.zzt(zzfla.zzn());
                    zza2.zzh(zzfla.zzb());
                    zza2.zzn(zzflu.OS_ANDROID);
                    zza2.zzq(this.zzf.afmaVersion);
                    zza2.zzb(this.zzh);
                    zza2.zzo(Build.VERSION.RELEASE);
                    zza2.zzu(Build.VERSION.SDK_INT);
                    zza2.zzm(zzfla.zzf());
                    zza2.zzl(zzfla.zza());
                    zza2.zzf((long) this.zzi);
                    zza2.zze(zzfla.zze());
                    zza2.zzc(zzfla.zzg());
                    zza2.zzg(zzfla.zzi());
                    zza2.zzi(zzfla.zzj());
                    zza2.zzj(this.zzj.zzb(zzfla.zzj()));
                    zza2.zzp(zzfla.zzk());
                    zza2.zzd(zzfla.zzh());
                    zza2.zzv(zzfla.zzm());
                    zza2.zzr(zzfla.zzl());
                    zza2.zzs(zzfla.zzc());
                    if (((Boolean) zzba.zzc().zza(zzbdz.zziK)).booleanValue()) {
                        zza2.zza(this.zzk);
                    }
                    zzflz zzflz = this.zzg;
                    zzfma zza3 = zzfmb.zza();
                    zza3.zza(zza2);
                    zzflz.zzb(zza3);
                }
            }
        }
    }
}
