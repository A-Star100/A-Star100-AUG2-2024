package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbpu implements zzbpg {
    /* access modifiers changed from: private */
    public final zzbpi zza;
    private final zzbpj zzb;
    private final zzbpc zzc;
    private final String zzd;

    zzbpu(zzbpc zzbpc, String str, zzbpj zzbpj, zzbpi zzbpi) {
        this.zzc = zzbpc;
        this.zzd = str;
        this.zzb = zzbpj;
        this.zza = zzbpi;
    }

    static /* bridge */ /* synthetic */ void zzd(zzbpu zzbpu, zzbow zzbow, zzbpd zzbpd, Object obj, zzcbw zzcbw) {
        try {
            zzu.zzp();
            String uuid = UUID.randomUUID().toString();
            zzbkx.zzo.zzc(uuid, new zzbpt(zzbpu, zzbow, zzcbw));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", uuid);
            jSONObject.put("args", zzbpu.zzb.zzb(obj));
            zzbpd.zzl(zzbpu.zzd, jSONObject);
        } catch (Exception e) {
            zzcbw.zzd(e);
            zzm.zzh("Unable to invokeJavascript", e);
            zzbow.zzb();
        } catch (Throwable th) {
            zzbow.zzb();
            throw th;
        }
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        zzcbw zzcbw = new zzcbw();
        zzbow zzb2 = this.zzc.zzb((zzawo) null);
        zze.zza("callJs > getEngine: Promise created");
        zzb2.zzj(new zzbpr(this, zzb2, obj, zzcbw), new zzbps(this, zzcbw, zzb2));
        return zzcbw;
    }
}
