package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgpd {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzgpd(Class cls, Class cls2, zzgpc zzgpc) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgpd)) {
            return false;
        }
        zzgpd zzgpd = (zzgpd) obj;
        if (!zzgpd.zza.equals(this.zza) || !zzgpd.zzb.equals(this.zzb)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        Class cls = this.zzb;
        String simpleName = this.zza.getSimpleName();
        String simpleName2 = cls.getSimpleName();
        return simpleName + " with serialization type: " + simpleName2;
    }
}
