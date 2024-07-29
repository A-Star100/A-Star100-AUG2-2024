package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdxa {
    private final zzdwk zza;
    private final zzdrv zzb;
    private final Object zzc = new Object();
    private final List zzd;
    private boolean zze;

    zzdxa(zzdwk zzdwk, zzdrv zzdrv) {
        this.zza = zzdwk;
        this.zzb = zzdrv;
        this.zzd = new ArrayList();
    }

    /* access modifiers changed from: private */
    public final void zzd(List list) {
        String str;
        boolean z;
        synchronized (this.zzc) {
            if (!this.zze) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    zzbmw zzbmw = (zzbmw) it.next();
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzjk)).booleanValue()) {
                        zzdru zza2 = this.zzb.zza(zzbmw.zza);
                        if (zza2 != null) {
                            zzbtc zzbtc = zza2.zzc;
                            if (zzbtc != null) {
                                str = zzbtc.toString();
                            }
                        }
                        str = "";
                    } else {
                        str = "";
                    }
                    String str2 = str;
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzjl)).booleanValue()) {
                        zzdru zza3 = this.zzb.zza(zzbmw.zza);
                        if (zza3 != null) {
                            if (zza3.zzd) {
                                z = true;
                                List list2 = this.zzd;
                                String str3 = zzbmw.zza;
                                list2.add(new zzdwz(str3, str2, this.zzb.zzb(str3), zzbmw.zzb ? 1 : 0, zzbmw.zzd, zzbmw.zzc, z));
                            }
                        }
                    }
                    z = false;
                    List list22 = this.zzd;
                    String str32 = zzbmw.zza;
                    list22.add(new zzdwz(str32, str2, this.zzb.zzb(str32), zzbmw.zzb ? 1 : 0, zzbmw.zzd, zzbmw.zzc, z));
                }
                this.zze = true;
            }
        }
    }

    public final JSONArray zza() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        synchronized (this.zzc) {
            if (!this.zze) {
                if (this.zza.zzt()) {
                    zzd(this.zza.zzg());
                } else {
                    zzc();
                }
            }
            for (zzdwz zza2 : this.zzd) {
                jSONArray.put(zza2.zza());
            }
        }
        return jSONArray;
    }

    public final void zzc() {
        this.zza.zzs(new zzdwy(this));
    }
}
