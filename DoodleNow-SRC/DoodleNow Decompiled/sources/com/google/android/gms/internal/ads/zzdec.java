package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdec implements Runnable {
    public final /* synthetic */ zzded zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzdec(zzded zzded, Object obj) {
        this.zza = zzded;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th) {
            zzu.zzo().zzv(th, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th);
        }
    }
}
