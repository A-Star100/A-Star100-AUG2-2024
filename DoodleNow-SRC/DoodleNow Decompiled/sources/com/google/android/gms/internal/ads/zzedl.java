package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzedl implements zzfjq {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzfkw zzc;
    private final zzflh zzd;

    public zzedl(String str, zzflh zzflh, zzfkw zzfkw) {
        this.zzb = str;
        this.zzd = zzflh;
        this.zzc = zzfkw;
    }

    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        zzdyi zzdyi;
        String str;
        zzedk zzedk = (zzedk) obj;
        int optInt = zzedk.zza.optInt("http_timeout_millis", 60000);
        zzbxg zza2 = zzedk.zzb;
        String str2 = "";
        if (zza2.zza() == -2) {
            HashMap hashMap = new HashMap();
            if (zzedk.zzb.zzj() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) zzba.zzc().zza(zzbdz.zzaO)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = str2;
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = str2;
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null && (group.toLowerCase(Locale.ROOT).startsWith("id=") || group.toLowerCase(Locale.ROOT).startsWith("ide="))) {
                                if (!TextUtils.isEmpty(str)) {
                                    str = str.concat("; ");
                                }
                                str = str.concat(group);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(HttpHeaders.COOKIE, str);
                    }
                } else {
                    hashMap.put(HttpHeaders.COOKIE, this.zzb);
                }
            }
            if (zzedk.zzb.zzk()) {
                zzedm.zza(hashMap, zzedk.zza);
            }
            if (zzedk.zzb != null && !TextUtils.isEmpty(zzedk.zzb.zzf())) {
                str2 = zzedk.zzb.zzf();
            }
            zzflh zzflh = this.zzd;
            zzfkw zzfkw = this.zzc;
            zzfkw.zzg(true);
            zzflh.zza(zzfkw);
            return new zzedg(zzedk.zzb.zzg(), optInt, hashMap, str2.getBytes(zzfwd.zzc), "", zzedk.zzb.zzk());
        }
        if (zza2.zza() == 1) {
            if (zza2.zzh() != null) {
                str2 = TextUtils.join(", ", zza2.zzh());
                zzm.zzg(str2);
            }
            zzdyi = new zzdyi(2, "Error building request URL: ".concat(String.valueOf(str2)));
        } else {
            zzdyi = new zzdyi(1);
        }
        zzflh zzflh2 = this.zzd;
        zzfkw zzfkw2 = this.zzc;
        zzfkw2.zzh(zzdyi);
        zzfkw2.zzg(false);
        zzflh2.zza(zzfkw2);
        throw zzdyi;
    }
}
