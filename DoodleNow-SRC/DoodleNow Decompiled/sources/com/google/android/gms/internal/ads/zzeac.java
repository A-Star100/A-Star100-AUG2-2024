package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeac extends zzdzw {
    private String zzg;
    private int zzh = 1;

    zzeac(Context context) {
        this.zzf = new zzbwa(context, zzu.zzt().zzb(), this, this);
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzeal(1));
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    int i = this.zzh;
                    if (i == 2) {
                        this.zzf.zzp().zze(this.zze, new zzdzv(this));
                    } else if (i == 3) {
                        this.zzf.zzp().zzh(this.zzg, new zzdzv(this));
                    } else {
                        this.zza.zzd(new zzeal(1));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzeal(1));
                } catch (Throwable th) {
                    zzu.zzo().zzw(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
                    this.zza.zzd(new zzeal(1));
                }
            }
        }
    }

    public final ListenableFuture zzb(zzbxd zzbxd) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 2) {
                ListenableFuture zzg2 = zzgee.zzg(new zzeal(2));
                return zzg2;
            } else if (this.zzc) {
                zzcbw zzcbw = this.zza;
                return zzcbw;
            } else {
                this.zzh = 2;
                this.zzc = true;
                this.zze = zzbxd;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzeaa(this), zzcbr.zzf);
                zzcbw zzcbw2 = this.zza;
                return zzcbw2;
            }
        }
    }

    public final ListenableFuture zzc(String str) {
        synchronized (this.zzb) {
            int i = this.zzh;
            if (i != 1 && i != 3) {
                ListenableFuture zzg2 = zzgee.zzg(new zzeal(2));
                return zzg2;
            } else if (this.zzc) {
                zzcbw zzcbw = this.zza;
                return zzcbw;
            } else {
                this.zzh = 3;
                this.zzc = true;
                this.zzg = str;
                this.zzf.checkAvailabilityAndConnect();
                this.zza.addListener(new zzeab(this), zzcbr.zzf);
                zzcbw zzcbw2 = this.zza;
                return zzcbw2;
            }
        }
    }
}
