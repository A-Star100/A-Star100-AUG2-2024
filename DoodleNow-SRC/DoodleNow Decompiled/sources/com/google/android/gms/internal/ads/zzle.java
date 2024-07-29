package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzle {
    /* access modifiers changed from: private */
    public long zza;
    /* access modifiers changed from: private */
    public float zzb;
    /* access modifiers changed from: private */
    public long zzc;

    public zzle() {
        this.zza = C.TIME_UNSET;
        this.zzb = -3.4028235E38f;
        this.zzc = C.TIME_UNSET;
    }

    /* synthetic */ zzle(zzlg zzlg, zzld zzld) {
        this.zza = zzlg.zza;
        this.zzb = zzlg.zzb;
        this.zzc = zzlg.zzc;
    }

    public final zzle zzd(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == C.TIME_UNSET) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzek.zzd(z);
        this.zzc = j;
        return this;
    }

    public final zzle zze(long j) {
        this.zza = j;
        return this;
    }

    public final zzle zzf(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzek.zzd(z);
        this.zzb = f;
        return this;
    }

    public final zzlg zzg() {
        return new zzlg(this, (zzlf) null);
    }
}
