package com.google.android.gms.maps;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.internal.zzbk;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzak extends zzbk {
    final /* synthetic */ StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener zza;

    zzak(StreetViewPanorama streetViewPanorama, StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener onStreetViewPanoramaCameraChangeListener) {
        this.zza = onStreetViewPanoramaCameraChangeListener;
    }

    public final void zzb(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.zza.onStreetViewPanoramaCameraChange(streetViewPanoramaCamera);
    }
}
