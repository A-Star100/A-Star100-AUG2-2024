package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbhi;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbje;
import com.google.android.gms.internal.ads.zzbma;
import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzbum;
import com.google.android.gms.internal.ads.zzbup;
import com.google.android.gms.internal.ads.zzbvu;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzbyv;
import com.google.android.gms.internal.ads.zzcap;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzaw {
    /* access modifiers changed from: private */
    public final zzk zza;
    /* access modifiers changed from: private */
    public final zzi zzb;
    /* access modifiers changed from: private */
    public final zzeq zzc;
    /* access modifiers changed from: private */
    public final zzbjd zzd;
    private final zzbyv zze;
    /* access modifiers changed from: private */
    public final zzbum zzf;
    /* access modifiers changed from: private */
    public final zzbje zzg;
    /* access modifiers changed from: private */
    public zzbvu zzh;

    public zzaw(zzk zzk, zzi zzi, zzeq zzeq, zzbjd zzbjd, zzbyv zzbyv, zzbum zzbum, zzbje zzbje) {
        this.zza = zzk;
        this.zzb = zzi;
        this.zzc = zzeq;
        this.zzd = zzbjd;
        this.zze = zzbyv;
        this.zzf = zzbum;
        this.zzg = zzbje;
    }

    static /* bridge */ /* synthetic */ void zzt(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zzb().zzo(context, zzay.zzc().afmaVersion, "gmob-apps", bundle, true);
    }

    public final zzbq zzc(Context context, String str, zzbqo zzbqo) {
        return (zzbq) new zzao(this, context, str, zzbqo).zzd(context, false);
    }

    public final zzbu zzd(Context context, zzq zzq, String str, zzbqo zzbqo) {
        return (zzbu) new zzak(this, context, zzq, str, zzbqo).zzd(context, false);
    }

    public final zzbu zze(Context context, zzq zzq, String str, zzbqo zzbqo) {
        return (zzbu) new zzam(this, context, zzq, str, zzbqo).zzd(context, false);
    }

    public final zzdj zzf(Context context, zzbqo zzbqo) {
        return (zzdj) new zzac(this, context, zzbqo).zzd(context, false);
    }

    public final zzbhi zzh(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbhi) new zzas(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbho zzi(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbho) new zzau(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzbma zzl(Context context, zzbqo zzbqo, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbma) new zzai(this, context, zzbqo, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbui zzm(Context context, zzbqo zzbqo) {
        return (zzbui) new zzag(this, context, zzbqo).zzd(context, false);
    }

    public final zzbup zzo(Activity activity) {
        zzaa zzaa = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzm.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbup) zzaa.zzd(activity, z);
    }

    public final zzbyj zzq(Context context, String str, zzbqo zzbqo) {
        return (zzbyj) new zzav(this, context, str, zzbqo).zzd(context, false);
    }

    public final zzcap zzr(Context context, zzbqo zzbqo) {
        return (zzcap) new zzae(this, context, zzbqo).zzd(context, false);
    }
}
