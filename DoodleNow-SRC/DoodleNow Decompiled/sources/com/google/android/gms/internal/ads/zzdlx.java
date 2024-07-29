package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdlx implements zzbgs {
    final /* synthetic */ zzdmu zza;
    final /* synthetic */ ViewGroup zzb;

    zzdlx(zzdmu zzdmu, ViewGroup viewGroup) {
        this.zza = zzdmu;
        this.zzb = viewGroup;
    }

    public final JSONObject zza() {
        return this.zza.zzo();
    }

    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    public final void zzc() {
        zzfzn zzfzn = zzdlu.zza;
        Map zzm = this.zza.zzm();
        if (zzm != null) {
            int size = zzfzn.size();
            int i = 0;
            while (i < size) {
                Object obj = zzm.get((String) zzfzn.get(i));
                i++;
                if (obj != null) {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch((View) null, motionEvent);
    }
}
