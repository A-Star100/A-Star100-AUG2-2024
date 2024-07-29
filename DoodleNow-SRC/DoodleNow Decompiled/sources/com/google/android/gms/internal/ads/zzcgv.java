package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.TrafficStats;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcgv implements zzfxh {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzcie zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ zzawo zzf;
    public final /* synthetic */ zzbfc zzg;
    public final /* synthetic */ VersionInfoParcel zzh;
    public final /* synthetic */ zzm zzi;
    public final /* synthetic */ zza zzj;
    public final /* synthetic */ zzbcx zzk;
    public final /* synthetic */ zzffn zzl;
    public final /* synthetic */ zzffq zzm;
    public final /* synthetic */ zzfgm zzn;
    public final /* synthetic */ zzefo zzo;

    public /* synthetic */ zzcgv(Context context, zzcie zzcie, String str, boolean z, boolean z2, zzawo zzawo, zzbfc zzbfc, VersionInfoParcel versionInfoParcel, zzbeo zzbeo, zzm zzm2, zza zza2, zzbcx zzbcx, zzffn zzffn, zzffq zzffq, zzfgm zzfgm, zzefo zzefo) {
        this.zza = context;
        this.zzb = zzcie;
        this.zzc = str;
        this.zzd = z;
        this.zze = z2;
        this.zzf = zzawo;
        this.zzg = zzbfc;
        this.zzh = versionInfoParcel;
        this.zzi = zzm2;
        this.zzj = zza2;
        this.zzk = zzbcx;
        this.zzl = zzffn;
        this.zzm = zzffq;
        this.zzn = zzfgm;
        this.zzo = zzefo;
    }

    public final Object zza() {
        zzcie zzcie = this.zzb;
        String str = this.zzc;
        boolean z = this.zzd;
        zzbcx zzbcx = this.zzk;
        boolean z2 = this.zze;
        zzawo zzawo = this.zzf;
        zzffn zzffn = this.zzl;
        zzbfc zzbfc = this.zzg;
        zzm zzm2 = this.zzi;
        zzffq zzffq = this.zzm;
        Context context = this.zza;
        VersionInfoParcel versionInfoParcel = this.zzh;
        zza zza2 = this.zzj;
        zzfgm zzfgm = this.zzn;
        zzefo zzefo = this.zzo;
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = zzchj.zza;
            zzchj zzchj = r2;
            zzefo zzefo2 = zzefo;
            zzffq zzffq2 = zzffq;
            zza zza3 = zza2;
            zzffn zzffn2 = zzffn;
            zzchj zzchj2 = new zzchj(new zzcid(context), zzcie, str, z, z2, zzawo, zzbfc, versionInfoParcel, (zzbeo) null, zzm2, zza3, zzbcx, zzffn2, zzffq2, zzfgm);
            zzchc zzchc = new zzchc(zzchj2);
            zzchc.setWebViewClient(zzu.zzq().zzc(zzchc, zzbcx, z2, zzefo2));
            zzchc.setWebChromeClient(new zzcgl(zzchc));
            return zzchc;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }
}
