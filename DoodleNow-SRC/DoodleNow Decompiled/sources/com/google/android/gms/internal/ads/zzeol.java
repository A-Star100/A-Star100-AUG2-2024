package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeol {
    private final zzeoq zza;
    private final String zzb;
    /* access modifiers changed from: private */
    public zzdn zzc;

    public zzeol(zzeoq zzeoq, String str) {
        this.zza = zzeoq;
        this.zzb = str;
    }

    public final synchronized String zza() {
        String str;
        str = null;
        try {
            zzdn zzdn = this.zzc;
            if (zzdn != null) {
                str = zzdn.zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }

    public final synchronized String zzb() {
        String str;
        str = null;
        try {
            zzdn zzdn = this.zzc;
            if (zzdn != null) {
                str = zzdn.zzg();
            }
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
        return str;
    }

    public final synchronized void zzd(zzl zzl, int i) throws RemoteException {
        this.zzc = null;
        zzeor zzeor = new zzeor(i);
        zzeok zzeok = new zzeok(this);
        this.zza.zzb(zzl, this.zzb, zzeor, zzeok);
    }

    public final synchronized boolean zze() throws RemoteException {
        return this.zza.zza();
    }
}
