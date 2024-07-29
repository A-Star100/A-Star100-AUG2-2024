package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcdh {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzba.zzc().zza(zzbdz.zzD)).longValue());
    private long zzb;
    private boolean zzc = true;

    zzcdh() {
    }

    public final void zza(SurfaceTexture surfaceTexture, zzccs zzccs) {
        if (zzccs != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (!this.zzc) {
                if (Math.abs(timestamp - this.zzb) < this.zza) {
                    return;
                }
            }
            this.zzc = false;
            this.zzb = timestamp;
            zzftg zzftg = zzt.zza;
            Objects.requireNonNull(zzccs);
            zzftg.post(new zzcdg(zzccs));
        }
    }

    public final void zzb() {
        this.zzc = true;
    }
}
