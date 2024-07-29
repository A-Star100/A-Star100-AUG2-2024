package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfiy {
    private final zzfir zza;
    private final ListenableFuture zzb;
    private boolean zzc = false;
    private boolean zzd = false;

    public zzfiy(zzfhw zzfhw, zzfiq zzfiq, zzfir zzfir) {
        this.zza = zzfir;
        this.zzb = zzgee.zzf(zzgee.zzn(zzfiq.zza(zzfir), new zzfiw(this, zzfiq, zzfhw, zzfir), zzfir.zzb()), Exception.class, new zzfix(this, zzfiq), zzfir.zzb());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.common.util.concurrent.ListenableFuture zza(com.google.android.gms.internal.ads.zzfir r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzd     // Catch:{ all -> 0x0032 }
            if (r0 != 0) goto L_0x002f
            boolean r0 = r1.zzc     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000a
            goto L_0x002f
        L_0x000a:
            com.google.android.gms.internal.ads.zzfir r0 = r1.zza     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfig r0 = r0.zza()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzfig r0 = r2.zza()     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzfir r0 = r1.zza     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfig r0 = r0.zza()     // Catch:{ all -> 0x0032 }
            com.google.android.gms.internal.ads.zzfig r2 = r2.zza()     // Catch:{ all -> 0x0032 }
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x002f
            r2 = 1
            r1.zzc = r2     // Catch:{ all -> 0x0032 }
            com.google.common.util.concurrent.ListenableFuture r2 = r1.zzb     // Catch:{ all -> 0x0032 }
            monitor-exit(r1)
            return r2
        L_0x002f:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x0032:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfiy.zza(com.google.android.gms.internal.ads.zzfir):com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzfiq zzfiq, zzfhw zzfhw, zzfir zzfir, zzfif zzfif) throws Exception {
        synchronized (this) {
            this.zzd = true;
            zzfiq.zzb(zzfif);
            if (!this.zzc) {
                zzfhw.zzd(zzfir.zza(), zzfif);
                ListenableFuture zzh = zzgee.zzh((Object) null);
                return zzh;
            }
            ListenableFuture zzh2 = zzgee.zzh(new zzfip(zzfif, zzfir));
            return zzh2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzfiq zzfiq, Exception exc) throws Exception {
        synchronized (this) {
            this.zzd = true;
            throw exc;
        }
    }

    public final synchronized void zzd(zzgea zzgea) {
        zzgee.zzr(zzgee.zzn(this.zzb, zzfiv.zza, this.zza.zzb()), zzgea, this.zza.zzb());
    }
}
