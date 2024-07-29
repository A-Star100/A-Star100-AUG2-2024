package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcqc {
    private final String zza;
    private final zzbpz zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzcqh zzd;
    private final zzbky zze = new zzcpz(this);
    private final zzbky zzf = new zzcqb(this);

    public zzcqc(String str, zzbpz zzbpz, Executor executor) {
        this.zza = str;
        this.zzb = zzbpz;
        this.zzc = executor;
    }

    static /* bridge */ /* synthetic */ boolean zzg(zzcqc zzcqc, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        return !TextUtils.isEmpty(str) && str.equals(zzcqc.zza);
    }

    public final void zzc(zzcqh zzcqh) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcqh;
    }

    public final void zzd(zzcgm zzcgm) {
        zzcgm.zzae("/updateActiveView", this.zze);
        zzcgm.zzae("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcgm zzcgm) {
        zzcgm.zzaw("/updateActiveView", this.zze);
        zzcgm.zzaw("/untrackActiveViewUnit", this.zzf);
    }
}
