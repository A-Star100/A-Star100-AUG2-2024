package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaxj implements zzfrs {
    private final zzfpr zza;
    private final zzfqi zzb;
    private final zzaxw zzc;
    private final zzaxi zzd;
    private final zzaws zze;
    private final zzaxy zzf;
    private final zzaxq zzg;
    private final zzaxh zzh;

    zzaxj(zzfpr zzfpr, zzfqi zzfqi, zzaxw zzaxw, zzaxi zzaxi, zzaws zzaws, zzaxy zzaxy, zzaxq zzaxq, zzaxh zzaxh) {
        this.zza = zzfpr;
        this.zzb = zzfqi;
        this.zzc = zzaxw;
        this.zzd = zzaxi;
        this.zze = zzaws;
        this.zzf = zzaxy;
        this.zzg = zzaxq;
        this.zzh = zzaxh;
    }

    private final Map zze() {
        HashMap hashMap = new HashMap();
        zzfpr zzfpr = this.zza;
        zzaud zzb2 = this.zzb.zzb();
        hashMap.put("v", zzfpr.zzb());
        hashMap.put("gms", Boolean.valueOf(this.zza.zzc()));
        hashMap.put("int", zzb2.zzi());
        hashMap.put("up", Boolean.valueOf(this.zzd.zza()));
        hashMap.put("t", new Throwable());
        zzaxq zzaxq = this.zzg;
        if (zzaxq != null) {
            hashMap.put("tcq", Long.valueOf(zzaxq.zzc()));
            hashMap.put("tpq", Long.valueOf(this.zzg.zzg()));
            hashMap.put("tcv", Long.valueOf(this.zzg.zzd()));
            hashMap.put("tpv", Long.valueOf(this.zzg.zzh()));
            hashMap.put("tchv", Long.valueOf(this.zzg.zzb()));
            hashMap.put("tphv", Long.valueOf(this.zzg.zzf()));
            hashMap.put("tcc", Long.valueOf(this.zzg.zza()));
            hashMap.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return hashMap;
    }

    public final Map zza() {
        zzaxw zzaxw = this.zzc;
        Map zze2 = zze();
        zze2.put("lts", Long.valueOf(zzaxw.zza()));
        return zze2;
    }

    public final Map zzb() {
        zzfpr zzfpr = this.zza;
        zzfqi zzfqi = this.zzb;
        Map zze2 = zze();
        zzaud zza2 = zzfqi.zza();
        zze2.put("gai", Boolean.valueOf(zzfpr.zzd()));
        zze2.put("did", zza2.zzh());
        zze2.put("dst", Integer.valueOf(zza2.zzc().zza()));
        zze2.put("doo", Boolean.valueOf(zza2.zzaq()));
        zzaws zzaws = this.zze;
        if (zzaws != null) {
            zze2.put("nt", Long.valueOf(zzaws.zza()));
        }
        zzaxy zzaxy = this.zzf;
        if (zzaxy != null) {
            zze2.put("vs", Long.valueOf(zzaxy.zzc()));
            zze2.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return zze2;
    }

    public final Map zzc() {
        zzaxh zzaxh = this.zzh;
        Map zze2 = zze();
        if (zzaxh != null) {
            zze2.put("vst", zzaxh.zza());
        }
        return zze2;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
