package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbul;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzag extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbqo zzb;

    zzag(zzaw zzaw, Context context, zzbqo zzbqo) {
        this.zza = context;
        this.zzb = zzbqo;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzl(ObjectWrapper.wrap(this.zza), this.zzb, 241199000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbul) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzaf.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 241199000);
        } catch (RemoteException | zzp | NullPointerException unused) {
            return null;
        }
    }
}
