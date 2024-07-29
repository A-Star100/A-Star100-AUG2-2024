package com.google.android.gms.maps.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.maps.zza;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.VisibleRegion;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzbu extends zza implements IProjectionDelegate {
    zzbu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.internal.IProjectionDelegate");
    }

    public final LatLng fromScreenLocation(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        Parcel zzJ = zzJ(1, zza);
        LatLng latLng = (LatLng) zzc.zza(zzJ, LatLng.CREATOR);
        zzJ.recycle();
        return latLng;
    }

    public final VisibleRegion getVisibleRegion() throws RemoteException {
        Parcel zzJ = zzJ(3, zza());
        VisibleRegion visibleRegion = (VisibleRegion) zzc.zza(zzJ, VisibleRegion.CREATOR);
        zzJ.recycle();
        return visibleRegion;
    }

    public final IObjectWrapper toScreenLocation(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        Parcel zzJ = zzJ(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    public final IObjectWrapper toScreenLocationWithAltitude(LatLng latLng, float f) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        zza.writeFloat(f);
        Parcel zzJ = zzJ(4, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }
}
