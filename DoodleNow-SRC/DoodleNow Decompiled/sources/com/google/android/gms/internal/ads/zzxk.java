package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzxk {
    public static final zzxk zza = new zzxk(new zzcz[0]);
    @Deprecated
    public static final zzn zzb = zzxi.zza;
    private static final String zzd = Integer.toString(0, 36);
    public final int zzc;
    private final zzfzn zze;
    private int zzf;

    public zzxk(zzcz... zzczArr) {
        this.zze = zzfzn.zzl(zzczArr);
        this.zzc = zzczArr.length;
        int i = 0;
        while (i < this.zze.size()) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.zze.size(); i3++) {
                if (((zzcz) this.zze.get(i)).equals(this.zze.get(i3))) {
                    zzfe.zzd("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i = i2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxk zzxk = (zzxk) obj;
            return this.zzc == zzxk.zzc && this.zze.equals(zzxk.zze);
        }
    }

    public final int hashCode() {
        int i = this.zzf;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zze.hashCode();
        this.zzf = hashCode;
        return hashCode;
    }

    public final int zza(zzcz zzcz) {
        int indexOf = this.zze.indexOf(zzcz);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public final zzcz zzb(int i) {
        return (zzcz) this.zze.get(i);
    }

    public final zzfzn zzc() {
        return zzfzn.zzk(zzgad.zzb(this.zze, zzxj.zza));
    }
}
