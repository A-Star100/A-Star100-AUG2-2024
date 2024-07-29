package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbqb implements zzbln {
    final /* synthetic */ zzbqc zza;
    private final zzcbw zzb;

    public zzbqb(zzbqc zzbqc, zzcbw zzcbw) {
        this.zza = zzbqc;
        this.zzb = zzcbw;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzb.zzd(new zzbpf());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzb.zzd(new zzbpf(str));
        }
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzb.zzc(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzb.zzd(e);
        }
    }
}
