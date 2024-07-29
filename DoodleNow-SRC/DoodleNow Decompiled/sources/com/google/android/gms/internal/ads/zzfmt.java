package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.zzr;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfmt {
    private final Context zza;
    private final Executor zzb;
    private final zzr zzc;
    private final zzflk zzd;

    zzfmt(Context context, Executor executor, zzr zzr, zzflk zzflk) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzr;
        this.zzd = zzflk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        this.zzc.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(String str, zzflh zzflh) {
        zzfkw zza2 = zzfkv.zza(this.zza, zzflo.CUI_NAME_PING);
        zza2.zzi();
        zza2.zzg(this.zzc.zza(str));
        if (zzflh == null) {
            this.zzd.zzb(zza2.zzm());
            return;
        }
        zzflh.zza(zza2);
        zzflh.zzh();
    }

    public final void zzc(String str, zzflh zzflh) {
        if (!zzflk.zza() || !((Boolean) zzbfm.zzd.zze()).booleanValue()) {
            this.zzb.execute(new zzfmr(this, str));
        } else {
            this.zzb.execute(new zzfms(this, str, zzflh));
        }
    }

    public final void zzd(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzc((String) it.next(), (zzflh) null);
        }
    }
}
