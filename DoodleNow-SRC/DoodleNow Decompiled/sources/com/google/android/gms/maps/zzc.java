package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzac;
import com.google.android.gms.maps.model.Marker;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzc extends zzac {
    final /* synthetic */ GoogleMap.OnInfoWindowClickListener zza;

    zzc(GoogleMap googleMap, GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.zza = onInfoWindowClickListener;
    }

    public final void zzb(zzad zzad) {
        this.zza.onInfoWindowClick(new Marker(zzad));
    }
}
