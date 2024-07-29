package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejj implements zzegp {
    private final Context zza;
    private final zzdji zzb;
    /* access modifiers changed from: private */
    public zzbrd zzc;
    private final VersionInfoParcel zzd;

    public zzejj(Context context, zzdji zzdji, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdji;
        this.zzd = versionInfoParcel;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        if (zzffz.zza.zza.zzg.contains(Integer.toString(6))) {
            zzdky zzt = zzdky.zzt(this.zzc);
            zzfgi zzfgi = zzffz.zza.zza;
            if (zzfgi.zzg.contains(Integer.toString(zzt.zzc()))) {
                zzdla zze = this.zzb.zze(new zzcul(zzffz, zzffn, zzegm.zza), new zzdlk(zzt), new zzdnb((zzbra) null, (zzbqz) null, this.zzc));
                ((zzeif) zzegm.zzc).zzc(zze.zzi());
                return zze.zza();
            }
            throw new zzekh(1, "No corresponding native ad listener");
        }
        throw new zzekh(2, "Unified must be used for RTB.");
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        try {
            ((zzbsn) zzegm.zzb).zzq(zzffn.zzaa);
            if (this.zzd.clientJarVersion < ((Integer) zzba.zzc().zza(zzbdz.zzbH)).intValue()) {
                ((zzbsn) zzegm.zzb).zzm(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeji(this, zzegm, (zzejh) null), (zzbqu) zzegm.zzc);
            } else {
                ((zzbsn) zzegm.zzb).zzn(zzffn.zzV, zzffn.zzw.toString(), zzffz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeji(this, zzegm, (zzejh) null), (zzbqu) zzegm.zzc, zzffz.zza.zza.zzi);
            }
        } catch (RemoteException e) {
            throw new zzfgp(e);
        }
    }
}
