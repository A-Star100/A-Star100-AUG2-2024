package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbyg;
import com.google.android.gms.internal.ads.zzbyi;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzbyr;
import com.google.android.gms.internal.ads.zzbyx;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzfc extends zzbyi {
    private static void zzr(zzbyq zzbyq) {
        zzm.zzg("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzf.zza.post(new zzfb(zzbyq));
    }

    public final Bundle zzb() throws RemoteException {
        return new Bundle();
    }

    public final zzdn zzc() {
        return null;
    }

    public final zzbyg zzd() {
        return null;
    }

    public final String zze() throws RemoteException {
        return "";
    }

    public final void zzf(zzl zzl, zzbyq zzbyq) throws RemoteException {
        zzr(zzbyq);
    }

    public final void zzg(zzl zzl, zzbyq zzbyq) throws RemoteException {
        zzr(zzbyq);
    }

    public final void zzh(boolean z) {
    }

    public final void zzi(zzdd zzdd) throws RemoteException {
    }

    public final void zzj(zzdg zzdg) {
    }

    public final void zzk(zzbym zzbym) throws RemoteException {
    }

    public final void zzl(zzbyx zzbyx) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, boolean z) {
    }

    public final boolean zzo() throws RemoteException {
        return false;
    }

    public final void zzp(zzbyr zzbyr) throws RemoteException {
    }
}
