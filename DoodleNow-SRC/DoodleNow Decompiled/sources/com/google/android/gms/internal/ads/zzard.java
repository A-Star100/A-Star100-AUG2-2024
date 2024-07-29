package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzard implements zzaqp {
    private final Map zza = new HashMap();
    private final zzaqc zzb;
    private final BlockingQueue zzc;
    private final zzaqh zzd;

    zzard(zzaqc zzaqc, BlockingQueue blockingQueue, zzaqh zzaqh) {
        this.zzd = zzaqh;
        this.zzb = zzaqc;
        this.zzc = blockingQueue;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0061, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzaqq r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map r0 = r5.zza     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = r6.zzj()     // Catch:{ all -> 0x0062 }
            java.lang.Object r0 = r0.remove(r6)     // Catch:{ all -> 0x0062 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0062 }
            if (r0 == 0) goto L_0x0060
            boolean r1 = r0.isEmpty()     // Catch:{ all -> 0x0062 }
            if (r1 != 0) goto L_0x0060
            boolean r1 = com.google.android.gms.internal.ads.zzarc.zzb     // Catch:{ all -> 0x0062 }
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x002f
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0062 }
            int r4 = r0.size()     // Catch:{ all -> 0x0062 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0062 }
            r1[r3] = r4     // Catch:{ all -> 0x0062 }
            r1[r2] = r6     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "%d waiting requests for cacheKey=%s; resend to network"
            com.google.android.gms.internal.ads.zzarc.zzd(r4, r1)     // Catch:{ all -> 0x0062 }
        L_0x002f:
            java.lang.Object r1 = r0.remove(r3)     // Catch:{ all -> 0x0062 }
            com.google.android.gms.internal.ads.zzaqq r1 = (com.google.android.gms.internal.ads.zzaqq) r1     // Catch:{ all -> 0x0062 }
            java.util.Map r4 = r5.zza     // Catch:{ all -> 0x0062 }
            r4.put(r6, r0)     // Catch:{ all -> 0x0062 }
            r1.zzu(r5)     // Catch:{ all -> 0x0062 }
            java.util.concurrent.BlockingQueue r6 = r5.zzc     // Catch:{ InterruptedException -> 0x0044 }
            r6.put(r1)     // Catch:{ InterruptedException -> 0x0044 }
            monitor-exit(r5)
            return
        L_0x0044:
            r6 = move-exception
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0062 }
            r0[r3] = r6     // Catch:{ all -> 0x0062 }
            java.lang.String r6 = "Couldn't add request to queue. %s"
            com.google.android.gms.internal.ads.zzarc.zzb(r6, r0)     // Catch:{ all -> 0x0062 }
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0062 }
            r6.interrupt()     // Catch:{ all -> 0x0062 }
            com.google.android.gms.internal.ads.zzaqc r6 = r5.zzb     // Catch:{ all -> 0x0062 }
            r6.zzb()     // Catch:{ all -> 0x0062 }
            monitor-exit(r5)
            return
        L_0x0060:
            monitor-exit(r5)
            return
        L_0x0062:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzard.zza(com.google.android.gms.internal.ads.zzaqq):void");
    }

    public final void zzb(zzaqq zzaqq, zzaqw zzaqw) {
        List<zzaqq> list;
        zzapz zzapz = zzaqw.zzb;
        if (zzapz == null || zzapz.zza(System.currentTimeMillis())) {
            zza(zzaqq);
            return;
        }
        String zzj = zzaqq.zzj();
        synchronized (this) {
            list = (List) this.zza.remove(zzj);
        }
        if (list != null) {
            if (zzarc.zzb) {
                zzarc.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), zzj);
            }
            for (zzaqq zzb2 : list) {
                this.zzd.zzb(zzb2, zzaqw, (Runnable) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzc(com.google.android.gms.internal.ads.zzaqq r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map r0 = r5.zza     // Catch:{ all -> 0x0052 }
            java.lang.String r1 = r6.zzj()     // Catch:{ all -> 0x0052 }
            boolean r0 = r0.containsKey(r1)     // Catch:{ all -> 0x0052 }
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x003a
            java.util.Map r0 = r5.zza     // Catch:{ all -> 0x0052 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0052 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0052 }
            if (r0 != 0) goto L_0x001e
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0052 }
            r0.<init>()     // Catch:{ all -> 0x0052 }
        L_0x001e:
            java.lang.String r4 = "waiting-for-response"
            r6.zzm(r4)     // Catch:{ all -> 0x0052 }
            r0.add(r6)     // Catch:{ all -> 0x0052 }
            java.util.Map r6 = r5.zza     // Catch:{ all -> 0x0052 }
            r6.put(r1, r0)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzarc.zzb     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0038
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r6[r3] = r1     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "Request for cacheKey=%s is in flight, putting on hold."
            com.google.android.gms.internal.ads.zzarc.zza(r0, r6)     // Catch:{ all -> 0x0052 }
        L_0x0038:
            monitor-exit(r5)
            return r2
        L_0x003a:
            java.util.Map r0 = r5.zza     // Catch:{ all -> 0x0052 }
            r4 = 0
            r0.put(r1, r4)     // Catch:{ all -> 0x0052 }
            r6.zzu(r5)     // Catch:{ all -> 0x0052 }
            boolean r6 = com.google.android.gms.internal.ads.zzarc.zzb     // Catch:{ all -> 0x0052 }
            if (r6 == 0) goto L_0x0050
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x0052 }
            r6[r3] = r1     // Catch:{ all -> 0x0052 }
            java.lang.String r0 = "new request, sending to network %s"
            com.google.android.gms.internal.ads.zzarc.zza(r0, r6)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return r3
        L_0x0052:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzard.zzc(com.google.android.gms.internal.ads.zzaqq):boolean");
    }
}
