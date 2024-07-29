package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzda;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdxq implements zzp, zzcia {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private zzdxf zzc;
    private zzcgm zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private zzda zzh;
    private boolean zzi;

    zzdxq(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = versionInfoParcel;
    }

    private final synchronized boolean zzl(zzda zzda) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zziO)).booleanValue()) {
            zzm.zzj("Ad inspector had an internal error.");
            try {
                zzda.zze(zzfhk.zzd(16, (String) null, (zze) null));
            } catch (RemoteException unused) {
            }
        } else if (this.zzc == null) {
            zzm.zzj("Ad inspector had an internal error.");
            try {
                zzu.zzo().zzw(new NullPointerException("InspectorManager null"), "InspectorUi.shouldOpenUi");
                zzda.zze(zzfhk.zzd(16, (String) null, (zze) null));
            } catch (RemoteException unused2) {
            }
        } else {
            if (!this.zze && !this.zzf) {
                if (zzu.zzB().currentTimeMillis() >= this.zzg + ((long) ((Integer) zzba.zzc().zza(zzbdz.zziR)).intValue())) {
                    return true;
                }
            }
            zzm.zzj("Ad inspector cannot be opened because it is already open.");
            try {
                zzda.zze(zzfhk.zzd(19, (String) null, (zze) null));
            } catch (RemoteException unused3) {
            }
        }
        return false;
        return false;
        return false;
    }

    public final synchronized void zza(boolean z, int i, String str, String str2) {
        if (z) {
            com.google.android.gms.ads.internal.util.zze.zza("Ad inspector loaded.");
            this.zze = true;
            zzk("");
            return;
        }
        zzm.zzj("Ad inspector failed to load.");
        try {
            zzcbh zzo = zzu.zzo();
            zzo.zzw(new Exception("Failed to load UI. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2), "InspectorUi.onAdWebViewFinishedLoading 0");
            zzda zzda = this.zzh;
            if (zzda != null) {
                zzda.zze(zzfhk.zzd(17, (String) null, (zze) null));
            }
        } catch (RemoteException e) {
            zzu.zzo().zzw(e, "InspectorUi.onAdWebViewFinishedLoading 1");
        }
        this.zzi = true;
        this.zzd.destroy();
    }

    public final void zzdH() {
    }

    public final void zzdk() {
    }

    public final void zzdq() {
    }

    public final synchronized void zzdr() {
        this.zzf = true;
        zzk("");
    }

    public final void zzdt() {
    }

    public final synchronized void zzdu(int i) {
        this.zzd.destroy();
        if (!this.zzi) {
            com.google.android.gms.ads.internal.util.zze.zza("Inspector closed.");
            zzda zzda = this.zzh;
            if (zzda != null) {
                try {
                    zzda.zze((zze) null);
                } catch (RemoteException unused) {
                }
            }
        }
        this.zzf = false;
        this.zze = false;
        this.zzg = 0;
        this.zzi = false;
        this.zzh = null;
    }

    public final Activity zzg() {
        zzcgm zzcgm = this.zzd;
        if (zzcgm == null || zzcgm.zzaB()) {
            return null;
        }
        return this.zzd.zzi();
    }

    public final void zzh(zzdxf zzdxf) {
        this.zzc = zzdxf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(String str) {
        JSONObject zze2 = this.zzc.zze();
        if (!TextUtils.isEmpty(str)) {
            try {
                zze2.put("redirectUrl", str);
            } catch (JSONException unused) {
            }
        }
        this.zzd.zzb("window.inspectorInfo", zze2.toString());
    }

    public final synchronized void zzj(zzda zzda, zzbls zzbls, zzbll zzbll, zzbkz zzbkz) {
        zzda zzda2 = zzda;
        synchronized (this) {
            if (zzl(zzda)) {
                try {
                    zzu.zzz();
                    zzcgm zza2 = zzcgz.zza(this.zza, zzcie.zza(), "", false, false, (zzawo) null, (zzbfc) null, this.zzb, (zzbeo) null, (com.google.android.gms.ads.internal.zzm) null, (zza) null, zzbcx.zza(), (zzffn) null, (zzffq) null, (zzefo) null, (zzfgm) null);
                    this.zzd = zza2;
                    zzcic zzN = zza2.zzN();
                    if (zzN == null) {
                        zzm.zzj("Failed to obtain a web view for the ad inspector");
                        try {
                            zzu.zzo().zzw(new NullPointerException("Failed to obtain a web view for the ad inspector"), "InspectorUi.openInspector 2");
                            zzda2.zze(zzfhk.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                        } catch (RemoteException e) {
                            zzu.zzo().zzw(e, "InspectorUi.openInspector 3");
                        }
                    } else {
                        this.zzh = zzda2;
                        zzN.zzR((com.google.android.gms.ads.internal.client.zza) null, (zzbjo) null, (zzp) null, (zzbjq) null, (zzaa) null, false, (zzblb) null, (zzb) null, (zzbtt) null, (zzbzo) null, (zzefd) null, (zzfmt) null, (zzduh) null, zzbls, (zzdgn) null, new zzblr(this.zza), zzbll, zzbkz, (zzcpk) null);
                        zzN.zzB(this);
                        this.zzd.loadUrl((String) zzba.zzc().zza(zzbdz.zziP));
                        zzu.zzi();
                        zzn.zza(this.zza, new AdOverlayInfoParcel(this, this.zzd, 1, this.zzb), true);
                        this.zzg = zzu.zzB().currentTimeMillis();
                    }
                } catch (zzcgy e2) {
                    zzm.zzk("Failed to obtain a web view for the ad inspector", e2);
                    try {
                        zzu.zzo().zzw(e2, "InspectorUi.openInspector 0");
                        zzda2.zze(zzfhk.zzd(17, "Failed to obtain a web view for the ad inspector", (zze) null));
                    } catch (RemoteException e3) {
                        zzu.zzo().zzw(e3, "InspectorUi.openInspector 1");
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzk(java.lang.String r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zze     // Catch:{ all -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            boolean r0 = r2.zzf     // Catch:{ all -> 0x0018 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            com.google.android.gms.internal.ads.zzgep r0 = com.google.android.gms.internal.ads.zzcbr.zze     // Catch:{ all -> 0x0018 }
            com.google.android.gms.internal.ads.zzdxp r1 = new com.google.android.gms.internal.ads.zzdxp     // Catch:{ all -> 0x0018 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0018 }
            r0.execute(r1)     // Catch:{ all -> 0x0018 }
            monitor-exit(r2)
            return
        L_0x0016:
            monitor-exit(r2)
            return
        L_0x0018:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdxq.zzk(java.lang.String):void");
    }
}
