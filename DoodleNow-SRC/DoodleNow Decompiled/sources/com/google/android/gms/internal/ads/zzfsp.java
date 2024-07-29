package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzfsp implements Closeable {
    public static zzftb zza() {
        return new zzftb();
    }

    public static zzftb zzb(int i, zzfta zzfta) {
        return new zzftb(new zzfsn(i), zzfso.zza, zzfta);
    }

    public static zzftb zzc(zzfxh<Integer> zzfxh, zzfxh<Integer> zzfxh2, zzfta zzfta) {
        return new zzftb(zzfxh, zzfxh2, zzfta);
    }

    static /* synthetic */ Integer zze() {
        return -1;
    }
}
