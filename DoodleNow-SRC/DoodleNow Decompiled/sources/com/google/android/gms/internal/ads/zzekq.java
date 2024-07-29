package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzekq implements zzegp {
    private final Context zza;
    private final Executor zzb;
    private final zzdqr zzc;

    public zzekq(Context context, Executor executor, zzdqr zzdqr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdqr;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzdqn zze = this.zzc.zze(new zzcul(zzffz, zzffn, zzegm.zza), new zzdqo(new zzekp(zzegm)));
        zze.zzd().zzo(new zzcpa((zzfhg) zzegm.zzb), this.zzb);
        ((zzeif) zzegm.zzc).zzc(zze.zzm());
        return zze.zzk();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        try {
            zzfgi zzfgi = zzffz.zza.zza;
            if (zzfgi.zzo.zza == 3) {
                ((zzfhg) zzegm.zzb).zzr(this.zza, zzfgi.zzd, zzffn.zzw.toString(), (zzbqu) zzegm.zzc);
            } else {
                ((zzfhg) zzegm.zzb).zzq(this.zza, zzfgi.zzd, zzffn.zzw.toString(), (zzbqu) zzegm.zzc);
            }
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzegm.zza)), e);
        }
    }
}
