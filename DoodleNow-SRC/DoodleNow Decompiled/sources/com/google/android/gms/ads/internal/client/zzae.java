package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzcas;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzae extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbqo zzb;

    zzae(zzaw zzaw, Context context, zzbqo zzbqo) {
        this.zza = context;
        this.zzb = zzbqo;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzp(ObjectWrapper.wrap(this.zza), this.zzb, 241199000);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzcas) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzad.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 241199000);
        } catch (RemoteException | zzp | NullPointerException unused) {
            return null;
        }
    }
}
