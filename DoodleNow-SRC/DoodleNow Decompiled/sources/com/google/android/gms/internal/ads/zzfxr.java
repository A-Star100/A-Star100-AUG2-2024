package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfxr extends zzgag {
    final /* synthetic */ zzfxt zza;

    zzfxr(zzfxt zzfxt) {
        this.zza = zzfxt;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return zzfym.zza(this.zza.zza.entrySet(), obj);
    }

    public final Iterator iterator() {
        return new zzfxs(this.zza);
    }

    public final boolean remove(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return false;
        }
        zzfxt zzfxt = this.zza;
        zzfyg.zzo(zzfxt.zzb, ((Map.Entry) Objects.requireNonNull((Map.Entry) obj)).getKey());
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Map zza() {
        return this.zza;
    }
}
