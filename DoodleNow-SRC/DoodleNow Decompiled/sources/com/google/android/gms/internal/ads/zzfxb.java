package com.google.android.gms.internal.ads;

import java.util.Iterator;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzfxb implements Iterable {
    final /* synthetic */ CharSequence zza;
    final /* synthetic */ zzfxe zzb;

    zzfxb(zzfxe zzfxe, CharSequence charSequence) {
        this.zza = charSequence;
        this.zzb = zzfxe;
    }

    public final Iterator iterator() {
        return this.zzb.zzg(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        zzfwg.zzb(sb, this, ", ");
        sb.append(AbstractJsonLexerKt.END_LIST);
        return sb.toString();
    }
}
