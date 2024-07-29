package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzerm implements zzewr {
    private final zzfcl zza;

    zzerm(zzfcl zzfcl) {
        this.zza = zzfcl;
    }

    public final int zza() {
        return 15;
    }

    public final ListenableFuture zzb() {
        zzfcl zzfcl = this.zza;
        zzerl zzerl = null;
        if (!(zzfcl == null || zzfcl.zza() == null || zzfcl.zza().isEmpty())) {
            zzerl = new zzerl(this);
        }
        return zzgee.zzh(zzerl);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
