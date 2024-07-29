package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzbda implements Runnable {
    public final /* synthetic */ zzbdf zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbda(zzbdf zzbdf, Context context) {
        this.zza = zzbdf;
        this.zzb = context;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbdz.zzeQ)).booleanValue();
        zzbdf zzbdf = this.zza;
        Context context = this.zzb;
        if (booleanValue) {
            try {
                zzbdf.zza = (zzazt) zzq.zzb(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzbdb.zza);
                zzbdf.zza.zze(ObjectWrapper.wrap(context), "GMA_SDK");
                zzbdf.zzb = true;
            } catch (RemoteException | zzp | NullPointerException unused) {
                zzm.zze("Cannot dynamite load clearcut");
            }
        }
    }
}
