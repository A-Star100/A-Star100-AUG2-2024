package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzehy implements zzegj {
    private final Context zza;
    private final zzdim zzb;
    private final Executor zzc;
    private final zzffm zzd;

    public zzehy(Context context, Executor executor, zzdim zzdim, zzffm zzffm) {
        this.zza = context;
        this.zzb = zzdim;
        this.zzc = executor;
        this.zzd = zzffm;
    }

    private static String zzd(zzffn zzffn) {
        try {
            return zzffn.zzw.getString("tab_url");
        } catch (Exception unused) {
            return null;
        }
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        String zzd2 = zzd(zzffn);
        return zzgee.zzn(zzgee.zzh((Object) null), new zzehw(this, zzd2 != null ? Uri.parse(zzd2) : null, zzffz, zzffn), this.zzc);
    }

    public final boolean zzb(zzffz zzffz, zzffn zzffn) {
        Context context = this.zza;
        return (context instanceof Activity) && zzbew.zzg(context) && !TextUtils.isEmpty(zzd(zzffn));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Uri uri, zzffz zzffz, zzffn zzffn, Object obj) throws Exception {
        try {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            build.intent.setData(uri);
            zzc zzc2 = new zzc(build.intent, (zzy) null);
            zzcbw zzcbw = new zzcbw();
            zzdhm zze = this.zzb.zze(new zzcul(zzffz, zzffn, (String) null), new zzdhp(new zzehx(zzcbw), (zzcgm) null));
            zzcbw.zzc(new AdOverlayInfoParcel(zzc2, (zza) null, zze.zza(), (zzaa) null, new VersionInfoParcel(0, 0, false), (zzcgm) null, (zzdgn) null));
            this.zzd.zza();
            return zzgee.zzh(zze.zzg());
        } catch (Throwable th) {
            zzm.zzh("Error in CustomTabsAdRenderer", th);
            throw th;
        }
    }
}
