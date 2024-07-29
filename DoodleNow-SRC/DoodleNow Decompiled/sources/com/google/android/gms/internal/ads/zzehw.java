package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzehw implements zzgdl {
    public final /* synthetic */ zzehy zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ zzffz zzc;
    public final /* synthetic */ zzffn zzd;

    public /* synthetic */ zzehw(zzehy zzehy, Uri uri, zzffz zzffz, zzffn zzffn) {
        this.zza = zzehy;
        this.zzb = uri;
        this.zzc = zzffz;
        this.zzd = zzffn;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, obj);
    }
}
