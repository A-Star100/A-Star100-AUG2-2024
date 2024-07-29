package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzhao implements Map.Entry {
    private final Map.Entry zza;

    /* synthetic */ zzhao(Map.Entry entry, zzhan zzhan) {
        this.zza = entry;
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (((zzhaq) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzhbl) {
            return ((zzhaq) this.zza.getValue()).zzc((zzhbl) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzhaq zza() {
        return (zzhaq) this.zza.getValue();
    }
}
