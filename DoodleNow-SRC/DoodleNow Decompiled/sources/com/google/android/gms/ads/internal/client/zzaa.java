package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbuo;
import com.google.android.gms.internal.ads.zzbus;
import com.google.android.gms.internal.ads.zzbvs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzaa extends zzax {
    final /* synthetic */ Activity zza;
    final /* synthetic */ zzaw zzb;

    zzaa(zzaw zzaw, Activity activity) {
        this.zza = activity;
        this.zzb = zzaw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "ad_overlay");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzm(ObjectWrapper.wrap(this.zza));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbdz.zza(this.zza);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkr)).booleanValue()) {
            try {
                return zzbuo.zzI(((zzbus) zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdOverlayCreatorImpl", zzz.zza)).zze(ObjectWrapper.wrap(this.zza)));
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzb.zzh = zzbvs.zza(this.zza.getApplicationContext());
                this.zzb.zzh.zzg(e, "ClientApiBroker.createAdOverlay");
                return null;
            }
        } else {
            zzaw zzaw = this.zzb;
            return zzaw.zzf.zza(this.zza);
        }
    }
}
