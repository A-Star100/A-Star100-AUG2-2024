package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzam;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzz extends zzam {
    final /* synthetic */ GoogleMap.OnMapClickListener zza;

    zzz(GoogleMap googleMap, GoogleMap.OnMapClickListener onMapClickListener) {
        this.zza = onMapClickListener;
    }

    public final void zzb(LatLng latLng) {
        this.zza.onMapClick(latLng);
    }
}
