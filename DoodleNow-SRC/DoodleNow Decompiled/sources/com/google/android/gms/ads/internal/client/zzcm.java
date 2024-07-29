package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzazo;
import com.google.android.gms.internal.ads.zzazq;
import com.google.android.gms.internal.ads.zzbmw;
import com.google.android.gms.internal.ads.zzbnd;
import com.google.android.gms.internal.ads.zzbqo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzcm extends zzazo implements zzco {
    zzcm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final float zze() throws RemoteException {
        Parcel zzdb = zzdb(7, zza());
        float readFloat = zzdb.readFloat();
        zzdb.recycle();
        return readFloat;
    }

    public final String zzf() throws RemoteException {
        Parcel zzdb = zzdb(9, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final List zzg() throws RemoteException {
        Parcel zzdb = zzdb(13, zza());
        ArrayList<zzbmw> createTypedArrayList = zzdb.createTypedArrayList(zzbmw.CREATOR);
        zzdb.recycle();
        return createTypedArrayList;
    }

    public final void zzh(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(10, zza);
    }

    public final void zzi() throws RemoteException {
        zzdc(15, zza());
    }

    public final void zzj(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzazq.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(17, zza);
    }

    public final void zzk() throws RemoteException {
        zzdc(1, zza());
    }

    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(6, zza);
    }

    public final void zzm(zzda zzda) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzda);
        zzdc(16, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzdc(5, zza);
    }

    public final void zzo(zzbqo zzbqo) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbqo);
        zzdc(11, zza);
    }

    public final void zzp(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzazq.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(4, zza);
    }

    public final void zzq(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzdc(2, zza);
    }

    public final void zzr(String str) throws RemoteException {
        throw null;
    }

    public final void zzs(zzbnd zzbnd) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbnd);
        zzdc(12, zza);
    }

    public final void zzt(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(18, zza);
    }

    public final void zzu(zzff zzff) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzff);
        zzdc(14, zza);
    }

    public final boolean zzv() throws RemoteException {
        Parcel zzdb = zzdb(8, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
