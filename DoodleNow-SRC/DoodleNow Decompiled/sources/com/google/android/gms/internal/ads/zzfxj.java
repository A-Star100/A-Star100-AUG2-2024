package com.google.android.gms.internal.ads;

import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzfxj implements zzfxh {
    private static final zzfxh zza = zzfxi.zza;
    private volatile zzfxh zzb;
    @CheckForNull
    private Object zzc;

    zzfxj(zzfxh zzfxh) {
        this.zzb = zzfxh;
    }

    public final String toString() {
        Object obj = this.zzb;
        if (obj == zza) {
            obj = "<supplier that returned " + String.valueOf(this.zzc) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    public final Object zza() {
        zzfxh zzfxh = this.zzb;
        zzfxh zzfxh2 = zza;
        if (zzfxh != zzfxh2) {
            synchronized (this) {
                if (this.zzb != zzfxh2) {
                    Object zza2 = this.zzb.zza();
                    this.zzc = zza2;
                    this.zzb = zzfxh2;
                    return zza2;
                }
            }
        }
        return this.zzc;
    }
}
