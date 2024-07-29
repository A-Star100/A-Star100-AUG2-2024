package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzftr extends zzftp {
    private static zzftr zzc;

    private zzftr(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzftr zzj(Context context) {
        zzftr zzftr;
        synchronized (zzftr.class) {
            if (zzc == null) {
                zzc = new zzftr(context);
            }
            zzftr = zzc;
        }
        return zzftr;
    }

    public final zzfto zzh(long j, boolean z) throws IOException {
        zzfto zzb;
        synchronized (zzftr.class) {
            zzb = zzb((String) null, (String) null, j, z);
        }
        return zzb;
    }

    public final zzfto zzi(String str, String str2, long j, boolean z) throws IOException {
        zzfto zzb;
        synchronized (zzftr.class) {
            zzb = zzb(str, str2, j, z);
        }
        return zzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzftr.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzftr.class) {
            zzf(true);
        }
    }
}
