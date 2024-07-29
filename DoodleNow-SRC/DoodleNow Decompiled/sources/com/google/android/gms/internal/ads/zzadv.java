package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzadv {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i = zzfx.zza;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.zza = parseInt;
            this.zzb = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzby zzby) {
        for (int i = 0; i < zzby.zza(); i++) {
            zzbx zzb2 = zzby.zzb(i);
            if (zzb2 instanceof zzagw) {
                zzagw zzagw = (zzagw) zzb2;
                if ("iTunSMPB".equals(zzagw.zzb) && zzc(zzagw.zzc)) {
                    return true;
                }
            } else if (zzb2 instanceof zzahf) {
                zzahf zzahf = (zzahf) zzb2;
                if ("com.apple.iTunes".equals(zzahf.zza) && "iTunSMPB".equals(zzahf.zzb) && zzc(zzahf.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
