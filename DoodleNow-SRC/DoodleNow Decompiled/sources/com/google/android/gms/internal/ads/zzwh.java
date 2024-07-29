package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzwh implements zzwy {
    final /* synthetic */ zzwk zza;
    /* access modifiers changed from: private */
    public final int zzb;

    public zzwh(zzwk zzwk, int i) {
        this.zza = zzwk;
        this.zzb = i;
    }

    public final int zza(zzlb zzlb, zzih zzih, int i) {
        return this.zza.zzg(this.zzb, zzlb, zzih, i);
    }

    public final int zzb(long j) {
        return this.zza.zzi(this.zzb, j);
    }

    public final void zzd() throws IOException {
        this.zza.zzI(this.zzb);
    }

    public final boolean zze() {
        return this.zza.zzP(this.zzb);
    }
}
