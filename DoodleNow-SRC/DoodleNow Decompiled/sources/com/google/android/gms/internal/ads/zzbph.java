package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbph {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbpq zzc;
    private zzbpq zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzbpq zza(Context context, VersionInfoParcel versionInfoParcel, zzflk zzflk) {
        zzbpq zzbpq;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbpq(zzc(context), versionInfoParcel, (String) zzba.zzc().zza(zzbdz.zza), zzflk);
            }
            zzbpq = this.zzc;
        }
        return zzbpq;
    }

    public final zzbpq zzb(Context context, VersionInfoParcel versionInfoParcel, zzflk zzflk) {
        zzbpq zzbpq;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbpq(zzc(context), versionInfoParcel, (String) zzbgc.zzb.zze(), zzflk);
            }
            zzbpq = this.zzd;
        }
        return zzbpq;
    }
}
