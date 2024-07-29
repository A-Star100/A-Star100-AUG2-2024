package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeiq implements zzegp {
    private final Context zza;
    private final zzdim zzb;
    private final VersionInfoParcel zzc;
    private final Executor zzd;

    public zzeiq(Context context, VersionInfoParcel versionInfoParcel, zzdim zzdim, Executor executor) {
        this.zza = context;
        this.zzc = versionInfoParcel;
        this.zzb = zzdim;
        this.zzd = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzdhm zze = this.zzb.zze(new zzcul(zzffz, zzffn, zzegm.zza), new zzdhp(new zzeip(this, zzegm), (zzcgm) null));
        zze.zzd().zzo(new zzcpa((zzfhg) zzegm.zzb), this.zzd);
        ((zzeif) zzegm.zzc).zzc(zze.zzj());
        return zze.zzg();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        zzfgi zzfgi = zzffz.zza.zza;
        ((zzfhg) zzegm.zzb).zzo(this.zza, zzfgi.zzd, zzffn.zzw.toString(), zzbw.zzl(zzffn.zzt), (zzbqu) zzegm.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzegm zzegm, boolean z, Context context, zzczd zzczd) throws zzdit {
        try {
            ((zzfhg) zzegm.zzb).zzv(z);
            if (this.zzc.clientJarVersion < ((Integer) zzba.zzc().zza(zzbdz.zzaH)).intValue()) {
                ((zzfhg) zzegm.zzb).zzx();
            } else {
                ((zzfhg) zzegm.zzb).zzy(context);
            }
        } catch (zzfgp e) {
            zzm.zzi("Cannot show interstitial.");
            throw new zzdit(e.getCause());
        }
    }
}
