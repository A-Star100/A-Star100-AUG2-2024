package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbqc implements zzgdl {
    private final zzbpi zza;
    private final zzbpj zzb;
    private final String zzc = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzd;

    zzbqc(ListenableFuture listenableFuture, String str, zzbpj zzbpj, zzbpi zzbpi) {
        this.zzd = listenableFuture;
        this.zzb = zzbpj;
        this.zza = zzbpi;
    }

    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(Object obj) {
        return zzgee.zzn(this.zzd, new zzbqa(this, obj), zzcbr.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Object obj, zzbpd zzbpd) throws Exception {
        zzcbw zzcbw = new zzcbw();
        zzu.zzp();
        String uuid = UUID.randomUUID().toString();
        zzbkx.zzo.zzc(uuid, new zzbqb(this, zzcbw));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", uuid);
        jSONObject.put("args", (JSONObject) obj);
        zzbpd.zzl(this.zzc, jSONObject);
        return zzcbw;
    }
}
