package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfts extends zzftp {
    private static zzfts zzc;

    private zzfts(Context context) {
        super(context, "paidv2_id", "paidv2_creation_time", "PaidV2LifecycleImpl");
    }

    public static final zzfts zzi(Context context) {
        zzfts zzfts;
        synchronized (zzfts.class) {
            if (zzc == null) {
                zzc = new zzfts(context);
            }
            zzfts = zzc;
        }
        return zzfts;
    }

    public final zzfto zzh(long j, boolean z) throws IOException {
        synchronized (zzfts.class) {
            if (!zzo()) {
                zzfto zzfto = new zzfto();
                return zzfto;
            }
            zzfto zzb = zzb((String) null, (String) null, j, z);
            return zzb;
        }
    }

    public final void zzj() throws IOException {
        synchronized (zzfts.class) {
            if (zzg(false)) {
                zzf(false);
            }
        }
    }

    public final void zzk() throws IOException {
        this.zzb.zze("paidv2_publisher_option");
    }

    public final void zzl() throws IOException {
        this.zzb.zze("paidv2_user_option");
    }

    public final void zzm(boolean z) throws IOException {
        this.zzb.zzd("paidv2_user_option", Boolean.valueOf(z));
    }

    public final void zzn(boolean z) throws IOException {
        this.zzb.zzd("paidv2_publisher_option", Boolean.valueOf(z));
        if (!z) {
            zzj();
        }
    }

    public final boolean zzo() {
        return this.zzb.zzf("paidv2_publisher_option", true);
    }

    public final boolean zzp() {
        return this.zzb.zzf("paidv2_user_option", true);
    }
}
