package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfpf extends zzfpa {
    public zzfpf(zzfot zzfot, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfot, hashSet, jSONObject, j);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        if (zzfok.zzg(this.zzb, this.zzd.zza())) {
            return null;
        }
        this.zzd.zze(this.zzb);
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute((String) obj);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzfnq zza;
        if (!TextUtils.isEmpty(str) && (zza = zzfnq.zza()) != null) {
            for (zzfnc zzfnc : zza.zzc()) {
                if (this.zza.contains(zzfnc.zzh())) {
                    zzfnc.zzg().zzh(str, this.zzc);
                }
            }
        }
        super.onPostExecute(str);
    }
}
