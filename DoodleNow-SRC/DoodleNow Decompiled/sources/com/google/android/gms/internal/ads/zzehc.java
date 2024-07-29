package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzehc implements zzegp {
    private final Context zza;
    private final zzcra zzb;

    zzehc(Context context, zzcra zzcra) {
        this.zza = context;
        this.zzb = zzcra;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzeio zzeio = new zzeio(zzffn, (zzbsn) zzegm.zzb, AdFormat.APP_OPEN_AD);
        zzcqx zza2 = this.zzb.zza(new zzcul(zzffz, zzffn, zzegm.zza), new zzdhp(zzeio, (zzcgm) null), new zzcqy(zzffn.zzab));
        zzeio.zzb(zza2.zzc());
        ((zzeif) zzegm.zzc).zzc(zza2.zzi());
        return zza2.zza();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        try {
            ((zzbsn) zzegm.zzb).zzq(zzffn.zzaa);
            ((zzbsn) zzegm.zzb).zzi(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzehb(zzegm, (zzeha) null), (zzbqu) zzegm.zzc);
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading an app open RTB ad", e);
            throw new zzfgp(e);
        }
    }
}
