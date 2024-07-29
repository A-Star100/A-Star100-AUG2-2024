package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcev implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ zzcey zzd;

    zzcev(zzcey zzcey, String str, String str2, int i) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = zzcey;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.zza);
        hashMap.put("cachedSrc", this.zzb);
        hashMap.put("totalBytes", Integer.toString(this.zzc));
        zzcey.zze(this.zzd, "onPrecacheEvent", hashMap);
    }
}
