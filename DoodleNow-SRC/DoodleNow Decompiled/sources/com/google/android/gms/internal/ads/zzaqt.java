package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaqt {
    private final AtomicInteger zza = new AtomicInteger();
    private final Set zzb = new HashSet();
    private final PriorityBlockingQueue zzc = new PriorityBlockingQueue();
    private final PriorityBlockingQueue zzd = new PriorityBlockingQueue();
    private final zzaqa zze;
    private final zzaqj zzf;
    private final zzaqk[] zzg;
    private zzaqc zzh;
    private final List zzi = new ArrayList();
    private final List zzj = new ArrayList();
    private final zzaqh zzk;

    public zzaqt(zzaqa zzaqa, zzaqj zzaqj, int i) {
        zzaqh zzaqh = new zzaqh(new Handler(Looper.getMainLooper()));
        this.zze = zzaqa;
        this.zzf = zzaqj;
        this.zzg = new zzaqk[4];
        this.zzk = zzaqh;
    }

    public final zzaqq zza(zzaqq zzaqq) {
        zzaqq.zzf(this);
        synchronized (this.zzb) {
            this.zzb.add(zzaqq);
        }
        zzaqq.zzg(this.zza.incrementAndGet());
        zzaqq.zzm("add-to-queue");
        zzc(zzaqq, 0);
        this.zzc.add(zzaqq);
        return zzaqq;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzaqq zzaqq) {
        synchronized (this.zzb) {
            this.zzb.remove(zzaqq);
        }
        synchronized (this.zzi) {
            for (zzaqs zza2 : this.zzi) {
                zza2.zza();
            }
        }
        zzc(zzaqq, 5);
    }

    /* access modifiers changed from: package-private */
    public final void zzc(zzaqq zzaqq, int i) {
        synchronized (this.zzj) {
            for (zzaqr zza2 : this.zzj) {
                zza2.zza();
            }
        }
    }

    public final void zzd() {
        zzaqc zzaqc = this.zzh;
        if (zzaqc != null) {
            zzaqc.zzb();
        }
        zzaqk[] zzaqkArr = this.zzg;
        for (int i = 0; i < 4; i++) {
            zzaqk zzaqk = zzaqkArr[i];
            if (zzaqk != null) {
                zzaqk.zza();
            }
        }
        zzaqc zzaqc2 = new zzaqc(this.zzc, this.zzd, this.zze, this.zzk);
        this.zzh = zzaqc2;
        zzaqc2.start();
        for (int i2 = 0; i2 < 4; i2++) {
            zzaqk zzaqk2 = new zzaqk(this.zzd, this.zzf, this.zze, this.zzk);
            this.zzg[i2] = zzaqk2;
            zzaqk2.start();
        }
    }
}
