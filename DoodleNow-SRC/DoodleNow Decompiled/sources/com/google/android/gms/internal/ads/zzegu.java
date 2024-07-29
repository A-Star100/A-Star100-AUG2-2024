package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzegu implements zzegj {
    private final zzcra zza;
    private final Context zzb;
    private final zzdri zzc;
    private final zzfgi zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzblb zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbdz.zziN)).booleanValue();
    private final zzefo zzi;

    public zzegu(zzcra zzcra, Context context, Executor executor, zzdri zzdri, zzfgi zzfgi, VersionInfoParcel versionInfoParcel, zzblb zzblb, zzefo zzefo) {
        this.zzb = context;
        this.zza = zzcra;
        this.zze = executor;
        this.zzc = zzdri;
        this.zzd = zzfgi;
        this.zzf = versionInfoParcel;
        this.zzg = zzblb;
        this.zzi = zzefo;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        zzdrm zzdrm = new zzdrm();
        ListenableFuture zzn = zzgee.zzn(zzgee.zzh((Object) null), new zzegq(this, zzffn, zzffz, zzdrm), this.zze);
        zzn.addListener(new zzegr(zzdrm), this.zze);
        return zzn;
    }

    public final boolean zzb(zzffz zzffz, zzffn zzffn) {
        zzffs zzffs = zzffn.zzt;
        return (zzffs == null || zzffs.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzffn zzffn, zzffz zzffz, zzdrm zzdrm, Object obj) throws Exception {
        zzffn zzffn2 = zzffn;
        zzffz zzffz2 = zzffz;
        zzcgm zza2 = this.zzc.zza(this.zzd.zze, zzffn2, zzffz2.zzb.zzb);
        zza2.zzaa(zzffn2.zzX);
        zzdrm.zza(this.zzb, (View) zza2);
        zzcbw zzcbw = new zzcbw();
        zzcul zzcul = new zzcul(zzffz2, zzffn2, (String) null);
        zzegw zzegw = r1;
        zzegw zzegw2 = new zzegw(this.zzf, zzcbw, zzffn, zza2, this.zzd, this.zzh, this.zzg, this.zzi);
        zzcqx zza3 = this.zza.zza(zzcul, new zzdhp(zzegw, zza2), new zzcqy(zzffn2.zzab));
        zza3.zzh().zzi(zza2, false, this.zzh ? this.zzg : null);
        zzcbw.zzc(zza3);
        zza3.zzc().zzo(new zzegs(zza2), zzcbr.zzf);
        zza3.zzh();
        zzffs zzffs = zzffn2.zzt;
        return zzgee.zzm(zzdrh.zzj(zza2, zzffs.zzb, zzffs.zza), new zzegt(this, zza2, zzffn2, zza3), this.zze);
    }
}
