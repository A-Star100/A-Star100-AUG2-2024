package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfru {
    final /* synthetic */ zzfrv zza;
    private final byte[] zzb;
    private int zzc;
    private int zzd;

    /* synthetic */ zzfru(zzfrv zzfrv, byte[] bArr, zzfrt zzfrt) {
        this.zza = zzfrv;
        this.zzb = bArr;
    }

    public final zzfru zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzfru zzb(int i) {
        this.zzc = i;
        return this;
    }

    public final synchronized void zzc() {
        try {
            zzfrv zzfrv = this.zza;
            if (zzfrv.zzb) {
                zzfrv.zza.zzj(this.zzb);
                this.zza.zza.zzi(this.zzc);
                this.zza.zza.zzg(this.zzd);
                this.zza.zza.zzh((int[]) null);
                this.zza.zza.zzf();
            }
        } catch (RemoteException e) {
            Log.d("GASS", "Clearcut log failed", e);
        }
    }
}
