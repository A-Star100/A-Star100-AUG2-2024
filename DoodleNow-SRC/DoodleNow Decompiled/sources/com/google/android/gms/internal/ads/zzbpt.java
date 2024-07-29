package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbpt implements zzbln {
    final /* synthetic */ zzbpu zza;
    private final zzbow zzb;
    private final zzcbw zzc;

    public zzbpt(zzbpu zzbpu, zzbow zzbow, zzcbw zzcbw) {
        this.zza = zzbpu;
        this.zzb = zzbow;
        this.zzc = zzcbw;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzc.zzd(new zzbpf());
            } catch (IllegalStateException unused) {
            } catch (Throwable th) {
                this.zzb.zzb();
                throw th;
            }
        } else {
            this.zzc.zzd(new zzbpf(str));
        }
        this.zzb.zzb();
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzc.zzc(this.zza.zza.zza(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzc.zzd(e);
        } catch (Throwable th) {
            this.zzb.zzb();
            throw th;
        }
        this.zzb.zzb();
    }
}
