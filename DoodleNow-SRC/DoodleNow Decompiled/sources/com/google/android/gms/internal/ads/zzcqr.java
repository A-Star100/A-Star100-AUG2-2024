package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcqr implements zzazy {
    private zzcgm zza;
    private final Executor zzb;
    private final zzcqd zzc;
    private final Clock zzd;
    private boolean zze = false;
    private boolean zzf = false;
    private final zzcqg zzg = new zzcqg();

    public zzcqr(Executor executor, zzcqd zzcqd, Clock clock) {
        this.zzb = executor;
        this.zzc = zzcqd;
        this.zzd = clock;
    }

    private final void zzg() {
        try {
            JSONObject zza2 = this.zzc.zzb(this.zzg);
            if (this.zza != null) {
                this.zzb.execute(new zzcqq(this, zza2));
            }
        } catch (JSONException e) {
            zze.zzb("Failed to call video active view js", e);
        }
    }

    public final void zza() {
        this.zze = false;
    }

    public final void zzb() {
        this.zze = true;
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(JSONObject jSONObject) {
        this.zza.zzl("AFMA_updateActiveView", jSONObject);
    }

    public final void zze(boolean z) {
        this.zzf = z;
    }

    public final void zzf(zzcgm zzcgm) {
        this.zza = zzcgm;
    }

    public final void zzdp(zzazx zzazx) {
        boolean z = this.zzf ? false : zzazx.zzj;
        zzcqg zzcqg = this.zzg;
        zzcqg.zza = z;
        zzcqg.zzd = this.zzd.elapsedRealtime();
        this.zzg.zzf = zzazx;
        if (this.zze) {
            zzg();
        }
    }
}
