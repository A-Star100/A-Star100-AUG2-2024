package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzxw implements zzys {
    public final /* synthetic */ zzyl zza;

    public /* synthetic */ zzxw(zzyl zzyl) {
        this.zza = zzyl;
    }

    public final List zza(int i, zzcz zzcz, int[] iArr) {
        zzfzk zzfzk = new zzfzk();
        for (int i2 = 0; i2 < zzcz.zzb; i2++) {
            zzfzk.zzf(new zzyf(i, zzcz, i2, this.zza, iArr[i2]));
        }
        return zzfzk.zzi();
    }
}
