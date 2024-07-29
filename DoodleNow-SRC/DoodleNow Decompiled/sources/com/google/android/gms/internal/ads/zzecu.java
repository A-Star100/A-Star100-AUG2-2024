package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzecu extends zzbwl {
    private final Context zza;
    private final zzgep zzb;
    private final zzedm zzc;
    private final zzcnx zzd;
    private final ArrayDeque zze;
    private final zzflk zzf;
    private final zzbxm zzg;
    private final zzedj zzh;

    public zzecu(Context context, zzgep zzgep, zzbxm zzbxm, zzcnx zzcnx, zzedm zzedm, ArrayDeque arrayDeque, zzedj zzedj, zzflk zzflk) {
        zzbdz.zza(context);
        this.zza = context;
        this.zzb = zzgep;
        this.zzg = zzbxm;
        this.zzc = zzedm;
        this.zzd = zzcnx;
        this.zze = arrayDeque;
        this.zzh = zzedj;
        this.zzf = zzflk;
    }

    private final synchronized zzecr zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzecr zzecr = (zzecr) it.next();
            if (zzecr.zzc.equals(str)) {
                it.remove();
                return zzecr;
            }
        }
        return null;
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, zzfkn zzfkn, zzbpq zzbpq, zzflh zzflh, zzfkw zzfkw) {
        zzbpg zza2 = zzbpq.zza("AFMA_getAdDictionary", zzbpn.zza, zzecm.zza);
        zzflg.zze(listenableFuture, zzfkw);
        zzfjs zza3 = zzfkn.zzb(zzfkh.BUILD_URL, listenableFuture).zzf(zza2).zza();
        zzflg.zzd(zza3, zzflh, zzfkw);
        return zza3;
    }

    private static ListenableFuture zzm(zzbxd zzbxd, zzfkn zzfkn, zzexp zzexp) {
        zzecg zzecg = new zzecg(zzexp, zzbxd);
        return zzfkn.zzb(zzfkh.GMS_SIGNALS, zzgee.zzh(zzbxd.zza)).zzf(zzecg).zze(zzech.zza).zza();
    }

    private final synchronized void zzn(zzecr zzecr) {
        zzo();
        this.zze.addLast(zzecr);
    }

    private final synchronized void zzo() {
        int intValue = ((Long) zzbfz.zzc.zze()).intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(ListenableFuture listenableFuture, zzbww zzbww, zzbxd zzbxd) {
        zzgee.zzr(zzgee.zzn(listenableFuture, new zzecn(this), zzcbr.zza), new zzecq(this, zzbww, zzbxd), zzcbr.zzf);
    }

    public final ListenableFuture zzb(zzbxd zzbxd, int i) {
        if (!((Boolean) zzbfz.zza.zze()).booleanValue()) {
            return zzgee.zzg(new Exception("Split request is disabled."));
        }
        zzfid zzfid = zzbxd.zzi;
        if (zzfid == null) {
            return zzgee.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfid.zzc == 0 || zzfid.zzd == 0) {
            return zzgee.zzg(new Exception("Caching is disabled."));
        }
        zzbpq zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzexp zzr = this.zzd.zzr(zzbxd, i);
        zzfkn zzc2 = zzr.zzc();
        ListenableFuture zzm = zzm(zzbxd, zzc2, zzr);
        zzflh zzd2 = zzr.zzd();
        zzfkw zza2 = zzfkv.zza(this.zza, zzflo.CUI_NAME_ADREQUEST_BUILDURL);
        ListenableFuture zzl = zzl(zzm, zzc2, zzb2, zzd2, zza2);
        return zzc2.zza(zzfkh.GET_URL_AND_CACHE_KEY, zzm, zzl).zza(new zzeck(this, zzl, zzm, zzbxd, zza2)).zza();
    }

    public final ListenableFuture zzc(zzbxd zzbxd, int i) {
        zzecr zzecr;
        zzfjs zzfjs;
        zzbpq zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        zzexp zzr = this.zzd.zzr(zzbxd, i);
        zzbpg zza2 = zzb2.zza("google.afma.response.normalize", zzect.zza, zzbpn.zzb);
        if (!((Boolean) zzbfz.zza.zze()).booleanValue()) {
            String str = zzbxd.zzj;
            zzecr = null;
            if (str != null && !str.isEmpty()) {
                zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            zzecr = zzk(zzbxd.zzh);
            if (zzecr == null) {
                zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        zzfkw zza3 = zzecr == null ? zzfkv.zza(this.zza, zzflo.CUI_NAME_ADREQUEST_BUILDURL) : zzecr.zze;
        zzflh zzd2 = zzr.zzd();
        zzd2.zze(zzbxd.zza.getStringArrayList("ad_types"));
        zzedl zzedl = new zzedl(zzbxd.zzg, zzd2, zza3);
        zzedi zzedi = new zzedi(this.zza, zzbxd.zzb.afmaVersion, this.zzg, i);
        zzfkn zzc2 = zzr.zzc();
        zzfkw zza4 = zzfkv.zza(this.zza, zzflo.CUI_NAME_ADREQUEST_PARSERESPONSE);
        if (zzecr == null) {
            ListenableFuture zzm = zzm(zzbxd, zzc2, zzr);
            ListenableFuture zzl = zzl(zzm, zzc2, zzb2, zzd2, zza3);
            zzfkw zza5 = zzfkv.zza(this.zza, zzflo.CUI_NAME_ADREQUEST_REQUEST);
            zzfjs zza6 = zzc2.zza(zzfkh.HTTP, zzl, zzm).zza(new zzeci(zzl, zzbxd, zzm)).zze(zzedl).zze(new zzflc(zza5)).zze(zzedi).zza();
            zzflg.zzb(zza6, zzd2, zza5);
            zzflg.zze(zza6, zza4);
            zzfjs = zzc2.zza(zzfkh.PRE_PROCESS, zzm, zzl, zza6).zza(new zzecj(zzbxd, zza6, zzm, zzl)).zzf(zza2).zza();
        } else {
            zzedk zzedk = new zzedk(zzecr.zzb, zzecr.zza);
            zzfkw zza7 = zzfkv.zza(this.zza, zzflo.CUI_NAME_ADREQUEST_REQUEST);
            zzfjs zza8 = zzc2.zzb(zzfkh.HTTP, zzgee.zzh(zzedk)).zze(zzedl).zze(new zzflc(zza7)).zze(zzedi).zza();
            zzflg.zzb(zza8, zzd2, zza7);
            ListenableFuture zzh2 = zzgee.zzh(zzecr);
            zzflg.zze(zza8, zza4);
            zzfjs = zzc2.zza(zzfkh.PRE_PROCESS, zza8, zzh2).zza(new zzecf(zza8, zzh2)).zzf(zza2).zza();
        }
        zzflg.zzb(zzfjs, zzd2, zza4);
        return zzfjs;
    }

    public final ListenableFuture zzd(zzbxd zzbxd, int i) {
        zzbpq zzb2 = zzu.zzf().zzb(this.zza, VersionInfoParcel.forPackage(), this.zzf);
        if (!((Boolean) zzbge.zza.zze()).booleanValue()) {
            return zzgee.zzg(new Exception("Signal collection disabled."));
        }
        zzexp zzr = this.zzd.zzr(zzbxd, i);
        zzewu zza2 = zzr.zza();
        zzbpg zza3 = zzb2.zza("google.afma.request.getSignals", zzbpn.zza, zzbpn.zzb);
        zzfkw zza4 = zzfkv.zza(this.zza, zzflo.CUI_NAME_SCAR_SIGNALS);
        zzfjs zza5 = zzr.zzc().zzb(zzfkh.GET_SIGNALS, zzgee.zzh(zzbxd.zza)).zze(new zzflc(zza4)).zzf(new zzeco(zza2, zzbxd)).zzb(zzfkh.JS_SIGNALS).zzf(zza3).zza();
        zzflh zzd2 = zzr.zzd();
        zzd2.zze(zzbxd.zza.getStringArrayList("ad_types"));
        zzflg.zzc(zza5, zzd2, zza4);
        if (((Boolean) zzbft.zzg.zze()).booleanValue()) {
            zzedm zzedm = this.zzc;
            Objects.requireNonNull(zzedm);
            zza5.addListener(new zzecl(zzedm), this.zzb);
        }
        return zza5;
    }

    public final void zze(zzbxd zzbxd, zzbww zzbww) {
        zzp(zzb(zzbxd, Binder.getCallingUid()), zzbww, zzbxd);
    }

    public final void zzf(zzbxd zzbxd, zzbww zzbww) {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue() && (bundle = zzbxd.zzm) != null) {
            bundle.putLong(zzdtq.SERVICE_CONNECTED.zza(), zzu.zzB().currentTimeMillis());
        }
        zzp(zzd(zzbxd, Binder.getCallingUid()), zzbww, zzbxd);
    }

    public final void zzg(zzbxd zzbxd, zzbww zzbww) {
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue() && (bundle = zzbxd.zzm) != null) {
            bundle.putLong(zzdtq.SERVICE_CONNECTED.zza(), zzu.zzB().currentTimeMillis());
        }
        ListenableFuture zzc2 = zzc(zzbxd, Binder.getCallingUid());
        zzp(zzc2, zzbww, zzbxd);
        if (((Boolean) zzbft.zze.zze()).booleanValue()) {
            zzedm zzedm = this.zzc;
            Objects.requireNonNull(zzedm);
            zzc2.addListener(new zzecl(zzedm), this.zzb);
        }
    }

    public final void zzh(String str, zzbww zzbww) {
        zzp(zzi(str), zzbww, (zzbxd) null);
    }

    public final ListenableFuture zzi(String str) {
        if (!((Boolean) zzbfz.zza.zze()).booleanValue()) {
            return zzgee.zzg(new Exception("Split request is disabled."));
        }
        zzecp zzecp = new zzecp(this);
        if (zzk(str) == null) {
            return zzgee.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzgee.zzh(zzecp);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzj(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzbxd zzbxd, zzfkw zzfkw) throws Exception {
        String zze2 = ((zzbxg) listenableFuture.get()).zze();
        String str = zzbxd.zzh;
        zzn(new zzecr((zzbxg) listenableFuture.get(), (JSONObject) listenableFuture2.get(), str, zze2, zzfkw));
        return new ByteArrayInputStream(zze2.getBytes(zzfwd.zzc));
    }
}
