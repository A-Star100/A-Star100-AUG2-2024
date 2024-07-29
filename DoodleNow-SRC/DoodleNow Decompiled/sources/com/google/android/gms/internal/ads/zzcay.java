package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcay {
    public final ListenableFuture zza(Context context, int i) {
        zzcbw zzcbw = new zzcbw();
        zzay.zzb();
        if (zzf.zzu(context)) {
            zzcbr.zza.execute(new zzcax(this, context, zzcbw));
        }
        return zzcbw;
    }
}
