package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdvt implements zzdvh {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzeoi zzb;

    zzdvt(long j, Context context, zzdvm zzdvm, zzcik zzcik, String str) {
        this.zza = j;
        zzfds zzv = zzcik.zzv();
        zzv.zzc(context);
        zzv.zza(new zzq());
        zzv.zzb(str);
        zzeoi zza2 = zzv.zzd().zza();
        this.zzb = zza2;
        zza2.zzD(new zzdvs(this, zzdvm));
    }

    public final void zza() {
        this.zzb.zzx();
    }

    public final void zzb(zzl zzl) {
        this.zzb.zzaa(zzl);
    }

    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
