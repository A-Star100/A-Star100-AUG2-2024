package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeim implements zzegj {
    private final Context zza;
    private final zzdri zzb;
    private final zzdim zzc;
    private final zzfgi zzd;
    private final Executor zze;
    private final VersionInfoParcel zzf;
    private final zzblb zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zza(zzbdz.zziN)).booleanValue();
    private final zzefo zzi;

    public zzeim(Context context, VersionInfoParcel versionInfoParcel, zzfgi zzfgi, Executor executor, zzdim zzdim, zzdri zzdri, zzblb zzblb, zzefo zzefo) {
        this.zza = context;
        this.zzd = zzfgi;
        this.zzc = zzdim;
        this.zze = executor;
        this.zzf = versionInfoParcel;
        this.zzb = zzdri;
        this.zzg = zzblb;
        this.zzi = zzefo;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        zzdrm zzdrm = new zzdrm();
        ListenableFuture zzn = zzgee.zzn(zzgee.zzh((Object) null), new zzeij(this, zzffn, zzffz, zzdrm), this.zze);
        zzn.addListener(new zzeik(zzdrm), this.zze);
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
        zzcgm zza2 = this.zzb.zza(this.zzd.zze, zzffn2, zzffz2.zzb.zzb);
        zza2.zzaa(zzffn2.zzX);
        zzdrm.zza(this.zza, (View) zza2);
        zzcbw zzcbw = new zzcbw();
        zzcul zzcul = new zzcul(zzffz2, zzffn2, (String) null);
        zzfgi zzfgi = this.zzd;
        boolean z = this.zzh;
        zzeil zzeil = r1;
        zzeil zzeil2 = new zzeil(this.zza, this.zzf, zzcbw, zzffn, zza2, zzfgi, z, this.zzg, this.zzi);
        zzdhm zze2 = this.zzc.zze(zzcul, new zzdhp(zzeil, zza2));
        zzcbw.zzc(zze2);
        zze2.zzc().zzo(new zzeih(zza2), zzcbr.zzf);
        zze2.zzk().zzi(zza2, true, this.zzh ? this.zzg : null);
        zze2.zzk();
        zzffn zzffn3 = zzffn;
        zzffs zzffs = zzffn3.zzt;
        return zzgee.zzm(zzdrh.zzj(zza2, zzffs.zzb, zzffs.zza), new zzeii(this, zza2, zzffn3, zze2), this.zze);
    }
}
