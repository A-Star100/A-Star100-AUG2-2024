package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzejo {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final zzgex zzc;
    private final List zzd = new ArrayList();
    private final Set zze = new HashSet();
    private zzeke zzf;
    private int zzg = Integer.MAX_VALUE;
    private final String zzh;
    private final int zzi;
    private final zzekd zzj;
    private zzffn zzk;

    zzejo(zzffz zzffz, zzekd zzekd, zzgex zzgex) {
        this.zzi = zzffz.zzb.zzb.zzq;
        this.zzj = zzekd;
        this.zzc = zzgex;
        this.zzh = zzekk.zzc(zzffz);
        List list = zzffz.zzb.zza;
        for (int i = 0; i < list.size(); i++) {
            this.zza.put((zzffn) list.get(i), Integer.valueOf(i));
        }
        this.zzb.addAll(list);
    }

    private final synchronized void zzf() {
        this.zzj.zzi(this.zzk);
        zzeke zzeke = this.zzf;
        if (zzeke != null) {
            this.zzc.zzc(zzeke);
        } else {
            this.zzc.zzd(new zzekh(3, this.zzh));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0049, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzg(boolean r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.List r0 = r4.zzb     // Catch:{ all -> 0x004b }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x004b }
        L_0x0007:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x0048
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x004b }
            com.google.android.gms.internal.ads.zzffn r1 = (com.google.android.gms.internal.ads.zzffn) r1     // Catch:{ all -> 0x004b }
            java.util.Map r2 = r4.zza     // Catch:{ all -> 0x004b }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x004b }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0022
            int r2 = r2.intValue()     // Catch:{ all -> 0x004b }
            goto L_0x0025
        L_0x0022:
            r2 = 2147483647(0x7fffffff, float:NaN)
        L_0x0025:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x004b }
            if (r5 != 0) goto L_0x0035
            java.util.Set r3 = r4.zze     // Catch:{ all -> 0x004b }
            java.lang.String r1 = r1.zzat     // Catch:{ all -> 0x004b }
            boolean r1 = r3.contains(r1)     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x0007
        L_0x0035:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r3 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 >= r3) goto L_0x0040
            monitor-exit(r4)
            r5 = 1
            return r5
        L_0x0040:
            int r1 = r2.intValue()     // Catch:{ all -> 0x004b }
            int r2 = r4.zzg     // Catch:{ all -> 0x004b }
            if (r1 <= r2) goto L_0x0007
        L_0x0048:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x004b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejo.zzg(boolean):boolean");
    }

    private final synchronized boolean zzh() {
        for (zzffn zzffn : this.zzd) {
            Integer num = (Integer) this.zza.get(zzffn);
            if (Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE).intValue() < this.zzg) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean zzi() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 1
            boolean r1 = r2.zzg(r0)     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0012
            boolean r1 = r2.zzh()     // Catch:{ all -> 0x0014 }
            if (r1 == 0) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            monitor-exit(r2)
            r0 = 0
            return r0
        L_0x0012:
            monitor-exit(r2)
            return r0
        L_0x0014:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejo.zzi():boolean");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final synchronized zzffn zza() {
        int i = 0;
        while (i < this.zzb.size()) {
            zzffn zzffn = (zzffn) this.zzb.get(i);
            String str = zzffn.zzat;
            if (this.zze.contains(str)) {
                i++;
            } else {
                if (!TextUtils.isEmpty(str)) {
                    this.zze.add(str);
                }
                this.zzd.add(zzffn);
                return (zzffn) this.zzb.remove(i);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(java.lang.Throwable r1, com.google.android.gms.internal.ads.zzffn r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            java.util.List r1 = r0.zzd     // Catch:{ all -> 0x0020 }
            r1.remove(r2)     // Catch:{ all -> 0x0020 }
            java.util.Set r1 = r0.zze     // Catch:{ all -> 0x0020 }
            java.lang.String r2 = r2.zzat     // Catch:{ all -> 0x0020 }
            r1.remove(r2)     // Catch:{ all -> 0x0020 }
            boolean r1 = r0.zzd()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x001e
            boolean r1 = r0.zzi()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x001e
            r0.zzf()     // Catch:{ all -> 0x0020 }
            monitor-exit(r0)
            return
        L_0x001e:
            monitor-exit(r0)
            return
        L_0x0020:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejo.zzb(java.lang.Throwable, com.google.android.gms.internal.ads.zzffn):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(zzeke zzeke, zzffn zzffn) {
        this.zzd.remove(zzffn);
        if (zzd()) {
            zzeke.zzq();
            return;
        }
        Integer num = (Integer) this.zza.get(zzffn);
        Integer valueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
        if (valueOf.intValue() > this.zzg) {
            this.zzj.zzm(zzffn);
            return;
        }
        if (this.zzf != null) {
            this.zzj.zzm(this.zzk);
        }
        this.zzg = valueOf.intValue();
        this.zzf = zzeke;
        this.zzk = zzffn;
        if (!zzi()) {
            zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzd() {
        return this.zzc.isDone();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zze() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzd()     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 != 0) goto L_0x001b
            java.util.List r0 = r3.zzd     // Catch:{ all -> 0x001d }
            int r2 = r3.zzi     // Catch:{ all -> 0x001d }
            int r0 = r0.size()     // Catch:{ all -> 0x001d }
            if (r0 >= r2) goto L_0x001b
            boolean r0 = r3.zzg(r1)     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x001b:
            monitor-exit(r3)
            return r1
        L_0x001d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejo.zze():boolean");
    }
}
