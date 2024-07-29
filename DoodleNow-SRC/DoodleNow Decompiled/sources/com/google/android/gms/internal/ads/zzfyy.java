package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyy extends zzgay implements Serializable {
    final Comparator zza;

    zzfyy(Comparator comparator) {
        this.zza = comparator;
    }

    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj, obj2);
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfyy) {
            return this.zza.equals(((zzfyy) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
