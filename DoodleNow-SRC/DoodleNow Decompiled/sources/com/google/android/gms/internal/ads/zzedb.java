package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzedb implements zzgdl {
    public final /* synthetic */ zzede zza;

    public /* synthetic */ zzedb(zzede zzede) {
        this.zza = zzede;
    }

    public final ListenableFuture zza(Object obj) {
        return zzgee.zzh(zzfhj.zza((InputStream) obj));
    }
}
