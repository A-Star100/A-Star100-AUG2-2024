package com.google.android.gms.internal.mlkit_common;

/* compiled from: com.google.mlkit:common@@18.9.0 */
final class zzpm extends zzpt {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zzpm(String str, boolean z, int i, zzpl zzpl) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpt) {
            zzpt zzpt = (zzpt) obj;
            return this.zza.equals(zzpt.zzb()) && this.zzb == zzpt.zzc() && this.zzc == zzpt.zza();
        }
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003) ^ this.zzc;
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        int i = this.zzc;
        return "MLKitLoggingOptions{libraryName=" + str + ", enableFirelog=" + z + ", firelogEventType=" + i + "}";
    }

    public final int zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzb;
    }
}
