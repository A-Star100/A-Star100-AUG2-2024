package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzegb implements zzegc {
    static /* synthetic */ zzfmy zzc(String str, String str2, String str3, zzegd zzegd, String str4, WebView webView, String str5, String str6, zzege zzege) {
        zzfni zza = zzfni.zza("Google", str2);
        zzfnh zzm = zzm("javascript");
        zzfnd zzk = zzk(zzegd.toString());
        if (zzm == zzfnh.NONE) {
            zzm.zzj("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzk == null) {
            zzm.zzj("Omid html session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzegd))));
            return null;
        } else {
            zzfnh zzm2 = zzm(str4);
            if (zzk == zzfnd.VIDEO && zzm2 == zzfnh.NONE) {
                zzm.zzj("Omid html session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
                return null;
            }
            return zzfmy.zza(zzfmz.zza(zzk, zzl(zzege.toString()), zzm, zzm2, true), zzfna.zzb(zza, webView, str5, ""));
        }
    }

    static /* synthetic */ zzfmy zzd(String str, String str2, String str3, String str4, zzegd zzegd, WebView webView, String str5, String str6, zzege zzege) {
        zzfni zza = zzfni.zza(str, str2);
        zzfnh zzm = zzm("javascript");
        zzfnh zzm2 = zzm(str4);
        zzfnd zzk = zzk(zzegd.toString());
        if (zzm == zzfnh.NONE) {
            zzm.zzj("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        } else if (zzk == null) {
            zzm.zzj("Omid js session error; Unable to parse creative type: ".concat(String.valueOf(String.valueOf(zzegd))));
            return null;
        } else if (zzk == zzfnd.VIDEO && zzm2 == zzfnh.NONE) {
            zzm.zzj("Omid js session error; Video events owner unknown for video creative: ".concat(String.valueOf(str4)));
            return null;
        } else {
            return zzfmy.zza(zzfmz.zza(zzk, zzl(zzege.toString()), zzm, zzm2, true), zzfna.zzc(zza, webView, str5, ""));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfnd zzk(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L_0x0020
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0043
            if (r4 == r3) goto L_0x0040
            if (r4 == r2) goto L_0x003d
            r4 = 0
            return r4
        L_0x003d:
            com.google.android.gms.internal.ads.zzfnd r4 = com.google.android.gms.internal.ads.zzfnd.VIDEO
            return r4
        L_0x0040:
            com.google.android.gms.internal.ads.zzfnd r4 = com.google.android.gms.internal.ads.zzfnd.NATIVE_DISPLAY
            return r4
        L_0x0043:
            com.google.android.gms.internal.ads.zzfnd r4 = com.google.android.gms.internal.ads.zzfnd.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegb.zzk(java.lang.String):com.google.android.gms.internal.ads.zzfnd");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzfng zzl(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L_0x0020
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r2
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = r3
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L_0x0034
            r4 = 0
            goto L_0x0035
        L_0x0034:
            r4 = -1
        L_0x0035:
            if (r4 == 0) goto L_0x0044
            if (r4 == r3) goto L_0x0041
            if (r4 == r2) goto L_0x003e
            com.google.android.gms.internal.ads.zzfng r4 = com.google.android.gms.internal.ads.zzfng.UNSPECIFIED
            return r4
        L_0x003e:
            com.google.android.gms.internal.ads.zzfng r4 = com.google.android.gms.internal.ads.zzfng.ONE_PIXEL
            return r4
        L_0x0041:
            com.google.android.gms.internal.ads.zzfng r4 = com.google.android.gms.internal.ads.zzfng.DEFINED_BY_JAVASCRIPT
            return r4
        L_0x0044:
            com.google.android.gms.internal.ads.zzfng r4 = com.google.android.gms.internal.ads.zzfng.BEGIN_TO_RENDER
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegb.zzl(java.lang.String):com.google.android.gms.internal.ads.zzfng");
    }

    private static zzfnh zzm(String str) {
        if ("native".equals(str)) {
            return zzfnh.NATIVE;
        }
        if ("javascript".equals(str)) {
            return zzfnh.JAVASCRIPT;
        }
        return zzfnh.NONE;
    }

    private static final Object zzn(zzega zzega) {
        try {
            return zzega.zza();
        } catch (RuntimeException e) {
            zzu.zzo().zzv(e, "omid exception");
            return null;
        }
    }

    private static final void zzo(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            zzu.zzo().zzv(e, "omid exception");
        }
    }

    public final zzfmy zza(String str, WebView webView, String str2, String str3, String str4, zzege zzege, zzegd zzegd, String str5) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzeW)).booleanValue() || !zzfmw.zzb()) {
            return null;
        }
        return (zzfmy) zzn(new zzefx("Google", str, "javascript", zzegd, str4, webView, str5, "", zzege));
    }

    public final zzfmy zzb(String str, WebView webView, String str2, String str3, String str4, String str5, zzege zzege, zzegd zzegd, String str6) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzeW)).booleanValue() || !zzfmw.zzb()) {
            return null;
        }
        return (zzfmy) zzn(new zzefu(str5, str, "javascript", str4, zzegd, webView, str6, "", zzege));
    }

    public final String zze(Context context) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzeW)).booleanValue()) {
            return null;
        }
        return (String) zzn(zzefy.zza);
    }

    public final void zzf(zzfmy zzfmy, View view) {
        zzo(new zzefs(zzfmy, view));
    }

    public final void zzg(zzfmy zzfmy) {
        zzo(new zzefz(zzfmy));
    }

    public final void zzh(zzfmy zzfmy, View view) {
        zzo(new zzeft(zzfmy, view));
    }

    public final void zzi(zzfmy zzfmy) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzeW)).booleanValue() && zzfmw.zzb()) {
            Objects.requireNonNull(zzfmy);
            zzo(new zzefv(zzfmy));
        }
    }

    public final boolean zzj(Context context) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzeW)).booleanValue()) {
            zzm.zzj("Omid flag is disabled");
            return false;
        }
        Boolean bool = (Boolean) zzn(new zzefw(context));
        if (bool == null || !bool.booleanValue()) {
            return false;
        }
        return true;
    }
}
