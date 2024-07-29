package com.google.android.gms.internal.ads;

import android.app.Activity;
import com.google.android.gms.ads.internal.overlay.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzees extends zzefp {
    private Activity zza;
    private zzm zzb;
    private String zzc;
    private String zzd;

    zzees() {
    }

    public final zzefp zza(Activity activity) {
        if (activity != null) {
            this.zza = activity;
            return this;
        }
        throw new NullPointerException("Null activity");
    }

    public final zzefp zzb(zzm zzm) {
        this.zzb = zzm;
        return this;
    }

    public final zzefp zzc(String str) {
        this.zzc = str;
        return this;
    }

    public final zzefp zzd(String str) {
        this.zzd = str;
        return this;
    }

    public final zzefq zze() {
        Activity activity = this.zza;
        if (activity != null) {
            return new zzeeu(activity, this.zzb, this.zzc, this.zzd, (zzeet) null);
        }
        throw new IllegalStateException("Missing required properties: activity");
    }
}
