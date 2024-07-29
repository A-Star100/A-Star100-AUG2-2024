package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.google.mlkit.common.MlKitException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbgo extends zzbgw {
    static final int zza = Color.rgb(204, 204, 204);
    static final int zzb;
    private static final int zzc;
    private final String zzd;
    private final List zze = new ArrayList();
    private final List zzf = new ArrayList();
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;

    static {
        int rgb = Color.rgb(12, 174, MlKitException.CODE_SCANNER_PIPELINE_INFERENCE_ERROR);
        zzc = rgb;
        zzb = rgb;
    }

    public zzbgo(String str, List list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzd = str;
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzbgr zzbgr = (zzbgr) list.get(i3);
            this.zze.add(zzbgr);
            this.zzf.add(zzbgr);
        }
        this.zzg = num != null ? num.intValue() : zza;
        this.zzh = num2 != null ? num2.intValue() : zzb;
        this.zzi = num3 != null ? num3.intValue() : 12;
        this.zzj = i;
        this.zzk = i2;
    }

    public final int zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzk;
    }

    public final int zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzh;
    }

    public final int zzf() {
        return this.zzi;
    }

    public final String zzg() {
        return this.zzd;
    }

    public final List zzh() {
        return this.zzf;
    }

    public final List zzi() {
        return this.zze;
    }
}
