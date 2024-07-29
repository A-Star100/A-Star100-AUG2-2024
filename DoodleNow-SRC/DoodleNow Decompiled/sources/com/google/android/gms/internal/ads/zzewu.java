package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzewu {
    private final Context zza;
    private final Set zzb;
    private final Executor zzc;
    private final zzflh zzd;
    private final zzduh zze;
    private long zzf = 0;
    private int zzg = 0;

    public zzewu(Context context, Executor executor, Set set, zzflh zzflh, zzduh zzduh) {
        this.zza = context;
        this.zzc = executor;
        this.zzb = set;
        this.zzd = zzflh;
        this.zze = zzduh;
    }

    public final ListenableFuture zza(Object obj, Bundle bundle) {
        zzfkw zza2 = zzfkv.zza(this.zza, zzflo.CUI_NAME_ADREQUEST_SIGNALS);
        zza2.zzi();
        ArrayList arrayList = new ArrayList(this.zzb.size());
        List arrayList2 = new ArrayList();
        if (!((String) zzba.zzc().zza(zzbdz.zzlv)).isEmpty()) {
            arrayList2 = Arrays.asList(((String) zzba.zzc().zza(zzbdz.zzlv)).split(f.a));
        }
        this.zzf = zzu.zzB().elapsedRealtime();
        Bundle bundle2 = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue() && bundle != null) {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            if (obj instanceof Bundle) {
                bundle.putLong(zzdtq.CLIENT_SIGNALS_START.zza(), currentTimeMillis);
            } else {
                bundle.putLong(zzdtq.GMS_SIGNALS_START.zza(), currentTimeMillis);
            }
        }
        for (zzewr zzewr : this.zzb) {
            if (!arrayList2.contains(String.valueOf(zzewr.zza()))) {
                if (!((Boolean) zzba.zzc().zza(zzbdz.zzfY)).booleanValue() || zzewr.zza() != 44) {
                    long elapsedRealtime = zzu.zzB().elapsedRealtime();
                    ListenableFuture zzb2 = zzewr.zzb();
                    zzb2.addListener(new zzews(this, elapsedRealtime, zzewr, bundle2), zzcbr.zzf);
                    arrayList.add(zzb2);
                }
            }
        }
        ListenableFuture zza3 = zzgee.zzb(arrayList).zza(new zzewt(arrayList, obj, bundle, bundle2), this.zzc);
        if (zzflk.zza()) {
            zzflg.zzb(zza3, this.zzd, zza2);
        }
        return zza3;
    }

    public final void zzb(long j, zzewr zzewr, Bundle bundle) {
        long elapsedRealtime = zzu.zzB().elapsedRealtime() - j;
        if (((Boolean) zzbfv.zza.zze()).booleanValue()) {
            zze.zza("Signal runtime (ms) : " + zzfxg.zzc(zzewr.getClass().getCanonicalName()) + " = " + elapsedRealtime);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzcd)).booleanValue()) {
                synchronized (this) {
                    bundle.putLong("sig" + zzewr.zza(), elapsedRealtime);
                }
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzca)).booleanValue()) {
            zzdug zza2 = this.zze.zza();
            zza2.zzb("action", "lat_ms");
            zza2.zzb("lat_grp", "sig_lat_grp");
            zza2.zzb("lat_id", String.valueOf(zzewr.zza()));
            zza2.zzb("clat_ms", String.valueOf(elapsedRealtime));
            if (((Boolean) zzba.zzc().zza(zzbdz.zzcb)).booleanValue()) {
                synchronized (this) {
                    this.zzg++;
                }
                zza2.zzb("seq_num", zzu.zzo().zzh().zzd());
                synchronized (this) {
                    if (this.zzg == this.zzb.size() && this.zzf != 0) {
                        this.zzg = 0;
                        String valueOf = String.valueOf(zzu.zzB().elapsedRealtime() - this.zzf);
                        if (zzewr.zza() <= 39 || zzewr.zza() >= 52) {
                            zza2.zzb("lat_clsg", valueOf);
                        } else {
                            zza2.zzb("lat_gmssg", valueOf);
                        }
                    }
                }
            }
            zza2.zzg();
        }
    }
}
