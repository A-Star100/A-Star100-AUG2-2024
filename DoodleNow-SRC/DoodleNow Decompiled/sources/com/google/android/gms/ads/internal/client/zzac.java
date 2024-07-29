package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbvs;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzac extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbqo zzb;

    zzac(zzaw zzaw, Context context, zzbqo zzbqo) {
        this.zza = context;
        this.zzb = zzbqo;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "out_of_context_tester");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbdz.zza(context);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjn)).booleanValue()) {
            return zzce.zzh(wrap, this.zzb, 241199000);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Context context = this.zza;
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        zzbdz.zza(context);
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzjn)).booleanValue()) {
            return null;
        }
        try {
            return ((zzdk) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", zzab.zza)).zze(wrap, this.zzb, 241199000);
        } catch (RemoteException | zzp | NullPointerException e) {
            zzbvs.zza(this.zza).zzg(e, "ClientApiBroker.getOutOfContextTester");
            return null;
        }
    }
}
