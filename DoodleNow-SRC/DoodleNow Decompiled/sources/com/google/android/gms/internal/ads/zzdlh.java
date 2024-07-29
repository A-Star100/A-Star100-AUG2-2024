package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdlh {
    zzbif zza;
    zzbic zzb;
    zzbis zzc;
    zzbip zzd;
    zzbnr zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdlh zza(zzbic zzbic) {
        this.zzb = zzbic;
        return this;
    }

    public final zzdlh zzb(zzbif zzbif) {
        this.zza = zzbif;
        return this;
    }

    public final zzdlh zzc(String str, zzbil zzbil, zzbii zzbii) {
        this.zzf.put(str, zzbil);
        if (zzbii != null) {
            this.zzg.put(str, zzbii);
        }
        return this;
    }

    public final zzdlh zzd(zzbnr zzbnr) {
        this.zze = zzbnr;
        return this;
    }

    public final zzdlh zze(zzbip zzbip) {
        this.zzd = zzbip;
        return this;
    }

    public final zzdlh zzf(zzbis zzbis) {
        this.zzc = zzbis;
        return this;
    }

    public final zzdlj zzg() {
        return new zzdlj(this);
    }
}
