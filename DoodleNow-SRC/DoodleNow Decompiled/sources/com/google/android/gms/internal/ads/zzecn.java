package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzecn implements zzgdl {
    public final /* synthetic */ zzecu zza;

    public /* synthetic */ zzecn(zzecu zzecu) {
        this.zza = zzecu;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgee.zzh(zzfhj.zza((InputStream) obj));
    }
}
