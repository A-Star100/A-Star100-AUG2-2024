package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzew implements Handler.Callback {
    public final /* synthetic */ zzfb zza;

    public /* synthetic */ zzew(zzfb zzfb) {
        this.zza = zzfb;
    }

    public final boolean handleMessage(Message message) {
        zzfb.zzg(this.zza, message);
        return true;
    }
}
