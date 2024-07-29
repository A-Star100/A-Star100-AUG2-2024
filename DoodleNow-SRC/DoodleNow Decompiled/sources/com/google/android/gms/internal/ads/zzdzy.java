package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzy extends zzdzw {
    zzdzy(Context context) {
        this.zzf = new zzbwa(context, zzu.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, new zzdzv(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzeal(1));
                } catch (Throwable th) {
                    zzu.zzo().zzw(th, "RemoteSignalsClientTask.onConnected");
                    this.zza.zzd(new zzeal(1));
                }
            }
        }
    }

    public final ListenableFuture zzb(zzbxd zzbxd) {
        synchronized (this.zzb) {
            if (this.zzc) {
                zzcbw zzcbw = this.zza;
                return zzcbw;
            }
            this.zzc = true;
            this.zze = zzbxd;
            this.zzf.checkAvailabilityAndConnect();
            this.zza.addListener(new zzdzx(this), zzcbr.zzf);
            zzcbw zzcbw2 = this.zza;
            return zzcbw2;
        }
    }
}
