package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbrs extends zzbqt {
    private final Adapter zza;
    private final zzbyb zzb;

    zzbrs(Adapter adapter, zzbyb zzbyb) {
        this.zza = adapter;
        this.zzb = zzbyb;
    }

    public final void zze() throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i) throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zzg(ObjectWrapper.wrap(this.zza), i);
        }
    }

    public final void zzh(zze zze) throws RemoteException {
    }

    public final void zzi(int i, String str) throws RemoteException {
    }

    public final void zzj(int i) throws RemoteException {
    }

    public final void zzk(zze zze) {
    }

    public final void zzl(String str) {
    }

    public final void zzm() throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp() throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzq(String str, String str2) throws RemoteException {
    }

    public final void zzr(zzbhy zzbhy, String str) throws RemoteException {
    }

    public final void zzs(zzbyc zzbyc) throws RemoteException {
    }

    public final void zzt(zzbyg zzbyg) throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zzm(ObjectWrapper.wrap(this.zza), new zzbyc(zzbyg.zzf(), zzbyg.zze()));
        }
    }

    public final void zzu() throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzv() throws RemoteException {
    }

    public final void zzw() throws RemoteException {
    }

    public final void zzx() throws RemoteException {
    }

    public final void zzy() throws RemoteException {
        zzbyb zzbyb = this.zzb;
        if (zzbyb != null) {
            zzbyb.zzo(ObjectWrapper.wrap(this.zza));
        }
    }
}
