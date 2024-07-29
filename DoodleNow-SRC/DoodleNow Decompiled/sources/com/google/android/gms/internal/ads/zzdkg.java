package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdkg implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;
    private final zzhjm zzd;

    public zzdkg(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3, zzhjm zzhjm4) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
        this.zzd = zzhjm4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcqr((Executor) this.zzb.zzb(), new zzcqd((Context) this.zzc.zzb(), (zzazu) this.zza.zzb()), (Clock) this.zzd.zzb());
    }
}
