package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzgw extends IOException {
    public final int zza;

    public zzgw(int i) {
        this.zza = i;
    }

    public zzgw(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzgw(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzgw(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}
