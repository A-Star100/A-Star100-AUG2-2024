package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzcc extends IOException {
    public final boolean zza;
    public final int zzb;

    protected zzcc(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.zza = z;
        this.zzb = i;
    }

    public static zzcc zza(String str, Throwable th) {
        return new zzcc(str, th, true, 1);
    }

    public static zzcc zzb(String str, Throwable th) {
        return new zzcc(str, th, true, 0);
    }

    public static zzcc zzc(String str) {
        return new zzcc(str, (Throwable) null, false, 1);
    }

    public final String getMessage() {
        String message = super.getMessage();
        return message + "{contentIsMalformed=" + this.zza + ", dataType=" + this.zzb + "}";
    }
}
