package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzegy implements zzegp {
    private final Context zza;
    private final zzcra zzb;
    private final Executor zzc;

    zzegy(Context context, zzcra zzcra, Executor executor) {
        this.zza = context;
        this.zzb = zzcra;
        this.zzc = executor;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzcqx zza2 = this.zzb.zza(new zzcul(zzffz, zzffn, zzegm.zza), new zzdhp(new zzegx(zzegm), (zzcgm) null), new zzcqy(zzffn.zzab));
        zza2.zzd().zzo(new zzcpa((zzfhg) zzegm.zzb), this.zzc);
        ((zzeif) zzegm.zzc).zzc(zza2.zzj());
        return zza2.zza();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        zzfgi zzfgi = zzffz.zza.zza;
        ((zzfhg) zzegm.zzb).zzl(this.zza, zzfgi.zzd, zzffn.zzw.toString(), (zzbqu) zzegm.zzc);
    }
}
