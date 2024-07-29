package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzlv implements zzlm {
    public final zzvc zza;
    public final Object zzb = new Object();
    public final List zzc = new ArrayList();
    public int zzd;
    public boolean zze;

    public zzlv(zzvj zzvj, boolean z) {
        this.zza = new zzvc(zzvj, z);
    }

    public final zzcx zza() {
        return this.zza.zzC();
    }

    public final Object zzb() {
        return this.zzb;
    }

    public final void zzc(int i) {
        this.zzd = i;
        this.zze = false;
        this.zzc.clear();
    }
}
