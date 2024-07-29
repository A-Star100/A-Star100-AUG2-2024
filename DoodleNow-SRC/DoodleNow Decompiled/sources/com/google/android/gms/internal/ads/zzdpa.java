package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdpa extends zzbhs {
    private final String zza;
    private final zzdkt zzb;
    private final zzdky zzc;

    public zzdpa(String str, zzdkt zzdkt, zzdky zzdky) {
        this.zza = str;
        this.zzb = zzdkt;
        this.zzc = zzdky;
    }

    public final double zzb() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzc() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdq zzd() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzbgx zze() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbhe zzf() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return this.zzc.zzv();
    }

    public final IObjectWrapper zzh() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzy();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzz();
    }

    public final String zzk() throws RemoteException {
        return this.zzc.zzB();
    }

    public final String zzl() throws RemoteException {
        return this.zza;
    }

    public final String zzm() throws RemoteException {
        return this.zzc.zzD();
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzE();
    }

    public final List zzo() throws RemoteException {
        return this.zzc.zzG();
    }

    public final void zzp() throws RemoteException {
        this.zzb.zzb();
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        this.zzb.zzF(bundle);
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzK(bundle);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zzX(bundle);
    }
}
