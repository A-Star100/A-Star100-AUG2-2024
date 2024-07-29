package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdzk implements zzgdl {
    public static final /* synthetic */ zzdzk zza = new zzdzk();

    private /* synthetic */ zzdzk() {
    }

    public final ListenableFuture zza(Object obj) {
        TimeoutException timeoutException = (TimeoutException) obj;
        return zzgee.zzg(new zzdyi(5));
    }
}
