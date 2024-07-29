package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfpv extends zzfpr {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzfpv(String str, boolean z, boolean z2, zzfpu zzfpu) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfpr) {
            zzfpr zzfpr = (zzfpr) obj;
            return this.zza.equals(zzfpr.zzb()) && this.zzb == zzfpr.zzd() && this.zzc == zzfpr.zzc();
        }
    }

    public final int hashCode() {
        int i = 1237;
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003;
        if (true == this.zzc) {
            i = 1231;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        return "AdShield2Options{clientVersion=" + this.zza + ", shouldGetAdvertisingId=" + this.zzb + ", isGooglePlayServicesAvailable=" + this.zzc + "}";
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
