package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbbg {
    final long zza;
    final String zzb;
    final int zzc;

    zzbbg(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbbg)) {
            zzbbg zzbbg = (zzbbg) obj;
            return zzbbg.zza == this.zza && zzbbg.zzc == this.zzc;
        }
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
