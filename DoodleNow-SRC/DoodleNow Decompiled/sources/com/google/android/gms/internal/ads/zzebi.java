package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzebi implements zzgdl {
    public static final /* synthetic */ zzebi zza = new zzebi();

    private /* synthetic */ zzebi() {
    }

    public final ListenableFuture zza(Object obj) {
        InputStream inputStream = (InputStream) obj;
        JSONObject jSONObject = new JSONObject();
        if (inputStream == null) {
            return zzgee.zzh(jSONObject);
        }
        try {
            zzu.zzp();
            jSONObject = new JSONObject(zzt.zzN(new InputStreamReader(inputStream)));
        } catch (IOException | JSONException e) {
            zzu.zzo().zzw(e, "AdsServiceSignalTask.startAdsServiceSignalTask");
        }
        return zzgee.zzh(jSONObject);
    }
}
