package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzaw;
import com.google.android.gms.maps.model.Marker;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzb extends zzaw {
    final /* synthetic */ GoogleMap.OnMarkerDragListener zza;

    zzb(GoogleMap googleMap, GoogleMap.OnMarkerDragListener onMarkerDragListener) {
        this.zza = onMarkerDragListener;
    }

    public final void zzb(zzad zzad) {
        this.zza.onMarkerDrag(new Marker(zzad));
    }

    public final void zzc(zzad zzad) {
        this.zza.onMarkerDragEnd(new Marker(zzad));
    }

    public final void zzd(zzad zzad) {
        this.zza.onMarkerDragStart(new Marker(zzad));
    }
}
