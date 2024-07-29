package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaqk extends Thread {
    private final BlockingQueue zza;
    private final zzaqj zzb;
    private final zzaqa zzc;
    private volatile boolean zzd = false;
    private final zzaqh zze;

    public zzaqk(BlockingQueue blockingQueue, zzaqj zzaqj, zzaqa zzaqa, zzaqh zzaqh) {
        this.zza = blockingQueue;
        this.zzb = zzaqj;
        this.zzc = zzaqa;
        this.zze = zzaqh;
    }

    private void zzb() throws InterruptedException {
        zzaqq zzaqq = (zzaqq) this.zza.take();
        SystemClock.elapsedRealtime();
        zzaqq.zzt(3);
        try {
            zzaqq.zzm("network-queue-take");
            zzaqq.zzw();
            TrafficStats.setThreadStatsTag(zzaqq.zzc());
            zzaqm zza2 = this.zzb.zza(zzaqq);
            zzaqq.zzm("network-http-complete");
            if (!zza2.zze || !zzaqq.zzv()) {
                zzaqw zzh = zzaqq.zzh(zza2);
                zzaqq.zzm("network-parse-complete");
                if (zzh.zzb != null) {
                    this.zzc.zzd(zzaqq.zzj(), zzh.zzb);
                    zzaqq.zzm("network-cache-written");
                }
                zzaqq.zzq();
                this.zze.zzb(zzaqq, zzh, (Runnable) null);
                zzaqq.zzs(zzh);
                zzaqq.zzt(4);
            }
            zzaqq.zzp("not-modified");
            zzaqq.zzr();
            zzaqq.zzt(4);
        } catch (zzaqz e) {
            SystemClock.elapsedRealtime();
            this.zze.zza(zzaqq, e);
            zzaqq.zzr();
        } catch (Exception e2) {
            zzarc.zzc(e2, "Unhandled exception %s", e2.toString());
            zzaqz zzaqz = new zzaqz((Throwable) e2);
            SystemClock.elapsedRealtime();
            this.zze.zza(zzaqq, zzaqz);
            zzaqq.zzr();
        } catch (Throwable th) {
            zzaqq.zzt(4);
            throw th;
        }
    }

    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzarc.zzb("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
