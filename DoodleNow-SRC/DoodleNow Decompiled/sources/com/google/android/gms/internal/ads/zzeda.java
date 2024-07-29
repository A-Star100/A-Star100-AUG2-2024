package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeda implements zzgdl {
    public final /* synthetic */ zzeyg zza;

    public /* synthetic */ zzeda(zzeyg zzeyg) {
        this.zza = zzeyg;
    }

    public final ListenableFuture zza(Object obj) {
        Void voidR = (Void) obj;
        return this.zza.zza().zza(new JSONObject(), new Bundle());
    }
}
