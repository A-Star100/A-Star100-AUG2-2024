package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbcf {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbcb(this);
    /* access modifiers changed from: private */
    public final Object zzc = new Object();
    /* access modifiers changed from: private */
    public zzbci zzd;
    private Context zze;
    /* access modifiers changed from: private */
    public zzbcl zzf;

    static /* bridge */ /* synthetic */ void zzh(zzbcf zzbcf) {
        synchronized (zzbcf.zzc) {
            zzbci zzbci = zzbcf.zzd;
            if (zzbci != null) {
                if (zzbci.isConnected() || zzbcf.zzd.isConnecting()) {
                    zzbcf.zzd.disconnect();
                }
                zzbcf.zzd = null;
                zzbcf.zzf = null;
                Binder.flushPendingCommands();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzc
            monitor-enter(r0)
            android.content.Context r1 = r3.zze     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzbci r1 = r3.zzd     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.zzbcd r1 = new com.google.android.gms.internal.ads.zzbcd     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzbce r2 = new com.google.android.gms.internal.ads.zzbce     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzbci r1 = r3.zzd(r1, r2)     // Catch:{ all -> 0x0023 }
            r3.zzd = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcf.zzl():void");
    }

    public final long zza(zzbcj zzbcj) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2;
            }
            if (this.zzd.zzp()) {
                try {
                    long zze2 = this.zzf.zze(zzbcj);
                    return zze2;
                } catch (RemoteException e) {
                    zzm.zzh("Unable to call into cache service.", e);
                    return -2;
                }
            }
        }
    }

    public final zzbcg zzb(zzbcj zzbcj) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                zzbcg zzbcg = new zzbcg();
                return zzbcg;
            }
            try {
                if (this.zzd.zzp()) {
                    zzbcg zzg = this.zzf.zzg(zzbcj);
                    return zzg;
                }
                zzbcg zzf2 = this.zzf.zzf(zzbcj);
                return zzf2;
            } catch (RemoteException e) {
                zzm.zzh("Unable to call into cache service.", e);
                return new zzbcg();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized zzbci zzd(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbci(this.zze, zzu.zzt().zzb(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.zzc
            monitor-enter(r0)
            android.content.Context r1 = r2.zze     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zze = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbdq r3 = com.google.android.gms.internal.ads.zzbdz.zzeh     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zza(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.zzl()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzbdq r3 = com.google.android.gms.internal.ads.zzbdz.zzeg     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zza(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzbcc r3 = new com.google.android.gms.internal.ads.zzbcc     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzbas r1 = com.google.android.gms.ads.internal.zzu.zzb()     // Catch:{ all -> 0x0048 }
            r1.zzc(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcf.zzi(android.content.Context):void");
    }

    public final void zzj() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzei)).booleanValue()) {
            synchronized (this.zzc) {
                zzl();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzcbr.zzd.schedule(this.zzb, ((Long) zzba.zzc().zza(zzbdz.zzej)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }
}
