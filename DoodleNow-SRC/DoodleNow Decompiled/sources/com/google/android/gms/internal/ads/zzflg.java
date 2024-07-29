package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzh;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzflg {
    public static void zzb(ListenableFuture listenableFuture, zzflh zzflh, zzfkw zzfkw) {
        zzg(listenableFuture, zzflh, zzfkw, false);
    }

    public static void zzc(ListenableFuture listenableFuture, zzflh zzflh, zzfkw zzfkw) {
        zzg(listenableFuture, zzflh, zzfkw, true);
    }

    public static void zzd(ListenableFuture listenableFuture, zzflh zzflh, zzfkw zzfkw) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            zzgee.zzr(zzgdv.zzu(listenableFuture), new zzflf(zzflh, zzfkw), zzcbr.zzf);
        }
    }

    public static void zze(ListenableFuture listenableFuture, zzfkw zzfkw) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            zzgee.zzr(zzgdv.zzu(listenableFuture), new zzfld(zzfkw), zzcbr.zzf);
        }
    }

    public static boolean zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) zzba.zzc().zza(zzbdz.zziI), str);
    }

    private static void zzg(ListenableFuture listenableFuture, zzflh zzflh, zzfkw zzfkw, boolean z) {
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            zzgee.zzr(zzgdv.zzu(listenableFuture), new zzfle(zzflh, zzfkw, z), zzcbr.zzf);
        }
    }

    public static zzflo zza(zzfgi zzfgi) {
        int zze = zzh.zze(zzfgi) - 1;
        if (zze == 0 || zze == 1) {
            return zzflo.CUI_NAME_ADREQUEST;
        }
        return zzflo.CUI_NAME_SCAR_RENDERING;
    }
}
