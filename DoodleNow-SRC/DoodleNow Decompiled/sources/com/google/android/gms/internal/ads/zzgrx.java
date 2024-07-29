package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgrx {
    private final zzgfv zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;

    /* synthetic */ zzgrx(zzgfv zzgfv, int i, String str, String str2, zzgrw zzgrw) {
        this.zza = zzgfv;
        this.zzb = i;
        this.zzc = str;
        this.zzd = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgrx)) {
            return false;
        }
        zzgrx zzgrx = (zzgrx) obj;
        if (this.zza != zzgrx.zza || this.zzb != zzgrx.zzb || !this.zzc.equals(zzgrx.zzc) || !this.zzd.equals(zzgrx.zzd)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final String toString() {
        return String.format("(status=%s, keyId=%s, keyType='%s', keyPrefix='%s')", new Object[]{this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd});
    }

    public final int zza() {
        return this.zzb;
    }
}
