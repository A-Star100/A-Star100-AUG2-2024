package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzftt implements OnCompleteListener {
    public final /* synthetic */ zzftu zza;

    public /* synthetic */ zzftt(zzftu zzftu) {
        this.zza = zzftu;
    }

    public final void onComplete(Task task) {
        zzftu zzftu = this.zza;
        if (task.isCanceled()) {
            zzftu.cancel(false);
        } else if (task.isSuccessful()) {
            zzftu.zzc(task.getResult());
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                zzftu.zzd(exception);
                return;
            }
            throw new IllegalStateException();
        }
    }
}
