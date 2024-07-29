package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcos implements zzcoa {
    private final zzffm zza;

    public zzcos(zzffm zzffm) {
        this.zza = zzffm;
    }

    public final void zza(Map map) {
        String str = (String) map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zza.zzb(Boolean.parseBoolean(str));
            } catch (Exception e) {
                throw new IllegalStateException("Invalid render_in_browser state", e);
            }
        }
    }
}
