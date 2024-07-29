package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzv extends zzbwv {
    final /* synthetic */ zzdzw zza;

    protected zzdzv(zzdzw zzdzw) {
        this.zza = zzdzw;
    }

    public final void zze(zzbb zzbb) {
        this.zza.zza.zzd(zzbb.zza());
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) {
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
        zzdzw zzdzw = this.zza;
        zzdzw.zza.zzc(new zzeam(autoCloseInputStream, zzdzw.zze));
    }

    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbxd zzbxd) {
        this.zza.zza.zzc(new zzeam(new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor), zzbxd));
    }
}
