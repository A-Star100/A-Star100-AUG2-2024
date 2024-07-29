package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgne extends zzggi {
    private final zzgou zza;

    public zzgne(zzgou zzgou) {
        this.zza = zzgou;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgne)) {
            return false;
        }
        zzgou zzgou = ((zzgne) obj).zza;
        if (!this.zza.zzc().zzg().equals(zzgou.zzc().zzg()) || !this.zza.zzc().zzi().equals(zzgou.zzc().zzi()) || !this.zza.zzc().zzh().equals(zzgou.zzc().zzh())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        zzgou zzgou = this.zza;
        return Objects.hash(new Object[]{zzgou.zzc(), zzgou.zzd()});
    }

    public final String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = this.zza.zzc().zzi();
        zzgvv zzg = this.zza.zzc().zzg();
        zzgvv zzgvv = zzgvv.UNKNOWN_PREFIX;
        int ordinal = zzg.ordinal();
        objArr[1] = ordinal != 1 ? ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        return String.format("(typeUrl=%s, outputPrefixType=%s)", objArr);
    }

    public final boolean zza() {
        return this.zza.zzc().zzg() != zzgvv.RAW;
    }

    public final zzgou zzb() {
        return this.zza;
    }
}
