package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.util.zze;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzezk implements zzewq {
    private final List zza;

    public zzezk(List list) {
        this.zza = list;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            ((JSONObject) obj).put("eid", TextUtils.join(f.a, this.zza));
        } catch (JSONException unused) {
            zze.zza("Failed putting experiment ids.");
        }
    }
}
