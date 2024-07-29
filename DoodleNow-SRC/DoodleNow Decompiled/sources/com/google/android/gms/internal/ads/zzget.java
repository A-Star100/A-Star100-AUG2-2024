package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgcs;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzget extends zzgcs.zzi implements Runnable {
    private final Runnable zza;

    public zzget(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th) {
            zzd(th);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final String zza() {
        String obj = this.zza.toString();
        return "task=[" + obj + "]";
    }
}
