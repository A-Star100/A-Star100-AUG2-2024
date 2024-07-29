package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcgx implements zzgdk {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzawo zzb;
    public final /* synthetic */ VersionInfoParcel zzc;
    public final /* synthetic */ zza zzd;
    public final /* synthetic */ zzefo zze;
    public final /* synthetic */ zzfgm zzf;
    public final /* synthetic */ String zzg;

    public /* synthetic */ zzcgx(Context context, zzawo zzawo, VersionInfoParcel versionInfoParcel, zza zza2, zzefo zzefo, zzfgm zzfgm, String str) {
        this.zza = context;
        this.zzb = zzawo;
        this.zzc = versionInfoParcel;
        this.zzd = zza2;
        this.zze = zzefo;
        this.zzf = zzfgm;
        this.zzg = str;
    }

    public final ListenableFuture zza() {
        zzu.zzz();
        Context context = this.zza;
        zzcie zza2 = zzcie.zza();
        zzawo zzawo = this.zzb;
        zzefo zzefo = this.zze;
        zza zza3 = this.zzd;
        zzcgm zza4 = zzcgz.zza(context, zza2, "", false, false, zzawo, (zzbfc) null, this.zzc, (zzbeo) null, (zzm) null, zza3, zzbcx.zza(), (zzffn) null, (zzffq) null, zzefo, this.zzf);
        zzcbv zza5 = zzcbv.zza(zza4);
        zza4.zzN().zzB(new zzcgw(zza5));
        zza4.loadUrl(this.zzg);
        return zza5;
    }
}
