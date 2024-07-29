package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfik {
    private final HashMap zza = new HashMap();

    public final zzfij zza(zzfia zzfia, Context context, zzfhs zzfhs, zzfiq zzfiq) {
        zzfij zzfij = (zzfij) this.zza.get(zzfia);
        if (zzfij != null) {
            return zzfij;
        }
        zzfhx zzfhx = new zzfhx(zzfid.zza(zzfia, context));
        zzfij zzfij2 = new zzfij(zzfhx, new zzfis(zzfhx, zzfhs, zzfiq));
        this.zza.put(zzfia, zzfij2);
        return zzfij2;
    }
}
