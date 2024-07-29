package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzarb {
    public static final boolean zza = zzarc.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    zzarb() {
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        if (!this.zzc) {
            zzb("Request on the loose");
            zzarc.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public final synchronized void zza(String str, long j) {
        if (!this.zzc) {
            this.zzb.add(new zzara(str, j, SystemClock.elapsedRealtime()));
        } else {
            throw new IllegalStateException("Marker added to finished log");
        }
    }

    public final synchronized void zzb(String str) {
        long j;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j = 0;
        } else {
            long j2 = ((zzara) this.zzb.get(0)).zzc;
            List list = this.zzb;
            j = ((zzara) list.get(list.size() - 1)).zzc - j2;
        }
        if (j > 0) {
            long j3 = ((zzara) this.zzb.get(0)).zzc;
            zzarc.zza("(%-4d ms) %s", Long.valueOf(j), str);
            for (zzara zzara : this.zzb) {
                long j4 = zzara.zzc;
                zzarc.zza("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(zzara.zzb), zzara.zza);
                j3 = j4;
            }
        }
    }
}
