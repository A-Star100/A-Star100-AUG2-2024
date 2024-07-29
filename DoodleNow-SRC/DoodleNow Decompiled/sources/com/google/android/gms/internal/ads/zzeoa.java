package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbk;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zzci;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeoa implements AppEventListener, zzdbl, zzdae, zzcyt, zzczk, zza, zzcyq, zzdbb, zzczg, zzdgn {
    final zzduh zza;
    final BlockingQueue zzb = new ArrayBlockingQueue(((Integer) zzba.zzc().zza(zzbdz.zziL)).intValue());
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicBoolean zzh = new AtomicBoolean(true);
    private final AtomicBoolean zzi = new AtomicBoolean(false);
    private final AtomicBoolean zzj = new AtomicBoolean(false);

    public zzeoa(zzduh zzduh) {
        this.zza = zzduh;
    }

    private final void zzo() {
        if (this.zzi.get() && this.zzj.get()) {
            for (Pair zzenl : this.zzb) {
                zzfcs.zza(this.zzd, new zzenl(zzenl));
            }
            this.zzb.clear();
            this.zzh.set(false);
        }
    }

    public final void onAdClicked() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzkv)).booleanValue()) {
            zzfcs.zza(this.zzc, zzeny.zza);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onAppEvent(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.zzh     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x003b
            java.util.concurrent.BlockingQueue r0 = r3.zzb     // Catch:{ all -> 0x0047 }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x0047 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.offer(r1)     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0039
            java.lang.String r0 = "The queue for app events is full, dropping the new event."
            com.google.android.gms.ads.internal.util.client.zzm.zze(r0)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzduh r0 = r3.zza     // Catch:{ all -> 0x0047 }
            if (r0 == 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzdug r0 = r0.zza()     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "action"
            java.lang.String r2 = "dae_action"
            r0.zzb(r1, r2)     // Catch:{ all -> 0x0047 }
            java.lang.String r1 = "dae_name"
            r0.zzb(r1, r4)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "dae_data"
            r0.zzb(r4, r5)     // Catch:{ all -> 0x0047 }
            r0.zzf()     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0039:
            monitor-exit(r3)
            return
        L_0x003b:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzens r1 = new com.google.android.gms.internal.ads.zzens     // Catch:{ all -> 0x0047 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzfcs.zza(r0, r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r3)
            return
        L_0x0047:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeoa.onAppEvent(java.lang.String, java.lang.String):void");
    }

    public final void zza() {
        zzfcs.zza(this.zzc, zzeni.zza);
        zzfcs.zza(this.zzg, zzenj.zza);
    }

    public final void zzb() {
        zzfcs.zza(this.zzc, zzent.zza);
    }

    public final void zzc() {
        zzfcs.zza(this.zzc, zzenv.zza);
        zzfcs.zza(this.zzg, zzenw.zza);
        zzfcs.zza(this.zzg, zzenx.zza);
    }

    public final void zzdB(zze zze2) {
        zzfcs.zza(this.zzc, new zzenm(zze2));
        zzfcs.zza(this.zzc, new zzenn(zze2));
        zzfcs.zza(this.zzf, new zzeno(zze2));
        this.zzh.set(false);
        this.zzb.clear();
    }

    public final void zzdG() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkv)).booleanValue()) {
            zzfcs.zza(this.zzc, zzeny.zza);
        }
        zzfcs.zza(this.zzg, zzenk.zza);
    }

    public final void zzdf() {
        zzfcs.zza(this.zzc, zzenu.zza);
    }

    public final void zzdn(zzbxd zzbxd) {
    }

    public final void zzdo(zzffz zzffz) {
        this.zzh.set(true);
        this.zzj.set(false);
    }

    public final void zzds(zzbxq zzbxq, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final synchronized zzbh zzg() {
        return (zzbh) this.zzc.get();
    }

    public final void zzh(zzs zzs) {
        zzfcs.zza(this.zze, new zzenz(zzs));
    }

    public final synchronized zzcb zzi() {
        return (zzcb) this.zzd.get();
    }

    public final void zzj(zzbh zzbh) {
        this.zzc.set(zzbh);
    }

    public final void zzk(zzbk zzbk) {
        this.zzf.set(zzbk);
    }

    public final void zzl(zzdg zzdg) {
        this.zze.set(zzdg);
    }

    public final void zzm(zzcb zzcb) {
        this.zzd.set(zzcb);
        this.zzi.set(true);
        zzo();
    }

    public final void zzn(zzci zzci) {
        this.zzg.set(zzci);
    }

    public final void zzq(zze zze2) {
        zzfcs.zza(this.zzg, new zzenr(zze2));
    }

    public final void zzr() {
        zzfcs.zza(this.zzc, zzenh.zza);
    }

    public final synchronized void zzs() {
        zzfcs.zza(this.zzc, zzenp.zza);
        zzfcs.zza(this.zzf, zzenq.zza);
        this.zzj.set(true);
        zzo();
    }
}
