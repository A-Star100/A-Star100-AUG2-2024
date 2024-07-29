package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzsw extends Handler {
    final /* synthetic */ zzsy zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzsw(zzsy zzsy, Looper looper) {
        super(looper);
        this.zza = zzsy;
    }

    public final void handleMessage(Message message) {
        zzsy.zza(this.zza, message);
    }
}
