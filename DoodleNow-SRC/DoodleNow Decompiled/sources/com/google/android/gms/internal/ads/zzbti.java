package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbti implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbtj zza;

    zzbti(zzbtj zzbtj) {
        this.zza = zzbtj;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("Operation denied by user.");
    }
}
