package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeiu implements zzegp {
    private final Context zza;
    private final zzdim zzb;

    public zzeiu(Context context, zzdim zzdim) {
        this.zza = context;
        this.zzb = zzdim;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzeio zzeio = new zzeio(zzffn, (zzbsn) zzegm.zzb, AdFormat.INTERSTITIAL);
        zzdhm zze = this.zzb.zze(new zzcul(zzffz, zzffn, zzegm.zza), new zzdhp(zzeio, (zzcgm) null));
        zzeio.zzb(zze.zzc());
        ((zzeif) zzegm.zzc).zzc(zze.zzi());
        return zze.zzg();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        try {
            ((zzbsn) zzegm.zzb).zzq(zzffn.zzaa);
            ((zzbsn) zzegm.zzb).zzl(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeit(this, zzegm, (zzeis) null), (zzbqu) zzegm.zzc);
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a interstitial RTB ad", e);
            throw new zzfgp(e);
        }
    }
}
