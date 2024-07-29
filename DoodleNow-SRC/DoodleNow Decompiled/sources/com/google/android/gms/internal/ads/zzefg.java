package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzefg implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzm zza;

    public /* synthetic */ zzefg(zzm zzm) {
        this.zza = zzm;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zzm zzm = this.zza;
        if (zzm != null) {
            zzm.zzb();
        }
    }
}
