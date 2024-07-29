package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgbi extends zzfxo {
    final Iterator zza;
    final /* synthetic */ zzgbj zzb;

    zzgbi(zzgbj zzgbj) {
        this.zzb = zzgbj;
        this.zza = zzgbj.zza.iterator();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            Set set = this.zzb.zzb;
            Object next = it.next();
            if (set.contains(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
