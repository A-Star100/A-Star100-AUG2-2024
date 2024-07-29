package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhji {
    private final List zza;
    private final List zzb;

    /* synthetic */ zzhji(int i, int i2, zzhjh zzhjh) {
        this.zza = zzhis.zzc(i);
        this.zzb = zzhis.zzc(i2);
    }

    public final zzhji zza(zzhje zzhje) {
        this.zzb.add(zzhje);
        return this;
    }

    public final zzhji zzb(zzhje zzhje) {
        this.zza.add(zzhje);
        return this;
    }

    public final zzhjj zzc() {
        return new zzhjj(this.zza, this.zzb, (zzhjh) null);
    }
}
