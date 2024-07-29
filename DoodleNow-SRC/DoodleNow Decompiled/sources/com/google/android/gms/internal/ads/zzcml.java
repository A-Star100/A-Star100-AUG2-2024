package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzag;
import com.google.android.gms.ads.nonagon.signalgeneration.zzi;
import com.google.android.gms.ads.nonagon.signalgeneration.zzj;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcml implements zzi {
    private final zzckh zza;
    private zzcya zzb;
    private zzag zzc;

    /* synthetic */ zzcml(zzckh zzckh, zzcmk zzcmk) {
        this.zza = zzckh;
    }

    public final /* synthetic */ zzi zza(zzcya zzcya) {
        this.zzb = zzcya;
        return this;
    }

    public final /* synthetic */ zzi zzb(zzag zzag) {
        this.zzc = zzag;
        return this;
    }

    public final zzj zzc() {
        zzhjd.zzc(this.zzb, zzcya.class);
        zzhjd.zzc(this.zzc, zzag.class);
        return new zzcmn(this.zza, this.zzc, new zzcvf(), new zzcxd(), new zzduv(), this.zzb, (zzfdi) null, (zzfcl) null, (zzcmm) null);
    }
}
