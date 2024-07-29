package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzal extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzaw zzd;

    zzal(zzaw zzaw, Context context, zzq zzq, String str) {
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        this.zzd = zzaw;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "search");
        return new zzew();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzf(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 241199000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zzd.zza.zza(this.zza, this.zzb, this.zzc, (zzbqo) null, 3);
    }
}
