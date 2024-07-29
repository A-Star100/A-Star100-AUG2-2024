package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdot {
    private final zzfgi zza;
    private final Executor zzb;
    private final zzdri zzc;
    private final zzdqd zzd;
    private final Context zze;
    private final zzduh zzf;
    private final zzfmt zzg;
    private final zzefd zzh;

    public zzdot(zzfgi zzfgi, Executor executor, zzdri zzdri, Context context, zzduh zzduh, zzfmt zzfmt, zzefd zzefd, zzdqd zzdqd) {
        this.zza = zzfgi;
        this.zzb = executor;
        this.zzc = zzdri;
        this.zze = context;
        this.zzf = zzduh;
        this.zzg = zzfmt;
        this.zzh = zzefd;
        this.zzd = zzdqd;
    }

    private final void zzh(zzcgm zzcgm) {
        zzj(zzcgm);
        zzcgm.zzae("/video", zzbkx.zzl);
        zzcgm.zzae("/videoMeta", zzbkx.zzm);
        zzcgm.zzae("/precache", new zzcez());
        zzcgm.zzae("/delayPageLoaded", zzbkx.zzp);
        zzcgm.zzae("/instrument", zzbkx.zzn);
        zzcgm.zzae("/log", zzbkx.zzg);
        zzcgm.zzae("/click", new zzbjw((zzdgn) null, (zzcpk) null));
        if (this.zza.zzb != null) {
            zzcgm.zzN().zzE(true);
            zzcgm.zzae("/open", new zzblk((zzb) null, (zzbtm) null, (zzefd) null, (zzduh) null, (zzcpk) null));
        } else {
            zzcgm.zzN().zzE(false);
        }
        if (zzu.zzn().zzp(zzcgm.getContext())) {
            zzcgm.zzae("/logScionEvent", new zzble(zzcgm.getContext()));
        }
    }

    private final void zzi(zzcgm zzcgm, zzcbv zzcbv) {
        if (!(this.zza.zza == null || zzcgm.zzq() == null)) {
            zzcgm.zzq().zzs(this.zza.zza);
        }
        zzcbv.zzb();
    }

    private static final void zzj(zzcgm zzcgm) {
        zzcgm.zzae("/videoClicked", zzbkx.zzh);
        zzcgm.zzN().zzG(true);
        zzcgm.zzae("/getNativeAdViewSignals", zzbkx.zzs);
        zzcgm.zzae("/getNativeClickMeta", zzbkx.zzt);
    }

    public final ListenableFuture zza(JSONObject jSONObject) {
        return zzgee.zzn(zzgee.zzn(zzgee.zzh((Object) null), new zzdok(this), this.zzb), new zzdoj(this, jSONObject), this.zzb);
    }

    public final ListenableFuture zzb(String str, String str2, zzffn zzffn, zzffq zzffq, zzq zzq) {
        return zzgee.zzn(zzgee.zzh((Object) null), new zzdoi(this, zzq, zzffn, zzffq, str, str2), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject, zzcgm zzcgm) throws Exception {
        zzcbv zza2 = zzcbv.zza(zzcgm);
        if (this.zza.zzb != null) {
            zzcgm.zzah(zzcie.zzd());
        } else {
            zzcgm.zzah(zzcie.zze());
        }
        zzcgm.zzN().zzB(new zzdol(this, zzcgm, zza2));
        zzcgm.zzl("google.afma.nativeAds.renderVideo", jSONObject);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzq zzq, zzffn zzffn, zzffq zzffq, String str, String str2, Object obj) throws Exception {
        zzcgm zza2 = this.zzc.zza(zzq, zzffn, zzffq);
        zzcbv zza3 = zzcbv.zza(zza2);
        if (this.zza.zzb != null) {
            zzh(zza2);
            zza2.zzah(zzcie.zzd());
        } else {
            zzdqa zzb2 = this.zzd.zzb();
            zzdqa zzdqa = zzb2;
            zzcic zzN = zza2.zzN();
            zzb zzb3 = r14;
            zzb zzb4 = new zzb(this.zze, (zzbzo) null, (zzbwg) null);
            zzN.zzR(zzb2, zzdqa, zzb2, zzb2, zzb2, false, (zzblb) null, zzb3, (zzbtt) null, (zzbzo) null, this.zzh, this.zzg, this.zzf, (zzbls) null, zzb2, (zzblr) null, (zzbll) null, (zzbkz) null, (zzcpk) null);
            zzj(zza2);
        }
        zza2.zzN().zzB(new zzdom(this, zza2, zza3));
        zza2.zzac(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Object obj) throws Exception {
        zzcgm zza2 = this.zzc.zza(zzq.zzc(), (zzffn) null, (zzffq) null);
        zzcbv zza3 = zzcbv.zza(zza2);
        zzh(zza2);
        zza2.zzN().zzH(new zzdon(zza3));
        zza2.loadUrl((String) zzba.zzc().zza(zzbdz.zzdH));
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzcgm zzcgm, zzcbv zzcbv, boolean z, int i, String str, String str2) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzdR)).booleanValue()) {
            zzi(zzcgm, zzcbv);
        } else if (z) {
            zzi(zzcgm, zzcbv);
        } else {
            zzcbv.zzd(new zzekh(1, "Native Video WebView failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcgm zzcgm, zzcbv zzcbv, boolean z, int i, String str, String str2) {
        if (z) {
            if (!(this.zza.zza == null || zzcgm.zzq() == null)) {
                zzcgm.zzq().zzs(this.zza.zza);
            }
            zzcbv.zzb();
            return;
        }
        zzcbv.zzd(new zzekh(1, "Html video Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
