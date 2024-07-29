package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzlg {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzlg(zzle zzle, zzlf zzlf) {
        this.zza = zzle.zza;
        this.zzb = zzle.zzb;
        this.zzc = zzle.zzc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlg)) {
            return false;
        }
        zzlg zzlg = (zzlg) obj;
        return this.zza == zzlg.zza && this.zzb == zzlg.zzb && this.zzc == zzlg.zzc;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc)});
    }

    public final zzle zza() {
        return new zzle(this, (zzld) null);
    }
}
