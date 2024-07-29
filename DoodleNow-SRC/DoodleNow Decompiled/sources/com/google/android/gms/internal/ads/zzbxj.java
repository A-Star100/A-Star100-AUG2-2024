package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbxj implements Callable {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbxl zzb;

    zzbxj(zzbxl zzbxl, Context context) {
        this.zza = context;
        this.zzb = zzbxl;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbxi zzbxi;
        zzbxk zzbxk = (zzbxk) this.zzb.zza.get(this.zza);
        if (zzbxk != null) {
            if (zzbxk.zza + ((Long) zzbfj.zza.zze()).longValue() >= zzu.zzB().currentTimeMillis()) {
                zzbxi = new zzbxh(this.zza, zzbxk.zzb).zza();
                zzbxl zzbxl = this.zzb;
                zzbxl.zza.put(this.zza, new zzbxk(zzbxl, zzbxi));
                return zzbxi;
            }
        }
        zzbxi = new zzbxh(this.zza).zza();
        zzbxl zzbxl2 = this.zzb;
        zzbxl2.zza.put(this.zza, new zzbxk(zzbxl2, zzbxi));
        return zzbxi;
    }
}
