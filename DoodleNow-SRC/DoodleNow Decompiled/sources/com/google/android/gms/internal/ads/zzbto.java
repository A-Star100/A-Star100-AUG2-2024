package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbto implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbtp zza;

    zzbto(zzbtp zzbtp) {
        this.zza = zzbtp;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzh("User canceled the download.");
    }
}
