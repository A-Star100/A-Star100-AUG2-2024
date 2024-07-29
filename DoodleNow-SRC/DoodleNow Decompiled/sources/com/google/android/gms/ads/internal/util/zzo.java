package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbew;
import com.google.android.gms.internal.ads.zzhjn;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzo implements zzbev {
    final /* synthetic */ zzbew zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    zzo(zzt zzt, zzbew zzbew, Context context, Uri uri) {
        this.zza = zzbew;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.zza.zza()).build();
        build.intent.setPackage(zzhjn.zza(this.zzb));
        build.launchUrl(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
