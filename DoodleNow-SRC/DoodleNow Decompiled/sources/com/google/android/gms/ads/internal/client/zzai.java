package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzblu;
import com.google.android.gms.internal.ads.zzbmd;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbqo;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzai extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbqo zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    zzai(zzaw zzaw, Context context, zzbqo zzbqo, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbqo;
        this.zzc = onH5AdsEventListener;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza() {
        return new zzbmh();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzk(ObjectWrapper.wrap(this.zza), this.zzb, 241199000, new zzblu(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbmd) zzq.zzb(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzah.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, 241199000, new zzblu(this.zzc));
        } catch (RemoteException | zzp | NullPointerException unused) {
            return null;
        }
    }
}
