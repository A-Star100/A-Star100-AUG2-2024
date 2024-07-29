package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzduc;
import com.google.android.gms.internal.ads.zzdum;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzc {
    /* access modifiers changed from: private */
    public final int zza;
    private final long zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final Map zze;
    /* access modifiers changed from: private */
    public final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();
    private final zzdum zzh;
    private Map zzi;

    public zzc(zzdum zzdum) {
        this.zzh = zzdum;
        this.zza = ((Integer) zzba.zzc().zza(zzbdz.zzhb)).intValue();
        this.zzb = ((Long) zzba.zzc().zza(zzbdz.zzhc)).longValue();
        this.zzc = ((Boolean) zzba.zzc().zza(zzbdz.zzhh)).booleanValue();
        this.zzd = ((Boolean) zzba.zzc().zza(zzbdz.zzhf)).booleanValue();
        this.zze = Collections.synchronizedMap(new zzb(this));
    }

    private final synchronized void zzg(zzduc zzduc) {
        if (this.zzc) {
            ArrayDeque arrayDeque = this.zzg;
            ArrayDeque clone = arrayDeque.clone();
            arrayDeque.clear();
            ArrayDeque arrayDeque2 = this.zzf;
            ArrayDeque clone2 = arrayDeque2.clone();
            arrayDeque2.clear();
            zzcbr.zza.execute(new zza(this, zzduc, clone, clone2));
        }
    }

    private final void zzh(zzduc zzduc, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzduc.zzb());
            this.zzi = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.zzi.put("e_r", str);
            this.zzi.put("e_id", (String) pair2.first);
            if (this.zzd) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzh.zza(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                zzj(this.zzi, "e_type", (String) pair.first);
                zzj(this.zzi, "e_agent", (String) pair.second);
            }
            this.zzh.zzf(this.zzi);
        }
    }

    private final synchronized void zzi() {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        try {
            Iterator it = this.zze.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (currentTimeMillis - ((Long) ((Pair) entry.getValue()).first).longValue() <= this.zzb) {
                    break;
                }
                this.zzg.add(new Pair((String) entry.getKey(), (String) ((Pair) entry.getValue()).second));
                it.remove();
            }
        } catch (ConcurrentModificationException e) {
            zzu.zzo().zzw(e, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private static final void zzj(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    public final synchronized String zzb(String str, zzduc zzduc) {
        Pair pair = (Pair) this.zze.get(str);
        zzduc.zzb().put(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, str);
        if (pair != null) {
            String str2 = (String) pair.second;
            this.zze.remove(str);
            zzduc.zzb().put("mhit", b.ac);
            return str2;
        }
        zzduc.zzb().put("mhit", "false");
        return null;
    }

    public final synchronized void zzd(String str, String str2, zzduc zzduc) {
        this.zze.put(str, new Pair(Long.valueOf(zzu.zzB().currentTimeMillis()), str2));
        zzi();
        zzg(zzduc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzduc zzduc, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        zzh(zzduc, arrayDeque, "to");
        zzh(zzduc, arrayDeque2, "of");
    }

    public final synchronized void zzf(String str) {
        this.zze.remove(str);
    }
}
