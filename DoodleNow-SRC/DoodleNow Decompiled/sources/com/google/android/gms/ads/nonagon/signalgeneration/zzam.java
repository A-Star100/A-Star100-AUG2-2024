package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.internal.ads.zzbxd;
import com.google.android.gms.internal.ads.zzeam;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.android.gms.internal.ads.zzgee;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzam implements zzgdl {
    public final /* synthetic */ zzbxd zza;

    public /* synthetic */ zzam(zzbxd zzbxd) {
        this.zza = zzbxd;
    }

    public final ListenableFuture zza(Object obj) {
        zzeam zzeam = (zzeam) obj;
        zzap zzap = new zzap(new JsonReader(new InputStreamReader(zzeam.zzb())), zzeam.zza());
        try {
            zzap.zzb = zzay.zzb().zzi(this.zza.zza).toString();
        } catch (JSONException unused) {
            zzap.zzb = "{}";
        }
        return zzgee.zzh(zzap);
    }
}
