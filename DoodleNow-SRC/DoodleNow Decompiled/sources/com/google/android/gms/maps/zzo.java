package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzag;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzbg;
import com.google.android.gms.maps.model.Polygon;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzo extends zzbg {
    final /* synthetic */ GoogleMap.OnPolygonClickListener zza;

    zzo(GoogleMap googleMap, GoogleMap.OnPolygonClickListener onPolygonClickListener) {
        this.zza = onPolygonClickListener;
    }

    public final void zzb(zzag zzag) {
        this.zza.onPolygonClick(new Polygon(zzag));
    }
}
