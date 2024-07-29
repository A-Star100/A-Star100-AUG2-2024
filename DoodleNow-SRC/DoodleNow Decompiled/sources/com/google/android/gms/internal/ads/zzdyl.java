package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdyl implements zzgdl {
    public static final /* synthetic */ zzdyl zza = new zzdyl();

    private /* synthetic */ zzdyl() {
    }

    public final ListenableFuture zza(Object obj) {
        return zzgee.zzg(((ExecutionException) obj).getCause());
    }
}
