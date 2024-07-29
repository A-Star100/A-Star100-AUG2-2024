package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzego {
    private final List zza = Collections.synchronizedList(new ArrayList());
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final String zzc;
    private zzffq zzd = null;
    private zzffn zze = null;
    private zzu zzf = null;

    public zzego(String str) {
        this.zzc = str;
    }

    private static String zzj(zzffn zzffn) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdv)).booleanValue()) {
            return zzffn.zzaq;
        }
        return zzffn.zzx;
    }

    private final synchronized void zzk(zzffn zzffn, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        Map map = this.zzb;
        String zzj = zzj(zzffn);
        if (!map.containsKey(zzj)) {
            Bundle bundle = new Bundle();
            Iterator<String> keys = zzffn.zzw.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    bundle.putString(next, zzffn.zzw.getString(next));
                } catch (JSONException unused) {
                }
            }
            if (((Boolean) zzba.zzc().zza(zzbdz.zzgR)).booleanValue()) {
                str4 = zzffn.zzG;
                str3 = zzffn.zzH;
                str2 = zzffn.zzI;
                str = zzffn.zzJ;
            } else {
                str4 = "";
                str3 = "";
                str2 = "";
                str = "";
            }
            zzu zzu = new zzu(zzffn.zzF, 0, (zze) null, bundle, str4, str3, str2, str);
            try {
                this.zza.add(i, zzu);
            } catch (IndexOutOfBoundsException e) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e, "AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation");
            }
            this.zzb.put(zzj, zzu);
        }
    }

    private final void zzl(zzffn zzffn, long j, zze zze2, boolean z) {
        Map map = this.zzb;
        String zzj = zzj(zzffn);
        if (map.containsKey(zzj)) {
            if (this.zze == null) {
                this.zze = zzffn;
            }
            zzu zzu = (zzu) this.zzb.get(zzj);
            zzu.zzb = j;
            zzu.zzc = zze2;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzgS)).booleanValue() && z) {
                this.zzf = zzu;
            }
        }
    }

    public final zzu zza() {
        return this.zzf;
    }

    public final zzcyj zzb() {
        return new zzcyj(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzffn zzffn) {
        zzk(zzffn, this.zza.size());
    }

    public final void zze(zzffn zzffn) {
        int indexOf = this.zza.indexOf(this.zzb.get(zzj(zzffn)));
        if (indexOf < 0 || indexOf >= this.zzb.size()) {
            indexOf = this.zza.indexOf(this.zzf);
        }
        if (indexOf >= 0 && indexOf < this.zzb.size()) {
            this.zzf = (zzu) this.zza.get(indexOf);
            while (true) {
                indexOf++;
                if (indexOf < this.zza.size()) {
                    zzu zzu = (zzu) this.zza.get(indexOf);
                    zzu.zzb = 0;
                    zzu.zzc = null;
                } else {
                    return;
                }
            }
        }
    }

    public final void zzf(zzffn zzffn, long j, zze zze2) {
        zzl(zzffn, j, zze2, false);
    }

    public final void zzg(zzffn zzffn, long j, zze zze2) {
        zzl(zzffn, j, (zze) null, true);
    }

    public final synchronized void zzh(String str, List list) {
        if (this.zzb.containsKey(str)) {
            int indexOf = this.zza.indexOf((zzu) this.zzb.get(str));
            try {
                this.zza.remove(indexOf);
            } catch (IndexOutOfBoundsException e) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e, "AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry");
            }
            this.zzb.remove(str);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzk((zzffn) it.next(), indexOf);
                indexOf++;
            }
        }
    }

    public final void zzi(zzffq zzffq) {
        this.zzd = zzffq;
    }
}
