package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbyv {
    public static final zzbyj zza(Context context, String str, zzbqo zzbqo) {
        try {
            IBinder zze = ((zzbyn) zzq.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzbyu.zza)).zze(ObjectWrapper.wrap(context), str, zzbqo, 241199000);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return queryLocalInterface instanceof zzbyj ? (zzbyj) queryLocalInterface : new zzbyh(zze);
        } catch (RemoteException | zzp e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return null;
        }
    }
}
