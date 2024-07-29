package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbof implements zzbnx, zzbnv {
    private final zzcgm zza;

    public zzbof(Context context, VersionInfoParcel versionInfoParcel, zzawo zzawo, zza zza2) throws zzcgy {
        zzu.zzz();
        zzcgm zza3 = zzcgz.zza(context, zzcie.zza(), "", false, false, (zzawo) null, (zzbfc) null, versionInfoParcel, (zzbeo) null, (zzm) null, (zza) null, zzbcx.zza(), (zzffn) null, (zzffq) null, (zzefo) null, (zzfgm) null);
        this.zza = zza3;
        ((View) zza3).setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        zzay.zzb();
        if (zzf.zzv()) {
            zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
            return;
        }
        zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
        if (!zzt.zza.post(runnable)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    public final void zza(String str) {
        zze.zza("invokeJavascript on adWebView from js");
        zzs(new zzbob(this, str));
    }

    public final /* synthetic */ void zzb(String str, String str2) {
        zzbnu.zzc(this, str, str2);
    }

    public final void zzc() {
        this.zza.destroy();
    }

    public final /* synthetic */ void zzd(String str, Map map) {
        zzbnu.zza(this, str, map);
    }

    public final /* synthetic */ void zze(String str, JSONObject jSONObject) {
        zzbnu.zzb(this, str, jSONObject);
    }

    public final void zzf(String str) {
        zze.zza("loadHtml on adWebView from html");
        zzs(new zzboc(this, str));
    }

    public final void zzg(String str) {
        zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new zzbnz(this, str));
    }

    public final void zzh(String str) {
        zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new zzbod(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str})));
    }

    public final boolean zzi() {
        return this.zza.zzaB();
    }

    public final zzbpe zzj() {
        return new zzbpe(this);
    }

    public final void zzk(zzbol zzbol) {
        zzcic zzN = this.zza.zzN();
        Objects.requireNonNull(zzbol);
        zzN.zzH(new zzboa(zzbol));
    }

    public final /* synthetic */ void zzl(String str, JSONObject jSONObject) {
        zzbnu.zzd(this, str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm(String str) {
        this.zza.zza(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(String str) {
        this.zza.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str) {
        this.zza.loadData(str, "text/html", "UTF-8");
    }

    public final void zzq(String str, zzbky zzbky) {
        this.zza.zzae(str, new zzboe(this, zzbky));
    }

    public final void zzr(String str, zzbky zzbky) {
        this.zza.zzax(str, new zzbny(zzbky));
    }
}
