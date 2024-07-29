package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzexe implements zzgdl {
    public static final /* synthetic */ zzexe zza = new zzexe();

    private /* synthetic */ zzexe() {
    }

    public final ListenableFuture zza(Object obj) {
        zzhdv zzc = zzhdw.zzc();
        for (Topic next : ((GetTopicsResponse) obj).getTopics()) {
            zzhdt zzc2 = zzhdu.zzc();
            zzc2.zzc(next.getTopicId());
            zzc2.zza(next.getModelVersion());
            zzc2.zzb(next.getTaxonomyVersion());
            zzc.zza((zzhdu) zzc2.zzbr());
        }
        return zzgee.zzh(new zzexi(Base64.encodeToString(((zzhdw) zzc.zzbr()).zzaV(), 1), 1, (zzexh) null));
    }
}
