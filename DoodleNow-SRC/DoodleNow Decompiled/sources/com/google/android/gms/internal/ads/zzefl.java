package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzefl implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzefo zza;
    public final /* synthetic */ zzm zzb;

    public /* synthetic */ zzefl(zzefo zzefo, zzm zzm) {
        this.zza = zzefo;
        this.zzb = zzm;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zza.zzn(this.zzb, dialogInterface, i);
    }
}
