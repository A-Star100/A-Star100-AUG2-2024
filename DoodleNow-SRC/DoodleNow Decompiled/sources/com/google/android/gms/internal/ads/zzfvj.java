package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfvj implements OnCompleteListener {
    public final /* synthetic */ zzfvr zza;
    public final /* synthetic */ TaskCompletionSource zzb;

    public /* synthetic */ zzfvj(zzfvr zzfvr, TaskCompletionSource taskCompletionSource) {
        this.zza = zzfvr;
        this.zzb = taskCompletionSource;
    }

    public final void onComplete(Task task) {
        this.zza.zzt(this.zzb, task);
    }
}
