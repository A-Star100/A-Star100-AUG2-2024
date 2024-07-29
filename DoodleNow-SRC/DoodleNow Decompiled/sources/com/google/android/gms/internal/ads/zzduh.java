package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzduh {
    /* access modifiers changed from: private */
    public final zzdum zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map zzc;

    public zzduh(zzdum zzdum, Executor executor) {
        this.zza = zzdum;
        this.zzc = zzdum.zza();
        this.zzb = executor;
    }

    public final zzdug zza() {
        zzdug zzdug = new zzdug(this);
        zzdug unused = zzdug.zzb.putAll(zzdug.zza.zzc);
        return zzdug;
    }

    public final void zze() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzlp)).booleanValue()) {
            zzdug zza2 = zza();
            zza2.zzb("action", "pecr");
            zza2.zzf();
        }
    }
}
