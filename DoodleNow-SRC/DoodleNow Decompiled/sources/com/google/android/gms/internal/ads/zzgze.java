package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgze {
    private final Object zza;
    private final int zzb;

    zzgze(Object obj, int i) {
        this.zza = obj;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgze)) {
            return false;
        }
        zzgze zzgze = (zzgze) obj;
        if (this.zza == zzgze.zza && this.zzb == zzgze.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
