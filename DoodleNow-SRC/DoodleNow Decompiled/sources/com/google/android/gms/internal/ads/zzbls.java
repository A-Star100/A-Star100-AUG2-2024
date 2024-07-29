package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbls implements zzbky {
    private final zzdxf zza;

    public zzbls(zzdxf zzdxf) {
        Preconditions.checkNotNull(zzdxf, "The Inspector Manager must not be null");
        this.zza = zzdxf;
    }

    public final void zza(Object obj, Map map) {
        if (map != null && map.containsKey("extras")) {
            long j = Long.MAX_VALUE;
            if (map.containsKey(PermissionsResponse.EXPIRES_KEY)) {
                try {
                    j = Long.parseLong((String) map.get(PermissionsResponse.EXPIRES_KEY));
                } catch (NumberFormatException unused) {
                }
            }
            this.zza.zzi((String) map.get("extras"), j);
        }
    }
}
