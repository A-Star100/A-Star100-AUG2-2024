package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzs;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzw extends zzs {
    final /* synthetic */ GoogleMap.OnCameraMoveListener zza;

    zzw(GoogleMap googleMap, GoogleMap.OnCameraMoveListener onCameraMoveListener) {
        this.zza = onCameraMoveListener;
    }

    public final void zzb() {
        this.zza.onCameraMove();
    }
}
