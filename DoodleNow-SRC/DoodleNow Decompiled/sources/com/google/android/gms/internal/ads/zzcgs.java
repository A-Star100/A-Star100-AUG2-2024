package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcgs implements zzgea {
    final /* synthetic */ List zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ Uri zzc;
    final /* synthetic */ zzcgu zzd;

    zzcgs(zzcgu zzcgu, List list, String str, Uri uri) {
        this.zza = list;
        this.zzb = str;
        this.zzc = uri;
        this.zzd = zzcgu;
    }

    public final void zza(Throwable th) {
        zzm.zzj("Failed to parse gmsg params for: ".concat(String.valueOf(String.valueOf(this.zzc))));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List list = this.zza;
        String str = this.zzb;
        this.zzd.zzU((Map) obj, list, str);
    }
}
