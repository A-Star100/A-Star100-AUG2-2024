package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdpc extends zzbhu {
    private final String zza;
    private final zzdkt zzb;
    private final zzdky zzc;

    public zzdpc(String str, zzdkt zzdkt, zzdky zzdky) {
        this.zza = str;
        this.zzb = zzdkt;
        this.zzc = zzdky;
    }

    public final Bundle zzb() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdq zzc() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzbgx zzd() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbhe zze() throws RemoteException {
        return this.zzc.zzo();
    }

    public final IObjectWrapper zzf() throws RemoteException {
        return this.zzc.zzv();
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzh() throws RemoteException {
        return this.zzc.zzx();
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

    public final List zzm() throws RemoteException {
        return this.zzc.zzG();
    }

    public final void zzn() throws RemoteException {
        this.zzb.zzb();
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        this.zzb.zzF(bundle);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zzb.zzK(bundle);
    }

    public final boolean zzq(Bundle bundle) throws RemoteException {
        return this.zzb.zzX(bundle);
    }
}
