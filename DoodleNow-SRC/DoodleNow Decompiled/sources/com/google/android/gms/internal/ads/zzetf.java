package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzetf implements Callable {
    public final /* synthetic */ zzetg zza;

    public /* synthetic */ zzetf(zzetg zzetg) {
        this.zza = zzetg;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzu.zzp();
        zzbax zzf = zzu.zzo().zzi().zzf();
        Bundle bundle = null;
        if (zzf != null && (!zzu.zzo().zzi().zzL() || !zzu.zzo().zzi().zzM())) {
            if (zzf.zzh()) {
                zzf.zzg();
            }
            zzban zza2 = zzf.zza();
            if (zza2 != null) {
                str2 = zza2.zzd();
                str = zza2.zze();
                str3 = zza2.zzf();
                if (str2 != null) {
                    zzu.zzo().zzi().zzv(str2);
                }
                if (str3 != null) {
                    zzu.zzo().zzi().zzx(str3);
                }
            } else {
                str2 = zzu.zzo().zzi().zzi();
                str3 = zzu.zzo().zzi().zzj();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzu.zzo().zzi().zzM()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    bundle2.putString("v_fp_vertical", "no_hash");
                } else {
                    bundle2.putString("v_fp_vertical", str3);
                }
            }
            if (str2 != null && !zzu.zzo().zzi().zzL()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzeth(bundle);
    }
}
