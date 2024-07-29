package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeku implements zzegp {
    private final Context zza;
    private final zzdqr zzb;

    public zzeku(Context context, zzdqr zzdqr) {
        this.zza = context;
        this.zzb = zzdqr;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzeio zzeio = new zzeio(zzffn, (zzbsn) zzegm.zzb, AdFormat.REWARDED);
        zzdqn zze = this.zzb.zze(new zzcul(zzffz, zzffn, zzegm.zza), new zzdqo(zzeio));
        zzeio.zzb(zze.zzc());
        ((zzeif) zzegm.zzc).zzc(zze.zzn());
        return zze.zzk();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        try {
            ((zzbsn) zzegm.zzb).zzq(zzffn.zzaa);
            if (zzffz.zza.zza.zzo.zza == 3) {
                ((zzbsn) zzegm.zzb).zzo(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekt(this, zzegm, (zzeks) null), (zzbqu) zzegm.zzc);
            } else {
                ((zzbsn) zzegm.zzb).zzp(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzekt(this, zzegm, (zzeks) null), (zzbqu) zzegm.zzc);
            }
        } catch (RemoteException e) {
            zze.zzb("Remote exception loading a rewarded RTB ad", e);
        }
    }
}
