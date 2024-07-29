package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzaq;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzaa extends zzaq {
    final /* synthetic */ GoogleMap.OnMapLongClickListener zza;

    zzaa(GoogleMap googleMap, GoogleMap.OnMapLongClickListener onMapLongClickListener) {
        this.zza = onMapLongClickListener;
    }

    public final void zzb(LatLng latLng) {
        this.zza.onMapLongClick(latLng);
    }
}
