package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzewc implements zzewr {
    private final zzcad zza;
    private final zzgep zzb;
    private final Context zzc;

    public zzewc(zzcad zzcad, zzgep zzgep, Context context) {
        this.zza = zzcad;
        this.zzb = zzgep;
        this.zzc = context;
    }

    public final int zza() {
        return 34;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzewb(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzewd zzc() throws Exception {
        String str;
        String str2;
        String str3;
        if (!this.zza.zzp(this.zzc)) {
            return new zzewd((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzd = this.zza.zzd(this.zzc);
        String str4 = zzd == null ? "" : zzd;
        String zzb2 = this.zza.zzb(this.zzc);
        if (zzb2 == null) {
            str = "";
        } else {
            str = zzb2;
        }
        String zza2 = this.zza.zza(this.zzc);
        if (zza2 == null) {
            str2 = "";
        } else {
            str2 = zza2;
        }
        Long l = null;
        String str5 = true != this.zza.zzp(this.zzc) ? null : "fa";
        if ("TIME_OUT".equals(str)) {
            l = (Long) zzba.zzc().zza(zzbdz.zzaf);
        }
        Long l2 = l;
        if (str5 == null) {
            str3 = "";
        } else {
            str3 = str5;
        }
        return new zzewd(str4, str, str2, str3, l2);
    }
}
