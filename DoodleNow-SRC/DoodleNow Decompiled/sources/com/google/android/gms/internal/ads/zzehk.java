package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzfk;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzehk implements zzegj {
    private final zzcsm zza;
    private final Context zzb;
    private final zzdri zzc;
    private final zzfgi zzd;
    private final Executor zze;
    private final zzfwf zzf;

    public zzehk(zzcsm zzcsm, Context context, Executor executor, zzdri zzdri, zzfgi zzfgi, zzfwf zzfwf) {
        this.zzb = context;
        this.zza = zzcsm;
        this.zze = executor;
        this.zzc = zzdri;
        this.zzd = zzfgi;
        this.zzf = zzfwf;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        return zzgee.zzn(zzgee.zzh((Object) null), new zzehj(this, zzffz, zzffn), this.zze);
    }

    public final boolean zzb(zzffz zzffz, zzffn zzffn) {
        zzffs zzffs = zzffn.zzt;
        return (zzffs == null || zzffs.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzffz zzffz, zzffn zzffn, Object obj) throws Exception {
        View view;
        zzq zza2 = zzfgo.zza(this.zzb, zzffn.zzv);
        zzcgm zza3 = this.zzc.zza(zza2, zzffn, zzffz.zzb.zzb);
        zza3.zzaa(zzffn.zzX);
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhN)).booleanValue() || !zzffn.zzah) {
            view = new zzdrl(this.zzb, (View) zza3, (zzau) this.zzf.apply(zzffn));
        } else {
            view = zzcth.zza(this.zzb, (View) zza3, zzffn);
        }
        zzcsm zzcsm = this.zza;
        zzcul zzcul = new zzcul(zzffz, zzffn, (String) null);
        Objects.requireNonNull(zza3);
        zzcrn zza4 = zzcsm.zza(zzcul, new zzcrt(view, zza3, new zzehe(zza3), zzfgo.zzb(zza2)));
        zza4.zzh().zzi(zza3, false, (zzblb) null);
        zza4.zzc().zzo(new zzehf(zza3), zzcbr.zzf);
        zza4.zzh();
        zzffs zzffs = zzffn.zzt;
        ListenableFuture zzj = zzdrh.zzj(zza3, zzffs.zzb, zzffs.zza);
        if (zzffn.zzN) {
            Objects.requireNonNull(zza3);
            zzj.addListener(new zzehg(zza3), this.zze);
        }
        zzj.addListener(new zzehh(this, zza3), this.zze);
        return zzgee.zzm(zzj, new zzehi(zza4), zzcbr.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcgm zzcgm) {
        zzcgm.zzZ();
        zzchm zzq = zzcgm.zzq();
        zzfk zzfk = this.zzd.zza;
        if (!(zzfk == null || zzq == null)) {
            zzq.zzs(zzfk);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbi)).booleanValue() && !zzcgm.isAttachedToWindow()) {
            zzcgm.onPause();
            zzcgm.zzas(true);
        }
    }
}
