package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzemc implements zzegj {
    private final Context zza;
    private final zzcsm zzb;
    private final zzbeu zzc;
    private final zzgep zzd;
    private final zzfkn zze;

    public zzemc(Context context, zzcsm zzcsm, zzfkn zzfkn, zzgep zzgep, zzbeu zzbeu) {
        this.zza = context;
        this.zzb = zzcsm;
        this.zze = zzfkn;
        this.zzd = zzgep;
        this.zzc = zzbeu;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        zzema zzema = new zzema(this, new View(this.zza), (zzcgm) null, zzely.zza, (zzffo) zzffn.zzv.get(0));
        zzcrn zza2 = this.zzb.zza(new zzcul(zzffz, zzffn, (String) null), zzema);
        zzemb zzk = zza2.zzk();
        zzffs zzffs = zzffn.zzt;
        zzbep zzbep = new zzbep(zzk, zzffs.zzb, zzffs.zza);
        zzfkh zzfkh = zzfkh.CUSTOM_RENDER_SYN;
        return zzfjx.zzd(new zzelz(this, zzbep), this.zzd, zzfkh, this.zze).zzb(zzfkh.CUSTOM_RENDER_ACK).zzd(zzgee.zzh(zza2.zza())).zza();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.zzt;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzb(com.google.android.gms.internal.ads.zzffz r1, com.google.android.gms.internal.ads.zzffn r2) {
        /*
            r0 = this;
            com.google.android.gms.internal.ads.zzbeu r1 = r0.zzc
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzemc.zzb(com.google.android.gms.internal.ads.zzffz, com.google.android.gms.internal.ads.zzffn):boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbep zzbep) throws Exception {
        this.zzc.zze(zzbep);
    }
}
