package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzekd {
    /* access modifiers changed from: private */
    public final Clock zza;
    /* access modifiers changed from: private */
    public final zzekf zzb;
    /* access modifiers changed from: private */
    public final zzfmt zzc;
    /* access modifiers changed from: private */
    public final LinkedHashMap zzd = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final boolean zze;
    /* access modifiers changed from: private */
    public final zzego zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    private long zzh;
    private long zzi;

    public zzekd(Clock clock, zzekf zzekf, zzego zzego, zzfmt zzfmt) {
        this.zza = clock;
        this.zzb = zzekf;
        this.zze = ((Boolean) zzba.zzc().zza(zzbdz.zzgV)).booleanValue();
        this.zzf = zzego;
        this.zzc = zzfmt;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r3.zzc != 8) goto L_0x0017;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0015, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0017, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzq(com.google.android.gms.internal.ads.zzffn r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.LinkedHashMap r0 = r2.zzd     // Catch:{ all -> 0x0018 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzekc r3 = (com.google.android.gms.internal.ads.zzekc) r3     // Catch:{ all -> 0x0018 }
            r0 = 0
            if (r3 != 0) goto L_0x000e
            monitor-exit(r2)
            return r0
        L_0x000e:
            int r3 = r3.zzc     // Catch:{ all -> 0x0018 }
            r1 = 8
            monitor-exit(r2)
            if (r3 != r1) goto L_0x0017
            r3 = 1
            return r3
        L_0x0017:
            return r0
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekd.zzq(com.google.android.gms.internal.ads.zzffn):boolean");
    }

    public final synchronized long zza() {
        return this.zzh;
    }

    /* access modifiers changed from: package-private */
    public final synchronized ListenableFuture zzf(zzffz zzffz, zzffn zzffn, ListenableFuture listenableFuture, zzfmp zzfmp) {
        zzffn zzffn2 = zzffn;
        ListenableFuture listenableFuture2 = listenableFuture;
        synchronized (this) {
            zzffq zzffq = zzffz.zzb.zzb;
            long elapsedRealtime = this.zza.elapsedRealtime();
            String str = zzffn2.zzx;
            if (str != null) {
                this.zzd.put(zzffn2, new zzekc(str, zzffn2.zzag, 9, 0, (Integer) null));
                zzgee.zzr(listenableFuture2, new zzekb(this, elapsedRealtime, zzffq, zzffn, str, zzfmp, zzffz), zzcbr.zzf);
            }
        }
        return listenableFuture2;
    }

    public final synchronized String zzg() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Map.Entry value : this.zzd.entrySet()) {
            zzekc zzekc = (zzekc) value.getValue();
            if (zzekc.zzc != Integer.MAX_VALUE) {
                arrayList.add(zzekc.toString());
            }
        }
        return TextUtils.join("_", arrayList);
    }

    public final synchronized void zzi(zzffn zzffn) {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
        if (zzffn != null) {
            this.zzf.zze(zzffn);
        }
        this.zzg = true;
    }

    public final synchronized void zzj() {
        this.zzh = this.zza.elapsedRealtime() - this.zzi;
    }

    public final synchronized void zzk(List list) {
        this.zzi = this.zza.elapsedRealtime();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzffn zzffn = (zzffn) it.next();
            if (!TextUtils.isEmpty(zzffn.zzx)) {
                this.zzd.put(zzffn, new zzekc(zzffn.zzx, zzffn.zzag, Integer.MAX_VALUE, 0, (Integer) null));
            }
        }
    }

    public final synchronized void zzl() {
        this.zzi = this.zza.elapsedRealtime();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzm(com.google.android.gms.internal.ads.zzffn r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.LinkedHashMap r0 = r1.zzd     // Catch:{ all -> 0x0017 }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x0017 }
            com.google.android.gms.internal.ads.zzekc r2 = (com.google.android.gms.internal.ads.zzekc) r2     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0015
            boolean r0 = r1.zzg     // Catch:{ all -> 0x0017 }
            if (r0 != 0) goto L_0x0015
            r0 = 8
            r2.zzc = r0     // Catch:{ all -> 0x0017 }
            monitor-exit(r1)
            return
        L_0x0015:
            monitor-exit(r1)
            return
        L_0x0017:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekd.zzm(com.google.android.gms.internal.ads.zzffn):void");
    }
}
