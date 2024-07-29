package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcym implements zzhiv {
    private final zzcyl zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;
    private final zzhjm zze;

    public zzcym(zzcyl zzcyl, zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4) {
        this.zza = zzcyl;
        this.zzb = zzhjm;
        this.zzc = zzhjm2;
        this.zzd = zzhjm3;
        this.zze = zzhjm4;
    }

    public final /* synthetic */ Object zzb() {
        String str;
        Context context = (Context) this.zzb.zzb();
        VersionInfoParcel zza2 = ((zzcjc) this.zzc).zza();
        zzffn zza3 = ((zzcum) this.zzd).zza();
        zzbzk zzbzk = new zzbzk();
        zzbzl zzbzl = zza3.zzB;
        if (zzbzl == null) {
            return null;
        }
        zzffs zzffs = zza3.zzt;
        if (zzffs == null) {
            str = null;
        } else {
            str = zzffs.zzb;
        }
        return new zzbzj(context, zza2, zzbzl, str, zzbzk);
    }
}
