package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfgu {
    private final zzffn zza;
    private final zzffq zzb;
    private final zzefd zzc;
    private final zzfmt zzd;
    private final zzflh zze;
    private final zzcpk zzf;

    public zzfgu(zzefd zzefd, zzfmt zzfmt, zzffn zzffn, zzffq zzffq, zzcpk zzcpk, zzflh zzflh) {
        this.zza = zzffn;
        this.zzb = zzffq;
        this.zzc = zzefd;
        this.zzd = zzfmt;
        this.zzf = zzcpk;
        this.zze = zzflh;
    }

    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzb((String) it.next(), 2);
        }
    }

    public final void zzb(String str, int i) {
        if (!this.zza.zzaj) {
            this.zzd.zzc(str, this.zze);
            return;
        }
        this.zzc.zzd(new zzeff(zzu.zzB().currentTimeMillis(), this.zzb.zzb, str, i));
    }

    public final void zzc(List list, int i) {
        ListenableFuture listenableFuture;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzjR)).booleanValue() || !zzcpk.zzj(str)) {
                listenableFuture = zzgee.zzh(str);
            } else {
                listenableFuture = this.zzf.zzb(str, zzay.zze());
            }
            zzgee.zzr(listenableFuture, new zzfgt(this, i), zzcbr.zza);
        }
    }
}
