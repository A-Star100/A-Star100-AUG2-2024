package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbqg {
    private static zzbqg zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    zzbqg() {
    }

    public static zzbqg zza() {
        if (zza == null) {
            zza = new zzbqg();
        }
        return zza;
    }

    public final Thread zzb(Context context, String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbqf(this, context, str));
        thread.start();
        return thread;
    }
}
