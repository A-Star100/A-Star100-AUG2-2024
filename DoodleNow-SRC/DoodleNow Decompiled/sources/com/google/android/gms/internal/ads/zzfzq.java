package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.io.FileUtils;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzfzq implements Map, Serializable {
    @CheckForNull
    private transient zzfzs zza;
    @CheckForNull
    private transient zzfzs zzb;
    @CheckForNull
    private transient zzfzi zzc;

    zzfzq() {
    }

    public static zzfzq zzc(Map map) {
        Set entrySet = map.entrySet();
        zzfzp zzfzp = new zzfzp(entrySet instanceof Collection ? entrySet.size() : 4);
        zzfzp.zzb(entrySet);
        return zzfzp.zzc();
    }

    public static zzfzq zzd() {
        return zzgbe.zza;
    }

    public static zzfzq zze(Object obj, Object obj2) {
        zzfyk.zzb("dialog_not_shown_reason", obj2);
        return zzgbe.zzj(1, new Object[]{"dialog_not_shown_reason", obj2}, (zzfzp) null);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public final boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public final boolean equals(@CheckForNull Object obj) {
        return zzgak.zzb(this, obj);
    }

    @CheckForNull
    public abstract Object get(@CheckForNull Object obj);

    @CheckForNull
    public final Object getOrDefault(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public final int hashCode() {
        return zzgbp.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    @CheckForNull
    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    @Deprecated
    public final Object remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        zzfyk.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) * 8, FileUtils.ONE_GB));
        sb.append(AbstractJsonLexerKt.BEGIN_OBJ);
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public abstract zzfzi zza();

    /* renamed from: zzb */
    public final zzfzi values() {
        zzfzi zzfzi = this.zzc;
        if (zzfzi != null) {
            return zzfzi;
        }
        zzfzi zza2 = zza();
        this.zzc = zza2;
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public abstract zzfzs zzf();

    /* access modifiers changed from: package-private */
    public abstract zzfzs zzg();

    /* renamed from: zzh */
    public final zzfzs entrySet() {
        zzfzs zzfzs = this.zza;
        if (zzfzs != null) {
            return zzfzs;
        }
        zzfzs zzf = zzf();
        this.zza = zzf;
        return zzf;
    }

    /* renamed from: zzi */
    public final zzfzs keySet() {
        zzfzs zzfzs = this.zzb;
        if (zzfzs != null) {
            return zzfzs;
        }
        zzfzs zzg = zzg();
        this.zzb = zzg;
        return zzg;
    }
}
