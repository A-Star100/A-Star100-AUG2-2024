package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdqy implements zzcia {
    public final /* synthetic */ zzcbw zza;

    public /* synthetic */ zzdqy(zzcbw zzcbw) {
        this.zza = zzcbw;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzcbw zzcbw = this.zza;
        if (z) {
            zzcbw.zzc((Object) null);
            return;
        }
        zzcbw.zzd(new Exception("Ad Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
