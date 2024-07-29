package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzelm implements zzegp {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzdqr zzc;

    public zzelm(Context context, Executor executor, zzdqr zzdqr) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdqr;
    }

    /* access modifiers changed from: private */
    public static final void zze(zzffz zzffz, zzffn zzffn, zzegm zzegm) {
        try {
            ((zzfhg) zzegm.zzb).zzk(zzffz.zza.zza.zzd, zzffn.zzw.toString());
        } catch (Exception e) {
            zzm.zzk("Fail to load ad from adapter ".concat(String.valueOf(zzegm.zza)), e);
        }
    }

    public final /* bridge */ /* synthetic */ Object zza(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp, zzekh {
        zzdqn zze = this.zzc.zze(new zzcul(zzffz, zzffn, zzegm.zza), new zzdqo(new zzeli(zzegm)));
        zze.zzd().zzo(new zzcpa((zzfhg) zzegm.zzb), this.zzb);
        zzczx zze2 = zze.zze();
        zzcyo zzb2 = zze.zzb();
        ((zzeig) zzegm.zzc).zzc(new zzell(this, zze.zza(), zzb2, zze2, zze.zzg()));
        return zze.zzk();
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        if (!((zzfhg) zzegm.zzb).zzC()) {
            ((zzeig) zzegm.zzc).zzd(new zzelk(this, zzffz, zzffn, zzegm));
            Object obj = zzegm.zzb;
            Context context = this.zza;
            zzfgi zzfgi = zzffz.zza.zza;
            String jSONObject = zzffn.zzw.toString();
            ((zzfhg) obj).zzh(context, zzfgi.zzd, (String) null, (zzbyb) zzegm.zzc, jSONObject);
            return;
        }
        zze(zzffz, zzffn, zzegm);
    }
}
