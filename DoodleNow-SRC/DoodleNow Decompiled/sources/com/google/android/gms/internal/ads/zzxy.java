package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzxy implements zzys {
    public final /* synthetic */ zzyx zza;
    public final /* synthetic */ zzyl zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int[] zzd;

    public /* synthetic */ zzxy(zzyx zzyx, zzyl zzyl, boolean z, int[] iArr) {
        this.zza = zzyx;
        this.zzb = zzyl;
        this.zzc = z;
        this.zzd = iArr;
    }

    public final List zza(int i, zzcz zzcz, int[] iArr) {
        zzxv zzxv = new zzxv(this.zza);
        int i2 = this.zzd[i];
        zzfzk zzfzk = new zzfzk();
        zzcz zzcz2 = zzcz;
        for (int i3 = 0; i3 < zzcz2.zzb; i3++) {
            zzfzk.zzf(new zzye(i, zzcz, i3, this.zzb, iArr[i3], this.zzc, zzxv, i2));
        }
        return zzfzk.zzi();
    }
}
