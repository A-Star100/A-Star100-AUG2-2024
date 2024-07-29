package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfnq {
    private static final zzfnq zza = new zzfnq();
    private final ArrayList zzb = new ArrayList();
    private final ArrayList zzc = new ArrayList();

    private zzfnq() {
    }

    public static zzfnq zza() {
        return zza;
    }

    public final Collection zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfnc zzfnc) {
        this.zzb.add(zzfnc);
    }

    public final void zze(zzfnc zzfnc) {
        ArrayList arrayList = this.zzb;
        boolean zzg = zzg();
        arrayList.remove(zzfnc);
        this.zzc.remove(zzfnc);
        if (zzg && !zzg()) {
            zzfny.zzb().zzg();
        }
    }

    public final void zzf(zzfnc zzfnc) {
        ArrayList arrayList = this.zzc;
        boolean zzg = zzg();
        arrayList.add(zzfnc);
        if (!zzg) {
            zzfny.zzb().zzf();
        }
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
