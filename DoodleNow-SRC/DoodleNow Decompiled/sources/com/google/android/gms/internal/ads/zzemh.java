package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzemh implements zzegj {
    private final zzbeu zza;
    private final zzgep zzb;
    private final zzfkn zzc;
    /* access modifiers changed from: private */
    public final zzemq zzd;

    public zzemh(zzfkn zzfkn, zzgep zzgep, zzbeu zzbeu, zzemq zzemq) {
        this.zzc = zzfkn;
        this.zzb = zzgep;
        this.zza = zzbeu;
        this.zzd = zzemq;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        zzcbw zzcbw = new zzcbw();
        zzemm zzemm = new zzemm();
        zzemm.zzd(new zzemg(this, zzcbw, zzffz, zzffn, zzemm));
        zzffs zzffs = zzffn.zzt;
        zzbep zzbep = new zzbep(zzemm, zzffs.zzb, zzffs.zza);
        zzfkh zzfkh = zzfkh.CUSTOM_RENDER_SYN;
        return zzfjx.zzd(new zzemf(this, zzbep), this.zzb, zzfkh, this.zzc).zzb(zzfkh.CUSTOM_RENDER_ACK).zzd(zzcbw).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzffz r1, com.google.android.gms.internal.ads.zzffn r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbeu r1 = r0.zza
            if (r1 == 0) goto L_0x000e
            com.google.android.gms.internal.ads.zzffs r1 = r2.zzt
            if (r1 == 0) goto L_0x000e
            java.lang.String r1 = r1.zza
            if (r1 == 0) goto L_0x000e
            r1 = 1
            return r1
        L_0x000e:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemh.zzb(com.google.android.gms.internal.ads.zzffz, com.google.android.gms.internal.ads.zzffn):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbep zzbep) throws Exception {
        this.zza.zze(zzbep);
    }
}
