package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public interface zzcgm extends zza, zzdgn, zzcgd, zzbnt, zzchn, zzchr, zzbog, zzazy, zzchu, zzm, zzchx, zzchy, zzcdn, zzchz {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    boolean isAttachedToWindow();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zzC(zzchm zzchm);

    zzffn zzD();

    Context zzE();

    View zzF();

    WebView zzG();

    WebViewClient zzH();

    zzawo zzI();

    zzbbl zzJ();

    zzbgs zzK();

    com.google.android.gms.ads.internal.overlay.zzm zzL();

    com.google.android.gms.ads.internal.overlay.zzm zzM();

    zzcic zzN();

    zzcie zzO();

    zzffq zzP();

    zzfgm zzQ();

    zzfmy zzR();

    ListenableFuture zzS();

    String zzT();

    void zzU(zzffn zzffn, zzffq zzffq);

    void zzV();

    void zzW();

    void zzX(int i);

    void zzY();

    void zzZ();

    boolean zzaA(boolean z, int i);

    boolean zzaB();

    boolean zzaC();

    boolean zzaD();

    boolean zzaE();

    void zzaa(boolean z);

    void zzab();

    void zzac(String str, String str2, String str3);

    void zzad();

    void zzae(String str, zzbky zzbky);

    void zzaf();

    void zzag(com.google.android.gms.ads.internal.overlay.zzm zzm);

    void zzah(zzcie zzcie);

    void zzai(zzbbl zzbbl);

    void zzaj(boolean z);

    void zzak();

    void zzal(Context context);

    void zzam(boolean z);

    void zzan(zzbgq zzbgq);

    void zzao(boolean z);

    void zzap(zzbgs zzbgs);

    void zzaq(zzfmy zzfmy);

    void zzar(int i);

    void zzas(boolean z);

    void zzat(com.google.android.gms.ads.internal.overlay.zzm zzm);

    void zzau(boolean z);

    void zzav(boolean z);

    void zzaw(String str, zzbky zzbky);

    void zzax(String str, Predicate predicate);

    boolean zzay();

    boolean zzaz();

    Activity zzi();

    com.google.android.gms.ads.internal.zza zzj();

    zzbem zzm();

    VersionInfoParcel zzn();

    zzchm zzq();

    void zzt(String str, zzcey zzcey);
}
