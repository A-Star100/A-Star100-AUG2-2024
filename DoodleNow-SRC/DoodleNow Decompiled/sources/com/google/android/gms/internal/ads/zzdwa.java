package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdwa implements Runnable {
    public final /* synthetic */ zzdwk zza;
    public final /* synthetic */ zzcbw zzb;

    public /* synthetic */ zzdwa(zzdwk zzdwk, zzcbw zzcbw) {
        this.zza = zzdwk;
        this.zzb = zzcbw;
    }

    public final void run() {
        String zzc = zzu.zzo().zzi().zzg().zzc();
        boolean isEmpty = TextUtils.isEmpty(zzc);
        zzcbw zzcbw = this.zzb;
        if (!isEmpty) {
            zzcbw.zzc(zzc);
        } else {
            zzcbw.zzd(new Exception());
        }
    }
}
