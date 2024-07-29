package com.google.android.gms.internal.ads;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgdi extends zzgdf {
    private zzgdi() {
        super((zzgde) null);
    }

    /* synthetic */ zzgdi(zzgdh zzgdh) {
        super((zzgde) null);
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzgdj zzgdj) {
        int zzz;
        synchronized (zzgdj) {
            zzz = zzgdj.remaining - 1;
            zzgdj.remaining = zzz;
        }
        return zzz;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzgdj zzgdj, @CheckForNull Set set, Set set2) {
        synchronized (zzgdj) {
            if (zzgdj.seenExceptions == null) {
                zzgdj.seenExceptions = set2;
            }
        }
    }
}
