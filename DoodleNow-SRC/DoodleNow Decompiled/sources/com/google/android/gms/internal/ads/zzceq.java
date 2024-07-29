package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzb;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzceq extends zzb {
    final zzcdn zza;
    final zzcey zzb;
    private final String zzc;
    private final String[] zzd;

    zzceq(zzcdn zzcdn, zzcey zzcey, String str, String[] strArr) {
        this.zza = zzcdn;
        this.zzb = zzcey;
        this.zzc = str;
        this.zzd = strArr;
        zzu.zzy().zzb(this);
    }

    public final void zza() {
        try {
            this.zzb.zzu(this.zzc, this.zzd);
        } finally {
            zzt.zza.post(new zzcep(this));
        }
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzbW)).booleanValue() || !(this.zzb instanceof zzcfh)) {
            return super.zzb();
        }
        return zzcbr.zze.zzb(new zzceo(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Boolean zzd() throws Exception {
        return Boolean.valueOf(this.zzb.zzw(this.zzc, this.zzd, this));
    }

    public final String zze() {
        return this.zzc;
    }
}
