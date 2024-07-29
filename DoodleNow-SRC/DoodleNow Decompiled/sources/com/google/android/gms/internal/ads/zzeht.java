package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeht extends zzbsa {
    final /* synthetic */ zzehu zza;
    private final zzegm zzb;

    /* synthetic */ zzeht(zzehu zzehu, zzegm zzegm, zzehs zzehs) {
        this.zza = zzehu;
        this.zzb = zzegm;
    }

    public final void zze(String str) throws RemoteException {
        ((zzeif) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzeif) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzeif) this.zzb.zzc).zzo();
    }

    public final void zzh(zzbqx zzbqx) throws RemoteException {
        this.zza.zzd = zzbqx;
        ((zzeif) this.zzb.zzc).zzo();
    }
}
