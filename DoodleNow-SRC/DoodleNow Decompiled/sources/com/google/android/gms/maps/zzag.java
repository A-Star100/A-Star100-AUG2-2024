package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.zzas;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzag extends zzas {
    final /* synthetic */ OnMapReadyCallback zza;

    zzag(zzah zzah, OnMapReadyCallback onMapReadyCallback) {
        this.zza = onMapReadyCallback;
    }

    public final void zzb(IGoogleMapDelegate iGoogleMapDelegate) throws RemoteException {
        this.zza.onMapReady(new GoogleMap(iGoogleMapDelegate));
    }
}
