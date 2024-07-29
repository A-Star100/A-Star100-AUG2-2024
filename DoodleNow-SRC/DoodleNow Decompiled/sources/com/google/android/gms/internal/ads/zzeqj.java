package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeqj implements zzewr {
    private final zzgep zza;
    private final zzfgi zzb;
    private final VersionInfoParcel zzc;
    private final zzcbl zzd;

    public zzeqj(zzgep zzgep, zzfgi zzfgi, VersionInfoParcel versionInfoParcel, zzcbl zzcbl) {
        this.zza = zzgep;
        this.zzb = zzfgi;
        this.zzc = versionInfoParcel;
        this.zzd = zzcbl;
    }

    public final int zza() {
        return 9;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeqi(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeqk zzc() throws Exception {
        return new zzeqk(this.zzb.zzj, this.zzc, this.zzd.zzm());
    }
}
