package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcbo implements Executor {
    private final Handler zza = new zzf(Looper.getMainLooper());

    zzcbo() {
    }

    public final void execute(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzu.zzp();
                zzt.zzM(zzu.zzo().zzd(), th);
                throw th;
            }
        } else {
            this.zza.post(runnable);
        }
    }
}
