package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfzu extends zzfxo {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzfws zzb;

    zzfzu(Iterator it, zzfws zzfws) {
        this.zza = it;
        this.zzb = zzfws;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public final Object zza() {
        while (this.zza.hasNext()) {
            Iterator it = this.zza;
            zzfws zzfws = this.zzb;
            Object next = it.next();
            if (zzfws.zza(next)) {
                return next;
            }
        }
        zzb();
        return null;
    }
}
