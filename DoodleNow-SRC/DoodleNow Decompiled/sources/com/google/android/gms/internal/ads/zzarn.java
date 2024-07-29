package com.google.android.gms.internal.ads;

import com.amazon.a.a.o.b.f;
import com.google.common.net.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzarn {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e) {
            if (SessionDescription.SUPPORTED_SDP_VERSION.equals(str) || "-1".equals(str)) {
                zzarc.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0;
            }
            zzarc.zzc(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    public static zzapz zzb(zzaqm zzaqm) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        zzaqm zzaqm2 = zzaqm;
        long currentTimeMillis = System.currentTimeMillis();
        Map map = zzaqm2.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get("Date");
        long zza = str != null ? zza(str) : 0;
        String str2 = (String) map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(f.a, 0);
            z = false;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = (String) map.get("Expires");
        long zza2 = str3 != null ? zza(str3) : 0;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        long zza3 = str4 != null ? zza(str4) : 0;
        String str5 = (String) map.get(HttpHeaders.ETAG);
        if (i != 0) {
            j4 = currentTimeMillis + (j * 1000);
            if (z) {
                j5 = j4;
            } else {
                Long.signum(j2);
                j5 = (j2 * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (zza <= 0 || zza2 < zza) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (zza2 - zza);
                j3 = j4;
            }
        }
        zzapz zzapz = new zzapz();
        zzapz.zza = zzaqm2.zzb;
        zzapz.zzb = str5;
        zzapz.zzf = j4;
        zzapz.zze = j3;
        zzapz.zzc = zza;
        zzapz.zzd = zza3;
        zzapz.zzg = map;
        zzapz.zzh = zzaqm2.zzd;
        return zzapz;
    }

    static String zzc(long j) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
