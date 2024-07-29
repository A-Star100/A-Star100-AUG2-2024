package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
abstract class zzgdo extends zzgdd {
    @CheckForNull
    private List zza;

    zzgdo(zzfzi zzfzi, boolean z) {
        super(zzfzi, z, true);
        List list;
        if (zzfzi.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = zzgad.zza(zzfzi.size());
        }
        for (int i = 0; i < zzfzi.size(); i++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    /* access modifiers changed from: package-private */
    public abstract Object zzG(List list);

    /* access modifiers changed from: package-private */
    public final void zzf(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzgdn(obj));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu() {
        List list = this.zza;
        if (list != null) {
            zzc(zzG(list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i) {
        super.zzy(i);
        this.zza = null;
    }
}
