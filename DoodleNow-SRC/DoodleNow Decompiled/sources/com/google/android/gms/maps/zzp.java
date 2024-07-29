package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzaj;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbi;
import com.google.android.gms.maps.model.Polyline;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzp extends zzbi {
    final /* synthetic */ GoogleMap.OnPolylineClickListener zza;

    zzp(GoogleMap googleMap, GoogleMap.OnPolylineClickListener onPolylineClickListener) {
        this.zza = onPolylineClickListener;
    }

    public final void zzb(zzaj zzaj) {
        this.zza.onPolylineClick(new Polyline(zzaj));
    }
}
