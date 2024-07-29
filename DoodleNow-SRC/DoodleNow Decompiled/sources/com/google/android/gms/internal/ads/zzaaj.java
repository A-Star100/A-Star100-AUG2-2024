package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaaj {
    /* access modifiers changed from: private */
    public final Context zza;
    private zzdm zzb;
    /* access modifiers changed from: private */
    public zzcp zzc;
    private boolean zzd;

    public zzaaj(Context context) {
        this.zza = context.getApplicationContext();
    }

    public final zzaaq zzc() {
        zzek.zzf(!this.zzd);
        if (this.zzc == null) {
            if (this.zzb == null) {
                this.zzb = new zzaam((zzaal) null);
            }
            this.zzc = new zzaan(this.zzb);
        }
        zzaaq zzaaq = new zzaaq(this, (zzaap) null);
        this.zzd = true;
        return zzaaq;
    }
}
