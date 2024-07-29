package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgpb {
    private final Class zza;
    private final zzgxm zzb;

    /* synthetic */ zzgpb(Class cls, zzgxm zzgxm, zzgpa zzgpa) {
        this.zza = cls;
        this.zzb = zzgxm;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpb)) {
            return false;
        }
        zzgpb zzgpb = (zzgpb) obj;
        if (!zzgpb.zza.equals(this.zza) || !zzgpb.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzgxm zzgxm = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String valueOf = String.valueOf(zzgxm);
        return simpleName + ", object identifier: " + valueOf;
    }
}
