package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzgfc extends zzgen {
    final /* synthetic */ zzgfe zza;
    private final zzgdk zzb;

    zzgfc(zzgfe zzgfe, zzgdk zzgdk) {
        this.zza = zzgfe;
        this.zzb = zzgdk;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzgdk zzgdk = this.zzb;
        ListenableFuture zza2 = zzgdk.zza();
        zzfwr.zzd(zza2, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgdk);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzb.toString();
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Throwable th) {
        this.zza.zzd(th);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj) {
        this.zza.zzs((ListenableFuture) obj);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return this.zza.isDone();
    }
}
