package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzaa;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class MapCapabilities {
    private final zzaa zza;

    public MapCapabilities(zzaa zzaa) {
        this.zza = (zzaa) Preconditions.checkNotNull(zzaa);
    }

    public boolean isAdvancedMarkersAvailable() {
        try {
            return this.zza.zzd();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
