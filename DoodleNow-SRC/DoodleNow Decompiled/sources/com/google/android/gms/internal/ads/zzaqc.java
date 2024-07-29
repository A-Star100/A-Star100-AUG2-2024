package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaqc extends Thread {
    private static final boolean zza = zzarc.zzb;
    private final BlockingQueue zzb;
    /* access modifiers changed from: private */
    public final BlockingQueue zzc;
    private final zzaqa zzd;
    private volatile boolean zze = false;
    private final zzard zzf;
    private final zzaqh zzg;

    public zzaqc(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaqa zzaqa, zzaqh zzaqh) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzaqa;
        this.zzg = zzaqh;
        this.zzf = new zzard(this, blockingQueue2, zzaqh);
    }

    private void zzc() throws InterruptedException {
        zzaqq zzaqq = (zzaqq) this.zzb.take();
        zzaqq.zzm("cache-queue-take");
        zzaqq.zzt(1);
        try {
            zzaqq.zzw();
            zzapz zza2 = this.zzd.zza(zzaqq.zzj());
            if (zza2 == null) {
                zzaqq.zzm("cache-miss");
                if (!this.zzf.zzc(zzaqq)) {
                    this.zzc.put(zzaqq);
                }
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                if (zza2.zza(currentTimeMillis)) {
                    zzaqq.zzm("cache-hit-expired");
                    zzaqq.zze(zza2);
                    if (!this.zzf.zzc(zzaqq)) {
                        this.zzc.put(zzaqq);
                    }
                } else {
                    zzaqq.zzm("cache-hit");
                    zzaqw zzh = zzaqq.zzh(new zzaqm(zza2.zza, zza2.zzg));
                    zzaqq.zzm("cache-hit-parsed");
                    if (!zzh.zzc()) {
                        zzaqq.zzm("cache-parsing-failed");
                        this.zzd.zzc(zzaqq.zzj(), true);
                        zzaqq.zze((zzapz) null);
                        if (!this.zzf.zzc(zzaqq)) {
                            this.zzc.put(zzaqq);
                        }
                    } else if (zza2.zzf < currentTimeMillis) {
                        zzaqq.zzm("cache-hit-refresh-needed");
                        zzaqq.zze(zza2);
                        zzh.zzd = true;
                        if (!this.zzf.zzc(zzaqq)) {
                            this.zzg.zzb(zzaqq, zzh, new zzaqb(this, zzaqq));
                        } else {
                            this.zzg.zzb(zzaqq, zzh, (Runnable) null);
                        }
                    } else {
                        this.zzg.zzb(zzaqq, zzh, (Runnable) null);
                    }
                }
            }
        } finally {
            zzaqq.zzt(2);
        }
    }

    public final void run() {
        if (zza) {
            zzarc.zzd("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzb();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzarc.zzb("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zzb() {
        this.zze = true;
        interrupt();
    }
}
