package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbez extends QueryInfoGenerationCallback {
    final /* synthetic */ String zza;
    final /* synthetic */ zzbfa zzb;

    zzbez(zzbfa zzbfa, String str) {
        this.zza = str;
        this.zzb = zzbfa;
    }

    public final void onFailure(String str) {
        zzm.zzj("Failed to generate query info for Custom Tab error: ".concat(String.valueOf(str)));
        try {
            zzbfa zzbfa = this.zzb;
            zzbfa.zzd.postMessage(zzbfa.zzc(this.zza, str).toString(), (Bundle) null);
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Error Response JSON: ", e);
        }
    }

    public final void onSuccess(QueryInfo queryInfo) {
        String query = queryInfo.getQuery();
        try {
            zzbfa zzbfa = this.zzb;
            zzbfa.zzd.postMessage(zzbfa.zzd(this.zza, query).toString(), (Bundle) null);
        } catch (JSONException e) {
            zzm.zzh("Error creating PACT Signal Response JSON: ", e);
        }
    }
}
