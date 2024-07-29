package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public interface zzbsn extends IInterface {
    zzdq zze() throws RemoteException;

    zzbtc zzf() throws RemoteException;

    zzbtc zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbsq zzbsq) throws RemoteException;

    void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbry zzbry, zzbqu zzbqu) throws RemoteException;

    void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsb zzbsb, zzbqu zzbqu, zzq zzq) throws RemoteException;

    void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsb zzbsb, zzbqu zzbqu, zzq zzq) throws RemoteException;

    void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbse zzbse, zzbqu zzbqu) throws RemoteException;

    void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsh zzbsh, zzbqu zzbqu) throws RemoteException;

    void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsh zzbsh, zzbqu zzbqu, zzbgt zzbgt) throws RemoteException;

    void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsk zzbsk, zzbqu zzbqu) throws RemoteException;

    void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsk zzbsk, zzbqu zzbqu) throws RemoteException;

    void zzq(String str) throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
