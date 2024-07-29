package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.ads.zzbdg;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdsh implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;

    public zzdsh(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4, zzhjm zzhjm5) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
        this.zze = zzhjm5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzciq) this.zza).zza();
        String zza3 = ((zzdza) this.zzb).zzb();
        VersionInfoParcel zza4 = ((zzcjc) this.zzc).zza();
        zzbdg.zza.C0013zza zza5 = (zzbdg.zza.C0013zza) this.zzd.zzb();
        String str = (String) this.zze.zzb();
        zzbcx zzbcx = new zzbcx(new zzbdf(zza2));
        zzbdg.zzar.zza zzd2 = zzbdg.zzar.zzd();
        zzd2.zzg(zza4.buddyApkVersion);
        zzd2.zzi(zza4.clientJarVersion);
        zzd2.zzh(true != zza4.isClientJar ? 2 : 0);
        zzbcx.zzc(new zzdsg(zza5, zza3, (zzbdg.zzar) zzd2.zzbr(), str));
        return zzbcx;
    }
}
