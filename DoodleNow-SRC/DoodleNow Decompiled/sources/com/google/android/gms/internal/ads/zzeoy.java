package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeoy implements zzewr {
    private final Context zza;

    zzeoy(Context context) {
        this.zza = context;
    }

    public final int zza() {
        return 2;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzcM)).booleanValue()) {
            return zzgee.zzh((Object) null);
        }
        return zzgee.zzh(new zzeoz(ContextCompat.checkSelfPermission(this.zza, "com.google.android.gms.permission.AD_ID") == 0));
    }
}
