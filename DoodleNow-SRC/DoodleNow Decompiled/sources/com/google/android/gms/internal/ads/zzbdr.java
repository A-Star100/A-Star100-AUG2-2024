package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbdr {
    private final List zza = new ArrayList();
    private final List zzb = new ArrayList();
    private final List zzc = new ArrayList();

    public final List zza() {
        ArrayList arrayList = new ArrayList();
        for (zzbdq zza2 : this.zzb) {
            String str = (String) zzba.zzc().zza(zza2);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzbea.zza());
        return arrayList;
    }

    public final List zzb() {
        List zza2 = zza();
        for (zzbdq zza3 : this.zzc) {
            String str = (String) zzba.zzc().zza(zza3);
            if (!TextUtils.isEmpty(str)) {
                zza2.add(str);
            }
        }
        zza2.addAll(zzbea.zzb());
        return zza2;
    }

    public final void zzc(zzbdq zzbdq) {
        this.zzb.add(zzbdq);
    }

    public final void zzd(zzbdq zzbdq) {
        this.zza.add(zzbdq);
    }

    public final void zze(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzbdq zzbdq : this.zza) {
            if (zzbdq.zze() == 1) {
                zzbdq.zzd(editor, zzbdq.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzm.zzg("Flag Json is null.");
        }
    }
}
