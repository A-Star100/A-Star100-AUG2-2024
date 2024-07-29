package com.google.android.gms.ads.nonagon.util.logging.csi;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzfxg;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class CsiParamDefaults {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public CsiParamDefaults(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = versionInfoParcel.afmaVersion;
    }

    public void set(Map<String, String> map) {
        map.put("s", "gmob_sdk");
        map.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzu.zzp();
        map.put("device", zzt.zzr());
        map.put("app", this.zzb);
        zzu.zzp();
        boolean zzE = zzt.zzE(this.zza);
        String str = SessionDescription.SUPPORTED_SDP_VERSION;
        map.put("is_lite_sdk", true != zzE ? str : "1");
        zzbdq zzbdq = zzbdz.zza;
        List zzb2 = zzba.zza().zzb();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgX)).booleanValue()) {
            zzb2.addAll(zzu.zzo().zzi().zzg().zzd());
        }
        map.put("e", TextUtils.join(f.a, zzb2));
        map.put(b.I, this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkY)).booleanValue()) {
            zzu.zzp();
            if (true == zzt.zzB(this.zza)) {
                str = "1";
            }
            map.put("is_bstar", str);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjo)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzcf)).booleanValue()) {
                map.put("plugin", zzfxg.zzc(zzu.zzo().zzn()));
            }
        }
    }
}
