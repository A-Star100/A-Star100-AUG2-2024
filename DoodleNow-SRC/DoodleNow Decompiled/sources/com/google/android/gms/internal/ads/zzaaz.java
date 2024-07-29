package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaaz extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaax zzd;
    private boolean zze;

    /* synthetic */ zzaaz(zzaax zzaax, SurfaceTexture surfaceTexture, boolean z, zzaay zzaay) {
        super(surfaceTexture);
        this.zzd = zzaax;
        this.zza = z;
    }

    public static zzaaz zza(Context context, boolean z) {
        int i = 0;
        boolean z2 = true;
        if (z && !zzb(context)) {
            z2 = false;
        }
        zzek.zzf(z2);
        zzaax zzaax = new zzaax();
        if (z) {
            i = zzb;
        }
        return zzaax.zza(i);
    }

    public static synchronized boolean zzb(Context context) {
        int i;
        synchronized (zzaaz.class) {
            if (!zzc) {
                zzb = zzet.zzb(context) ? zzet.zzc() ? 1 : 2 : 0;
                zzc = true;
            }
            i = zzb;
        }
        return i != 0;
    }

    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
