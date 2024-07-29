package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzacx {
    private final zzacw zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public zzacx(zzacw zzacw) {
        this.zza = zzacw;
    }

    public final zzadf zza(Object... objArr) {
        Constructor constructor;
        synchronized (this.zzb) {
            if (!this.zzb.get()) {
                try {
                    constructor = this.zza.zza();
                } catch (ClassNotFoundException unused) {
                    this.zzb.set(true);
                } catch (Exception e) {
                    throw new RuntimeException("Error instantiating extension", e);
                }
            }
            constructor = null;
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (zzadf) constructor.newInstance(objArr);
        } catch (Exception e2) {
            throw new IllegalStateException("Unexpected error creating extractor", e2);
        }
    }
}
