package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcfc extends zzcey {
    public zzcfc(zzcdn zzcdn) {
        super(zzcdn);
    }

    public final void zzf() {
    }

    public final boolean zzt(String str) {
        String zzf = zzf.zzf(str);
        zzcdn zzcdn = (zzcdn) this.zzc.get();
        if (!(zzcdn == null || zzf == null)) {
            zzcdn.zzt(zzf, this);
        }
        zzm.zzj("VideoStreamNoopCache is doing nothing.");
        zzg(str, zzf, "noop", "Noop cache is a noop.");
        return false;
    }
}
