package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbl {
    public static final zzbl zza = new zzbl(new zzbk());
    @Deprecated
    public static final zzn zzb = zzbj.zza;
    private static final String zzf = Integer.toString(0, 36);
    private static final String zzg = Integer.toString(1, 36);
    private static final String zzh = Integer.toString(2, 36);
    public final Uri zzc = null;
    public final String zzd = null;
    public final Bundle zze = null;

    private zzbl(zzbk zzbk) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbl)) {
            return false;
        }
        zzbl zzbl = (zzbl) obj;
        Uri uri = zzbl.zzc;
        if (zzfx.zzG((Object) null, (Object) null)) {
            String str = zzbl.zzd;
            if (zzfx.zzG((Object) null, (Object) null)) {
                Bundle bundle = zzbl.zze;
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return 0;
    }
}
