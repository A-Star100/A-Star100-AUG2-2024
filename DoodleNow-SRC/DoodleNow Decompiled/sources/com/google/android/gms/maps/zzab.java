package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzc;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzab extends zzc {
    private final GoogleMap.CancelableCallback zza;

    zzab(GoogleMap.CancelableCallback cancelableCallback) {
        this.zza = cancelableCallback;
    }

    public final void zzb() {
        this.zza.onCancel();
    }

    public final void zzc() {
        this.zza.onFinish();
    }
}
