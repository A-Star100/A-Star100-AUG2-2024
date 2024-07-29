package com.google.android.gms.internal.ads;

import android.media.metrics.LogSessionId;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzpb {
    public static final zzpb zza;
    public final String zzb;
    private final zzpa zzc;
    private final Object zzd;

    static {
        zzpb zzpb;
        if (zzfx.zza < 31) {
            zzpb = new zzpb("");
        } else {
            zzpb = new zzpb(zzpa.zza, "");
        }
        zza = zzpb;
    }

    public zzpb(LogSessionId logSessionId, String str) {
        this(new zzpa(logSessionId), str);
    }

    private zzpb(zzpa zzpa, String str) {
        this.zzc = zzpa;
        this.zzb = str;
        this.zzd = new Object();
    }

    public zzpb(String str) {
        zzek.zzf(zzfx.zza < 31);
        this.zzb = str;
        this.zzc = null;
        this.zzd = new Object();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpb)) {
            return false;
        }
        zzpb zzpb = (zzpb) obj;
        return Objects.equals(this.zzb, zzpb.zzb) && Objects.equals(this.zzc, zzpb.zzc) && Objects.equals(this.zzd, zzpb.zzd);
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.zzb, this.zzc, this.zzd});
    }

    public final LogSessionId zza() {
        zzpa zzpa = this.zzc;
        zzpa.getClass();
        return zzpa.zzb;
    }
}
