package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeil implements zzdiu {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzffn zzd;
    private final zzcgm zze;
    private final zzfgi zzf;
    private final zzblb zzg;
    private final boolean zzh;
    private final zzefo zzi;

    zzeil(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzffn zzffn, zzcgm zzcgm, zzfgi zzfgi, boolean z, zzblb zzblb, zzefo zzefo) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzffn;
        this.zze = zzcgm;
        this.zzf = zzfgi;
        this.zzg = zzblb;
        this.zzh = z;
        this.zzi = zzefo;
    }

    public final void zza(boolean z, Context context, zzczd zzczd) {
        zzdhm zzdhm = (zzdhm) zzgee.zzq(this.zzc);
        this.zze.zzao(true);
        boolean zze2 = this.zzh ? this.zzg.zze(false) : false;
        zzu.zzp();
        zzk zzk = new zzk(zze2, zzt.zzI(this.zza), this.zzh ? this.zzg.zzd() : false, this.zzh ? this.zzg.zza() : 0.0f, -1, z, this.zzd.zzP, false);
        if (zzczd != null) {
            zzczd.zzf();
        }
        zzu.zzi();
        zzdij zzh2 = zzdhm.zzh();
        zzcgm zzcgm = this.zze;
        zzffn zzffn = this.zzd;
        VersionInfoParcel versionInfoParcel = this.zzb;
        int i = zzffn.zzR;
        String str = zzffn.zzC;
        zzffs zzffs = zzffn.zzt;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzp) zzh2, (zzaa) null, zzcgm, i, versionInfoParcel, str, zzk, zzffs.zzb, zzffs.zza, this.zzf.zzf, zzczd, (zzbui) zzffn.zzaj ? this.zzi : null);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
