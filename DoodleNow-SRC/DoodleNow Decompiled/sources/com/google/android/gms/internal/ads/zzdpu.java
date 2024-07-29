package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdpu implements Callable {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final zzcgz zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public final zzduh zzd;
    /* access modifiers changed from: private */
    public final zzefd zze;
    /* access modifiers changed from: private */
    public final Executor zzf;
    /* access modifiers changed from: private */
    public final zzawo zzg;
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzh;
    /* access modifiers changed from: private */
    public final zzfmt zzi;
    /* access modifiers changed from: private */
    public final zzefo zzj;
    /* access modifiers changed from: private */
    public final zzfgm zzk;

    public zzdpu(Context context, Executor executor, zzawo zzawo, VersionInfoParcel versionInfoParcel, zza zza2, zzcgz zzcgz, zzefd zzefd, zzfmt zzfmt, zzduh zzduh, zzefo zzefo, zzfgm zzfgm) {
        this.zzc = context;
        this.zzf = executor;
        this.zzg = zzawo;
        this.zzh = versionInfoParcel;
        this.zza = zza2;
        this.zzb = zzcgz;
        this.zze = zzefd;
        this.zzi = zzfmt;
        this.zzd = zzduh;
        this.zzj = zzefo;
        this.zzk = zzfgm;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdpx zzdpx = new zzdpx(this);
        zzdpx.zzk();
        return zzdpx;
    }
}
