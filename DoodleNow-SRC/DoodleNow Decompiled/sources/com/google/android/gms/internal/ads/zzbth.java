package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbth implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbtj zza;

    zzbth(zzbtj zzbtj) {
        this.zza = zzbtj;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzbtj zzbtj = this.zza;
        Intent zzb = zzbtj.zzb();
        zzu.zzp();
        zzt.zzT(zzbtj.zzb, zzb);
    }
}
