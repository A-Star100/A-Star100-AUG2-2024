package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaqg implements Runnable {
    private final zzaqq zza;
    private final zzaqw zzb;
    private final Runnable zzc;

    public zzaqg(zzaqq zzaqq, zzaqw zzaqw, Runnable runnable) {
        this.zza = zzaqq;
        this.zzb = zzaqw;
        this.zzc = runnable;
    }

    public final void run() {
        this.zza.zzw();
        zzaqw zzaqw = this.zzb;
        if (zzaqw.zzc()) {
            this.zza.zzo(zzaqw.zza);
        } else {
            this.zza.zzn(zzaqw.zzc);
        }
        if (this.zzb.zzd) {
            this.zza.zzm("intermediate-response");
        } else {
            this.zza.zzp("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
