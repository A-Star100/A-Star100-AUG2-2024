package com.google.android.gms.ads.nonagon.signalgeneration;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzfkw;
import com.google.android.gms.internal.ads.zzflh;
import com.google.android.gms.internal.ads.zzgea;
import com.google.common.util.concurrent.ListenableFuture;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzx implements zzgea {
    final /* synthetic */ ListenableFuture zza;
    final /* synthetic */ zzcat zzb;
    final /* synthetic */ zzcam zzc;
    final /* synthetic */ zzfkw zzd;
    final /* synthetic */ zzab zze;

    zzx(zzab zzab, ListenableFuture listenableFuture, zzcat zzcat, zzcam zzcam, zzfkw zzfkw) {
        this.zza = listenableFuture;
        this.zzb = zzcat;
        this.zzc = zzcam;
        this.zzd = zzfkw;
        this.zze = zzab;
    }

    public final void zza(Throwable th) {
        String message = th.getMessage();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhJ)).booleanValue()) {
            zzu.zzo().zzv(th, "SignalGeneratorImpl.generateSignals");
        } else {
            zzu.zzo().zzw(th, "SignalGeneratorImpl.generateSignals");
        }
        zzflh zzr = zzab.zzr(this.zza, this.zzb);
        if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
            zzfkw zzfkw = this.zzd;
            zzfkw.zzh(th);
            zzfkw.zzg(false);
            zzr.zza(zzfkw);
            zzr.zzh();
        }
        try {
            if (!"Unknown format is no longer supported.".equals(message)) {
                message = "Internal error. " + message;
            }
            this.zzc.zzb(message);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzap zzap = (zzap) obj;
        zzflh zzr = zzab.zzr(this.zza, this.zzb);
        this.zze.zzH.set(true);
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhE)).booleanValue()) {
            try {
                this.zzc.zzb("QueryInfo generation has been disabled.");
            } catch (RemoteException e) {
                zzm.zzg("QueryInfo generation has been disabled.".concat(e.toString()));
            }
            if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
                zzfkw zzfkw = this.zzd;
                zzfkw.zzc("QueryInfo generation has been disabled.");
                zzfkw.zzg(false);
                zzr.zza(zzfkw);
                zzr.zzh();
            }
        } else if (zzap == null) {
            try {
                this.zzc.zzc((String) null, (String) null, (Bundle) null);
                this.zzd.zzg(true);
                if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (RemoteException e2) {
                zzfkw zzfkw2 = this.zzd;
                zzfkw2.zzh(e2);
                zzfkw2.zzg(false);
                zzm.zzh("", e2);
                zzu.zzo().zzw(e2, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (Throwable th) {
                if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
                throw th;
            }
        } else {
            try {
                if (TextUtils.isEmpty(new JSONObject(zzap.zzb).optString(ProxyAmazonBillingActivity.EXTRAS_REQUEST_ID, ""))) {
                    zzm.zzj("The request ID is empty in request JSON.");
                    this.zzc.zzb("Internal error: request ID is empty in request JSON.");
                    zzfkw zzfkw3 = this.zzd;
                    zzfkw3.zzc("Request ID empty");
                    zzfkw3.zzg(false);
                    if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
                        zzr.zza(this.zzd);
                        zzr.zzh();
                        return;
                    }
                    return;
                }
                Bundle bundle = zzap.zzd;
                zzab zzab = this.zze;
                if (zzab.zzv && bundle != null && bundle.getInt(zzab.zzx, -1) == -1) {
                    zzab zzab2 = this.zze;
                    bundle.putInt(zzab2.zzx, zzab2.zzy.get());
                }
                zzab zzab3 = this.zze;
                if (zzab3.zzu && bundle != null && TextUtils.isEmpty(bundle.getString(zzab3.zzw))) {
                    if (TextUtils.isEmpty(this.zze.zzA)) {
                        zzab zzab4 = this.zze;
                        zzt zzp = zzu.zzp();
                        zzab zzab5 = this.zze;
                        zzab4.zzA = zzp.zzc(zzab5.zzg, zzab5.zzz.afmaVersion);
                    }
                    zzab zzab6 = this.zze;
                    bundle.putString(zzab6.zzw, zzab6.zzA);
                }
                this.zzc.zzc(zzap.zza, zzap.zzb, bundle);
                this.zzd.zzg(true);
                if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            } catch (JSONException e3) {
                zzm.zzj("Failed to create JSON object from the request string.");
                zzcam zzcam = this.zzc;
                String obj2 = e3.toString();
                zzcam.zzb("Internal error for request JSON: " + obj2);
                zzfkw zzfkw4 = this.zzd;
                zzfkw4.zzh(e3);
                zzfkw4.zzg(false);
                zzu.zzo().zzw(e3, "SignalGeneratorImpl.generateSignals.onSuccess");
                if (((Boolean) zzbfm.zze.zze()).booleanValue() && zzr != null) {
                    zzr.zza(this.zzd);
                    zzr.zzh();
                }
            }
        }
    }
}
