package com.google.android.gms.internal.ads;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzfwm implements Serializable {
    zzfwm() {
    }

    public static zzfwm zzc() {
        return zzfvv.zza;
    }

    public static zzfwm zzd(@CheckForNull Object obj) {
        return obj == null ? zzfvv.zza : new zzfww(obj);
    }

    public abstract zzfwm zza(zzfwf zzfwf);

    public abstract Object zzb(Object obj);
}
