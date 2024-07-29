package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbpy implements zzgdl {
    public final /* synthetic */ String zza;
    public final /* synthetic */ zzbky zzb;

    public /* synthetic */ zzbpy(String str, zzbky zzbky) {
        this.zza = str;
        this.zzb = zzbky;
    }

    public final ListenableFuture zza(Object obj) {
        zzbpd zzbpd = (zzbpd) obj;
        zzbpd.zzq(this.zza, this.zzb);
        return zzgee.zzh(zzbpd);
    }
}
