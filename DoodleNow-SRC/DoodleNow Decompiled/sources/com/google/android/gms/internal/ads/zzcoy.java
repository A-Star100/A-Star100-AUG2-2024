package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.amazon.a.a.o.b;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcoy implements zzcoa {
    private final zzdxf zza;

    zzcoy(zzdxf zzdxf) {
        this.zza = zzdxf;
    }

    public final void zza(Map map) {
        String str = (String) map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzo(str.equals(b.ac));
        }
    }
}
