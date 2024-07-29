package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzflh implements Runnable {
    private final List zza = new ArrayList();
    private final zzflk zzb;
    private zzflq zzc = zzflq.FORMAT_UNKNOWN;
    private String zzd;
    private String zze;
    private zzffy zzf;
    private zze zzg;
    private Future zzh;

    zzflh(zzflk zzflk) {
        this.zzb = zzflk;
    }

    public final synchronized void run() {
        zzh();
    }

    public final synchronized zzflh zza(zzfkw zzfkw) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            List list = this.zza;
            zzfkw.zzj();
            list.add(zzfkw);
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            this.zzh = zzcbr.zzd.schedule(this, (long) ((Integer) zzba.zzc().zza(zzbdz.zziH)).intValue(), TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public final synchronized zzflh zzb(String str) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue() && zzflg.zzf(str)) {
            this.zzd = str;
        }
        return this;
    }

    public final synchronized zzflh zzc(zze zze2) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            this.zzg = zze2;
        }
        return this;
    }

    public final synchronized zzflh zzd(zzflq zzflq) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            this.zzc = zzflq;
        }
        return this;
    }

    public final synchronized zzflh zze(ArrayList arrayList) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            if (!arrayList.contains("banner")) {
                if (!arrayList.contains(AdFormat.BANNER.name())) {
                    if (!arrayList.contains("interstitial")) {
                        if (!arrayList.contains(AdFormat.INTERSTITIAL.name())) {
                            if (!arrayList.contains("native")) {
                                if (!arrayList.contains(AdFormat.NATIVE.name())) {
                                    if (!arrayList.contains("rewarded")) {
                                        if (!arrayList.contains(AdFormat.REWARDED.name())) {
                                            if (arrayList.contains("app_open_ad")) {
                                                this.zzc = zzflq.FORMAT_APP_OPEN;
                                            } else if (arrayList.contains("rewarded_interstitial") || arrayList.contains(AdFormat.REWARDED_INTERSTITIAL.name())) {
                                                this.zzc = zzflq.FORMAT_REWARDED_INTERSTITIAL;
                                            }
                                        }
                                    }
                                    this.zzc = zzflq.FORMAT_REWARDED;
                                }
                            }
                            this.zzc = zzflq.FORMAT_NATIVE;
                        }
                    }
                    this.zzc = zzflq.FORMAT_INTERSTITIAL;
                }
            }
            this.zzc = zzflq.FORMAT_BANNER;
        }
        return this;
    }

    public final synchronized zzflh zzf(String str) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            this.zze = str;
        }
        return this;
    }

    public final synchronized zzflh zzg(zzffy zzffy) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            this.zzf = zzffy;
        }
        return this;
    }

    public final synchronized void zzh() {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            Future future = this.zzh;
            if (future != null) {
                future.cancel(false);
            }
            for (zzfkw zzfkw : this.zza) {
                if (this.zzc != zzflq.FORMAT_UNKNOWN) {
                    zzfkw.zzd(this.zzc);
                }
                if (!TextUtils.isEmpty(this.zzd)) {
                    zzfkw.zzf(this.zzd);
                }
                if (!TextUtils.isEmpty(this.zze) && !zzfkw.zzl()) {
                    zzfkw.zze(this.zze);
                }
                zzffy zzffy = this.zzf;
                if (zzffy != null) {
                    zzfkw.zzb(zzffy);
                } else {
                    zze zze2 = this.zzg;
                    if (zze2 != null) {
                        zzfkw.zza(zze2);
                    }
                }
                this.zzb.zzb(zzfkw.zzm());
            }
            this.zza.clear();
        }
    }
}
