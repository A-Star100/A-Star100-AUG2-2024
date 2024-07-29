package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbve;
import com.google.android.gms.internal.ads.zzflh;
import com.google.android.gms.internal.ads.zzgea;
import java.util.List;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzz implements zzgea {
    final /* synthetic */ zzbve zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzab zzc;

    zzz(zzab zzab, zzbve zzbve, boolean z) {
        this.zza = zzbve;
        this.zzb = z;
        this.zzc = zzab;
    }

    public final void zza(Throwable th) {
        try {
            zzbve zzbve = this.zza;
            String message = th.getMessage();
            zzbve.zze("Internal error: " + message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        List<Uri> list = (List) obj;
        try {
            zzab.zzH(this.zzc, list);
            this.zza.zzf(list);
            if (this.zzc.zzt || this.zzb) {
                for (Uri uri : list) {
                    if (this.zzc.zzO(uri)) {
                        zzab zzab = this.zzc;
                        this.zzc.zzr.zzc(zzab.zzZ(uri, zzab.zzB, "1").toString(), (zzflh) null);
                    } else {
                        if (((Boolean) zzba.zzc().zza(zzbdz.zzhA)).booleanValue()) {
                            this.zzc.zzr.zzc(uri.toString(), (zzflh) null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
