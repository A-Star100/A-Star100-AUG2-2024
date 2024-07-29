package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcyj extends zzdm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzego zzh;
    private final Bundle zzi;

    public zzcyj(zzffn zzffn, String str, zzego zzego, zzffq zzffq, String str2) {
        String str3;
        String str4 = null;
        if (zzffn == null) {
            str3 = null;
        } else {
            str3 = zzffn.zzac;
        }
        this.zzb = str3;
        this.zzc = str2;
        this.zzd = zzffq == null ? null : zzffq.zzb;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                str4 = zzffn.zzw.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = str4 != null ? str4 : str;
        this.zze = zzego.zzc();
        this.zzh = zzego;
        this.zzf = zzu.zzB().currentTimeMillis() / 1000;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzgT)).booleanValue() || zzffq == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzffq.zzj;
        }
        this.zzg = (!((Boolean) zzba.zzc().zza(zzbdz.zzjf)).booleanValue() || zzffq == null || TextUtils.isEmpty(zzffq.zzh)) ? "" : zzffq.zzh;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final Bundle zze() {
        return this.zzi;
    }

    public final com.google.android.gms.ads.internal.client.zzu zzf() {
        zzego zzego = this.zzh;
        if (zzego != null) {
            return zzego.zza();
        }
        return null;
    }

    public final String zzg() {
        return this.zza;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        return this.zzb;
    }

    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
