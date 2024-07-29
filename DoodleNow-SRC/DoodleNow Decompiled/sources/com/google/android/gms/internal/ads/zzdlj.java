package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdlj {
    public static final zzdlj zza = new zzdlj(new zzdlh());
    private final zzbif zzb;
    private final zzbic zzc;
    private final zzbis zzd;
    private final zzbip zze;
    private final zzbnr zzf;
    private final SimpleArrayMap zzg;
    private final SimpleArrayMap zzh;

    private zzdlj(zzdlh zzdlh) {
        this.zzb = zzdlh.zza;
        this.zzc = zzdlh.zzb;
        this.zzd = zzdlh.zzc;
        this.zzg = new SimpleArrayMap(zzdlh.zzf);
        this.zzh = new SimpleArrayMap(zzdlh.zzg);
        this.zze = zzdlh.zzd;
        this.zzf = zzdlh.zze;
    }

    public final zzbic zza() {
        return this.zzc;
    }

    public final zzbif zzb() {
        return this.zzb;
    }

    public final zzbii zzc(String str) {
        return (zzbii) this.zzh.get(str);
    }

    public final zzbil zzd(String str) {
        return (zzbil) this.zzg.get(str);
    }

    public final zzbip zze() {
        return this.zze;
    }

    public final zzbis zzf() {
        return this.zzd;
    }

    public final zzbnr zzg() {
        return this.zzf;
    }

    public final ArrayList zzh() {
        ArrayList arrayList = new ArrayList(this.zzg.size());
        for (int i = 0; i < this.zzg.size(); i++) {
            arrayList.add((String) this.zzg.keyAt(i));
        }
        return arrayList;
    }

    public final ArrayList zzi() {
        ArrayList arrayList = new ArrayList();
        if (this.zzd != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzb != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzc != null) {
            arrayList.add(Integer.toString(2));
        }
        if (!this.zzg.isEmpty()) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzf != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }
}
