package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzduk implements zzfko {
    private final Map zza = new HashMap();
    private final zzduc zzb;
    private final Clock zzc;
    private final Map zzd = new HashMap();

    public zzduk(zzduc zzduc, Set set, Clock clock) {
        this.zzb = zzduc;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzduj zzduj = (zzduj) it.next();
            this.zzd.put(zzduj.zzc, zzduj);
        }
        this.zzc = clock;
    }

    private final void zze(zzfkh zzfkh, boolean z) {
        zzfkh zzb2 = ((zzduj) this.zzd.get(zzfkh)).zzb;
        if (this.zza.containsKey(zzb2)) {
            String str = true != z ? "f." : "s.";
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzb2)).longValue();
            this.zzb.zzb().put("label.".concat(((zzduj) this.zzd.get(zzfkh)).zza), str.concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
    }

    public final void zzd(zzfkh zzfkh, String str) {
        if (this.zza.containsKey(zzfkh)) {
            long elapsedRealtime = this.zzc.elapsedRealtime() - ((Long) this.zza.get(zzfkh)).longValue();
            zzduc zzduc = this.zzb;
            String valueOf = String.valueOf(str);
            zzduc.zzb().put("task.".concat(valueOf), "s.".concat(String.valueOf(Long.toString(elapsedRealtime))));
        }
        if (this.zzd.containsKey(zzfkh)) {
            zze(zzfkh, true);
        }
    }

    public final void zzdC(zzfkh zzfkh, String str) {
    }

    public final void zzdD(zzfkh zzfkh, String str, Throwable th) {
        if (this.zza.containsKey(zzfkh)) {
            Clock clock = this.zzc;
            Map map = this.zza;
            zzduc zzduc = this.zzb;
            String valueOf = String.valueOf(str);
            zzduc.zzb().put("task.".concat(valueOf), "f.".concat(String.valueOf(Long.toString(clock.elapsedRealtime() - ((Long) map.get(zzfkh)).longValue()))));
        }
        if (this.zzd.containsKey(zzfkh)) {
            zze(zzfkh, false);
        }
    }

    public final void zzdE(zzfkh zzfkh, String str) {
        this.zza.put(zzfkh, Long.valueOf(this.zzc.elapsedRealtime()));
    }
}
