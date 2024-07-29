package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcxu {
    private final zzfkn zza;
    private final VersionInfoParcel zzb;
    private final ApplicationInfo zzc;
    private final String zzd;
    private final List zze;
    private final PackageInfo zzf;
    private final zzhip zzg;
    private final String zzh;
    private final zzewu zzi;
    private final zzg zzj;
    private final zzfgi zzk;
    private final zzddz zzl;

    public zzcxu(zzfkn zzfkn, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, List list, PackageInfo packageInfo, zzhip zzhip, zzg zzg2, String str2, zzewu zzewu, zzfgi zzfgi, zzddz zzddz) {
        this.zza = zzfkn;
        this.zzb = versionInfoParcel;
        this.zzc = applicationInfo;
        this.zzd = str;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = zzhip;
        this.zzh = str2;
        this.zzi = zzewu;
        this.zzj = zzg2;
        this.zzk = zzfgi;
        this.zzl = zzddz;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbxd zza(ListenableFuture listenableFuture, Bundle bundle) throws Exception {
        Bundle bundle2 = (Bundle) listenableFuture.get();
        String str = (String) ((ListenableFuture) this.zzg.zzb()).get();
        boolean z = ((Boolean) zzba.zzc().zza(zzbdz.zzhk)).booleanValue() && this.zzj.zzO();
        String str2 = this.zzh;
        PackageInfo packageInfo = this.zzf;
        List list = this.zze;
        return new zzbxd(bundle2, this.zzb, this.zzc, this.zzd, list, packageInfo, str, str2, (zzfid) null, (String) null, z, this.zzk.zzb(), bundle);
    }

    public final ListenableFuture zzb(Bundle bundle) {
        this.zzl.zza();
        return zzfjx.zzc(this.zzi.zza(new Bundle(), bundle), zzfkh.SIGNALS, this.zza).zza();
    }

    public final ListenableFuture zzc() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue() && (bundle = this.zzk.zzr) != null) {
            bundle2.putAll(bundle);
        }
        ListenableFuture zzb2 = zzb(bundle2);
        return this.zza.zza(zzfkh.REQUEST_PARCEL, zzb2, (ListenableFuture) this.zzg.zzb()).zza(new zzcxt(this, zzb2, bundle2)).zza();
    }
}
