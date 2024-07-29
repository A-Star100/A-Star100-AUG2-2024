package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgbd extends zzfzn {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zzgbd(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzfwr.zza(i, this.zzc, "index");
        return Objects.requireNonNull(this.zza[i + i + this.zzb]);
    }

    public final int size() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }
}
