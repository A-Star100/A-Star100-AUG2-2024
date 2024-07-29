package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzm;
import com.google.android.gms.maps.model.CameraPosition;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzu extends zzm {
    final /* synthetic */ GoogleMap.OnCameraChangeListener zza;

    zzu(GoogleMap googleMap, GoogleMap.OnCameraChangeListener onCameraChangeListener) {
        this.zza = onCameraChangeListener;
    }

    public final void zzb(CameraPosition cameraPosition) {
        this.zza.onCameraChange(cameraPosition);
    }
}
