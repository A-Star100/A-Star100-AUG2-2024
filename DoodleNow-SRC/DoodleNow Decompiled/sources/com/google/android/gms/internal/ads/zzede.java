package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzede extends zzbwp {
    private final Context zza;
    private final zzeyf zzb;
    private final zzeyd zzc;
    private final zzedm zzd;
    private final zzgep zze;
    private final zzedj zzf;
    private final zzbxm zzg;

    zzede(Context context, zzeyf zzeyf, zzeyd zzeyd, zzedj zzedj, zzedm zzedm, zzgep zzgep, zzbxm zzbxm) {
        this.zza = context;
        this.zzb = zzeyf;
        this.zzc = zzeyd;
        this.zzf = zzedj;
        this.zzd = zzedm;
        this.zze = zzgep;
        this.zzg = zzbxm;
    }

    private final void zzc(ListenableFuture listenableFuture, zzbwt zzbwt) {
        zzgee.zzr(zzgee.zzn(zzgdv.zzu(listenableFuture), new zzedb(this), zzcbr.zza), new zzedd(this, zzbwt), zzcbr.zzf);
    }

    public final ListenableFuture zzb(zzbwi zzbwi, int i) {
        ListenableFuture listenableFuture;
        HashMap hashMap = new HashMap();
        Bundle bundle = zzbwi.zzc;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                String string = bundle.getString(str);
                if (string != null) {
                    hashMap.put(str, string);
                }
            }
        }
        zzedg zzedg = new zzedg(zzbwi.zza, zzbwi.zzb, hashMap, zzbwi.zzd, "", zzbwi.zze);
        zzeyd zzeyd = this.zzc;
        zzeyd.zza(new zzezl(zzbwi));
        boolean z = zzedg.zzf;
        zzeye zzb2 = zzeyd.zzb();
        if (z) {
            String str2 = zzbwi.zza;
            String str3 = (String) zzbfz.zzb.zze();
            if (!TextUtils.isEmpty(str3)) {
                String host = Uri.parse(str2).getHost();
                if (!TextUtils.isEmpty(host)) {
                    Iterator it = zzfxe.zzc(zzfwc.zzc(';')).zzd(str3).iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (host.endsWith((String) it.next())) {
                                listenableFuture = zzgee.zzm(zzb2.zza().zza(new JSONObject(), new Bundle()), new zzecw(zzedg), this.zze);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        listenableFuture = zzgee.zzh(zzedg);
        zzfkn zzb3 = zzb2.zzb();
        return zzgee.zzn(zzb3.zzb(zzfkh.HTTP, listenableFuture).zze(new zzedi(this.zza, "", this.zzg, i)).zza(), zzecx.zza, this.zze);
    }

    public final void zze(zzbwi zzbwi, zzbwt zzbwt) {
        zzc(zzb(zzbwi, Binder.getCallingUid()), zzbwt);
    }

    public final void zzf(zzbwe zzbwe, zzbwt zzbwt) {
        zzexu zzexu = new zzexu(zzbwe, Binder.getCallingUid());
        zzeyf zzeyf = this.zzb;
        zzeyf.zza(zzexu);
        zzeyg zzb2 = zzeyf.zzb();
        zzfkn zzb3 = zzb2.zzb();
        zzfjs zza2 = zzb3.zzb(zzfkh.GMS_SIGNALS, zzgee.zzi()).zzf(new zzeda(zzb2)).zze(zzecz.zza).zzf(zzecy.zza).zza();
        zzc(zza2, zzbwt);
        if (((Boolean) zzbft.zzf.zze()).booleanValue()) {
            zzedm zzedm = this.zzd;
            Objects.requireNonNull(zzedm);
            zza2.addListener(new zzedc(zzedm), this.zze);
        }
    }
}
