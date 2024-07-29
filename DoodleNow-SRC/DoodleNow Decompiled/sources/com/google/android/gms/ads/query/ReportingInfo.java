package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbvl;
import com.google.android.gms.internal.ads.zzbvm;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class ReportingInfo {
    private final zzbvm zza;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzbvl zza;

        public Builder(View view) {
            zzbvl zzbvl = new zzbvl();
            this.zza = zzbvl;
            zzbvl.zzb(view);
        }

        public ReportingInfo build() {
            return new ReportingInfo(this, (zzb) null);
        }

        public Builder setAssetViews(Map<String, View> map) {
            this.zza.zzc(map);
            return this;
        }
    }

    /* synthetic */ ReportingInfo(Builder builder, zzb zzb) {
        this.zza = new zzbvm(builder.zza);
    }

    public void recordClick(List<Uri> list) {
        this.zza.zza(list);
    }

    public void recordImpression(List<Uri> list) {
        this.zza.zzb(list);
    }

    public void reportTouchEvent(MotionEvent motionEvent) {
        this.zza.zzc(motionEvent);
    }

    public void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zza.zzd(uri, updateClickUrlCallback);
    }

    public void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zza.zze(list, updateImpressionUrlsCallback);
    }
}
