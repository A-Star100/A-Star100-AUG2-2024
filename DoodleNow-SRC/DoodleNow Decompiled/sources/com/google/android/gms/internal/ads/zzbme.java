package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbme {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    private zzbma zzc;

    public zzbme(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(true, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzbdz.zza(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzjL)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzba.zzc().zza(zzbdz.zzjN)).intValue()) {
            zzm.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzay.zza().zzl(this.zza, new zzbqk(), this.zzb);
        }
    }

    public final void zza() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjL)).booleanValue()) {
            zzd();
            zzbma zzbma = this.zzc;
            if (zzbma != null) {
                try {
                    zzbma.zze();
                } catch (RemoteException e) {
                    zzm.zzl("#007 Could not call remote method.", e);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbma zzbma = this.zzc;
        if (zzbma == null) {
            return false;
        }
        try {
            zzbma.zzf(str);
            return true;
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
            return true;
        }
    }
}
