package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfpm implements Continuation {
    public final /* synthetic */ zzasi zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzfpm(zzasi zzasi, int i) {
        this.zza = zzasi;
        this.zzb = i;
    }

    public final Object then(Task task) {
        int i = zzfpp.zza;
        if (!task.isSuccessful()) {
            return false;
        }
        int i2 = this.zzb;
        zzfru zza2 = ((zzfrv) task.getResult()).zza(((zzaso) this.zza.zzbr()).zzaV());
        zza2.zza(i2);
        zza2.zzc();
        return true;
    }
}
