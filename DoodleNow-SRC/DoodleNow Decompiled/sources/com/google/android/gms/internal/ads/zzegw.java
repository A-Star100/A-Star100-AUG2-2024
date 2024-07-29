package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzegw implements zzdiu {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzffn zzc;
    private final zzcgm zzd;
    private final zzfgi zze;
    private final zzblb zzf;
    private final boolean zzg;
    private final zzefo zzh;

    zzegw(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzffn zzffn, zzcgm zzcgm, zzfgi zzfgi, boolean z, zzblb zzblb, zzefo zzefo) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzffn;
        this.zzd = zzcgm;
        this.zze = zzfgi;
        this.zzg = z;
        this.zzf = zzblb;
        this.zzh = zzefo;
    }

    public final void zza(boolean z, Context context, zzczd zzczd) {
        zzcqx zzcqx = (zzcqx) zzgee.zzq(this.zzb);
        this.zzd.zzao(true);
        boolean zze2 = this.zzg ? this.zzf.zze(true) : true;
        boolean z2 = this.zzg;
        zzk zzk = new zzk(zze2, true, z2 ? this.zzf.zzd() : false, z2 ? this.zzf.zza() : 0.0f, -1, z, this.zzc.zzP, false);
        if (zzczd != null) {
            zzczd.zzf();
        }
        zzu.zzi();
        zzdij zzg2 = zzcqx.zzg();
        zzcgm zzcgm = this.zzd;
        int i = this.zzc.zzR;
        if (i == -1) {
            zzw zzw = this.zze.zzj;
            if (zzw != null) {
                int i2 = zzw.zza;
                if (i2 == 1) {
                    i = 7;
                } else if (i2 == 2) {
                    i = 6;
                }
            }
            zzm.zze("Error setting app open orientation; no targeting orientation available.");
            i = this.zzc.zzR;
        }
        int i3 = i;
        VersionInfoParcel versionInfoParcel = this.zza;
        zzffn zzffn = this.zzc;
        String str = zzffn.zzC;
        zzffs zzffs = zzffn.zzt;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzp) zzg2, (zzaa) null, zzcgm, i3, versionInfoParcel, str, zzk, zzffs.zzb, zzffs.zza, this.zze.zzf, zzczd, (zzbui) zzffn.zzaj ? this.zzh : null);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
