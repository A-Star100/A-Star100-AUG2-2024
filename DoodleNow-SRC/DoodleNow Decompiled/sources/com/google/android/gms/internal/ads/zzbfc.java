package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.MotionEvent;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbfc {
    private MotionEvent zza = MotionEvent.obtain(0, 0, 1, 0.0f, 0.0f, 0);
    private MotionEvent zzb = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
    private final Context zzc;
    private final ScheduledExecutorService zzd;
    private final zzflh zze;
    private final zzbfe zzf;

    public zzbfc(Context context, ScheduledExecutorService scheduledExecutorService, zzbfe zzbfe, zzflh zzflh) {
        this.zzc = context;
        this.zzd = scheduledExecutorService;
        this.zzf = zzbfe;
        this.zze = zzflh;
    }

    public final ListenableFuture zza() {
        return (zzgdv) zzgee.zzo(zzgdv.zzu(zzgee.zzh((Object) null)), ((Long) zzbfs.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd);
    }

    public final void zzb(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 && motionEvent.getEventTime() > this.zza.getEventTime()) {
            this.zza = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 0 && motionEvent.getEventTime() > this.zzb.getEventTime()) {
            this.zzb = MotionEvent.obtain(motionEvent);
        }
    }
}
