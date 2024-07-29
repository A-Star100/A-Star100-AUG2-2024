package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzp;
import com.google.android.gms.ads.internal.util.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvu;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzk extends RemoteCreator {
    private zzbvu zza;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzbv ? (zzbv) queryLocalInterface : new zzbv(iBinder);
    }

    public final zzbu zza(Context context, zzq zzq, String str, zzbqo zzbqo, int i) {
        zzbdz.zza(context);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkr)).booleanValue()) {
            try {
                IBinder zze = ((zzbv) zzq.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", zzj.zza)).zze(ObjectWrapper.wrap(context), zzq, str, zzbqo, 241199000, i);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return queryLocalInterface instanceof zzbu ? (zzbu) queryLocalInterface : new zzbs(zze);
            } catch (RemoteException | zzp | NullPointerException e) {
                zzbvu zza2 = zzbvs.zza(context);
                this.zza = zza2;
                zza2.zzg(e, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzm.zzl("#007 Could not call remote method.", e);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbv) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzq, str, zzbqo, 241199000, i);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                return queryLocalInterface2 instanceof zzbu ? (zzbu) queryLocalInterface2 : new zzbs(zze2);
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
                zzm.zzf("Could not create remote AdManager.", e2);
                return null;
            }
        }
    }
}
