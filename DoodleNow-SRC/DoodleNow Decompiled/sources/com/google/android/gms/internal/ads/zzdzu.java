package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzu extends zzdzw {
    public zzdzu(Context context) {
        this.zzf = new zzbwa(context, zzu.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzg(this.zze, new zzdzv(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzeal(1));
                } catch (Throwable th) {
                    zzu.zzo().zzw(th, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zzd(new zzeal(1));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzm.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzeal(1));
    }
}
