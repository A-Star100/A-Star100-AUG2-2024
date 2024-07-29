package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfue extends zzfup {
    private final String zza;
    private final String zzb;

    /* synthetic */ zzfue(String str, String str2, zzfud zzfud) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfup) {
            zzfup zzfup = (zzfup) obj;
            String str = this.zza;
            if (str != null ? str.equals(zzfup.zzb()) : zzfup.zzb() == null) {
                String str2 = this.zzb;
                if (str2 != null ? str2.equals(zzfup.zza()) : zzfup.zza() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((hashCode ^ 1000003) * 1000003) ^ i;
    }

    public final String toString() {
        return "OverlayDisplayDismissRequest{sessionToken=" + this.zza + ", appId=" + this.zzb + "}";
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }
}
