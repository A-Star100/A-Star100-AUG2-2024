package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbxn extends zzbxp {
    private final String zza;
    private final int zzb;

    public zzbxn(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbxn)) {
            zzbxn zzbxn = (zzbxn) obj;
            if (Objects.equal(this.zza, zzbxn.zza)) {
                if (Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzbxn.zzb))) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
