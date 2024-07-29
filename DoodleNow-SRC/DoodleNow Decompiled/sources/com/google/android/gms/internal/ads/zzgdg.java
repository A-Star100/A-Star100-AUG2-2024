package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgdg extends zzgdf {
    final AtomicReferenceFieldUpdater zza;
    final AtomicIntegerFieldUpdater zzb;

    zzgdg(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
        super((zzgde) null);
        this.zza = atomicReferenceFieldUpdater;
        this.zzb = atomicIntegerFieldUpdater;
    }

    /* access modifiers changed from: package-private */
    public final int zza(zzgdj zzgdj) {
        return this.zzb.decrementAndGet(zzgdj);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.internal.ads.zzgdj r2, @javax.annotation.CheckForNull java.util.Set r3, java.util.Set r4) {
        /*
            r1 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = r1.zza
            r0 = 0
            boolean r0 = androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(r3, r2, r0, r4)
            if (r0 == 0) goto L_0x000a
            goto L_0x0010
        L_0x000a:
            java.lang.Object r3 = r3.get(r2)
            if (r3 == 0) goto L_0x0000
        L_0x0010:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgdg.zzb(com.google.android.gms.internal.ads.zzgdj, java.util.Set, java.util.Set):void");
    }
}
