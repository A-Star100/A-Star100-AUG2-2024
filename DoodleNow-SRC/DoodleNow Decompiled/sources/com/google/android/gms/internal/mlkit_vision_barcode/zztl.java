package com.google.android.gms.internal.mlkit_vision_barcode;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.3.0 */
final class zztl extends zztp {
    private final String zza;
    private final boolean zzb;
    private final int zzc;

    /* synthetic */ zztl(String str, boolean z, int i, zztk zztk) {
        this.zza = str;
        this.zzb = z;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zztp) {
            zztp zztp = (zztp) obj;
            return this.zza.equals(zztp.zzb()) && this.zzb == zztp.zzc() && this.zzc == zztp.zza();
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
