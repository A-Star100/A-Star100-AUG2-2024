package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfcw implements zzfwf {
    final /* synthetic */ zzfda zza;

    zzfcw(zzfda zzfda) {
        this.zza = zzfda;
    }

    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzm.zzh("", (zzeal) obj);
        zze.zza("Failed to get a cache key, reverting to legacy flow.");
        zzfda zzfda = this.zza;
        zzfda.zzd = new zzfcz((zzbxd) null, zzfda.zze(), (zzfcy) null);
        return this.zza.zzd;
    }
}
