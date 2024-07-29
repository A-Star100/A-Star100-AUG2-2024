package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbgt;
import com.google.android.gms.internal.ads.zzbic;
import com.google.android.gms.internal.ads.zzbif;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbip;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbni;
import com.google.android.gms.internal.ads.zzbnr;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public interface zzbq extends IInterface {
    zzbn zze() throws RemoteException;

    void zzf(zzbic zzbic) throws RemoteException;

    void zzg(zzbif zzbif) throws RemoteException;

    void zzh(String str, zzbil zzbil, zzbii zzbii) throws RemoteException;

    void zzi(zzbnr zzbnr) throws RemoteException;

    void zzj(zzbip zzbip, zzq zzq) throws RemoteException;

    void zzk(zzbis zzbis) throws RemoteException;

    void zzl(zzbh zzbh) throws RemoteException;

    void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException;

    void zzn(zzbni zzbni) throws RemoteException;

    void zzo(zzbgt zzbgt) throws RemoteException;

    void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException;

    void zzq(zzcf zzcf) throws RemoteException;
}
