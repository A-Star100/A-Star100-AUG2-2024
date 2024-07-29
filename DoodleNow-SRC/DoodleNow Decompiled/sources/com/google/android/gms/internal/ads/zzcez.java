package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcez implements zzbky {
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zzm.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcey zzcey;
        Map map2 = map;
        zzcdn zzcdn = (zzcdn) obj;
        if (zze.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map2);
            jSONObject.remove("google.afma.Notify_dt");
            zzm.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcer zzy = zzu.zzy();
        if (!map2.containsKey("abort")) {
            String str = (String) map2.get("src");
            Integer zzb = zzb(map2, "periodicReportIntervalMs");
            Integer zzb2 = zzb(map2, "exoPlayerRenderingIntervalMs");
            Integer zzb3 = zzb(map2, "exoPlayerIdleIntervalMs");
            zzcdm zzcdm = new zzcdm((String) map2.get("flags"));
            boolean z = zzcdm.zzl;
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map2.get("demuxed");
                zzceq zzceq = null;
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        zzm.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (z) {
                    Iterator it = zzy.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        zzceq zzceq2 = (zzceq) it.next();
                        if (zzceq2.zza == zzcdn && str.equals(zzceq2.zze())) {
                            zzceq = zzceq2;
                            break;
                        }
                    }
                } else {
                    zzceq = zzy.zza(zzcdn);
                }
                if (zzceq != null) {
                    zzm.zzj("Precache task is already running.");
                    return;
                } else if (zzcdn.zzj() == null) {
                    zzm.zzj("Precache requires a dependency provider.");
                    return;
                } else {
                    Integer zzb4 = zzb(map2, "player");
                    if (zzb4 == null) {
                        zzb4 = 0;
                    }
                    if (zzb != null) {
                        zzcdn.zzA(zzb.intValue());
                    }
                    if (zzb2 != null) {
                        zzcdn.zzy(zzb2.intValue());
                    }
                    if (zzb3 != null) {
                        zzcdn.zzx(zzb3.intValue());
                    }
                    int intValue = zzb4.intValue();
                    zzcek zzcek = zzcdn.zzj().zzb;
                    if (intValue > 0) {
                        int i2 = zzcdm.zzh;
                        int zzu = zzcde.zzu();
                        if (zzu < i2) {
                            zzcey = new zzcfh(zzcdn, zzcdm);
                        } else if (zzu < zzcdm.zzb) {
                            zzcey = new zzcfe(zzcdn, zzcdm);
                        } else {
                            zzcey = new zzcfc(zzcdn);
                        }
                    } else {
                        zzcey = new zzcfb(zzcdn);
                    }
                    new zzceq(zzcdn, zzcey, str, strArr).zzb();
                }
            } else {
                zzceq zza = zzy.zza(zzcdn);
                if (zza != null) {
                    zzcey = zza.zzb;
                } else {
                    zzm.zzj("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb5 = zzb(map2, "minBufferMs");
            if (zzb5 != null) {
                zzcey.zzs(zzb5.intValue());
            }
            Integer zzb6 = zzb(map2, "maxBufferMs");
            if (zzb6 != null) {
                zzcey.zzr(zzb6.intValue());
            }
            Integer zzb7 = zzb(map2, "bufferForPlaybackMs");
            if (zzb7 != null) {
                zzcey.zzp(zzb7.intValue());
            }
            Integer zzb8 = zzb(map2, "bufferForPlaybackAfterRebufferMs");
            if (zzb8 != null) {
                zzcey.zzq(zzb8.intValue());
            }
        } else if (!zzy.zzd(zzcdn)) {
            zzm.zzj("Precache abort but no precache task running.");
        }
    }
}
