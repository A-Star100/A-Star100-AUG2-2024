package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbvs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzao extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbqo zzc;
    final /* synthetic */ zzaw zzd;

    zzao(zzaw zzaw, Context context, String str, zzbqo zzbqo) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbqo;
        this.zzd = zzaw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "native_ad");
        return new zzeu();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 241199000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbdz.zza(this.zza);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkr)).booleanValue()) {
            try {
                IBinder zze = ((zzbr) zzq.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", zzan.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 241199000);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                return queryLocalInterface instanceof zzbq ? (zzbq) queryLocalInterface : new zzbo(zze);
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzd.zzh = zzbvs.zza(this.zza);
                this.zzd.zzh.zzg(e, "ClientApiBroker.createAdLoaderBuilder");
                return null;
            }
        } else {
            return this.zzd.zzb.zza(this.zza, this.zzb, this.zzc);
        }
    }
}
