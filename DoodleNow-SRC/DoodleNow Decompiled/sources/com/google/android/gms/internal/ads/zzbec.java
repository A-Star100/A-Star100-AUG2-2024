package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbec {
    private final String zza = ((String) zzbfn.zzb.zze());
    private final Map zzb;
    private final Context zzc;
    private final String zzd;

    public zzbec(Context context, String str) {
        String str2;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        zzu.zzp();
        linkedHashMap.put("device", zzt.zzr());
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        linkedHashMap.put("app", str2);
        zzu.zzp();
        boolean zzE = zzt.zzE(context);
        String str3 = SessionDescription.SUPPORTED_SDP_VERSION;
        linkedHashMap.put("is_lite_sdk", true != zzE ? str3 : "1");
        Future zzb2 = zzu.zzm().zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(((zzbxi) zzb2.get()).zzk));
            linkedHashMap.put("network_fine", Integer.toString(((zzbxi) zzb2.get()).zzl));
        } catch (Exception e) {
            zzu.zzo().zzw(e, "CsiConfiguration.CsiConfiguration");
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkY)).booleanValue()) {
            Map map = this.zzb;
            zzu.zzp();
            map.put("is_bstar", true == zzt.zzB(context) ? "1" : str3);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjo)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzcf)).booleanValue() && !zzfxg.zzd(zzu.zzo().zzn())) {
                this.zzb.put("plugin", zzu.zzo().zzn());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Context zza() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final String zzc() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Map zzd() {
        return this.zzb;
    }
}
