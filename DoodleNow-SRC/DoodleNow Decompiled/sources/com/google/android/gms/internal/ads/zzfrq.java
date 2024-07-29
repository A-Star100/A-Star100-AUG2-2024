package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfrq extends Exception {
    private final int zza;

    public zzfrq(int i, String str) {
        super(str);
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzfrq(int i, Throwable th) {
        super(th);
        this.zza = i;
    }
}
