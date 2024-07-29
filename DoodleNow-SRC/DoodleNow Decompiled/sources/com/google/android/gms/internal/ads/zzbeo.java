package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Deprecated
@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbeo {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbeo(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put("ad_format", str2);
    }

    public static final zzbel zzf() {
        return new zzbel(zzu.zzB().elapsedRealtime(), (String) null, (zzbel) null);
    }

    public final zzben zza() {
        zzben zzben;
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbdz.zzbQ)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap hashMap = new HashMap();
        synchronized (this.zzc) {
            for (zzbel zzbel : this.zza) {
                long zza2 = zzbel.zza();
                String zzc2 = zzbel.zzc();
                zzbel zzb2 = zzbel.zzb();
                if (zzb2 != null && zza2 > 0) {
                    sb.append(zzc2);
                    sb.append('.');
                    sb.append(zza2 - zzb2.zza());
                    sb.append(AbstractJsonLexerKt.COMMA);
                    if (booleanValue) {
                        if (!hashMap.containsKey(Long.valueOf(zzb2.zza()))) {
                            hashMap.put(Long.valueOf(zzb2.zza()), new StringBuilder(zzc2));
                        } else {
                            StringBuilder sb2 = (StringBuilder) hashMap.get(Long.valueOf(zzb2.zza()));
                            sb2.append('+');
                            sb2.append(zzc2);
                        }
                    }
                }
            }
            this.zza.clear();
            String str = null;
            if (!TextUtils.isEmpty((CharSequence) null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (booleanValue) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append('.');
                    sb3.append(zzu.zzB().currentTimeMillis() + (((Long) entry.getKey()).longValue() - zzu.zzB().elapsedRealtime()));
                    sb3.append(AbstractJsonLexerKt.COMMA);
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                str = sb3.toString();
            }
            zzben = new zzben(sb.toString(), str);
        }
        return zzben;
    }

    public final Map zzb() {
        Map map;
        synchronized (this.zzc) {
            zzu.zzo().zzg();
            map = this.zzb;
        }
        return map;
    }

    public final void zzc(zzbeo zzbeo) {
        synchronized (this.zzc) {
        }
    }

    public final void zzd(String str, String str2) {
        zzbee zzg;
        if (!TextUtils.isEmpty(str2) && (zzg = zzu.zzo().zzg()) != null) {
            synchronized (this.zzc) {
                zzbek zza2 = zzg.zza(str);
                Map map = this.zzb;
                map.put(str, zza2.zza((String) map.get(str), str2));
            }
        }
    }

    public final boolean zze(zzbel zzbel, long j, String... strArr) {
        synchronized (this.zzc) {
            for (int i = 0; i <= 0; i++) {
                this.zza.add(new zzbel(j, strArr[i], zzbel));
            }
        }
        return true;
    }
}
