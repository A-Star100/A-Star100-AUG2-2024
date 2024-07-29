package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.internal.ads.zzaqm;
import com.google.android.gms.internal.ads.zzaqq;
import com.google.android.gms.internal.ads.zzaqt;
import com.google.android.gms.internal.ads.zzaqz;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzarf;
import com.google.android.gms.internal.ads.zzarm;
import com.google.android.gms.internal.ads.zzarq;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbmv;
import com.google.android.gms.internal.ads.zzfsf;
import com.google.android.gms.internal.ads.zzfsg;
import com.google.android.gms.internal.ads.zzfsk;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaz extends zzarf {
    private final Context zzc;

    private zzaz(Context context, zzare zzare) {
        super(zzare);
        this.zzc = context;
    }

    public static zzaqt zzb(Context context) {
        zzaqt zzaqt = new zzaqt(new zzarm(new File(zzfsg.zza(zzfsf.zza(), context.getCacheDir(), "admob_volley", zzfsk.zza)), 20971520), new zzaz(context, new zzarq()), 4);
        zzaqt.zzd();
        return zzaqt;
    }

    public final zzaqm zza(zzaqq zzaqq) throws zzaqz {
        if (zzaqq.zza() == 0) {
            if (Pattern.matches((String) zzba.zzc().zza(zzbdz.zzeu), zzaqq.zzk())) {
                Context context = this.zzc;
                zzay.zzb();
                if (zzf.zzt(context, 13400000)) {
                    zzaqm zza = new zzbmv(this.zzc).zza(zzaqq);
                    if (zza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzaqq.zzk())));
                        return zza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzaqq.zzk())));
                }
            }
        }
        return super.zza(zzaqq);
    }
}
