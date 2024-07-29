package com.google.android.gms.maps;

import com.google.android.gms.internal.maps.zzu;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzaa;
import com.google.android.gms.maps.model.IndoorBuilding;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzk extends zzaa {
    final /* synthetic */ GoogleMap.OnIndoorStateChangeListener zza;

    zzk(GoogleMap googleMap, GoogleMap.OnIndoorStateChangeListener onIndoorStateChangeListener) {
        this.zza = onIndoorStateChangeListener;
    }

    public final void zzb() {
        this.zza.onIndoorBuildingFocused();
    }

    public final void zzc(zzu zzu) {
        this.zza.onIndoorLevelActivated(new IndoorBuilding(zzu));
    }
}
