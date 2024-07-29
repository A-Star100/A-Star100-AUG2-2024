package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzerq implements Callable {
    public final /* synthetic */ zzerr zza;

    public /* synthetic */ zzerq(zzerr zzerr) {
        this.zza = zzerr;
    }

    public final Object call() {
        return new zzers(Long.valueOf(zzu.zzB().currentTimeMillis() - zzu.zzo().zzi().zzg().zza()).longValue());
    }
}
