package com.google.mlkit.common.sdkinternal;

import java.util.Deque;

/* compiled from: com.google.mlkit:common@@18.9.0 */
public final /* synthetic */ class zzk implements Runnable {
    public final /* synthetic */ Runnable zza;

    public /* synthetic */ zzk(Runnable runnable) {
        this.zza = runnable;
    }

    public final void run() {
        MlKitThreadPool.zze((Deque) MlKitThreadPool.zza.get(), this.zza);
    }
}
