package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbzy extends zzcae {
    private final Clock zzb;
    private final zzbzy zzc = this;
    private final zzhje zzd;
    private final zzhje zze;
    private final zzhje zzf;
    private final zzhje zzg;
    private final zzhje zzh;
    private final zzhje zzi;
    private final zzhje zzj;
    private final zzhje zzk;

    /* synthetic */ zzbzy(Context context, Clock clock, zzg zzg2, zzcad zzcad, zzbzx zzbzx) {
        this.zzb = clock;
        zzhiv zza = zzhiw.zza(context);
        this.zzd = zza;
        zzhiv zza2 = zzhiw.zza(zzg2);
        this.zze = zza2;
        zzhiv zza3 = zzhiw.zza(zzcad);
        this.zzf = zza3;
        this.zzg = zzhiu.zzc(new zzbzq(zza, zza2, zza3));
        zzhiv zza4 = zzhiw.zza(clock);
        this.zzh = zza4;
        zzhje zzc2 = zzhiu.zzc(new zzbzs(zza4, zza2, zza3));
        this.zzi = zzc2;
        zzbzu zzbzu = new zzbzu(zza4, zzc2);
        this.zzj = zzbzu;
        this.zzk = zzhiu.zzc(new zzcaj(zza, zzbzu));
    }

    /* access modifiers changed from: package-private */
    public final zzbzp zza() {
        return (zzbzp) this.zzg.zzb();
    }

    /* access modifiers changed from: package-private */
    public final zzbzt zzb() {
        return new zzbzt(this.zzb, (zzbzr) this.zzi.zzb());
    }

    /* access modifiers changed from: package-private */
    public final zzcai zzc() {
        return (zzcai) this.zzk.zzb();
    }
}
