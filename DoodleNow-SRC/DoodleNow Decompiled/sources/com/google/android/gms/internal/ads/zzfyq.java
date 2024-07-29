package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfyq extends AbstractSet {
    final /* synthetic */ zzfyw zza;

    zzfyq(zzfyw zzfyw) {
        this.zza = zzfyw;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzd = this.zza.zzw(entry.getKey());
            if (zzd == -1 || !zzfwl.zza(zzfyw.zzj(this.zza, zzd), entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final Iterator iterator() {
        zzfyw zzfyw = this.zza;
        Map zzl = zzfyw.zzl();
        if (zzl != null) {
            return zzl.entrySet().iterator();
        }
        return new zzfyo(zzfyw);
    }

    public final boolean remove(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzfyw zzfyw = this.zza;
        if (zzfyw.zzr()) {
            return false;
        }
        int zzc = zzfyw.zzv();
        Object key = entry.getKey();
        Object value = entry.getValue();
        zzfyw zzfyw2 = this.zza;
        int zzb = zzfyx.zzb(key, value, zzc, Objects.requireNonNull(zzfyw2.zze), zzfyw2.zzA(), zzfyw2.zzB(), zzfyw2.zzC());
        if (zzb == -1) {
            return false;
        }
        this.zza.zzq(zzb, zzc);
        zzfyw zzfyw3 = this.zza;
        zzfyw3.zzg = zzfyw3.zzg - 1;
        this.zza.zzo();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
