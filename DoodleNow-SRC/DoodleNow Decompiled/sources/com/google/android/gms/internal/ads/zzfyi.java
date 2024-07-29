package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyi extends AbstractCollection {
    final /* synthetic */ zzfyj zza;

    zzfyi(zzfyj zzfyj) {
        this.zza = zzfyj;
    }

    public final void clear() {
        this.zza.zzp();
    }

    public final boolean contains(@CheckForNull Object obj) {
        for (Collection contains : this.zza.zzs().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final Iterator iterator() {
        return this.zza.zzg();
    }

    public final int size() {
        return this.zza.zze();
    }
}
