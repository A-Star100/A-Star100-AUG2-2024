package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcoq implements zzcoa {
    private final Context zza;
    private final zzg zzb = zzu.zzo().zzi();

    public zzcoq(Context context) {
        this.zza = context;
    }

    public final void zza(Map map) {
        String str;
        if (!map.isEmpty() && (str = (String) map.get("gad_idless")) != null) {
            zzg zzg = this.zzb;
            boolean parseBoolean = Boolean.parseBoolean(str);
            zzg.zzF(parseBoolean);
            if (parseBoolean) {
                Context context = this.zza;
                if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue()) {
                    context.deleteDatabase("OfflineUpload.db");
                }
                try {
                    zzftr zzj = zzftr.zzj(context);
                    zzfts zzi = zzfts.zzi(context);
                    zzj.zzk();
                    zzj.zzl();
                    zzi.zzj();
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzcS)).booleanValue()) {
                        zzi.zzk();
                    }
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzcT)).booleanValue()) {
                        zzi.zzl();
                    }
                } catch (IOException e) {
                    zzu.zzo().zzw(e, "clearStorageOnIdlessMode");
                }
            }
        }
    }
}
