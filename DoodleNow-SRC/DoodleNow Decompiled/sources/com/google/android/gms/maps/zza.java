package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzau;
import com.google.android.gms.maps.model.Marker;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zza extends zzau {
    final /* synthetic */ GoogleMap.OnMarkerClickListener zza;

    zza(GoogleMap googleMap, GoogleMap.OnMarkerClickListener onMarkerClickListener) {
        this.zza = onMarkerClickListener;
    }

    public final boolean zzb(zzad zzad) {
        return this.zza.onMarkerClick(new Marker(zzad));
    }
}
