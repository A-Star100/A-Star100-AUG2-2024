package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgkc extends zzggt {
    private final String zza;
    private final zzgka zzb;
    private final zzggt zzc;

    /* synthetic */ zzgkc(String str, zzgka zzgka, zzggt zzggt, zzgkb zzgkb) {
        this.zza = str;
        this.zzb = zzgka;
        this.zzc = zzggt;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgkc)) {
            return false;
        }
        zzgkc zzgkc = (zzgkc) obj;
        if (!zzgkc.zzb.equals(this.zzb) || !zzgkc.zzc.equals(this.zzc) || !zzgkc.zza.equals(this.zza)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{zzgkc.class, this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        zzggt zzggt = this.zzc;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(zzggt);
        return "LegacyKmsEnvelopeAead Parameters (kekUri: " + this.zza + ", dekParsingStrategy: " + valueOf + ", dekParametersForNewKeys: " + valueOf2 + ")";
    }

    public final boolean zza() {
        return false;
    }

    public final zzggt zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }
}
