package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbjz implements zzbky {
    public static final /* synthetic */ zzbjz zza = new zzbjz();

    private /* synthetic */ zzbjz() {
    }

    public final void zza(Object obj, Map map) {
        zzchx zzchx = (zzchx) obj;
        zzbky zzbky = zzbkx.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzawo zzI = zzchx.zzI();
            if (zzI != null) {
                zzI.zzc().zzl(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzm.zzj("Could not parse touch parameters from gmsg.");
        }
    }
}
