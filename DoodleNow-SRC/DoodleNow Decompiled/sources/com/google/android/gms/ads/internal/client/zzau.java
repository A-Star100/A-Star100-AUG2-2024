package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhr;
import com.google.android.gms.internal.ads.zzbvs;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzau extends zzax {
    final /* synthetic */ View zza;
    final /* synthetic */ HashMap zzb;
    final /* synthetic */ HashMap zzc;
    final /* synthetic */ zzaw zzd;

    zzau(zzaw zzaw, View view, HashMap hashMap, HashMap hashMap2) {
        this.zza = view;
        this.zzb = hashMap;
        this.zzc = hashMap2;
        this.zzd = zzaw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza.getContext(), "native_ad_view_holder_delegate");
        return new zzfa();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        HashMap hashMap = this.zzc;
        return zzce.zzj(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(hashMap));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        zzbdz.zza(this.zza.getContext());
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkr)).booleanValue()) {
            try {
                return zzbhn.zze(((zzbhr) zzq.zzb(this.zza.getContext(), "com.google.android.gms.ads.ChimeraNativeAdViewHolderDelegateCreatorImpl", zzat.zza)).zze(ObjectWrapper.wrap(this.zza), ObjectWrapper.wrap(this.zzb), ObjectWrapper.wrap(this.zzc)));
            } catch (RemoteException | zzp | NullPointerException e) {
                this.zzd.zzh = zzbvs.zza(this.zza.getContext());
                this.zzd.zzh.zzg(e, "ClientApiBroker.createNativeAdViewHolderDelegate");
                return null;
            }
        } else {
            zzaw zzaw = this.zzd;
            return zzaw.zzg.zza(this.zza, this.zzb, this.zzc);
        }
    }
}
