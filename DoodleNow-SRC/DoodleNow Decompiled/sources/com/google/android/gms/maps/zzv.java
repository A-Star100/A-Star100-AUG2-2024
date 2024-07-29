package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzu;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzv extends zzu {
    final /* synthetic */ GoogleMap.OnCameraMoveStartedListener zza;

    zzv(GoogleMap googleMap, GoogleMap.OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.zza = onCameraMoveStartedListener;
    }

    public final void zzb(int i) {
        this.zza.onCameraMoveStarted(i);
    }
}
