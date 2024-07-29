package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeig extends zzbya implements zzdaa {
    private zzbyb zza;
    private zzczz zzb;
    private zzdgy zzc;

    public final synchronized void zza(zzczz zzczz) {
        this.zzb = zzczz;
    }

    public final synchronized void zzc(zzbyb zzbyb) {
        this.zza = zzbyb;
    }

    public final synchronized void zzd(zzdgy zzdgy) {
        this.zzc = zzdgy;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbyb zzbyb = this.zza;
        if (zzbyb != null) {
            ((zzell) zzbyb).zzb.onAdClicked();
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbyb zzbyb = this.zza;
        if (zzbyb != null) {
            zzbyb.zzf(iObjectWrapper);
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzczz zzczz = this.zzb;
        if (zzczz != null) {
            zzczz.zza(i);
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbyb zzbyb = this.zza;
        if (zzbyb != null) {
            ((zzell) zzbyb).zzc.zzb();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzczz zzczz = this.zzb;
        if (zzczz != null) {
            zzczz.zzd();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbyb zzbyb = this.zza;
        if (zzbyb != null) {
            ((zzell) zzbyb).zza.zzdr();
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        zzdgy zzdgy = this.zzc;
        if (zzdgy != null) {
            zzm.zzj("Fail to initialize adapter ".concat(String.valueOf(((zzelk) zzdgy).zzc.zza)));
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzdgy zzdgy = this.zzc;
        if (zzdgy != null) {
            Executor zzc2 = ((zzelk) zzdgy).zzd.zzb;
            zzegm zzegm = ((zzelk) zzdgy).zzc;
            zzffn zzffn = ((zzelk) zzdgy).zzb;
            zzc2.execute(new zzelj((zzelk) zzdgy, ((zzelk) zzdgy).zza, zzffn, zzegm));
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbyc zzbyc) throws RemoteException {
        zzbyb zzbyb = this.zza;
        if (zzbyb != null) {
            ((zzell) zzbyb).zzd.zza(zzbyc);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbyb zzbyb = this.zza;
        if (zzbyb != null) {
            ((zzell) zzbyb).zzc.zze();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbyb zzbyb = this.zza;
        if (zzbyb != null) {
            ((zzell) zzbyb).zzd.zzc();
        }
    }
}
