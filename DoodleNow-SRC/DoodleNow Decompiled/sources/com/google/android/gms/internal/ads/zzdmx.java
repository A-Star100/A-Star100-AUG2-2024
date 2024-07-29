package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdmx implements zzczk {
    private final zzdky zza;
    private final zzdld zzb;
    private final Executor zzc;
    private final Executor zzd;

    public zzdmx(zzdky zzdky, zzdld zzdld, Executor executor, Executor executor2) {
        this.zza = zzdky;
        this.zzb = zzdld;
        this.zzc = executor;
        this.zzd = executor2;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzcgm zzcgm) {
        this.zzc.execute(new zzdmv(zzcgm));
    }

    public final void zzr() {
        if (this.zzb.zzd()) {
            zzdky zzdky = this.zza;
            zzfmy zzu = zzdky.zzu();
            if (zzu == null && zzdky.zzw() != null) {
                if (((Boolean) zzba.zzc().zza(zzbdz.zzfc)).booleanValue()) {
                    zzdky zzdky2 = this.zza;
                    ListenableFuture zzw = zzdky2.zzw();
                    zzcbw zzp = zzdky2.zzp();
                    if (zzw != null && zzp != null) {
                        zzgee.zzr(zzgee.zzl(zzw, zzp), new zzdmw(this), this.zzd);
                        return;
                    }
                    return;
                }
            }
            if (zzu != null) {
                zzdky zzdky3 = this.zza;
                zzcgm zzr = zzdky3.zzr();
                zzcgm zzs = zzdky3.zzs();
                if (zzr == null) {
                    zzr = zzs != null ? zzs : null;
                }
                if (zzr != null) {
                    zzb(zzr);
                }
            }
        }
    }
}
