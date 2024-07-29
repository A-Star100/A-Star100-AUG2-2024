package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdnv implements zzcia {
    public final /* synthetic */ zzcbv zza;

    public /* synthetic */ zzdnv(zzcbv zzcbv) {
        this.zza = zzcbv;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzcbv zzcbv = this.zza;
        if (z) {
            zzcbv.zzb();
            return;
        }
        zzcbv.zzd(new zzekh(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
