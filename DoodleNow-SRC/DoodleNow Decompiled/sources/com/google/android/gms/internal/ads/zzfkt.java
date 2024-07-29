package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfkt implements zzdfs, zzczg, zzdfw {
    private final zzflh zza;
    private final zzfkw zzb;

    zzfkt(Context context, zzflh zzflh) {
        this.zza = zzflh;
        this.zzb = zzfkv.zza(context, zzflo.CUI_NAME_ADSHOW);
    }

    public final void zza() {
    }

    public final void zzb() {
        if (((Boolean) zzbfm.zzd.zze()).booleanValue()) {
            zzflh zzflh = this.zza;
            zzfkw zzfkw = this.zzb;
            zzfkw.zzg(true);
            zzflh.zza(zzfkw);
        }
    }

    public final void zzk() {
    }

    public final void zzl() {
        if (((Boolean) zzbfm.zzd.zze()).booleanValue()) {
            this.zzb.zzi();
        }
    }

    public final void zzq(zze zze) {
        if (((Boolean) zzbfm.zzd.zze()).booleanValue()) {
            zzflh zzflh = this.zza;
            zzfkw zzfkw = this.zzb;
            zzfkw.zzc(zze.zza().toString());
            zzfkw.zzg(false);
            zzflh.zza(zzfkw);
        }
    }
}
