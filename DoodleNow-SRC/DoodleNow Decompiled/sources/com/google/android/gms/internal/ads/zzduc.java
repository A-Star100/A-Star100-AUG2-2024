package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzh;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzduc {
    private final ConcurrentHashMap zza;
    private final zzcbl zzb;
    private final zzfgi zzc;
    private final String zzd;
    private final String zze;
    private final zzj zzf;
    private final Bundle zzg = new Bundle();
    private final Context zzh;

    public zzduc(Context context, zzdum zzdum, zzcbl zzcbl, zzfgi zzfgi, String str, String str2, zzj zzj) {
        ActivityManager.MemoryInfo zzc2;
        ConcurrentHashMap zzc3 = zzdum.zzc();
        this.zza = zzc3;
        this.zzb = zzcbl;
        this.zzc = zzfgi;
        this.zzd = str;
        this.zze = str2;
        this.zzf = zzj;
        this.zzh = context;
        zzc3.put("ad_format", str2.toUpperCase(Locale.ROOT));
        String str3 = "1";
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjt)).booleanValue()) {
            int zzj2 = zzj.zzj();
            int i = zzj2 - 1;
            if (zzj2 != 0) {
                zzc3.put("asv", i != 0 ? i != 1 ? "na" : ExifInterface.GPS_MEASUREMENT_2D : str3);
            } else {
                throw null;
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue()) {
            Runtime runtime = Runtime.getRuntime();
            zzc("rt_f", String.valueOf(runtime.freeMemory()));
            zzc("rt_m", String.valueOf(runtime.maxMemory()));
            zzc("rt_t", String.valueOf(runtime.totalMemory()));
            zzc("wv_c", String.valueOf(zzu.zzo().zzb()));
            if (((Boolean) zzba.zzc().zza(zzbdz.zzce)).booleanValue() && (zzc2 = zzf.zzc(context)) != null) {
                zzc("mem_avl", String.valueOf(zzc2.availMem));
                zzc("mem_tt", String.valueOf(zzc2.totalMem));
                zzc("low_m", true != zzc2.lowMemory ? SessionDescription.SUPPORTED_SDP_VERSION : str3);
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhd)).booleanValue()) {
            int zze2 = zzh.zze(zzfgi) - 1;
            if (zze2 != 0) {
                if (zze2 == 1) {
                    zzc3.put(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, str);
                    zzc3.put("se", "query_g");
                } else if (zze2 == 2) {
                    zzc3.put("se", "r_adinfo");
                } else if (zze2 != 3) {
                    zzc3.put("se", "r_both");
                } else {
                    zzc3.put("se", "r_adstring");
                }
                zzc3.put("scar", b.ac);
                zzc("ragent", zzfgi.zzd.zzp);
                zzc("rtype", zzh.zza(zzh.zzb(zzfgi.zzd)));
                return;
            }
            zzc3.put(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, str);
            zzc3.put("scar", "false");
        }
    }

    public final Bundle zza() {
        return this.zzg;
    }

    public final Map zzb() {
        return this.zza;
    }

    public final void zzc(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zza.put(str, str2);
        }
    }

    public final void zzd(zzffz zzffz) {
        if (!zzffz.zzb.zza.isEmpty()) {
            zzffn zzffn = (zzffn) zzffz.zzb.zza.get(0);
            zzc("ad_format", zzffn.zza(zzffn.zzb));
            if (zzffn.zzb == 6) {
                this.zza.put("as", true != this.zzb.zzm() ? SessionDescription.SUPPORTED_SDP_VERSION : "1");
            }
        }
        zzc("gqi", zzffz.zzb.zzb.zzb);
    }

    public final void zze(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("cnt")) {
                zzc("network_coarse", Integer.toString(bundle.getInt("cnt")));
            }
            if (bundle.containsKey("gnt")) {
                zzc("network_fine", Integer.toString(bundle.getInt("gnt")));
            }
        }
    }
}
