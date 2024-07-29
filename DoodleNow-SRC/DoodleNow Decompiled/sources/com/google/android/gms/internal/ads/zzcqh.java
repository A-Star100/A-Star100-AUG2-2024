package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcqh implements zzazy, zzczl, zzp, zzczk {
    private final zzcqc zza;
    private final zzcqd zzb;
    private final Set zzc = new HashSet();
    private final zzbqc zzd;
    private final Executor zze;
    private final Clock zzf;
    private final AtomicBoolean zzg = new AtomicBoolean(false);
    private final zzcqg zzh = new zzcqg();
    private boolean zzi = false;
    private WeakReference zzj = new WeakReference(this);

    public zzcqh(zzbpz zzbpz, zzcqd zzcqd, Executor executor, zzcqc zzcqc, Clock clock) {
        this.zza = zzcqc;
        this.zzd = zzbpz.zza("google.afma.activeView.handleUpdate", zzbpn.zza, zzbpn.zza);
        this.zzb = zzcqd;
        this.zze = executor;
        this.zzf = clock;
    }

    private final void zzk() {
        for (zzcgm zzf2 : this.zzc) {
            this.zza.zzf(zzf2);
        }
        this.zza.zze();
    }

    public final synchronized void zzdH() {
        this.zzh.zzb = false;
        zzg();
    }

    public final synchronized void zzdj(Context context) {
        this.zzh.zze = "u";
        zzg();
        zzk();
        this.zzi = true;
    }

    public final synchronized void zzdk() {
        this.zzh.zzb = true;
        zzg();
    }

    public final synchronized void zzdl(Context context) {
        this.zzh.zzb = true;
        zzg();
    }

    public final synchronized void zzdm(Context context) {
        this.zzh.zzb = false;
        zzg();
    }

    public final synchronized void zzdp(zzazx zzazx) {
        zzcqg zzcqg = this.zzh;
        zzcqg.zza = zzazx.zzj;
        zzcqg.zzf = zzazx;
        zzg();
    }

    public final void zzdq() {
    }

    public final void zzdr() {
    }

    public final void zzdt() {
    }

    public final void zzdu(int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzg() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.ref.WeakReference r0 = r5.zzj     // Catch:{ all -> 0x0060 }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x005b
            boolean r0 = r5.zzi     // Catch:{ all -> 0x0060 }
            if (r0 != 0) goto L_0x0059
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zzg     // Catch:{ all -> 0x0060 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0060 }
            if (r0 == 0) goto L_0x0059
            com.google.android.gms.internal.ads.zzcqg r0 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.common.util.Clock r1 = r5.zzf     // Catch:{ Exception -> 0x0051 }
            long r1 = r1.elapsedRealtime()     // Catch:{ Exception -> 0x0051 }
            r0.zzd = r1     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcqd r0 = r5.zzb     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcqg r1 = r5.zzh     // Catch:{ Exception -> 0x0051 }
            org.json.JSONObject r0 = r0.zzb(r1)     // Catch:{ Exception -> 0x0051 }
            java.util.Set r1 = r5.zzc     // Catch:{ Exception -> 0x0051 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0051 }
        L_0x002d:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x0044
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcgm r2 = (com.google.android.gms.internal.ads.zzcgm) r2     // Catch:{ Exception -> 0x0051 }
            java.util.concurrent.Executor r3 = r5.zze     // Catch:{ Exception -> 0x0051 }
            com.google.android.gms.internal.ads.zzcqf r4 = new com.google.android.gms.internal.ads.zzcqf     // Catch:{ Exception -> 0x0051 }
            r4.<init>(r2, r0)     // Catch:{ Exception -> 0x0051 }
            r3.execute(r4)     // Catch:{ Exception -> 0x0051 }
            goto L_0x002d
        L_0x0044:
            com.google.android.gms.internal.ads.zzbqc r1 = r5.zzd     // Catch:{ Exception -> 0x0051 }
            com.google.common.util.concurrent.ListenableFuture r0 = r1.zzb(r0)     // Catch:{ Exception -> 0x0051 }
            java.lang.String r1 = "ActiveViewListener.callActiveViewJs"
            com.google.android.gms.internal.ads.zzcbu.zzb(r0, r1)     // Catch:{ Exception -> 0x0051 }
            monitor-exit(r5)
            return
        L_0x0051:
            r0 = move-exception
            java.lang.String r1 = "Failed to call ActiveViewJS"
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r0)     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0059:
            monitor-exit(r5)
            return
        L_0x005b:
            r5.zzj()     // Catch:{ all -> 0x0060 }
            monitor-exit(r5)
            return
        L_0x0060:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcqh.zzg():void");
    }

    public final synchronized void zzh(zzcgm zzcgm) {
        this.zzc.add(zzcgm);
        this.zza.zzd(zzcgm);
    }

    public final void zzi(Object obj) {
        this.zzj = new WeakReference(obj);
    }

    public final synchronized void zzj() {
        zzk();
        this.zzi = true;
    }

    public final synchronized void zzr() {
        if (this.zzg.compareAndSet(false, true)) {
            this.zza.zzc(this);
            zzg();
        }
    }
}
