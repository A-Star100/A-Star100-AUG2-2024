package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbvs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzaq extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzaw zzb;

    zzaq(zzaw zzaw, Context context) {
        this.zza = context;
        this.zzb = zzaw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "mobile_ads_settings");
        return new zzey();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzg(ObjectWrapper.wrap(this.zza), 241199000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbdz.zza(this.zza);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkr)).booleanValue()) {
            try {
                IBinder zze = ((zzcp) zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", zzap.zza)).zze(ObjectWrapper.wrap(this.zza), 241199000);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
                return queryLocalInterface instanceof zzco ? (zzco) queryLocalInterface : new zzcm(zze);
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzb.zzh = zzbvs.zza(this.zza);
                this.zzb.zzh.zzg(e, "ClientApiBroker.getMobileAdsSettingsManager");
                return null;
            }
        } else {
            return this.zzb.zzc.zza(this.zza);
        }
    }
}
