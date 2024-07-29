package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzfuo;
import com.google.android.gms.internal.ads.zzfup;
import com.google.android.gms.internal.ads.zzfuq;
import com.google.android.gms.internal.ads.zzfur;
import com.google.android.gms.internal.ads.zzfva;
import com.google.android.gms.internal.ads.zzfvc;
import com.google.android.gms.internal.ads.zzfvd;
import com.google.android.gms.internal.ads.zzfve;
import com.google.android.gms.internal.ads.zzfvf;
import com.google.android.gms.internal.ads.zzfvu;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzx {
    private String zza = null;
    private String zzb = null;
    private zzcgm zzc = null;
    private zzfuq zzd = null;
    private boolean zze = false;
    private zzfvd zzf;

    private final zzfvf zzl() {
        zzfve zzc2 = zzfvf.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzlg)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        return zzc2.zzc();
    }

    private final void zzm() {
        if (this.zzf == null) {
            this.zzf = new zzw(this);
        }
    }

    public final synchronized void zza(zzcgm zzcgm, Context context) {
        this.zzc = zzcgm;
        if (!zzk(context)) {
            zzf("Unable to bind", "on_play_store_bind");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", "fetch_completed");
        zze("on_play_store_bind", hashMap);
    }

    public final void zzc() {
        zzfuq zzfuq;
        if (!this.zze || (zzfuq = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfuo zzc2 = zzfup.zzc();
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzlg)).booleanValue() || TextUtils.isEmpty(this.zzb)) {
            String str = this.zza;
            if (str != null) {
                zzc2.zzb(str);
            } else {
                zzf("Missing session token and/or appId", "onLMDupdate");
            }
        } else {
            zzc2.zza(this.zzb);
        }
        zzfuq.zzb(zzc2.zzc(), this.zzf);
    }

    /* access modifiers changed from: package-private */
    public final void zzd(String str) {
        zze(str, new HashMap());
    }

    /* access modifiers changed from: package-private */
    public final void zze(String str, Map map) {
        zzcbr.zze.execute(new zzv(this, str, map));
    }

    /* access modifiers changed from: package-private */
    public final void zzf(String str, String str2) {
        zze.zza(str);
        if (this.zzc != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str);
            hashMap.put("action", str2);
            zze("onError", hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(String str, Map map) {
        zzcgm zzcgm = this.zzc;
        if (zzcgm != null) {
            zzcgm.zzd(str, map);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzi(zzfvc zzfvc) {
        if (!TextUtils.isEmpty(zzfvc.zzb())) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzlg)).booleanValue()) {
                this.zza = zzfvc.zzb();
            }
        }
        switch (zzfvc.zza()) {
            case 8152:
                zzd("onLMDOverlayOpened");
                return;
            case 8153:
                zzd("onLMDOverlayClicked");
                return;
            case 8155:
                zzd("onLMDOverlayClose");
                return;
            case 8157:
                this.zza = null;
                this.zzb = null;
                this.zze = false;
                return;
            case 8160:
            case 8161:
            case 8162:
                HashMap hashMap = new HashMap();
                hashMap.put("error", String.valueOf(zzfvc.zza()));
                zze("onLMDOverlayFailedToOpen", hashMap);
                return;
            default:
                return;
        }
    }

    public final void zzj(zzcgm zzcgm, zzfva zzfva) {
        if (zzcgm == null) {
            zzf("adWebview missing", "onLMDShow");
            return;
        }
        this.zzc = zzcgm;
        if (this.zze || zzk(zzcgm.getContext())) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzlg)).booleanValue()) {
                this.zzb = zzfva.zzh();
            }
            zzm();
            zzfuq zzfuq = this.zzd;
            if (zzfuq != null) {
                zzfuq.zzd(zzfva, this.zzf);
                return;
            }
            return;
        }
        zzf("LMDOverlay not bound", "on_play_store_bind");
    }

    public final synchronized boolean zzk(Context context) {
        if (!zzfvu.zza(context)) {
            return false;
        }
        try {
            this.zzd = zzfur.zza(context);
        } catch (NullPointerException e) {
            zze.zza("Error connecting LMD Overlay service");
            zzu.zzo().zzw(e, "LastMileDeliveryOverlay.bindLastMileDeliveryService");
        }
        if (this.zzd == null) {
            this.zze = false;
            return false;
        }
        zzm();
        this.zze = true;
        return true;
    }

    public final void zzb() {
        zzfuq zzfuq;
        if (!this.zze || (zzfuq = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfuq.zza(zzl(), this.zzf);
        zzd("onLMDOverlayCollapse");
    }

    public final void zzg() {
        zzfuq zzfuq;
        if (!this.zze || (zzfuq = this.zzd) == null) {
            zze.zza("LastMileDelivery not connected");
            return;
        }
        zzfuq.zzc(zzl(), this.zzf);
        zzd("onLMDOverlayExpand");
    }
}
