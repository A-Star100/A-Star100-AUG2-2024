package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public class zzhar {
    private static final zzgzf zzb = zzgzf.zza;
    protected volatile zzhbl zza;
    private volatile zzgyj zzc;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhar)) {
            return false;
        }
        zzhar zzhar = (zzhar) obj;
        zzhbl zzhbl = this.zza;
        zzhbl zzhbl2 = zzhar.zza;
        if (zzhbl == null && zzhbl2 == null) {
            return zzb().equals(zzhar.zzb());
        }
        if (zzhbl != null && zzhbl2 != null) {
            return zzhbl.equals(zzhbl2);
        }
        if (zzhbl != null) {
            zzhar.zzd(zzhbl.zzbt());
            return zzhbl.equals(zzhar.zza);
        }
        zzd(zzhbl2.zzbt());
        return this.zza.equals(zzhbl2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzc != null) {
            return ((zzgyf) this.zzc).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzaY();
        }
        return 0;
    }

    public final zzgyj zzb() {
        if (this.zzc != null) {
            return this.zzc;
        }
        synchronized (this) {
            if (this.zzc != null) {
                zzgyj zzgyj = this.zzc;
                return zzgyj;
            }
            if (this.zza == null) {
                this.zzc = zzgyj.zzb;
            } else {
                this.zzc = this.zza.zzaN();
            }
            zzgyj zzgyj2 = this.zzc;
            return zzgyj2;
        }
    }

    public final zzhbl zzc(zzhbl zzhbl) {
        zzhbl zzhbl2 = this.zza;
        this.zzc = null;
        this.zza = zzhbl;
        return zzhbl2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzhbl r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzhbl r0 = r1.zza
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzhbl r0 = r1.zza     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x000c:
            r1.zza = r2     // Catch:{ zzhak -> 0x0013 }
            com.google.android.gms.internal.ads.zzgyj r0 = com.google.android.gms.internal.ads.zzgyj.zzb     // Catch:{ zzhak -> 0x0013 }
            r1.zzc = r0     // Catch:{ zzhak -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            r1.zza = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzgyj r2 = com.google.android.gms.internal.ads.zzgyj.zzb     // Catch:{ all -> 0x001b }
            r1.zzc = r2     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhar.zzd(com.google.android.gms.internal.ads.zzhbl):void");
    }
}
