package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfqe implements OnFailureListener {
    public final /* synthetic */ zzfqi zza;

    public /* synthetic */ zzfqe(zzfqi zzfqi) {
        this.zza = zzfqi;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzf(exc);
    }
}
