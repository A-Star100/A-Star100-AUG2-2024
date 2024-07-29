package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.amazon.a.a.o.b;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzduc;
import com.google.android.gms.internal.ads.zzgea;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaa implements zzgea {
    final /* synthetic */ zzab zza;

    zzaa(zzab zzab) {
        this.zza = zzab;
    }

    public final void zza(Throwable th) {
        zzu.zzo().zzw(th, "SignalGeneratorImpl.initializeWebViewForSignalCollection");
        zzh.zzc(this.zza.zzq, (zzduc) null, "sgf", new Pair("sgf_reason", th.getMessage()), new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", b.ac), new Pair("sgi_rn", Integer.toString(this.zza.zzI.get())));
        zzm.zzh("Failed to initialize webview for loading SDKCore. ", th);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjC)).booleanValue() && !this.zza.zzH.get()) {
            if (this.zza.zzI.getAndIncrement() < ((Integer) zzba.zzc().zza(zzbdz.zzjD)).intValue()) {
                this.zza.zzT();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzap zzap = (zzap) obj;
        zzm.zze("Initialized webview successfully for SDKCore.");
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjC)).booleanValue()) {
            zzh.zzc(this.zza.zzq, (zzduc) null, "sgs", new Pair("se", "query_g"), new Pair("ad_format", AdFormat.BANNER.name()), new Pair("rtype", Integer.toString(6)), new Pair("scar", b.ac), new Pair("sgi_rn", Integer.toString(this.zza.zzI.get())));
            this.zza.zzH.set(true);
        }
    }
}
