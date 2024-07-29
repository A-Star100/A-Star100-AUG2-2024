package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzq;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzx extends zzq {
    final /* synthetic */ GoogleMap.OnCameraMoveCanceledListener zza;

    zzx(GoogleMap googleMap, GoogleMap.OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.zza = onCameraMoveCanceledListener;
    }

    public final void zzb() {
        this.zza.onCameraMoveCanceled();
    }
}
