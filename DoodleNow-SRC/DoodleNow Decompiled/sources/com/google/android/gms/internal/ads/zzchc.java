package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzchc extends FrameLayout implements zzcgm {
    private final zzcgm zza;
    private final zzcdc zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzchc(zzcgm zzcgm) {
        super(zzcgm.getContext());
        this.zza = zzcgm;
        this.zzb = new zzcdc(zzcgm.zzE(), this, this);
        addView((View) zzcgm);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        zzfmy zzR = zzR();
        if (zzR != null) {
            zzt.zza.post(new zzcha(zzR));
            zzcgm zzcgm = this.zza;
            zzftg zzftg = zzt.zza;
            Objects.requireNonNull(zzcgm);
            zzftg.postDelayed(new zzchb(zzcgm), (long) ((Integer) zzba.zzc().zza(zzbdz.zzeX)).intValue());
            return;
        }
        this.zza.destroy();
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, "text/html", str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, "text/html", "UTF-8", (String) null);
    }

    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    public final void onAdClicked() {
        zzcgm zzcgm = this.zza;
        if (zzcgm != null) {
            zzcgm.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzb.zzf();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA(int i) {
        this.zza.zzA(i);
    }

    public final void zzB(int i) {
        this.zzb.zzg(i);
    }

    public final void zzC(zzchm zzchm) {
        this.zza.zzC(zzchm);
    }

    public final zzffn zzD() {
        return this.zza.zzD();
    }

    public final Context zzE() {
        return this.zza.zzE();
    }

    public final View zzF() {
        return this;
    }

    public final WebView zzG() {
        return (WebView) this.zza;
    }

    public final WebViewClient zzH() {
        return this.zza.zzH();
    }

    public final zzawo zzI() {
        return this.zza.zzI();
    }

    public final zzbbl zzJ() {
        return this.zza.zzJ();
    }

    public final zzbgs zzK() {
        return this.zza.zzK();
    }

    public final zzm zzL() {
        return this.zza.zzL();
    }

    public final zzm zzM() {
        return this.zza.zzM();
    }

    public final zzcic zzN() {
        return ((zzchj) this.zza).zzaL();
    }

    public final zzcie zzO() {
        return this.zza.zzO();
    }

    public final zzffq zzP() {
        return this.zza.zzP();
    }

    public final zzfgm zzQ() {
        return this.zza.zzQ();
    }

    public final zzfmy zzR() {
        return this.zza.zzR();
    }

    public final ListenableFuture zzS() {
        return this.zza.zzS();
    }

    public final String zzT() {
        return this.zza.zzT();
    }

    public final void zzU(zzffn zzffn, zzffq zzffq) {
        this.zza.zzU(zzffn, zzffq);
    }

    public final void zzV() {
        this.zzb.zze();
        this.zza.zzV();
    }

    public final void zzW() {
        this.zza.zzW();
    }

    public final void zzX(int i) {
        this.zza.zzX(i);
    }

    public final void zzY() {
        this.zza.zzY();
    }

    public final void zzZ() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzu.zzr().zze()));
        hashMap.put("app_volume", String.valueOf(zzu.zzr().zza()));
        zzchj zzchj = (zzchj) this.zza;
        hashMap.put("device_volume", String.valueOf(zzac.zzb(zzchj.getContext())));
        zzchj.zzd("volume", hashMap);
    }

    public final void zza(String str) {
        ((zzchj) this.zza).zzaQ(str);
    }

    public final boolean zzaA(boolean z, int i) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzaL)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaA(z, i);
        return true;
    }

    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    public final boolean zzaD() {
        return this.zzc.get();
    }

    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    public final void zzaF(zzc zzc2, boolean z) {
        this.zza.zzaF(zzc2, z);
    }

    public final void zzaG(String str, String str2, int i) {
        this.zza.zzaG(str, str2, 14);
    }

    public final void zzaH(boolean z, int i, boolean z2) {
        this.zza.zzaH(z, i, z2);
    }

    public final void zzaI(boolean z, int i, String str, String str2, boolean z2) {
        this.zza.zzaI(z, i, str, str2, z2);
    }

    public final void zzaJ(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zza.zzaJ(z, i, str, z2, z3);
    }

    public final void zzaa(boolean z) {
        this.zza.zzaa(z);
    }

    public final void zzab() {
        this.zza.zzab();
    }

    public final void zzac(String str, String str2, String str3) {
        this.zza.zzac(str, str2, (String) null);
    }

    public final void zzad() {
        this.zza.zzad();
    }

    public final void zzae(String str, zzbky zzbky) {
        this.zza.zzae(str, zzbky);
    }

    public final void zzaf() {
        TextView textView = new TextView(getContext());
        zzu.zzp();
        textView.setText(zzt.zzy());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzag(zzm zzm) {
        this.zza.zzag(zzm);
    }

    public final void zzah(zzcie zzcie) {
        this.zza.zzah(zzcie);
    }

    public final void zzai(zzbbl zzbbl) {
        this.zza.zzai(zzbbl);
    }

    public final void zzaj(boolean z) {
        this.zza.zzaj(z);
    }

    public final void zzak() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzal(Context context) {
        this.zza.zzal(context);
    }

    public final void zzam(boolean z) {
        this.zza.zzam(z);
    }

    public final void zzan(zzbgq zzbgq) {
        this.zza.zzan(zzbgq);
    }

    public final void zzao(boolean z) {
        this.zza.zzao(z);
    }

    public final void zzap(zzbgs zzbgs) {
        this.zza.zzap(zzbgs);
    }

    public final void zzaq(zzfmy zzfmy) {
        this.zza.zzaq(zzfmy);
    }

    public final void zzar(int i) {
        this.zza.zzar(i);
    }

    public final void zzas(boolean z) {
        this.zza.zzas(true);
    }

    public final void zzat(zzm zzm) {
        this.zza.zzat(zzm);
    }

    public final void zzau(boolean z) {
        this.zza.zzau(z);
    }

    public final void zzav(boolean z) {
        this.zza.zzav(z);
    }

    public final void zzaw(String str, zzbky zzbky) {
        this.zza.zzaw(str, zzbky);
    }

    public final void zzax(String str, Predicate predicate) {
        this.zza.zzax(str, predicate);
    }

    public final boolean zzay() {
        return this.zza.zzay();
    }

    public final boolean zzaz() {
        return this.zza.zzaz();
    }

    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    public final void zzd(String str, Map map) {
        this.zza.zzd(str, map);
    }

    public final void zzdG() {
        zzcgm zzcgm = this.zza;
        if (zzcgm != null) {
            zzcgm.zzdG();
        }
    }

    public final void zzdf() {
        zzcgm zzcgm = this.zza;
        if (zzcgm != null) {
            zzcgm.zzdf();
        }
    }

    public final void zzdg() {
        this.zza.zzdg();
    }

    public final void zzdh() {
        this.zza.zzdh();
    }

    public final String zzdi() {
        return this.zza.zzdi();
    }

    public final void zzdp(zzazx zzazx) {
        this.zza.zzdp(zzazx);
    }

    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    public final int zzf() {
        return this.zza.zzf();
    }

    public final int zzg() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdM)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    public final int zzh() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdM)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    public final Activity zzi() {
        return this.zza.zzi();
    }

    public final zza zzj() {
        return this.zza.zzj();
    }

    public final zzbel zzk() {
        return this.zza.zzk();
    }

    public final void zzl(String str, JSONObject jSONObject) {
        ((zzchj) this.zza).zzb(str, jSONObject.toString());
    }

    public final zzbem zzm() {
        return this.zza.zzm();
    }

    public final VersionInfoParcel zzn() {
        return this.zza.zzn();
    }

    public final zzcdc zzo() {
        return this.zzb;
    }

    public final zzcey zzp(String str) {
        return this.zza.zzp(str);
    }

    public final zzchm zzq() {
        return this.zza.zzq();
    }

    public final String zzr() {
        return this.zza.zzr();
    }

    public final void zzt(String str, zzcey zzcey) {
        this.zza.zzt(str, zzcey);
    }

    public final void zzu() {
        this.zza.zzu();
    }

    public final void zzv(boolean z, long j) {
        this.zza.zzv(z, j);
    }

    public final void zzw() {
        this.zza.zzw();
    }

    public final void zzx(int i) {
    }

    public final void zzy(int i) {
    }

    public final void zzz(boolean z) {
        this.zza.zzz(false);
    }
}
