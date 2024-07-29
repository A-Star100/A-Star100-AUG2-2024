package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.google.android.gms.internal.ads.zzduc;
import com.google.android.gms.internal.ads.zzdum;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzg implements Runnable {
    public final /* synthetic */ zzdum zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Pair[] zzc;

    public /* synthetic */ zzg(zzdum zzdum, zzduc zzduc, String str, Pair[] pairArr) {
        this.zza = zzdum;
        this.zzb = str;
        this.zzc = pairArr;
    }

    public final void run() {
        zzh.zzd(this.zza, (zzduc) null, this.zzb, this.zzc);
    }
}
