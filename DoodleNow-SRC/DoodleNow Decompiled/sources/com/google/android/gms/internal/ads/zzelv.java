package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzelv implements zzegj {
    private final zzegl zza;
    private final zzegp zzb;
    private final zzfkn zzc;
    private final zzgep zzd;

    public zzelv(zzfkn zzfkn, zzgep zzgep, zzegl zzegl, zzegp zzegp) {
        this.zzc = zzfkn;
        this.zzd = zzgep;
        this.zzb = zzegp;
        this.zza = zzegl;
    }

    static final String zze(String str, int i) {
        return "Error from: " + str + ", code: " + i;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        zzegm zzegm;
        Iterator it = zzffn.zzu.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzegm = null;
                break;
            }
            try {
                zzegm = this.zza.zza((String) it.next(), zzffn.zzw);
                break;
            } catch (zzfgp unused) {
            }
        }
        if (zzegm == null) {
            return zzgee.zzg(new zzejl("Unable to instantiate mediation adapter class."));
        }
        zzcbw zzcbw = new zzcbw();
        zzegm.zzc.zza(new zzelu(this, zzegm, zzcbw));
        if (zzffn.zzN) {
            Bundle bundle = zzffz.zza.zza.zzd.zzm;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        zzfkn zzfkn = this.zzc;
        return zzfjx.zzd(new zzels(this, zzffz, zzffn, zzegm), this.zzd, zzfkh.ADAPTER_LOAD_AD_SYN, zzfkn).zzb(zzfkh.ADAPTER_LOAD_AD_ACK).zzd(zzcbw).zzb(zzfkh.ADAPTER_WRAP_ADAPTER).zze(new zzelt(this, zzffz, zzffn, zzegm)).zza();
    }

    public final boolean zzb(zzffz zzffz, zzffn zzffn) {
        return !zzffn.zzu.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzffz zzffz, zzffn zzffn, zzegm zzegm, Void voidR) throws Exception {
        return this.zzb.zza(zzffz, zzffn, zzegm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws Exception {
        this.zzb.zzb(zzffz, zzffn, zzegm);
    }
}
