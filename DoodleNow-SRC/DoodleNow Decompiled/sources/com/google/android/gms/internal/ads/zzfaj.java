package com.google.android.gms.internal.ads;

import android.os.Build;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzcn;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfaj implements Callable {
    public static final /* synthetic */ zzfaj zza = new zzfaj();

    private /* synthetic */ zzfaj() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzba.zzc().zza(zzbdz.zzK);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzba.zzc().zza(zzbdz.zzL)).intValue()) {
                for (String str2 : str.split(f.a, -1)) {
                    hashMap.put(str2, zzcn.zza(str2));
                }
            }
        }
        return new zzfal(hashMap);
    }
}
