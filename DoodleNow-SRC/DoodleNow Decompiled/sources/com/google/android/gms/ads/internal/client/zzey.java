package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbnd;
import com.google.android.gms.internal.ads.zzbqo;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzey extends zzcn {
    private zzbnd zza;

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb() {
        zzbnd zzbnd = this.zza;
        if (zzbnd != null) {
            try {
                zzbnd.zzb(Collections.emptyList());
            } catch (RemoteException e) {
                zzm.zzk("Could not notify onComplete event.", e);
            }
        }
    }

    public final float zze() throws RemoteException {
        return 1.0f;
    }

    public final String zzf() {
        return "";
    }

    public final List zzg() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzh(String str) throws RemoteException {
    }

    public final void zzi() {
    }

    public final void zzj(boolean z) throws RemoteException {
    }

    public final void zzk() throws RemoteException {
        zzm.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzf.zza.post(new zzex(this));
    }

    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzm(zzda zzda) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzo(zzbqo zzbqo) throws RemoteException {
    }

    public final void zzp(boolean z) throws RemoteException {
    }

    public final void zzq(float f) throws RemoteException {
    }

    public final void zzr(String str) throws RemoteException {
    }

    public final void zzs(zzbnd zzbnd) throws RemoteException {
        this.zza = zzbnd;
    }

    public final void zzt(String str) {
    }

    public final void zzu(zzff zzff) throws RemoteException {
    }

    public final boolean zzv() throws RemoteException {
        return false;
    }
}
