package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzcrt {
    private final zzctt zza;
    private final View zzb;
    private final zzffo zzc;
    private final zzcgm zzd;

    public zzcrt(View view, zzcgm zzcgm, zzctt zzctt, zzffo zzffo) {
        this.zzb = view;
        this.zzd = zzcgm;
        this.zza = zzctt;
        this.zzc = zzffo;
    }

    public static final zzdgf zzf(Context context, VersionInfoParcel versionInfoParcel, zzffn zzffn, zzfgi zzfgi) {
        return new zzdgf(new zzcrr(context, versionInfoParcel, zzffn, zzfgi), zzcbr.zzf);
    }

    public static final Set zzg(zzctk zzctk) {
        return Collections.singleton(new zzdgf(zzctk, zzcbr.zzf));
    }

    public static final zzdgf zzh(zzcti zzcti) {
        return new zzdgf(zzcti, zzcbr.zze);
    }

    public final View zza() {
        return this.zzb;
    }

    public final zzcgm zzb() {
        return this.zzd;
    }

    public final zzctt zzc() {
        return this.zza;
    }

    public zzdac zzd(Set set) {
        return new zzdac(set);
    }

    public final zzffo zze() {
        return this.zzc;
    }
}
