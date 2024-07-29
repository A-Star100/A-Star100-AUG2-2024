package com.google.android.gms.internal.ads;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgbc extends zzfzs {
    private final transient zzfzq zza;
    private final transient zzfzn zzb;

    zzgbc(zzfzq zzfzq, zzfzn zzfzn) {
        this.zza = zzfzq;
        this.zzb = zzfzn;
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, i);
    }

    public final zzfzn zzd() {
        return this.zzb;
    }

    public final zzgbt zze() {
        return this.zzb.listIterator(0);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf() {
        return true;
    }
}
