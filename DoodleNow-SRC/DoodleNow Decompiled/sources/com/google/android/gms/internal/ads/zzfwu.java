package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzfwu implements Serializable, zzfws {
    private final List zza;

    /* synthetic */ zzfwu(List list, zzfwt zzfwt) {
        this.zza = list;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzfwu) {
            return this.zza.equals(((zzfwu) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z = true;
        for (Object next : this.zza) {
            if (!z) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
            sb.append(next);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    public final boolean zza(Object obj) {
        for (int i = 0; i < this.zza.size(); i++) {
            if (!((zzfws) this.zza.get(i)).zza(obj)) {
                return false;
            }
        }
        return true;
    }
}
