package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zzcc;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbpc {
    /* access modifiers changed from: private */
    public final Object zza = new Object();
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    /* access modifiers changed from: private */
    public final zzflk zze;
    private final zzbd zzf;
    private final zzbd zzg;
    /* access modifiers changed from: private */
    public zzbpb zzh;
    /* access modifiers changed from: private */
    public int zzi = 1;

    public zzbpc(Context context, VersionInfoParcel versionInfoParcel, String str, zzbd zzbd, zzbd zzbd2, zzflk zzflk) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzflk;
        this.zzf = zzbd;
        this.zzg = zzbd2;
    }

    public final zzbow zzb(zzawo zzawo) {
        zze.zza("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("getEngine: Lock acquired");
            zze.zza("refreshIfDestroyed: Trying to acquire lock");
            synchronized (this.zza) {
                zze.zza("refreshIfDestroyed: Lock acquired");
                zzbpb zzbpb = this.zzh;
                if (zzbpb != null && this.zzi == 0) {
                    zzbpb.zzj(new zzboi(this), zzboj.zza);
                }
            }
            zze.zza("refreshIfDestroyed: Lock released");
            zzbpb zzbpb2 = this.zzh;
            if (zzbpb2 != null) {
                if (zzbpb2.zze() != -1) {
                    int i = this.zzi;
                    if (i == 0) {
                        zze.zza("getEngine (NO_UPDATE): Lock released");
                        zzbow zza2 = this.zzh.zza();
                        return zza2;
                    } else if (i == 1) {
                        this.zzi = 2;
                        zzd((zzawo) null);
                        zze.zza("getEngine (PENDING_UPDATE): Lock released");
                        zzbow zza3 = this.zzh.zza();
                        return zza3;
                    } else {
                        zze.zza("getEngine (UPDATING): Lock released");
                        zzbow zza4 = this.zzh.zza();
                        return zza4;
                    }
                }
            }
            this.zzi = 2;
            this.zzh = zzd((zzawo) null);
            zze.zza("getEngine (NULL or REJECTED): Lock released");
            zzbow zza5 = this.zzh.zza();
            return zza5;
        }
    }

    /* access modifiers changed from: protected */
    public final zzbpb zzd(zzawo zzawo) {
        zzfkw zza2 = zzfkv.zza(this.zzb, zzflo.CUI_NAME_SDKINIT_SDKCORE);
        zza2.zzi();
        zzbpb zzbpb = new zzbpb(this.zzg);
        zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        zzcbr.zze.execute(new zzbom(this, (zzawo) null, zzbpb));
        zze.zza("loadNewJavascriptEngine: Promise created");
        zzbpb.zzj(new zzbor(this, zzbpb, zza2), new zzbos(this, zzbpb, zza2));
        return zzbpb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzbpb zzbpb, zzbnx zzbnx, ArrayList arrayList, long j) {
        zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
            if (zzbpb.zze() != -1) {
                if (zzbpb.zze() != 1) {
                    if (((Boolean) zzba.zzc().zza(zzbdz.zzhI)).booleanValue()) {
                        zzbpb.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                    } else {
                        zzbpb.zzg();
                    }
                    zzgep zzgep = zzcbr.zze;
                    Objects.requireNonNull(zzbnx);
                    zzgep.execute(new zzbok(zzbnx));
                    String valueOf = String.valueOf(zzba.zzc().zza(zzbdz.zzc));
                    int zze2 = zzbpb.zze();
                    int i = this.zzi;
                    String valueOf2 = String.valueOf(arrayList.get(0));
                    long currentTimeMillis = zzu.zzB().currentTimeMillis() - j;
                    zze.zza("Could not receive /jsLoaded in " + valueOf + " ms. JS engine session reference status(onEngLoadedTimeout) is " + zze2 + ". Update status(onEngLoadedTimeout) is " + i + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + valueOf2 + " ms. Total latency(onEngLoadedTimeout) is " + currentTimeMillis + " ms. Rejecting.");
                    zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                    return;
                }
            }
            zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj(zzawo zzawo, zzbpb zzbpb) {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbof zzbof = new zzbof(this.zzb, this.zzd, (zzawo) null, (zza) null);
            zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbof.zzk(new zzbol(this, arrayList, currentTimeMillis, zzbpb, zzbof));
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbof.zzq("/jsLoaded", new zzbon(this, currentTimeMillis, zzbpb, zzbof));
            zzcc zzcc = new zzcc();
            zzboo zzboo = new zzboo(this, (zzawo) null, zzbof, zzcc);
            zzcc.zzb(zzboo);
            zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbof.zzq("/requestReload", zzboo);
            zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbof.zzh(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbof.zzf(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbof.zzg(this.zzc);
                zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            zzt.zza.postDelayed(new zzboq(this, zzbpb, zzbof, arrayList, currentTimeMillis), (long) ((Integer) zzba.zzc().zza(zzbdz.zzd)).intValue());
        } catch (Throwable th) {
            zzm.zzh("Error creating webview.", th);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzhI)).booleanValue()) {
                zzbpb.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            zzu.zzo().zzw(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzbpb.zzg();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk(zzbnx zzbnx) {
        if (zzbnx.zzi()) {
            this.zzi = 1;
        }
    }
}
