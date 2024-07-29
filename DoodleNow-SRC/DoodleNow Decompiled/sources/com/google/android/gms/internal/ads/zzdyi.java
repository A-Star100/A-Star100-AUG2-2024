package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzdyi extends Exception {
    private final int zza;

    public zzdyi(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdyi(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdyi(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
