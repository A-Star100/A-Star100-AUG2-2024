package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzael {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzael(int i, byte[] bArr, int i2, int i3) {
        this.zza = i;
        this.zzb = bArr;
        this.zzc = i2;
        this.zzd = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzael zzael = (zzael) obj;
            return this.zza == zzael.zza && this.zzc == zzael.zzc && this.zzd == zzael.zzd && Arrays.equals(this.zzb, zzael.zzb);
        }
    }

    public final int hashCode() {
        return (((((this.zza * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
