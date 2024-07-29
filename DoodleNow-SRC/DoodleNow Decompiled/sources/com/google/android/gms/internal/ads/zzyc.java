package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzyc implements zzys {
    public final /* synthetic */ zzyl zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzyc(zzyl zzyl, String str) {
        this.zza = zzyl;
        this.zzb = str;
    }

    public final List zza(int i, zzcz zzcz, int[] iArr) {
        zzfzk zzfzk = new zzfzk();
        for (int i2 = 0; i2 < zzcz.zzb; i2++) {
            int i3 = i;
            zzcz zzcz2 = zzcz;
            int i4 = i2;
            zzfzk.zzf(new zzyr(i3, zzcz2, i4, this.zza, iArr[i2], this.zzb));
        }
        return zzfzk.zzi();
    }
}
