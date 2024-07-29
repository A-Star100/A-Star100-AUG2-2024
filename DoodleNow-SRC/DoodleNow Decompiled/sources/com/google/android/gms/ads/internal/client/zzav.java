package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbyv;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzav extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbqo zzc;
    final /* synthetic */ zzaw zzd;

    zzav(zzaw zzaw, Context context, String str, zzbqo zzbqo) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbqo;
        this.zzd = zzaw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "rewarded");
        return new zzfc();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzo(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, 241199000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return zzbyv.zza(this.zza, this.zzb, this.zzc);
    }
}
