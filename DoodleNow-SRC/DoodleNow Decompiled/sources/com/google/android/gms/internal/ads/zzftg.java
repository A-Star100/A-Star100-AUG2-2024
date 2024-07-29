package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public class zzftg extends Handler {
    private final Looper zza = Looper.getMainLooper();

    public zzftg() {
    }

    public final void dispatchMessage(Message message) {
        zza(message);
    }

    /* access modifiers changed from: protected */
    public void zza(Message message) {
        super.dispatchMessage(message);
    }

    public zzftg(Looper looper) {
        super(looper);
    }
}
