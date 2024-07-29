package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyv extends AbstractCollection {
    final /* synthetic */ zzfyw zza;

    zzfyv(zzfyw zzfyw) {
        this.zza = zzfyw;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzfyw zzfyw = this.zza;
        Map zzl = zzfyw.zzl();
        if (zzl != null) {
            return zzl.values().iterator();
        }
        return new zzfyp(zzfyw);
    }

    public final int size() {
        return this.zza.size();
    }
}
