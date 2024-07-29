package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzazo;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzbqo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbv extends zzazo implements IInterface {
    zzbv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManagerCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, zzq zzq, String str, zzbqo zzbqo, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzq);
        zza.writeString(str);
        zzazq.zzf(zza, zzbqo);
        zza.writeInt(241199000);
        zza.writeInt(i2);
        Parcel zzdb = zzdb(2, zza);
        IBinder readStrongBinder = zzdb.readStrongBinder();
        zzdb.recycle();
        return readStrongBinder;
    }
}
