package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzbb;
import com.google.android.gms.ads.internal.util.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzecq implements zzgea {
    final /* synthetic */ zzbww zza;
    final /* synthetic */ zzbxd zzb;

    zzecq(zzecu zzecu, zzbww zzbww, zzbxd zzbxd) {
        this.zza = zzbww;
        this.zzb = zzbxd;
    }

    public final void zza(Throwable th) {
        try {
            this.zza.zze(zzbb.zzb(th));
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue()) {
                this.zza.zzg(parcelFileDescriptor, this.zzb);
            } else {
                this.zza.zzf(parcelFileDescriptor);
            }
        } catch (RemoteException e) {
            zze.zzb("Service can't call client", e);
        }
    }
}
