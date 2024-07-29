package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfpe extends zzfpa {
    public zzfpe(zzfot zzfot, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfot, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfnq zza = zzfnq.zza();
        if (zza != null) {
            for (zzfnc zzfnc : zza.zzc()) {
                if (this.zza.contains(zzfnc.zzh())) {
                    zzfnc.zzg().zzd(str, this.zzc);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* access modifiers changed from: protected */
    public final void zza(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
