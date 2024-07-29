package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcrr implements zzdae {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzffn zzc;
    public final /* synthetic */ zzfgi zzd;

    public /* synthetic */ zzcrr(Context context, VersionInfoParcel versionInfoParcel, zzffn zzffn, zzfgi zzfgi) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzffn;
        this.zzd = zzfgi;
    }

    public final void zzs() {
        zzu.zzs().zzn(this.zza, this.zzb.afmaVersion, this.zzc.zzD.toString(), this.zzd.zzf);
    }
}
