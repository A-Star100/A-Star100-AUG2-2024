package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzftv {
    public static ListenableFuture zza(Task task, CancellationTokenSource cancellationTokenSource) {
        zzftu zzftu = new zzftu(task, (Runnable) null);
        task.addOnCompleteListener(zzgev.zzb(), new zzftt(zzftu));
        return zzftu;
    }
}
