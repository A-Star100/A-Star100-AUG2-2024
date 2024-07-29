package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcqu {
    private final zzduh zza;
    private final zzffz zzb;

    zzcqu(zzduh zzduh, zzffz zzffz) {
        this.zza = zzduh;
        this.zzb = zzffz;
    }

    public final void zza(long j, int i) {
        zzdug zza2 = this.zza.zza();
        zza2.zzd(this.zzb.zzb.zzb);
        zza2.zzb("action", "ad_closed");
        zza2.zzb("show_time", String.valueOf(j));
        zza2.zzb("ad_format", "app_open_ad");
        int i2 = i - 1;
        zza2.zzb("acr", i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h");
        zza2.zzf();
    }
}
