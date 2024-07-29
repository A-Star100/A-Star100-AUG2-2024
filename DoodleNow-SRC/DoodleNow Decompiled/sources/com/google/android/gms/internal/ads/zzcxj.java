package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzau;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcxj implements zzfwf {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzfgi zzc;

    public /* synthetic */ zzcxj(Context context, VersionInfoParcel versionInfoParcel, zzfgi zzfgi) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfgi;
    }

    public final Object apply(Object obj) {
        zzffn zzffn = (zzffn) obj;
        zzau zzau = new zzau(this.zza);
        zzau.zzp(zzffn.zzC);
        zzau.zzq(zzffn.zzD.toString());
        zzau.zzo(this.zzb.afmaVersion);
        zzau.zzn(this.zzc.zzf);
        return zzau;
    }
}
