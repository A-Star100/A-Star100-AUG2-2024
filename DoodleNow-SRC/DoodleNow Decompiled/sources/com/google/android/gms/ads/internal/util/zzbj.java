package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzaqu;
import com.google.android.gms.internal.ads.zzaqz;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbj implements zzaqu {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbn zzb;

    zzbj(zzbq zzbq, String str, zzbn zzbn) {
        this.zza = str;
        this.zzb = zzbn;
    }

    public final void zza(zzaqz zzaqz) {
        String zzaqz2 = zzaqz.toString();
        zzm.zzj("Failed to load URL: " + this.zza + "\n" + zzaqz2);
        this.zzb.zza((Object) null);
    }
}
