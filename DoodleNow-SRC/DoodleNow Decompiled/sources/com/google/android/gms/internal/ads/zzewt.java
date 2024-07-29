package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzewt implements Callable {
    public final /* synthetic */ List zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ Bundle zzd;

    public /* synthetic */ zzewt(List list, Object obj, Bundle bundle, Bundle bundle2) {
        this.zza = list;
        this.zzb = obj;
        this.zzc = bundle;
        this.zzd = bundle2;
    }

    public final Object call() {
        Object obj;
        Bundle bundle;
        Iterator it = this.zza.iterator();
        while (true) {
            obj = this.zzb;
            if (!it.hasNext()) {
                break;
            }
            zzewq zzewq = (zzewq) ((ListenableFuture) it.next()).get();
            if (zzewq != null) {
                zzewq.zzj(obj);
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue() && (bundle = this.zzc) != null) {
            Bundle bundle2 = this.zzd;
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdtq.CLIENT_SIGNALS_END.zza(), currentTimeMillis);
                bundle.putBundle("client_sig_latency_key", bundle2);
            } else {
                bundle.putLong(zzdtq.GMS_SIGNALS_END.zza(), currentTimeMillis);
                bundle.putBundle("gms_sig_latency_key", bundle2);
            }
        }
        return obj;
    }
}
