package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgdr extends zzgdd {
    /* access modifiers changed from: private */
    @CheckForNull
    public zzgdq zza;

    zzgdr(zzfzi zzfzi, boolean z, Executor executor, Callable callable) {
        super(zzfzi, z, false);
        this.zza = new zzgdp(this, callable, executor);
        zzv();
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i, @CheckForNull Object obj) {
    }

    /* access modifiers changed from: protected */
    public final void zzq() {
        zzgdq zzgdq = this.zza;
        if (zzgdq != null) {
            zzgdq.zzh();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzu() {
        zzgdq zzgdq = this.zza;
        if (zzgdq != null) {
            zzgdq.zzf();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i) {
        super.zzy(i);
        if (i == 1) {
            this.zza = null;
        }
    }
}
