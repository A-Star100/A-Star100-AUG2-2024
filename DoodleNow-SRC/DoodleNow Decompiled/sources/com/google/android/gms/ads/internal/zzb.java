package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbzo;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzb {
    private final Context zza;
    private boolean zzb;
    private final zzbzo zzc;
    private final zzbwg zzd = new zzbwg(false, Collections.emptyList());

    public zzb(Context context, zzbzo zzbzo, zzbwg zzbwg) {
        this.zza = context;
        this.zzc = zzbzo;
    }

    private final boolean zzd() {
        zzbzo zzbzo = this.zzc;
        return (zzbzo != null && zzbzo.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbzo zzbzo = this.zzc;
            if (zzbzo != null) {
                zzbzo.zzd(str, (Map) null, 3);
                return;
            }
            zzbwg zzbwg = this.zzd;
            if (zzbwg.zza && (list = zzbwg.zzb) != null) {
                for (String str2 : list) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        Context context = this.zza;
                        zzu.zzp();
                        zzt.zzL(context, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
