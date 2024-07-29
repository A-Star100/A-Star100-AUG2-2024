package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdri {
    private final zzcgz zza;
    private final Context zzb;
    private final zzawo zzc;
    private final zzbfc zzd;
    private final VersionInfoParcel zze;
    private final zza zzf;
    private final zzbcx zzg;
    /* access modifiers changed from: private */
    public final zzdbf zzh;
    private final zzefo zzi;
    private final zzfgm zzj;

    public zzdri(zzcgz zzcgz, Context context, zzawo zzawo, zzbfc zzbfc, VersionInfoParcel versionInfoParcel, zza zza2, zzbcx zzbcx, zzdbf zzdbf, zzefo zzefo, zzfgm zzfgm) {
        this.zza = zzcgz;
        this.zzb = context;
        this.zzc = zzawo;
        this.zzd = zzbfc;
        this.zze = versionInfoParcel;
        this.zzf = zza2;
        this.zzg = zzbcx;
        this.zzh = zzdbf;
        this.zzi = zzefo;
        this.zzj = zzfgm;
    }

    public final zzcgm zza(zzq zzq, zzffn zzffn, zzffq zzffq) throws zzcgy {
        zzcie zzc2 = zzcie.zzc(zzq);
        String str = zzq.zza;
        zzdqx zzdqx = new zzdqx(this);
        zzefo zzefo = this.zzi;
        zzfgm zzfgm = this.zzj;
        zza zza2 = this.zzf;
        zzbcx zzbcx = this.zzg;
        return zzcgz.zza(this.zzb, zzc2, str, false, false, this.zzc, this.zzd, this.zze, (zzbeo) null, zzdqx, zza2, zzbcx, zzffn, zzffq, zzefo, zzfgm);
    }
}
