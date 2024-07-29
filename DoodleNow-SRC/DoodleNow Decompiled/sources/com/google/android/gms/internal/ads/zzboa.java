package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzboa implements zzcib {
    public final /* synthetic */ zzbol zza;

    public /* synthetic */ zzboa(zzbol zzbol) {
        this.zza = zzbol;
    }

    public final void zza() {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        zzbol zzbol = this.zza;
        long j = zzbol.zzc;
        ArrayList arrayList = zzbol.zzb;
        arrayList.add(Long.valueOf(currentTimeMillis - j));
        String valueOf = String.valueOf(arrayList.get(0));
        zze.zza("LoadNewJavascriptEngine(onEngLoaded) latency is " + valueOf + " ms.");
        zzt.zza.postDelayed(new zzboh(zzbol.zza, zzbol.zzd, zzbol.zze, arrayList, j), (long) ((Integer) zzba.zzc().zza(zzbdz.zzc)).intValue());
    }
}
