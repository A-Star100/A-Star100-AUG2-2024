package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyt extends AbstractSet {
    final /* synthetic */ zzfyw zza;

    zzfyt(zzfyw zzfyw) {
        this.zza = zzfyw;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzfyw zzfyw = this.zza;
        Map zzl = zzfyw.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzfyn(zzfyw);
    }

    public final boolean remove(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        return this.zza.zzy(obj) != zzfyw.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
