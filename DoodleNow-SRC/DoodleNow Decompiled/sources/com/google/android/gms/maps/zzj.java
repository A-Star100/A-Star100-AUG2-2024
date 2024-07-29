package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzao;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzj extends zzao {
    final /* synthetic */ GoogleMap.OnMapLoadedCallback zza;

    zzj(GoogleMap googleMap, GoogleMap.OnMapLoadedCallback onMapLoadedCallback) {
        this.zza = onMapLoadedCallback;
    }

    public final void zzb() throws RemoteException {
        this.zza.onMapLoaded();
    }
}
