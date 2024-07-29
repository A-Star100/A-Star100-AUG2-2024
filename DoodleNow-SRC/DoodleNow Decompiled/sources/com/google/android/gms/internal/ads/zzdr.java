package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdr {
    public static final zzdr zza = new zzdr(-1, -1, -1);
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;

    public zzdr(int i, int i2, int i3) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = zzfx.zzK(i3) ? zzfx.zzm(i3, i2) : -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdr)) {
            return false;
        }
        zzdr zzdr = (zzdr) obj;
        return this.zzb == zzdr.zzb && this.zzc == zzdr.zzc && this.zzd == zzdr.zzd;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.zzb + ", channelCount=" + this.zzc + ", encoding=" + this.zzd + "]";
    }
}
