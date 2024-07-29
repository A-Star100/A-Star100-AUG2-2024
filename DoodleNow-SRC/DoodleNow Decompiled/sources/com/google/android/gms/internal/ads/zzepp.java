package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzepp implements zzgdl {
    public static final /* synthetic */ zzepp zza = new zzepp();

    private /* synthetic */ zzepp() {
    }

    public final ListenableFuture zza(Object obj) {
        if (((Throwable) obj) instanceof TimeoutException) {
            return zzgee.zzh(zzepq.zza);
        }
        return zzgee.zzh(zzepr.zza);
    }
}
