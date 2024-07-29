package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzfrx extends zzazp implements zzfry {
    public zzfrx() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                zzazq.zzc(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzazq.zzc(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzazq.zzc(parcel);
                break;
            case 6:
                parcel.readInt();
                zzazq.zzc(parcel);
                break;
            case 7:
                parcel.readInt();
                zzazq.zzc(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzazq.zzc(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
