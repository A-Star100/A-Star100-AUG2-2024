package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzo;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzy extends zzo {
    final /* synthetic */ GoogleMap.OnCameraIdleListener zza;

    zzy(GoogleMap googleMap, GoogleMap.OnCameraIdleListener onCameraIdleListener) {
        this.zza = onCameraIdleListener;
    }

    public final void zzb() {
        this.zza.onCameraIdle();
    }
}
