package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.internal.zzay;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
final class zzh extends zzay {
    final /* synthetic */ GoogleMap.OnMyLocationButtonClickListener zza;

    zzh(GoogleMap googleMap, GoogleMap.OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        this.zza = onMyLocationButtonClickListener;
    }

    public final boolean zzb() throws RemoteException {
        return this.zza.onMyLocationButtonClick();
    }
}
